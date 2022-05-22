package projeto.estacionamento.business;

import java.util.Objects;

import projeto.estacionamento.Main;
import projeto.estacionamento.StorageData;
import projeto.estacionamento.enumerations.RespostasOperacoesGenericas;
import projeto.estacionamento.models.Cliente;
import projeto.estacionamento.utils.Mensagens;

public class OperacoesCliente {
	
	public static void menu(RespostasOperacoesGenericas resposta) {
		switch(resposta) {
			case CADASTRO:
				cadastrarCliente();
				break;
			case ALTERACAO:
				alterarCliente();
				break;
			case EXCLUSAO:
				excluirCliente();
				break;
			case CONSULTA:
				buscarCliente();
				break;
			case RELATORIO:
				StorageData.listarClientes();
				break;
			default:
				break;		
		}
	}
	
	private static void cadastrarCliente() {
		System.out.print(Mensagens.getMensagem("Insira o nome: ", 2));
		String nome = Main.scanner.nextLine();
		
		System.out.print(Mensagens.getMensagem("Insira o cpf: ", 2));
		String cpf = Main.scanner.nextLine();
		
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
		
		System.out.print(Mensagens.getMensagem("Insira o sexo: ", 2));
		String sexo = Main.scanner.nextLine();
		
		StorageData.inserirCliente(new Cliente(nome, cpf, logradouro, numero, bairro, municipio, estado, cep, telefone, sexo));
	}
	
	private static void alterarCliente() {
		System.out.print(Mensagens.getMensagem("Insira o cpf: ", 2));
		Cliente cliente = StorageData.encontrarCliente(Main.scanner.nextLine());
		
		if(Objects.isNull(cliente))
			return;
		
		System.out.print(Mensagens.getMensagem("Insira o logradouro: ", 2));
		cliente.setLogradouro(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o número: ", 2));
		cliente.setNumero(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o bairro: ", 2));
		cliente.setBairro(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o município: ", 2));
		cliente.setMunicipio(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o estado: ", 2));
		cliente.setEstado(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o CEP: ", 2));
		cliente.setCep(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o telefone: ", 2));
		cliente.setTelefone(Main.scanner.nextLine());
		
		System.out.print(Mensagens.getMensagem("Insira o sexo: ", 2));
		cliente.setSexo(Main.scanner.nextLine());
	}
	
	private static void excluirCliente() {
		System.out.print(Mensagens.getMensagem("Insira o cpf: ", 2));
		StorageData.excluirCliente(Main.scanner.nextLine());
	}
	
	private static void buscarCliente() {
		System.out.print(Mensagens.getMensagem("Insira o cpf: ", 2));
		System.out.print(Mensagens.getMensagem(StorageData.encontrarCliente(Main.scanner.nextLine()).toString(), 4));
	}

}
