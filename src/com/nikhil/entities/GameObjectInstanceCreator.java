package com.nikhil.entities;

import java.awt.Graphics;
import java.lang.reflect.Type;

import org.ietf.jgss.GSSManager;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class GameObjectInstanceCreator implements JsonDeserializer<GameObject>{

	public GameObjectInstanceCreator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public GameObject deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject jsonObject = (JsonObject) arg0;
		return null;
	}

}
