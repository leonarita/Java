package aula03;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Exercicio3 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar data_hora = Calendar.getInstance();
		int op=1, add;

		System.out.print("Informe o dia: ");
		int dia = sc.nextInt();
		System.out.print("Informe o mês: ");
		int mes = sc.nextInt();
		System.out.print("Informe o ano: ");
		int ano = sc.nextInt();
		
		System.out.print("Informe a hora: ");
		int hora = sc.nextInt();
		System.out.print("Informe o minuto: ");
		int min = sc.nextInt();
		System.out.print("Informe o segundo: ");
		int sec = sc.nextInt();
		
		do
		{	System.out.println("\n\n\n");
			System.out.println("\t\t\tDATA: " + sdf.format(data_hora.getTime()));
			
			System.out.print("\n\nConsidere as opções abaixo:" + 
					"\n\t1) Adicionar dias" + 
					"\n\t2) Adicionar meses" + 
					"\n\t3) Adicionar anos" + 
					"\n\t4) Adicionar horas" + 
					"\n\t5) Adicionar minutos" + 
					"\n\t6) Subtrair dias" + 
					"\n\t7) Subtrair meses" + 
					"\n\t8) Subtrair anos" + 
					"\n\t9) Subtrair horas" + 
					"\n\t10) Subtrair minutos " + 
					"\n\t11)Obter dia da semana" + 
					"\n\t0) Sair" +
					"\n\nInforme a opção desejada: ");
			
			op = sc.nextInt();
			
			if (op==0)
			{
				System.out.println("\n\nAté mais!");
				break;
			}
			
			switch (op)
			{
				case 1:
					System.out.print("Adicionar quantos dias? ");
					add = sc.nextInt();
					dia += add;
					break;
					
				case 2:
					System.out.print("Adicionar quantos meses? ");
					add = sc.nextInt();
					mes += add;
					break;
					
				case 3:
					System.out.print("Adicionar quantos anos? ");
					add = sc.nextInt();
					ano += add;
					break;
					
				case 4:
					System.out.print("Adicionar quantas horas? ");
					add = sc.nextInt();
					hora += add;
					break;
					
				case 5:
					System.out.print("Adicionar quantos minutos? ");
					add = sc.nextInt();
					min += add;
					break;
					
				case 6:
					System.out.print("Subtrair quantos dias? ");
					add = sc.nextInt();
					dia -= add;
					break;
					
				case 7:
					System.out.print("Subtrair quantos meses? ");
					add = sc.nextInt();
					mes -= add;
					break;
					
				case 8:
					System.out.print("Subtrair quantos anos? ");
					add = sc.nextInt();
					ano -= add;
					break;
					
				case 9:
					System.out.print("Subtrair quantas horas? ");
					add = sc.nextInt();
					hora -= add;
					break;
					
				case 10:
					System.out.print("Subtrair quantos minutos? ");
					add = sc.nextInt();
					min -= add;
					break;
					
				case 11:
					System.out.print("\n\n" + new DateFormatSymbols().getWeekdays()[data_hora.get(Calendar.DAY_OF_WEEK)]);
					break;
					
				default:
					System.out.println("\n\t\tOpção inválida!");
					break;
			}
			
			data_hora.set(ano, mes, dia, hora, min, sec);
			
		}
		while (op != 0);
		
		sc.close();
	}

}