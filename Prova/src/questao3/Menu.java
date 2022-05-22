package questao3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import questao3.models.ChamadaOriginaria;
import questao3.models.ChamadaRecebida;
import questao3.models.Cliente;

public class Menu {
	
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	
	public static void adicionarCliente() {
		System.out.print("\t\tInsira o número de telefone do cliente: ");
		String telefone = Main.scanner.nextLine();
		
		clientes.add(new Cliente(telefone));
		System.out.print("\t\t\tCliente adicionado com sucesso!");
	}
	
	public static void adicionarChamadaRecebida() {
		Cliente cliente = encontrarCliente();
		
		if(Objects.isNull(cliente)) {
			System.out.print("\t\t\tCliente não encontrado!");
			return;
		}
		
		System.out.print("\t\tInsira a data da chamada: ");
		String dataChamada = Main.scanner.nextLine();
		
		System.out.print("\t\tInsira a hora da chamada: ");
		String horaChamada = Main.scanner.nextLine();
		
		System.out.print("\t\tInsira a duração da chamada: ");
		String duracao = Main.scanner.nextLine();
		
		System.out.print("\t\tInsira o telefone de origem: ");
		String telefoneOrigem = Main.scanner.nextLine();
		
		System.out.print("\t\tInsira o valor da chamada: ");
		String valorChamada = Main.scanner.nextLine();
		
		cliente.adicionarChamadaRecebida(new ChamadaRecebida(dataChamada, horaChamada, duracao, telefoneOrigem, valorChamada));
		System.out.print("\t\t\tChamada recebida adicionada com sucesso!");
	}
	
	public static void adicionarChamadaOriginaria() {
		Cliente cliente = encontrarCliente();
		
		if(Objects.isNull(cliente)) {
			System.out.print("\t\t\tCliente não encontrado!");
			return;
		}
		
		System.out.print("\t\tInsira a data da chamada: ");
		String dataChamada = Main.scanner.nextLine();
		
		System.out.print("\t\tInsira a hora da chamada: ");
		String horaChamada = Main.scanner.nextLine();
		
		System.out.print("\t\tInsira a duração da chamada: ");
		String duracao = Main.scanner.nextLine();
		
		System.out.print("\t\tInsira o telefone de destino: ");
		String telefoneDestino = Main.scanner.nextLine();
		
		cliente.adicionarChamadaOriginaria(new ChamadaOriginaria(dataChamada, horaChamada, duracao, telefoneDestino));
	}
	
	public static void exibirDadosCliente() {
		Cliente cliente = encontrarCliente();
		
		if(Objects.isNull(cliente)) {
			System.out.print("\t\t\tCliente não encontrado!");
			return;
		}
		
		System.out.println("\n\n==========");
		System.out.println("\tCliente cujo Número é " + cliente.getNumeroTelefone());
		
		System.out.println("\n\t\tChamadas Originarias");
		for(ChamadaOriginaria chamadaOriginaria : cliente.getChamadasOriginarias())
			System.out.println("\t\t\tData de chamada: " + chamadaOriginaria.getDataChamada() 
					+ ", hora da chamada: " + chamadaOriginaria.getDataChamada() + ", duração: " + chamadaOriginaria.getDuracao()
					+ ", telefone de destino: " + chamadaOriginaria.getTelefoneDestino());
		
		System.out.println("\n\t\tChamadas Recebidas");
		for(ChamadaRecebida chamadaRecebida : cliente.getChamadasRecebidas())
			System.out.println("\t\t\tData de chamada: " + chamadaRecebida.getDataChamada() 
					+ ", hora da chamada: " + chamadaRecebida.getDataChamada() + ", duração: " + chamadaRecebida.getDuracao()
					+ ", telefone de origem: " + chamadaRecebida.getTelefoneOrigem() + ", Valor da chamada: " + chamadaRecebida.getValorChamada());
		
		System.out.println("==========");
	}
	
	private static Cliente encontrarCliente() {
		System.out.print("\t\tInsira o telefone: ");
		String telefone = Main.scanner.nextLine();
		
		for(Cliente cliente : clientes) {
			if(cliente.getNumeroTelefone().equals(telefone)) {
				return cliente;
			}
		}
		return null;
	}

}
