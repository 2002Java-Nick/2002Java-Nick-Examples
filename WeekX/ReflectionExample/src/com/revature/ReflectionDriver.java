package com.revature;

import java.lang.reflect.Field;

public class ReflectionDriver {

	public static void main(String[] args) {

		String var = "Foo";
		
		System.out.println("Initial contents: " + var);
		
		Class<String> stringClass = String.class;
		
		try {
			Field field = stringClass.getDeclaredField("value");
			field.setAccessible(true);
			field.set(var, "Something Different".toCharArray());
			System.out.println("New contents: " + var);
			System.out.println("Foo");
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
