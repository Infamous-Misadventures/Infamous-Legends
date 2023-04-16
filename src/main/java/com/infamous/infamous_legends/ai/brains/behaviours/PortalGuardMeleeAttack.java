package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.PortalGuard;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

public class PortalGuardMeleeAttack extends Behavior<PortalGuard> {
   private final int cooldownBetweenAttacks;

   public PortalGuardMeleeAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryStatus.VALUE_ABSENT), 600, 600);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, PortalGuard mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 4.0 && mob.shootAnimationTick <= 0 && mob.reelInBallAnimationTick <= 0 && !mob.playingIdleShootingAnimation;
   }

   protected void start(ServerLevel p_23524_, PortalGuard p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      p_23525_.lookAt(Anchor.EYES, livingentity.position());
      p_23525_.getNavigation().stop();
		
      p_23525_.attackAnimationTick = p_23525_.attackAnimationLength;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 4);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, PortalGuard p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		
		if (livingentity != null) {
			p_22552_.lookAt(Anchor.EYES, livingentity.position());
		}
		
		p_22552_.getNavigation().stop();
		
		if (p_22552_.attackAnimationTick == p_22552_.attackAnimationLength - (20 * 0.85)) {
			p_22552_.playSound(SoundEvents.IRON_GOLEM_ATTACK);
		}
		
		if (livingentity != null && p_22552_.attackAnimationTick == p_22552_.attackAnimationActionPoint && p_22552_.distanceTo(livingentity) <= 5.0 && p_22552_.hasLineOfSight(livingentity)) {					
			p_22552_.doHurtTarget(livingentity);
			for (LivingEntity entity : p_22551_.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), p_22552_, livingentity.getBoundingBox().inflate(3, 0, 3))) {
				if (!MiscUtils.piglinAllies(p_22552_, entity) && entity != livingentity) {
					p_22552_.doHurtTarget(entity);
				}
			}
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, PortalGuard p_22546_, long p_22547_) {
		return p_22546_.attackAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, PortalGuard p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleType.ATTACK_COOLING_DOWN, true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(PortalGuard p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}