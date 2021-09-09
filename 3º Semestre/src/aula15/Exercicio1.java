package aula15;

import java.io.IOException;

public class Exercicio1 {
	
	private static final String FILE1 = "file001.txt";
	private static final String FILE2 = "file002.txt";
	
	public static void main(String... args) throws IOException {
		
		// Há vários métodos de realizar esse exercício.
		// Como o estudo de File me interessa bastante, realizei duas formas
		
		// method 1
		FileOperations1.writeFile(FILE1, "Leonardo");
		FileOperations1.writeFile(FILE2, "Narita");
		FileOperations1.readFiles(FILE1, FILE2);
		
		// method 2
		FileOperations2.writeFile(FILE1, "Leonardo");
		FileOperations2.writeFile(FILE2, "Narita");
		FileOperations2.readFiles(FILE1, FILE2);
	}

}
