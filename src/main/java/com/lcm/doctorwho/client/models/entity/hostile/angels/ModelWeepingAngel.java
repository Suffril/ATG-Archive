package com.lcm.doctorwho.client.models.entity.hostile.angels;

import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import java.util.ArrayList;

public class ModelWeepingAngel extends ModelBase {

	private ArrayList<ModelRenderer> boxes = new ArrayList<>();

	public ModelWeepingAngel() {
		textureWidth = 128;
		textureHeight = 128;
		
		ModelRenderer innerChin = new ModelRenderer(this, 26, 48);
		innerChin.addBox(-4F, -1F, -3F, 8, 1, 7);
		innerChin.setRotationPoint(0F, 0F, 0F);
		innerChin.mirror = true;
		ATGUtils.setRotation(innerChin, 0F, 0F, 0F);
		boxes.add(innerChin);

		ModelRenderer torso1 = new ModelRenderer(this, 0, 16);
		torso1.addBox(-2F, 1F, 1.4F, 4, 7, 1);
		torso1.setRotationPoint(0F, 0F, 0F);
		torso1.mirror = true;
		ATGUtils.setRotation(torso1, 0F, 0F, 0F);
		boxes.add(torso1);

		ModelRenderer rightArm = new ModelRenderer(this, 40, 16);
		rightArm.addBox(-2F, -2F, -2F, 3, 12, 4);
		rightArm.setRotationPoint(-5F, 2F, 0F);
		rightArm.mirror = true;
		ATGUtils.setRotation(rightArm, -1.361357F, 0F, 0F);
		boxes.add(rightArm);

		ModelRenderer leftArm = new ModelRenderer(this, 40, 16);
		leftArm.addBox(-1F, -2F, -2F, 3, 12, 4);
		leftArm.setRotationPoint(5F, 2F, 0F);
		ATGUtils.setRotation(leftArm, -1.500983F, 0F, -0.2094395F);
		boxes.add(leftArm);

		ModelRenderer teeth = new ModelRenderer(this, 30, 32);
		teeth.addBox(-1F, -1.5F, -3.8F, 2, 1, 1);
		teeth.setRotationPoint(0F, 0F, 0F);
		teeth.mirror = true;
		ATGUtils.setRotation(teeth, 0F, 0F, 0F);
		boxes.add(teeth);

		ModelRenderer torso2 = new ModelRenderer(this, 63, 37);
		torso2.addBox(-4F, 9F, 1F, 8, 14, 1);
		torso2.setRotationPoint(0F, 0F, 0F);
		torso2.mirror = true;
		ATGUtils.setRotation(torso2, 0.0349066F, 0F, 0F);
		boxes.add(torso2);

		ModelRenderer torso3 = new ModelRenderer(this, 58, 16);
		torso3.addBox(-2F, 5F, 1.5F, 1, 4, 1);
		torso3.setRotationPoint(0F, 0F, 0F);
		torso3.mirror = true;
		ATGUtils.setRotation(torso3, 0F, 0F, 0F);
		boxes.add(torso3);

		ModelRenderer torso4 = new ModelRenderer(this, 64, 16);
		torso4.addBox(2F, 0F, 1.4F, 2, 8, 1);
		torso4.setRotationPoint(0F, 0F, 0F);
		torso4.mirror = true;
		ATGUtils.setRotation(torso4, 0F, 0F, 0F);
		boxes.add(torso4);

		ModelRenderer torso5 = new ModelRenderer(this, 64, 16);
		torso5.addBox(-4F, 0F, 1.4F, 2, 8, 1);
		torso5.setRotationPoint(0F, 0F, 0F);
		torso5.mirror = true;
		ATGUtils.setRotation(torso5, 0F, 0F, 0F);
		boxes.add(torso5);

		ModelRenderer torso6 = new ModelRenderer(this, 40, 11);
		torso6.addBox(-4F, 8F, 1.6F, 2, 1, 1);
		torso6.setRotationPoint(0F, 0F, 0F);
		torso6.mirror = true;
		ATGUtils.setRotation(torso6, 0F, 0F, 0F);
		boxes.add(torso6);

		ModelRenderer torso7 = new ModelRenderer(this, 40, 11);
		torso7.addBox(-1F, 8F, 1.6F, 2, 1, 1);
		torso7.setRotationPoint(0F, 0F, 0F);
		torso7.mirror = true;
		ATGUtils.setRotation(torso7, 0F, 0F, 0F);
		boxes.add(torso7);

		ModelRenderer torso8 = new ModelRenderer(this, 40, 11);
		torso8.addBox(2F, 8F, 1.6F, 2, 1, 1);
		torso8.setRotationPoint(0F, 0F, 0F);
		torso8.mirror = true;
		ATGUtils.setRotation(torso8, 0F, 0F, 0F);
		boxes.add(torso8);

		ModelRenderer body1 = new ModelRenderer(this, 48, 9);
		body1.addBox(1F, 6F, 1.5F, 1, 3, 1);
		body1.setRotationPoint(0F, 0F, 0F);
		body1.mirror = true;
		ATGUtils.setRotation(body1, 0F, 0F, 0F);
		boxes.add(body1);

		ModelRenderer body2 = new ModelRenderer(this, 58, 16);
		body2.addBox(1F, 5F, -2.5F, 1, 4, 1);
		body2.setRotationPoint(0F, 0F, 0F);
		body2.mirror = true;
		ATGUtils.setRotation(body2, 0F, 0F, 0F);
		boxes.add(body2);

		ModelRenderer body3 = new ModelRenderer(this, 50, 0);
		body3.addBox(-2F, 4F, -2.5F, 1, 5, 1);
		body3.setRotationPoint(0F, 0F, 0F);
		body3.mirror = true;
		ATGUtils.setRotation(body3, 0F, 0F, 0F);
		boxes.add(body3);

		ModelRenderer body4 = new ModelRenderer(this, 40, 11);
		body4.addBox(-4F, 8F, -2.6F, 2, 1, 1);
		body4.setRotationPoint(0F, 0F, 0F);
		body4.mirror = true;
		ATGUtils.setRotation(body4, 0F, 0F, 0F);
		boxes.add(body4);

		ModelRenderer body5 = new ModelRenderer(this, 40, 11);
		body5.addBox(-1F, 8F, -2.6F, 2, 1, 1);
		body5.setRotationPoint(0F, 0F, 0F);
		body5.mirror = true;
		ATGUtils.setRotation(body5, 0F, 0F, 0F);
		boxes.add(body5);

		ModelRenderer body6 = new ModelRenderer(this, 72, 16);
		body6.addBox(-4.2F, 8F, -2.5F, 1, 1, 5);
		body6.setRotationPoint(0F, 0F, 0F);
		body6.mirror = true;
		ATGUtils.setRotation(body6, 0F, 0F, 0F);
		boxes.add(body6);

		ModelRenderer body7 = new ModelRenderer(this, 64, 16);
		body7.addBox(2F, 0F, -2.4F, 2, 8, 1);
		body7.setRotationPoint(0F, 0F, 0F);
		body7.mirror = true;
		ATGUtils.setRotation(body7, 0F, 0F, 0F);
		boxes.add(body7);

		ModelRenderer body8 = new ModelRenderer(this, 64, 16);
		body8.addBox(-4F, 0F, -2.4F, 2, 8, 1);
		body8.setRotationPoint(0F, 0F, 0F);
		body8.mirror = true;
		ATGUtils.setRotation(body8, 0F, 0F, 0F);
		boxes.add(body8);

		ModelRenderer body9 = new ModelRenderer(this, 16, 16);
		body9.addBox(-4F, 0F, -2F, 8, 9, 4);
		body9.setRotationPoint(0F, 0F, 0F);
		body9.mirror = true;
		ATGUtils.setRotation(body9, 0F, 0F, 0F);
		boxes.add(body9);

		ModelRenderer body10 = new ModelRenderer(this, 56, 27);
		body10.addBox(-4F, 22F, -3F, 8, 1, 6);
		body10.setRotationPoint(0F, 0F, 0F);
		body10.mirror = true;
		ATGUtils.setRotation(body10, 0F, 0F, 0F);
		boxes.add(body10);

		ModelRenderer body11 = new ModelRenderer(this, 87, 16);
		body11.addBox(1F, 14F, 1.2F, 1, 9, 1);
		body11.setRotationPoint(0F, 0F, 0F);
		body11.mirror = true;
		ATGUtils.setRotation(body11, 0.0349066F, 0F, 0F);
		boxes.add(body11);

		ModelRenderer body12 = new ModelRenderer(this, 0, 49);
		body12.addBox(-4F, 9F, -2F, 8, 14, 4);
		body12.setRotationPoint(0F, 0F, 0F);
		body12.mirror = true;
		ATGUtils.setRotation(body12, 0F, 0F, 0F);
		boxes.add(body12);

		ModelRenderer body13 = new ModelRenderer(this, 87, 16);
		body13.addBox(-3F, 12F, 1.2F, 1, 11, 1);
		body13.setRotationPoint(0F, 0F, 0F);
		body13.mirror = true;
		ATGUtils.setRotation(body13, 0.0349066F, 0F, 0F);
		boxes.add(body13);

		ModelRenderer body14 = new ModelRenderer(this, 87, 16);
		body14.addBox(-1F, 10F, -2.2F, 1, 13, 1);
		body14.setRotationPoint(0F, 0F, 0F);
		body14.mirror = true;
		ATGUtils.setRotation(body14, -0.0349066F, 0F, 0F);
		boxes.add(body14);

		ModelRenderer body15 = new ModelRenderer(this, 87, 16);
		body15.addBox(1F, 15F, -2.2F, 1, 8, 1);
		body15.setRotationPoint(0F, 0F, 0F);
		body15.mirror = true;
		ATGUtils.setRotation(body15, -0.0349066F, 0F, 0F);
		boxes.add(body15);

		ModelRenderer body16 = new ModelRenderer(this, 40, 11);
		body16.addBox(2F, 8F, -2.6F, 2, 1, 1);
		body16.setRotationPoint(0F, 0F, 0F);
		body16.mirror = true;
		ATGUtils.setRotation(body16, 0F, 0F, 0F);
		boxes.add(body16);

		ModelRenderer body17 = new ModelRenderer(this, 72, 16);
		body17.addBox(3.2F, 8F, -2.5F, 1, 1, 5);
		body17.setRotationPoint(0F, 0F, 0F);
		body17.mirror = true;
		ATGUtils.setRotation(body17, 0F, 0F, 0F);
		boxes.add(body17);

		ModelRenderer body18 = new ModelRenderer(this, 63, 37);
		body18.addBox(-4F, 9F, -2F, 8, 14, 1);
		body18.setRotationPoint(0F, 0F, 0F);
		body18.mirror = true;
		ATGUtils.setRotation(body18, -0.0349066F, 0F, 0F);
		boxes.add(body18);

		ModelRenderer body19 = new ModelRenderer(this, 87, 16);
		body19.addBox(-3F, 13F, -2.2F, 1, 10, 1);
		body19.setRotationPoint(0F, 0F, 0F);
		body19.mirror = true;
		ATGUtils.setRotation(body19, -0.0349066F, 0F, 0F);
		boxes.add(body19);

		ModelRenderer body20 = new ModelRenderer(this, 0, 38);
		body20.addBox(-4F, 23F, -3.5F, 8, 1, 7);
		body20.setRotationPoint(0F, 0F, 0F);
		body20.mirror = true;
		ATGUtils.setRotation(body20, 0F, 0F, 0F);
		boxes.add(body20);

		ModelRenderer body21 = new ModelRenderer(this, 0, 26);
		body21.addBox(-4.1F, 22F, -3F, 1, 1, 6);
		body21.setRotationPoint(0F, 0F, 0F);
		body21.mirror = true;
		ATGUtils.setRotation(body21, 0F, 0F, 0F);
		boxes.add(body21);

		ModelRenderer body22 = new ModelRenderer(this, 31, 38);
		body22.addBox(-4.5F, 23F, -3F, 9, 1, 6);
		body22.setRotationPoint(0F, 0F, 0F);
		body22.mirror = true;
		ATGUtils.setRotation(body22, 0F, 0F, 0F);
		boxes.add(body22);

		ModelRenderer body23 = new ModelRenderer(this, 87, 16);
		body23.addBox(-4.1F, 11F, 0F, 1, 11, 1);
		body23.setRotationPoint(0F, 0F, 0F);
		body23.mirror = true;
		ATGUtils.setRotation(body23, 0F, 0F, 0F);
		boxes.add(body23);

		ModelRenderer body24 = new ModelRenderer(this, 0, 26);
		body24.addBox(3.1F, 22F, -3F, 1, 1, 6);
		body24.setRotationPoint(0F, 0F, 0F);
		body24.mirror = true;
		ATGUtils.setRotation(body24, 0F, 0F, 0F);
		boxes.add(body24);

		ModelRenderer body25 = new ModelRenderer(this, 87, 16);
		body25.addBox(3.1F, 12F, -1F, 1, 10, 1);
		body25.setRotationPoint(0F, 0F, 0F);
		body25.mirror = true;
		ATGUtils.setRotation(body25, 0F, 0F, 0F);
		boxes.add(body25);

		ModelRenderer body26 = new ModelRenderer(this, 0, 16);
		body26.addBox(-2F, 1F, -2.4F, 4, 7, 1);
		body26.setRotationPoint(0F, 0F, 0F);
		body26.mirror = true;
		ATGUtils.setRotation(body26, 0F, 0F, 0F);
		boxes.add(body26);

		ModelRenderer body27 = new ModelRenderer(this, 95, 0);
		body27.addBox(-5F, 1F, -0.5F, 3, 7, 1);
		body27.setRotationPoint(0F, 0F, 0F);
		body27.mirror = true;
		ATGUtils.setRotation(body27, 0F, 2.356194F, 0F);
		boxes.add(body27);

		ModelRenderer body28 = new ModelRenderer(this, 94, 16);
		body28.addBox(-6F, 0F, -0.5F, 1, 9, 1);
		body28.setRotationPoint(0F, 0F, 0F);
		body28.mirror = true;
		ATGUtils.setRotation(body28, 0F, 2.356194F, 0F);
		boxes.add(body28);

		ModelRenderer body29 = new ModelRenderer(this, 100, 16);
		body29.addBox(-7F, -1F, -0.5F, 1, 11, 1);
		body29.setRotationPoint(0F, 0F, 0F);
		body29.mirror = true;
		ATGUtils.setRotation(body29, 0F, 2.356194F, 0F);
		boxes.add(body29);

		ModelRenderer body30 = new ModelRenderer(this, 105, 16);
		body30.addBox(-8F, -3F, -0.5F, 1, 15, 1);
		body30.setRotationPoint(0F, 0F, 0F);
		body30.mirror = true;
		ATGUtils.setRotation(body30, 0F, 2.356194F, 0F);
		boxes.add(body30);

		ModelRenderer body31 = new ModelRenderer(this, 110, 15);
		body31.addBox(-9F, -4F, -0.5F, 1, 18, 1);
		body31.setRotationPoint(0F, 0F, 0F);
		body31.mirror = true;
		ATGUtils.setRotation(body31, 0F, 2.356194F, 0F);
		boxes.add(body31);

		ModelRenderer body33 = new ModelRenderer(this, 115, 14);
		body33.addBox(-10F, -4F, -0.5F, 1, 20, 1);
		body33.setRotationPoint(0F, 0F, 0F);
		body33.mirror = true;
		ATGUtils.setRotation(body33, 0F, 2.356194F, 0F);
		boxes.add(body33);

		ModelRenderer body338 = new ModelRenderer(this, 120, 16);
		body338.addBox(-11F, -3F, -0.5F, 1, 18, 1);
		body338.setRotationPoint(0F, 0F, 0F);
		body338.mirror = true;
		ATGUtils.setRotation(body338, 0F, 2.356194F, 0F);
		boxes.add(body338);

		ModelRenderer body34 = new ModelRenderer(this, 83, 47);
		body34.addBox(-12F, -2F, -0.5F, 1, 14, 1);
		body34.setRotationPoint(0F, 0F, 0F);
		body34.mirror = true;
		ATGUtils.setRotation(body34, 0F, 2.356194F, 0F);
		boxes.add(body34);

		ModelRenderer body35 = new ModelRenderer(this, 95, 0);
		body35.addBox(-5F, 1F, -0.5F, 3, 7, 1);
		body35.setRotationPoint(0F, 0F, 0F);
		body35.mirror = true;
		ATGUtils.setRotation(body35, 0F, 0.7853982F, 0F);
		boxes.add(body35);

		ModelRenderer body36 = new ModelRenderer(this, 94, 16);
		body36.addBox(-6F, 0F, -0.5F, 1, 9, 1);
		body36.setRotationPoint(0F, 0F, 0F);
		body36.mirror = true;
		ATGUtils.setRotation(body36, 0F, 0.7853982F, 0F);
		boxes.add(body36);

		ModelRenderer body37 = new ModelRenderer(this, 100, 16);
		body37.addBox(-7F, -1F, -0.5F, 1, 11, 1);
		body37.setRotationPoint(0F, 0F, 0F);
		body37.mirror = true;
		ATGUtils.setRotation(body37, 0F, 0.7853982F, 0F);
		boxes.add(body37);

		ModelRenderer body38 = new ModelRenderer(this, 105, 16);
		body38.addBox(-8F, -3F, -0.5F, 1, 15, 1);
		body38.setRotationPoint(0F, 0F, 0F);
		body38.mirror = true;
		ATGUtils.setRotation(body38, 0F, 0.7853982F, 0F);
		boxes.add(body38);

		ModelRenderer body39 = new ModelRenderer(this, 110, 15);
		body39.addBox(-9F, -4F, -0.5F, 1, 18, 1);
		body39.setRotationPoint(0F, 0F, 0F);
		body39.mirror = true;
		ATGUtils.setRotation(body39, 0F, 0.7853982F, 0F);
		boxes.add(body39);

		ModelRenderer body40 = new ModelRenderer(this, 115, 14);
		body40.addBox(-10F, -4F, -0.5F, 1, 20, 1);
		body40.setRotationPoint(0F, 0F, 0F);
		body40.mirror = true;
		ATGUtils.setRotation(body40, 0F, 0.7853982F, 0F);
		boxes.add(body40);

		ModelRenderer body41 = new ModelRenderer(this, 120, 16);
		body41.addBox(-11F, -3F, -0.5F, 1, 18, 1);
		body41.setRotationPoint(0F, 0F, 0F);
		body41.mirror = true;
		ATGUtils.setRotation(body41, 0F, 0.7853982F, 0F);
		boxes.add(body41);

		ModelRenderer body42 = new ModelRenderer(this, 83, 47);
		body42.addBox(-12F, -2F, -0.5F, 1, 14, 1);
		body42.setRotationPoint(0F, 0F, 0F);
		body42.mirror = true;
		ATGUtils.setRotation(body42, 0F, 0.7853982F, 0F);
		boxes.add(body42);

		ModelRenderer head1 = new ModelRenderer(this, 106, 0);
		head1.addBox(-2.5F, -5.7F, -4.3F, 4, 1, 1);
		head1.setRotationPoint(0F, 0F, 0F);
		head1.mirror = true;
		ATGUtils.setRotation(head1, 0F, 0F, 0F);
		boxes.add(head1);

		ModelRenderer head2 = new ModelRenderer(this, 16, 31);
		head2.addBox(-4F, -1F, -4F, 3, 1, 1);
		head2.setRotationPoint(0F, 0F, 0F);
		head2.mirror = true;
		ATGUtils.setRotation(head2, 0F, 0F, 0F);
		boxes.add(head2);

		ModelRenderer head3 = new ModelRenderer(this, 16, 31);
		head3.addBox(1F, -1F, -4F, 3, 1, 1);
		head3.setRotationPoint(0F, 0F, 0F);
		head3.mirror = true;
		ATGUtils.setRotation(head3, 0F, 0F, 0F);
		boxes.add(head3);

		ModelRenderer head4 = new ModelRenderer(this, 0, 69);
		head4.addBox(-2F, -0.5F, -4F, 4, 1, 1);
		head4.setRotationPoint(0F, 0F, 0F);
		head4.mirror = true;
		ATGUtils.setRotation(head4, 0F, 0F, 0F);
		boxes.add(head4);

		ModelRenderer head5 = new ModelRenderer(this, 111, 9);
		head5.addBox(-0.7F, -0.8F, 2F, 5, 1, 2);
		head5.setRotationPoint(0F, 0F, 0F);
		head5.mirror = true;
		ATGUtils.setRotation(head5, 0F, 0F, 0F);
		boxes.add(head5);

		ModelRenderer head6 = new ModelRenderer(this, 84, 36);
		head6.addBox(-4.5F, -6.5F, -6F, 9, 1, 9);
		head6.setRotationPoint(0F, 0F, 0F);
		head6.mirror = true;
		ATGUtils.setRotation(head6, -0.2617994F, 0F, 0F);
		boxes.add(head6);

		ModelRenderer head7 = new ModelRenderer(this, 33, 0);
		head7.addBox(2F, -6F, -4.3F, 2, 1, 1);
		head7.setRotationPoint(0F, 0F, 0F);
		head7.mirror = true;
		ATGUtils.setRotation(head7, 0F, 0F, 0F);
		boxes.add(head7);

		ModelRenderer head8 = new ModelRenderer(this, 33, 0);
		head8.addBox(-4F, -6F, -4.3F, 2, 1, 1);
		head8.setRotationPoint(0F, 0F, 0F);
		head8.mirror = true;
		ATGUtils.setRotation(head8, 0F, 0F, 0F);
		boxes.add(head8);

		ModelRenderer head9 = new ModelRenderer(this, 33, 4);
		head9.addBox(-4.3F, -6F, -4F, 1, 1, 2);
		head9.setRotationPoint(0F, 0F, 0F);
		head9.mirror = true;
		ATGUtils.setRotation(head9, 0F, 0F, 0F);
		boxes.add(head9);

		ModelRenderer head10 = new ModelRenderer(this, 43, 33);
		head10.addBox(-4.3F, -0.8F, 2F, 4, 1, 2);
		head10.setRotationPoint(0F, 0F, 0F);
		head10.mirror = true;
		ATGUtils.setRotation(head10, 0F, 0F, 0F);
		boxes.add(head10);

		ModelRenderer head11 = new ModelRenderer(this, 33, 4);
		head11.addBox(-4.3F, -5F, -2F, 1, 1, 2);
		head11.setRotationPoint(0F, 0F, 0F);
		head11.mirror = true;
		ATGUtils.setRotation(head11, 0F, 0F, 0F);
		boxes.add(head11);

		ModelRenderer head12 = new ModelRenderer(this, 106, 5);
		head12.addBox(-4.3F, -4F, 0F, 1, 2, 1);
		head12.setRotationPoint(0F, 0F, 0F);
		head12.mirror = true;
		ATGUtils.setRotation(head12, 0F, 0F, 0F);
		boxes.add(head12);

		ModelRenderer head13 = new ModelRenderer(this, 33, 0);
		head13.addBox(0.5F, -5.5F, -4.3F, 2, 1, 1);
		head13.setRotationPoint(0F, 0F, 0F);
		head13.mirror = true;
		ATGUtils.setRotation(head13, 0F, 0F, 0F);
		boxes.add(head13);

		ModelRenderer head14 = new ModelRenderer(this, 57, 0);
		head14.addBox(-4F, -6.5F, -6.5F, 8, 1, 10);
		head14.setRotationPoint(0F, 0F, 0F);
		head14.mirror = true;
		ATGUtils.setRotation(head14, -0.2617994F, 0F, 0F);
		boxes.add(head14);

		ModelRenderer head15 = new ModelRenderer(this, 0, 0);
		head15.addBox(-4F, -8F, -4F, 8, 7, 8);
		head15.setRotationPoint(0F, 0F, 0F);
		head15.mirror = true;
		ATGUtils.setRotation(head15, 0F, 0F, 0F);
		boxes.add(head15);

		ModelRenderer head16 = new ModelRenderer(this, 111, 9);
		head16.addBox(-0.7F, -0.8F, 2.2F, 5, 1, 2);
		head16.setRotationPoint(0F, 0F, 0F);
		head16.mirror = true;
		ATGUtils.setRotation(head16, 0F, 0F, 0F);
		boxes.add(head16);

		ModelRenderer head17 = new ModelRenderer(this, 43, 33);
		head17.addBox(-4.3F, -0.8F, 2.2F, 4, 1, 2);
		head17.setRotationPoint(0F, 0F, 0F);
		head17.mirror = true;
		ATGUtils.setRotation(head17, 0F, 0F, 0F);
		boxes.add(head17);

		ModelRenderer head18 = new ModelRenderer(this, 106, 5);
		head18.addBox(-4.3F, -1.5F, 1.5F, 1, 1, 1);
		head18.setRotationPoint(0F, 0F, 0F);
		head18.mirror = true;
		ATGUtils.setRotation(head18, 0F, 0F, 0F);
		boxes.add(head18);

		ModelRenderer head19 = new ModelRenderer(this, 106, 5);
		head19.addBox(-4.3F, -5F, -3F, 1, 2, 1);
		head19.setRotationPoint(0F, 0F, 0F);
		head19.mirror = true;
		ATGUtils.setRotation(head19, 0F, 0F, 0F);
		boxes.add(head19);

		ModelRenderer head20 = new ModelRenderer(this, 106, 5);
		head20.addBox(-4.3F, -2F, 1F, 1, 1, 1);
		head20.setRotationPoint(0F, 0F, 0F);
		head20.mirror = true;
		ATGUtils.setRotation(head20, 0F, 0F, 0F);
		boxes.add(head20);

		ModelRenderer head21 = new ModelRenderer(this, 106, 5);
		head21.addBox(3.3F, -1.5F, 1.5F, 1, 1, 1);
		head21.setRotationPoint(0F, 0F, 0F);
		head21.mirror = true;
		ATGUtils.setRotation(head21, 0F, 0F, 0F);
		boxes.add(head21);

		ModelRenderer head22 = new ModelRenderer(this, 106, 5);
		head22.addBox(3.3F, -2F, 1F, 1, 1, 1);
		head22.setRotationPoint(0F, 0F, 0F);
		head22.mirror = true;
		ATGUtils.setRotation(head22, 0F, 0F, 0F);
		boxes.add(head22);

		ModelRenderer head23 = new ModelRenderer(this, 106, 5);
		head23.addBox(3.3F, -4F, 0F, 1, 2, 1);
		head23.setRotationPoint(0F, 0F, 0F);
		head23.mirror = true;
		ATGUtils.setRotation(head23, 0F, 0F, 0F);
		boxes.add(head23);

		ModelRenderer head24 = new ModelRenderer(this, 33, 4);
		head24.addBox(3.3F, -5F, -2F, 1, 1, 2);
		head24.setRotationPoint(0F, 0F, 0F);
		head24.mirror = true;
		ATGUtils.setRotation(head24, 0F, 0F, 0F);
		boxes.add(head24);

		ModelRenderer head25 = new ModelRenderer(this, 106, 5);
		head25.addBox(3.3F, -5F, -3F, 1, 2, 1);
		head25.setRotationPoint(0F, 0F, 0F);
		head25.mirror = true;
		ATGUtils.setRotation(head25, 0F, 0F, 0F);
		boxes.add(head25);

		ModelRenderer head26 = new ModelRenderer(this, 33, 4);
		head26.addBox(3.3F, -6F, -4F, 1, 1, 2);
		head26.setRotationPoint(0F, 0F, 0F);
		head26.mirror = true;
		ATGUtils.setRotation(head26, 0F, 0F, 0F);
		boxes.add(head26);

		for (ModelRenderer box : boxes)
			box.setTextureSize(128, 128);
	}

	@Override public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

		for (ModelRenderer box : boxes)
			box.render(scale);
	}

}
