package sistemaControleProcessos;

//Adicionar enum

import java.util.ArrayList;

import java.sql.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Inicio {
	
	static Scanner sc = new Scanner (System.in);
	
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	static ArrayList<Processo> processos = new ArrayList<Processo>();	
	
	static int id=3, ra=3, cod=5, num=10;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		int op=1;
		
		clientes.add(new Cliente(1, "Stefany", new Date(2000, 10, 17), 1));
		clientes.add(new Cliente(2, "Leonardo", new Date(2000, 07, 13), 2));
		
		funcionarios.add(new Funcionario(3, "Samuel", new Date(2000, 01-1, 10), 1, new Date(2018, 01-1, 01)));
		funcionarios.add(new Funcionario(4, "Marcos", new Date(1992, 10-1, 10), 2, new Date(2016, 12-1, 01)));
		
		processos.add(new Processo(1, new Date(2019, 05-1, 02), null, (short) 1, clientes.get(0)));
		processos.add(new Processo(2, new Date(2016, 12-1, 10), new Date (2016, 12-1, 20), (short) 3, clientes.get(0)));
		processos.add(new Processo(3, new Date(2013, 03-1, 16), null, (short) 2, clientes.get(0)));
		processos.add(new Processo(4, new Date(2017, 11-1, 05), null, (short) 2, clientes.get(0)));

		processos.add(new Processo(5, new Date(2011, 11-1, 24), null, (short) 1, clientes.get(1)));
		processos.add(new Processo(6, new Date(2015, 05-1, 12), new Date(2017, 02-1, 10), (short) 3, clientes.get(1)));
		processos.add(new Processo(7, new Date(2012, 02-1, 15), null, (short) 2, clientes.get(1)));
		
		processos.add(new Processo(8, new Date(2018, 03-1, 07), null, (short) 2, funcionarios.get(0)));
		processos.add(new Processo(9, new Date(2011, 02-1, 05), null, (short) 1, funcionarios.get(0)));		
			
		do
		{
			try
			{
				System.out.print("\n\n\t\tMENU PRINCIPAL\n\n");
				System.out.print("Considere as seguintes opções: \n\t1-Cadastrar \n\t2-Atualizar relatório \n\t3-Consultar \n\t0-Sair");
				System.out.print("\n\nInforme a opção desejada: ");
				op = sc.nextInt();
				System.out.println("\n\n");
				
				if (op==0)
					break;
				
				else if (op==1)
					cadastrar();
				
				else if (op==2)
					atualizar();
				
				else if (op==3)
					consultar();
				
				else
					JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "Erro na aplicação: " + e.getMessage());
				sc.nextLine();
			}
		}
		while (op!=0);
	}
	
	@SuppressWarnings("deprecation")
	public static void atualizar () {
		
		System.out.print("Informe o numero do processo para ser atualizado: ");
		int n = sc.nextInt();
		
		if (processos.get(n-1).getStatusInt() == 3) {
			JOptionPane.showMessageDialog(null, "Processo finalizado!");
			return;
		}
		
		processos.get(n-1).setStatus((short)(processos.get(n-1).getStatusInt()+1));
		
		if (processos.get(n-1).getStatusInt() == (short)3) {
			processos.get(n-1).setDataEncerramento(new Date(System.currentTimeMillis()));
			processos.get(n-1).getDataEncerramento2().setYear(processos.get(n-1).getDataEncerramento2().getYear()-1900);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void cadastrar() {
		
		System.out.print("\n\n\n\n\t\tMENU DE CADASTRO\n\n");
		System.out.print("Considere as seguintes opções: \n\t1-Cadastrar cliente \n\t2-Cadastrar funcionário \n\t3-Cadastrar relatório \n\t0-Voltar");
		System.out.print("\n\nInforme a opção desejada: ");
		int op = sc.nextInt();
		
		if (op==0)
			return;
		
		else if (op==1 || op==2) {
			
			sc.nextLine();
			System.out.print("\n\nInforme o nome: ");
			String n = sc.nextLine();
			
			System.out.print("\n\nInforme a data de nascimento: ");
			
			System.out.print("\n\tDia: ");
			int d = sc.nextInt();
			
			System.out.print("\tMês: ");
			int m = sc.nextInt();
			m--;
			
			System.out.print("\tAno: ");
			int a = sc.nextInt();
			
			sc.nextLine();
			
			cod++;
			
			if (op==1) {
				clientes.add(new Cliente(cod, n, new Date(a, m, d), id));
				id++;
			}
			
			else {
				System.out.print("\n\nInforme a data de admissao: ");
				
				System.out.print("\n\tDia: ");
				int d1 = sc.nextInt();
				
				System.out.print("\tMês: ");
				int m1 = sc.nextInt();
				m1--;
				
				System.out.print("\tAno: ");
				int a1 = sc.nextInt();
				
				sc.nextLine();
				
				funcionarios.add(new Funcionario(cod, n, new Date(a, m, d), ra, new Date(a1, m1, d1)));
				ra++;
			}
		}
		
		else if (op==3) {
			sc.nextLine();
			
			System.out.print("\n\nInforme a data de abertura: ");
			
			System.out.print("\n\tDia: ");
			int d = sc.nextInt();
			
			System.out.print("\tMês: ");
			int m = sc.nextInt();
			m--;
			
			System.out.print("\tAno: ");
			int a = sc.nextInt();
			
			System.out.print("\n\nDigite 1 se for um funcionário ou 2 se for um cliente: ");
			int nn = sc.nextInt();
			
			if (nn==1) {
				
				System.out.print("\n\nInforme o RA: ");
				int n = sc.nextInt();
				
				processos.add(new Processo(num, new Date(a, m, d), null, (short) 1, funcionarios.get(n-1)));
			} 

			else if (nn==2) {
				
				System.out.print("\n\nInforme o id: ");
				int n = sc.nextInt();
				
				processos.add(new Processo(num, new Date(a, m, d), null, (short) 1, clientes.get(n-1)));
			}

			else {
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				return;
			}
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Opção inválida!");
		}
	}
	
	public static void consultar () {
		
		System.out.print("\n\n\n\n\t\tMENU DE CONSULTA\n\n");
		System.out.print("Considere as seguintes opções: \n\t1-Consultar pessoa \n\t2-Consultar funcionário \n\t3-Consultar cliente \n\t0-Voltar");
		System.out.print("\n\nInforme a opção desejada: ");
		int op = sc.nextInt();
		sc.nextLine();
		
		if (op==0)
			return;
		
		else if (op==1) {
			
			System.out.print("\n\nInforme o nome da pessoa: ");
			String n = sc.nextLine();

			busca (1, n);
		}
		
		else if (op==2) {
			
			System.out.print("\n\nInforme o nome do funcionário: ");
			String n = sc.nextLine();
			
			boolean ok = false;
			
			for (int i=0; i<funcionarios.size(); i++) {
				if (funcionarios.get(i).getNome().equals(n)) {
					ok = true;
					break;
				}
			}
			
			if (ok==false)
				return;
			
			busca(2, n);
		}	
		
		else if (op==3) {
				
			System.out.print("\n\nInforme o nome do cliente: ");
			String n = sc.nextLine();
				
			boolean ok = false;
				
			for (int i=0; i<clientes.size(); i++) {
				if (clientes.get(i).getNome().equals(n)) {
					ok = true;
					break;
				}
			}
				
			if (ok==false)
				return;
				
			busca(2, n);
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Opção inválida!");
		}
	}
	
	public static void busca (int o, String n) {
		System.out.print("\n\n");
		
		if (o==1) {
			System.out.println("\n\n\tPROCESSOS DE " + n + "\n");
			for (int i=0; i<processos.size(); i++) {
				if (processos.get(i).getPessoa().getNome().equals(n)) {
					Processo p = processos.get(i);
					
					System.out.println("Número: " + p.getNumero() + ", Data de Abertura: " + p.getDataAbertura() + ", Data de Encerramento: "
							+ (p.getDataEncerramento2() == null ? "-" : p.getDataEncerramento()) + ", Status: " + p.getStatus());
				}
			}
		}
		
		else {
			System.out.println("\n\n\tPROCESSOS NÃO FINALIZADOS DE " + n + "\n");
			for (int i=0; i<processos.size(); i++) {
				if (processos.get(i).getPessoa().getNome().equals(n) && !processos.get(i).getStatus().equals("Finalizado")) {
					Processo p = processos.get(i);
					
					System.out.println("Número: " + p.getNumero() + ", Data de Abertura: " + p.getDataAbertura() + ", Data de Encerramento: "
							+ (p.getDataEncerramento2() == null ? "-" : p.getDataEncerramento()) + ", Status: " + p.getStatus());
				}
			}
		}
	}
}
