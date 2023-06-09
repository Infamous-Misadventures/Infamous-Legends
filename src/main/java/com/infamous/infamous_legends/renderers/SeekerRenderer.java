package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.Seeker;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.SeekerModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class SeekerRenderer extends MobRenderer<Seeker, SeekerModel<Seeker>> {

	public SeekerRenderer(EntityRendererProvider.Context context) {
		super(context, new SeekerModel<>(context.bakeLayer(ModelLayerInit.SEEKER)), 0.75F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.SEEKER_INNER_ARMOUR, ModelLayerInit.SEEKER_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}
	
	protected boolean isShaking(Seeker entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(Seeker p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/seeker.png");
	}

}
