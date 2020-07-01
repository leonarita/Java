package exercicio3;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class _Exercicio3 
{
	public class Cliente 
	{	
		private int codigo;
		private String nome, cpf;
		
		public Cliente ()
		{
			this.codigo = -1;
		}
		
		public void mensagem ()
		{
			JOptionPane.showMessageDialog(null, "Criado com sucesso!");
		}

		public int getCodigo() 
		{
			return codigo;
		}
		
		public void setCodigo(int codigo) 
		{
			this.codigo = codigo;
			this.mensagem();
		}
		
		public String getNome() 
		{
			return nome;
		}
		
		public boolean setNome(String nome) 
		{
			if (nome.contains(" "))
			{	this.nome = nome;
				return true;
			}
			else
			{	System.out.println("\n\nNão foi possível inserir o nome " + nome + "! \n(Sobrenome é obrigatório)");
				return false;
			}
		}
		
		public String getCpf() 
		{
			return cpf;
		}
		
		public boolean setCpf(String cpf) 
		{
			if (cpf.length() == 11)
			{	this.cpf = cpf;
				return true;
			}
			else
			{	System.out.println("\n\nCPF deve conter 11 digitos!");
				return false;
			}
		}
	}

	public static class Inicio 
	{
		public static void main(String[] args) 
		{
			Scanner sc = new Scanner (System.in);
			
			int indice = 0, op;
			Cliente[] clientes = new Cliente[10];
			String[] textos = new String[] { "Inserir Cliente", "Consultar cliente específico", "Consultar clientes" };
			
			for (int i=0; i<10; i++)
				clientes[i] = new _Exercicio3().new Cliente();
				//Para instanciar uma classe dentro de uma classe, basta instanciar a classe mais externa e, depois, a classe mais interna
			
			do
			{
				menu(textos);
				op = sc.nextInt();
				
				sc.nextLine();
				System.out.println("\n\n");
				
				if (op==0)
				{
					System.out.println("Até a próxima!");
					break;
				}
				else if (op==1)
				{
					if (indice==10)
					{
						System.out.println("\tNão é possível inserir, pois o vetor está lotado!");
						continue;
					}
					
					System.out.print("\tInforme o nome: ");
					String nome = sc.nextLine();
					
					System.out.print("\tInforme o CPF: ");
					String cpf = sc.nextLine();
					
					if (clientes[indice].setNome(nome) && clientes[indice].setCpf(cpf))
					{
						clientes[indice].setCodigo(indice);
						indice++;
					}
					else
						continue;
				}
				else if (op==2)
				{
					System.out.print("\tInforme o Código para consultar: ");
					int cod = sc.nextInt();
					
					for (Cliente i : clientes)
					{
						if (i.getCodigo() == cod)
							System.out.println("Código: " + i.getCodigo() + ", nome: " + i.getNome() + ", CPF: " + i.getCpf());
					}
				}
				else if (op==3)
				{
					for (Cliente i : clientes)
						if (i.getCodigo() != -1)
							System.out.println("Código: " + i.getCodigo() + ", nome: " + i.getNome() + ", CPF: " + i.getCpf());
				}
				else
					System.out.println("Comando inválido!");
			}
			while (op!=0);
			
			sc.close();
		}
		
		public static void menu (String[] textos)
		{
			System.out.println("\n\nConsidere as opções abaixo: ");
			for (int i=0; i<textos.length; i++)
				System.out.println("\t" + (i+1) + "-" + textos[i]);
			System.out.println("\t0-Sair");
			System.out.print("\n\nInsira a opção desejada: ");
		}

	}

}
