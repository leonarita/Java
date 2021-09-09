package aula16;

public class ExceptionHandler {
	
	private static final int ZERO = 0;
	
	public static void validateVariable(Integer value) throws NumberFormatException {
		
		if(IntegerComparator.isNegative(value)) {
			throw new NumberFormatException("Erro-Argumento negativo");
		}
		if(IntegerComparator.isSmallValue(value)) {
			throw new NumberFormatException("Erro-Argumento deve ser maior que x");
		}
		if(IntegerComparator.isBigValue(value)) {
			throw new NumberFormatException("Erro-Argumento muito grande");
		}
	}

	public static int divisonByZero(int value) throws ArithmeticException {
		
		try {
			return value/ZERO;
		}
		catch(ArithmeticException e) {
			throw new ArithmeticException();
		}
	}
	
}
