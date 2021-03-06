package atividade.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import atividade.modelo.repositorio.ContaEspecialDAO;

public class ContaEspecial extends ContaComum {

	private double limiteConta;
	
	private static ContaEspecialDAO ceDao = new ContaEspecialDAO();
	
	public ContaEspecial() { }

	public ContaEspecial(LocalDate aberturaConta, LocalDate fechamentoConta, int situacaoConta,
			int senhaConta, BigDecimal saldoConta, ArrayList<Movimento> movimentosConta) {
	
		super(aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta, movimentosConta);

	}

	public double getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(double limiteConta) {
		this.limiteConta = limiteConta;
	}
	
	public static ContaEspecialDAO getCeDao() {
		return ceDao;
	}

	@Override
	public String toString() {
		return "ContaComum [numeroConta=" + numeroConta + ", aberturaConta=" + aberturaConta + ", fechamentoConta="
		+ fechamentoConta + ", situacaoConta=" + situacaoConta + ", senhaConta=******, saldoConta="
		+ saldoConta + ", movimentosConta=" + movimentosConta + ", limiteConta=" + limiteConta + "]";
	}

	public int abrirConta(int id) {
		return ceDao.criarContaEspecial(this, id);
	}
	
	public ContaEspecial acessarConta(long numeroConta, long senhaConta, long idPessoa) {
		ContaEspecial ce = ceDao.obterContaEspecialPorNumeroContaESenha(numeroConta, senhaConta);
		
		int response = ContaComum.getCcDao().verificarContaDoUsuario(ce.getNumeroConta(), idPessoa);
		
		if (response == 1)
			return ce;
		else
			return null;
	}
	
}
