package example2_DataPersistence;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import example2_DataPersistence.modelo.*;
import example2_DataPersistence.modelo.repositorio.MovimentoDAO;

public class Main {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int op = 1;
		
		String[] textos = new String[] { "Registrar pessoa física", "Registrar pessoa jurídica", "Consultar CPF", "Consultar CNPJ",
				"Abrir conta comum", "Abrir conta especial", "Abrir conta poupança", "Acessar conta comum", "Acessar conta especial",
				"Acessar conta poupança"};
		
		do {
			
			try {
				menu(textos);
				
				try {
					op = sc.nextInt();
				}
				catch (InputMismatchException a) {
					System.out.println("\n\n\tOpção inválida!");
					continue;
				}
				finally {
					sc.nextLine();
					System.out.println("\n\n");
				}
				
				if (op == 0) {
					System.out.println("Até a próxima!");
					break;
				}
				
				else if (op == 1 || op == 2) {
					try {
						criarPessoa(op);
					}
					catch (InputMismatchException e) {
						System.out.print("\n\tO campo anterior é inválido!");
						sc.nextLine();
					}
				}
				
				else if (op == 3) {
					System.out.print("\tInsira o CPF para buscar: ");
					String cpf = sc.nextLine();
					
					System.out.println(PessoaFisica.consultarCpf(cpf));
				}
				else if (op == 4) {
					System.out.print("\tInsira o CNPJ para buscar: ");
					String cnpj = sc.nextLine();
					
					System.out.println(PessoaJuridica.consultarCnpj(cnpj));
				}
				
				else if (op > 4 && op < 11) {
					try {
	
						if(op > 4 && op < 8)
							coletarCredencial(op - 4, 1);
						else if (op > 7 && op < 11)
							coletarCredencial(op - 7, 2);
	
					}
					catch (InputMismatchException e) {
						System.out.print("\n\tO campo anterior é inválido!");
						sc.nextLine();
					}
					catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
				}
				
				else {
					System.out.print("\t\tOpção inválida");
				}
			}
			catch (Exception e) {
				System.out.println("\n\n\t\t\tERROR 500: INTERNAL SERVER ERROR\n" + e.getMessage());
				sc.nextLine();
			}
		}
		while (op!=0);
		
		sc.close();
	}
	
	public static void menu (String[] textos) {
		System.out.println("\n\nConsidere as opções abaixo: \n");
		
		for (int i=0; i<textos.length; i++)
			System.out.println("\t" + ((i+1) < 10 ? " " + (i+1) : (i+1)) + "- " + textos[i]);
		
		System.out.println("\t 0-Sair");
		System.out.print("\n\nInsira a opção desejada: ");
	}
	
	public static int criarPessoa (int tipo) throws InputMismatchException {
		int cod = 0;

		System.out.print("\tInsira o nome: ");
		String nome = sc.nextLine();
		
		System.out.print("\tInsira o endereço: ");
		String endereco = sc.nextLine();
		
		System.out.print("\tInsira o cep: ");
		long cep = sc.nextLong();
		sc.nextLine();
		
		System.out.print("\tInsira o telefone: ");
		String telefone = sc.nextLine();
		
		System.out.print("\tInsira a renda: ");
		double renda = sc.nextDouble();
		sc.nextLine();
		
		if(tipo == 1) {
			PessoaFisica pf = new PessoaFisica(nome, endereco, cep, telefone, renda);
			
			System.out.print("\tInsira o cpf: ");
			boolean result = pf.setCpfPessoa(sc.nextLine());
			
			if (result) {
			
				System.out.print("\tInsira o rg: ");
				pf.setRgPessoa(sc.nextLine());
				
				System.out.print("\tInsira a idade: ");
				pf.setIdadePessoa(sc.nextInt());
				sc.nextLine();
				
				cod = pf.registrarPessoa();
			}
			else {
				JOptionPane.showMessageDialog(null, "CPF inválido!");
			}
		}
		else if(tipo == 2) {
			PessoaJuridica pj = new PessoaJuridica(nome, endereco, cep, telefone, renda);

			System.out.print("\tInsira o cnpj: ");
			boolean result = pj.setCnpjPessoa(sc.nextLine());

			if (result)
				cod = pj.registrarPessoa();
			else
				JOptionPane.showMessageDialog(null, "CNPJ inválido!");
		}
		
		return cod;
	}
	
	public static void coletarCredencial(int tipo, int op) throws InputMismatchException, IllegalArgumentException {
		
		System.out.print("Insira o CPF ou CNPJ: ");
		String credential = sc.nextLine();
		int idPessoa = 0;
		
		if (credential.length() == 11) {
			idPessoa = PessoaFisica.buscarIdPeloCpf(credential);
			
			if (idPessoa == 0) {
				System.out.print("\n\tVocê não está cadastrado no sistema. Deseja se cadastrar? [S/N] ");
				String r = sc.nextLine();
				
				if (r.toLowerCase().contains("s")) {
					idPessoa = criarPessoa(1);
				}
				else {
					return;
				}
			}
		}
		else if (credential.length() == 14) {
			idPessoa = PessoaJuridica.buscarIdPeloCnpj(credential);
			
			if (idPessoa == 0) {
				System.out.print("\n\tVocê não está cadastrado no sistema. Deseja se cadastrar? [S/N] ");
				String r = sc.nextLine();
				
				if (r.toLowerCase().contains("s")) {
					idPessoa = criarPessoa(2);
				}
				else {
					return;
				}
			}
		}
		else {
			throw new IllegalArgumentException("\n\n\tCredencial inválida!");
		}
		
		if (idPessoa == 0) {
			System.out.println("\n\t\tOPS... Algo deu errado!");
			return;
		}
		else {
			if (op == 1) {
				criarConta(tipo, idPessoa);
			}
			else if (op == 2) {
				acessarConta(tipo, idPessoa);
			}
		}
	}
	
	public static void criarConta(int tipo, int idPessoa) throws InputMismatchException, IllegalArgumentException {
		
		System.out.print("\tInsira a senha: ");
		int senha = sc.nextInt();
		
		System.out.print("\tInsira o saldo: ");
		double saldo = sc.nextDouble();
		
		if (tipo == 1) {
			ContaComum cc = new ContaComum(LocalDate.now(), null, 1, senha, saldo, null);
			cc.abrirConta(idPessoa);
		}
		else if (tipo == 2) {
			ContaEspecial ce = new ContaEspecial(LocalDate.now(), null, 2, senha, saldo, null);
			
			System.out.print("\tInsira o limite: ");
			ce.setLimiteConta(sc.nextDouble());
			ce.abrirConta(idPessoa);
		}
		else if (tipo == 3) {
			ContaPoupanca cp = new ContaPoupanca(LocalDate.now(), null, 3, senha, saldo, null);
			cp.setAniversarioConta(LocalDate.now());
			cp.abrirConta(idPessoa);
		}
	}
	
	public static void acessarConta(int tipo, int idPessoa) throws InputMismatchException {
		
		System.out.print("\tInsira o número da conta: ");
		int numeroConta = sc.nextInt();
		
		System.out.print("\tInsira a senha: ");
		int senha = sc.nextInt();
		
		if (tipo == 1) {
		
			ContaComum cc = ContaComum.acessarConta(numeroConta, senha);
			
			if(cc == null) {
				throw new IllegalArgumentException("\n\t\tConta não cadastrada ou não encontrada");
			}
			else {
				realizarOperacoesBanco(1, cc);
			}
		}
		else if (tipo == 2) {
			
			ContaComum ce = ContaComum.acessarConta(numeroConta, senha);
			
			if(ce == null) {
				throw new IllegalArgumentException("\n\t\tConta não cadastrada ou não encontrada");
			}
			else {
				throw new IllegalArgumentException("\n\t\tBUILDING...");
			}
		}
		else if (tipo == 3) {
			
			ContaComum cp = ContaComum.acessarConta(numeroConta, senha);
			
			if(cp == null) {
				throw new IllegalArgumentException("\n\t\tConta não cadastrada ou não encontrada");
			}
			else {
				throw new IllegalArgumentException("\n\t\tBUILDING...");
			}
		}
	}
	
	public static void realizarOperacoesBanco(int tipo, ContaComum cc) {

		String[] textos = new String[] { "Consultar conta", "Emitir saldo", "Emitir extrato", 
				"Sacar valor", "Depositar valor", "Encerrar conta" };
		
		int op = 1;
				
		if (cc.getFechamentoConta() == null) {
			do {
				menu(textos);
				op = sc.nextInt();
				
				Movimento m = new Movimento();
				m.setContaMovimento(cc);
				
				if (op == 0) {
					break;
				}
				
				else if (op == 1) {
					System.out.println(cc.toString());
				}
				else if (op == 2) {
					System.out.println("Saldo: " + cc.getSaldoConta());
				}
				else if (op == 3) {
					
					if (cc != null) {
						System.out.println("\n\nConta recuperada: numero = " + cc.getNumeroConta() + ", saldo = "
								+ cc.getSaldoConta());
						
						MovimentoDAO mvDao = new MovimentoDAO();
						cc.setMovimentosConta(mvDao.obterMovimentosPorNumeroConta(cc.getNumeroConta()));
						mvDao.fecharConexao();
						
						for (Movimento mv : cc.getMovimentosConta()) {
							System.out.println("MV ID " + mv.getIdMovimento() + ", tipo = " + mv.getTipoMovimento() + ", valor = "
									+ mv.getValorMovimento());
						}
					}
				}
				else if (op == 4) {
					System.out.print("\n\tInsira o valor para sacar: ");
					double valor = sc.nextDouble();
					
					m.registrarMovimento(2, valor);
					
				    if(m.getIdMovimento() > 0) {
						  System.out.println("MV ID " + m.getIdMovimento() + ": Saque de " + m.getValorMovimento() + " realizado!\n");
						  cc.setSaldoConta(cc.getSaldoConta() - valor);
				    }
				}
				else if (op == 5) {
					System.out.print("\n\tInsira o valor para depositar: ");
					double valor = sc.nextDouble();
					
					m.registrarMovimento(1, valor);
					
				    if(m.getIdMovimento() > 0) {
						  System.out.println("MV ID " + m.getIdMovimento() + ": Depósito de " + m.getValorMovimento() + " realizado!\n");
						  cc.setSaldoConta(cc.getSaldoConta() + valor);
				    }
				}
				else if (op == 6) {
					cc.setFechamentoConta(LocalDate.now());
					
					if (cc.encerrarConta() == 1) {
						System.out.println("\n\tConta encerrada com sucesso!");
						break;
					}
					else
						System.out.println("\n\tHouve algum imprevisto ao encerrar a conta...");
				}
			}
			while (op != 0);
		}
		else {
			System.out.println("Conta já encerrada!");
		}
	}
}
