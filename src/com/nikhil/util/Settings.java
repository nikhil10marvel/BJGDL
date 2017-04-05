package com.nikhil.util;

import java.awt.Color;
import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.nikhil.core.Handler;
import com.nikhil.entities.GameObject;
import com.nikhil.entities.GameObjectInstanceCreator;

public class Settings {
	
	protected float height;
	protected float width;
	protected String title;
	transient Handler handler;
	public boolean dispose = false;
	
	public transient LevelLoader level_loader;
	
	public transient LoadScheme[] schemes;

	@SerializedName("level.loader.default_pallet")
	public static Color[] default_pallet = {
			Color.black,
			Color.red,
			Color.yellow,
			Color.cyan,
			Color.orange,
			Color.PINK,
			Color.MAGENTA,
			Color.gray,
			Color.blue,
			Color.white
	};
	
	@SerializedName("level.loader.pallet")
	public Color[] pallet;
	
	
	public float getHeight() {
		return height;
	}
	
	public Settings(){
		handler = new Handler();
		level_loader = new LevelLoader(this);
		schemes = new LoadScheme[10];
	}
	
	public Settings(int scheme_size){
		handler = new Handler();
		level_loader = new LevelLoader(this);
		schemes = new LoadScheme[scheme_size];
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isDispose() {
		return dispose;
	}

	public void setDispose(boolean dispose) {
		this.dispose = dispose;
	}
	
	public Handler getHandler(){
		return handler;
	}

	public void loadSettings(String file_path){
		Gson gson = getBuilder().create();
		String data = readFile(new File(file_path));
		//System.out.println(data);	//#Debug
		Settings set = gson.fromJson(data, Settings.class);
		height = set.getHeight();
		width = set.getWidth();
		title = set.getTitle();
		dispose = set.isDispose();
		pallet = set.pallet;
		default_pallet = set.default_pallet;
		System.out.println(toString());
	}
	
	public void saveSettings(String file_path){
		Gson gson = getBuilder().setPrettyPrinting().create();
		String data = gson.toJson(this);
		//System.out.println(data);	//#Debug
		writeFile(new File(file_path), data);
	}
	
	public void saveSettings(OutputStream outputStream){
		Gson gson = getBuilder().setPrettyPrinting().create();
		String data = gson.toJson(this);
		//System.out.println(data); //#Debug
		writeOutputStream(outputStream, data);
	}
	
	public void loadSettings(InputStream inputStream){
		Gson gson = getBuilder().create();
		String data = readInputStream(inputStream);
		//System.out.println(data); //#Debug
		Settings set = gson.fromJson(data, Settings.class);
		height = set.getHeight();
		width = set.getWidth();
		title = set.getTitle();
		dispose = set.isDispose();
		pallet = set.pallet;
		default_pallet = set.default_pallet;
		System.out.println(toString());
	}
	
	private GsonBuilder getBuilder(){
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(GameObject.class, new GameObjectInstanceCreator());
		return builder;
	}
	
	public String toString(){
		return "Settings[" + height + "," + width + "," + title + "," + dispose + "] " + "Load Schemes: " + schemes.toString();
	}
	
	private String writeFile(File file, String str){
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			bw.write(str);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	private void writeOutputStream(OutputStream outputStream, String str){
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream))){
			bw.write(str);
		} catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	private String readFile(File file){
		String line;
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			while((line = br.readLine()) != null){
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	private String readInputStream(InputStream inputStream){
		String line;
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
			while((line = br.readLine()) != null){
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	private ArrayList<LoadScheme> getSchemeFromJSON(String gson){
		java.lang.reflect.Type listType = new TypeToken<ArrayList<LoadScheme>>(){}.getType();
		ArrayList<LoadScheme> list = new Gson().fromJson(gson, listType);
		return list;
	}
	
}
