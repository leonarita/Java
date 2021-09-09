package aula17.exercicio1;

import java.lang.reflect.Method;

public class LetraB {
	
	public static void main(String... args) {
		
		// Com reflexão
		try {
			Class<?> systemClass = Class.forName("java.lang.System");
			Object outObject = systemClass.getField("out").get(null);
			Method printlnMethod = outObject.getClass().getMethod("println", new Class[] { String.class });			
			printlnMethod.invoke(outObject, "Hello World");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
