package com.lcm.doctorwho.client.models.entity.angels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWeepingAngel extends ModelBase {
	ModelRenderer InnerChin;
	ModelRenderer Torso1;
	ModelRenderer RightArm;
	ModelRenderer LeftArm;
	ModelRenderer Teeth;
	ModelRenderer Torso2;
	ModelRenderer Torso3;
	ModelRenderer Torso4;
	ModelRenderer Torso5;
	ModelRenderer Torso6;
	ModelRenderer Torso7;
	ModelRenderer Torso8;
	ModelRenderer body1;
	ModelRenderer body2;
	ModelRenderer body3;
	ModelRenderer body4;
	ModelRenderer body5;
	ModelRenderer body6;
	ModelRenderer body7;
	ModelRenderer body8;
	ModelRenderer body9;
	ModelRenderer body10;
	ModelRenderer body11;
	ModelRenderer body12;
	ModelRenderer body13;
	ModelRenderer body14;
	ModelRenderer body15;
	ModelRenderer body16;
	ModelRenderer body17;
	ModelRenderer body18;
	ModelRenderer body19;
	ModelRenderer body20;
	ModelRenderer body21;
	ModelRenderer body22;
	ModelRenderer body23;
	ModelRenderer body24;
	ModelRenderer body25;
	ModelRenderer body26;
	ModelRenderer body27;
	ModelRenderer body28;
	ModelRenderer body29;
	ModelRenderer body30;
	ModelRenderer body31;
	ModelRenderer body33;
	ModelRenderer body338;
	ModelRenderer body34;
	ModelRenderer body35;
	ModelRenderer body36;
	ModelRenderer body37;
	ModelRenderer body38;
	ModelRenderer body39;
	ModelRenderer body40;
	ModelRenderer body41;
	ModelRenderer body42;
	ModelRenderer head1;
	ModelRenderer head2;
	ModelRenderer head3;
	ModelRenderer head4;
	ModelRenderer head5;
	ModelRenderer head6;
	ModelRenderer head7;
	ModelRenderer head8;
	ModelRenderer head9;
	ModelRenderer head10;
	ModelRenderer head11;
	ModelRenderer head12;
	ModelRenderer head13;
	ModelRenderer head14;
	ModelRenderer head15;
	ModelRenderer head16;
	ModelRenderer head17;
	ModelRenderer head18;
	ModelRenderer head19;
	ModelRenderer head20;
	ModelRenderer head21;
	ModelRenderer head22;
	ModelRenderer head23;
	ModelRenderer head24;
	ModelRenderer head25;
	ModelRenderer head26;

	public ModelWeepingAngel() {
		textureWidth = 128;
		textureHeight = 128;

		InnerChin = new ModelRenderer(this, 26, 48);
		InnerChin.addBox(-4F, -1F, -3F, 8, 1, 7);
		InnerChin.setRotationPoint(0F, 0F, 0F);
		InnerChin.setTextureSize(128, 128);
		InnerChin.mirror = true;
		setRotation(InnerChin, 0F, 0F, 0F);
		Torso1 = new ModelRenderer(this, 0, 16);
		Torso1.addBox(-2F, 1F, 1.4F, 4, 7, 1);
		Torso1.setRotationPoint(0F, 0F, 0F);
		Torso1.setTextureSize(128, 128);
		Torso1.mirror = true;
		setRotation(Torso1, 0F, 0F, 0F);
		RightArm = new ModelRenderer(this, 40, 16);
		RightArm.addBox(-2F, -2F, -2F, 3, 12, 4);
		RightArm.setRotationPoint(-5F, 2F, 0F);
		RightArm.setTextureSize(128, 128);
		RightArm.mirror = true;
		setRotation(RightArm, -1.361357F, 0F, 0F);
		// LeftArm.mirror = true;
		LeftArm = new ModelRenderer(this, 40, 16);
		LeftArm.addBox(-1F, -2F, -2F, 3, 12, 4);
		LeftArm.setRotationPoint(5F, 2F, 0F);
		LeftArm.setTextureSize(128, 128);
		LeftArm.mirror = true;
		setRotation(LeftArm, -1.500983F, 0F, -0.2094395F);
		LeftArm.mirror = false;
		Teeth = new ModelRenderer(this, 30, 32);
		Teeth.addBox(-1F, -1.5F, -3.8F, 2, 1, 1);
		Teeth.setRotationPoint(0F, 0F, 0F);
		Teeth.setTextureSize(128, 128);
		Teeth.mirror = true;
		setRotation(Teeth, 0F, 0F, 0F);
		Torso2 = new ModelRenderer(this, 63, 37);
		Torso2.addBox(-4F, 9F, 1F, 8, 14, 1);
		Torso2.setRotationPoint(0F, 0F, 0F);
		Torso2.setTextureSize(128, 128);
		Torso2.mirror = true;
		setRotation(Torso2, 0.0349066F, 0F, 0F);
		Torso3 = new ModelRenderer(this, 58, 16);
		Torso3.addBox(-2F, 5F, 1.5F, 1, 4, 1);
		Torso3.setRotationPoint(0F, 0F, 0F);
		Torso3.setTextureSize(128, 128);
		Torso3.mirror = true;
		setRotation(Torso3, 0F, 0F, 0F);
		Torso4 = new ModelRenderer(this, 64, 16);
		Torso4.addBox(2F, 0F, 1.4F, 2, 8, 1);
		Torso4.setRotationPoint(0F, 0F, 0F);
		Torso4.setTextureSize(128, 128);
		Torso4.mirror = true;
		setRotation(Torso4, 0F, 0F, 0F);
		Torso5 = new ModelRenderer(this, 64, 16);
		Torso5.addBox(-4F, 0F, 1.4F, 2, 8, 1);
		Torso5.setRotationPoint(0F, 0F, 0F);
		Torso5.setTextureSize(128, 128);
		Torso5.mirror = true;
		setRotation(Torso5, 0F, 0F, 0F);
		Torso6 = new ModelRenderer(this, 40, 11);
		Torso6.addBox(-4F, 8F, 1.6F, 2, 1, 1);
		Torso6.setRotationPoint(0F, 0F, 0F);
		Torso6.setTextureSize(128, 128);
		Torso6.mirror = true;
		setRotation(Torso6, 0F, 0F, 0F);
		Torso7 = new ModelRenderer(this, 40, 11);
		Torso7.addBox(-1F, 8F, 1.6F, 2, 1, 1);
		Torso7.setRotationPoint(0F, 0F, 0F);
		Torso7.setTextureSize(128, 128);
		Torso7.mirror = true;
		setRotation(Torso7, 0F, 0F, 0F);
		Torso8 = new ModelRenderer(this, 40, 11);
		Torso8.addBox(2F, 8F, 1.6F, 2, 1, 1);
		Torso8.setRotationPoint(0F, 0F, 0F);
		Torso8.setTextureSize(128, 128);
		Torso8.mirror = true;
		setRotation(Torso8, 0F, 0F, 0F);
		body1 = new ModelRenderer(this, 48, 9);
		body1.addBox(1F, 6F, 1.5F, 1, 3, 1);
		body1.setRotationPoint(0F, 0F, 0F);
		body1.setTextureSize(128, 128);
		body1.mirror = true;
		setRotation(body1, 0F, 0F, 0F);
		body2 = new ModelRenderer(this, 58, 16);
		body2.addBox(1F, 5F, -2.5F, 1, 4, 1);
		body2.setRotationPoint(0F, 0F, 0F);
		body2.setTextureSize(128, 128);
		body2.mirror = true;
		setRotation(body2, 0F, 0F, 0F);
		body3 = new ModelRenderer(this, 50, 0);
		body3.addBox(-2F, 4F, -2.5F, 1, 5, 1);
		body3.setRotationPoint(0F, 0F, 0F);
		body3.setTextureSize(128, 128);
		body3.mirror = true;
		setRotation(body3, 0F, 0F, 0F);
		body4 = new ModelRenderer(this, 40, 11);
		body4.addBox(-4F, 8F, -2.6F, 2, 1, 1);
		body4.setRotationPoint(0F, 0F, 0F);
		body4.setTextureSize(128, 128);
		body4.mirror = true;
		setRotation(body4, 0F, 0F, 0F);
		body5 = new ModelRenderer(this, 40, 11);
		body5.addBox(-1F, 8F, -2.6F, 2, 1, 1);
		body5.setRotationPoint(0F, 0F, 0F);
		body5.setTextureSize(128, 128);
		body5.mirror = true;
		setRotation(body5, 0F, 0F, 0F);
		body6 = new ModelRenderer(this, 72, 16);
		body6.addBox(-4.2F, 8F, -2.5F, 1, 1, 5);
		body6.setRotationPoint(0F, 0F, 0F);
		body6.setTextureSize(128, 128);
		body6.mirror = true;
		setRotation(body6, 0F, 0F, 0F);
		body7 = new ModelRenderer(this, 64, 16);
		body7.addBox(2F, 0F, -2.4F, 2, 8, 1);
		body7.setRotationPoint(0F, 0F, 0F);
		body7.setTextureSize(128, 128);
		body7.mirror = true;
		setRotation(body7, 0F, 0F, 0F);
		body8 = new ModelRenderer(this, 64, 16);
		body8.addBox(-4F, 0F, -2.4F, 2, 8, 1);
		body8.setRotationPoint(0F, 0F, 0F);
		body8.setTextureSize(128, 128);
		body8.mirror = true;
		setRotation(body8, 0F, 0F, 0F);
		body9 = new ModelRenderer(this, 16, 16);
		body9.addBox(-4F, 0F, -2F, 8, 9, 4);
		body9.setRotationPoint(0F, 0F, 0F);
		body9.setTextureSize(128, 128);
		body9.mirror = true;
		setRotation(body9, 0F, 0F, 0F);
		body10 = new ModelRenderer(this, 56, 27);
		body10.addBox(-4F, 22F, -3F, 8, 1, 6);
		body10.setRotationPoint(0F, 0F, 0F);
		body10.setTextureSize(128, 128);
		body10.mirror = true;
		setRotation(body10, 0F, 0F, 0F);
		body11 = new ModelRenderer(this, 87, 16);
		body11.addBox(1F, 14F, 1.2F, 1, 9, 1);
		body11.setRotationPoint(0F, 0F, 0F);
		body11.setTextureSize(128, 128);
		body11.mirror = true;
		setRotation(body11, 0.0349066F, 0F, 0F);
		body12 = new ModelRenderer(this, 0, 49);
		body12.addBox(-4F, 9F, -2F, 8, 14, 4);
		body12.setRotationPoint(0F, 0F, 0F);
		body12.setTextureSize(128, 128);
		body12.mirror = true;
		setRotation(body12, 0F, 0F, 0F);
		body13 = new ModelRenderer(this, 87, 16);
		body13.addBox(-3F, 12F, 1.2F, 1, 11, 1);
		body13.setRotationPoint(0F, 0F, 0F);
		body13.setTextureSize(128, 128);
		body13.mirror = true;
		setRotation(body13, 0.0349066F, 0F, 0F);
		body14 = new ModelRenderer(this, 87, 16);
		body14.addBox(-1F, 10F, -2.2F, 1, 13, 1);
		body14.setRotationPoint(0F, 0F, 0F);
		body14.setTextureSize(128, 128);
		body14.mirror = true;
		setRotation(body14, -0.0349066F, 0F, 0F);
		body15 = new ModelRenderer(this, 87, 16);
		body15.addBox(1F, 15F, -2.2F, 1, 8, 1);
		body15.setRotationPoint(0F, 0F, 0F);
		body15.setTextureSize(128, 128);
		body15.mirror = true;
		setRotation(body15, -0.0349066F, 0F, 0F);
		body16 = new ModelRenderer(this, 40, 11);
		body16.addBox(2F, 8F, -2.6F, 2, 1, 1);
		body16.setRotationPoint(0F, 0F, 0F);
		body16.setTextureSize(128, 128);
		body16.mirror = true;
		setRotation(body16, 0F, 0F, 0F);
		body17 = new ModelRenderer(this, 72, 16);
		body17.addBox(3.2F, 8F, -2.5F, 1, 1, 5);
		body17.setRotationPoint(0F, 0F, 0F);
		body17.setTextureSize(128, 128);
		body17.mirror = true;
		setRotation(body17, 0F, 0F, 0F);
		body18 = new ModelRenderer(this, 63, 37);
		body18.addBox(-4F, 9F, -2F, 8, 14, 1);
		body18.setRotationPoint(0F, 0F, 0F);
		body18.setTextureSize(128, 128);
		body18.mirror = true;
		setRotation(body18, -0.0349066F, 0F, 0F);
		body19 = new ModelRenderer(this, 87, 16);
		body19.addBox(-3F, 13F, -2.2F, 1, 10, 1);
		body19.setRotationPoint(0F, 0F, 0F);
		body19.setTextureSize(128, 128);
		body19.mirror = true;
		setRotation(body19, -0.0349066F, 0F, 0F);
		body20 = new ModelRenderer(this, 0, 38);
		body20.addBox(-4F, 23F, -3.5F, 8, 1, 7);
		body20.setRotationPoint(0F, 0F, 0F);
		body20.setTextureSize(128, 128);
		body20.mirror = true;
		setRotation(body20, 0F, 0F, 0F);
		body21 = new ModelRenderer(this, 0, 26);
		body21.addBox(-4.1F, 22F, -3F, 1, 1, 6);
		body21.setRotationPoint(0F, 0F, 0F);
		body21.setTextureSize(128, 128);
		body21.mirror = true;
		setRotation(body21, 0F, 0F, 0F);
		body22 = new ModelRenderer(this, 31, 38);
		body22.addBox(-4.5F, 23F, -3F, 9, 1, 6);
		body22.setRotationPoint(0F, 0F, 0F);
		body22.setTextureSize(128, 128);
		body22.mirror = true;
		setRotation(body22, 0F, 0F, 0F);
		body23 = new ModelRenderer(this, 87, 16);
		body23.addBox(-4.1F, 11F, 0F, 1, 11, 1);
		body23.setRotationPoint(0F, 0F, 0F);
		body23.setTextureSize(128, 128);
		body23.mirror = true;
		setRotation(body23, 0F, 0F, 0F);
		body24 = new ModelRenderer(this, 0, 26);
		body24.addBox(3.1F, 22F, -3F, 1, 1, 6);
		body24.setRotationPoint(0F, 0F, 0F);
		body24.setTextureSize(128, 128);
		body24.mirror = true;
		setRotation(body24, 0F, 0F, 0F);
		body25 = new ModelRenderer(this, 87, 16);
		body25.addBox(3.1F, 12F, -1F, 1, 10, 1);
		body25.setRotationPoint(0F, 0F, 0F);
		body25.setTextureSize(128, 128);
		body25.mirror = true;
		setRotation(body25, 0F, 0F, 0F);
		body26 = new ModelRenderer(this, 0, 16);
		body26.addBox(-2F, 1F, -2.4F, 4, 7, 1);
		body26.setRotationPoint(0F, 0F, 0F);
		body26.setTextureSize(128, 128);
		body26.mirror = true;
		setRotation(body26, 0F, 0F, 0F);
		body27 = new ModelRenderer(this, 95, 0);
		body27.addBox(-5F, 1F, -0.5F, 3, 7, 1);
		body27.setRotationPoint(0F, 0F, 0F);
		body27.setTextureSize(128, 128);
		body27.mirror = true;
		setRotation(body27, 0F, 2.356194F, 0F);
		body28 = new ModelRenderer(this, 94, 16);
		body28.addBox(-6F, 0F, -0.5F, 1, 9, 1);
		body28.setRotationPoint(0F, 0F, 0F);
		body28.setTextureSize(128, 128);
		body28.mirror = true;
		setRotation(body28, 0F, 2.356194F, 0F);
		body29 = new ModelRenderer(this, 100, 16);
		body29.addBox(-7F, -1F, -0.5F, 1, 11, 1);
		body29.setRotationPoint(0F, 0F, 0F);
		body29.setTextureSize(128, 128);
		body29.mirror = true;
		setRotation(body29, 0F, 2.356194F, 0F);
		body30 = new ModelRenderer(this, 105, 16);
		body30.addBox(-8F, -3F, -0.5F, 1, 15, 1);
		body30.setRotationPoint(0F, 0F, 0F);
		body30.setTextureSize(128, 128);
		body30.mirror = true;
		setRotation(body30, 0F, 2.356194F, 0F);
		body31 = new ModelRenderer(this, 110, 15);
		body31.addBox(-9F, -4F, -0.5F, 1, 18, 1);
		body31.setRotationPoint(0F, 0F, 0F);
		body31.setTextureSize(128, 128);
		body31.mirror = true;
		setRotation(body31, 0F, 2.356194F, 0F);
		body33 = new ModelRenderer(this, 115, 14);
		body33.addBox(-10F, -4F, -0.5F, 1, 20, 1);
		body33.setRotationPoint(0F, 0F, 0F);
		body33.setTextureSize(128, 128);
		body33.mirror = true;
		setRotation(body33, 0F, 2.356194F, 0F);
		body338 = new ModelRenderer(this, 120, 16);
		body338.addBox(-11F, -3F, -0.5F, 1, 18, 1);
		body338.setRotationPoint(0F, 0F, 0F);
		body338.setTextureSize(128, 128);
		body338.mirror = true;
		setRotation(body338, 0F, 2.356194F, 0F);
		body34 = new ModelRenderer(this, 83, 47);
		body34.addBox(-12F, -2F, -0.5F, 1, 14, 1);
		body34.setRotationPoint(0F, 0F, 0F);
		body34.setTextureSize(128, 128);
		body34.mirror = true;
		setRotation(body34, 0F, 2.356194F, 0F);
		body35 = new ModelRenderer(this, 95, 0);
		body35.addBox(-5F, 1F, -0.5F, 3, 7, 1);
		body35.setRotationPoint(0F, 0F, 0F);
		body35.setTextureSize(128, 128);
		body35.mirror = true;
		setRotation(body35, 0F, 0.7853982F, 0F);
		body36 = new ModelRenderer(this, 94, 16);
		body36.addBox(-6F, 0F, -0.5F, 1, 9, 1);
		body36.setRotationPoint(0F, 0F, 0F);
		body36.setTextureSize(128, 128);
		body36.mirror = true;
		setRotation(body36, 0F, 0.7853982F, 0F);
		body37 = new ModelRenderer(this, 100, 16);
		body37.addBox(-7F, -1F, -0.5F, 1, 11, 1);
		body37.setRotationPoint(0F, 0F, 0F);
		body37.setTextureSize(128, 128);
		body37.mirror = true;
		setRotation(body37, 0F, 0.7853982F, 0F);
		body38 = new ModelRenderer(this, 105, 16);
		body38.addBox(-8F, -3F, -0.5F, 1, 15, 1);
		body38.setRotationPoint(0F, 0F, 0F);
		body38.setTextureSize(128, 128);
		body38.mirror = true;
		setRotation(body38, 0F, 0.7853982F, 0F);
		body39 = new ModelRenderer(this, 110, 15);
		body39.addBox(-9F, -4F, -0.5F, 1, 18, 1);
		body39.setRotationPoint(0F, 0F, 0F);
		body39.setTextureSize(128, 128);
		body39.mirror = true;
		setRotation(body39, 0F, 0.7853982F, 0F);
		body40 = new ModelRenderer(this, 115, 14);
		body40.addBox(-10F, -4F, -0.5F, 1, 20, 1);
		body40.setRotationPoint(0F, 0F, 0F);
		body40.setTextureSize(128, 128);
		body40.mirror = true;
		setRotation(body40, 0F, 0.7853982F, 0F);
		body41 = new ModelRenderer(this, 120, 16);
		body41.addBox(-11F, -3F, -0.5F, 1, 18, 1);
		body41.setRotationPoint(0F, 0F, 0F);
		body41.setTextureSize(128, 128);
		body41.mirror = true;
		setRotation(body41, 0F, 0.7853982F, 0F);
		body42 = new ModelRenderer(this, 83, 47);
		body42.addBox(-12F, -2F, -0.5F, 1, 14, 1);
		body42.setRotationPoint(0F, 0F, 0F);
		body42.setTextureSize(128, 128);
		body42.mirror = true;
		setRotation(body42, 0F, 0.7853982F, 0F);
		head1 = new ModelRenderer(this, 106, 0);
		head1.addBox(-2.5F, -5.7F, -4.3F, 4, 1, 1);
		head1.setRotationPoint(0F, 0F, 0F);
		head1.setTextureSize(128, 128);
		head1.mirror = true;
		setRotation(head1, 0F, 0F, 0F);
		head2 = new ModelRenderer(this, 16, 31);
		head2.addBox(-4F, -1F, -4F, 3, 1, 1);
		head2.setRotationPoint(0F, 0F, 0F);
		head2.setTextureSize(128, 128);
		head2.mirror = true;
		setRotation(head2, 0F, 0F, 0F);
		head3 = new ModelRenderer(this, 16, 31);
		head3.addBox(1F, -1F, -4F, 3, 1, 1);
		head3.setRotationPoint(0F, 0F, 0F);
		head3.setTextureSize(128, 128);
		head3.mirror = true;
		setRotation(head3, 0F, 0F, 0F);
		head4 = new ModelRenderer(this, 0, 69);
		head4.addBox(-2F, -0.5F, -4F, 4, 1, 1);
		head4.setRotationPoint(0F, 0F, 0F);
		head4.setTextureSize(128, 128);
		head4.mirror = true;
		setRotation(head4, 0F, 0F, 0F);
		head5 = new ModelRenderer(this, 111, 9);
		head5.addBox(-0.7F, -0.8F, 2F, 5, 1, 2);
		head5.setRotationPoint(0F, 0F, 0F);
		head5.setTextureSize(128, 128);
		head5.mirror = true;
		setRotation(head5, 0F, 0F, 0F);
		head6 = new ModelRenderer(this, 84, 36);
		head6.addBox(-4.5F, -6.5F, -6F, 9, 1, 9);
		head6.setRotationPoint(0F, 0F, 0F);
		head6.setTextureSize(128, 128);
		head6.mirror = true;
		setRotation(head6, -0.2617994F, 0F, 0F);
		head7 = new ModelRenderer(this, 33, 0);
		head7.addBox(2F, -6F, -4.3F, 2, 1, 1);
		head7.setRotationPoint(0F, 0F, 0F);
		head7.setTextureSize(128, 128);
		head7.mirror = true;
		setRotation(head7, 0F, 0F, 0F);
		head8 = new ModelRenderer(this, 33, 0);
		head8.addBox(-4F, -6F, -4.3F, 2, 1, 1);
		head8.setRotationPoint(0F, 0F, 0F);
		head8.setTextureSize(128, 128);
		head8.mirror = true;
		setRotation(head8, 0F, 0F, 0F);
		head9 = new ModelRenderer(this, 33, 4);
		head9.addBox(-4.3F, -6F, -4F, 1, 1, 2);
		head9.setRotationPoint(0F, 0F, 0F);
		head9.setTextureSize(128, 128);
		head9.mirror = true;
		setRotation(head9, 0F, 0F, 0F);
		head10 = new ModelRenderer(this, 43, 33);
		head10.addBox(-4.3F, -0.8F, 2F, 4, 1, 2);
		head10.setRotationPoint(0F, 0F, 0F);
		head10.setTextureSize(128, 128);
		head10.mirror = true;
		setRotation(head10, 0F, 0F, 0F);
		head11 = new ModelRenderer(this, 33, 4);
		head11.addBox(-4.3F, -5F, -2F, 1, 1, 2);
		head11.setRotationPoint(0F, 0F, 0F);
		head11.setTextureSize(128, 128);
		head11.mirror = true;
		setRotation(head11, 0F, 0F, 0F);
		head12 = new ModelRenderer(this, 106, 5);
		head12.addBox(-4.3F, -4F, 0F, 1, 2, 1);
		head12.setRotationPoint(0F, 0F, 0F);
		head12.setTextureSize(128, 128);
		head12.mirror = true;
		setRotation(head12, 0F, 0F, 0F);
		head13 = new ModelRenderer(this, 33, 0);
		head13.addBox(0.5F, -5.5F, -4.3F, 2, 1, 1);
		head13.setRotationPoint(0F, 0F, 0F);
		head13.setTextureSize(128, 128);
		head13.mirror = true;
		setRotation(head13, 0F, 0F, 0F);
		head14 = new ModelRenderer(this, 57, 0);
		head14.addBox(-4F, -6.5F, -6.5F, 8, 1, 10);
		head14.setRotationPoint(0F, 0F, 0F);
		head14.setTextureSize(128, 128);
		head14.mirror = true;
		setRotation(head14, -0.2617994F, 0F, 0F);
		head15 = new ModelRenderer(this, 0, 0);
		head15.addBox(-4F, -8F, -4F, 8, 7, 8);
		head15.setRotationPoint(0F, 0F, 0F);
		head15.setTextureSize(128, 128);
		head15.mirror = true;
		setRotation(head15, 0F, 0F, 0F);
		head16 = new ModelRenderer(this, 111, 9);
		head16.addBox(-0.7F, -0.8F, 2.2F, 5, 1, 2);
		head16.setRotationPoint(0F, 0F, 0F);
		head16.setTextureSize(128, 128);
		head16.mirror = true;
		setRotation(head16, 0F, 0F, 0F);
		head17 = new ModelRenderer(this, 43, 33);
		head17.addBox(-4.3F, -0.8F, 2.2F, 4, 1, 2);
		head17.setRotationPoint(0F, 0F, 0F);
		head17.setTextureSize(128, 128);
		head17.mirror = true;
		setRotation(head17, 0F, 0F, 0F);
		head18 = new ModelRenderer(this, 106, 5);
		head18.addBox(-4.3F, -1.5F, 1.5F, 1, 1, 1);
		head18.setRotationPoint(0F, 0F, 0F);
		head18.setTextureSize(128, 128);
		head18.mirror = true;
		setRotation(head18, 0F, 0F, 0F);
		head19 = new ModelRenderer(this, 106, 5);
		head19.addBox(-4.3F, -5F, -3F, 1, 2, 1);
		head19.setRotationPoint(0F, 0F, 0F);
		head19.setTextureSize(128, 128);
		head19.mirror = true;
		setRotation(head19, 0F, 0F, 0F);
		head20 = new ModelRenderer(this, 106, 5);
		head20.addBox(-4.3F, -2F, 1F, 1, 1, 1);
		head20.setRotationPoint(0F, 0F, 0F);
		head20.setTextureSize(128, 128);
		head20.mirror = true;
		setRotation(head20, 0F, 0F, 0F);
		head21 = new ModelRenderer(this, 106, 5);
		head21.addBox(3.3F, -1.5F, 1.5F, 1, 1, 1);
		head21.setRotationPoint(0F, 0F, 0F);
		head21.setTextureSize(128, 128);
		head21.mirror = true;
		setRotation(head21, 0F, 0F, 0F);
		head22 = new ModelRenderer(this, 106, 5);
		head22.addBox(3.3F, -2F, 1F, 1, 1, 1);
		head22.setRotationPoint(0F, 0F, 0F);
		head22.setTextureSize(128, 128);
		head22.mirror = true;
		setRotation(head22, 0F, 0F, 0F);
		head23 = new ModelRenderer(this, 106, 5);
		head23.addBox(3.3F, -4F, 0F, 1, 2, 1);
		head23.setRotationPoint(0F, 0F, 0F);
		head23.setTextureSize(128, 128);
		head23.mirror = true;
		setRotation(head23, 0F, 0F, 0F);
		head24 = new ModelRenderer(this, 33, 4);
		head24.addBox(3.3F, -5F, -2F, 1, 1, 2);
		head24.setRotationPoint(0F, 0F, 0F);
		head24.setTextureSize(128, 128);
		head24.mirror = true;
		setRotation(head24, 0F, 0F, 0F);
		head25 = new ModelRenderer(this, 106, 5);
		head25.addBox(3.3F, -5F, -3F, 1, 2, 1);
		head25.setRotationPoint(0F, 0F, 0F);
		head25.setTextureSize(128, 128);
		head25.mirror = true;
		setRotation(head25, 0F, 0F, 0F);
		head26 = new ModelRenderer(this, 33, 4);
		head26.addBox(3.3F, -6F, -4F, 1, 1, 2);
		head26.setRotationPoint(0F, 0F, 0F);
		head26.setTextureSize(128, 128);
		head26.mirror = true;
		setRotation(head26, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		InnerChin.render(scale);
		Torso1.render(scale);
		RightArm.render(scale);
		LeftArm.render(scale);
		Teeth.render(scale);
		Torso2.render(scale);
		Torso3.render(scale);
		Torso4.render(scale);
		Torso5.render(scale);
		Torso6.render(scale);
		Torso7.render(scale);
		Torso8.render(scale);
		body1.render(scale);
		body2.render(scale);
		body3.render(scale);
		body4.render(scale);
		body5.render(scale);
		body6.render(scale);
		body7.render(scale);
		body8.render(scale);
		body9.render(scale);
		body10.render(scale);
		body11.render(scale);
		body12.render(scale);
		body13.render(scale);
		body14.render(scale);
		body15.render(scale);
		body16.render(scale);
		body17.render(scale);
		body18.render(scale);
		body19.render(scale);
		body20.render(scale);
		body21.render(scale);
		body22.render(scale);
		body23.render(scale);
		body24.render(scale);
		body25.render(scale);
		body26.render(scale);
		body27.render(scale);
		body28.render(scale);
		body29.render(scale);
		body30.render(scale);
		body31.render(scale);
		body33.render(scale);
		body33.render(scale);
		body34.render(scale);
		body35.render(scale);
		body36.render(scale);
		body37.render(scale);
		body38.render(scale);
		body39.render(scale);
		body40.render(scale);
		body41.render(scale);
		body42.render(scale);
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
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}