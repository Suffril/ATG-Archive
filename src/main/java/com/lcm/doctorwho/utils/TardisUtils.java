package com.lcm.doctorwho.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.common.capabilities.ITardis;

import jdk.nashorn.internal.ir.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TardisUtils {

	public static NBTTagCompound tardisWriteToNBT(ITardis capa) {
		NBTTagCompound nbtTag = new NBTTagCompound();
		nbtTag.setInteger("tardisID", capa.getTardisID());
		nbtTag.setString("ownerUUID", capa.getOwner());
		nbtTag.setInteger("modelID", capa.getModelID());
		nbtTag.setBoolean("doorOpen", capa.isDoorOpen());
        nbtTag.setLong("interiorPos", capa.getInteriorPos());
        nbtTag.setLong("exteriorPos", capa.getExteriorPos());
		return nbtTag;
	}

	public static ITardis tardisReadFromNBT(ITardis capa, NBTTagCompound nbt) {
		capa.setTardisID(nbt.getInteger("tardisID"));
		capa.setOwner(nbt.getString("ownerUUID"));
		capa.setModelID(nbt.getInteger("modelID"));
		capa.setDoorOpen(nbt.getBoolean("doorOpen"));
		capa.setInteriorPos(nbt.getLong("interiorPos"));
		capa.setExteriorPos(nbt.getLong("exteriorPos"));
		return capa;
	}

	public static void saveTardis(int ID, BlockPos interior, BlockPos exterior, int dim_id) throws IOException {
		FMLCommonHandler fml = FMLCommonHandler.instance();
		File fileDir = new File(FMLCommonHandler.instance().getSavesDirectory() + "\\" + fml.getMinecraftServerInstance().getWorldName() + "\\data\\tardis_info\\");
		if (!fileDir.exists()) fileDir.mkdirs();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + "tardis_" + ID + ".tardis"), "UTF-8"); JsonWriter jw = gson.newJsonWriter(writer)) {

			jw.beginObject();
            jw.name("tardis_id").value(ID);
            jw.name("exterior_pos").value(interior.toLong());
            jw.name("interior_pos").value(exterior.toLong());
            jw.name("dim").value(dim_id);
			jw.endObject();

		} catch (UnsupportedEncodingException e) {
			throw new Error("UTF-8 does not exist on this system", e);
		}
	}

	public static int getTardisAmount() throws IOException {
        FMLCommonHandler fml = FMLCommonHandler.instance();
        return Math.toIntExact(Files.list(Paths.get(FMLCommonHandler.instance().getSavesDirectory() + "\\" + fml.getMinecraftServerInstance().getWorldName() + "\\data\\tardis_info")).count());
    }

}
