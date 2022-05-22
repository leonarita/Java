package projeto.estacionamento;

import java.util.Objects;
import java.util.Scanner;

import projeto.estacionamento.business.OperacoesCliente;
import projeto.estacionamento.business.OperacoesConta;
import projeto.estacionamento.business.OperacoesPatio;
import projeto.estacionamento.business.OperacoesVeiculoCaminhao;
import projeto.estacionamento.business.OperacoesVeiculoCarro;
import projeto.estacionamento.enumerations.RespostasOpcoesIniciais;
import projeto.estacionamento.enumerations.RespostasOperacoesContas;
import projeto.estacionamento.enumerations.RespostasOperacoesEscolhaVeiculos;
import projeto.estacionamento.enumerations.RespostasOperacoesGenericas;
import projeto.estacionamento.utils.Mensagens;

public class Main {
	
	private static String[] textosDeOpcoesIniciais = {"Cliente", "Ve�culo", "P�tio", "Conta"};
	private static String[] textosDeOperacoesGenericos = {"Cadastro", "Altera��o", "Exclus�o", "Consulta", "Relat�rio"};
	private static String[] textosDeOperacoesPatio = {"Cadastro", "Altera��o", "Exclus�o", "Consulta", "Relat�rio", "Lota��o"};
	private static String[] textosDeOperacoesConta = {"Inclus�o de Di�ria", "Exclus�o de Di�ria", "Total a Pagar"};
	private static String[] textosDeOperacoesVeiculos = {"Carro", "Caminh�o"};
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			RespostasOpcoesIniciais respostaOpcaoInicial = RespostasOpcoesIniciais.getById(menu(textosDeOpcoesIniciais, "Sair"));
			
			if(respostaOpcaoInicial.equals(RespostasOpcoesIniciais.SAIR)) {
				System.out.println(Mensagens.getMensagem("At� logo!", 1, 2));
				break;
			}
			else if(respostaOpcaoInicial.equals(RespostasOpcoesIniciais.CONTA)) {
				RespostasOperacoesContas respostasOperacoesContas = RespostasOperacoesContas.getById
						(menu(textosDeOperacoesConta, "Voltar ao menu principal"));
				
				if(respostasOperacoesContas.equals(RespostasOperacoesContas.VOLTAR))
					continue;
				OperacoesConta.menu(respostasOperacoesContas);
			}
			else if(respostaOpcaoInicial.equals(RespostasOpcoesIniciais.VEICULO)) {
				RespostasOperacoesEscolhaVeiculos respostasOperacoesEscolhaVeiculos = RespostasOperacoesEscolhaVeiculos.getById
						(menu(textosDeOperacoesVeiculos, null));
				
				RespostasOperacoesGenericas respostaOperacao = RespostasOperacoesGenericas.getById
						(menu(textosDeOperacoesGenericos, "Voltar ao menu principal")); 
				
				if(respostaOperacao.equals(RespostasOperacoesGenericas.VOLTAR))
					continue;
				else if(respostasOperacoesEscolhaVeiculos.equals(RespostasOperacoesEscolhaVeiculos.CARRO))
					OperacoesVeiculoCarro.menu(respostaOperacao);
				else
					OperacoesVeiculoCaminhao.menu(respostaOperacao);
			}
			else if(respostaOpcaoInicial.equals(RespostasOpcoesIniciais.PATIO)) {
				RespostasOperacoesGenericas respostaOperacao = RespostasOperacoesGenericas.getById
						(menu(textosDeOperacoesPatio, "Voltar ao menu principal"));
				
				if(respostaOperacao.equals(RespostasOperacoesGenericas.VOLTAR))
					continue;
				 OperacoesPatio.menu(respostaOperacao);
			}
			else {
				RespostasOperacoesGenericas respostaOperacao = RespostasOperacoesGenericas.getById
						(menu(textosDeOperacoesGenericos, "Voltar ao menu principal"));
				
				if(respostaOperacao.equals(RespostasOperacoesGenericas.VOLTAR))
					continue;
				OperacoesCliente.menu(respostaOperacao);
			}
		}
	}
	
	public static int menu(String[] textos, String callbackMensagem) {
		int minimoValorPossivel = 1;
		System.out.println(Mensagens.getMensagem("Considere as op��es abaixo: ", 0, 2));
		
		for(int i=0; i<textos.length; i++)
			System.out.println(Mensagens.getMensagem((i+1) + "-" + textos[i], 1));
		
		if(Objects.nonNull(callbackMensagem)) {
			System.out.println(Mensagens.getMensagem("0-" + callbackMensagem, 1));
			minimoValorPossivel = 0;
		}
		
		System.out.print(Mensagens.getMensagem("Insira a op��o desejada: ", 2));
		
		try {
			int resposta = scanner.nextInt();
			scanner.nextLine();	
			
			if(resposta > textos.length || resposta < minimoValorPossivel) {
				throw new IllegalArgumentException("Valor n�o dispon�vel. Tente novamente...");
			}
			
			return resposta;
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return menu(textos, callbackMensagem);
		}
		catch (Exception e) {
			System.out.println("Erro: Insira um valor num�rico correspondente ao desejado");
			return menu(textos, callbackMensagem);
		}
	}

}
