package testes.fundamentos;

import java.math.BigDecimal;

public class DecimalNumber {
	
	public static void main (String[] args) {
		System.out.println(0.1 + 0.2 == 0.3);
		System.out.println(0.1 + 0.2);
		
		System.out.println();
		System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")).compareTo(new BigDecimal("0.3")) == 0 ? true : false);
		System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));
		
		System.out.println();
		System.out.println(new BigDecimal(0.1 + 0.2));
		System.out.println(new BigDecimal(0.1 + 0.2).doubleValue());
		System.out.println(new BigDecimal(0.1 + 0.2).floatValue());
	}

}
