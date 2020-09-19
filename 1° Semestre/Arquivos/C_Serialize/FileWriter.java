package C_Serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileWriter {

	// gera saída dos dados no arquivo
	private static ObjectOutputStream output; 
	
	public static void openFile() {
	
		try {
	
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("clients.ser")));
		}
		catch (SecurityException securityException) {
			System.err.println("Write permission denied. Terminating.");
			System.exit(1);
		}
		catch (IOException fileNotFoundException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1); 
		}
	}
	
	public static void addRecords() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s%n%s%n? ", "Enter account number, first name, last name and balance.", "Enter end-of-file indicator to end input.");
		
		// faz um loop até o indicador de fim de arquivo
		while (input.hasNext()) { 
			try {

				Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());

				// serializa o objeto de registro em um arquivoÿ
				output.writeObject(record);
			}
			catch (NoSuchElementException elementException) {
				System.err.println("Invalid input. Please try again.");
				
				// descarta entrada para o usuário tentar de novo
				input.nextLine(); 
			}
			catch (IOException ioException) {
				System.err.println("Error writing to file. Terminating.");
				break;
			}
			
			System.out.print("? ");
		}
		input.close();
	}

	public static void closeFile() {
		try {
		
			if (output != null)
				output.close();
			}
		catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
		}
	}
}
