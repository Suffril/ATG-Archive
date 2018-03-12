package com.lcm.doctorwho.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import com.lcm.doctorwho.AcrossTheGalaxy;

import net.minecraft.client.Minecraft;

public class JsonGenUtil {
	
	public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private static String mod_path = Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "/mods/Json Files"; // FIXME WTF
	
	// Generates basic item jsons
	public static void item(String itemName, String textureName) throws IOException {
		File fileDir = new File(mod_path + "\\models\\item\\");
		if (!fileDir.exists()) fileDir.mkdirs();
		
		try (Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + itemName + ".json"), "UTF-8"); JsonWriter jw = gson.newJsonWriter(writer)) {
			
			jw.beginObject();
			jw.name("parent").value("item/generated");
			jw.name("textures");
			jw.beginObject();
			jw.name("layer0").value(AcrossTheGalaxy.MODID + ":items/" + textureName);
			jw.endObject();
			jw.endObject();
		} catch (UnsupportedEncodingException e) {
			throw new Error("UTF-8 does not exist on this system", e);
		}
	}
	
	// This only generates basic block blockstates with ONE variant (I'll add support for multiple later)
	public static void block(String blockName, String textureName) throws IOException {
		File fileDir = new File(mod_path + "\\blockstates\\");
		if (!fileDir.exists()) fileDir.mkdirs();
		
		try (Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8"); JsonWriter jw = gson.newJsonWriter(writer)) {
			jw.beginObject();
			jw.name("variants");
			jw.beginObject();
			jw.name("normal");
			jw.beginObject();
			jw.name("model").value(AcrossTheGalaxy.MODID + ":" + blockName);
			jw.endObject();
			jw.endObject();
			jw.endObject();
		} catch (UnsupportedEncodingException e) {
			throw new Error("UTF-8 does not exist on this system", e);
		}
		
		blockModel(blockName, textureName, mod_path);
		blockItemModel(blockName);
	}
	
	// Generates basic block model
	private static void blockModel(String blockName, String textureName, String path) throws IOException {
		File fileDir = new File(path + "\\models\\block\\");
		if (!fileDir.exists()) fileDir.mkdirs();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8"); JsonWriter jw = gson.newJsonWriter(writer)) {
			jw.beginObject();
			jw.name("parent").value("block/cube_all");
			jw.name("textures");
			jw.beginObject();
			jw.name("all").value(AcrossTheGalaxy.MODID + ":blocks/" + textureName);
			jw.endObject();
			jw.endObject();
		} catch (UnsupportedEncodingException e) {
			throw new Error("UTF-8 does not exist on this system", e);
		}
	}
	
	// Generates Item block model
	private static void blockItemModel(String blockName) throws IOException {
		File fileDir = new File(mod_path + "\\models\\item\\");
		if (!fileDir.exists()) fileDir.mkdirs();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8"); JsonWriter jw = gson.newJsonWriter(writer);) {
			jw.beginObject();
			jw.name("parent").value(AcrossTheGalaxy.MODID + ":block/" + blockName);
			jw.endObject();
		} catch (UnsupportedEncodingException e) {
			throw new Error("UTF-8 does not exist on this system", e);
		}
		
	}
	
}
