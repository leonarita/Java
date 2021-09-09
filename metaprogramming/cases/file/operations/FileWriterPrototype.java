package file.operations;

import java.util.List;

public interface FileWriterPrototype<T> {

	public void createFile(List<T> values);
	
}
