package H_Datas;

import java.util.Calendar;

public class B_Calendar {

	public static void main (String[] args) {
		
		Calendar agora = Calendar.getInstance();
		System.out.println("A data corrente é " + agora);
		
		System.out.printf("%tc\n", agora);
		System.out.printf("%tF\n", agora);
		System.out.printf("%tD\n", agora);
		System.out.printf("%tF\n", agora);
		System.out.printf("%tT\n", agora);

		agora.add(Calendar.DATE, -15);
		System.out.println("15 dias atrás: " + agora);
		
		agora.add(Calendar.MONTH, 4);
		System.out.println("4 meses depois: " + agora);
		
		agora.add(Calendar.YEAR, 2);
		System.out.println("2 anos depois: " + agora);
	}
}
