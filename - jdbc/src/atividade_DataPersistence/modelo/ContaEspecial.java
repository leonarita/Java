package atividade_DataPersistence.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import atividade_DataPersistence.modelo.repositorio.ContaComumDAO;
import atividade_DataPersistence.modelo.repositorio.ContaEspecialDAO;

public class ContaEspecial extends ContaComum {

	private double limiteConta;
	
	public ContaEspecial() {
		
	}

	public ContaEspecial(LocalDate aberturaConta, LocalDate fechamentoConta, int situacaoConta,
			int senhaConta, double saldoConta, ArrayList<Movimento> movimentosConta) {
	
		super(aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta, movimentosConta);

	}

	public double getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(double limiteConta) {
		this.limiteConta = limiteConta;
	}
	
	@Override
	public String toString() {
		return "ContaComum [numeroConta=" + numeroConta + ", aberturaConta=" + aberturaConta + ", fechamentoConta="
		+ fechamentoConta + ", situacaoConta=" + situacaoConta + ", senhaConta=******, saldoConta="
		+ saldoConta + ", movimentosConta=" + movimentosConta + ", limiteConta=" + limiteConta + "]";
	}

	public void abrirConta(int id) {
		ContaEspecialDAO ceDao = new ContaEspecialDAO();
		ceDao.criarContaEspecial(this, id);
		ceDao.fecharConexao();
	}
	
	public static ContaEspecial acessarConta(long numeroConta, long senhaConta, long idPessoa) {
		ContaEspecialDAO ceDao = new ContaEspecialDAO();
		ContaEspecial ce = ceDao.obterContaEspecialPorNumeroContaESenha(numeroConta, senhaConta);
		ceDao.fecharConexao();
		
		ContaComumDAO ccDao = new ContaComumDAO();
		int response = ccDao.verificarContaDoUsuario(ce.getNumeroConta(), idPessoa);
		ccDao.fecharConexao();
		
		if (response == 1)
			return ce;
		else
			return null;
	}
	
}
