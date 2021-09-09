package file.operations;

import java.util.List;

public interface FileReaderPrototype<T> {

	public void readFile(List<T> values);
	
}
