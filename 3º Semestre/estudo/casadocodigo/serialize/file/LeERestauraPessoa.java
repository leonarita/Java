package casadocodigo.serialize.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeERestauraPessoa {
	
	public static Pessoa le() {
		try {
			FileInputStream fin = new FileInputStream("Grava.dados");
			ObjectInputStream ois = new ObjectInputStream(fin);
					
			Pessoa p = (Pessoa) ois.readObject();
	
			ois.close();
			fin.close();
			return p;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Lendo Pessoa.");
		
		Pessoa objetoLido = le();
		
		System.out.println("Executado.");
		System.out.println("Nome: " + objetoLido.getNome());
		System.out.println("Telefone: " + objetoLido.getTelefone());
	}

}
