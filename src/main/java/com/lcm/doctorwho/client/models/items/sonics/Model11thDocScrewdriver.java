package com.lcm.doctorwho.client.models.items.sonics;

import com.lcm.doctorwho.client.models.interfaces.ItemModelBase;
import com.lcm.doctorwho.utils.ATGUtils;
import lucraft.mods.lucraftcore.util.render.LCModelState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemTransformVec3f;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model11thDocScrewdriver extends ModelBase implements ItemModelBase {

	private ArrayList<ModelRenderer> boxes = new ArrayList<>();

	public Model11thDocScrewdriver() {
		textureWidth = 128;
		textureHeight = 26;

		ModelRenderer p1 = new ModelRenderer(this, 0, 10);
		p1.addBox(-1.5F, 11.3F, -1.5F, 3, 1, 3);
		boxes.add(p1);

		ModelRenderer p2 = new ModelRenderer(this, 102, 13);
		p2.addBox(-1.5F, 16F, -1.6F, 3, 1, 1);
		boxes.add(p2);

		ModelRenderer p4 = new ModelRenderer(this, 0, 16);
		p4.addBox(-0.5F, 6F, 0.9F, 1, 1, 1);
		boxes.add(p4);

		ModelRenderer p5 = new ModelRenderer(this, 38, 0);
		p5.addBox(0.7F, 0F, -1.5F, 1, 7, 3);
		boxes.add(p5);

		ModelRenderer p6 = new ModelRenderer(this, 49, 0);
		p6.addBox(-1.5F, 0F, 0.7F, 3, 7, 1);
		boxes.add(p6);

		ModelRenderer p7 = new ModelRenderer(this, 38, 0);
		p7.addBox(-1.7F, 0F, -1.5F, 1, 7, 3);
		boxes.add(p7);

		ModelRenderer p8 = new ModelRenderer(this, 92, 7);
		p8.addBox(-1.5F, 7.5F, -1.8F, 3, 1, 1);
		boxes.add(p8);

		ModelRenderer p9 = new ModelRenderer(this, 38, 12);
		p9.addBox(0.8F, 7.5F, -1.5F, 1, 1, 3);
		boxes.add(p9);

		ModelRenderer p10 = new ModelRenderer(this, 92, 7);
		p10.addBox(-1.5F, 7.5F, 0.8F, 3, 1, 1);
		boxes.add(p10);

		ModelRenderer p11 = new ModelRenderer(this, 38, 12);
		p11.addBox(-1.8F, 7.5F, -1.5F, 1, 1, 3);
		boxes.add(p11);

		ModelRenderer p12 = new ModelRenderer(this, 57, 11);
		p12.addBox(-1.5F, 9.5F, 0.6F, 3, 2, 1);
		boxes.add(p12);

		ModelRenderer p13 = new ModelRenderer(this, 110, 0);
		p13.addBox(-1.6F, 9.5F, -1.5F, 1, 2, 3);
		boxes.add(p13);

		ModelRenderer p14 = new ModelRenderer(this, 48, 10);
		p14.addBox(-1.5F, 8.5F, 0.7F, 3, 1, 1);
		boxes.add(p14);

		ModelRenderer p15 = new ModelRenderer(this, 82, 6);
		p15.addBox(-1.7F, 8.5F, -1.5F, 1, 1, 3);
		boxes.add(p15);

		ModelRenderer p16 = new ModelRenderer(this, 28, 9);
		p16.addBox(-1F, 20.3F, -1F, 2, 1, 2);
		boxes.add(p16);

		ModelRenderer p17 = new ModelRenderer(this, 19, 14);
		p17.addBox(-1.5F, 7F, -1.6F, 3, 1, 1);
		boxes.add(p17);

		ModelRenderer p18 = new ModelRenderer(this, 28, 13);
		p18.addBox(0.6F, 7F, -1.5F, 1, 1, 3);
		boxes.add(p18);

		ModelRenderer p19 = new ModelRenderer(this, 19, 14);
		p19.addBox(-1.5F, 7F, 0.6F, 3, 1, 1);
		boxes.add(p19);

		ModelRenderer p20 = new ModelRenderer(this, 28, 13);
		p20.addBox(-1.6F, 7F, -1.5F, 1, 1, 3);
		boxes.add(p20);

		ModelRenderer p21 = new ModelRenderer(this, 30, 19);
		p21.addBox(-1.5F, -1F, -1.5F, 3, 1, 3);
		boxes.add(p21);

		ModelRenderer p22 = new ModelRenderer(this, 7, 16);
		p22.addBox(0.9F, 6F, -0.5F, 1, 1, 1);
		boxes.add(p22);

		ModelRenderer p23 = new ModelRenderer(this, 79, 12);
		p23.addBox(-1F, -2.5F, -1F, 2, 2, 2);
		boxes.add(p23);

		ModelRenderer p24 = new ModelRenderer(this, 49, 0);
		p24.addBox(-1.5F, 0F, -1.7F, 3, 7, 1);
		boxes.add(p24);

		ModelRenderer p27 = new ModelRenderer(this, 7, 16);
		p27.addBox(-1.9F, 6F, -0.5F, 1, 1, 1);
		boxes.add(p27);

		ModelRenderer p28 = new ModelRenderer(this, 68, 11);
		p28.addBox(-1.5F, -2.5F, -0.5F, 3, 1, 1);
		boxes.add(p28);

		ModelRenderer p29 = new ModelRenderer(this, 47, 14);
		p29.addBox(-0.5F, -2.5F, -1.5F, 1, 1, 3);
		boxes.add(p29);

		ModelRenderer p31 = new ModelRenderer(this, 9, 5);
		p31.addBox(-0.9F, -5.6F, -0.5F, 1, 1, 1);
		boxes.add(p31);

		ModelRenderer p32 = new ModelRenderer(this, 13, 13);
		p32.addBox(-0.5F, -5.6F, -0.9F, 1, 1, 1);
		boxes.add(p32);

		ModelRenderer p33 = new ModelRenderer(this, 9, 5);
		p33.addBox(-0.1F, -5.6F, -0.5F, 1, 1, 1);
		boxes.add(p33);

		ModelRenderer p34 = new ModelRenderer(this, 13, 13);
		p34.addBox(-0.5F, -5.6F, -0.1F, 1, 1, 1);
		boxes.add(p34);

		ModelRenderer p35 = new ModelRenderer(this, 0, 20);
		p35.addBox(-0.2F, -4.1F, -0.8F, 1, 1, 1);
		boxes.add(p35);

		ModelRenderer p36 = new ModelRenderer(this, 9, 5);
		p36.addBox(-0.8F, -3.4F, -0.5F, 1, 1, 1);
		boxes.add(p36);

		ModelRenderer p37 = new ModelRenderer(this, 13, 13);
		p37.addBox(-0.5F, -3.4F, -0.8F, 1, 1, 1);
		boxes.add(p37);

		ModelRenderer p38 = new ModelRenderer(this, 13, 13);
		p38.addBox(-0.5F, -3.4F, -0.2F, 1, 1, 1);
		boxes.add(p38);

		ModelRenderer p39 = new ModelRenderer(this, 9, 5);
		p39.addBox(-0.2F, -3.4F, -0.5F, 1, 1, 1);
		boxes.add(p39);

		ModelRenderer p40 = new ModelRenderer(this, 22, 19);
		p40.addBox(-1F, -4.1F, -0.5F, 2, 1, 1);
		boxes.add(p40);

		ModelRenderer p41 = new ModelRenderer(this, 0, 20);
		p41.addBox(-0.8F, -4.1F, -0.8F, 1, 1, 1);
		boxes.add(p41);

		ModelRenderer p42 = new ModelRenderer(this, 13, 17);
		p42.addBox(-0.5F, -4.1F, -1F, 1, 1, 2);
		boxes.add(p42);

		ModelRenderer p43 = new ModelRenderer(this, 0, 20);
		p43.addBox(-0.2F, -4.1F, -0.2F, 1, 1, 1);
		boxes.add(p43);

		ModelRenderer p44 = new ModelRenderer(this, 0, 20);
		p44.addBox(-0.8F, -4.1F, -0.2F, 1, 1, 1);
		boxes.add(p44);

		ModelRenderer p45 = new ModelRenderer(this, 27, 0);
		p45.addBox(-0.5F, -2F, -2.3F, 1, 2, 1);
		ATGUtils.setRotation(p45, 0.2094395F, -2.356194F, 0F);
		boxes.add(p45);

		ModelRenderer p46 = new ModelRenderer(this, 13, 13);
		p46.addBox(-0.5F, -4.6F, -0.2F, 1, 1, 1);
		boxes.add(p46);

		ModelRenderer p47 = new ModelRenderer(this, 9, 5);
		p47.addBox(-0.2F, -4.6F, -0.5F, 1, 1, 1);
		boxes.add(p47);

		ModelRenderer p48 = new ModelRenderer(this, 13, 13);
		p48.addBox(-0.5F, -4.6F, -0.8F, 1, 1, 1);
		boxes.add(p48);

		ModelRenderer p49 = new ModelRenderer(this, 9, 5);
		p49.addBox(-0.8F, -4.6F, -0.5F, 1, 1, 1);
		boxes.add(p49);

		ModelRenderer p50 = new ModelRenderer(this, 0, 16);
		p50.addBox(-0.5F, 6F, -1.9F, 1, 1, 1);
		boxes.add(p50);

		ModelRenderer p51 = new ModelRenderer(this, 48, 10);
		p51.addBox(-1.5F, 8.5F, -1.7F, 3, 1, 1);
		boxes.add(p51);

		ModelRenderer p52 = new ModelRenderer(this, 57, 11);
		p52.addBox(-1.5F, 9.5F, -1.6F, 3, 2, 1);
		boxes.add(p52);

		ModelRenderer p53 = new ModelRenderer(this, 82, 6);
		p53.addBox(0.7F, 8.5F, -1.5F, 1, 1, 3);
		boxes.add(p53);

		ModelRenderer p54 = new ModelRenderer(this, 110, 0);
		p54.addBox(0.6F, 9.5F, -1.5F, 1, 2, 3);
		boxes.add(p54);

		ModelRenderer p55 = new ModelRenderer(this, 82, 6);
		p55.addBox(-1.7F, 11F, -1.5F, 1, 1, 3);
		boxes.add(p55);

		ModelRenderer p56 = new ModelRenderer(this, 48, 10);
		p56.addBox(-1.5F, 11F, -1.7F, 3, 1, 1);
		boxes.add(p56);

		ModelRenderer p57 = new ModelRenderer(this, 82, 6);
		p57.addBox(0.7F, 11F, -1.5F, 1, 1, 3);
		boxes.add(p57);

		ModelRenderer p58 = new ModelRenderer(this, 48, 10);
		p58.addBox(-1.5F, 11F, 0.7F, 3, 1, 1);
		boxes.add(p58);

		ModelRenderer p59 = new ModelRenderer(this, 65, 0);
		p59.addBox(0.7F, 19F, -1.5F, 1, 1, 3);
		boxes.add(p59);

		ModelRenderer p60 = new ModelRenderer(this, 17, 10);
		p60.addBox(-1.5F, 19F, 0.7F, 3, 1, 1);
		boxes.add(p60);

		ModelRenderer p61 = new ModelRenderer(this, 74, 6);
		p61.addBox(-1.6F, 18F, -1F, 1, 1, 2);
		boxes.add(p61);

		ModelRenderer p62 = new ModelRenderer(this, 65, 0);
		p62.addBox(-1.7F, 19F, -1.5F, 1, 1, 3);
		boxes.add(p62);

		ModelRenderer p63 = new ModelRenderer(this, 17, 10);
		p63.addBox(-1.5F, 17F, -1.7F, 3, 1, 1);
		boxes.add(p63);

		ModelRenderer p64 = new ModelRenderer(this, 65, 0);
		p64.addBox(0.7F, 17F, -1.5F, 1, 1, 3);
		boxes.add(p64);

		ModelRenderer p65 = new ModelRenderer(this, 65, 0);
		p65.addBox(-1.7F, 17F, -1.5F, 1, 1, 3);
		boxes.add(p65);

		ModelRenderer p66 = new ModelRenderer(this, 17, 10);
		p66.addBox(-1.5F, 17F, 0.7F, 3, 1, 1);
		boxes.add(p66);

		ModelRenderer p67 = new ModelRenderer(this, 17, 10);
		p67.addBox(-1.5F, 19F, -1.7F, 3, 1, 1);
		boxes.add(p67);

		ModelRenderer p68 = new ModelRenderer(this, 74, 0);
		p68.addBox(-1.5F, 18F, -1.5F, 3, 1, 3);
		boxes.add(p68);

		ModelRenderer p69 = new ModelRenderer(this, 65, 5);
		p69.addBox(-1F, 18F, 0.6F, 2, 1, 1);
		boxes.add(p69);

		ModelRenderer p70 = new ModelRenderer(this, 74, 6);
		p70.addBox(0.6F, 18F, -1F, 1, 1, 2);
		boxes.add(p70);

		ModelRenderer p71 = new ModelRenderer(this, 28, 5);
		p71.addBox(-1F, 20F, -1.4F, 2, 1, 1);
		boxes.add(p71);

		ModelRenderer p72 = new ModelRenderer(this, 19, 4);
		p72.addBox(0.4F, 20F, -1F, 1, 1, 2);
		boxes.add(p72);

		ModelRenderer p73 = new ModelRenderer(this, 19, 4);
		p73.addBox(-1.4F, 20F, -1F, 1, 1, 2);
		boxes.add(p73);

		ModelRenderer p74 = new ModelRenderer(this, 28, 5);
		p74.addBox(-1F, 20F, 0.4F, 2, 1, 1);
		boxes.add(p74);

		ModelRenderer p75 = new ModelRenderer(this, 65, 5);
		p75.addBox(-1F, 18F, -1.6F, 2, 1, 1);
		boxes.add(p75);

		ModelRenderer p76 = new ModelRenderer(this, 14, 0);
		p76.addBox(-0.5F, -1.5F, -1.9F, 1, 8, 1);
		boxes.add(p76);

		ModelRenderer p77 = new ModelRenderer(this, 59, 0);
		p77.addBox(0.9F, -1.5F, -0.5F, 1, 8, 1);
		boxes.add(p77);

		ModelRenderer p78 = new ModelRenderer(this, 59, 0);
		p78.addBox(-1.9F, -1.5F, -0.5F, 1, 8, 1);
		boxes.add(p78);

		ModelRenderer p79 = new ModelRenderer(this, 14, 0);
		p79.addBox(-0.5F, -1.5F, 0.9F, 1, 8, 1);
		boxes.add(p79);

		ModelRenderer p80 = new ModelRenderer(this, 20, 0);
		p80.addBox(-0.5F, -3.6F, -4.3F, 1, 1, 1);
		ATGUtils.setRotation(p80, -0.5235988F, -2.356194F, 0F);
		boxes.add(p80);

		ModelRenderer p81 = new ModelRenderer(this, 33, 0);
		p81.addBox(-0.5F, -4.2F, -2.8F, 1, 3, 1);
		ATGUtils.setRotation(p81, -0.0872665F, -2.356194F, 0F);
		boxes.add(p81);

		ModelRenderer p82 = new ModelRenderer(this, 33, 0);
		p82.addBox(-0.5F, -4.2F, -2.8F, 1, 3, 1);
		ATGUtils.setRotation(p82, -0.0872665F, 0.7853982F, 0F);
		boxes.add(p82);

		ModelRenderer p83 = new ModelRenderer(this, 20, 0);
		p83.addBox(-0.5F, -3.6F, -4.3F, 1, 1, 1);
		ATGUtils.setRotation(p83, -0.5235988F, 0.7853982F, 0F);
		boxes.add(p83);

		ModelRenderer p84 = new ModelRenderer(this, 27, 0);
		p84.addBox(-0.5F, -2F, -2.3F, 1, 2, 1);
		ATGUtils.setRotation(p84, 0.2094395F, 0.7853982F, 0F);
		boxes.add(p84);

		ModelRenderer p85 = new ModelRenderer(this, 33, 0);
		p85.addBox(-0.5F, -4.2F, -2.8F, 1, 3, 1);
		ATGUtils.setRotation(p85, -0.0872665F, -0.7853982F, 0F);
		boxes.add(p85);

		ModelRenderer p86 = new ModelRenderer(this, 20, 0);
		p86.addBox(-0.5F, -3.6F, -4.3F, 1, 1, 1);
		ATGUtils.setRotation(p86, -0.5235988F, -0.7853982F, 0F);
		boxes.add(p86);

		ModelRenderer p87 = new ModelRenderer(this, 27, 0);
		p87.addBox(-0.5F, -2F, -2.3F, 1, 2, 1);
		ATGUtils.setRotation(p87, 0.2094395F, -0.7853982F, 0F);
		boxes.add(p87);

		ModelRenderer p88 = new ModelRenderer(this, 33, 0);
		p88.addBox(-0.5F, -4.2F, -2.8F, 1, 3, 1);
		ATGUtils.setRotation(p88, -0.0872665F, 2.356194F, 0F);
		boxes.add(p88);

		ModelRenderer p89 = new ModelRenderer(this, 20, 0);
		p89.addBox(-0.5F, -3.6F, -4.3F, 1, 1, 1);
		ATGUtils.setRotation(p89, -0.5235988F, 2.356194F, 0F);
		boxes.add(p89);

		ModelRenderer p90 = new ModelRenderer(this, 27, 0);
		p90.addBox(-0.5F, -2F, -2.3F, 1, 2, 1);
		ATGUtils.setRotation(p90, 0.2094395F, 2.356194F, 0F);
		boxes.add(p90);


		ModelRenderer p91 = new ModelRenderer(this, 112, 19);
		p91.addBox(-1.6F, 16F, -1.5F, 1, 1, 3);
		boxes.add(p91);

		ModelRenderer p92 = new ModelRenderer(this, 102, 8);
		p92.addBox(-1.5F, 14.2F, -1.7F, 3, 2, 1);
		boxes.add(p92);

		ModelRenderer p93 = new ModelRenderer(this, 99, 0);
		p93.addBox(-1.5F, 12.2F, -1.8F, 3, 2, 1);
		boxes.add(p93);

		ModelRenderer p94 = new ModelRenderer(this, 99, 0);
		p94.addBox(-1.5F, 12.2F, 0.8F, 3, 2, 1);
		boxes.add(p94);

		ModelRenderer p95 = new ModelRenderer(this, 102, 8);
		p95.addBox(-1.5F, 14.2F, 0.7F, 3, 2, 1);
		boxes.add(p95);

		ModelRenderer p96 = new ModelRenderer(this, 102, 13);
		p96.addBox(-1.5F, 16F, 0.6F, 3, 1, 1);
		boxes.add(p96);

		ModelRenderer p97 = new ModelRenderer(this, 112, 7);
		p97.addBox(-1.8F, 12.2F, -1.5F, 1, 2, 3);
		boxes.add(p97);

		ModelRenderer p98 = new ModelRenderer(this, 112, 13);
		p98.addBox(-1.7F, 14.2F, -1.5F, 1, 2, 3);
		boxes.add(p98);

		ModelRenderer p99 = new ModelRenderer(this, 112, 19);
		p99.addBox(0.6F, 16F, -1.5F, 1, 1, 3);
		boxes.add(p99);

		ModelRenderer p100 = new ModelRenderer(this, 112, 13);
		p100.addBox(0.7F, 14.2F, -1.5F, 1, 2, 3);
		boxes.add(p100);

		ModelRenderer p101 = new ModelRenderer(this, 112, 7);
		p101.addBox(0.8F, 12.2F, -1.5F, 1, 2, 3);
		boxes.add(p101);

		for (ModelRenderer box : boxes) {
			box.setTextureSize(128, 26);
			box.mirror = true;
			box.setRotationPoint(0F, 2.7F, 0F);
		}

	}

	@Override public void renderModel(float scale) {
		for (ModelRenderer box : boxes)
			box.render(scale);
	}

	@Override public IModelState getTransforms() {
		Map<ItemCameraTransforms.TransformType, TRSRTransformation> map = new HashMap<>();
		map.put(ItemCameraTransforms.TransformType.GUI, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(1F, 1F, 0F), new Vector3f(0.5F, 0.5F, 0), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.GROUND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(-90F, 0F, 0F), new Vector3f(0.5F, 0.3F, 0.5F), new Vector3f(0.5F, 0.5F, 0.5F))));
		map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -120F, 0F), new Vector3f(1F, 0.3F, 0F), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -110, 0F), new Vector3f(1.4F, 0.7F, 0.9F), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, 0.5F), new Vector3f(0.7F, 0.7F, 0.7F))));
		map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, -0.2F), new Vector3f(0.7F, 0.7F, 0.7F))));
		map.put(ItemCameraTransforms.TransformType.FIXED, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(0F, 0F, 0F), new Vector3f(0.5F, 0.5F, 0.5F), new Vector3f(1F, 1F, 1F))));
		return new LCModelState(map);
	}

}
