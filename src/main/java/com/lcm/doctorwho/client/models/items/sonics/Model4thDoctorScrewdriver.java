package com.lcm.doctorwho.client.models.items.sonics;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import com.lcm.doctorwho.client.models.ItemModelBase;

import lucraft.mods.lucraftcore.util.render.LCModelState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemTransformVec3f;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

public class Model4thDoctorScrewdriver extends ModelBase implements ItemModelBase {

    ModelRenderer Indent5;
    ModelRenderer Indent6;
    ModelRenderer Darkbottom2;
    ModelRenderer Darkbottom1;
    ModelRenderer Neck2;
    ModelRenderer Darkindent2;
    ModelRenderer Indent4;
    ModelRenderer Indent3;
    ModelRenderer Darkindent1;
    ModelRenderer Neck1;
    ModelRenderer Indent2;
    ModelRenderer Indent1;
    ModelRenderer smallneck2;
    ModelRenderer smallneck1;
    ModelRenderer Outerneck4;
    ModelRenderer Outerneck3;
    ModelRenderer Bottomneck2;
    ModelRenderer Outerneck2;
    ModelRenderer Outerneck1;
    ModelRenderer Bottomneck1;
    ModelRenderer Innerneck1;
    ModelRenderer thinneck1;
    ModelRenderer Raisedbit2;
    ModelRenderer Raisedbit1;
    ModelRenderer Headpart4;
    ModelRenderer thinneck2;
    ModelRenderer Headpart2;
    ModelRenderer Bar1;
    ModelRenderer backemitter1;
    ModelRenderer Emitterbit1;
    ModelRenderer backemitter2;
    ModelRenderer Headpart9;
    ModelRenderer Bar2;
    ModelRenderer Bar3;
    ModelRenderer Headpart1;
    ModelRenderer Emitterbit2;
    ModelRenderer backemitter4;
    ModelRenderer backemitter3;
    ModelRenderer backemitter5;
    ModelRenderer backemitter6;
    ModelRenderer Emitterbit5;
    ModelRenderer Emitterbit6;
    ModelRenderer Emitterbit3;
    ModelRenderer Emitterbit4;
    ModelRenderer thickneck1;
    ModelRenderer thickneck2;
    ModelRenderer Base1;
    ModelRenderer Base2;
    ModelRenderer Bottom3;
    ModelRenderer Bottom4;
    ModelRenderer Bottom1;
    ModelRenderer Bottom5;
    ModelRenderer Bottom2;
    ModelRenderer Curvebit1;
    ModelRenderer Curvebit2;
    ModelRenderer Curvebit3;
    ModelRenderer Curvebit4;
    ModelRenderer Curvebit5;
    ModelRenderer Curvebit6;
    ModelRenderer Curvebit7;
    ModelRenderer Darkcurve1;
    ModelRenderer Curvebit8;
    ModelRenderer Curvebit9;
    ModelRenderer Darkcurve2;
    ModelRenderer Darkcurve3;
    ModelRenderer Darkcurve4;
    ModelRenderer Endbit1;
    ModelRenderer Curvebit10;
    ModelRenderer Darkcurve5;
    ModelRenderer Curvebit11;



    public Model4thDoctorScrewdriver()
    {
        textureWidth = 256;
        textureHeight = 256;

        Indent5 = new ModelRenderer(this, 40, 83);
        Indent5.addBox(0F, 0F, 0F, 8, 2, 10);
        Indent5.setRotationPoint(-4F, -18F, -5F);
        Indent5.setTextureSize(256, 256);
        Indent5.mirror = true;
        setRotation(Indent5, 0F, 0F, 0F);
        Indent6 = new ModelRenderer(this, 0, 83);
        Indent6.addBox(0F, 0F, 0F, 10, 2, 8);
        Indent6.setRotationPoint(-5F, -18F, -4F);
        Indent6.setTextureSize(256, 256);
        Indent6.mirror = true;
        setRotation(Indent6, 0F, 0F, 0F);
        Darkbottom2 = new ModelRenderer(this, 87, 53);
        Darkbottom2.addBox(0F, 0F, 0F, 11, 1, 8);
        Darkbottom2.setRotationPoint(-5.5F, 17F, -4F);
        Darkbottom2.setTextureSize(256, 256);
        Darkbottom2.mirror = true;
        setRotation(Darkbottom2, 0F, 0F, 0F);
        Darkbottom1 = new ModelRenderer(this, 87, 38);
        Darkbottom1.addBox(0F, 0F, 0F, 8, 1, 11);
        Darkbottom1.setRotationPoint(-4F, 17F, -5.5F);
        Darkbottom1.setTextureSize(256, 256);
        Darkbottom1.mirror = true;
        setRotation(Darkbottom1, 0F, 0F, 0F);
        Neck2 = new ModelRenderer(this, 0, 96);
        Neck2.addBox(0F, 0F, 0F, 8, 29, 6);
        Neck2.setRotationPoint(-4F, -53F, -3F);
        Neck2.setTextureSize(256, 256);
        Neck2.mirror = true;
        setRotation(Neck2, 0F, 0F, 0F);
        Darkindent2 = new ModelRenderer(this, 0, 23);
        Darkindent2.addBox(0F, 0F, 0F, 7, 7, 8);
        Darkindent2.setRotationPoint(-3.5F, -23F, -4F);
        Darkindent2.setTextureSize(256, 256);
        Darkindent2.mirror = true;
        setRotation(Darkindent2, 0F, 0F, 0F);
        Indent4 = new ModelRenderer(this, 0, 83);
        Indent4.addBox(0F, 0F, 0F, 10, 2, 8);
        Indent4.setRotationPoint(-5F, -21F, -4F);
        Indent4.setTextureSize(256, 256);
        Indent4.mirror = true;
        setRotation(Indent4, 0F, 0F, 0F);
        Indent3 = new ModelRenderer(this, 40, 83);
        Indent3.addBox(0F, 0F, 0F, 8, 2, 10);
        Indent3.setRotationPoint(-4F, -21F, -5F);
        Indent3.setTextureSize(256, 256);
        Indent3.mirror = true;
        setRotation(Indent3, 0F, 0F, 0F);
        Darkindent1 = new ModelRenderer(this, 0, 23);
        Darkindent1.addBox(0F, 0F, 0F, 8, 7, 7);
        Darkindent1.setRotationPoint(-4F, -23F, -3.5F);
        Darkindent1.setTextureSize(256, 256);
        Darkindent1.mirror = true;
        setRotation(Darkindent1, 0F, 0F, 0F);
        Neck1 = new ModelRenderer(this, 0, 96);
        Neck1.addBox(0F, 0F, 0F, 6, 29, 8);
        Neck1.setRotationPoint(-3F, -53F, -4F);
        Neck1.setTextureSize(256, 256);
        Neck1.mirror = true;
        setRotation(Neck1, 0F, 0F, 0F);
        Indent2 = new ModelRenderer(this, 0, 83);
        Indent2.addBox(0F, 0F, 0F, 10, 2, 8);
        Indent2.setRotationPoint(-5F, -24F, -4F);
        Indent2.setTextureSize(256, 256);
        Indent2.mirror = true;
        setRotation(Indent2, 0F, 0F, 0F);
        Indent1 = new ModelRenderer(this, 40, 83);
        Indent1.addBox(0F, 0F, 0F, 8, 2, 10);
        Indent1.setRotationPoint(-4F, -24F, -5F);
        Indent1.setTextureSize(256, 256);
        Indent1.mirror = true;
        setRotation(Indent1, 0F, 0F, 0F);
        smallneck2 = new ModelRenderer(this, 0, 156);
        smallneck2.addBox(0F, 0F, 0F, 9, 2, 7);
        smallneck2.setRotationPoint(-4.5F, -44F, -3.5F);
        smallneck2.setTextureSize(256, 256);
        smallneck2.mirror = true;
        setRotation(smallneck2, 0F, 0F, 0F);
        smallneck1 = new ModelRenderer(this, 39, 156);
        smallneck1.addBox(0F, 0F, 0F, 7, 2, 9);
        smallneck1.setRotationPoint(-3.5F, -44F, -4.5F);
        smallneck1.setTextureSize(256, 256);
        smallneck1.mirror = true;
        setRotation(smallneck1, 0F, 0F, 0F);
        Outerneck4 = new ModelRenderer(this, 35, 185);
        Outerneck4.addBox(-9F, 0F, 0F, 9, 2, 7);
        Outerneck4.setRotationPoint(5F, -56F, -3.5F);
        Outerneck4.setTextureSize(256, 256);
        Outerneck4.mirror = true;
        setRotation(Outerneck4, 0F, 0F, 1.413717F);
        Outerneck3 = new ModelRenderer(this, 71, 185);
        Outerneck3.addBox(0F, 0F, -9F, 7, 2, 9);
        Outerneck3.setRotationPoint(-3.5F, -56F, 5F);
        Outerneck3.setTextureSize(256, 256);
        Outerneck3.mirror = true;
        setRotation(Outerneck3, -1.413717F, 0F, 0F);
        Bottomneck2 = new ModelRenderer(this, 39, 170);
        Bottomneck2.addBox(0F, 0F, 0F, 8, 3, 10);
        Bottomneck2.setRotationPoint(-4F, -56F, -5F);
        Bottomneck2.setTextureSize(256, 256);
        Bottomneck2.mirror = true;
        setRotation(Bottomneck2, 0F, 0F, 0F);
        Outerneck2 = new ModelRenderer(this, 0, 185);
        Outerneck2.addBox(0F, 0F, 0F, 7, 2, 9);
        Outerneck2.setRotationPoint(-3.5F, -56F, -5F);
        Outerneck2.setTextureSize(256, 256);
        Outerneck2.mirror = true;
        setRotation(Outerneck2, 1.413717F, 0F, 0F);
        Outerneck1 = new ModelRenderer(this, 107, 185);
        Outerneck1.addBox(0F, 0F, 0F, 9, 2, 7);
        Outerneck1.setRotationPoint(-5F, -56F, -3.5F);
        Outerneck1.setTextureSize(256, 256);
        Outerneck1.mirror = true;
        setRotation(Outerneck1, 0F, 0F, -1.413717F);
        Bottomneck1 = new ModelRenderer(this, 0, 170);
        Bottomneck1.addBox(0F, 0F, 0F, 10, 3, 8);
        Bottomneck1.setRotationPoint(-5F, -56F, -4F);
        Bottomneck1.setTextureSize(256, 256);
        Bottomneck1.mirror = true;
        setRotation(Bottomneck1, 0F, 0F, 0F);
        Innerneck1 = new ModelRenderer(this, 0, 6);
        Innerneck1.addBox(0F, 0F, 0F, 7, 1, 7);
        Innerneck1.setRotationPoint(-3.5F, -65F, -3.5F);
        Innerneck1.setTextureSize(256, 256);
        Innerneck1.mirror = true;
        setRotation(Innerneck1, 0F, 0F, 0F);
        thinneck1 = new ModelRenderer(this, 0, 16);
        thinneck1.addBox(0F, 0F, 0F, 2, 1, 3);
        thinneck1.setRotationPoint(-1F, -67F, -1.5F);
        thinneck1.setTextureSize(256, 256);
        thinneck1.mirror = true;
        setRotation(thinneck1, 0F, 0F, 0F);
        Raisedbit2 = new ModelRenderer(this, 0, 138);
        Raisedbit2.addBox(0F, 0F, 0F, 8, 4, 10);
        Raisedbit2.setRotationPoint(-4F, -42F, -5F);
        Raisedbit2.setTextureSize(256, 256);
        Raisedbit2.mirror = true;
        setRotation(Raisedbit2, 0F, 0F, 0F);
        Raisedbit1 = new ModelRenderer(this, 41, 138);
        Raisedbit1.addBox(0F, 0F, 0F, 10, 4, 8);
        Raisedbit1.setRotationPoint(-5F, -42F, -4F);
        Raisedbit1.setTextureSize(256, 256);
        Raisedbit1.mirror = true;
        setRotation(Raisedbit1, 0F, 0F, 0F);
        Headpart4 = new ModelRenderer(this, 0, 56);
        Headpart4.addBox(0F, 0F, 0F, 10, 3, 6);
        Headpart4.setRotationPoint(-5F, -80F, -3F);
        Headpart4.setTextureSize(256, 256);
        Headpart4.mirror = true;
        setRotation(Headpart4, 0F, 0F, 0F);
        thinneck2 = new ModelRenderer(this, 0, 16);
        thinneck2.addBox(0F, 0F, 0F, 3, 1, 2);
        thinneck2.setRotationPoint(-1.5F, -67F, -1F);
        thinneck2.setTextureSize(256, 256);
        thinneck2.mirror = true;
        setRotation(thinneck2, 0F, 0F, 0F);
        Headpart9 = new ModelRenderer(this, 57, 56);
        Headpart9.addBox(0F, 0F, 0F, 3, 10, 6);
        Headpart9.setRotationPoint(3.5F, -78.5F, -3F);
        Headpart9.setTextureSize(256, 256);
        Headpart9.mirror = true;
        setRotation(Headpart9, 0F, 0F, 0F);
        Bar1 = new ModelRenderer(this, 0, 42);
        Bar1.addBox(-2F, 0F, 0F, 2, 4, 2);
        Bar1.setRotationPoint(5F, -76.5F, -1F);
        Bar1.setTextureSize(256, 256);
        Bar1.mirror = true;
        setRotation(Bar1, 0F, 0F, 0.7853982F);
        backemitter1 = new ModelRenderer(this, 16, 15);
        backemitter1.addBox(0F, 0F, 0F, 1, 1, 2);
        backemitter1.setRotationPoint(-2F, -72F, 4F);
        backemitter1.setTextureSize(256, 256);
        backemitter1.mirror = true;
        setRotation(backemitter1, 0F, 0F, 0F);
        Emitterbit1 = new ModelRenderer(this, 0, 0);
        Emitterbit1.addBox(0F, 0F, 0F, 2, 3, 1);
        Emitterbit1.setRotationPoint(-1F, -75F, -6F);
        Emitterbit1.setTextureSize(256, 256);
        Emitterbit1.mirror = true;
        setRotation(Emitterbit1, 0F, 0F, 0F);
        backemitter2 = new ModelRenderer(this, 16, 15);
        backemitter2.addBox(0F, 0F, 0F, 1, 4, 2);
        backemitter2.setRotationPoint(-2.5F, -75.5F, 4F);
        backemitter2.setTextureSize(256, 256);
        backemitter2.mirror = true;
        setRotation(backemitter2, 0F, 0F, 0F);
        Headpart2 = new ModelRenderer(this, 35, 56);
        Headpart2.addBox(0F, 0F, 0F, 3, 10, 6);
        Headpart2.setRotationPoint(-6.5F, -78.5F, -3F);
        Headpart2.setTextureSize(256, 256);
        Headpart2.mirror = true;
        setRotation(Headpart2, 0F, 0F, 0F);
        Bar2 = new ModelRenderer(this, 0, 42);
        Bar2.addBox(0F, 0F, 0F, 2, 3, 2);
        Bar2.setRotationPoint(-1F, -71.5F, -1F);
        Bar2.setTextureSize(256, 256);
        Bar2.mirror = true;
        setRotation(Bar2, 0F, 0F, 0F);
        Bar3 = new ModelRenderer(this, 0, 42);
        Bar3.addBox(0F, 0F, 0F, 2, 4, 2);
        Bar3.setRotationPoint(-5F, -76.5F, -1F);
        Bar3.setTextureSize(256, 256);
        Bar3.mirror = true;
        setRotation(Bar3, 0F, 0F, -0.7853982F);
        Headpart1 = new ModelRenderer(this, 0, 68);
        Headpart1.addBox(0F, 0F, 0F, 10, 3, 6);
        Headpart1.setRotationPoint(-5F, -70F, -3F);
        Headpart1.setTextureSize(256, 256);
        Headpart1.mirror = true;
        setRotation(Headpart1, 0F, 0F, 0F);
        Emitterbit2 = new ModelRenderer(this, 0, 0);
        Emitterbit2.addBox(0F, 0F, 0F, 3, 2, 1);
        Emitterbit2.setRotationPoint(-1.5F, -74.5F, -6F);
        Emitterbit2.setTextureSize(256, 256);
        Emitterbit2.mirror = true;
        setRotation(Emitterbit2, 0F, 0F, 0F);
        backemitter4 = new ModelRenderer(this, 16, 15);
        backemitter4.addBox(0F, 0F, 0F, 1, 4, 2);
        backemitter4.setRotationPoint(1.5F, -75.5F, 4F);
        backemitter4.setTextureSize(256, 256);
        backemitter4.mirror = true;
        setRotation(backemitter4, 0F, 0F, 0F);
        backemitter3 = new ModelRenderer(this, 16, 15);
        backemitter3.addBox(0F, 0F, 0F, 1, 1, 2);
        backemitter3.setRotationPoint(-2F, -76F, 4F);
        backemitter3.setTextureSize(256, 256);
        backemitter3.mirror = true;
        setRotation(backemitter3, 0F, 0F, 0F);
        backemitter5 = new ModelRenderer(this, 16, 15);
        backemitter5.addBox(0F, 0F, 0F, 1, 1, 2);
        backemitter5.setRotationPoint(1F, -72F, 4F);
        backemitter5.setTextureSize(256, 256);
        backemitter5.mirror = true;
        setRotation(backemitter5, 0F, 0F, 0F);
        backemitter6 = new ModelRenderer(this, 16, 15);
        backemitter6.addBox(0F, 0F, 0F, 1, 1, 2);
        backemitter6.setRotationPoint(1F, -76F, 4F);
        backemitter6.setTextureSize(256, 256);
        backemitter6.mirror = true;
        setRotation(backemitter6, 0F, 0F, 0F);
        Emitterbit5 = new ModelRenderer(this, 164, 0);
        Emitterbit5.addBox(0F, 0F, 0F, 4, 5, 8);
        Emitterbit5.setRotationPoint(-2F, -76F, -4F);
        Emitterbit5.setTextureSize(256, 256);
        Emitterbit5.mirror = true;
        setRotation(Emitterbit5, 0F, 0F, 0F);
        Emitterbit6 = new ModelRenderer(this, 134, 0);
        Emitterbit6.addBox(0F, 0F, 0F, 5, 4, 8);
        Emitterbit6.setRotationPoint(-2.5F, -75.5F, -4F);
        Emitterbit6.setTextureSize(256, 256);
        Emitterbit6.mirror = true;
        setRotation(Emitterbit6, 0F, 0F, 0F);
        Emitterbit3 = new ModelRenderer(this, 0, 0);
        Emitterbit3.addBox(0F, 0F, 0F, 3, 4, 1);
        Emitterbit3.setRotationPoint(-1.5F, -75.5F, -5F);
        Emitterbit3.setTextureSize(256, 256);
        Emitterbit3.mirror = true;
        setRotation(Emitterbit3, 0F, 0F, 0F);
        Emitterbit4 = new ModelRenderer(this, 0, 0);
        Emitterbit4.addBox(0F, 0F, 0F, 4, 3, 1);
        Emitterbit4.setRotationPoint(-2F, -75F, -5F);
        Emitterbit4.setTextureSize(256, 256);
        Emitterbit4.mirror = true;
        setRotation(Emitterbit4, 0F, 0F, 0F);
        thickneck1 = new ModelRenderer(this, 29, 199);
        thickneck1.addBox(0F, 0F, 0F, 6, 1, 7);
        thickneck1.setRotationPoint(-3F, -66F, -3.5F);
        thickneck1.setTextureSize(256, 256);
        thickneck1.mirror = true;
        setRotation(thickneck1, 0F, 0F, 0F);
        thickneck2 = new ModelRenderer(this, 0, 199);
        thickneck2.addBox(0F, 0F, 0F, 7, 1, 6);
        thickneck2.setRotationPoint(-3.5F, -66F, -3F);
        thickneck2.setTextureSize(256, 256);
        thickneck2.mirror = true;
        setRotation(thickneck2, 0F, 0F, 0F);
        Base1 = new ModelRenderer(this, 87, 0);
        Base1.addBox(0F, 0F, 0F, 9, 23, 12);
        Base1.setRotationPoint(-4.5F, -16F, -6F);
        Base1.setTextureSize(256, 256);
        Base1.mirror = true;
        setRotation(Base1, 0F, 0F, 0F);
        Base2 = new ModelRenderer(this, 40, 0);
        Base2.addBox(0F, 0F, 0F, 12, 23, 9);
        Base2.setRotationPoint(-6F, -16F, -4.5F);
        Base2.setTextureSize(256, 256);
        Base2.mirror = true;
        setRotation(Base2, 0F, 0F, 0F);
        Bottom3 = new ModelRenderer(this, 87, 0);
        Bottom3.addBox(0F, 0F, 0F, 1, 4, 12);
        Bottom3.setRotationPoint(-4.5F, 18F, -6F);
        Bottom3.setTextureSize(256, 256);
        Bottom3.mirror = true;
        setRotation(Bottom3, 0F, 0F, 0F);
        Bottom4 = new ModelRenderer(this, 40, 0);
        Bottom4.addBox(0F, 0F, 0F, 1, 4, 9);
        Bottom4.setRotationPoint(-5F, 19F, -4.5F);
        Bottom4.setTextureSize(256, 256);
        Bottom4.mirror = true;
        setRotation(Bottom4, 0F, 0F, 0F);
        Bottom1 = new ModelRenderer(this, 87, 0);
        Bottom1.addBox(0F, 0F, 0F, 8, 6, 12);
        Bottom1.setRotationPoint(-3.5F, 18F, -6F);
        Bottom1.setTextureSize(256, 256);
        Bottom1.mirror = true;
        setRotation(Bottom1, 0F, 0F, 0F);
        Bottom5 = new ModelRenderer(this, 40, 0);
        Bottom5.addBox(0F, 0F, 0F, 2, 3, 9);
        Bottom5.setRotationPoint(-6F, 18F, -4.5F);
        Bottom5.setTextureSize(256, 256);
        Bottom5.mirror = true;
        setRotation(Bottom5, 0F, 0F, 0F);
        Bottom2 = new ModelRenderer(this, 40, 0);
        Bottom2.addBox(0F, 0F, 0F, 10, 6, 9);
        Bottom2.setRotationPoint(-4F, 18F, -4.5F);
        Bottom2.setTextureSize(256, 256);
        Bottom2.mirror = true;
        setRotation(Bottom2, 0F, 0F, 0F);
        Curvebit1 = new ModelRenderer(this, 87, 0);
        Curvebit1.addBox(0F, 0F, 0F, 2, 2, 12);
        Curvebit1.setRotationPoint(-3.5F, 10.5F, -6F);
        Curvebit1.setTextureSize(256, 256);
        Curvebit1.mirror = true;
        setRotation(Curvebit1, 0F, 0F, 0F);
        Curvebit2 = new ModelRenderer(this, 40, 0);
        Curvebit2.addBox(0F, 0F, 0F, 12, 5, 9);
        Curvebit2.setRotationPoint(-6F, 12F, -4.5F);
        Curvebit2.setTextureSize(256, 256);
        Curvebit2.mirror = true;
        setRotation(Curvebit2, 0F, 0F, 0F);
        Curvebit3 = new ModelRenderer(this, 87, 0);
        Curvebit3.addBox(0F, 0F, 0F, 9, 5, 12);
        Curvebit3.setRotationPoint(-4.5F, 12F, -6F);
        Curvebit3.setTextureSize(256, 256);
        Curvebit3.mirror = true;
        setRotation(Curvebit3, 0F, 0F, 0F);
        Curvebit4 = new ModelRenderer(this, 87, 9);
        Curvebit4.addBox(0F, 0F, 0F, 3, 2, 3);
        Curvebit4.setRotationPoint(-6F, 11F, 1.5F);
        Curvebit4.setTextureSize(256, 256);
        Curvebit4.mirror = true;
        setRotation(Curvebit4, 0F, 0F, 0F);
        Curvebit5 = new ModelRenderer(this, 87, 0);
        Curvebit5.addBox(0F, 0F, 0F, 9, 1, 12);
        Curvebit5.setRotationPoint(-4.5F, 11.5F, -6F);
        Curvebit5.setTextureSize(256, 256);
        Curvebit5.mirror = true;
        setRotation(Curvebit5, 0F, 0F, 0F);
        Curvebit6 = new ModelRenderer(this, 40, 0);
        Curvebit6.addBox(0F, 0F, 0F, 7, 5, 9);
        Curvebit6.setRotationPoint(-1F, 7F, -4.5F);
        Curvebit6.setTextureSize(256, 256);
        Curvebit6.mirror = true;
        setRotation(Curvebit6, 0F, 0F, 0F);
        Curvebit7 = new ModelRenderer(this, 87, 13);
        Curvebit7.addBox(0F, 0F, 0F, 3, 2, 6);
        Curvebit7.setRotationPoint(-4.5F, 6.5F, -6F);
        Curvebit7.setTextureSize(256, 256);
        Curvebit7.mirror = true;
        setRotation(Curvebit7, 0F, 0F, 0F);
        Darkcurve1 = new ModelRenderer(this, 40, 37);
        Darkcurve1.addBox(0F, 0F, 0F, 4, 2, 8);
        Darkcurve1.setRotationPoint(-5F, 10F, -4.5F);
        Darkcurve1.setTextureSize(256, 256);
        Darkcurve1.mirror = true;
        setRotation(Darkcurve1, 0F, 0F, 0F);
        Curvebit8 = new ModelRenderer(this, 87, 9);
        Curvebit8.addBox(0F, 0F, 0F, 2, 3, 5);
        Curvebit8.setRotationPoint(-6F, 6.5F, -4.5F);
        Curvebit8.setTextureSize(256, 256);
        Curvebit8.mirror = true;
        setRotation(Curvebit8, 0F, 0F, 0F);
        Curvebit9 = new ModelRenderer(this, 87, 9);
        Curvebit9.addBox(0F, 0F, 0F, 2, 2, 4);
        Curvebit9.setRotationPoint(-6F, 7F, 0.5F);
        Curvebit9.setTextureSize(256, 256);
        Curvebit9.mirror = true;
        setRotation(Curvebit9, 0F, 0F, 0F);
        Darkcurve2 = new ModelRenderer(this, 40, 41);
        Darkcurve2.addBox(0F, 0F, 0F, 3, 3, 5);
        Darkcurve2.setRotationPoint(-4F, 8F, -0.5F);
        Darkcurve2.setTextureSize(256, 256);
        Darkcurve2.mirror = true;
        setRotation(Darkcurve2, 0F, 0F, 0F);
        Darkcurve3 = new ModelRenderer(this, 40, 37);
        Darkcurve3.addBox(0F, 0F, 0F, 4, 2, 8);
        Darkcurve3.setRotationPoint(-5F, 9.5F, -4.5F);
        Darkcurve3.setTextureSize(256, 256);
        Darkcurve3.mirror = true;
        setRotation(Darkcurve3, 0F, 0F, 0F);
        Darkcurve4 = new ModelRenderer(this, 40, 41);
        Darkcurve4.addBox(0F, 0F, 0F, 1, 2, 5);
        Darkcurve4.setRotationPoint(-5F, 9F, -0.5F);
        Darkcurve4.setTextureSize(256, 256);
        Darkcurve4.mirror = true;
        setRotation(Darkcurve4, 0F, 0F, 0F);
        Endbit1 = new ModelRenderer(this, 87, 0);
        Endbit1.addBox(0F, 0F, 0F, 6, 3, 12);
        Endbit1.setRotationPoint(-1.5F, 9F, -6F);
        Endbit1.setTextureSize(256, 256);
        Endbit1.mirror = true;
        setRotation(Endbit1, 0F, 0F, 0F);
        Curvebit10 = new ModelRenderer(this, 87, 0);
        Curvebit10.addBox(0F, 0F, 0F, 6, 2, 12);
        Curvebit10.setRotationPoint(-1.5F, 7F, -6F);
        Curvebit10.setTextureSize(256, 256);
        Curvebit10.mirror = true;
        setRotation(Curvebit10, 0F, 0F, 0F);
        Darkcurve5 = new ModelRenderer(this, 40, 37);
        Darkcurve5.addBox(0F, 0F, 0F, 3, 2, 5);
        Darkcurve5.setRotationPoint(-4F, 8F, -4.5F);
        Darkcurve5.setTextureSize(256, 256);
        Darkcurve5.mirror = true;
        setRotation(Darkcurve5, 0F, 0F, 0F);
        Curvebit11 = new ModelRenderer(this, 87, 11);
        Curvebit11.addBox(0F, 0F, 0F, 3, 1, 6);
        Curvebit11.setRotationPoint(-4.5F, 7F, 0F);
        Curvebit11.setTextureSize(256, 256);
        Curvebit11.mirror = true;
        setRotation(Curvebit11, 0F, 0F, 0F);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }


    @Override
    public void renderModel(float scale) {
        GL11.glScalef(0.2F, 0.2F, 0.2F);
        Indent5.render(scale);
        Indent6.render(scale);
        Darkbottom2.render(scale);
        Darkbottom1.render(scale);
        Neck2.render(scale);
        Darkindent2.render(scale);
        Indent4.render(scale);
        Indent3.render(scale);
        Darkindent1.render(scale);
        Neck1.render(scale);
        Indent2.render(scale);
        Indent1.render(scale);
        smallneck2.render(scale);
        smallneck1.render(scale);
        Outerneck4.render(scale);
        Outerneck3.render(scale);
        Bottomneck2.render(scale);
        Outerneck2.render(scale);
        Outerneck1.render(scale);
        Bottomneck1.render(scale);
        Innerneck1.render(scale);
        thinneck1.render(scale);
        Raisedbit2.render(scale);
        Raisedbit1.render(scale);
        Headpart4.render(scale);
        thinneck2.render(scale);
        Headpart2.render(scale);
        Bar1.render(scale);
        backemitter1.render(scale);
        Emitterbit1.render(scale);
        backemitter2.render(scale);
        Headpart9.render(scale);
        Bar2.render(scale);
        Bar3.render(scale);
        Headpart1.render(scale);
        Emitterbit2.render(scale);
        backemitter4.render(scale);
        backemitter3.render(scale);
        backemitter5.render(scale);
        backemitter6.render(scale);
        Emitterbit5.render(scale);
        Emitterbit6.render(scale);
        Emitterbit3.render(scale);
        Emitterbit4.render(scale);
        thickneck1.render(scale);
        thickneck2.render(scale);
        Base1.render(scale);
        Base2.render(scale);
        Bottom3.render(scale);
        Bottom4.render(scale);
        Bottom1.render(scale);
        Bottom5.render(scale);
        Bottom2.render(scale);
        Curvebit1.render(scale);
        Curvebit2.render(scale);
        Curvebit3.render(scale);
        Curvebit4.render(scale);
        Curvebit5.render(scale);
        Curvebit6.render(scale);
        Curvebit7.render(scale);
        Darkcurve1.render(scale);
        Curvebit8.render(scale);
        Curvebit9.render(scale);
        Darkcurve2.render(scale);
        Darkcurve3.render(scale);
        Darkcurve4.render(scale);
        Endbit1.render(scale);
        Curvebit10.render(scale);
        Darkcurve5.render(scale);
        Curvebit11.render(scale);
    }

    @Override
    public IModelState getTransforms() {
        Map<ItemCameraTransforms.TransformType, TRSRTransformation> map = new HashMap<>();
        map.put(ItemCameraTransforms.TransformType.GUI, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(0F, 1.0F, 0F), new Vector3f(0.5F, 0.5F, 0), new Vector3f(1F, 1F, 1F))));
        map.put(ItemCameraTransforms.TransformType.GROUND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(-90F, 0F, 0F), new Vector3f(0.5F, 0.3F, 0.5F), new Vector3f(1F, 1F, 1F))));
        map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -120F, 0F), new Vector3f(1F, 0.3F, 0F), new Vector3f(1F, 1F, 1F))));
        map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -110, 0F), new Vector3f(1.4F, 0.7F, 0.9F), new Vector3f(1F, 1F, 1F))));
        map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, 0.5F), new Vector3f(0.7F, 0.7F, 0.7F))));
        map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, -0.2F), new Vector3f(0.7F, 0.7F, 0.7F))));
        map.put(ItemCameraTransforms.TransformType.FIXED, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(0F, 0F, 0F), new Vector3f(0.5F, 0.5F, 0.5F), new Vector3f(1F, 1F, 1F))));
        return new LCModelState(map);
    }

}
