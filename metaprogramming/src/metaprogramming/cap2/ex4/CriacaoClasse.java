package metaprogramming.cap2.ex4;

import java.io.IOException;
import java.util.Objects;

public class CriacaoClasse {

	public CriacaoClasse() throws IOException{
		throw new IOException();
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		try{
			CriacaoClasse obj = CriacaoClasse.class.newInstance();
			
			if(Objects.nonNull(obj)) {}
		} 
		catch (InstantiationException e) {
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
