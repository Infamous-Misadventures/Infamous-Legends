package com.infamous.infamous_legends.animation.keyframe_animations.definition;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PiglinBruiserKeyframeAnimations {

	public static final AnimationDefinition BRUISER_SPIN = AnimationDefinition.Builder.withLength(1.75f)
			.addAnimation("everything",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.9583434f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.2083433f, KeyframeAnimations.posVec(0f, 12f, 0f),
						AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.4583433f, KeyframeAnimations.posVec(0f, 12f, 0f),
						AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.6766667f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.7083433f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("everything",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 60f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, -720f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, -720f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("body",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(8.885306084252989f, 0f, 2.1564030737931716f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(8.89f, 0f, 2.16f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(34.090200962643976f, 26.643392180447336f, -25.668925261817403f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(-7.036400269471557f, 27.237171361007896f, -11.657268181587298f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583433f, KeyframeAnimations.degreeVec(2.1879564134137217f, 27.98899445201572f, 8.093137312894978f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftArm",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(0.25f, KeyframeAnimations.posVec(1f, -3f, -2f),
						AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(0.5416766f, KeyframeAnimations.posVec(1f, -3f, -2f),
						AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(1.3433333f, KeyframeAnimations.posVec(1f, -3f, 0f),
						AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(1.6766667f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leftArm",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(-2.4905f, -0.21782074970724352f, -19.9953f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(-84.99428956952602f, 15.921801062704873f, -85.70814284721882f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(-84.99428956952602f, 15.921801062704873f, -85.70814284721882f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(-78.9178656236429f, 2.4941004781602896f, -62.142963328375075f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3433333f, KeyframeAnimations.degreeVec(26.08f, 2.49f, -62.14f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6766667f, KeyframeAnimations.degreeVec(-2.4905f, -0.21782074970724352f, -19.9953f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightArm",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 3f, 0f),
						AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(0.5416766f, KeyframeAnimations.posVec(0f, 3f, 0f),
						AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(0.7916766f, KeyframeAnimations.posVec(-1f, 3f, 2f),
						AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(1.375f, KeyframeAnimations.posVec(-3f, -3f, -2f),
						AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("rightArm",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(-2.4905f, 0.2178f, 19.9953f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(-135.49060065470687f, 49.69939905634565f, -66.86350093776102f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(-232.45938190086986f, -1.5213269586177205f, -77.43227161070581f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(-232.45938190086986f, -1.5213269586177205f, -77.43227161070581f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(-227.99116425158033f, -38.17283654472932f, -75.98895023469203f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125f, KeyframeAnimations.degreeVec(-117.62048975961329f, -15.249225643952215f, 101.79232728688271f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375f, KeyframeAnimations.degreeVec(-117.62048975961329f, -15.249225643952215f, 101.79232728688271f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75f, KeyframeAnimations.degreeVec(-2.4905f, 0.2178f, 19.9953f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(-3.5f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(1.5094323555817937f, 27.364659889330596f, -0.4617479352468763f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583434f, KeyframeAnimations.degreeVec(-23.954955645651573f, 18.868791568754077f, 5.2565127242083145f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0416767f, KeyframeAnimations.degreeVec(-23.95f, 18.87f, 5.26f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.degreeVec(0.42346131946969834f, 0.7096318413933851f, 6.093427143444623f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583433f, KeyframeAnimations.degreeVec(0.33256626436870645f, 13.258542963262208f, -1.3384723362102342f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75f, KeyframeAnimations.degreeVec(-3.5f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftEar",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(37.5f, 0f, 2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875f, KeyframeAnimations.degreeVec(-69.24408537505815f, -10.184790115943088f, 14.634861760762305f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(-69.24408537505815f, -10.184790115943088f, 14.634861760762305f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167667f, KeyframeAnimations.degreeVec(30.376345996110345f, 12.965811704051085f, 5.620364544773004f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5834333f, KeyframeAnimations.degreeVec(-30.57468839782689f, 4.88830798221281f, 1.593569412451525f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightEar",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-30f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(-2.5f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(47.5f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1676667f, KeyframeAnimations.degreeVec(47.5f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3433333f, KeyframeAnimations.degreeVec(-35f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5f, KeyframeAnimations.degreeVec(7.2472078554365f, -1.9359724557994014f, 12.377386584975284f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6766667f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftLeg",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftLeg",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -5f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(-62.92802533922759f, 0.9761235304858928f, -3.2854121083296377f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(-62.92802533922759f, 0.9761235304858928f, -3.2854121083296377f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167667f, KeyframeAnimations.degreeVec(-0.9501590316082726f, 21.432866256905964f, -17.70153662826491f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5834333f, KeyframeAnimations.degreeVec(-0.9501590316082726f, 21.432866256905964f, -17.70153662826491f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, -5f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightLeg",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightLeg",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5002076301761917f, 2.606637306583707f, 2.3886003878242263f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(-3.089978372054702f, 1.87435758616617f, -12.603598841514085f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(-3.13f, 1.83f, -13.54f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167667f, KeyframeAnimations.degreeVec(-1.94722074655132f, 17.580282115530846f, 1.8044983441149274f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5834333f, KeyframeAnimations.degreeVec(-1.94722074655132f, 17.580282115530846f, 1.8044983441149274f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75f, KeyframeAnimations.degreeVec(-2.5002076301761917f, 2.606637306583707f, 2.3886003878242263f),
						AnimationChannel.Interpolations.CATMULLROM))).build();
			public static final AnimationDefinition BRUISER_ATTACK = AnimationDefinition.Builder.withLength(1.5f)
			.addAnimation("everything",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("body",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375f, KeyframeAnimations.degreeVec(-7.5008290087971545f, -2.7083179219025624f, -2.2726403989859136f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(-7.5008290087971545f, -2.7083179219025624f, -2.2726403989859136f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(11.451602951633014f, -22.54482510151518f, 9.594437398958526f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875f, KeyframeAnimations.degreeVec(27.145073410064924f, -2.381685068847637f, 3.4897569567947175f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftArm",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leftArm",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(-2.4905f, -0.21782074970724352f, -19.9953f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375f, KeyframeAnimations.degreeVec(-27.70551496670918f, -6.868710763177406f, -16.520831630452903f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-27.70551496670918f, -6.868710763177406f, -16.520831630452903f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875f, KeyframeAnimations.degreeVec(19.012799950041007f, -12.687382626528802f, -33.04228751094844f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1676667f, KeyframeAnimations.degreeVec(11.593726765699138f, -15.752614930000732f, -23.22065715672717f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167667f, KeyframeAnimations.degreeVec(-2.4905f, -0.21782074970724352f, -19.9953f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightArm",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("rightArm",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(-2.4905f, 0.2178f, 19.9953f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-193.58947300283285f, -8.525581930562367f, -23.446141870731026f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625f, KeyframeAnimations.degreeVec(-193.58947300283285f, -8.525581930562367f, -23.446141870731026f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(33.41961685390939f, -4.1503141357923425f, 25.10145901697642f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1676667f, KeyframeAnimations.degreeVec(33.41961685390939f, -4.1503141357923425f, 25.10145901697642f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5f, KeyframeAnimations.degreeVec(-2.4905f, 0.2178f, 19.9953f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(-3.5f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(4.248546202408306f, 7.301219839001533f, 3.038141532166719f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(4.248546202408306f, 7.301219839001533f, 3.038141532166719f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(-18.119999999999997f, 2.9f, -0.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583434f, KeyframeAnimations.degreeVec(-13.284862847810473f, 0.188154939511878f, -2.500704847125653f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25f, KeyframeAnimations.degreeVec(6.5600000000000005f, -0.3f, -1.32f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5f, KeyframeAnimations.degreeVec(-3.5f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftEar",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-27.5f, 0f, 2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625f, KeyframeAnimations.degreeVec(-27.5f, 0f, 2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875f, KeyframeAnimations.degreeVec(23.59681405985839f, -7.9813f, -13.1249f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0416767f, KeyframeAnimations.degreeVec(23.59681405985839f, -7.9813f, -13.1249f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2916767f, KeyframeAnimations.degreeVec(-29.738748111332278f, 3.1467f, 6.4849f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightEar",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(-27.5f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(-27.5f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(23.59681405985839f, 7.981334288788275f, 13.124894812003276f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1f, KeyframeAnimations.degreeVec(23.59681405985839f, 7.981334288788275f, 13.124894812003276f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(-29.738748111332278f, -3.1467450216691937f, -6.484872297788007f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftLeg",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftLeg",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -5f, -2.5f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightLeg",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightLeg",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5002076301761917f, 2.606637306583707f, 2.3886003878242263f),
						AnimationChannel.Interpolations.CATMULLROM))).build();

}