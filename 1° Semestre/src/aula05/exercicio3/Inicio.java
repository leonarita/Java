package aula05.exercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		
		int codigo = 1;
		int op = 1, op2 = 0;
		int indexPF = 0, indexPJ = 0;
		
		PessoaFisica[] pessoaFisica = new PessoaFisica[10];
		PessoaJuridica[] pessoaJuridica = new PessoaJuridica[10];
		
		String endereco = "", telefone = "", nome, cpf, razaoSocial, cnpj;
		
		String[] textos = new String[] { "Inserir Cliente", "Remover", "Consultar clientes" };
		
		Scanner sc = new Scanner (System.in);
		
		do {
			
			try {
				menu(textos);
				op = sc.nextInt();
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
			
			if (op == 1) {
				menu(new String[] { "Pessoa F�sica", "Pessoa Jur�dica" });
				
				try {
					op2 = sc.nextInt();
					sc.nextLine();
				}
				catch (InputMismatchException e) {
					System.out.println("\n\n\t\tInsira um c�digo v�lido!");
					sc.nextLine();
					continue;
				}
					
				if (op2 == 1) {
					
					try {
						
						if (indexPF == 10) {
							throw new IndexOutOfBoundsException("\tN�o � poss�vel inserir, pois o vetor est� lotado!");
						}
						
						try {
						
							System.out.print("\tInforme o telefone: ");
							telefone = sc.nextLine();
							
							if(telefone.length() < 8 || telefone.contains("^[a-Z]"))
								throw new IndexOutOfBoundsException("\n\t\tTelefone inv�lido!");
							
							System.out.print("\tInforme o endere�o: ");
							endereco = sc.nextLine();
							
							if(endereco.length() < 5)
								throw new IndexOutOfBoundsException("\n\t\tEndere�o inv�lido!");
								
							System.out.print("\tInforme o CPF: ");
							cpf = sc.nextLine();
							
							if(cpf.length() < 11 || cpf.contains("^[a-Z]"))
								throw new IndexOutOfBoundsException("\n\t\tCPF inv�lido!");
								
							System.out.print("\tInforme o nome: ");
							nome = sc.nextLine();
							
							if(!nome.contains(" "))
								throw new IndexOutOfBoundsException("\n\t\tInsira nome e sobrenome!");
								
							pessoaFisica[indexPF] = new PessoaFisica();
							pessoaFisica[indexPF].setCodigo(codigo);
							pessoaFisica[indexPF].setTelefone(telefone);
							pessoaFisica[indexPF].setEndereco(endereco);
							pessoaFisica[indexPF].setNome(nome);
							pessoaFisica[indexPF].setCpf(cpf);
	
							indexPF++;
							
							System.out.println("\n\n\t\tDado inserido com sucesso!");
							codigo++;
						}
						catch (ValidateDataException e) {
							System.out.println(e.getMessage());
						}
					}
					catch(IndexOutOfBoundsException e) {
						System.out.println(e.getMessage());
					}
					
						
				}
				else if (op2 == 2) {
					
					try {
						
						if (indexPJ == 10) {
							throw new IndexOutOfBoundsException("\tN�o � poss�vel inserir, pois o vetor est� lotado!");
						}
					
						try {
							System.out.print("\tInforme o telefone: ");
							telefone = sc.nextLine();
							
							if(telefone.length() < 8 || telefone.contains("^[a-Z]"))
								throw new IndexOutOfBoundsException("\n\t\tTelefone inv�lido!");
							
							System.out.print("\tInforme o endere�o: ");
							endereco = sc.nextLine();
							
							if(endereco.length() < 5)
								throw new IndexOutOfBoundsException("\n\t\tEndere�o inv�lido!");
								
							System.out.print("\tInforme o CNPJ: ");
							cnpj = sc.nextLine();
							
							if(cnpj.length() < 14 || cnpj.contains("^[a-Z]"))
								throw new IndexOutOfBoundsException("\n\t\tCPF inv�lido!");
								
							System.out.print("\tInforme o nome: ");
							razaoSocial = sc.nextLine();
								
							pessoaJuridica[indexPJ] = new PessoaJuridica();
							pessoaJuridica[indexPJ].setCodigo(codigo);
							pessoaJuridica[indexPJ].setEndereco(endereco);
							pessoaJuridica[indexPJ].setTelefone(telefone);
							pessoaJuridica[indexPJ].setCnpj(cnpj);
							pessoaJuridica[indexPJ].setRazaoSocial(razaoSocial);
		
							indexPJ++;
							
							System.out.println("\n\n\t\tDado inserido com sucesso!");
							codigo++;
						}
						catch (ValidateDataException e) {
							System.out.println(e.getMessage());
						}
					}
					catch(IndexOutOfBoundsException e) {
						System.out.println(e.getMessage());
					}
				}
				else if (op2 == 0)
					continue;
				else {
					System.out.println("\tOp��o inv�lida...");
					continue;
				}
			}
			
			else if (op == 2) {
				
				try {
					System.out.print("\tInforme o c�digo do cliente a ser exlu�do: ");
					int cod = sc.nextInt();
					boolean find = false;
					
					for (int i=0; i<indexPF; i++) {
						if (cod == pessoaFisica[i].getCodigo()) {
							pessoaFisica[i] = null;
							indexPF--;
							find = true;
							break;
						}
					}
					
					if (!find) {
						for (int i=0; i<indexPJ; i++) {
							if(cod == pessoaJuridica[i].getCodigo()) {
								pessoaJuridica[i] = null;
								indexPJ--;
								find = true;
								break;
							}
						}
					}
					
					if (find) {
						System.out.println("\n\n\tDeletado com sucesso!");
					}
					else {
						throw new IllegalArgumentException("\n\n\tC�digo n�o encontrado!");
					}
				}
				catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
			
			else if (op == 3) {
				System.out.println("\n\n----- PESSOA F�SICA -----");
				
				for (int i=0; i<indexPF; i++) {
					System.out.println("\t id= " + pessoaFisica[i].getCodigo() + ", nome=" + pessoaFisica[i].getNome() 
							+ ", cpf=" + pessoaFisica[i].getCpf() + ", telefone=" + pessoaFisica[i].getTelefone() 
							+ ", endere�o=" + pessoaFisica[i].getEndereco());
				}
				
				System.out.println("\n\n----- PESSOA JUR�DICA -----");
				
				for (int i=0; i<indexPJ; i++) {
					
					System.out.println("\t id= " + pessoaJuridica[i].getCodigo() + ", raz�o social=" + pessoaJuridica[i].getRazaoSocial() 
							+ ", cnpj=" + pessoaJuridica[i].getCnpj() + ", telefone=" + pessoaJuridica[i].getTelefone() 
							+ ", endere�o=" + pessoaJuridica[i].getEndereco());
				}
			}
			
			else
				System.out.println("\n\n\tComando inv�lido!");
			
		}
		while (op != 0);
		
		sc.close();

	}
	
	public static void menu (String[] textos) {
		System.out.println("\n\nConsidere as op��es abaixo: ");
		for (int i=0; i<textos.length; i++)
			System.out.println("\t" + (i+1) + "-" + textos[i]);
		System.out.println("\t0-Sair");
		System.out.print("\n\nInsira a op��o desejada: ");
	}

}

