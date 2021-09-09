package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ComparatorFiles {

	public static void main(String[] args) throws IOException {
	
		System.out.println(Files.mismatch(Path.of("C:\\Teste\\ABC.txt"), Path.of("C:\\Teste\\ABD.txt")));
		System.out.println(Files.mismatch(Path.of("C:\\Teste\\ABD.txt"), Path.of("C:\\Teste\\ABF.txt")));
		System.out.println(Files.mismatch(Path.of("C:\\Teste\\ABF.txt"), Path.of("C:\\Teste\\ABD.txt")));

	}

}
