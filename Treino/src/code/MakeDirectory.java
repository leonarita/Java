package code;

import java.io.File;

public class MakeDirectory {

	public static void main (String[] args) {
		
		// Creates a file object with specified path
		File file = new File("C:\\directory");
		
		// Tries to create a new directory
		boolean value = file.mkdir();
		
		if (value)
			System.out.println("The new directory is created.");
		else
			System.out.println("The directory already exists.");
	}
}
