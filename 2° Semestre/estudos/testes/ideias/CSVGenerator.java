package testes.ideias;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVGenerator {
	
	private static class DataCSV {
		public String name;
		public String cpf;
		
		public DataCSV(String name, String cpf) {
			this.name = name;
			this.cpf = cpf;
		}
	}
	
	public static void main (String[] args) throws IOException {
		
		List<DataCSV> data = new ArrayList<CSVGenerator.DataCSV>(
				Arrays.asList(new DataCSV("name 1", "1111"), new DataCSV("name 2", "2222"), new DataCSV("name 3", ""))
		);
		
		PrintStream ps = new PrintStream("arq.csv");
		ps.println("Nome; CPF");
		
		for (DataCSV d : data) {
			ps.println(String.format("%s; %s;", d.name, d.cpf));
		}
			
		ps.close();
		
		File f = new File("arq.csv");
		InputStream i = new FileInputStream(f);
		
		convert(i);
		
		i.close();
		f.delete();
	}
	
	public static void convert(InputStream i) throws IOException {
		
		byte[] buffer = new byte[i.available()];
		i.read(buffer);

		File targetFile = new File("arq-official.csv");

		OutputStream outStream = new FileOutputStream(targetFile);
		outStream.write(buffer);
		outStream.close();
	}
	
	
	

}
