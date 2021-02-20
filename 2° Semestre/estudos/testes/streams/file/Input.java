package testes.streams.file;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;

// VISA TRAFEFAR DADOS NO MODO REQUEST
public class Input {
	
	public static void main(String[] args) throws IOException {
		
		workingWithByteArrayInputStream(TextGenerator.getHTML());
		workingWithFileInputStream();
	}
	
	public static void workingWithByteArrayInputStream(String html) throws IOException {
		
		try (InputStream initialStream = new ByteArrayInputStream(html.getBytes())) {
			
			File targetFile = new File("C:\\Teste\\teste1.html");
	
			java.nio.file.Files.copy(initialStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}

	}
	
	public static void workingWithFileInputStream() throws FileNotFoundException, IOException {
		
		try (InputStream initialStream = new FileInputStream(new File("C:\\Teste\\teste1.html"))) {
			
			File targetFile = new File("C:\\Teste\\teste2.html");
	
			java.nio.file.Files.copy(initialStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

}
