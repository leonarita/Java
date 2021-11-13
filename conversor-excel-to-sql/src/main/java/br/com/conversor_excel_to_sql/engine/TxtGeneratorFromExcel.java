package br.com.conversor_excel_to_sql.engine;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import br.com.conversor_excel_to_sql.file.FileOperations;
import br.com.conversor_excel_to_sql.proxy.SqlGenerator;
import br.com.conversor_excel_to_sql.sql.Sql;
import br.com.conversor_excel_to_sql.utils.Table;

public class TxtGeneratorFromExcel<T> {
	
	private Class<T> clazz;
	private ExtractorExcelData<T> extractor;
	private Workbook workbook;
	private List<String> values = new ArrayList<>();
		
	private TxtGeneratorFromExcel(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public static <T> TxtGeneratorFromExcel<T> of(Class<T> clazz) {
		return new TxtGeneratorFromExcel<T>(clazz);
	}
	
	public TxtGeneratorFromExcel<T> forFile(InputStream in) throws EncryptedDocumentException, IOException, InvalidFormatException {
		this.workbook = WorkbookFactory.create(in);
		return this;
	}
	
	public TxtGeneratorFromExcel<T> withExtractor() {
		this.extractor = ExtractorExcelData.of(clazz);
		return this;
	}
	
	public TxtGeneratorFromExcel<T> build() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Sheet sheet = workbook.getSheetAt(0);

		String table = clazz.getAnnotation(Table.class).name();
		String fields = SqlGenerator.fields(clazz);
		
		for (Row row: sheet) {
			String value = Sql.formatInsert(table, fields, SqlGenerator.values(clazz, extractor.extract(row)));
			values.add(value);
			System.out.println(value);
		}
		
		return this;
	}
	
	public TxtGeneratorFromExcel<T> generateFile(String path) throws IOException {
		if(clazz.getAnnotation(Table.class).skipFirstLine())
			values.remove(0);

		FileOperations.write(path, values);
		return this;
	}

}
