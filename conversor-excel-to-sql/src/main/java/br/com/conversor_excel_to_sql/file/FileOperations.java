package br.com.conversor_excel_to_sql.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileOperations {
	
	public static void write(String path, List<String> values) throws IOException {
		try(BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(path))) {
			for(String text : values)
				bufferWriter.write(text + "\n");
			bufferWriter.close();
		}
	}

}
