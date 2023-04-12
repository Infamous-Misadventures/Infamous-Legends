package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

public class LookAtTargetGoal extends Goal {
   protected final Mob mob;

   public LookAtTargetGoal(Mob mob) {
	  this.setFlags(EnumSet.of(Goal.Flag.LOOK));
      this.mob = mob;
   }

   public boolean canUse() {
         return mob.getTarget() != null && mob.getTarget().isAlive();
   }

   public boolean canContinueToUse() {
       return mob.getTarget() != null && mob.getTarget().isAlive();
   }

   public void tick() {
      if (mob.getTarget() != null && mob.getTarget().isAlive()) {
         this.mob.getLookControl().setLookAt(mob.getTarget().getX(), mob.getTarget().getEyeY(), mob.getTarget().getZ());
      }
   }
}