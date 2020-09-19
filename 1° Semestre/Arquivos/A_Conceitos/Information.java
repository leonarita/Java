package A_Conceitos;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Information {

	public static void getInfo() throws IOException {
		
		Scanner input = new Scanner(System.in);
	
		System.out.println("Enter file or directory name:");
	
		// cria o objeto Path com base na entrada de usu�rio
		Path path = Paths.get(input.nextLine());
	
		// se o caminho existe, gera uma sa�da das informa��es sobre ele
		if (Files.exists(path)) {
	
			// exibe informa��es sobre o arquivo (ou diret�rio)
			System.out.printf("%n%s exists%n", path.getFileName());
			System.out.printf("%s a directory%n", Files.isDirectory(path) ? "Is" : "Is not");
			System.out.printf("%s an absolute path%n", path.isAbsolute() ? "Is" : "Is not");
			System.out.printf("Last modified: %s%n", Files.getLastModifiedTime(path));
			System.out.printf("Size: %s%n", Files.size(path));
			System.out.printf("Path: %s%n", path);
			System.out.printf("Absolute path: %s%n", path.toAbsolutePath());
	
			// listagem de diret�rio de sa�da
			if (Files.isDirectory(path))  {
				
				System.out.printf("%nDirectory contents:%n");

				// objeto para itera��o pelo conte�do de um diret�rio
				DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);

				for (Path p : directoryStream)
					System.out.println(p);
			}
		}
		
		// se n�o for arquivo ou diret�rio, gera sa�da da mensagem de erro
		else 
		{
			System.out.printf("%s does not exist%n", path);
		}
		
		input.close();
	}
}
