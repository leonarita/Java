package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import file.operations.FileReaderPrototype;
import file.operations.reader.FileReaderCsv;
import file.operations.reader.FileReaderTxt;
import file.operations.writer.FileWriterCsv;
import file.operations.writer.FileWriterTxt;

public class App {

	public static void main(String... args) throws FileNotFoundException {
		
		List<PositionalData> dataToPersist = new ArrayList<PositionalData>();
		dataToPersist.add(proxyFor(PositionalData.class, new PositionalDataProxy(new Object[] {"Leo Narita", 10.0})));
		dataToPersist.add(proxyFor(PositionalData.class, new PositionalDataProxy(new Object[] {"Natanvirus", 2.0})));
		
		FileWriterCsv.of(PositionalData.class).forData(dataToPersist).build();
		FileWriterTxt.of(PositionalData.class).forData(dataToPersist).build();
		
		readContentFile(FileReaderCsv.of(PositionalData.class).forFile(new FileInputStream("C:\\Teste\\file.csv")));
		readContentFile(FileReaderTxt.of(PositionalData.class).forFile(new FileInputStream("C:\\Teste\\file.txt")));
	}
	
	public static void convertAndPrint(Object[] element) {
		PositionalData data = proxyFor(PositionalData.class, new PositionalDataProxy(element));
		System.out.print("\n--- " + data.getName() + " - " + data.getNota());
	}
	
	private static <T> void readContentFile(FileReaderPrototype<T> fileReader) {
		fileReader.read().forEach(element -> convertAndPrint(element));
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends Object> T proxyFor(Class<T> clazz, InvocationHandler invocationHandler) {
		return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{clazz}, invocationHandler);
	}
	
}
