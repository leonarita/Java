package file.operations.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import file.operations.FileWriterPrototype;
import file.utils.Position;

public class FileWriterCsv<T> implements FileWriterPrototype<T> {
	
	private Class<T> clazz;
	
	public FileWriterCsv(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public void createFile(List<T> values) {
		
		try (FileWriter writer = new FileWriter(new File("C:\\Teste\\file.csv"))) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Nome ; Nota \n");
			
			for(T value : values) {
				
				List<Method> methods = Arrays.asList(clazz.getMethods());
				
				methods.sort((e1, e2) -> { 
					return e1.getAnnotation(Position.class).start() - e2.getAnnotation(Position.class).start();
				});
				
				methods.forEach(element -> {
					try {
						stringBuilder.append(element.invoke(value).toString() + ";");
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				});
				
				stringBuilder.append("\n");
			}
			
			writer.write(stringBuilder.toString());
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
