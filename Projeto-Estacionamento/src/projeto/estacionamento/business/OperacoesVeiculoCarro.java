package projeto.estacionamento.business;

import projeto.estacionamento.Main;
import projeto.estacionamento.StorageData;
import projeto.estacionamento.enumerations.RespostasOperacoesEscolhaVeiculos;
import projeto.estacionamento.enumerations.RespostasOperacoesGenericas;
import projeto.estacionamento.models.Carro;
import projeto.estacionamento.utils.Mensagens;

public class OperacoesVeiculoCarro {
	
	public static void menu(RespostasOperacoesGenericas resposta) {
		switch(resposta) {
			case CADASTRO:
				cadastrarVeiculo();
				break;
			case ALTERACAO:
				atualizarVeiculo();
				break;
			case EXCLUSAO:
				excluirVeiculo();
				break;
			case CONSULTA:
				buscarVeiculo();
				break;
			case RELATORIO:
				StorageData.listarVeiculos(RespostasOperacoesEscolhaVeiculos.CARRO);
				break;
			default:
				break;		
		}
	}
	
	private static void cadastrarVeiculo() {
		System.out.print(Mensagens.getMensagem("Insira a marca: ", 2));
		String marca = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira o modelo: ", 2));
		String modelo = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira a chassi: ", 2));
		String chassi = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira a placa: ", 2));
		String placa = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira o ano de fabricação: ", 2));
		int anoFabricacao = Main.scanner.nextInt();
		
		System.out.print(Mensagens.getMensagem("Insira o ano do modelo: ", 2));
		int anoModelo = Main.scanner.nextInt();
		
		System.out.print(Mensagens.getMensagem("Insira o número de portas: ", 2));
		int numeroPortas = Main.scanner.nextInt();
		
		System.out.print(Mensagens.getMensagem("Insira a quantidade de passageiros: ", 2));
		int qtdPassageiros = Main.scanner.nextInt();

		Main.scanner.nextLine();
		StorageData.inserirVeiculo(new Carro(marca, modelo, anoFabricacao, anoModelo, chassi, placa, numeroPortas, qtdPassageiros));
	}
	
	private static void atualizarVeiculo() {
		System.out.print(Mensagens.getMensagem("Insira a marca: ", 2));
		Carro carro = (Carro) StorageData.encontrarVeiculo(Main.scanner.nextLine(), RespostasOperacoesEscolhaVeiculos.CARRO);
		
		System.out.print(Mensagens.getMensagem("Insira o modelo: ", 2));
		carro.setModelo(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira a chassi: ", 2));
		carro.setChassi(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira a placa: ", 2));
		carro.setPlaca(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o ano de fabricação: ", 2));
		carro.setAnoFabricacao(Main.scanner.nextInt());
		
		System.out.print(Mensagens.getMensagem("Insira o ano do modelo: ", 2));
		carro.setAnoModelo(Main.scanner.nextInt());
		
		System.out.print(Mensagens.getMensagem("Insira o número de portas: ", 2));
		carro.setNumeroPortas(Main.scanner.nextInt());
		
		System.out.print(Mensagens.getMensagem("Insira a quantidade de passageiros: ", 2));
		carro.setQtdPassageiros(Main.scanner.nextInt());
		
		Main.scanner.nextLine();
	}
	
	private static void buscarVeiculo() {
		System.out.print(Mensagens.getMensagem("Insira a placa: ", 2));
		System.out.print(Mensagens.getMensagem(StorageData.encontrarVeiculo(Main.scanner.nextLine(), RespostasOperacoesEscolhaVeiculos.CARRO).toString(), 4));
	}
	
	private static void excluirVeiculo() {
		System.out.print(Mensagens.getMensagem("Insira a placa: ", 2));
		StorageData.excluirVeiculo(Main.scanner.nextLine(), RespostasOperacoesEscolhaVeiculos.CARRO);
	}

}
