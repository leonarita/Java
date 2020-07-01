package N_Arquivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class B_Arrays_Arquivos {
	
	public static void main(String[] args) throws IOException {
		
		int[] values = new int[12];
		int i = 0;
		
		File file = new File("values.txt");
		
		if (file.exists()) {
			
			Scanner inputFile = new Scanner(file);
			
			while (inputFile.hasNext() && i < values.length) {
				values[i] = inputFile.nextInt();
				i++;
			}
			
			inputFile.close();
			
			for (int v : values) {
				System.out.println(v);
			}
		}
	}
}