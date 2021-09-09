package file.operations.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import file.operations.FileReaderPrototype;

public class FileReaderCsv<T> implements FileReaderPrototype<T> {

	private Class<T> clazz;
	private InputStream in;
	
	private FileReaderCsv(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public static <T> FileReaderCsv<T> of(Class<T> clazz) {
		return new FileReaderCsv<T>(clazz);
	}
	
	public FileReaderCsv<T> forFile(InputStream in) {
		this.in = in;
		return this;
	}

	@Override
	public List<Object[]> read() {
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			
			List<Object[]> data = new ArrayList<Object[]>();
			List<Method> methods = Arrays.asList(clazz.getMethods());
			boolean isHeader = true;
			
			for(String line : reader.lines().collect(Collectors.toList())) {
				
				if(isHeader) {
					isHeader = false;
					continue;
				}
				
				Object[] object = new Object[methods.size()];
				int i = 0;
				
				for(String s : line.split(";")) {
					object[i] = s;
					i++;
				}
				
				data.add(object);
			}
			
			return data;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
