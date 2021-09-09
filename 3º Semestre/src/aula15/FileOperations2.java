package aula15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOperations2 {

	public static void writeFile(String file, String value) throws IOException {
		
		// OutputStream out = new FileOutputStream(file)
		try(OutputStream out = Files.newOutputStream(Path.of(file))) {
			
			out.write(value.getBytes());
		}
	}

	public static void readFiles(String file1, String file2) throws FileNotFoundException, IOException {
		
		String result = "";
		
		try(
				// dois modos de instanciar
				InputStream inputStream1 = Files.newInputStream(Path.of(file1));
				InputStream inputStream2 = new FileInputStream(file2);
		) {
			result += new String(inputStream1.readAllBytes(), StandardCharsets.UTF_8);
			result += " ";
			result += new String(inputStream2.readAllBytes(), StandardCharsets.UTF_8);
		}
		
		System.out.println(result);
	}
}
