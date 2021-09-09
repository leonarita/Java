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
	private List<T> values;

	private FileWriterCsv(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public static <T> FileWriterCsv<T> of(Class<T> clazz) {
		return new FileWriterCsv<T>(clazz);
	}
	
	public FileWriterCsv<T> forData(List<T> values) {
		this.values = values;
		return this;
	}
	
	public void build() {
		
		try (FileWriter writer = new FileWriter(new File("C:\\Teste\\file.csv"))) {

			List<Method> methods = Arrays.asList(clazz.getMethods());
			methods.sort((e1, e2) -> e1.getAnnotation(Position.class).start() - e2.getAnnotation(Position.class).start());
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Nome ; Nota \n");
			
			for(T value : this.values) {
				
				methods.forEach(element -> {
					try {
						stringBuilder.append(element.invoke(value).toString() + ";");
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				});
				stringBuilder.deleteCharAt(stringBuilder.length()-1);				
				stringBuilder.append("\n");
			}
			
			writer.write(stringBuilder.toString());
			System.out.println("CSV successfully generated");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
