package atividade_DataPersistence.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import atividade_DataPersistence.modelo.repositorio.ContaComumDAO;
import atividade_DataPersistence.modelo.repositorio.MovimentoDAO;

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
		ContaComumDAO ccDao = new ContaComumDAO();
		ccDao.criarContaComum(this, id);
		ccDao.fecharConexao();
	}
	
	public static ContaComum acessarConta(long numeroConta, long senhaConta, long idPessoa) {
		ContaComumDAO ccDao = new ContaComumDAO();
		ContaComum cc = ccDao.obterContaComumPorNumeroContaESenha(numeroConta, senhaConta);
		int response = ccDao.verificarContaDoUsuario(cc.getNumeroConta(), idPessoa);
		ccDao.fecharConexao();
		
		if (response == 1)
			return cc;
		else
			return null;
	}
	
	public int encerrarConta() {
		ContaComumDAO ccDAO = new ContaComumDAO();
		int response = ccDAO.atualizarContaComum(this);
		ccDAO.fecharConexao();
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
			System.out.println("\n\nConta recuperada: numero = " + this.getNumeroConta() + ", saldo = "
					+ this.emitirSaldo());
			
			MovimentoDAO mvDao = new MovimentoDAO();
			this.setMovimentosConta(mvDao.obterMovimentosPorNumeroConta(this.getNumeroConta()));
			mvDao.fecharConexao();
			
			for (Movimento mv : this.getMovimentosConta()) {
				
				if (
						(dateTimeInicio != null && dateTimeFim != null
						&& mv.getDataHoraMovimento().toLocalDate().isAfter(dateTimeInicio.toLocalDate())
						&& mv.getDataHoraMovimento().toLocalDate().isBefore(dateTimeFim.toLocalDate())) 
						
						|| 

						(dateTimeInicio != null && dateTimeFim == null && 
						mv.getDataHoraMovimento().toLocalDate().equals(dateTimeInicio.toLocalDate()))
						
						||
						
						(dateTimeInicio == null && dateTimeFim == null)
					)
					
					System.out.println("MV ID " + mv.getIdMovimento() + ", tipo = " + 
					mv.getTipoMovimento() + ", valor = " + mv.getValorMovimento());
				
			}
		}
	}
}
