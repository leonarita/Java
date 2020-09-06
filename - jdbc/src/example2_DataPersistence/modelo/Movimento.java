package example2_DataPersistence.modelo;

import java.time.LocalDateTime;

import example2_DataPersistence.modelo.repositorio.ContaComumDAO;
import example2_DataPersistence.modelo.repositorio.MovimentoDAO;

public class Movimento {
	
	private int idMovimento;
	private int tipoMovimento;
	private LocalDateTime dataHoraMovimento;
	private double valorMovimento;
	private ContaComum contaMovimento;
	
	public int getIdMovimento() {
		return idMovimento;
	}
	
	public void setIdMovimento(int id) {
		this.idMovimento = id;
	}
	
	public int getTipoMovimento() {
		return tipoMovimento;
	}
	
	public void setTipoMovimento(int tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
	public LocalDateTime getDataHoraMovimento() {
		return dataHoraMovimento;
	}
	
	public void setDataHoraMovimento(LocalDateTime dataHoraMovimento) {
		this.dataHoraMovimento = dataHoraMovimento;
	}
	
	public double getValorMovimento() {
		return valorMovimento;
	}
	
	public void setValorMovimento(double valorMovimento) {
		this.valorMovimento = valorMovimento;
	}
	
	public ContaComum getContaMovimento() {
		return contaMovimento;
	}
	
	public void setContaMovimento(ContaComum contaMovimento) {
		this.contaMovimento = contaMovimento;
	}
	
	// Método interno auxiliar. Optei por implementá-lo para que o método registrarMovimento não ficasse tão extenso.
	private boolean efetivarMovimento() {
		// true=Sucesso e false=Falha
		boolean resultado = false; 
		
		if (this.contaMovimento != null) {
			
			ContaComumDAO ccDAO = new ContaComumDAO();
			
			// Garante que eu tenho em this.contaMovimento os dados mais atuais da conta
			this.contaMovimento = ccDAO.obterContaComumPorNumeroContaESenha(this.contaMovimento.getNumeroConta(), this.contaMovimento.getSenhaConta());
			
			// Se deu certo a consulta anterior
			if (this.contaMovimento != null) {
				
				// Depósito
				if (this.tipoMovimento == 1) {
					
					this.contaMovimento.setSaldoConta(this.contaMovimento.getSaldoConta() + this.valorMovimento);
					ccDAO.atualizarContaComum(this.contaMovimento);
					resultado = true;
					
					System.out.println("Depósito efetuado com sucesso!");
				} 
				
				// Saque
				else if (this.tipoMovimento == 2) {
					
					if (this.contaMovimento.getSaldoConta() >= this.valorMovimento) {
						
						// Só é possível sacar se existir saldo suficiente
						this.contaMovimento.setSaldoConta(this.contaMovimento.getSaldoConta() - this.valorMovimento);
						ccDAO.atualizarContaComum(this.contaMovimento);
						resultado = true;
						
						System.out.println("Saque efetuado com sucesso!");
					} 
					else {
						System.out.println("Saque não pôde ser efetivado. Sem saldo!");
					}
				}
			}
			
			ccDAO.fecharConexao();
		}
		
		return resultado;
	}
	
	public int registrarMovimento(int tipoMovimento, double valorMovimento) {
		
		// 1=Sucesso e 0=Fracasso
		int resultado = 0; 
		
		// Somente registra se existir conta vinculada
		if (this.contaMovimento != null) {
			
			this.tipoMovimento = tipoMovimento;
			this.dataHoraMovimento = LocalDateTime.now();
			this.valorMovimento = valorMovimento;
			
			// Somente registra se o movimento for efetivado na conta
			if (this.efetivarMovimento()) {
				
				MovimentoDAO mDAO = new MovimentoDAO();
				
				// Persiste este objeto, registrando o movimento no BD.
				this.idMovimento = mDAO.criarMovimento(this); 
				
				// Sucesso na inserção
				if (this.idMovimento > 0) {
					resultado = 1;
				}
				
				mDAO.fecharConexao();
			}
		}
		
		return resultado;
	}
}