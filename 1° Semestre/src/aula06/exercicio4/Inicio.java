package aula06.exercicio4;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inicio {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
			
		int op = 1;
		
		String[] textos = new String[] { "Calcular dias", "Calcular horas" };
				
		do {
			try {
				menu(textos);
				op = sc.nextInt();
				sc.nextLine();
				System.out.println("\n\n");
			}
			catch (InputMismatchException e) {
				System.out.println("\n\n\t\tInsira um n�mero v�lido!");
				sc.nextLine();
				continue;
			}
			
			if (op == 0) {
				System.out.println("At� a pr�xima!");
				break;
			}
			else if (op == 1) {
				calcularTempo(new Dia());
			}
			else if (op == 2) {
				calcularTempo(new Hora());
			}
			else {
				System.out.print("Op��o inv�lida");
			}
			
		}
		while (op != 0);
		
		sc.close();
	}
	
	public static void menu (String[] textos)
	{
		System.out.println("\n\nConsidere as op��es abaixo: ");
		
		for (int i=0; i<textos.length; i++)
			System.out.println("\t" + (i+1) + "-" + textos[i]);
		
		System.out.println("\t0-Sair");
		System.out.print("\n\nInsira a op��o desejada: ");
	}
	
	public static void calcularTempo(Tempo t) {
		String text;
		
		if (t.getClass() == Hora.class)
			text = "hora";
		else
			text = "data";
			
		System.out.println("Insira a " + text + " inicial: ");
		
		System.out.print("\tDia: ");
		int dia = sc.nextInt();
		
		System.out.print("\tM�s: ");
		int mes = sc.nextInt();
		
		System.out.print("\tAno: ");
		int ano = sc.nextInt();
		
		System.out.print("\tHora: ");
		int hora = sc.nextInt();
		
		System.out.print("\tMinuto: ");
		int minuto = sc.nextInt();
		
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.set(ano, mes, dia, hora, minuto);
		t.setDataHoraInicial(dataInicio);
		
		System.out.println("\n\n");
		System.out.println("Insira a " + text + " final: ");
		
		System.out.print("\tDia: ");
		dia = sc.nextInt();
		
		System.out.print("\tM�s: ");
		mes = sc.nextInt();
		
		System.out.print("\tAno: ");
		ano = sc.nextInt();
		
		System.out.print("\tHora: ");
		hora = sc.nextInt();
		
		System.out.print("\tMinuto: ");
		minuto = sc.nextInt();
		
		Calendar dataFim = Calendar.getInstance();
		dataFim.set(ano, mes, dia, hora, minuto);
		t.setDataHoraFinal(dataFim);
		
		try {
		
			if(t.validarTempo()) {
				if (t.getClass() == Hora.class)
					System.out.println("\n\n\t\t" + t.calcularTempo() + " horas");
				else
					System.out.println("\n\n\t\t" + t.calcularTempo() + " dias");
			}
			else {
				throw new IllegalArgumentException("\n\t\tTempo de in�cio n�o pode ser maior do que tempo de fim");
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
