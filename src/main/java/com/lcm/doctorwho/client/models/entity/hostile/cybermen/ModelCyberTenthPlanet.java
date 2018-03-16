package com.lcm.doctorwho.client.models.entity.hostile.cybermen;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.BodyPartHook;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelCyberTenthPlanet extends ModelBiped {
	private ResourceLocation TEX = new ResourceLocation(AcrossTheGalaxy.MODID, "textures/entity/cybermen/tenth_planet.png");

	public ModelCyberTenthPlanet() {
		textureWidth = 128;
		textureHeight = 128;

		ModelRenderer head1 = new ModelRenderer(this, 32, 0);
		head1.addBox(4.8F, -10F, -0.5F, 1, 7, 1);
		head1.setRotationPoint(0F, 0F, 0F);
		head1.setTextureSize(128, 128);
		head1.mirror = true;
		ATGUtils.setRotation(head1, 0F, 0F, 0F);

		ModelRenderer head2 = new ModelRenderer(this, 36, 0);
		head2.addBox(1F, -4.5F, -4.1F, 2, 1, 1);
		head2.setRotationPoint(0F, 0F, 0F);
		head2.setTextureSize(128, 128);
		head2.mirror = true;
		ATGUtils.setRotation(head2, 0F, 0F, 0F);

		ModelRenderer head3 = new ModelRenderer(this, 36, 2);
		head3.addBox(-0.5F, 0F, 0F, 1, 2, 1);
		head3.setRotationPoint(0F, -4F, -4F);
		head3.setTextureSize(128, 128);
		head3.mirror = true;
		ATGUtils.setRotation(head3, -0.122173F, 0F, 0F);

		ModelRenderer head4 = new ModelRenderer(this, 36, 0);
		head4.addBox(-3F, -4.5F, -4.1F, 2, 1, 1);
		head4.setRotationPoint(0F, 0F, 0F);
		head4.setTextureSize(128, 128);
		head4.mirror = true;
		ATGUtils.setRotation(head4, 0F, 0F, 0F);

		ModelRenderer head5 = new ModelRenderer(this, 36, 5);
		head5.addBox(-2.2F, -4.3F, -4.2F, 1, 1, 1);
		head5.setRotationPoint(0F, 0F, 0F);
		head5.setTextureSize(128, 128);
		head5.mirror = true;
		ATGUtils.setRotation(head5, 0F, 0F, 0F);

		ModelRenderer head6 = new ModelRenderer(this, 40, 2);
		head6.addBox(-4F, -7F, 3.2F, 8, 1, 1);
		head6.setRotationPoint(0F, 0F, 0F);
		head6.setTextureSize(128, 128);
		head6.mirror = true;
		ATGUtils.setRotation(head6, 0F, 0F, 0F);

		ModelRenderer head7 = new ModelRenderer(this, 58, 0);
		head7.addBox(0F, -1F, -1F, 2, 1, 2);
		head7.setRotationPoint(2F, 0.5F, -3F);
		head7.setTextureSize(128, 128);
		head7.mirror = true;
		ATGUtils.setRotation(head7, 0F, 0F, -0.3490659F);

		ModelRenderer head8 = new ModelRenderer(this, 36, 0);
		head8.addBox(-3F, -4F, -4.1F, 2, 1, 1);
		head8.setRotationPoint(0F, 0F, 0F);
		head8.setTextureSize(128, 128);
		head8.mirror = true;
		ATGUtils.setRotation(head8, 0F, 0F, 0F);

		ModelRenderer head9 = new ModelRenderer(this, 58, 3);
		head9.addBox(-1.5F, -11.5F, -2.7F, 3, 3, 1);
		head9.setRotationPoint(0F, 0F, 0F);
		head9.setTextureSize(128, 128);
		head9.mirror = true;
		ATGUtils.setRotation(head9, 0F, 0F, 0F);

		ModelRenderer head10 = new ModelRenderer(this, 40, 4);
		head10.addBox(-2F, -0.5F, -4F, 4, 1, 2);
		head10.setRotationPoint(0F, 0F, 0F);
		head10.setTextureSize(128, 128);
		head10.mirror = true;
		ATGUtils.setRotation(head10, 0F, 0F, 0F);

		ModelRenderer head11 = new ModelRenderer(this, 58, 0);
		head11.addBox(-2F, -1F, -1F, 2, 1, 2);
		head11.setRotationPoint(-2F, 0.5F, -3F);
		head11.setTextureSize(128, 128);
		head11.mirror = true;
		ATGUtils.setRotation(head11, 0F, 0F, 0.3490659F);

		ModelRenderer head12 = new ModelRenderer(this, 36, 0);
		head12.addBox(1F, -4F, -4.1F, 2, 1, 1);
		head12.setRotationPoint(0F, 0F, 0F);
		head12.setTextureSize(128, 128);
		head12.mirror = true;
		ATGUtils.setRotation(head12, 0F, 0F, 0F);

		ModelRenderer head13 = new ModelRenderer(this, 54, 0);
		head13.addBox(-2.2F, -4.2F, -4.25F, 1, 1, 1);
		head13.setRotationPoint(0F, 0F, 0F);
		head13.setTextureSize(128, 128);
		head13.mirror = true;
		ATGUtils.setRotation(head13, 0F, 0F, 0F);

		ModelRenderer head14 = new ModelRenderer(this, 36, 5);
		head14.addBox(-2.8F, -4.3F, -4.2F, 1, 1, 1);
		head14.setRotationPoint(0F, 0F, 0F);
		head14.setTextureSize(128, 128);
		head14.mirror = true;
		ATGUtils.setRotation(head14, 0F, 0F, 0F);

		ModelRenderer head15 = new ModelRenderer(this, 36, 5);
		head15.addBox(-2.8F, -4.2F, -4.2F, 1, 1, 1);
		head15.setRotationPoint(0F, 0F, 0F);
		head15.setTextureSize(128, 128);
		head15.mirror = true;
		ATGUtils.setRotation(head15, 0F, 0F, 0F);

		ModelRenderer head16 = new ModelRenderer(this, 36, 5);
		head16.addBox(1.2F, -4.3F, -4.2F, 1, 1, 1);
		head16.setRotationPoint(0F, 0F, 0F);
		head16.setTextureSize(128, 128);
		head16.mirror = true;
		ATGUtils.setRotation(head16, 0F, 0F, 0F);

		ModelRenderer head17 = new ModelRenderer(this, 36, 5);
		head17.addBox(1.8F, -4.3F, -4.2F, 1, 1, 1);
		head17.setRotationPoint(0F, 0F, 0F);
		head17.setTextureSize(128, 128);
		head17.mirror = true;
		ATGUtils.setRotation(head17, 0F, 0F, 0F);

		ModelRenderer head18 = new ModelRenderer(this, 36, 5);
		head18.addBox(1.8F, -4.2F, -4.2F, 1, 1, 1);
		head18.setRotationPoint(0F, 0F, 0F);
		head18.setTextureSize(128, 128);
		head18.mirror = true;
		ATGUtils.setRotation(head18, 0F, 0F, 0F);

		ModelRenderer head19 = new ModelRenderer(this, 54, 0);
		head19.addBox(1.2F, -4.2F, -4.25F, 1, 1, 1);
		head19.setRotationPoint(0F, 0F, 0F);
		head19.setTextureSize(128, 128);
		head19.mirror = true;
		ATGUtils.setRotation(head19, 0F, 0F, 0F);

		ModelRenderer head20 = new ModelRenderer(this, 42, 0);
		head20.addBox(-1.5F, -1F, 0F, 3, 1, 1);
		head20.setRotationPoint(0F, -0.2F, -4.1F);
		head20.setTextureSize(128, 128);
		head20.mirror = true;
		ATGUtils.setRotation(head20, -0.1396263F, 0F, 0F);

		ModelRenderer head21 = new ModelRenderer(this, 40, 2);
		head21.addBox(-4F, -6.5F, 3.2F, 8, 1, 1);
		head21.setRotationPoint(0F, 0F, 0F);
		head21.setTextureSize(128, 128);
		head21.mirror = true;
		ATGUtils.setRotation(head21, 0F, 0F, 0F);

		ModelRenderer head22 = new ModelRenderer(this, 66, 0);
		head22.addBox(3.2F, -7F, -4F, 1, 1, 8);
		head22.setRotationPoint(0F, 0F, 0F);
		head22.setTextureSize(128, 128);
		head22.mirror = true;
		ATGUtils.setRotation(head22, 0F, 0F, 0F);

		ModelRenderer head23 = new ModelRenderer(this, 66, 0);
		head23.addBox(3.2F, -6.5F, -4F, 1, 1, 8);
		head23.setRotationPoint(0F, 0F, 0F);
		head23.setTextureSize(128, 128);
		head23.mirror = true;
		ATGUtils.setRotation(head23, 0F, 0F, 0F);

		ModelRenderer head24 = new ModelRenderer(this, 40, 2);
		head24.addBox(-4F, -7F, -4.2F, 8, 1, 1);
		head24.setRotationPoint(0F, 0F, 0F);
		head24.setTextureSize(128, 128);
		head24.mirror = true;
		ATGUtils.setRotation(head24, 0F, 0F, 0F);

		ModelRenderer head25 = new ModelRenderer(this, 40, 2);
		head25.addBox(-4F, -6.5F, -4.2F, 8, 1, 1);
		head25.setRotationPoint(0F, 0F, 0F);
		head25.setTextureSize(128, 128);
		head25.mirror = true;
		ATGUtils.setRotation(head25, 0F, 0F, 0F);

		ModelRenderer head26 = new ModelRenderer(this, 66, 0);
		head26.addBox(-4.2F, -7F, -4F, 1, 1, 8);
		head26.setRotationPoint(0F, 0F, 0F);
		head26.setTextureSize(128, 128);
		head26.mirror = true;
		ATGUtils.setRotation(head26, 0F, 0F, 0F);

		ModelRenderer head27 = new ModelRenderer(this, 66, 0);
		head27.addBox(-4.2F, -6.5F, -4F, 1, 1, 8);
		head27.setRotationPoint(0F, 0F, 0F);
		head27.setTextureSize(128, 128);
		head27.mirror = true;
		ATGUtils.setRotation(head27, 0F, 0F, 0F);

		ModelRenderer head28 = new ModelRenderer(this, 32, 12);
		head28.addBox(-5F, -4F, -1F, 10, 2, 2);
		head28.setRotationPoint(0F, 0F, 0F);
		head28.setTextureSize(128, 128);
		head28.mirror = true;
		ATGUtils.setRotation(head28, 0F, 0F, 0F);

		ModelRenderer head29 = new ModelRenderer(this, 52, 4);
		head29.addBox(-0.5F, -10F, 3F, 1, 2, 1);
		head29.setRotationPoint(0F, 0F, 0F);
		head29.setTextureSize(128, 128);
		head29.mirror = true;
		ATGUtils.setRotation(head29, 0F, 0F, 0F);

		ModelRenderer head30 = new ModelRenderer(this, 32, 0);
		head30.addBox(-5.8F, -10F, -0.5F, 1, 7, 1);
		head30.setRotationPoint(0F, 0F, 0F);
		head30.setTextureSize(128, 128);
		head30.mirror = true;
		ATGUtils.setRotation(head30, 0F, 0F, 0F);

		ModelRenderer head31 = new ModelRenderer(this, 0, 0);
		head31.addBox(-4F, -8F, -4F, 8, 8, 8);
		head31.setRotationPoint(0F, 0F, 0F);
		head31.setTextureSize(128, 128);
		head31.mirror = true;
		ATGUtils.setRotation(head31, 0F, 0F, 0F);

		ModelRenderer head32 = new ModelRenderer(this, 84, 0);
		head32.addBox(-2F, -11.5F, -2.5F, 4, 3, 5);
		head32.setRotationPoint(0F, 0F, 0F);
		head32.setTextureSize(128, 128);
		head32.mirror = true;
		ATGUtils.setRotation(head32, 0F, 0F, 0F);

		ModelRenderer head33 = new ModelRenderer(this, 102, 0);
		head33.addBox(-1.5F, -12F, -2.5F, 3, 4, 5);
		head33.setRotationPoint(0F, 0F, 0F);
		head33.setTextureSize(128, 128);
		head33.mirror = true;
		ATGUtils.setRotation(head33, 0F, 0F, 0F);

		ModelRenderer head34 = new ModelRenderer(this, 32, 10);
		head34.addBox(-5.5F, -10.5F, -0.3F, 11, 1, 1);
		head34.setRotationPoint(0F, 0F, 0F);
		head34.setTextureSize(128, 128);
		head34.mirror = true;
		ATGUtils.setRotation(head34, 0F, 0F, 0F);

		ModelRenderer head35 = new ModelRenderer(this, 50, 0);
		head35.addBox(-0.5F, -10.5F, 2.5F, 1, 1, 1);
		head35.setRotationPoint(0F, 0F, 0F);
		head35.setTextureSize(128, 128);
		head35.mirror = true;
		ATGUtils.setRotation(head35, 0F, 0F, 0F);

		ModelRenderer head36 = new ModelRenderer(this, 32, 8);
		head36.addBox(-5.5F, -10.7F, -0.5F, 11, 1, 1);
		head36.setRotationPoint(0F, 0F, 0F);
		head36.setTextureSize(128, 128);
		head36.mirror = true;
		ATGUtils.setRotation(head36, 0F, 0F, 0F);

		ModelRenderer head37 = new ModelRenderer(this, 32, 8);
		head37.addBox(-5.5F, -10.3F, -0.5F, 11, 1, 1);
		head37.setRotationPoint(0F, 0F, 0F);
		head37.setTextureSize(128, 128);
		head37.mirror = true;
		ATGUtils.setRotation(head37, 0F, 0F, 0F);

		ModelRenderer head38 = new ModelRenderer(this, 32, 10);
		head38.addBox(-5.5F, -10.5F, -0.7F, 11, 1, 1);
		head38.setRotationPoint(0F, 0F, 0F);
		head38.setTextureSize(128, 128);
		head38.mirror = true;
		ATGUtils.setRotation(head38, 0F, 0F, 0F);

		ModelRenderer head39 = new ModelRenderer(this, 56, 7);
		head39.addBox(5F, -10.5F, -0.5F, 1, 8, 1);
		head39.setRotationPoint(0F, 0F, 0F);
		head39.setTextureSize(128, 128);
		head39.mirror = true;
		ATGUtils.setRotation(head39, 0F, 0F, 0F);

		ModelRenderer head40 = new ModelRenderer(this, 60, 7);
		head40.addBox(5F, -10F, -0.3F, 1, 7, 1);
		head40.setRotationPoint(0F, 0F, 0F);
		head40.setTextureSize(128, 128);
		head40.mirror = true;
		ATGUtils.setRotation(head40, 0F, 0F, 0F);

		ModelRenderer head41 = new ModelRenderer(this, 32, 0);
		head41.addBox(5.2F, -10F, -0.5F, 1, 7, 1);
		head41.setRotationPoint(0F, 0F, 0F);
		head41.setTextureSize(128, 128);
		head41.mirror = true;
		ATGUtils.setRotation(head41, 0F, 0F, 0F);

		ModelRenderer head42 = new ModelRenderer(this, 60, 7);
		head42.addBox(5F, -10F, -0.7F, 1, 7, 1);
		head42.setRotationPoint(0F, 0F, 0F);
		head42.setTextureSize(128, 128);
		head42.mirror = true;
		ATGUtils.setRotation(head42, 0F, 0F, 0F);

		ModelRenderer head43 = new ModelRenderer(this, 56, 7);
		head43.addBox(-6F, -10.5F, -0.5F, 1, 8, 1);
		head43.setRotationPoint(0F, 0F, 0F);
		head43.setTextureSize(128, 128);
		head43.mirror = true;
		ATGUtils.setRotation(head43, 0F, 0F, 0F);

		ModelRenderer head44 = new ModelRenderer(this, 60, 7);
		head44.addBox(-6F, -10F, -0.7F, 1, 7, 1);
		head44.setRotationPoint(0F, 0F, 0F);
		head44.setTextureSize(128, 128);
		head44.mirror = true;
		ATGUtils.setRotation(head44, 0F, 0F, 0F);

		ModelRenderer head45 = new ModelRenderer(this, 60, 7);
		head45.addBox(-6F, -10F, -0.3F, 1, 7, 1);
		head45.setRotationPoint(0F, 0F, 0F);
		head45.setTextureSize(128, 128);
		head45.mirror = true;
		ATGUtils.setRotation(head45, 0F, 0F, 0F);

		ModelRenderer head46 = new ModelRenderer(this, 32, 0);
		head46.addBox(-6.2F, -10F, -0.5F, 1, 7, 1);
		head46.setRotationPoint(0F, 0F, 0F);
		head46.setTextureSize(128, 128);
		head46.mirror = true;
		ATGUtils.setRotation(head46, 0F, 0F, 0F);

		ModelRenderer torso1 = new ModelRenderer(this, 16, 32);
		torso1.addBox(-1F, 6.75F, -3.7F, 2, 1, 1);
		torso1.setRotationPoint(0F, 0F, 0F);
		torso1.setTextureSize(128, 128);
		torso1.mirror = true;
		ATGUtils.setRotation(torso1, 0F, 0F, 0F);

		ModelRenderer torso2 = new ModelRenderer(this, 16, 16);
		torso2.addBox(-4F, 0F, -2F, 8, 12, 4);
		torso2.setRotationPoint(0F, 0F, 0F);
		torso2.setTextureSize(128, 128);
		torso2.mirror = true;
		ATGUtils.setRotation(torso2, 0F, 0F, 0F);

		ModelRenderer torso3 = new ModelRenderer(this, 16, 34);
		torso3.addBox(-1F, -1F, -3F, 1, 1, 1);
		torso3.setRotationPoint(2F, 7F, 0F);
		torso3.setTextureSize(128, 128);
		torso3.mirror = true;
		ATGUtils.setRotation(torso3, 0F, 0F, -0.7853982F);

		ModelRenderer torso4 = new ModelRenderer(this, 20, 34);
		torso4.addBox(-1F, 2.5F, -3.7F, 2, 4, 1);
		torso4.setRotationPoint(0F, 0F, 0F);
		torso4.setTextureSize(128, 128);
		torso4.mirror = true;
		ATGUtils.setRotation(torso4, 0F, 0F, 0F);

		ModelRenderer torso5 = new ModelRenderer(this, 16, 44);
		torso5.addBox(-3F, 4.5F, -2.5F, 6, 1, 1);
		torso5.setRotationPoint(0F, 0F, 0F);
		torso5.setTextureSize(128, 128);
		torso5.mirror = true;
		ATGUtils.setRotation(torso5, 0F, 0F, 0F);

		ModelRenderer torso6 = new ModelRenderer(this, 16, 34);
		torso6.addBox(-1F, 0F, -3F, 1, 1, 1);
		torso6.setRotationPoint(2F, 3F, 0F);
		torso6.setTextureSize(128, 128);
		torso6.mirror = true;
		ATGUtils.setRotation(torso6, 0F, 0F, 0.7853982F);

		ModelRenderer torso7 = new ModelRenderer(this, 16, 34);
		torso7.addBox(0F, -1F, -3F, 1, 1, 1);
		torso7.setRotationPoint(-2F, 7F, 0F);
		torso7.setTextureSize(128, 128);
		torso7.mirror = true;
		ATGUtils.setRotation(torso7, 0F, 0F, 0.7853982F);

		ModelRenderer torso8 = new ModelRenderer(this, 16, 34);
		torso8.addBox(0F, 0F, -3F, 1, 1, 1);
		torso8.setRotationPoint(-2F, 3F, 0F);
		torso8.setTextureSize(128, 128);
		torso8.mirror = true;
		ATGUtils.setRotation(torso8, 0F, 0F, -0.7853982F);

		ModelRenderer torso9 = new ModelRenderer(this, 26, 32);
		torso9.addBox(-2F, 3F, -3F, 4, 4, 1);
		torso9.setRotationPoint(0F, 0F, 0F);
		torso9.setTextureSize(128, 128);
		torso9.mirror = true;
		ATGUtils.setRotation(torso9, 0F, 0F, 0F);

		ModelRenderer torso10 = new ModelRenderer(this, 28, 35);
		torso10.addBox(3.5F, 2F, -3.5F, 0, 6, 2);
		torso10.setRotationPoint(0F, 0F, 0F);
		torso10.setTextureSize(128, 128);
		torso10.mirror = true;
		ATGUtils.setRotation(torso10, 0F, 0F, 0F);

		ModelRenderer torso11 = new ModelRenderer(this, 16, 44);
		torso11.addBox(-3F, 6F, -2.5F, 6, 1, 1);
		torso11.setRotationPoint(0F, 0F, 0F);
		torso11.setTextureSize(128, 128);
		torso11.mirror = true;
		ATGUtils.setRotation(torso11, 0F, 0F, 0F);

		ModelRenderer torso12 = new ModelRenderer(this, 16, 44);
		torso12.addBox(-3F, 3F, -2.5F, 6, 1, 1);
		torso12.setRotationPoint(0F, 0F, 0F);
		torso12.setTextureSize(128, 128);
		torso12.mirror = true;
		ATGUtils.setRotation(torso12, 0F, 0F, 0F);

		ModelRenderer torso13 = new ModelRenderer(this, 28, 35);
		torso13.addBox(-3.5F, 2F, -3.5F, 0, 6, 2);
		torso13.setRotationPoint(0F, 0F, 0F);
		torso13.setTextureSize(128, 128);
		torso13.mirror = true;
		ATGUtils.setRotation(torso13, 0F, 0F, 0F);

		ModelRenderer torso14 = new ModelRenderer(this, 16, 46);
		torso14.addBox(-3.5F, 7.9F, -3.5F, 7, 0, 2);
		torso14.setRotationPoint(0F, 0F, 0F);
		torso14.setTextureSize(128, 128);
		torso14.mirror = true;
		ATGUtils.setRotation(torso14, 0F, 0F, 0F);

		ModelRenderer torso15 = new ModelRenderer(this, 32, 37);
		torso15.addBox(-1.5F, 2F, -3.5F, 3, 6, 2);
		torso15.setRotationPoint(0F, 0F, 0F);
		torso15.setTextureSize(128, 128);
		torso15.mirror = true;
		ATGUtils.setRotation(torso15, 0F, 0F, 0F);

		ModelRenderer torso16 = new ModelRenderer(this, 16, 46);
		torso16.addBox(-3.5F, 2F, -3.5F, 7, 0, 2);
		torso16.setRotationPoint(0F, 0F, 0F);
		torso16.setTextureSize(128, 128);
		torso16.mirror = true;
		ATGUtils.setRotation(torso16, 0F, 0F, 0F);

		ModelRenderer gun1 = new ModelRenderer(this, 16, 39);
		gun1.addBox(-2F, 9F, -4F, 4, 3, 2);
		gun1.setRotationPoint(0F, 0F, 0F);
		gun1.setTextureSize(128, 128);
		gun1.mirror = true;
		ATGUtils.setRotation(gun1, 0F, 0F, 0F);

		ModelRenderer gun2 = new ModelRenderer(this, 36, 32);
		gun2.addBox(0F, -2F, -1.2F, 0, 4, 1);
		gun2.setRotationPoint(0F, 10.5F, -3F);
		gun2.setTextureSize(128, 128);
		gun2.mirror = true;
		ATGUtils.setRotation(gun2, 0F, 0F, 2.356194F);

		ModelRenderer gun3 = new ModelRenderer(this, 16, 56);
		gun3.addBox(-3.5F, 11F, -2.7F, 7, 0, 1);
		gun3.setRotationPoint(0F, 0F, 0F);
		gun3.setTextureSize(128, 128);
		gun3.mirror = true;
		ATGUtils.setRotation(gun3, 0F, 0F, 0F);

		ModelRenderer gun4 = new ModelRenderer(this, 22, 32);
		gun4.addBox(-0.5F, 10F, -4.3F, 1, 1, 1);
		gun4.setRotationPoint(0F, 0F, 0F);
		gun4.setTextureSize(128, 128);
		gun4.mirror = true;
		ATGUtils.setRotation(gun4, 0F, 0F, 0F);

		ModelRenderer gun5 = new ModelRenderer(this, 36, 32);
		gun5.addBox(0F, -2F, -1.2F, 0, 4, 1);
		gun5.setRotationPoint(0F, 10.5F, -3F);
		gun5.setTextureSize(128, 128);
		gun5.mirror = true;
		ATGUtils.setRotation(gun5, 0F, 0F, 0F);

		ModelRenderer gun6 = new ModelRenderer(this, 36, 32);
		gun6.addBox(0F, -2F, -1.2F, 0, 4, 1);
		gun6.setRotationPoint(0F, 10.5F, -3F);
		gun6.setTextureSize(128, 128);
		gun6.mirror = true;
		ATGUtils.setRotation(gun6, 0F, 0F, 0.7853982F);

		ModelRenderer gun7 = new ModelRenderer(this, 36, 32);
		gun7.addBox(0F, -2F, -1.2F, 0, 4, 1);
		gun7.setRotationPoint(0F, 10.5F, -3F);
		gun7.setTextureSize(128, 128);
		gun7.mirror = true;
		ATGUtils.setRotation(gun7, 0F, 0F, 1.570796F);

		ModelRenderer gun8 = new ModelRenderer(this, 16, 48);
		gun8.addBox(-1.5F, 8.5F, -4F, 3, 4, 2);
		gun8.setRotationPoint(0F, 0F, 0F);
		gun8.setTextureSize(128, 128);
		gun8.mirror = true;
		ATGUtils.setRotation(gun8, 0F, 0F, 0F);

		ModelRenderer gun9 = new ModelRenderer(this, 16, 36);
		gun9.addBox(3.5F, -2F, 0F, 1, 2, 1);
		gun9.setRotationPoint(0F, 12F, -3.7F);
		gun9.setTextureSize(128, 128);
		gun9.mirror = true;
		ATGUtils.setRotation(gun9, -0.7853982F, 0F, 0F);

		ModelRenderer gun10 = new ModelRenderer(this, 26, 48);
		gun10.addBox(-4.5F, 12F, -3.7F, 9, 1, 1);
		gun10.setRotationPoint(0F, 0F, 0F);
		gun10.setTextureSize(128, 128);
		gun10.mirror = true;
		ATGUtils.setRotation(gun10, 0F, 0F, 0F);

		ModelRenderer gun11 = new ModelRenderer(this, 34, 45);
		gun11.addBox(-4.5F, 9.5F, -2.7F, 1, 2, 1);
		gun11.setRotationPoint(0F, 0F, 0F);
		gun11.setTextureSize(128, 128);
		gun11.mirror = true;
		ATGUtils.setRotation(gun11, 0F, 0F, 0F);

		ModelRenderer gun12 = new ModelRenderer(this, 26, 48);
		gun12.addBox(-4.5F, 8F, -3.7F, 9, 1, 1);
		gun12.setRotationPoint(0F, 0F, 0F);
		gun12.setTextureSize(128, 128);
		gun12.mirror = true;
		ATGUtils.setRotation(gun12, 0F, 0F, 0F);

		ModelRenderer gun13 = new ModelRenderer(this, 16, 36);
		gun13.addBox(-4.5F, -2F, 0F, 1, 2, 1);
		gun13.setRotationPoint(0F, 12F, -3.7F);
		gun13.setTextureSize(128, 128);
		gun13.mirror = true;
		ATGUtils.setRotation(gun13, -0.7853982F, 0F, 0F);

		ModelRenderer gun14 = new ModelRenderer(this, 16, 36);
		gun14.addBox(3.5F, 0F, 0F, 1, 2, 1);
		gun14.setRotationPoint(0F, 9F, -3.7F);
		gun14.setTextureSize(128, 128);
		gun14.mirror = true;
		ATGUtils.setRotation(gun14, 0.7853982F, 0F, 0F);

		ModelRenderer gun15 = new ModelRenderer(this, 16, 36);
		gun15.addBox(-4.5F, 0F, 0F, 1, 2, 1);
		gun15.setRotationPoint(0F, 9F, -3.7F);
		gun15.setTextureSize(128, 128);
		gun15.mirror = true;
		ATGUtils.setRotation(gun15, 0.7853982F, 0F, 0F);

		ModelRenderer gun16 = new ModelRenderer(this, 34, 45);
		gun16.addBox(3.5F, 9.5F, -2.7F, 1, 2, 1);
		gun16.setRotationPoint(0F, 0F, 0F);
		gun16.setTextureSize(128, 128);
		gun16.mirror = true;
		ATGUtils.setRotation(gun16, 0F, 0F, 0F);

		ModelRenderer gun17 = new ModelRenderer(this, 16, 56);
		gun17.addBox(-3.5F, 10F, -2.7F, 7, 0, 1);
		gun17.setRotationPoint(0F, 0F, 0F);
		gun17.setTextureSize(128, 128);
		gun17.mirror = true;
		ATGUtils.setRotation(gun17, 0F, 0F, 0F);

		ModelRenderer rightArm1 = new ModelRenderer(this, 26, 50);
		rightArm1.addBox(-2.5F, -2.5F, -2.5F, 4, 1, 5);
		rightArm1.setRotationPoint(-5F, 2F, 0F);
		rightArm1.setTextureSize(128, 128);
		rightArm1.mirror = true;
		ATGUtils.setRotation(rightArm1, 0F, 0F, -0.1745329F);

		ModelRenderer rightArm2 = new ModelRenderer(this, 0, 32);
		rightArm2.addBox(-2.5F, 3.5F, -2F, 1, 1, 4);
		rightArm2.setRotationPoint(-5F, 2F, 0F);
		rightArm2.setTextureSize(128, 128);
		rightArm2.mirror = true;
		ATGUtils.setRotation(rightArm2, 0F, 0F, 0F);

		ModelRenderer rightArm3 = new ModelRenderer(this, 40, 16);
		rightArm3.addBox(-2F, -2F, -2F, 3, 12, 4);
		rightArm3.setRotationPoint(-5F, 2F, 0F);
		rightArm3.setTextureSize(128, 128);
		rightArm3.mirror = true;
		ATGUtils.setRotation(rightArm3, 0F, 0F, 0F);

		ModelRenderer rightArm4 = new ModelRenderer(this, 0, 32);
		rightArm4.addBox(-2.5F, 1F, -2F, 1, 1, 4);
		rightArm4.setRotationPoint(-5F, 2F, 0F);
		rightArm4.setTextureSize(128, 128);
		rightArm4.mirror = true;
		ATGUtils.setRotation(rightArm4, 0F, 0F, 0F);

		ModelRenderer rightArm5 = new ModelRenderer(this, 0, 32);
		rightArm5.addBox(-2.5F, 7F, -2F, 1, 1, 4);
		rightArm5.setRotationPoint(-5F, 2F, 0F);
		rightArm5.setTextureSize(128, 128);
		rightArm5.mirror = true;
		ATGUtils.setRotation(rightArm5, 0F, 0F, 0F);

		ModelRenderer rightArm6 = new ModelRenderer(this, 54, 16);
		rightArm6.addBox(-2F, 3.5F, -2.5F, 3, 1, 5);
		rightArm6.setRotationPoint(-5F, 2F, 0F);
		rightArm6.setTextureSize(128, 128);
		rightArm6.mirror = true;
		ATGUtils.setRotation(rightArm6, 0F, 0F, 0F);

		ModelRenderer rightArm7 = new ModelRenderer(this, 54, 16);
		rightArm7.addBox(-2F, 1F, -2.5F, 3, 1, 5);
		rightArm7.setRotationPoint(-5F, 2F, 0F);
		rightArm7.setTextureSize(128, 128);
		rightArm7.mirror = true;
		ATGUtils.setRotation(rightArm7, 0F, 0F, 0F);

		ModelRenderer rightArm8 = new ModelRenderer(this, 54, 16);
		rightArm8.addBox(-2F, 7F, -2.5F, 3, 1, 5);
		rightArm8.setRotationPoint(-5F, 2F, 0F);
		rightArm8.setTextureSize(128, 128);
		rightArm8.mirror = true;
		ATGUtils.setRotation(rightArm8, 0F, 0F, 0F);

		ModelRenderer leftArm1 = new ModelRenderer(this, 0, 32);
		leftArm1.addBox(1.5F, 3.5F, -2F, 1, 1, 4);
		leftArm1.setRotationPoint(5F, 2F, 0F);
		leftArm1.setTextureSize(128, 128);
		leftArm1.mirror = true;
		ATGUtils.setRotation(leftArm1, 0F, 0F, 0F);

		ModelRenderer leftArm2 = new ModelRenderer(this, 40, 16);
		leftArm2.addBox(-1F, -2F, -2F, 3, 12, 4);
		leftArm2.setRotationPoint(5F, 2F, 0F);
		leftArm2.setTextureSize(128, 128);
		leftArm2.mirror = true;
		ATGUtils.setRotation(leftArm2, 0F, 0F, 0F);
		leftArm2.mirror = false;

		ModelRenderer leftArm3 = new ModelRenderer(this, 54, 16);
		leftArm3.addBox(-1F, 3.5F, -2.5F, 3, 1, 5);
		leftArm3.setRotationPoint(5F, 2F, 0F);
		leftArm3.setTextureSize(128, 128);
		leftArm3.mirror = true;
		ATGUtils.setRotation(leftArm3, 0F, 0F, 0F);

		ModelRenderer leftArm4 = new ModelRenderer(this, 54, 16);
		leftArm4.addBox(-1F, 7F, -2.5F, 3, 1, 5);
		leftArm4.setRotationPoint(5F, 2F, 0F);
		leftArm4.setTextureSize(128, 128);
		leftArm4.mirror = true;
		ATGUtils.setRotation(leftArm4, 0F, 0F, 0F);

		ModelRenderer leftArm5 = new ModelRenderer(this, 0, 32);
		leftArm5.addBox(1.5F, 7F, -2F, 1, 1, 4);
		leftArm5.setRotationPoint(5F, 2F, 0F);
		leftArm5.setTextureSize(128, 128);
		leftArm5.mirror = true;
		ATGUtils.setRotation(leftArm5, 0F, 0F, 0F);

		ModelRenderer leftArm6 = new ModelRenderer(this, 26, 50);
		leftArm6.addBox(-1.5F, -2.5F, -2.5F, 4, 1, 5);
		leftArm6.setRotationPoint(5F, 2F, 0F);
		leftArm6.setTextureSize(128, 128);
		leftArm6.mirror = true;
		ATGUtils.setRotation(leftArm6, 0F, 0F, 0.1745329F);

		ModelRenderer leftArm7 = new ModelRenderer(this, 0, 32);
		leftArm7.addBox(1.5F, 1F, -2F, 1, 1, 4);
		leftArm7.setRotationPoint(5F, 2F, 0F);
		leftArm7.setTextureSize(128, 128);
		leftArm7.mirror = true;
		ATGUtils.setRotation(leftArm7, 0F, 0F, 0F);

		ModelRenderer leftArm8 = new ModelRenderer(this, 54, 16);
		leftArm8.addBox(-1F, 1F, -2.5F, 3, 1, 5);
		leftArm8.setRotationPoint(5F, 2F, 0F);
		leftArm8.setTextureSize(128, 128);
		leftArm8.mirror = true;
		ATGUtils.setRotation(leftArm8, 0F, 0F, 0F);

		ModelRenderer rightLeg1 = new ModelRenderer(this, 0, 32);
		rightLeg1.addBox(-2.5F, 3.5F, -2F, 1, 1, 4);
		rightLeg1.setRotationPoint(-2F, 12F, 0F);
		rightLeg1.setTextureSize(128, 128);
		rightLeg1.mirror = true;
		ATGUtils.setRotation(rightLeg1, 0F, 0F, 0F);

		ModelRenderer rightLeg2 = new ModelRenderer(this, 0, 16);
		rightLeg2.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightLeg2.setRotationPoint(-2F, 12F, 0F);
		rightLeg2.setTextureSize(128, 128);
		rightLeg2.mirror = true;
		ATGUtils.setRotation(rightLeg2, 0F, 0F, 0F);

		ModelRenderer rightLeg3 = new ModelRenderer(this, 0, 37);
		rightLeg3.addBox(-2F, 11F, -3F, 4, 1, 1);
		rightLeg3.setRotationPoint(-2F, 12F, 0F);
		rightLeg3.setTextureSize(128, 128);
		rightLeg3.mirror = true;
		ATGUtils.setRotation(rightLeg3, 0F, 0F, 0F);

		ModelRenderer rightLeg4 = new ModelRenderer(this, 0, 39);
		rightLeg4.addBox(-2F, 10.5F, -2.5F, 4, 1, 1);
		rightLeg4.setRotationPoint(-2F, 12F, 0F);
		rightLeg4.setTextureSize(128, 128);
		rightLeg4.mirror = true;
		ATGUtils.setRotation(rightLeg4, 0F, 0F, 0F);

		ModelRenderer rightLeg5 = new ModelRenderer(this, 0, 32);
		rightLeg5.addBox(-2.5F, 8.5F, -2F, 1, 1, 4);
		rightLeg5.setRotationPoint(-2F, 12F, 0F);
		rightLeg5.setTextureSize(128, 128);
		rightLeg5.mirror = true;
		ATGUtils.setRotation(rightLeg5, 0F, 0F, 0F);

		ModelRenderer rightLeg6 = new ModelRenderer(this, 64, 9);
		rightLeg6.addBox(-2F, 3.5F, -2.5F, 4, 1, 5);
		rightLeg6.setRotationPoint(-2F, 12F, 0F);
		rightLeg6.setTextureSize(128, 128);
		rightLeg6.mirror = true;
		ATGUtils.setRotation(rightLeg6, 0F, 0F, 0F);

		ModelRenderer rightLeg7 = new ModelRenderer(this, 64, 9);
		rightLeg7.addBox(-2F, 8.5F, -2.5F, 4, 1, 5);
		rightLeg7.setRotationPoint(-2F, 12F, 0F);
		rightLeg7.setTextureSize(128, 128);
		rightLeg7.mirror = true;
		ATGUtils.setRotation(rightLeg7, 0F, 0F, 0F);

		ModelRenderer leftLeg1 = new ModelRenderer(this, 0, 32);
		leftLeg1.addBox(1.5F, 3.5F, -2F, 1, 1, 4);
		leftLeg1.setRotationPoint(2F, 12F, 0F);
		leftLeg1.setTextureSize(128, 128);
		leftLeg1.mirror = true;
		ATGUtils.setRotation(leftLeg1, 0F, 0F, 0F);

		ModelRenderer leftLeg2 = new ModelRenderer(this, 0, 16);
		leftLeg2.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftLeg2.setRotationPoint(2F, 12F, 0F);
		leftLeg2.setTextureSize(128, 128);
		leftLeg2.mirror = true;
		ATGUtils.setRotation(leftLeg2, 0F, 0F, 0F);
		leftLeg2.mirror = false;

		ModelRenderer leftLeg3 = new ModelRenderer(this, 0, 37);
		leftLeg3.addBox(-2F, 11F, -3F, 4, 1, 1);
		leftLeg3.setRotationPoint(2F, 12F, 0F);
		leftLeg3.setTextureSize(128, 128);
		leftLeg3.mirror = true;
		ATGUtils.setRotation(leftLeg3, 0F, 0F, 0F);

		ModelRenderer leftLeg4 = new ModelRenderer(this, 0, 39);
		leftLeg4.addBox(-2F, 10.5F, -2.5F, 4, 1, 1);
		leftLeg4.setRotationPoint(2F, 12F, 0F);
		leftLeg4.setTextureSize(128, 128);
		leftLeg4.mirror = true;
		ATGUtils.setRotation(leftLeg4, 0F, 0F, 0F);

		ModelRenderer leftLeg5 = new ModelRenderer(this, 0, 32);
		leftLeg5.addBox(1.5F, 8.5F, -2F, 1, 1, 4);
		leftLeg5.setRotationPoint(2F, 12F, 0F);
		leftLeg5.setTextureSize(128, 128);
		leftLeg5.mirror = true;
		ATGUtils.setRotation(leftLeg5, 0F, 0F, 0F);

		ModelRenderer leftLeg6 = new ModelRenderer(this, 64, 9);
		leftLeg6.addBox(-2F, 3.5F, -2.5F, 4, 1, 5);
		leftLeg6.setRotationPoint(2F, 12F, 0F);
		leftLeg6.setTextureSize(128, 128);
		leftLeg6.mirror = true;
		ATGUtils.setRotation(leftLeg6, 0F, 0F, 0F);

		ModelRenderer leftLeg7 = new ModelRenderer(this, 64, 9);
		leftLeg7.addBox(-2F, 8.5F, -2.5F, 4, 1, 5);
		leftLeg7.setRotationPoint(2F, 12F, 0F);
		leftLeg7.setTextureSize(128, 128);
		leftLeg7.mirror = true;
		ATGUtils.setRotation(leftLeg7, 0F, 0F, 0F);

		this.bipedHead = new BodyPartHook(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0);
		this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);

		((BodyPartHook) this.bipedHead).setRender(scale -> {
			GlStateManager.pushMatrix();
			ATGUtils.bindTexture(TEX);
			GlStateManager.translate(0F, -0.00F, 0F);
			head1.render(scale);
			head2.render(scale);
			head3.render(scale);
			head4.render(scale);
			head5.render(scale);
			head6.render(scale);
			head7.render(scale);
			head8.render(scale);
			head9.render(scale);
			head10.render(scale);
			head11.render(scale);
			head12.render(scale);
			head13.render(scale);
			head14.render(scale);
			head15.render(scale);
			head16.render(scale);
			head17.render(scale);
			head18.render(scale);
			head19.render(scale);
			head20.render(scale);
			head21.render(scale);
			head22.render(scale);
			head23.render(scale);
			head24.render(scale);
			head25.render(scale);
			head26.render(scale);
			head27.render(scale);
			head28.render(scale);
			head29.render(scale);
			head30.render(scale);
			head31.render(scale);
			head32.render(scale);
			head33.render(scale);
			head34.render(scale);
			head35.render(scale);
			head36.render(scale);
			head37.render(scale);
			head38.render(scale);
			head39.render(scale);
			head40.render(scale);
			head41.render(scale);
			head42.render(scale);
			head43.render(scale);
			head44.render(scale);
			head45.render(scale);
			head46.render(scale);
			GlStateManager.popMatrix();
		});

		bipedBody = new BodyPartHook(this, 16, 16);
		bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);

		((BodyPartHook) bipedBody).setRender(scale -> {
			GlStateManager.pushMatrix();
			GlStateManager.translate(0F, -0.05F, 0F);
			ATGUtils.bindTexture(TEX);
			torso1.render(scale);
			torso2.render(scale);
			torso3.render(scale);
			torso4.render(scale);
			torso5.render(scale);
			torso6.render(scale);
			torso7.render(scale);
			torso8.render(scale);
			torso9.render(scale);
			torso10.render(scale);
			torso11.render(scale);
			torso12.render(scale);
			torso13.render(scale);
			torso14.render(scale);
			torso15.render(scale);
			torso16.render(scale);
			gun1.render(scale);
			gun2.render(scale);
			gun3.render(scale);
			gun4.render(scale);
			gun5.render(scale);
			gun6.render(scale);
			gun7.render(scale);
			gun8.render(scale);
			gun9.render(scale);
			gun10.render(scale);
			gun11.render(scale);
			gun12.render(scale);
			gun13.render(scale);
			gun14.render(scale);
			gun15.render(scale);
			gun16.render(scale);
			gun17.render(scale);
			GlStateManager.popMatrix();
		});

		this.bipedLeftArm = new BodyPartHook(this, 40, 16);
		this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0);
		this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);

		((BodyPartHook) bipedLeftArm).setRender(scale -> {
			GlStateManager.pushMatrix();
			GlStateManager.translate(-0.32, -0.05F, 0);
			ATGUtils.bindTexture(TEX);
			leftArm1.render(scale);
			leftArm2.render(scale);
			leftArm3.render(scale);
			leftArm4.render(scale);
			leftArm5.render(scale);
			leftArm6.render(scale);
			leftArm7.render(scale);
			leftArm8.render(scale);
			GlStateManager.popMatrix();
		});

		this.bipedRightArm = new BodyPartHook(this, 40, 16);
		this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0);
		this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);

		((BodyPartHook) bipedRightArm).setRender(scale -> {
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.32, -0.05F, 0);
			ATGUtils.bindTexture(TEX);
			rightArm1.render(scale);
			rightArm2.render(scale);
			rightArm3.render(scale);
			rightArm4.render(scale);
			rightArm5.render(scale);
			rightArm6.render(scale);
			rightArm7.render(scale);
			rightArm8.render(scale);
			GlStateManager.popMatrix();
		});

		this.bipedRightLeg = new BodyPartHook(this, 0, 16);
		this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0);
		this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);

		((BodyPartHook) bipedRightLeg).setRender(scale -> {
			GlStateManager.pushMatrix();
			// Old 0.90
			GlStateManager.translate(0.11, -0.80F, 0F);
			ATGUtils.bindTexture(TEX);
			rightLeg1.render(scale);
			rightLeg2.render(scale);
			rightLeg3.render(scale);
			rightLeg4.render(scale);
			rightLeg5.render(scale);
			rightLeg6.render(scale);
			rightLeg7.render(scale);
			GlStateManager.popMatrix();
		});

		this.bipedLeftLeg = new BodyPartHook(this, 0, 16);
		this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0);
		this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);

		((BodyPartHook) bipedLeftLeg).setRender(scale -> {
			GlStateManager.pushMatrix();
			GlStateManager.translate(-0.11, -0.80F, 0F);
			ATGUtils.bindTexture(TEX);
			leftLeg1.render(scale);
			leftLeg2.render(scale);
			leftLeg3.render(scale);
			leftLeg4.render(scale);
			leftLeg5.render(scale);
			leftLeg6.render(scale);
			leftLeg7.render(scale);
			GlStateManager.popMatrix();
		});

	}

	@Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float scale) {
		super.render(entity, f, f1, f2, f3, f4, scale);
		setRotationAngles(f, f1, f2, f3, f4, scale, entity);
	}

	@Override public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netheadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netheadYaw, headPitch, scaleFactor, entityIn);
	}

}
