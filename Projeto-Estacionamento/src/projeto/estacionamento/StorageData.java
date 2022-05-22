package projeto.estacionamento;

import java.time.LocalDate;
import java.util.Objects;

import projeto.estacionamento.enumerations.RespostasOperacoesEscolhaVeiculos;
import projeto.estacionamento.models.Carro;
import projeto.estacionamento.models.Cliente;
import projeto.estacionamento.models.Conta;
import projeto.estacionamento.models.Patio;
import projeto.estacionamento.models.Veiculo;
import projeto.estacionamento.utils.Mensagens;

public class StorageData {
	
	public static int storage_code_client = 0;

	private static int index_clientes = 0;
	private static int index_veiculos = 0;
	private static int index_patios = 0;
	private static int index_contas = 0;
	
	private static Cliente[] clientes = new Cliente[100];
	private static Veiculo[] veiculos = new Veiculo[100];
	private static Patio[] patios = new Patio[5];
	private static Conta[] contas = new Conta[100];
	
	// Métodos de inserção
	
	public static boolean inserirConta(Conta conta) {
		if(index_contas == 100) {
			System.out.println(Mensagens.getMensagem("Não foi possível inserir conta.", 3));
			return false;
		}
		if(calcularLotacao(conta.getPatio().getNome()) == conta.getPatio().getCapacidadeVeiculos()) {
			System.out.println(Mensagens.getMensagem("Devido ao patio cheio, não foi possivel inserir veículo.", 3));
			return false;
		}
		contas[index_contas++] = conta;
		System.out.println(Mensagens.getMensagem("Conta inserida com sucesso", 3));
		return true;
	}
	
	public static boolean inserirCliente(Cliente cliente) {
		if(index_clientes == 100) {
			System.out.println(Mensagens.getMensagem("Não foi possível inserir cliente.", 3));
			return false;
		}
		clientes[index_clientes++] = cliente;
		System.out.println(Mensagens.getMensagem("Cliente inserido com sucesso", 3));
		return true;
	}
	
	public static boolean inserirPatio(Patio patio) {
		if(index_patios == 100) {
			System.out.println(Mensagens.getMensagem("Não foi possível inserir patio.", 3));
			return false;
		}
		patios[index_patios++] = patio;
		System.out.println(Mensagens.getMensagem("Patio inserido com sucesso", 3));
		return true;
	}
	
	public static boolean inserirVeiculo(Veiculo veiculo) {
		if(index_veiculos == 100) {
			System.out.println(Mensagens.getMensagem("Não foi possível inserir veiculo.", 3));
			return false;
		}
		veiculos[index_veiculos++] = veiculo;
		System.out.println(Mensagens.getMensagem("Veiculo inserido com sucesso", 3));
		return true;
	}
	
	
	// Métodos de busca
	
	public static Conta encontrarConta(String placa, String patio, String cpf) {
		LocalDate date = LocalDate.now();
		
		for(int i=0; i<index_contas; i++) {
			if(Objects.isNull(contas[i].getVeiculo()) && Objects.nonNull(contas[i].getCliente()) && Objects.nonNull(contas[i].getPatio()) && contas[i].getVeiculo().getPlaca().equals(placa) && contas[i].getMes() == date.getMonth().getValue() && contas[i].getAno() == date.getYear() && contas[i].getPatio().getNome().equals(patio) && contas[i].getCliente().getCpf().equals(cpf)) {
				return contas[i];
			}
		}
		System.out.println(Mensagens.getMensagem("Conta não encontrada!", 3));
		return null;
	}
	
	public static Conta encontrarConta(String placa, int mes, int ano, String patio, String cpf) {
		for(int i=0; i<index_contas; i++) {
			if(Objects.isNull(contas[i].getVeiculo()) && Objects.nonNull(contas[i].getCliente()) && Objects.nonNull(contas[i].getPatio()) && contas[i].getVeiculo().getPlaca().equals(placa) && contas[i].getMes() == mes && contas[i].getAno() == ano && contas[i].getPatio().getNome().equals(patio) && contas[i].getCliente().getCpf().equals(cpf))  {
				return contas[i];
			}
		}
		System.out.println(Mensagens.getMensagem("Conta não encontrada!", 3));
		return null;
	}
	
	public static Cliente encontrarCliente(String cpf) {
		for(int i=0; i<index_clientes; i++) {
			if(clientes[i].getCpf().equals(cpf))
				return clientes[i];
		}
		System.out.println(Mensagens.getMensagem("Cliente não encontrado!", 3));
		return null;
	}
	
	public static Veiculo encontrarVeiculo(String placa) {
		for(int i=0; i<index_veiculos; i++) {
			if(veiculos[i].getPlaca().equals(placa))
				return veiculos[i];
		}
		System.out.println(Mensagens.getMensagem("Veículo não encontrado!", 3));
		return null;
	}
	
	public static Veiculo encontrarVeiculo(String placa, RespostasOperacoesEscolhaVeiculos tipoVeiculo) {
		Veiculo veiculo = null;
		
		for(int i=0; i<index_veiculos; i++) {
			if(veiculos[i].getPlaca().equals(placa)) {
				veiculo = veiculos[i];
				break;
			}
		}
		
		if(tipoVeiculo.isIstanceOf(veiculo))
			return veiculo;

		System.out.println(Mensagens.getMensagem("Veículo não encontrado!", 3));
		return null;
	}
	
	public static Patio encontrarPatio(String patio) {
		for(int i=0; i<index_patios; i++) {
			if(patios[i].getNome().equals(patio))
				return patios[i];
		}
		System.out.println(Mensagens.getMensagem("Patio não encontrado!", 3));
		return null;
	}
	
	
	// Métodos de exclusão
	
	public static boolean excluirCliente(String cpf) {
		boolean hasDeleted = false;
		
		for(int i=0; i<index_clientes; i++) {
			if(hasDeleted) {
				clientes[i-1] = clientes[i];
			}
			
			if(clientes[i].getCpf().equals(cpf)) {
				if(Mensagens.confirm()) {
					clientes[i] = null;
					hasDeleted = true;
				}
				else
					break;
			}
		}
		
		if(hasDeleted)
			index_clientes--;
		
		return hasDeleted;
	}
	
	public static boolean excluirPatio(String patio) {
		boolean hasDeleted = false;
		
		for(int i=0; i<index_patios; i++) {
			if(hasDeleted) {
				patios[i-1] = patios[i];
			}
			
			if(patios[i].getNome().equals(patio)) {
				if(Mensagens.confirm()) {
					patios[i] = null;
					hasDeleted = true;
				}
				else
					break;
			}
		}
		
		if(hasDeleted)
			index_patios--;
		
		return hasDeleted;
	}
	
	public static boolean excluirVeiculo(String placa, RespostasOperacoesEscolhaVeiculos tipoVeiculo) {
		boolean hasDeleted = false;
		
		for(int i=0; i<index_veiculos; i++) {
			if(hasDeleted) {
				veiculos[i-1] = veiculos[i];
			}
			
			if(veiculos[i].getPlaca().equals(placa) && tipoVeiculo.isIstanceOf(veiculos[i])) {
				if(Mensagens.confirm()) {
					veiculos[i] = null;
					hasDeleted = true;
				}
				else
					break;
			}
		}
		
		if(hasDeleted)
			index_veiculos--;
		
		return hasDeleted;
	}
	
	
	
	// Métodos de listagem
	
	public static void listarClientes() {
		for(int i=0; i<index_clientes; i++) {
			System.out.println(Mensagens.getMensagem(clientes[i].toString(), 3));
		}
	}
	
	public static void listarPatios() {
		for(int i=0; i<index_patios; i++) {
			System.out.println(Mensagens.getMensagem(patios[i].toString(), 3));
		}
	}
	
	public static void listarVeiculos(RespostasOperacoesEscolhaVeiculos tipoVeiculo) {
		for(int i=0; i<index_veiculos; i++) {
			if(tipoVeiculo.isIstanceOf(veiculos[i]))
				System.out.println(Mensagens.getMensagem(veiculos[i].toString(), 3));
		}
	}
	
	
	
	// Métodos adicionais
	
	public static int calcularLotacao(String nomeLotacao) {
		int total=0, totalCarros=0, totalCaminhoes=0;
		
		for(int i=0; i<index_contas; i++) {
			if(Objects.nonNull(contas[i].getPatio()) && contas[i].getPatio().getNome().equals(nomeLotacao) && contas[i].getMes() == LocalDate.now().getMonth().getValue() && contas[i].getAno() == LocalDate.now().getYear())  {
				total++;
				
				if(contas[i].getVeiculo() instanceof Carro)
					totalCarros++;
				else
					totalCaminhoes++;
			}
		}
		
		System.out.println(Mensagens.getMensagem("A lotação atual é de " + total + " veículos, sendo " + totalCarros + " carro e " + totalCaminhoes + " caminhões.", 3));
		return total;
	}
	
}
