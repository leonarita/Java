package aula15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations1 {
	
	public static void writeFile(String file, String value) throws IOException {
		
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
			bufferedWriter.write(value);
		}
	}
	
	public static void readFiles(String file1, String file2) throws FileNotFoundException, IOException {
		
		String result = "";
		
		try(
				BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
				BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
		) {
			result += bufferedReader1.readLine();
			result += " ";
			result += bufferedReader2.readLine();
		}
		
		System.out.println(result);
	}
	
}
