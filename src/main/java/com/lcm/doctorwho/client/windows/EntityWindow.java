package com.lcm.doctorwho.client.windows;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import java.awt.image.BufferedImage;
import java.nio.IntBuffer;
import java.util.Random;

/**
 * Created by Nictogen on 2/19/18
 */
public class EntityWindow extends Entity
{
	public BufferedImage image;
	public boolean rendering;

	private static DataParameter<Integer> WINDOW = EntityDataManager.createKey(EntityWindow.class, DataSerializers.VARINT);

	public EntityWindow(World worldIn)
	{
		super(worldIn);
	}

	public EntityWindow(World worldIn, double x, double y, double z)
	{
		super(worldIn);
		this.setPositionAndUpdate(x, y, z);
	}

	@Override public void onEntityUpdate() { }

	@Override protected void readEntityFromNBT(NBTTagCompound compound) {

	}

	@Override protected void writeEntityToNBT(NBTTagCompound compound) {

	}

	@Override
	protected void entityInit() {
		getDataManager().register(WINDOW, new Random().nextInt(100));
	}

	@Override public void onUpdate() {
		if(this.ticksExisted > 200)
			this.setDead();
	}

	public EntityCamera getPairedCamera(){
		if(FakeWorldHandler.fakeWorld.loadedEntityList.stream().anyMatch(entity -> entity.getEntityId() == dataManager.get(WINDOW))){
			return (EntityCamera) FakeWorldHandler.fakeWorld.loadedEntityList.stream().filter(entity -> entity.getEntityId() == dataManager.get(WINDOW)).findFirst().get();
		} else {
			EntityCamera camera = new EntityCamera(posX, posY, posZ);
			camera.setEntityId(dataManager.get(WINDOW));
			FakeWorldHandler.fakeWorld.spawnEntity(camera);
			return camera;
		}
//		return (EntityWindow) world.getEntityByID(dataManager.get(WINDOW));
	}

	public void renderWorldToTexture(float partialRenderTicks) {
		if(!world.isRemote) return;

		Framebuffer mcBuffer = Minecraft.getMinecraft().getFramebuffer();

		EntityCamera camera = getPairedCamera();
		Minecraft.getMinecraft().setRenderViewEntity(camera);
		EntityPlayerSP player = Minecraft.getMinecraft().player;
		Minecraft.getMinecraft().player = camera;

		Framebuffer framebuffer = new Framebuffer(500, 500, true);

		Minecraft mc = Minecraft.getMinecraft();
		if (mc.skipRenderWorld) return;
		EntityRenderer entityRenderer = mc.entityRenderer;

		//Backup current render settings
		int heightBackup = mc.displayHeight;
		int widthBackup = mc.displayWidth;

		int thirdPersonBackup = mc.gameSettings.thirdPersonView;
		boolean hideGuiBackup = mc.gameSettings.hideGUI;
		int particleBackup = mc.gameSettings.particleSetting;
		boolean anaglyphBackup = mc.gameSettings.anaglyph;
		int renderDistanceBackup = mc.gameSettings.renderDistanceChunks;
		float FOVbackup = mc.gameSettings.fovSetting;

		//Render world
		try {
			//Set all of the render setting to work on the proxy world
			mc.displayHeight = framebuffer.framebufferWidth;
			mc.displayWidth = framebuffer.framebufferHeight;

			mc.gameSettings.thirdPersonView = 0;
			mc.gameSettings.hideGUI = true;
			mc.gameSettings.anaglyph = false;

			//Set gl options
			framebuffer.bindFramebuffer(true);

			int i1 = mc.gameSettings.limitFramerate;
			if (mc.isFramerateLimitBelowMax()) {
				entityRenderer.renderWorld(partialRenderTicks, (1000000000 / i1));
			} else {
				entityRenderer.renderWorld(partialRenderTicks, 0L);
			}

			//toBufferedImage
			int i = mc.displayHeight * mc.displayWidth;

			IntBuffer pixelBuffer = BufferUtils.createIntBuffer(i);
			int[] pixelValues = new int[i];

			GlStateManager.glPixelStorei(3333, 1);
			GlStateManager.glPixelStorei(3317, 1);
			pixelBuffer.clear();

			GlStateManager.glReadPixels(0, 0, mc.displayWidth, mc.displayHeight, 32993, 33639, pixelBuffer);

			pixelBuffer.get(pixelValues);
			TextureUtil.processPixelValues(pixelValues, mc.displayWidth, mc.displayHeight);
			BufferedImage bufferedimage = new BufferedImage(mc.displayWidth, mc.displayHeight, 1);
			bufferedimage.setRGB(0, 0, mc.displayWidth, mc.displayWidth, pixelValues, 0, mc.displayHeight);

			this.image = bufferedimage;
		} catch (Exception e) {
			try {
				//Clean up the tessellator, just in case.
				Tessellator.getInstance().draw();
			} catch (Exception e2) {
				//It might throw an exception, but that just means we didn't need to clean it up (this time)
			}
			throw new RuntimeException("Error while rendering proxy world", e);
		} finally {
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			framebuffer.bindFramebufferTexture();
			GL11.glViewport(0, 0, widthBackup, heightBackup);
			GL11.glLoadIdentity();

			mc.player = player;
			mc.gameSettings.thirdPersonView = thirdPersonBackup;
			mc.gameSettings.hideGUI = hideGuiBackup;
			mc.gameSettings.particleSetting = particleBackup;
			mc.gameSettings.anaglyph = anaglyphBackup;
			mc.gameSettings.renderDistanceChunks = renderDistanceBackup;
			mc.gameSettings.fovSetting = FOVbackup;

			mc.displayHeight = heightBackup;
			mc.displayWidth = widthBackup;
		}

		framebuffer.deleteFramebuffer();
		mcBuffer.bindFramebuffer(true);
		Minecraft.getMinecraft().setRenderViewEntity(Minecraft.getMinecraft().player);
	}
}
