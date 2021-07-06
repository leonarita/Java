package casadocodigo.serialize.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CriaEArmazenaPessoa {
	
	public static void escreve(Pessoa p) {
		
		try {
			FileOutputStream fout = new FileOutputStream("Grava.dados");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(p);
			oos.close();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Criando Pessoa.");

		Pessoa p1 = new Pessoa();
		p1.setNome("Leandro");
		p1.setTelefone("3xxx-xxxx");
		
		System.out.println("Escrevendo Pessoa");
		escreve(p1);
		System.out.println("Terminado");
		
		// CMD: type Grava.dados
		// Shell: cat Grava.dados
	}

}
