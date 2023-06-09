package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.events.ShakeCameraEvent;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.items.PortalGuardFlailItem;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class PlayerPortalGuardWreckingBall extends AbstractArrow {
	   
	   private static final EntityDataAccessor<Integer> CLIENT_OWNERR_ID = SynchedEntityData.defineId(PlayerPortalGuardWreckingBall.class, EntityDataSerializers.INT);
	   
	   public boolean hasLanded;
	   
	   public boolean retracting;
	   
	   public float landingXRot;
	   public float landingYRot;
	   
	   private int life;
	   
	   public PlayerPortalGuardWreckingBall(EntityType<? extends PlayerPortalGuardWreckingBall> p_37561_, Level p_37562_) {
	      super(p_37561_, p_37562_);
	      this.pickup = AbstractArrow.Pickup.DISALLOWED;
	      
	   }

	   public PlayerPortalGuardWreckingBall(Level p_37569_, LivingEntity p_37570_) {
	      super(EntityTypeInit.PLAYER_PORTAL_GUARD_WRECKING_BALL.get(), p_37570_, p_37569_);
	      this.pickup = AbstractArrow.Pickup.DISALLOWED;
	   }
	   
		   @Override
		protected void defineSynchedData() {
			super.defineSynchedData();
			this.entityData.define(CLIENT_OWNERR_ID, 0);
		}
		   
	   public void setClientOwner(Entity newOwner) {
		   if (newOwner != null) {
			   this.entityData.set(CLIENT_OWNERR_ID, newOwner.getId());
		   }
	   }
	   
	   public LivingEntity getClientOwner() {
		   return this.level.getEntity(this.entityData.get(CLIENT_OWNERR_ID)) instanceof LivingEntity ? ((LivingEntity)this.level.getEntity(this.entityData.get(CLIENT_OWNERR_ID))) : null;
	   }

	   public void tick() {
	      super.tick();
	      
	      ++this.life;
			if (this.life >= 300) {
				this.discard();
			}
			
	      if (this.getOwner() != null && this.hasLanded && (this.inGroundTime > 20 || this.retracting)) {
	    	  this.inGround = false;
	    	  this.retracting = true;
	    	  
	    	  double speed = 0.075;
	    	  
	    	  this.setPos(this.getX(), this.getY() + 0.1, this.getZ());
	    	  
	    	  Vec3 vec3 = PositionUtils.getOffsetPos(this.getOwner(), 1.0, 0.0, 0, this.getOwner().getYRot());
	    	  
				double x = vec3.x - this.getX();
				double y = vec3.y - this.getY();
				double z = vec3.z - this.getZ();
				double d = Math.sqrt(x * x + y * y + z * z);
				this.setDeltaMovement(this.getDeltaMovement()
						.add(x / d * speed, y / d * speed, z / d * speed));
				
				this.level.addParticle(ParticleTypeInit.DUST.get(), this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
				
				if (!this.level.isClientSide && this.distanceTo(this.getOwner()) <= 1.5) {
					this.discard();
					if (this.getOwner() instanceof Player) {		
						for (ItemStack stack : ((Player)this.getOwner()).getInventory().items) {
							if (stack.getItem() instanceof PortalGuardFlailItem && PortalGuardFlailItem.isShooting(stack)) {
								((Player)this.getOwner()).getCooldowns().addCooldown(stack.getItem(), 100);
								PortalGuardFlailItem.setShooting(stack, false);
								break;
							}
						}
					}
				}
	      }
	      
	      if (this.hasLanded) {
	    	  this.setXRot(this.landingXRot);
	    	  this.setYRot(this.landingYRot);
	      }
	      
	      this.setClientOwner(this.getOwner());
	   }

	   protected ItemStack getPickupItem() {
	      return ItemStack.EMPTY;
	   }

	   @Nullable
	   protected EntityHitResult findHitEntity(Vec3 p_37575_, Vec3 p_37576_) {
	      return super.findHitEntity(p_37575_, p_37576_);
	   }
	   
	   @Override
	protected float getWaterInertia() {
		return 1.0F;
	}
	   
	   @Override
	protected void onHitBlock(BlockHitResult p_36755_) {
			if (!this.hasLanded) {
				this.playSound(SoundEventInit.PORTAL_GUARD_PROJECTILE_IMPACT.get(), 2, 1.0F);
				this.landingXRot = this.getXRot();
				this.landingYRot = this.getYRot();
				if (!this.level.isClientSide) {
					ShakeCameraEvent.shake(this.level, 40, 0.075F, this.blockPosition(), 10);
					((ServerLevel)this.level).sendParticles(ParticleTypeInit.DUST.get(), this.getX(), this.getY(), this.getZ(), 12, 0.2D, 0.2D, 0.2D, 0.0D);
					for (Entity entity : this.level.getEntities(this, this.getBoundingBox().inflate(1))) {
						if (entity instanceof LivingEntity) {
							boolean flag = entity.hurt(DamageSource.explosion(this.getOwner() instanceof LivingEntity ? ((LivingEntity)this.getOwner()) : null), 16);
							MiscUtils.disableShield(((LivingEntity)entity), 80);
							if (this.distanceTo(entity) > 0.2) {
								double d0 = entity.getX() - this.getX();
								double d1 = entity.getZ() - this.getZ();
								double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
								entity.push(d0 / d2 * 1.0D, 0.3D, d1 / d2 * 1.0D);
							}
						}
					}
				}
			}
			this.hasLanded = true;
		super.onHitBlock(p_36755_);
	}

	   protected void onHitEntity(EntityHitResult p_37573_) {
		  if (!this.hasLanded && !this.level.isClientSide) {
		      Entity entity = p_37573_.getEntity();
		      float f = 18F;
		      Entity entity1 = this.getOwner();
		      DamageSource damagesource = DamageSource.thrown(this, (Entity)(entity1 == null ? this : entity1));
		      boolean flag = entity.hurt(damagesource, f);
		      
		      if (entity instanceof LivingEntity) {
		    	  MiscUtils.disableShield(((LivingEntity)entity), 120);
		      }
		  }
	   }
	   
	   @Override
	public void setSoundEvent(SoundEvent p_36741_) {

	}

	   protected boolean tryPickup(Player p_150196_) {
	      return false;
	   }

	   protected SoundEvent getDefaultHitGroundSoundEvent() {
	      return null;
	   }

	   public void playerTouch(Player p_37580_) {
	      if (this.ownedBy(p_37580_) || this.getOwner() == null) {
	         super.playerTouch(p_37580_);
	      }

	   }

	   public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
	      return true;
	   }
	   
	   @Override
		public Packet<?> getAddEntityPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}
	}
