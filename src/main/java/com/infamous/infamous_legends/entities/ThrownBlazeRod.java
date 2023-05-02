package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class ThrownBlazeRod extends AbstractArrow {
   private boolean dealtDamage;
   private int life;
   
   public ThrownBlazeRod(EntityType<? extends ThrownBlazeRod> p_37561_, Level p_37562_) {
      super(p_37561_, p_37562_);
      this.pickup = AbstractArrow.Pickup.DISALLOWED;
   }

   public ThrownBlazeRod(Level p_37569_, LivingEntity p_37570_) {
      super(EntityTypeInit.THROWN_BLAZE_ROD.get(), p_37570_, p_37569_);
      this.pickup = AbstractArrow.Pickup.DISALLOWED;
   }

   public void tick() {
      if (this.inGroundTime > 4) {
         this.dealtDamage = true;
      } else {
    	  if (this.level.isClientSide && this.random.nextBoolean() && !this.isInWaterRainOrBubble()) {
    		  this.level.addParticle(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
    	  }
      }

      super.tick();
   }
   
   @Override
	protected boolean canHitEntity(Entity p_36743_) {
		boolean piglinThatCantBeHurt = this.getOwner() != null && this.getOwner() instanceof AbstractPiglin && MiscUtils.piglinAllies(this.getOwner(), p_36743_);
		return !piglinThatCantBeHurt && super.canHitEntity(p_36743_);
	}

   protected ItemStack getPickupItem() {
      return null;
   }

   @Nullable
   protected EntityHitResult findHitEntity(Vec3 p_37575_, Vec3 p_37576_) {
      return this.dealtDamage ? null : super.findHitEntity(p_37575_, p_37576_);
   }

   protected void onHitEntity(EntityHitResult p_37573_) {
      Entity entity = p_37573_.getEntity();
      float f = 5F;
      Entity entity1 = this.getOwner();
      DamageSource damagesource = DamageSource.trident(this, (Entity)(entity1 == null ? this : entity1));
      this.dealtDamage = true;
      SoundEvent soundevent = SoundEventInit.BLAZE_RUNT_PROJECTILE_IMPACT.get();
      if (entity.hurt(damagesource, f)) {
    	 entity.setSecondsOnFire(5);
         if (entity.getType() == EntityType.ENDERMAN) {
            return;
         }
      }

      this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
      float f1 = 1.0F;

      this.playSound(soundevent, 1F, MiscUtils.randomSoundPitch());
   }

   protected boolean tryPickup(Player p_150196_) {
      return false;
   }

	@Override
	protected SoundEvent getDefaultHitGroundSoundEvent() {
		return SoundEventInit.BLAZE_RUNT_PROJECTILE_IMPACT.get();
	}

	@Override
	public void setSoundEvent(SoundEvent pSoundEvent) {

	}

   public void playerTouch(Player p_37580_) {
      if (this.ownedBy(p_37580_) || this.getOwner() == null) {
         super.playerTouch(p_37580_);
      }

   }

   public void readAdditionalSaveData(CompoundTag p_37578_) {
      super.readAdditionalSaveData(p_37578_);
      this.dealtDamage = p_37578_.getBoolean("DealtDamage");
   }

   public void addAdditionalSaveData(CompoundTag p_37582_) {
      super.addAdditionalSaveData(p_37582_);
      p_37582_.putBoolean("DealtDamage", this.dealtDamage);
   }

   public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
      return true;
   }
   
   @Override
	protected void tickDespawn() {
		++this.life;
		if (this.life >= 100) {
			this.discard();
		}
	}
   
   @Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}