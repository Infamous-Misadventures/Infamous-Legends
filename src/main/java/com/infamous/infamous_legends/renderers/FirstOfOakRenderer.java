package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.entities.FirstOfOak;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.FirstOfOakModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.FirstOfOakGlowLayer;
import com.infamous.infamous_legends.renderers.layers.FirstOfOakSecondaryTypeLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class FirstOfOakRenderer extends MobRenderer<FirstOfOak, FirstOfOakModel<FirstOfOak>> {

	public FirstOfOakRenderer(EntityRendererProvider.Context context) {
		super(context, new FirstOfOakModel<>(context.bakeLayer(ModelLayerInit.FIRST_OF_OAK)), 1.75F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.FIRST_OF_OAK_INNER_ARMOUR, ModelLayerInit.FIRST_OF_OAK_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
		this.addLayer(new FirstOfOakSecondaryTypeLayer<>(this));
		this.addLayer(new FirstOfOakGlowLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(FirstOfOak p_114482_) {
		return new ResourceLocation(p_114482_.getWood1Type().getTextureLocation());
	}

}
