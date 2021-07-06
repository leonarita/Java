package casadocodigo.serialize.xml;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;

import casadocodigo.serialize.file.Pessoa;

public class EscrevePessoaXML {
	
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Leandro");
		pessoa.setTelefone("3743-xxxx");
		
		System.out.println("Gravando como XML");
		
		try {
			FileOutputStream fout = new FileOutputStream("Pessoa.xml");
			XMLEncoder xe = new XMLEncoder(fout);
		
			xe.writeObject(pessoa);
			xe.close();
		
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ok");
	}

}
