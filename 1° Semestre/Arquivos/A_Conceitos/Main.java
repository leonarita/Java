package A_Conceitos;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//Information.getInfo();
		
		// Exemplo Input: 100 Bob Blue 24,98
		//				  200 Steve Green -345,67
		//				  300 Pam White 0,00
		//				  400 Sam Red -42,16
		//				  500 Sue Yellow 224,62
		
		// Sa�da: ctrl Z
		FileWriter.openFile();
		FileWriter.addRecords();
		FileWriter.closeFile();
		
		FileReader.openFile();
		FileReader.readRecords();
		FileReader.closeFile();
	}

}
