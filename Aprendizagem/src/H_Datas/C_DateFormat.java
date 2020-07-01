package H_Datas;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class C_DateFormat {

	public static void main(String[] args) {
		
		Long currentTimeMillis = System.currentTimeMillis();		
		Date novaData = new Date(currentTimeMillis);
		
		// SimpleDateFormat
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatter.format(novaData);
		System.out.println(dataFormatada);
		
		// DateFormat
		String dateToString = DateFormat.getInstance().format(novaData);
		System.out.println(dateToString);
		
		dateToString = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(novaData);
		System.out.println(dateToString);
		
		dateToString = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(novaData);
		System.out.println(dateToString);
		
		// LocalDate
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate ontem = hoje.minusDays(1);
		System.out.println(ontem);
		
		// LocalTime
		LocalTime agora = LocalTime.now();
		System.out.println(agora);
		
		LocalTime maisUmaHora = agora.plusHours(1);
		System.out.println(maisUmaHora);
		
		// LocalDateTime
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		LocalDateTime futuro = now.plusHours(1).plusDays(2).plusSeconds(12);
		System.out.println(futuro);
	}
}
