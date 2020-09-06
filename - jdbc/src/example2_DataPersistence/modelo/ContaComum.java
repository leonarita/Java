package example2_DataPersistence.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import example2_DataPersistence.modelo.repositorio.ContaComumDAO;

public class ContaComum {
	
	protected long numeroConta;
	protected LocalDate aberturaConta;
	protected LocalDate fechamentoConta;
	protected int situacaoConta;
	protected int senhaConta;
	protected double saldoConta;
	protected ArrayList<Movimento> movimentosConta;
	
	public ContaComum(LocalDate aberturaConta, LocalDate fechamentoConta, int situacaoConta,
			int senhaConta, double saldoConta, ArrayList<Movimento> movimentosConta) {

		this.aberturaConta = aberturaConta;
		this.fechamentoConta = fechamentoConta;
		
		if(situacaoConta != 0)
			this.situacaoConta = situacaoConta;
		else
			this.situacaoConta = 1;
		
		this.senhaConta = senhaConta;
		this.saldoConta = saldoConta;
		this.movimentosConta = movimentosConta;
	}

	public ContaComum() {
		movimentosConta = new ArrayList<Movimento>();
	}
	
	public long getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(long numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public LocalDate getAberturaConta() {
		return aberturaConta;
	}
	
	public void setAberturaConta(LocalDate aberturaConta) {
		this.aberturaConta = aberturaConta;
	}
	
	public LocalDate getFechamentoConta() {
		return fechamentoConta;
	}
	
	public void setFechamentoConta(LocalDate fechamentoConta) {
		this.fechamentoConta = fechamentoConta;
	}
	
	public int getSituacaoConta() {
		return situacaoConta;
	}
	
	public void setSituacaoConta(int situacaoConta) {
		this.situacaoConta = situacaoConta;
	}
	
	public int getSenhaConta() {
		return senhaConta;
	}
	
	public void setSenhaConta(int senhaConta) {
		this.senhaConta = senhaConta;
	}
	
	public double getSaldoConta() {
		return saldoConta;
	}
	
	public void setSaldoConta(double saldoConta) {
		this.saldoConta = saldoConta;
	}

	public ArrayList<Movimento> getMovimentosConta() {
		return movimentosConta;
	}

	public void setMovimentosConta(ArrayList<Movimento> movimentosConta) {
		this.movimentosConta = movimentosConta;
	}
	
	public void abrirConta(int id) {
		ContaComumDAO ccDao = new ContaComumDAO();
		ccDao.criarContaComum(this, id);
		ccDao.fecharConexao();
	}
}
