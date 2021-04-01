package testes.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClasseTeste {
	
	private static class Classe {
		private String nome;
		private Long idade;
		
		public Classe(String nome, Long idade) {
			this.nome = nome;
			this.idade = idade;
		}
		
		public String getData() {
			return this.nome + " tem " + this.idade + " anos";
		}
		
	}
	
	private static List<Classe> classes = new ArrayList<>(Arrays.asList(new Classe("Teste", (long) 20), new Classe("Teste", (long) 20)));

	public static void main(String[] args) {
		
        for(Object c : classes) {

			Class<?> classe = c.getClass();
			Field[] campos = classe.getDeclaredFields();
			
			String nomeAtributo = "";
	        Object valorAtributo = null;
	        String linha = "";
                
	        for (Field campo : campos) {            
	        	try {               
	            	nomeAtributo = campo.getName();
	                campo.setAccessible(true);
	                valorAtributo = campo.get(c);                           
	            } catch (Exception e) {
	                e.printStackTrace();
	            }           
	        	
	        	linha += valorAtributo + ";";
	            System.out.println(nomeAtributo + ": " + valorAtributo);            
	        }
	        
	        System.out.println(linha);
	        
	        try {
				write("teste.csv", linha);
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	        linha = "";
        }
        
        classes.parallelStream().map(clazz -> clazz.getData());
		
	}
	
	public static void write(String path, String text) throws IOException {
		
		FileWriter fw = new FileWriter(path, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(text);
		bw.newLine();

		bw.close();
	}

}
