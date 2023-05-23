package com.infamous.infamous_legends.utils;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.init.BlockEntityTypeInit;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.items.PortalGuardFlailItem;
import com.infamous.infamous_legends.models.BigBeakModel;
import com.infamous.infamous_legends.models.BlazeRuntModel;
import com.infamous.infamous_legends.models.CobblestoneGolemModel;
import com.infamous.infamous_legends.models.ExplosiveFungusModel;
import com.infamous.infamous_legends.models.FirstOfOakBoltModel;
import com.infamous.infamous_legends.models.FirstOfOakModel;
import com.infamous.infamous_legends.models.FirstOfStoneModel;
import com.infamous.infamous_legends.models.GrindstoneGolemModel;
import com.infamous.infamous_legends.models.LavaLauncherModel;
import com.infamous.infamous_legends.models.MaceRuntModel;
import com.infamous.infamous_legends.models.MagmaCubeProjectileModel;
import com.infamous.infamous_legends.models.MossyGolemModel;
import com.infamous.infamous_legends.models.PiglinBombModel;
import com.infamous.infamous_legends.models.PiglinBruiserModel;
import com.infamous.infamous_legends.models.PiglinBuilderModel;
import com.infamous.infamous_legends.models.PigmadilloModel;
import com.infamous.infamous_legends.models.PlankGolemBoltModel;
import com.infamous.infamous_legends.models.PlankGolemModel;
import com.infamous.infamous_legends.models.PlayerPortalGuardWreckingBallModel;
import com.infamous.infamous_legends.models.PortalGuardModel;
import com.infamous.infamous_legends.models.PortalGuardWreckingBallModel;
import com.infamous.infamous_legends.models.RegalTigerModel;
import com.infamous.infamous_legends.models.SeekerModel;
import com.infamous.infamous_legends.models.SporeMedicModel;
import com.infamous.infamous_legends.models.SporebackModel;
import com.infamous.infamous_legends.models.ThrownBlazeRodModel;
import com.infamous.infamous_legends.models.WarBoarModel;
import com.infamous.infamous_legends.models.armor.PigmadilloShellModel;
import com.infamous.infamous_legends.models.armor.PigmadilloShellRollingModel;
import com.infamous.infamous_legends.models.armor.SporeMedicMaskModel;
import com.infamous.infamous_legends.renderers.BigBeakRenderer;
import com.infamous.infamous_legends.renderers.BlazeRuntRenderer;
import com.infamous.infamous_legends.renderers.BoulderProjectileRenderer;
import com.infamous.infamous_legends.renderers.CobblestoneGolemRenderer;
import com.infamous.infamous_legends.renderers.ExplosiveFungusRenderer;
import com.infamous.infamous_legends.renderers.FirstOfOakBoltRenderer;
import com.infamous.infamous_legends.renderers.FirstOfOakRenderer;
import com.infamous.infamous_legends.renderers.FirstOfStoneRenderer;
import com.infamous.infamous_legends.renderers.GrindstoneGolemRenderer;
import com.infamous.infamous_legends.renderers.LavaLauncherRenderer;
import com.infamous.infamous_legends.renderers.MaceRuntRenderer;
import com.infamous.infamous_legends.renderers.MagmaCubeProjectileRenderer;
import com.infamous.infamous_legends.renderers.MossyGolemRenderer;
import com.infamous.infamous_legends.renderers.PiglinBombRenderer;
import com.infamous.infamous_legends.renderers.PiglinBruiserRenderer;
import com.infamous.infamous_legends.renderers.PiglinBuilderRenderer;
import com.infamous.infamous_legends.renderers.PigmadilloRenderer;
import com.infamous.infamous_legends.renderers.PlankGolemBoltRenderer;
import com.infamous.infamous_legends.renderers.PlankGolemRenderer;
import com.infamous.infamous_legends.renderers.PlayerPortalGuardWreckingBallRenderer;
import com.infamous.infamous_legends.renderers.PortalGuardRenderer;
import com.infamous.infamous_legends.renderers.PortalGuardWreckingBallRenderer;
import com.infamous.infamous_legends.renderers.RegalTigerRenderer;
import com.infamous.infamous_legends.renderers.SeekerRenderer;
import com.infamous.infamous_legends.renderers.SporeMedicRenderer;
import com.infamous.infamous_legends.renderers.SporebackRenderer;
import com.infamous.infamous_legends.renderers.ThrownBlazeRodRenderer;
import com.infamous.infamous_legends.renderers.WarBoarRenderer;
import com.infamous.infamous_legends.renderers.blocks.LegendsSpawnerRenderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModelLayerInit.MACE_RUNT, MaceRuntModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.MACE_RUNT_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.MACE_RUNT_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.BLAZE_RUNT, BlazeRuntModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.BLAZE_RUNT_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.BLAZE_RUNT_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.SPORE_MEDIC, SporeMedicModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.SPORE_MEDIC_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.SPORE_MEDIC_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_BRUISER, PiglinBruiserModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_BRUISER_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_BRUISER_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.WAR_BOAR, WarBoarModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_BUILDER, PiglinBuilderModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_BUILDER_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_BUILDER_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.SEEKER, SeekerModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.SEEKER_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.SEEKER_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.SPOREBACK, SporebackModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.SPOREBACK_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.SPOREBACK_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.LAVA_LAUNCHER, LavaLauncherModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.LAVA_LAUNCHER_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.LAVA_LAUNCHER_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGMADILLO, PigmadilloModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGMADILLO_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGMADILLO_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PORTAL_GUARD, PortalGuardModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PORTAL_GUARD_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PORTAL_GUARD_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.COBBLESTONE_GOLEM, CobblestoneGolemModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.COBBLESTONE_GOLEM_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.COBBLESTONE_GOLEM_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PLANK_GOLEM, PlankGolemModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PLANK_GOLEM_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PLANK_GOLEM_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.GRINDSTONE_GOLEM, GrindstoneGolemModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.GRINDSTONE_GOLEM_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.GRINDSTONE_GOLEM_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.MOSSY_GOLEM, MossyGolemModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.MOSSY_GOLEM_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.MOSSY_GOLEM_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.FIRST_OF_STONE, FirstOfStoneModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.FIRST_OF_STONE_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.FIRST_OF_STONE_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.FIRST_OF_OAK, FirstOfOakModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.FIRST_OF_OAK_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.FIRST_OF_OAK_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.BIG_BEAK, BigBeakModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.BIG_BEAK_SADDLE, BigBeakModel::createSaddleLayer);
        event.registerLayerDefinition(ModelLayerInit.BIG_BEAK_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.BIG_BEAK_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.REGAL_TIGER, RegalTigerModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.REGAL_TIGER_SADDLE, RegalTigerModel::createSaddleLayer);
        event.registerLayerDefinition(ModelLayerInit.REGAL_TIGER_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.REGAL_TIGER_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.THROWN_BLAZE_ROD, ThrownBlazeRodModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_BOMB, PiglinBombModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.EXPLOSIVE_FUNGUS, ExplosiveFungusModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PORTAL_GUARD_WRECKING_BALL, PortalGuardWreckingBallModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PLAYER_PORTAL_GUARD_WRECKING_BALL, PlayerPortalGuardWreckingBallModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.MAGMA_CUBE_PROJECTILE, MagmaCubeProjectileModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PLANK_GOLEM_BOLT, PlankGolemBoltModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.FIRST_OF_OAK_BOLT, FirstOfOakBoltModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.SPORE_MEDIC_MASK, SporeMedicMaskModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGMADILLO_SHELL, PigmadilloShellModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGMADILLO_SHELL_ROLLING, PigmadilloShellRollingModel::createBodyLayer);
    }
	
	public static LayerDefinition createInnerArmourLayer() {
		return LayerDefinition.create(HumanoidModel.createMesh(LayerDefinitions.INNER_ARMOR_DEFORMATION, 0.0F), 64, 32);
	}
	
	public static LayerDefinition createOuterArmourLayer() {
		return LayerDefinition.create(HumanoidModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32);
	}
	
	@SubscribeEvent
	public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityTypeInit.MACE_RUNT.get(), MaceRuntRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.BLAZE_RUNT.get(), BlazeRuntRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.SPORE_MEDIC.get(), SporeMedicRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PIGLIN_BRUISER.get(), PiglinBruiserRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.WAR_BOAR.get(), WarBoarRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PIGLIN_BUILDER.get(), PiglinBuilderRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.SEEKER.get(), SeekerRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.SPOREBACK.get(), SporebackRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.LAVA_LAUNCHER.get(), LavaLauncherRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PIGMADILLO.get(), PigmadilloRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PORTAL_GUARD.get(), PortalGuardRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.COBBLESTONE_GOLEM.get(), CobblestoneGolemRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PLANK_GOLEM.get(), PlankGolemRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.GRINDSTONE_GOLEM.get(), GrindstoneGolemRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.MOSSY_GOLEM.get(), MossyGolemRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.FIRST_OF_STONE.get(), FirstOfStoneRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.FIRST_OF_OAK.get(), FirstOfOakRenderer::new);	
		event.registerEntityRenderer(EntityTypeInit.BIG_BEAK.get(), BigBeakRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.REGAL_TIGER.get(), RegalTigerRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.THROWN_BLAZE_ROD.get(), ThrownBlazeRodRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PIGLIN_BOMB.get(), PiglinBombRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.EXPLOSIVE_FUNGUS.get(), ExplosiveFungusRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PORTAL_GUARD_WRECKING_BALL.get(), PortalGuardWreckingBallRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PLAYER_PORTAL_GUARD_WRECKING_BALL.get(), PlayerPortalGuardWreckingBallRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.MAGMA_CUBE_PROJECTILE.get(), MagmaCubeProjectileRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PLANK_GOLEM_BOLT.get(), PlankGolemBoltRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.FIRST_OF_OAK_BOLT.get(), FirstOfOakBoltRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.BOULDER_PROJECTILE.get(), BoulderProjectileRenderer::new);
		
		event.registerBlockEntityRenderer(BlockEntityTypeInit.LEGENDS_SPAWNER.get(), LegendsSpawnerRenderer::new);
	}
	
	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent event) {
		  event.enqueueWork(() ->
		  {
				ItemProperties.register(Items.BLAZE_ROD, new ResourceLocation("throwing"),
						(stack, level, living, id) -> {
							return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
						});				
				
				ItemProperties.register(ItemInit.PORTAL_GUARD_FLAIL.get(), new ResourceLocation("shooting"),
						(stack, level, living, id) -> {
							return living != null && PortalGuardFlailItem.isShooting(stack) ? 1.0F : 0.0F;
						});
				
				ItemProperties.register(ItemInit.PORTAL_GUARD_FLAIL.get(), new ResourceLocation("charging"),
						(stack, level, living, id) -> {
							return living != null && !PortalGuardFlailItem.isShooting(stack) && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
						});
		  });
		}
}