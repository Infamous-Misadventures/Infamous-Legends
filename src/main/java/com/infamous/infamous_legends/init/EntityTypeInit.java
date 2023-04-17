package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.Sporeback;
import com.infamous.infamous_legends.entities.BlazeRunt;
import com.infamous.infamous_legends.entities.BoulderProjectile;
import com.infamous.infamous_legends.entities.CobblestoneGolem;
import com.infamous.infamous_legends.entities.ExplosiveFungus;
import com.infamous.infamous_legends.entities.FirstOfStone;
import com.infamous.infamous_legends.entities.GrindstoneGolem;
import com.infamous.infamous_legends.entities.LavaLauncher;
import com.infamous.infamous_legends.entities.MaceRunt;
import com.infamous.infamous_legends.entities.MagmaCubeProjectile;
import com.infamous.infamous_legends.entities.MossyGolem;
import com.infamous.infamous_legends.entities.PiglinBomb;
import com.infamous.infamous_legends.entities.PiglinBruiser;
import com.infamous.infamous_legends.entities.PiglinBuilder;
import com.infamous.infamous_legends.entities.Pigmadillo;
import com.infamous.infamous_legends.entities.PlankGolem;
import com.infamous.infamous_legends.entities.PlankGolemBolt;
import com.infamous.infamous_legends.entities.PortalGuard;
import com.infamous.infamous_legends.entities.PortalGuardWreckingBall;
import com.infamous.infamous_legends.entities.SporeMedic;
import com.infamous.infamous_legends.entities.ThrownBlazeRod;
import com.infamous.infamous_legends.entities.WarBoar;
import com.infamous.infamous_legends.entities.Seeker;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityTypeInit {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister
			.create(ForgeRegistries.ENTITY_TYPES, InfamousLegends.MOD_ID);

	// PIGLINS

	public static final RegistryObject<EntityType<MaceRunt>> MACE_RUNT = ENTITY_TYPES.register("mace_runt",
			() -> EntityType.Builder.<MaceRunt>of(MaceRunt::new, MobCategory.MONSTER).sized(0.6F, 1.4F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "mace_runt").toString()));
	
	public static final RegistryObject<EntityType<BlazeRunt>> BLAZE_RUNT = ENTITY_TYPES.register("blaze_runt",
			() -> EntityType.Builder.<BlazeRunt>of(BlazeRunt::new, MobCategory.MONSTER).sized(0.6F, 1.6F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "blaze_runt").toString()));
	
	public static final RegistryObject<EntityType<SporeMedic>> SPORE_MEDIC = ENTITY_TYPES.register("spore_medic",
			() -> EntityType.Builder.<SporeMedic>of(SporeMedic::new, MobCategory.MONSTER).sized(0.6F, 1.4F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "spore_medic").toString()));
	
	public static final RegistryObject<EntityType<PiglinBruiser>> PIGLIN_BRUISER = ENTITY_TYPES.register("piglin_bruiser",
			() -> EntityType.Builder.<PiglinBruiser>of(PiglinBruiser::new, MobCategory.MONSTER).sized(0.7F, 2.1F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "piglin_bruiser").toString()));
	
	public static final RegistryObject<EntityType<WarBoar>> WAR_BOAR = ENTITY_TYPES.register("war_boar",
			() -> EntityType.Builder.<WarBoar>of(WarBoar::new, MobCategory.MONSTER).sized(1.6F, 1.8F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "war_boar").toString()));
	
	public static final RegistryObject<EntityType<PiglinBuilder>> PIGLIN_BUILDER = ENTITY_TYPES.register("piglin_builder",
			() -> EntityType.Builder.<PiglinBuilder>of(PiglinBuilder::new, MobCategory.MONSTER).sized(0.6F, 1.4F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "piglin_builder").toString()));
	
	public static final RegistryObject<EntityType<Seeker>> SEEKER = ENTITY_TYPES.register("seeker",
			() -> EntityType.Builder.<Seeker>of(Seeker::new, MobCategory.MONSTER).sized(0.7F, 2.3F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "seeker").toString()));
	
	public static final RegistryObject<EntityType<Sporeback>> SPOREBACK = ENTITY_TYPES.register("sporeback",
			() -> EntityType.Builder.<Sporeback>of(Sporeback::new, MobCategory.MONSTER).sized(0.8F, 2.4F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "sporeback").toString()));
	
	public static final RegistryObject<EntityType<LavaLauncher>> LAVA_LAUNCHER = ENTITY_TYPES.register("lava_launcher",
			() -> EntityType.Builder.<LavaLauncher>of(LavaLauncher::new, MobCategory.MONSTER).sized(4.5F, 5.0F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "lava_launcher").toString()));
	
	public static final RegistryObject<EntityType<Pigmadillo>> PIGMADILLO = ENTITY_TYPES.register("pigmadillo",
			() -> EntityType.Builder.<Pigmadillo>of(Pigmadillo::new, MobCategory.MONSTER).sized(1.5F, 2.9F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "pigmadillo").toString()));
	
	public static final RegistryObject<EntityType<PortalGuard>> PORTAL_GUARD = ENTITY_TYPES.register("portal_guard",
			() -> EntityType.Builder.<PortalGuard>of(PortalGuard::new, MobCategory.MONSTER).sized(2.0F, 3.5F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "portal_guard").toString()));
	
	// GOLEMS
	
	public static final RegistryObject<EntityType<CobblestoneGolem>> COBBLESTONE_GOLEM = ENTITY_TYPES.register("cobblestone_golem",
			() -> EntityType.Builder.<CobblestoneGolem>of(CobblestoneGolem::new, MobCategory.MISC).sized(0.9F, 1.2F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "cobblestone_golem").toString()));
	
	public static final RegistryObject<EntityType<PlankGolem>> PLANK_GOLEM = ENTITY_TYPES.register("plank_golem",
			() -> EntityType.Builder.<PlankGolem>of(PlankGolem::new, MobCategory.MISC).sized(0.9F, 1.3F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "plank_golem").toString()));
	
	public static final RegistryObject<EntityType<GrindstoneGolem>> GRINDSTONE_GOLEM = ENTITY_TYPES.register("grindstone_golem",
			() -> EntityType.Builder.<GrindstoneGolem>of(GrindstoneGolem::new, MobCategory.MISC).sized(0.9F, 1.3F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "grindstone_golem").toString()));
	
	public static final RegistryObject<EntityType<MossyGolem>> MOSSY_GOLEM = ENTITY_TYPES.register("mossy_golem",
			() -> EntityType.Builder.<MossyGolem>of(MossyGolem::new, MobCategory.MISC).sized(0.9F, 1.3F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "mossy_golem").toString()));
	
	public static final RegistryObject<EntityType<FirstOfStone>> FIRST_OF_STONE = ENTITY_TYPES.register("first_of_stone",
			() -> EntityType.Builder.<FirstOfStone>of(FirstOfStone::new, MobCategory.MISC).sized(2.25F, 4.25F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "first_of_stone").toString()));
	
	// PROJECTILES

	public static final RegistryObject<EntityType<ThrownBlazeRod>> THROWN_BLAZE_ROD = ENTITY_TYPES.register("thrown_blaze_rod",
			() -> EntityType.Builder.<ThrownBlazeRod>of(ThrownBlazeRod::new, MobCategory.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "thrown_blaze_rod").toString()));

	public static final RegistryObject<EntityType<PiglinBomb>> PIGLIN_BOMB = ENTITY_TYPES.register("piglin_bomb",
			() -> EntityType.Builder.<PiglinBomb>of(PiglinBomb::new, MobCategory.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "piglin_bomb").toString()));
	
	public static final RegistryObject<EntityType<ExplosiveFungus>> EXPLOSIVE_FUNGUS = ENTITY_TYPES.register("explosive_fungus",
			() -> EntityType.Builder.<ExplosiveFungus>of(ExplosiveFungus::new, MobCategory.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "explosive_fungus").toString()));
	
	public static final RegistryObject<EntityType<PortalGuardWreckingBall>> PORTAL_GUARD_WRECKING_BALL = ENTITY_TYPES.register("portal_guard_wrecking_ball",
			() -> EntityType.Builder.<PortalGuardWreckingBall>of(PortalGuardWreckingBall::new, MobCategory.MISC).sized(1.25F, 1.25F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "portal_guard_wrecking_ball").toString()));
	
	public static final RegistryObject<EntityType<MagmaCubeProjectile>> MAGMA_CUBE_PROJECTILE = ENTITY_TYPES.register("magma_cube_projectile",
			() -> EntityType.Builder.<MagmaCubeProjectile>of(MagmaCubeProjectile::new, MobCategory.MISC).sized(1.25F, 1.25F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "magma_cube_projectile").toString()));
	
	public static final RegistryObject<EntityType<BoulderProjectile>> BOULDER_PROJECTILE = ENTITY_TYPES.register("boulder_projectile",
			() -> EntityType.Builder.<BoulderProjectile>of(BoulderProjectile::new, MobCategory.MISC).sized(1.5F, 1.5F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "boulder_projectile").toString()));
	
	public static final RegistryObject<EntityType<PlankGolemBolt>> PLANK_GOLEM_BOLT = ENTITY_TYPES.register("plank_golem_bolt",
			() -> EntityType.Builder.<PlankGolemBolt>of(PlankGolemBolt::new, MobCategory.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "plank_golem_bolt").toString()));
}
