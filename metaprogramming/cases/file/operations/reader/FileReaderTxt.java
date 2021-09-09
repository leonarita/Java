package file.operations.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import file.operations.FileReaderPrototype;
import file.utils.Position;

public class FileReaderTxt<T> implements FileReaderPrototype<T> {

	private Class<T> clazz;
	private InputStream in;
	
	private FileReaderTxt(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public static <T> FileReaderTxt<T> of(Class<T> clazz) {
		return new FileReaderTxt<T>(clazz);
	}
	
	public FileReaderTxt<T> forFile(InputStream in) {
		this.in = in;
		return this;
	}

	@Override
	public List<Object[]> read() {
	
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			
			List<Object[]> data = new ArrayList<Object[]>();
			
			List<Method> methods = Arrays.asList(clazz.getMethods());
			methods.sort((e1, e2) -> e1.getAnnotation(Position.class).start() - e2.getAnnotation(Position.class).start());
			
			reader.lines().forEach(line -> {
				
				Object[] object = new Object[methods.size()];
				int i = 0;
				
				for(Method method : methods) {
					Position position = method.getAnnotation(Position.class);
					object[i] = line.substring(position.start()-1, position.end()-1);
					i++;
				}
				
				data.add(object);
			});
			
			return data;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
