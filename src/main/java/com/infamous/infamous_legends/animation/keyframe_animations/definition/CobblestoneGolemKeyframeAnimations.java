package com.infamous.infamous_legends.animation.keyframe_animations.definition;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CobblestoneGolemKeyframeAnimations {

public static final AnimationDefinition COBBLESTONE_GOLEM_ATTACK = AnimationDefinition.Builder.withLength(2f)
.addAnimation("everything",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.16766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 8.5f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 9f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, 9.5f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.9167666f, KeyframeAnimations.posVec(0f, -2f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.9583434f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("everything",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(-14.944524436301435f, -1.1228970702691186f, 5.475131689926002f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(-19.944524436301435f, -1.1228970702691186f, 5.475131689926002f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.9583434f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1.0416767f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("body",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.125f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.9167666f, KeyframeAnimations.posVec(0f, -5.000000000000002f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(1.4167667f, KeyframeAnimations.posVec(0f, -5f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("body",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(-12.81f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(-1.87f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1.4167667f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(2f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("leftArm",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 2.7800000000000002f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.7083434f, KeyframeAnimations.posVec(0f, 2.1799999999999997f, 0.5000000000000001f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 5.09f, -2.75f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.875f, KeyframeAnimations.posVec(0f, -4f, -6f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.25f, KeyframeAnimations.posVec(0f, -4f, -6f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("leftArm",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0.0157f, -0.11300216496510984f, -7.4882f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.125f, KeyframeAnimations.degreeVec(27.21974641445877f, 3.4048673211614187f, -9.408043486834686f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.375f, KeyframeAnimations.degreeVec(-204.78630841771226f, -1.5475499167156173f, 23.776114066140362f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.625f, KeyframeAnimations.degreeVec(-204.79f, -1.55f, 23.78f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(-222.29f, -1.55f, 23.78f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.25f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0.0157f, -0.11300216496510984f, -7.4882f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("rightArm",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 2.7800000000000002f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.7083434f, KeyframeAnimations.posVec(0f, 2.1799999999999997f, 0.5000000000000001f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 5.09f, -2.75f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.875f, KeyframeAnimations.posVec(0f, -4f, -6f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.25f, KeyframeAnimations.posVec(0f, -4f, -6f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("rightArm",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0.0157f, 0f, 7.4882f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.125f, KeyframeAnimations.degreeVec(27.21974641445877f, -3.4049f, 9.408f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.375f, KeyframeAnimations.degreeVec(-204.78630841771226f, 1.5475f, -23.7761f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.625f, KeyframeAnimations.degreeVec(-204.79f, 1.55f, -23.78f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(-222.29f, 1.55f, -23.78f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.25f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0.0157f, 0f, 7.4882f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("leftLeg",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("rightLeg",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM))).build();
}