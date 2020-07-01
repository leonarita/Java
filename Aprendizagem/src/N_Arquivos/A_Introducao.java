package N_Arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class A_Introducao {

	public static void main(String[] args) throws FileNotFoundException {
		
		write();
		read();
	}
	
	public static void write() throws FileNotFoundException {
		
		PrintWriter outputFile = new PrintWriter("file.txt");
		
		outputFile.println("This is line 1");
		outputFile.println("This is line 2");
		outputFile.println("This is line 3");
		outputFile.println("This is line 4");
		
		outputFile.close();
	}
	
	public static void read() throws FileNotFoundException {
		
		File f = new File("file.txt");
		
		if (f.exists()) {
			Scanner input = new Scanner(f);
			
			while (input.hasNext()) {
				System.out.println(input.nextLine());
			}
			
			input.close();
		}
		else {
			JOptionPane.showMessageDialog(null, "The file does not exist!");
		}
	}
}
