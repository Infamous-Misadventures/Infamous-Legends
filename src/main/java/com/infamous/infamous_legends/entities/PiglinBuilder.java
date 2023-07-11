package com.infamous.infamous_legends.entities;

import com.google.common.collect.ImmutableList;
import com.infamous.infamous_legends.ai.brains.PiglinBuilderAi;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.SensorTypeInit;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.interfaces.IHasCustomExplosion;
import com.infamous.infamous_legends.utils.HandleLoopingSoundInstances;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.PiglinArmPose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class PiglinBuilder extends AbstractPiglin implements IHasCustomExplosion {

	public AnimationState shootAnimationState = new AnimationState();
	public int shootAnimationTick;
	public final int shootAnimationLength = 60;
	public final int shootAnimationActionPoint = 20;

	private ResourceLocation buildingStructureName;
	private int buildingStep;

	protected static final ImmutableList<SensorType<? extends Sensor<? super PiglinBuilder>>> SENSOR_TYPES = ImmutableList
			.of(SensorTypeInit.CUSTOM_NEAREST_LIVING_ENTITIES.get(), SensorTypeInit.CUSTOM_NEAREST_PLAYERS.get(), SensorType.NEAREST_ITEMS,
					SensorType.HURT_BY, SensorTypeInit.LEGENDS_PIGLIN_SPECIFIC_SENSOR.get());
	protected static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(
			MemoryModuleType.LOOK_TARGET, MemoryModuleType.DOORS_TO_CLOSE, MemoryModuleType.NEAREST_LIVING_ENTITIES,
			MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_PLAYER,
			MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS,
			MemoryModuleType.NEARBY_ADULT_PIGLINS, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY,
			MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.ATTACK_TARGET,
			MemoryModuleType.ATTACK_COOLING_DOWN, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.PATH,
			MemoryModuleType.ANGRY_AT, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.HOME,
			MemoryModuleTypeInit.NEARBY_ALLIES.get(), MemoryModuleTypeInit.WORK_POS.get());

	public PiglinBuilder(EntityType<? extends PiglinBuilder> type, Level level) {
		super(type, level);
		this.xpReward = 10;
	}

	public int getBuildingStep() {
		return buildingStep;
	}

	public void setBuildingStep(int buildingStep) {
		this.buildingStep = buildingStep;
	}

	public ResourceLocation getBuildingStructureName() {
		return buildingStructureName;
	}

	public void setBuildingStructureName(ResourceLocation buildingStructureName) {
		this.buildingStructureName = buildingStructureName;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag p_37870_) {
		super.addAdditionalSaveData(p_37870_);
		if (this.buildingStructureName != null) {
			p_37870_.putString("BuildingName", this.buildingStructureName.toString());
		}
		p_37870_.putInt("BuildingStep", this.buildingStep);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag p_37862_) {
		super.readAdditionalSaveData(p_37862_);
		if (p_37862_.contains("BuildingName")) {
			this.setBuildingStructureName(ResourceLocation.tryParse(p_37862_.getString("BuildingName")));
		}
		if (p_37862_.contains("BuildingStep")) {
			this.setBuildingStep(p_37862_.getInt("BuildingStep"));
		}
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level.isClientSide && this.random.nextBoolean() && !this.isInWaterRainOrBubble()) {
			Vec3 particlePos = PositionUtils.getOffsetPos(this, -14 / 16.0F, 33 / 16.0F, -12 / 16.0F, this.yBodyRot);
			this.level.addParticle(ParticleTypes.LARGE_SMOKE, particlePos.x, particlePos.y, particlePos.z, 0, 0.05, 0.0);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.2F).add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
	}
	
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_35058_, DifficultyInstance p_35059_,
			MobSpawnType p_35060_, @Nullable SpawnGroupData p_35061_, @Nullable CompoundTag p_35062_) {
		PiglinBuilderAi.initMemories(this);
		this.populateDefaultEquipmentSlots(this.random, p_35059_);
		return super.finalizeSpawn(p_35058_, p_35059_, p_35060_, p_35061_, p_35062_);
	}
	
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource p_219209_, DifficultyInstance p_219210_) {
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemInit.PIGLIN_BOMB.get()));
		this.setDropChance(EquipmentSlot.MAINHAND, 0.0F);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		if (this.shootAnimationTick > 0) {
			this.shootAnimationTick--;
		}
		
		if (this.level.isClientSide && this.shootAnimationTick <= 0) {
			this.shootAnimationState.stop();
		}
	}
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.shootAnimationTick = this.shootAnimationLength;
			this.shootAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}

	protected Brain.Provider<PiglinBuilder> brainProvider() {
		return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
	}

	protected Brain<?> makeBrain(Dynamic<?> p_35064_) {
		return PiglinBuilderAi.makeBrain(this, this.brainProvider().makeBrain(p_35064_));
	}

	public Brain<PiglinBuilder> getBrain() {
		return (Brain<PiglinBuilder>) super.getBrain();
	}
		   
	@Override
	protected boolean canHunt() {
		return false;
	}

	public boolean wantsToPickUp(ItemStack p_35078_) {
		return p_35078_.is(ItemInit.PIGLIN_BOMB.get()) ? super.wantsToPickUp(p_35078_) : false;
	}

	protected void customServerAiStep() {
		this.level.getProfiler().push("piglinBuilderBrain");
		this.getBrain().tick((ServerLevel) this.level, this);
		this.level.getProfiler().pop();
		PiglinBuilderAi.updateActivity(this);
		PiglinBuilderAi.maybePlayActivitySound(this);
		super.customServerAiStep();
	}
	
	@Override
	public boolean isLeftHanded() {
		return false;
	}
		   
	@Override
	public PiglinArmPose getArmPose() {
		return this.isAggressive() && this.isHoldingMeleeWeapon() ? PiglinArmPose.ATTACKING_WITH_MELEE_WEAPON
				: PiglinArmPose.DEFAULT;
	}
	
	public boolean hurt(DamageSource p_35055_, float p_35056_) {
		boolean flag = super.hurt(p_35055_, p_35056_);
		if (this.level.isClientSide) {
			return false;
		} else {
			if (flag && p_35055_.getEntity() instanceof LivingEntity) {
				PiglinBuilderAi.wasHurtBy(this, (LivingEntity) p_35055_.getEntity());
			}

			return flag;
		}
	}

	@Override
	protected boolean isImmuneToZombification() {
		return true;
	}
	
	@Override
	public void onAddedToWorld() {
	  super.onAddedToWorld();
	  if (this.level.isClientSide) {
		  HandleLoopingSoundInstances.addPiglinBuilderAudio(this, this.level);
	  }
	}

	protected SoundEvent getAmbientSound() {
		return SoundEventInit.BLAZE_RUNT_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource p_35072_) {
		return SoundEventInit.BLAZE_RUNT_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return SoundEventInit.BLAZE_RUNT_DEATH.get();
	}

	protected void playStepSound(BlockPos p_35066_, BlockState p_35067_) {
		this.playSound(SoundEventInit.PIGLIN_BUILDER_STEP.get(), 0.5F, this.getVoicePitch());
	}

	public void playAngrySound() {
		this.playSound(SoundEventInit.BLAZE_RUNT_IDLE.get(), 1.0F, this.getVoicePitch());
	}

	protected void playConvertedSound() {
		this.playSound(SoundEvents.PIGLIN_BRUTE_CONVERTED_TO_ZOMBIFIED, 1.0F, this.getVoicePitch());
	}

	@Override
	public boolean canHarmWithExplosion(Entity target) {
		return MiscUtils.piglinAllies(this, target) ? false : true;
	}
	   
}
