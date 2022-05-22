package projeto.estacionamento.business;

import projeto.estacionamento.Main;
import projeto.estacionamento.StorageData;
import projeto.estacionamento.enumerations.RespostasOperacoesEscolhaVeiculos;
import projeto.estacionamento.enumerations.RespostasOperacoesGenericas;
import projeto.estacionamento.models.Caminhao;
import projeto.estacionamento.utils.Mensagens;

public class OperacoesVeiculoCaminhao {
	
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
				StorageData.listarVeiculos(RespostasOperacoesEscolhaVeiculos.CAMINHAO);
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
		
		System.out.print(Mensagens.getMensagem("Insira o número de eixos: ", 2));
		int nmrEixos = Main.scanner.nextInt();
		
		System.out.print(Mensagens.getMensagem("Insira a capacidade de carga: ", 2));
		float capacidadeCarga = Main.scanner.nextFloat();
		
		Main.scanner.nextLine();
		StorageData.inserirVeiculo(new Caminhao(nmrEixos, capacidadeCarga, marca, modelo, anoFabricacao, anoModelo, chassi, placa));
	}
	
	private static void atualizarVeiculo() {
		System.out.print(Mensagens.getMensagem("Insira a marca: ", 2));
		Caminhao caminhao = (Caminhao) StorageData.encontrarVeiculo(Main.scanner.nextLine(), RespostasOperacoesEscolhaVeiculos.CAMINHAO);
		
		System.out.print(Mensagens.getMensagem("Insira o modelo: ", 2));
		caminhao.setModelo(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira a chassi: ", 2));
		caminhao.setChassi(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira a placa: ", 2));
		caminhao.setPlaca(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o ano de fabricação: ", 2));
		caminhao.setAnoFabricacao(Main.scanner.nextInt());
		
		System.out.print(Mensagens.getMensagem("Insira o ano do modelo: ", 2));
		caminhao.setAnoModelo(Main.scanner.nextInt());
		
		System.out.print(Mensagens.getMensagem("Insira o número de eixos: ", 2));
		caminhao.setNmrEixos(Main.scanner.nextInt());
		
		System.out.print(Mensagens.getMensagem("Insira a capacidade de carga: ", 2));
		caminhao.setCapacidadeCarga(Main.scanner.nextFloat());
		
		Main.scanner.nextLine();
	}
	
	private static void buscarVeiculo() {
		System.out.print(Mensagens.getMensagem("Insira a placa: ", 2));
		System.out.print(Mensagens.getMensagem(StorageData.encontrarVeiculo(Main.scanner.nextLine(), RespostasOperacoesEscolhaVeiculos.CAMINHAO).toString(), 4));
	}
	
	private static void excluirVeiculo() {
		System.out.print(Mensagens.getMensagem("Insira a placa: ", 2));
		StorageData.excluirVeiculo(Main.scanner.nextLine(), RespostasOperacoesEscolhaVeiculos.CAMINHAO);
	}

}
