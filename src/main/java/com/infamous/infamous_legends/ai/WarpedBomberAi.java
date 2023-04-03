package com.infamous.infamous_legends.ai;

import java.util.Optional;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.infamous.infamous_legends.ai.behaviours.WarpedBomberMeleeAttack;
import com.infamous.infamous_legends.entities.WarpedBomber;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.mojang.datafixers.util.Pair;

import net.minecraft.core.GlobalPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.behavior.DoNothing;
import net.minecraft.world.entity.ai.behavior.InteractWith;
import net.minecraft.world.entity.ai.behavior.InteractWithDoor;
import net.minecraft.world.entity.ai.behavior.LookAtTargetSink;
import net.minecraft.world.entity.ai.behavior.MeleeAttack;
import net.minecraft.world.entity.ai.behavior.MoveToTargetSink;
import net.minecraft.world.entity.ai.behavior.RandomStroll;
import net.minecraft.world.entity.ai.behavior.RunOne;
import net.minecraft.world.entity.ai.behavior.SetEntityLookTarget;
import net.minecraft.world.entity.ai.behavior.SetLookAndInteract;
import net.minecraft.world.entity.ai.behavior.SetWalkTargetFromAttackTargetIfTargetOutOfReach;
import net.minecraft.world.entity.ai.behavior.StartAttacking;
import net.minecraft.world.entity.ai.behavior.StopAttackingIfTargetInvalid;
import net.minecraft.world.entity.ai.behavior.StopBeingAngryIfTargetDead;
import net.minecraft.world.entity.ai.behavior.StrollAroundPoi;
import net.minecraft.world.entity.ai.behavior.StrollToPoi;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.schedule.Activity;

public class WarpedBomberAi {

	  public static Brain<?> makeBrain(WarpedBomber p_35100_, Brain<WarpedBomber> p_35101_) {
	      initCoreActivity(p_35100_, p_35101_);
	      initIdleActivity(p_35100_, p_35101_);
	      initFightActivity(p_35100_, p_35101_);
	      p_35101_.setCoreActivities(ImmutableSet.of(Activity.CORE));
	      p_35101_.setDefaultActivity(Activity.IDLE);
	      p_35101_.useDefaultActivity();
	      return p_35101_;
	   }

	   public static void initMemories(WarpedBomber p_35095_) {
	      GlobalPos globalpos = GlobalPos.of(p_35095_.level.dimension(), p_35095_.blockPosition());
	      p_35095_.getBrain().setMemory(MemoryModuleType.HOME, globalpos);
	   }

	   private static void initCoreActivity(WarpedBomber p_35112_, Brain<WarpedBomber> p_35113_) {
	      p_35113_.addActivity(Activity.CORE, 0, ImmutableList.of(new LookAtTargetSink(45, 90), new MoveToTargetSink(), new InteractWithDoor(), new StopBeingAngryIfTargetDead<>()));
	   }

	   private static void initIdleActivity(WarpedBomber p_35120_, Brain<WarpedBomber> p_35121_) {
	      p_35121_.addActivity(Activity.IDLE, 10, ImmutableList.of(new StartAttacking<>(WarpedBomberAi::findNearestValidAttackTarget), createIdleLookBehaviors(), createIdleMovementBehaviors(), new SetLookAndInteract(EntityType.PLAYER, 4)));
	   }

	   private static void initFightActivity(WarpedBomber p_35125_, Brain<WarpedBomber> p_35126_) {
	      p_35126_.addActivityAndRemoveMemoryWhenStopped(Activity.FIGHT, 10, ImmutableList.of(new StopAttackingIfTargetInvalid<>((p_35118_) -> {
	         return !isNearestValidAttackTarget(p_35125_, p_35118_);
	      }), new SetWalkTargetFromAttackTargetIfTargetOutOfReach(1.0F), new WarpedBomberMeleeAttack(20)), MemoryModuleType.ATTACK_TARGET);
	   }

	   private static RunOne<WarpedBomber> createIdleLookBehaviors() {
	      return new RunOne<>(ImmutableList.of(Pair.of(new SetEntityLookTarget(EntityType.PLAYER, 8.0F), 1), Pair.of(new SetEntityLookTarget(EntityType.PIGLIN, 8.0F), 1), Pair.of(new SetEntityLookTarget(EntityTypeInit.WARPED_BOMBER.get(), 8.0F), 1), Pair.of(new SetEntityLookTarget(8.0F), 1), Pair.of(new DoNothing(30, 60), 1)));
	   }

	   private static RunOne<WarpedBomber> createIdleMovementBehaviors() {
	      return new RunOne<>(ImmutableList.of(Pair.of(new RandomStroll(0.3F), 2), Pair.of(InteractWith.of(EntityType.PIGLIN, 8, MemoryModuleType.INTERACTION_TARGET, 0.6F, 2), 2), Pair.of(InteractWith.of(EntityTypeInit.WARPED_BOMBER.get(), 8, MemoryModuleType.INTERACTION_TARGET, 0.6F, 2), 2), Pair.of(new StrollToPoi(MemoryModuleType.HOME, 0.6F, 2, 100), 2), Pair.of(new StrollAroundPoi(MemoryModuleType.HOME, 0.6F, 5), 2), Pair.of(new DoNothing(30, 60), 1)));
	   }

	   public static void updateActivity(WarpedBomber p_35110_) {
	      Brain<WarpedBomber> brain = p_35110_.getBrain();
	      Activity activity = brain.getActiveNonCoreActivity().orElse((Activity)null);
	      brain.setActiveActivityToFirstValid(ImmutableList.of(Activity.FIGHT, Activity.IDLE));
	      Activity activity1 = brain.getActiveNonCoreActivity().orElse((Activity)null);
	      if (activity != activity1) {
	         playActivitySound(p_35110_);
	      }

	      p_35110_.setAggressive(brain.hasMemoryValue(MemoryModuleType.ATTACK_TARGET));
	   }

	   private static boolean isNearestValidAttackTarget(AbstractPiglin p_35089_, LivingEntity p_35090_) {
	      return findNearestValidAttackTarget(p_35089_).filter((p_35085_) -> {
	         return p_35085_ == p_35090_;
	      }).isPresent();
	   }

	   private static Optional<? extends LivingEntity> findNearestValidAttackTarget(AbstractPiglin p_35087_) {
	      Optional<LivingEntity> optional = BehaviorUtils.getLivingEntityFromUUIDMemory(p_35087_, MemoryModuleType.ANGRY_AT);
	      if (optional.isPresent() && Sensor.isEntityAttackableIgnoringLineOfSight(p_35087_, optional.get())) {
	         return optional;
	      } else {
	         Optional<? extends LivingEntity> optional1 = getTargetIfWithinRange(p_35087_, MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER);
	         return optional1.isPresent() ? optional1 : p_35087_.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_NEMESIS);
	      }
	   }

	   private static Optional<? extends LivingEntity> getTargetIfWithinRange(AbstractPiglin p_35092_, MemoryModuleType<? extends LivingEntity> p_35093_) {
	      return p_35092_.getBrain().getMemory(p_35093_).filter((p_35108_) -> {
	         return p_35108_.closerThan(p_35092_, 20.0D);
	      });
	   }

	   public static void wasHurtBy(WarpedBomber p_35097_, LivingEntity p_35098_) {
	      if (!(p_35098_ instanceof AbstractPiglin)) {
	         PiglinAi.maybeRetaliate(p_35097_, p_35098_);
	      }
	   }

	   protected static void setAngerTarget(WarpedBomber p_149989_, LivingEntity p_149990_) {
	      p_149989_.getBrain().eraseMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
	      p_149989_.getBrain().setMemoryWithExpiry(MemoryModuleType.ANGRY_AT, p_149990_.getUUID(), 600L);
	   }

	   public static void maybePlayActivitySound(WarpedBomber p_35115_) {
	      if ((double)p_35115_.level.random.nextFloat() < 0.0125D) {
	         playActivitySound(p_35115_);
	      }

	   }

	   private static void playActivitySound(WarpedBomber p_35123_) {
	      p_35123_.getBrain().getActiveNonCoreActivity().ifPresent((p_35104_) -> {
	         if (p_35104_ == Activity.FIGHT) {
	            p_35123_.playAngrySound();
	         }

	      });
	   }
}