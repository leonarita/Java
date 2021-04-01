package testes.annotations;

import java.lang.reflect.Method;
import testes.annotations.v2.ReadCharacteres;

public class ValidatorsMethod {
	
	public static <T> void setDataAtInterface(T objeto) {
				
		Class<?> classe = objeto.getClass();
		
		for(Method method : classe.getMethods()) {
			
			if(method.isAnnotationPresent(ReadCharacteres.class) ) {
				
				try {

					method.getDefaultValue();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
