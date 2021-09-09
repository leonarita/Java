package file.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FormatterString {
	
	public static String format(Object obj, String methodName, Class<?> clazz) {
		
		try {
			
			Method method = clazz.getMethod(methodName);
			String value = method.invoke(obj).toString();
			
			if(method.isAnnotationPresent(Position.class)) {
				Position position = method.getAnnotation(Position.class);

				if(position.length() > value.length()) {
					value = value.concat(" ".repeat(position.length() - value.length()));
				}
			}
			
			System.out.println("Value: '" + value + "'");
			
			return value;
		
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
