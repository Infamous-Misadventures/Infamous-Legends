package com.infamous.infamous_legends.animation.keyframe_animations.definition;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MaceRuntKeyframeAnimations {

	public static final AnimationDefinition MACE_RUNT_ATTACK = AnimationDefinition.Builder.withLength(2.875f)
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.0416767f, KeyframeAnimations.posVec(0f, 1f, 0.5f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.375f, KeyframeAnimations.posVec(0f, 1f, 0.5f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.5416767f, KeyframeAnimations.posVec(0f, 0f, -0.5f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.25f, KeyframeAnimations.posVec(0f, 0f, -0.5f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.4167665f, KeyframeAnimations.posVec(0f, 1f, -0.33f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.625f, KeyframeAnimations.posVec(0f, -0.25f, 0f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(25.6187f, -14.200779900147154f, -4.811382688330468f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(28.12f, -14.2f, -4.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(15.62f, -14.2f, -4.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875f,
							KeyframeAnimations.degreeVec(-25.232586041678022f, -9.833245171573434f,
									-1.242933078584028f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125f,
							KeyframeAnimations.degreeVec(-30.42812533846916f, -6.1317056643171775f,
									-0.7412668141214995f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375f,
							KeyframeAnimations.degreeVec(-30.42812533846916f, -6.1317056643171775f,
									-0.7412668141214995f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5416767f,
							KeyframeAnimations.degreeVec(41.087478919599675f, -3.609757701850139f,
									-4.6504897553832585f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25f,
							KeyframeAnimations.degreeVec(46.587478919599675f, -3.609757701850139f,
									-4.6504897553832585f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.625f,
							KeyframeAnimations.degreeVec(25.6187f, -14.200779900147154f, -4.811382688330468f),
							AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.7083434f, KeyframeAnimations.posVec(0.47f, 6.07f, 0f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1f, KeyframeAnimations.posVec(-1f, 2f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.375f, KeyframeAnimations.posVec(-1f, 2f, 0f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.4167667f, KeyframeAnimations.posVec(1f, 3.17f, -0.83f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.5f, KeyframeAnimations.posVec(-4f, 5.5f, -2.5f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.625f, KeyframeAnimations.posVec(-1f, -1f, -1f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.25f, KeyframeAnimations.posVec(-1f, -1f, -1f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.875f, KeyframeAnimations.posVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leftArm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f,
									KeyframeAnimations.degreeVec(-40.8858f, 26.668386575825934f, 27.402160179734437f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-40.89f, 26.67f, 27.4f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7083434f,
									KeyframeAnimations.degreeVec(-146.478697471348f, 34.96063533846505f,
											-28.929001666242037f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1f,
									KeyframeAnimations.degreeVec(-213.3974731066852f, -0.2041033584356029f,
											-22.534699184773302f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f,
									KeyframeAnimations.degreeVec(-211.72365454664114f, -11.043516602342333f,
											-39.44316808966485f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.625f,
									KeyframeAnimations.degreeVec(-103.17831258800743f, 52.21677186726356f,
											-6.480087687216383f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(-103.18f, 52.22f, -6.48f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(-103.18f, 52.22f, -6.48f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.4583435f,
									KeyframeAnimations.degreeVec(-97.93047649001184f, 49.60651281792743f,
											2.591484538613313f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.625f, KeyframeAnimations.degreeVec(-86.1f, 40.79f, 12.57f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.875f,
									KeyframeAnimations.degreeVec(-40.8858f, 26.668386575825934f, 27.402160179734437f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.7083434f, KeyframeAnimations.posVec(-0.47f, 6.07f, 0f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1f, KeyframeAnimations.posVec(1f, 2f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.375f, KeyframeAnimations.posVec(1f, 2f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 6.5f, -0.5f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.625f, KeyframeAnimations.posVec(1f, 1f, -1f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.25f, KeyframeAnimations.posVec(1f, 1f, -1f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.875f, KeyframeAnimations.posVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("rightArm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f,
									KeyframeAnimations.degreeVec(-46.5424f, -25.704677726778755f, -18.60553537578653f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-46.5424f, -25.704677726778755f,
									-18.60553537578653f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1f,
									KeyframeAnimations.degreeVec(-209.7400450281548f, -5.677127469726383f,
											16.189556371981908f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f,
									KeyframeAnimations.degreeVec(-212.1224275664613f, -3.306967153434197f,
											-16.32891775663107f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.625f,
									KeyframeAnimations.degreeVec(-79.07276922659241f, -2.582135985256228f,
											4.275472596169877f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.75f,
									KeyframeAnimations.degreeVec(-79.07279351134031f, -2.584579236952232f,
											4.271420537655413f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.25f,
									KeyframeAnimations.degreeVec(-79.07279351134031f, -2.584579236952232f,
											4.271420537655413f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.4583435f, KeyframeAnimations.degreeVec(-86.63f, -6.1f, 0.79f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.625f, KeyframeAnimations.degreeVec(-74.56f, -16.12f, -9.13f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.7916765f, KeyframeAnimations.degreeVec(-46.9f, -23.24f, -16.17f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.875f,
									KeyframeAnimations.degreeVec(-46.5424f, -25.704677726778755f, -18.60553537578653f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightHand", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0f, KeyframeAnimations.posVec(0.5f, 0f, 1f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25f, KeyframeAnimations.posVec(-0.5f, 1f, -1f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6766666f, KeyframeAnimations.posVec(3.0700000000000007f, -3.1100000000000003f, 0f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1f, KeyframeAnimations.posVec(4.5f, -4f, -1f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.5f, KeyframeAnimations.posVec(3.5f, -2f, 1f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.625f, KeyframeAnimations.posVec(1.5f, -3f, -3f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.75f, KeyframeAnimations.posVec(1.5f, -3f, -3f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.125f, KeyframeAnimations.posVec(1.5f, -3f, -3f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.25f, KeyframeAnimations.posVec(1.5f, -3f, -3f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.875f, KeyframeAnimations.posVec(0.5f, 0f, 1f),
							AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("rightHand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f,
									KeyframeAnimations.degreeVec(56.74998183401294f, -33.0855f, -2.373766923763924f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.125f,
									KeyframeAnimations.degreeVec(49.94476346444702f, -39.304092510779284f,
											2.0725443865742275f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25f,
									KeyframeAnimations.degreeVec(41.81487269524223f, -40.75493438762291f,
											10.400107474676478f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.6766666f,
									KeyframeAnimations.degreeVec(15.34835704740999f, -28.70667336882765f,
											2.6945767236331815f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1f,
									KeyframeAnimations.degreeVec(34.79389612010755f, -19.015332922836336f,
											-11.609831344278174f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5f,
									KeyframeAnimations.degreeVec(56.71944738622295f, -10.782145191703293f,
											-6.011848706475448f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.625f,
									KeyframeAnimations.degreeVec(39.75073898633556f, 8.689722593181815f,
											4.853029905718577f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.6766667f, KeyframeAnimations.degreeVec(29.33f, 10.13f, 5.66f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.75f,
									KeyframeAnimations.degreeVec(34.75073898633556f, 8.689722593181815f,
											4.853029905718577f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.875f, KeyframeAnimations.degreeVec(39.75f, 8.69f, 4.85f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(39.75f, 8.69f, 4.85f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.5f, KeyframeAnimations.degreeVec(39.75f, 8.69f, 4.85f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.7916765f, KeyframeAnimations.degreeVec(52.7f, -29.29f, -1.72f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.875f,
									KeyframeAnimations.degreeVec(56.74998183401294f, -33.0855f, -2.373766923763924f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.625f, KeyframeAnimations.posVec(0f, -2f, 1f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.375f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -2f, 1f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.6766667f, KeyframeAnimations.posVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.25f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(-22.6852f, 15.303823591608761f, -1.8075653258915736f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.08343333f,
							KeyframeAnimations.degreeVec(-27.6852f, 15.303823591608761f, -1.8075653258915736f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-10.190000000000001f, 15.3f, -1.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(39.81f, 15.3f, -1.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1f, KeyframeAnimations.degreeVec(39.81f, 15.3f, -1.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.degreeVec(14.810000000000002f, 15.3f, -1.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5416767f, KeyframeAnimations.degreeVec(-60.65f, 15.3f, -1.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.625f, KeyframeAnimations.degreeVec(-15.189999999999998f, 15.3f, -1.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2f, KeyframeAnimations.degreeVec(-37.69f, 15.3f, -1.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25f, KeyframeAnimations.degreeVec(-32.69f, 15.3f, -1.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5f, KeyframeAnimations.degreeVec(-23.93f, 15.3f, -1.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.7083435f, KeyframeAnimations.degreeVec(-30.24f, 15.3f, -1.81f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.875f,
							KeyframeAnimations.degreeVec(-22.6852f, 15.303823591608761f, -1.8075653258915736f),
							AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftEar",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7083434f,
									KeyframeAnimations.degreeVec(-24.81196607778702f, 3.1621980117042767f,
											6.8042314257686485f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.3433333f, KeyframeAnimations.degreeVec(37.69f, 3.16f, 6.8f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.625f,
									KeyframeAnimations.degreeVec(39.0564835668892f, 16.72749125733495f,
											0.28854535789359925f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.9583433f,
									KeyframeAnimations.degreeVec(-35.698732112081814f, -14.034074481472562f,
											-11.220357757500516f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.1676665f, KeyframeAnimations.degreeVec(10.36f, 16.12f, -12.73f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.375f,
									KeyframeAnimations.degreeVec(-21.5371551404212f, -1.0883834659177758f,
											-3.77814430100012f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.7083435f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightEar", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(-24.81196607778702f, -3.1622f, -6.8042f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(37.69f, -3.16f, -6.8f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6766667f, KeyframeAnimations.degreeVec(39.0564835668892f, -16.7275f, -0.2885f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9167667f, KeyframeAnimations.degreeVec(-35.698732112081814f, 14.0341f, 11.2204f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25f, KeyframeAnimations.degreeVec(10.36f, -16.12f, 12.73f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4167665f, KeyframeAnimations.degreeVec(-21.5371551404212f, 1.0884f, 3.7781f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.6766665f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftLeg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("rightLeg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f,
							KeyframeAnimations.degreeVec(12.5f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR)))
			.build();

}