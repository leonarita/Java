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

		if(validarSenha(senhaConta) == 1) {
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
		else
			throw new IllegalArgumentException("\n\n\tSenha deve possuir 6 dígitos!");
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
	
	@Override
	public String toString() {
		return "ContaComum [numeroConta=" + numeroConta + ", aberturaConta=" + aberturaConta + ", fechamentoConta="
				+ fechamentoConta + ", situacaoConta=" + situacaoConta + ", senhaConta=" + senhaConta + ", saldoConta="
				+ saldoConta + ", movimentosConta=" + movimentosConta + "]";
	}

	public int validarSenha(int senha) {
		if(senha < 99999 || senha > 999999)
			return 0;
		return 1;
	}
	
	public void abrirConta(int id) {
		ContaComumDAO ccDao = new ContaComumDAO();
		ccDao.criarContaComum(this, id);
		ccDao.fecharConexao();
	}
	
	public static ContaComum acessarConta(long numeroConta, long senhaConta) {
		ContaComumDAO ccDao = new ContaComumDAO();
		ContaComum cc = ccDao.obterContaComumPorNumeroContaESenha(numeroConta, senhaConta);
		ccDao.fecharConexao();
		return cc;
	}
	
	public int encerrarConta() {
		ContaComumDAO ccDAO = new ContaComumDAO();
		int response = ccDAO.atualizarContaComum(this);
		ccDAO.fecharConexao();
		return response;
	}
}
