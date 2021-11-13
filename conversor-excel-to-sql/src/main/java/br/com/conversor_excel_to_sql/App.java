package br.com.conversor_excel_to_sql;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import br.com.conversor_excel_to_sql.engine.TxtGeneratorFromExcel;
import br.com.conversor_excel_to_sql.entity.TestEntity;

public class App {
	
	public static void main(String[] args) 
			throws EncryptedDocumentException, InvalidFormatException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		TxtGeneratorFromExcel.of(TestEntity.class)
				.forFile(Files.newInputStream(Path.of("./doc.xlsx")))
				.withExtractor()
				.build()
				.generateFile("./doc.txt");
	}

}
