package com.infamous.infamous_legends.ai.brains.behaviours;

import java.util.function.Function;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.EntityTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;

public class SetWalkTargetFromHealTargetIfTargetOutOfReach extends Behavior<Mob> {
   private final Function<LivingEntity, Float> speedModifier;
   private double stopDistance;

   public SetWalkTargetFromHealTargetIfTargetOutOfReach(float p_24026_, double stopDistance) {
      this((p_147908_) -> {
         return p_24026_;
      });
      this.stopDistance = stopDistance;
   }

   public SetWalkTargetFromHealTargetIfTargetOutOfReach(Function<LivingEntity, Float> p_147905_) {
      super(ImmutableMap.of(MemoryModuleType.WALK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleTypeInit.HEAL_TARGET.get(), MemoryStatus.VALUE_PRESENT, MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES, MemoryStatus.REGISTERED));
      this.speedModifier = p_147905_;
   }
   
   @Override
	protected boolean checkExtraStartConditions(ServerLevel p_22538_, Mob p_22539_) {
	    LivingEntity livingentity = p_22539_.getBrain().getMemory(MemoryModuleTypeInit.HEAL_TARGET.get()).get();
		return p_22539_.distanceTo(livingentity) > this.stopDistance && super.checkExtraStartConditions(p_22538_, p_22539_);
	}

   protected void start(ServerLevel p_24032_, Mob p_24033_, long p_24034_) {
      LivingEntity livingentity = p_24033_.getBrain().getMemory(MemoryModuleTypeInit.HEAL_TARGET.get()).get();
      if (p_24033_.hasLineOfSight(livingentity) && p_24033_.distanceTo(livingentity) <= this.stopDistance) {
         this.clearWalkTarget(p_24033_);
      } else {
         this.setWalkAndLookTarget(p_24033_, livingentity);
      }

   }

   private void setWalkAndLookTarget(LivingEntity p_24038_, LivingEntity p_24039_) {
      Brain<?> brain = p_24038_.getBrain();
      brain.setMemory(MemoryModuleType.LOOK_TARGET, new EntityTracker(p_24039_, true));
      WalkTarget walktarget = new WalkTarget(new EntityTracker(p_24039_, false), this.speedModifier.apply(p_24038_), 0);
      brain.setMemory(MemoryModuleType.WALK_TARGET, walktarget);
   }

   private void clearWalkTarget(LivingEntity p_24036_) {
      p_24036_.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
   }
}