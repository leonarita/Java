package projeto.estacionamento.business;

import java.util.Objects;

import projeto.estacionamento.Main;
import projeto.estacionamento.StorageData;
import projeto.estacionamento.enumerations.RespostasOperacoesGenericas;
import projeto.estacionamento.models.Patio;
import projeto.estacionamento.utils.Mensagens;

public class OperacoesPatio {
	
	public static void menu(RespostasOperacoesGenericas resposta) {
		switch(resposta) {
			case CADASTRO:
				inserirPatio();
				break;
			case ALTERACAO:
				atualizarPatio();
				break;
			case EXCLUSAO:
				excluirPatio();
				break;
			case CONSULTA:
				buscarPatio();
				break;
			case RELATORIO:
				StorageData.listarPatios();
				break;
			case LOTACAO:
				visualizarLotacao();
				break;
			default:
				break;		
		}
	}
	
	private static void inserirPatio() {
		
		System.out.print(Mensagens.getMensagem("Insira o nome: ", 2));
		String nome = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira o logradouro: ", 2));
		String logradouro = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira o número: ", 2));
		String numero = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira o bairro: ", 2));
		String bairro = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira o município: ", 2));
		String municipio = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira o estado: ", 2));
		String estado = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira o CEP: ", 2));
		String cep = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira o telefone: ", 2));
		String telefone = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira a capacidade de veículos: ", 2));
		int capacidadeVeiculos = Main.scanner.nextInt();
		
		System.out.print(Mensagens.getMensagem("Insira a lotação: ", 2));
		int lotacao = Main.scanner.nextInt();
		
		System.out.print(Mensagens.getMensagem("Insira a diária de carros: ", 2));
		float diariaCarro = Main.scanner.nextFloat();
		
		System.out.print(Mensagens.getMensagem("Insira a diária de caminhões: ", 2));
		float diariaCaminhao = Main.scanner.nextFloat();
		
		Main.scanner.nextLine();
		StorageData.inserirPatio(new Patio(nome, logradouro, numero, bairro, municipio, estado, cep, telefone, capacidadeVeiculos, lotacao, diariaCarro, diariaCaminhao));
	}
	
	private static void atualizarPatio() {
		System.out.print(Mensagens.getMensagem("Insira o nome: ", 2));
		Patio patio = StorageData.encontrarPatio(Main.scanner.nextLine());
		
		if(Objects.isNull(patio))
			return;
		
		System.out.print(Mensagens.getMensagem("Insira o logradouro: ", 2));
		patio.setLogradouro(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o número: ", 2));
		patio.setNumero(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o bairro: ", 2));
		patio.setBairro(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o município: ", 2));
		patio.setMunicipio(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o estado: ", 2));
		patio.setEstado(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o CEP: ", 2));
		patio.setCep(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o telefone: ", 2));
		patio.setTelefone(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira a capacidade de veículos: ", 2));
		patio.setCapacidadeVeiculos(Main.scanner.nextInt());
		
		System.out.print(Mensagens.getMensagem("Insira a lotação: ", 2));
		patio.setLotacao(Main.scanner.nextInt());
		
		System.out.print(Mensagens.getMensagem("Insira a diária de carros: ", 2));
		patio.setDiariaCarro(Main.scanner.nextFloat());
		
		System.out.print(Mensagens.getMensagem("Insira a diária de caminhões: ", 2));
		patio.setDiariaCaminhao(Main.scanner.nextFloat());
		
		Main.scanner.nextLine();
	}
	
	private static void excluirPatio() {
		System.out.print(Mensagens.getMensagem("Insira o nome do patio: ", 2));
		StorageData.excluirPatio(Main.scanner.nextLine());
	}
	
	private static void buscarPatio() {
		System.out.print(Mensagens.getMensagem("Insira o nome do patio: ", 2));
		System.out.print(Mensagens.getMensagem(StorageData.encontrarPatio(Main.scanner.nextLine()).toString(), 4));
	}
	
	private static void visualizarLotacao() {
		System.out.print(Mensagens.getMensagem("Insira o nome do patio: ", 2));
		StorageData.calcularLotacao(Main.scanner.nextLine());
	}

}
