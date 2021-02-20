package aula_arquivos;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Arquivos {
	
	public static void main(String[] args) throws IOException {
		
		InputStream arq = null;
		
		try {
			arq = new DataInputStream(new FileInputStream("C://Teste//argumentos.cpp"));
			System.out.println("Arquivo aberto!");
		}
		catch(FileNotFoundException e) {
			System.out.println("A operação retornou o seguinte erro: " + e.getMessage());
		}
		finally {
			if (arq != null) {
				arq.close();
				System.out.println("Arquivo fechado!");
			}
			else {
				System.out.println("Erro na abertura do arquivo!");
			}
		}
		
	}

}
