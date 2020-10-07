package atividade;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import atividade.administrador.log.GravarErro;
import atividade.administrador.tela.DisplayQueryResults;
import atividade.designPattern.factoryMethod.FactoryConta;
import atividade.designPattern.factoryMethod.FactoryPessoa;
import atividade.modelo.*;
import atividade.modelo.enumeration.SituacaoContaEnum;
import atividade.modelo.enumeration.SituacaoPessoaEnum;
import atividade.modelo.repositorio.FabricaConexao;

public class Main {

// DESIGN PATTERNS
	// Creational => FactoryMethod, Singleton, Builder
	// Structural => Facade, Adapter
	// Behavior   => Strategy, Iterator, Mediator
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int op = 1;
		
		String[] textos = new String[] { "Registrar pessoa física", "Registrar pessoa jurídica", "Abrir conta comum", 
				"Abrir conta especial", "Abrir conta poupança", "Acessar conta comum", "Acessar conta especial", "Acessar conta poupança",
				"Acessar painel administrativo"};
		
		do {
			
			try {
				menu(textos);
				
				try {
					op = sc.nextInt();
				}
				catch (InputMismatchException e) {
					System.err.println("\n\n\tOpção inválida!");
					GravarErro.relatarErro(e.getMessage());
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
						criarPessoa(op+1);
					}
					catch (InputMismatchException | IllegalArgumentException e) {
						GravarErro.relatarErro(e.getMessage());
						
						if (e.getClass().equals(InputMismatchException.class)) {
							System.err.print("\n\tO campo anterior é inválido!");
							sc.nextLine();
						}
						else if(e.getClass().equals(IllegalArgumentException.class)) {
							System.err.println("\n\t" + e.getMessage());
						}
					}
				}
				
				else if (op > 2 && op < 9) {
					try {
	
						if(op > 2 && op < 6)
							coletarCredencial(op - 2, 1);
						else if (op > 5 && op < 9)
							coletarCredencial(op - 5, 2);
	
					}
					catch (InputMismatchException e) {
						System.err.print("\n\tO campo anterior é inválido!");
						GravarErro.relatarErro(e.getMessage());
						sc.nextLine();
					}
					catch (IllegalArgumentException e) {
						System.err.println("\n\t" + e.getMessage());
						GravarErro.relatarErro(e.getMessage());
					}
				}
				else if (op == 9) {
					String user = JOptionPane.showInputDialog("Insira o usuário: ");
					String password = JOptionPane.showInputDialog("Insira a senha: ");
															
					if(user.equals("admin") && password.equals("root")) {
						DisplayQueryResults display = new DisplayQueryResults();
						display.gerarJanelaAdministrativa();
					}
					else
						JOptionPane.showMessageDialog(null, "ERRO", "Credenciais incorretas...", 0);
				}
				
				else {
					System.err.print("\t\tOpção inválida");
				}
			}
			catch (Exception e) {
				
				System.err.println("\n\n\t\t\tERROR 500: INTERNAL SERVER ERROR"
						+ "\n\t\tErro: " + e.getClass().getSimpleName() 
						+ "\n\t\tMensagem: " + e.getMessage());
				
				GravarErro.relatarErro(e.getMessage());
				sc.nextLine();
			}
			
		}
		while (op!=0);
		
		sc.close();
		
		FabricaConexao.fecharConexao();
	}
	
	public static void menu (final String[] textos) {
		System.out.println("\n\nConsidere as opções abaixo: \n");
		
		for (int i=0; i<textos.length; i++)
			System.out.println("\t" + ((i+1) < 10 ? " " + (i+1) : (i+1)) + "- " + textos[i]);
		
		System.out.println("\t 0- Sair");
		System.out.print("\n\nInsira a opção desejada: ");
	}
	
	public static int criarPessoa (final int tipo) {
		int cod = 0;
		
		System.out.println("\n\nCADASTRO DE USUÁRIO");

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
		
		Pessoa p = FactoryPessoa.criarPessoa(tipo, nome, endereco, cep, telefone, renda);
		boolean result = false;
		
		if(tipo == SituacaoPessoaEnum.PESSOAFISICA.getSituacao()) {
			
			System.out.print("\tInsira o cpf: ");
			result = ((PessoaFisica) p).setCpfPessoa(sc.nextLine());
			
			if (result) {
			
				System.out.print("\tInsira o rg: ");
				((PessoaFisica) p).setRgPessoa(sc.nextLine());
				
				System.out.print("\tInsira a idade: ");
				((PessoaFisica) p).setIdadePessoa(sc.nextInt());
				sc.nextLine();
			}
			else {
				JOptionPane.showMessageDialog(null, "CPF inválido!");
			}
		}
		else if(tipo == SituacaoPessoaEnum.PESSOAJURIDICA.getSituacao()) {

			System.out.print("\tInsira o cnpj: ");
			result = ((PessoaJuridica) p).setCnpjPessoa(sc.nextLine());

			if (result) {
			}
			else
				JOptionPane.showMessageDialog(null, "CNPJ inválido!");
		}
		
		if (result) {
			cod = p.registrarPessoa();
			
			if(cod == 0)
				throw new IllegalArgumentException("CPF já cadastrado!");
		}
		else
			throw new IllegalArgumentException("Houve algum erro inesperado...");
		
		System.out.println("\n\t\tCadastro efetuado com sucesso!");
		return cod;
	}
	
	public static void coletarCredencial(final int tipo, final int op) {
		
		System.out.print("Insira o CPF ou CNPJ: ");
		String credential = sc.nextLine();
		int idPessoa = 0;
		
		try {
			// Utilizando design pattern strategy
			idPessoa = FactoryPessoa.escolherContaPorCredencial(credential).buscarIdPelaCredencial(credential);
		}
		catch (Exception e) {
			GravarErro.relatarErro(e.getMessage());
			throw new IllegalArgumentException("Credencial inválida!");
		}
			
		if (idPessoa != 0){
			
		}
		else if (idPessoa == 0) {
			System.out.print("\n\tVocê não está cadastrado no sistema. Deseja se cadastrar? [S/N] ");
			Character response = sc.next().charAt(0);
			sc.nextLine();
			
			if (Character.toUpperCase(response) == 'S') {
				try {
					idPessoa = criarPessoa(credential.length() == 11 ? 2 : 3);
					
					if (op == 2) {
						criarConta(tipo, idPessoa);
					}
				}
				catch (InputMismatchException | IllegalArgumentException e) {
					
					if (e.getClass().equals(InputMismatchException.class)) {
						System.err.print("\n\tO campo anterior é inválido!");
						sc.nextLine();
					}
					else if(e.getClass().equals(IllegalArgumentException.class)) {
						System.err.println("\n\t" + e.getMessage());
					}
				}
			}
			else {
				return;
			}
		}
		else {
			throw new IllegalArgumentException("Credencial inválida!");
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
				try {
					acessarConta(tipo, idPessoa);
				}
				catch (NullPointerException e) {
					System.err.println("\n\tConta não encontrada no banco de dados na modalidade fornecida");
					GravarErro.relatarErro(e.getMessage());
				}
			}
		}
	}
	
	public static void criarConta(final int tipo, final int idPessoa) {

		System.out.println("\n\nCRIAÇÃO DE CONTA");

		System.out.print("\tInsira a senha: ");
		int senha = sc.nextInt();
		
		ContaComum cc = FactoryConta.criarConta(tipo, LocalDate.now(), null, 1, senha, BigDecimal.ZERO, null);
		
		if (cc instanceof ContaEspecial) {
			
			System.out.print("\tInsira o saldo: ");
			cc.setSaldoConta(sc.nextBigDecimal());
			
			System.out.print("\tInsira o limite: ");
			((ContaEspecial) cc).setLimiteConta(sc.nextDouble());
		}
		else if (cc instanceof ContaPoupanca) {
			((ContaPoupanca) cc).setAniversarioConta(LocalDate.now());
		}
		
		int idConta = cc.abrirConta(idPessoa);
		System.out.println("\n\t\t" + (idConta == 0 ? "Erro ao criar conta" : "Conta nº " + idConta + " criada com sucesso!"));
	}
	
	public static void acessarConta(final int tipo, final int idPessoa) {
		
		System.out.println("\n\nACESSO À CONTA");
		
		System.out.print("\tInsira o número da conta: ");
		int numeroConta = sc.nextInt();
		
		System.out.print("\tInsira a senha: ");
		int senha = sc.nextInt();
		
		String[] textos = null;
			
		if (tipo == SituacaoContaEnum.CONTACOMUM.getSituacao()) {
			
			textos = new String[] { "Consultar conta", "Emitir saldo", "Emitir extrato", "Emitir extrato em um período específico", 
				"Sacar valor", "Depositar valor", "Encerrar conta", "Consultar movimento em uma data específica" };
		}
		else if (tipo == SituacaoContaEnum.CONTAESPECIAL.getSituacao()) {

			textos = new String[] { "Consultar conta", "Emitir saldo", "Emitir extrato", "Emitir extrato em um período específico", 
				"Sacar valor", "Depositar valor", "Encerrar conta", "Consultar movimento em uma data específica" };
		}
		else if (tipo == SituacaoContaEnum.CONTAPOUPANCA.getSituacao()) {
			
			textos = new String[] { "Consultar conta", "Emitir saldo", "Emitir extrato", "Emitir extrato em um período específico", 
				"Sacar valor", "Depositar valor", "Encerrar conta", "Consultar movimento em uma data específica",
				"Visualizar renda (juros)" };
		}
		
		// Utilizando design pattern strategy
		try (ContaComum c = FactoryConta.criarConta(tipo).acessarConta(numeroConta, senha, idPessoa)) {
			
			if(c.getNumeroConta() == 0 || c == null) {
				throw new IllegalArgumentException("Conta não cadastrada ou não encontrada");
			}
			else {	
				realizarOperacoesBanco(c, textos);
			}
		}
		catch (IllegalArgumentException e) {
			System.err.println("\n\t" + e.getMessage());
			GravarErro.relatarErro(e.getMessage());
		}
		catch (NullPointerException e) {
			System.err.println("\n\t\tAlgum dado foi incompatível: NULL");
			GravarErro.relatarErro(e.getMessage());
		}
		catch (Exception e) {
			System.err.println("\n\t\tHouve algum erro...");
			GravarErro.relatarErro(e.getMessage());
		}
	}
	
	public static void consultarDadosNaData(final ContaComum cc, final int op) {
		
		try {				
			sc.nextLine();
			DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			
			System.out.print("\n\tInsira a data " + (op == 2 ? "inicial" : "desejada") + " (dd/mm/aaaa): ");
			String d = sc.nextLine();
			LocalDateTime dateTimeInicio = LocalDate.parse(d, parser).atStartOfDay();
			dateTimeInicio.plusDays(-1);
			
			LocalDateTime dateTimeFim = null;
			
			if (op == 2) {
				System.out.print("\n\tInsira a data final (dd/mm/aaaa): ");
				d = sc.nextLine();
				dateTimeFim = LocalDate.parse(d, parser).atStartOfDay();
				dateTimeFim.plusDays(1);
			}
				
			cc.emitirExtrato(dateTimeInicio, dateTimeFim);
		}
		catch (DateTimeParseException ex) {
			System.err.println("\n\t\tA data está mal formatada...");
			GravarErro.relatarErro(ex.getMessage());
		}
		catch (Exception ex) {
			System.err.println("\n\t\tHouve algo de errado... \n" + ex.getClass());
			GravarErro.relatarErro(ex.getMessage());
		}
	}
	
	public static void realizarOperacoesBanco(final ContaComum cc, final String[] textos) {
		
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
					System.out.println("Saldo: " + cc.emitirSaldo());
				}
				else if (op == 3) {
					
					cc.emitirExtrato(null, null);
				}
				else if (op == 4) {
					
					consultarDadosNaData(cc, 2);
				}
				else if (op == 5) {
					System.out.print("\n\tInsira o valor para sacar: ");
					BigDecimal valor = sc.nextBigDecimal();
					
					m.registrarMovimento(2, valor);
					
				    if(m.getIdMovimento() > 0) {
						  System.out.println("MV ID " + m.getIdMovimento() + ": Saque de " + m.getValorMovimento() + " realizado!\n");
						  cc.sacarValor(valor);
				    }
				}
				else if (op == 6) {
					System.out.print("\n\tInsira o valor para depositar: ");
					BigDecimal valor = sc.nextBigDecimal();
					
					m.registrarMovimento(1, valor);
					
				    if(m.getIdMovimento() > 0) {
						  System.out.println("MV ID " + m.getIdMovimento() + ": Depósito de " + m.getValorMovimento() + " realizado!\n");
						  cc.depositarValor(valor);
				    }
				}
				else if (op == 7) {
					cc.setFechamentoConta(LocalDate.now());
					
					if (cc.encerrarConta() == 1) {
						System.out.println("\n\tConta encerrada com sucesso!");
						break;
					}
					else
						System.out.println("\n\tHouve algum imprevisto ao encerrar a conta...");
				}
				else if (op == 8) {
					
					consultarDadosNaData(cc, 1);
				}
								
				else if (op == 9 && cc instanceof ContaPoupanca) {
					System.out.println("\n\tBUILDING...");	
				}
				
				else {
					System.out.print("\n\t\tOpção inválida");
				}
			}
			while (op != 0);
		}
		else {
			System.out.println("Conta já encerrada!");
		}
	}
}
