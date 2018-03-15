package com.lcm.doctorwho.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import com.lcm.doctorwho.common.capabilities.interfaces.ITardisTile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TardisUtils {
	
	public static NBTTagCompound tardisWriteToNBT(ITardisTile capa) {
		NBTTagCompound nbtTag = new NBTTagCompound();
		nbtTag.setInteger("tardisID", capa.getTardisID());
		nbtTag.setString("ownerUUID", capa.getOwner());
		nbtTag.setInteger("modelID", capa.getModelID());
		nbtTag.setBoolean("doorOpen", capa.isDoorOpen());
		return nbtTag;
	}
	
	public static ITardisTile tardisReadFromNBT(ITardisTile capa, NBTTagCompound nbt) {
		capa.setTardisID(nbt.getInteger("tardisID"));
		capa.setOwner(nbt.getString("ownerUUID"));
		capa.setModelID(nbt.getInteger("modelID"));
		capa.setDoorOpen(nbt.getBoolean("doorOpen"));
		return capa;
	}
	
	public static void saveTardis(ITardisTile capa, BlockPos interior, BlockPos exterior, int dim_id) throws IOException {
		FMLCommonHandler fml = FMLCommonHandler.instance();
		File fileDir = new File(FMLCommonHandler.instance().getSavesDirectory() + "\\" + fml.getMinecraftServerInstance().getWorldName() + "\\data\\tardis_info\\");
		if (!fileDir.exists()) fileDir.mkdirs();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + "tardis_" + capa.getTardisID() + ".tardis"), "UTF-8"); JsonWriter jw = gson.newJsonWriter(writer)) {
			
			jw.beginObject();
			
			jw.name("int_x").value(interior.getX());
			jw.name("int_y").value(interior.getY());
			jw.name("int_z").value(interior.getZ());
			
			jw.name("ext_x").value(exterior.getX());
			jw.name("ext_y").value(exterior.getY());
			jw.name("ext_z").value(exterior.getZ());
			
			jw.name("ext_dim").value(dim_id);
			jw.name("doorOpen").value(capa.isDoorOpen());
			jw.endObject();
			
		} catch (UnsupportedEncodingException e) {
			throw new Error("UTF-8 does not exist on this system", e);
		}
	}
	
	public static int getTardisAmount() throws IOException {
		FMLCommonHandler fml = FMLCommonHandler.instance();
		File file = new File(FMLCommonHandler.instance().getSavesDirectory() + "\\" + fml.getMinecraftServerInstance().getWorldName() + "\\data\\tardis_info");
		if (!file.exists()) {
			file.mkdirs();
		}
		return Math.toIntExact(Files.list(Paths.get(FMLCommonHandler.instance().getSavesDirectory() + "\\" + fml.getMinecraftServerInstance().getWorldName() + "\\data\\tardis_info")).count());
	}
	
	public static TardisInfo loadInfoFromFile(int id) {
		FMLCommonHandler fml = FMLCommonHandler.instance();
		File info_file = new File(FMLCommonHandler.instance().getSavesDirectory() + "\\" + fml.getMinecraftServerInstance().getWorldName() + "\\data\\tardis_info" + "\\" + "tardis_" + id + ".tardis");
		if (!info_file.exists()) {
			return null;
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(info_file));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			TardisInfo info = JsonGenUtil.gson.fromJson(sb.toString(), TardisInfo.class);
			return info;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public static BlockPos newInteriorPos() throws IOException {
		BlockPos pos = new BlockPos(64 + 100 * getTardisAmount(), 64, 64 + 100 * getTardisAmount());
		return pos;
	}
	
	public static class TardisInfo {
		double int_x;
		double int_y;
		double int_z;
		
		double ext_x;
		double ext_y;
		double ext_z;
		int ext_dim;
		boolean doorOpen;
		
		public void setInteriorX(double int_x) {
			this.int_x = int_x;
		}
		
		public void setInteriorY(double int_y) {
			this.int_y = int_y;
		}
		
		public void setInteriorZ(double int_z) {
			this.int_z = int_z;
		}
		
		public void setExteriorX(double ext_x) {
			this.ext_x = ext_x;
		}
		
		public void setExteriorY(double ext_y) {
			this.ext_y = ext_y;
		}
		
		public void setExteriorZ(double ext_z) {
			this.ext_z = ext_z;
		}
		
		public double getExteriorX() {
			return ext_x;
		}
		
		public double getExteriorY() {
			return ext_y;
		}
		
		public double getExteriorZ() {
			return ext_z;
		}
		
		public double getInteriorX() {
			return int_x;
		}
		
		public double getInteriorY() {
			return int_y;
		}
		
		public double getInteriorZ() {
			return int_z;
		}
		
		public int getExteriorDim() {
			return ext_dim;
		}
		
		public void setExteriorDim(int ext_dim) {
			this.ext_dim = ext_dim;
		}
		
		public void setDoorOpen(boolean doorOpen) {
			this.doorOpen = doorOpen;
		}
		
		public boolean isDoorOpen() {
			return doorOpen;
		}
	}
	
}
