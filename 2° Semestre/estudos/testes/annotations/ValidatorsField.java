package testes.annotations;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

import testes.annotations.v1.CPF;
import testes.annotations.v1.IdadeMinima;
import testes.annotations.v1.Length;

public class ValidatorsField {
	
	public static <T> boolean validateCPF(T objeto) {
		Class<?> classe = objeto.getClass();
		
		for(Field field : classe.getDeclaredFields()) {
			
			if(field.isAnnotationPresent(CPF.class) ) {
				
				try {
					
					field.setAccessible(true);

					String val = ((String)field.get(objeto)).replace(".", "").replace("-", "");
					
					field.setAccessible(false);

					return val.length() == 11;
				}
				catch(IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return false;
	}
	
	public static <T> boolean validador(T objeto) {
		Class<?> classe = objeto.getClass();

		for (Field field : classe.getDeclaredFields()) {

			if (field.isAnnotationPresent(IdadeMinima.class)) {

				IdadeMinima idadeMinima = field.getAnnotation(IdadeMinima.class);

				try {
					field.setAccessible(true);
					LocalDate dataNascimento = (LocalDate) field.get(objeto);

					return Period.between(dataNascimento, LocalDate.now()).getYears() >= idadeMinima.valor();
				} 
				catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	
	public static <T> boolean validadorName(T objeto) {
		Class<?> classe = objeto.getClass();

		for (Field field : classe.getDeclaredFields()) {

			if (field.isAnnotationPresent(Length.class)) {

				Length length = field.getAnnotation(Length.class);

				try {
					field.setAccessible(true);

					String val = ((String)field.get(objeto));
										
					if (length.min() > val.length() || length.max() < val.length()) {
						return false;
					}
					
					if(length.rules().length != 0 && !length.rules()[0].equals("")) {

						for (String s : length.rules()) {
							
							if(s.startsWith("contains ")) {
								s = s.replace("contains ", "").replace("'", "");
								
								if(!val.contains(s)) {
									return false;
								}
							}
							else if(s.startsWith("at least ")) {
								
//								s = s.replace("at leas ", "").replace(" words", "");
//								
//								if()
							}
						}
					}
					
					return true;

				} 
				catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}

}
