package atividade.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import atividade.modelo.repositorio.ContaPoupancaDAO;

public class ContaPoupanca extends ContaComum {

	private LocalDate aniversarioConta;
	
	private static ContaPoupancaDAO cpDao = new ContaPoupancaDAO();
	
	public ContaPoupanca() {
		
	}
	
	public ContaPoupanca(LocalDate aberturaConta, LocalDate fechamentoConta, int situacaoConta,
			int senhaConta, double saldoConta, ArrayList<Movimento> movimentosConta) {

		super(aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta, movimentosConta);

	}

	public LocalDate getAniversarioConta() {
		return aniversarioConta;
	}

	public void setAniversarioConta(LocalDate aniversarioConta) {
		this.aniversarioConta = aniversarioConta;
	}
	
	public static ContaPoupancaDAO getCpDao() {
		return cpDao;
	}

	@Override
	public String toString() {
		return "ContaPoupanca [aniversarioConta=" + aniversarioConta + ", numeroConta=" + numeroConta
				+ ", aberturaConta=" + aberturaConta + ", fechamentoConta=" + fechamentoConta + ", situacaoConta="
				+ situacaoConta + ", senhaConta=" + senhaConta + ", saldoConta=" + saldoConta + ", movimentosConta="
				+ movimentosConta + "]";
	}

	public void abrirConta(int id) {
		cpDao.criarContaPoupanca(this, id);
	}
	
	public ContaPoupanca acessarConta(long numeroConta, long senhaConta, long idPessoa) {
		ContaPoupanca cp = cpDao.obterContaPoupancaPorNumeroContaESenha(numeroConta, senhaConta);
		
		int response = ContaComum.getCcDao().verificarContaDoUsuario(cp.getNumeroConta(), idPessoa);
		
		if (response == 1)
			return cp;
		else
			return null;
	}
	
}
