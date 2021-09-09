package file;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import file.operations.writer.FileWriterCsv;
import file.operations.writer.FileWriterTxt;

public class App {

	public static void main(String... args) {
		
		List<CsvFormat> dataToPersist = new ArrayList<CsvFormat>();
		dataToPersist.add(criarProxy(new Object[] {"Leo Narita", 10.0}));
		dataToPersist.add(criarProxy(new Object[] {"Natanvirus", 2.0}));
		
		FileWriterCsv<CsvFormat> fileWriterCsv = new FileWriterCsv<CsvFormat>(CsvFormat.class);
		fileWriterCsv.createFile(dataToPersist);
		
		FileWriterTxt<CsvFormat> fileWriterTxt = new FileWriterTxt<CsvFormat>(CsvFormat.class);
		fileWriterTxt.createFile(dataToPersist);
	}
	
	private static CsvFormat criarProxy(Object[] data) {
		
		return (CsvFormat) Proxy.newProxyInstance(
				Thread.currentThread().getContextClassLoader(), 
				new Class[]{CsvFormat.class}, 
				new CsvFormatProxy(data)
		);
	}
	
}
