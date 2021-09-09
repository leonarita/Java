package aula16;

public class IntegerComparator {
	
	public static boolean isNegative(Integer value) {
		return value < 0;
	}
	
	public static boolean isBigValue(Integer value) {
		return value > 1000;
	}
	
	public static boolean isSmallValue(Integer value) {
		return value < 1000 || value == 1000;
	}

}
