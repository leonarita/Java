package aula03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Exercicio5 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int op;
		String num = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		Calendar d = Calendar.getInstance();
	
		do
		{
			System.out.println("\n\n\n");
			
			System.out.print("Considere as opções abaixo:" + 
					"\n\t1) Converter para int" + 
					"\n\t2) Converter para long" + 
					"\n\t3) Converter para float" + 
					"\n\t4) Converter para double" + 
					"\n\t5) Converter para Calendar (data)" +
					"\n\t6) Converter para Calendar (hora)" +
					"\n\t0) Sair" +
					"\n\nInforme a opção desejada: ");
			
			op = sc.nextInt();
			sc.nextLine();
			
			if (op == 0)
			{	System.out.println("\n\nAté mais!");
				break;
			}
			else if (op>0 && op<5)
			{
				System.out.println("\n\nInforme um número: ");
				num = sc.nextLine();
			}
			else if (op==5)
			{
				System.out.println("\n\nInforme uma data (dd/mm/aaaa): ");
				num = sc.nextLine();
			}
			else if (op==6)
			{
				System.out.println("\n\nInforme uma hora (hh:mm:ss): ");
				num = sc.nextLine();
			}
			
			try
			{
				switch (op)
				{
					case 1:
						System.out.println("\n\tInteiro: " + Integer.parseInt(num));
						break;
						
					case 2:
						System.out.println("\tLong: " + Long.parseLong(num));
						break;
						
					case 3:
						System.out.println("\tFloat: " + Float.parseFloat(num));
						break;
						
					case 4:
						System.out.println("\tDouble: " + Double.parseDouble(num));
						break;
						
					case 5:
						d.setTime(sdf.parse(num));
						System.out.println(d.get(Calendar.DAY_OF_MONTH) + "/" + d.get(Calendar.MONTH) + "/" + + d.get(Calendar.YEAR));
						break;
						
					case 6:
						System.out.println(sdf2.format(d.getTime()));
						break;
						
					default:
						System.out.println("\n\t\tOpção inválida!");
						break;
				}
				
			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Conversão mal sucedida: \n" + ex, "ERROR 404", JOptionPane.ERROR_MESSAGE);
			}
			System.out.println("\n\n");
		}
		while (op!=0);
		
		sc.close();
	}

}
