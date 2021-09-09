package file.operations.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import file.operations.FileWriterPrototype;
import file.utils.FormatterString;
import file.utils.Position;

public class FileWriterTxt<T> implements FileWriterPrototype<T> {
	
	private Class<T> clazz;
	private List<T> values;
	
	private FileWriterTxt(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public static <T> FileWriterTxt<T> of(Class<T> clazz) {
		return new FileWriterTxt<T>(clazz);
	}
	
	public FileWriterTxt<T> forData(List<T> values) {
		this.values = values;
		return this;
	}
	
	public void build() {
		
		try (FileWriter writer = new FileWriter(new File("C:\\Teste\\file.txt"))) {
			StringBuilder stringBuilder = new StringBuilder();
			
			List<Method> methods = Arrays.asList(clazz.getMethods());
			methods.sort((e1, e2) -> e1.getAnnotation(Position.class).start() - e2.getAnnotation(Position.class).start());
			
			for(T value : this.values) {
				
				methods.forEach(element -> {
					try {
						stringBuilder.append(FormatterString.format(value, element.getName(), clazz));
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					}
				});
				
				stringBuilder.append("\n");
			}
			
			writer.write(stringBuilder.toString());
			System.out.println("TXT successfully generated");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
