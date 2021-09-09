package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import file.operations.reader.FileReaderCsv;
import file.operations.reader.FileReaderTxt;
import file.operations.writer.FileWriterCsv;
import file.operations.writer.FileWriterTxt;

public class App {

	public static void main(String... args) throws FileNotFoundException {
		
		List<CsvFormat> dataToPersist = new ArrayList<CsvFormat>();
		dataToPersist.add(proxyFor(new Object[] {"Leo Narita", 10.0}));
		dataToPersist.add(proxyFor(new Object[] {"Natanvirus", 2.0}));
		
		FileWriterCsv.of(CsvFormat.class).forData(dataToPersist).build();
		FileWriterTxt.of(CsvFormat.class).forData(dataToPersist).build();
		
		FileReaderCsv.of(CsvFormat.class).forFile(new FileInputStream("C:\\Teste\\file.csv")).read().forEach(element -> convertAndPrint(element));
		FileReaderTxt.of(CsvFormat.class).forFile(new FileInputStream("C:\\Teste\\file.txt")).read().forEach(element -> convertAndPrint(element));
	}
	
	public static void convertAndPrint(Object[] element) {
		CsvFormat data = proxyFor(element);
		System.out.print("\n--- " + data.getName() + " - " + data.getNota());
	}
	
	private static CsvFormat proxyFor(Object[] data) {
		
		return (CsvFormat) Proxy.newProxyInstance(
				Thread.currentThread().getContextClassLoader(), 
				new Class[]{CsvFormat.class}, 
				new CsvFormatProxy(data)
		);
	}
	
}
