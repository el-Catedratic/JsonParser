package com.jsonparser.aksonparser.parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.json.JSONObject;

public class AksonParser {

	public static<T> T parseToObject(String json , Class<T> cls) {
		JSONObject jsonObj = new JSONObject(json);
		try {
			Constructor<T> constructor = cls.getDeclaredConstructor();
			constructor.setAccessible(true);
			T instance = constructor.newInstance();
			return parseObject(jsonObj,instance);
		}
		catch(IllegalAccessException | NoSuchMethodException | SecurityException | InstantiationException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T parseObject(JSONObject jsonObj, T instance) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		for(var field : instance.getClass().getDeclaredFields()) {
			String name = field.getName();
			if(jsonObj.has(name)) {
				Object value = jsonObj.get(name);
				field.setAccessible(true);
				field.set(instance, value);
			}
		}
		return instance;
	}
	
}
