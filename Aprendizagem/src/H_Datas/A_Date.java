package H_Datas;

import java.sql.Date;
import java.time.Instant;

public class A_Date {

	public static void main (String[] args) {
		
		Long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
		
		Date novaData = new Date(currentTimeMillis);
		System.out.println(novaData);
		
		Instant instant = novaData.toInstant();
		System.out.println(instant);
		
		Date dataNoPassado = new Date(currentTimeMillis - 100000000000L);
		Date dataNoFuturo = new Date(currentTimeMillis + 100000000000L);
		Date mesmaDataNoFuturo = new Date(currentTimeMillis + 100000000000L);
		
		//Comparando se a data dataNoPassado é posterior a dataNoFuturo
		boolean isAfter = dataNoPassado.after(dataNoFuturo);
		System.out.println(isAfter);
		
		//Comparando se a data dataNoPassado é posterior a dataNoFuturo
		boolean isBefore = dataNoPassado.before(dataNoFuturo);
		System.out.println(isBefore);
		
		//Comparando se duas datas são iguais
		boolean isEqual = dataNoFuturo.equals(mesmaDataNoFuturo);
		System.out.println(isEqual);
		
		int compareCase1 = dataNoPassado.compareTo(dataNoFuturo);
		int compareCase2 = dataNoFuturo.compareTo(dataNoPassado);
		int compareCase3 = dataNoFuturo.compareTo(mesmaDataNoFuturo);
		
		System.out.println(compareCase1);
		System.out.println(compareCase2);
		System.out.println(compareCase3);
		
	}
}
