package file;

import file.utils.Position;

public interface PositionalData {
	
	@Position(start = 1, end = 20, length = 20)
	public String getName();
	
	@Position(start = 21, end = 25, length = 5)
	public Double getNota();

}
