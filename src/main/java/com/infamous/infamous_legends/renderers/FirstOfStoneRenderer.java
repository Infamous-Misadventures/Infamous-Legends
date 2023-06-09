package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.FirstOfStone;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.FirstOfStoneModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class FirstOfStoneRenderer extends MobRenderer<FirstOfStone, FirstOfStoneModel<FirstOfStone>> {

	public FirstOfStoneRenderer(EntityRendererProvider.Context context) {
		super(context, new FirstOfStoneModel<>(context.bakeLayer(ModelLayerInit.FIRST_OF_STONE)), 1.75F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.FIRST_OF_STONE_INNER_ARMOUR, ModelLayerInit.FIRST_OF_STONE_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(FirstOfStone p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/first_of_stone.png");
	}

}
