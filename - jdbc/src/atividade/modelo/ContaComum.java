package atividade.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import atividade.modelo.designPattern.facade.ContaComumFacade;
import atividade.modelo.enumeration.SituacaoContaEnum;
import atividade.modelo.repositorio.ContaComumDAO;

public class ContaComum {
	
	protected long numeroConta;
	protected LocalDate aberturaConta;
	protected LocalDate fechamentoConta;
	protected SituacaoContaEnum situacaoConta;
	protected int senhaConta;
	protected double saldoConta;
	protected ArrayList<Movimento> movimentosConta;
	
	private static ContaComumDAO ccDao = new ContaComumDAO();
	
	public ContaComum(LocalDate aberturaConta, LocalDate fechamentoConta, int situacaoConta,
			int senhaConta, double saldoConta, ArrayList<Movimento> movimentosConta) {

		if(validarSenha(senhaConta) == 1) {
			this.aberturaConta = aberturaConta;
			this.fechamentoConta = fechamentoConta;
			
			if(situacaoConta != 0)
				if(situacaoConta == 2)
					this.situacaoConta = SituacaoContaEnum.CONTAESPECIAL;
				else if(situacaoConta == 3)
					this.situacaoConta = SituacaoContaEnum.CONTAPOUPANCA;
			else
				this.situacaoConta = SituacaoContaEnum.CONTACOMUM;
			
			this.senhaConta = senhaConta;
			this.saldoConta = saldoConta;
			this.movimentosConta = movimentosConta;
		}
		else
			throw new IllegalArgumentException("\n\n\tSenha deve possuir 6 dígitos!");
	}

	public ContaComum() {
		movimentosConta = new ArrayList<Movimento>();
		this.situacaoConta = SituacaoContaEnum.CONTACOMUM;
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
		return situacaoConta.getSituacao();
	}
	
	public void setSituacaoConta(int situacaoConta) {
		this.situacaoConta.setSituacao(situacaoConta);
	}
	
	public int getSenhaConta() {
		return senhaConta;
	}
	
	public void setSenhaConta(int senhaConta) {
		this.senhaConta = senhaConta;
	}
	
	public double emitirSaldo() {
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
	
	public static ContaComumDAO getCcDao() {
		return ccDao;
	}

	@Override
	public String toString() {
		return "ContaComum [numeroConta=" + numeroConta + ", aberturaConta=" + aberturaConta + ", fechamentoConta="
				+ fechamentoConta + ", situacaoConta=" + situacaoConta + ", senhaConta=******, saldoConta="
				+ saldoConta + ", movimentosConta=" + movimentosConta + "]";
	}

	public int validarSenha(int senha) {
		if(senha < 99999 || senha > 999999)
			return 0;
		return 1;
	}
	
	public void abrirConta(int id) {
		ccDao.criarContaComum(this, id);
	}
	
	public static ContaComum acessarConta(long numeroConta, long senhaConta, long idPessoa) {
		ContaComum cc = ccDao.obterContaComumPorNumeroContaESenha(numeroConta, senhaConta);
		int response = ccDao.verificarContaDoUsuario(cc.getNumeroConta(), idPessoa);
		
		if (response == 1)
			return cc;
		else
			return null;
	}
	
	public int encerrarConta() {
		int response = ccDao.atualizarContaComum(this);
		return response;
	}

	public void sacarValor(double valor) {
		this.setSaldoConta(this.emitirSaldo() - valor);
	}
	
	public void depositarValor(double valor) {
		this.setSaldoConta(this.emitirSaldo() + valor);
	}
	
	public void emitirExtrato(LocalDateTime dateTimeInicio, LocalDateTime dateTimeFim) {
		
		if (this != null) {
			ContaComumFacade.emitirExtrato(dateTimeInicio, dateTimeFim, this);
		}
	}
}
