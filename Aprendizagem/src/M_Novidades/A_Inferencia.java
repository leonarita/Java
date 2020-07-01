package M_Novidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class A_Inferencia {
	
	public static void main (String args) {
		printarSoma(5, 5, 5);
	}

	//var pode ser usado em enhaced for e for interativo
	//var não pode ser utilizado em nivel de classe nem como parâmetro
	//var não pode ser utilizada em variáveis locais sem inicializar
	
	public static void connectAndPrintUrlJavaOracle() throws IOException {	
		
		//Pode usar var para as 3 atribuições abaixo
		try {
			URL url = new URL("https://docs.oracle.com/javase/10/language/");
			URLConnection urlConnection = url.openConnection();
			
			try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
				System.out.println(bufferedReader.lines().collect(Collectors.joining()).replace(">", ">\n"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printarSomar(int a, int b) {
		var soma = a + b;
		System.out.println(soma);
	}
	
	public static void printarNomeCompleto(String nome, String sobrenome) {
		var nomeCompleto = String.format("%s %s", nome, sobrenome);
		System.out.println(nomeCompleto);
	}
	
	public static void printarSoma(int... numeros) {
		int soma;
		if (numeros.length > 0) {
			soma = 0;
			
			for (var n : numeros)
				soma += n;
			
			System.out.println("A soma é " + soma);
		}
	}
}