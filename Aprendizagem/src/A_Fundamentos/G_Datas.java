package A_Fundamentos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class G_Datas {

	public static void main (String[] args) {
		
		LocalDate hoje = LocalDate.now();
		
		LocalDate anoNovo = LocalDate.of(hoje.getYear(), Month.DECEMBER, 31);
		
		//Formato ISO (internacional)
		System.out.println(hoje);
		System.out.println(anoNovo);
		
		System.out.println("O ano novo será em " + anoNovo.getDayOfMonth() + " de " + anoNovo.getMonth() + " de " + anoNovo.getYear());
		
		Period periodo = Period.between(hoje, anoNovo);
		System.out.print("\n" + periodo);
		
		System.out.println(" => Faltam " + periodo.getMonths() + " meses e " + periodo.getDays() + " dias para o ano novo!!");
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoje.format(formatador));
		
		LocalDateTime agora = LocalDateTime.now();
		
		//Formato ISO (internacional)
		System.out.print("\n" + agora);
		
		DateTimeFormatter formatador_horas = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println(" => " + agora.format(formatador_horas));
		
		LocalTime intervalo = LocalTime.of(9, 30);
		System.out.println(intervalo);
	}
}
