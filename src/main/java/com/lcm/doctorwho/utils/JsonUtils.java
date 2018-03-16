package com.lcm.doctorwho.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import com.lcm.doctorwho.AcrossTheGalaxy;
import net.minecraft.client.Minecraft;

import java.io.*;

public class JsonUtils {

	private static String mod_path = Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "/mods/Json Files";

	//Generates basic item jsons
	public static void item(String itemName, String textureName) {
		File fileDir = new File(mod_path + "\\models\\item\\");
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}

		try {

			Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + itemName + ".json"), "UTF-8");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonWriter jw = gson.newJsonWriter(writer);

			jw.beginObject();
			jw.name("parent").value("item/generated");
			jw.name("textures");
			jw.beginObject();
			jw.name("layer0").value(AcrossTheGalaxy.MODID + ":items/" + textureName);
			jw.endObject();
			jw.endObject();
			jw.close();
			writer.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//This only generates basic block blockstates with ONE variant (I'll add support for multiple later)
	public static void Block(String blockName, String textureName) {

		File fileDir = new File(mod_path + "\\blockstates\\");
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}

		try {

			Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonWriter jw = gson.newJsonWriter(writer);

			jw.beginObject();
			jw.name("variants");
			jw.beginObject();
			jw.name("normal");
			jw.beginObject();
			jw.name("model").value(AcrossTheGalaxy.MODID + ":" + blockName);
			jw.endObject();
			jw.endObject();
			jw.endObject();
			jw.close();
			writer.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		blockModel(blockName, textureName, mod_path);
		blockItemModel(blockName);

	}

	//Generates basic block model
	private static void blockModel(String blockName, String textureName, String path) {

		File fileDir = new File(path + "\\models\\block\\");
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}

		try {

			Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonWriter jw = gson.newJsonWriter(writer);

			jw.beginObject();
			jw.name("parent").value("block/cube_all");
			jw.name("textures");
			jw.beginObject();
			jw.name("all").value(AcrossTheGalaxy.MODID + ":blocks/" + textureName);
			jw.endObject();
			jw.endObject();
			jw.close();
			writer.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//Generates Item block model
	private static void blockItemModel(String blockName) {

		File fileDir = new File(mod_path + "\\models\\item\\");
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}

		try {

			Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonWriter jw = gson.newJsonWriter(writer);

			jw.beginObject();
			jw.name("parent").value(AcrossTheGalaxy.MODID + ":block/" + blockName);

			jw.endObject();
			jw.close();
			writer.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
