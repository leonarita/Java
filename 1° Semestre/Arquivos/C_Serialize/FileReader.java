package C_Serialize;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

	private static ObjectInputStream input;

	public static void openFile() {
	
		try {
			input = new ObjectInputStream(Files.newInputStream(Paths.get("clients.ser")));
		}
		catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	public static void readRecords() { 
	
		System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance");
	
		try {
	
			// faz um loop at� ocorrer uma EOFException
			while (true) {
	
				Account record = (Account) input.readObject();
				
				// exibe o conte�do de registro
				System.out.printf("%-10d%-12s%-12s%10.2f%n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
			}
		}
		catch (EOFException endOfFileException) {
			System.out.printf("%No more records%n");
		}
		catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Terminating.");
		}
		catch (IOException ioException) {
			System.err.println("Error reading from file. Terminating.");
		}
	}

	public static void closeFile() {
		try {
			if (input != null)
				input.close();
		}
		catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
			System.exit(1);
		}
	}
}
