package projeto.estacionamento.business;

import java.util.Objects;

import projeto.estacionamento.Main;
import projeto.estacionamento.StorageData;
import projeto.estacionamento.enumerations.RespostasOperacoesContas;
import projeto.estacionamento.models.Cliente;
import projeto.estacionamento.models.Conta;
import projeto.estacionamento.models.Patio;
import projeto.estacionamento.models.Veiculo;
import projeto.estacionamento.utils.Mensagens;

public class OperacoesConta {
	
	public static void menu(RespostasOperacoesContas resposta) {
		System.out.print(Mensagens.getMensagem("Insira o cpf do cliente: ", 2, 1));
		String cpf = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira a placa do carro: ", 2));
		String placa = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira o nome do patio: ", 2));
		String patio = Main.scanner.nextLine();
		
		switch(resposta) {
			case INCLUSAO_DIARIA:
				incluirDiaria(cpf, placa, patio);
				break;
			case EXCLUSAO_DIARIA:
				excluirDiaria(cpf, placa, patio);
				break;
			case TOTAL_PAGAR:
				calcularTotalAPagar(cpf, placa, patio);
				break;
			default: 
				return;
		}
	}
	
	private static void incluirDiaria(String cpf, String placa, String patio) {
		Conta conta = StorageData.encontrarConta(placa, patio, cpf);
		
		if(Objects.nonNull(conta)) {
			conta.adicionarDiaria();
			System.out.println(Mensagens.getMensagem("Diária inserida com sucesso!", 3));
			return;
		}
		
		criarConta(cpf, placa, patio);
	}
	
	private static void excluirDiaria(String cpf, String placa, String patio) {
		Conta conta = StorageData.encontrarConta(placa, patio, cpf);
		
		if(Objects.nonNull(conta)) {
			conta.excluirDiaria();
			System.out.println(Mensagens.getMensagem("Diária excluída com sucesso!", 3));
			return;
		}
	}
	
	private static void calcularTotalAPagar(String cpf, String placa, String patio) {
		System.out.print(Mensagens.getMensagem("Insira o mês da conta: ", 2));
		int mes = Main.scanner.nextInt();
		
		System.out.print(Mensagens.getMensagem("Insira o ano da conta: ", 2));
		int ano = Main.scanner.nextInt();
		Main.scanner.nextLine();
		
		Conta conta = StorageData.encontrarConta(placa, mes, ano, patio, cpf);
		
		if(Objects.nonNull(conta)) {
			System.out.println(Mensagens.getMensagem("Conta do veículo cuja placa é " + placa + " para esse período é: R$ " + conta.calcularTotalAPagar(), 3));
			return;
		}
	}
	
	private static void criarConta(String cpf, String placa, String patioNome) {
		Cliente cliente = StorageData.encontrarCliente(cpf);
		
		if(Objects.isNull(cliente))
			return;
		
		Veiculo veiculo = StorageData.encontrarVeiculo(placa);
		
		if(Objects.isNull(veiculo))
			return;
		
		Patio patio = StorageData.encontrarPatio(patioNome);
		
		if(Objects.isNull(patio))
			return;
		
		StorageData.inserirConta(new Conta(cliente, veiculo, patio));
	}

}
