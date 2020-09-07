package example2_DataPersistence.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import example2_DataPersistence.modelo.repositorio.ContaComumDAO;
import example2_DataPersistence.modelo.repositorio.ContaPoupancaDAO;

public class ContaPoupanca extends ContaComum {

	private LocalDate aniversarioConta;
	
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
	
	@Override
	public String toString() {
		return "ContaPoupanca [aniversarioConta=" + aniversarioConta + ", numeroConta=" + numeroConta
				+ ", aberturaConta=" + aberturaConta + ", fechamentoConta=" + fechamentoConta + ", situacaoConta="
				+ situacaoConta + ", senhaConta=" + senhaConta + ", saldoConta=" + saldoConta + ", movimentosConta="
				+ movimentosConta + "]";
	}

	public void abrirConta(int id) {
		ContaPoupancaDAO cpDao = new ContaPoupancaDAO();
		cpDao.criarContaPoupanca(this, id);
		cpDao.fecharConexao();
	}
	
	public static ContaPoupanca acessarConta(long numeroConta, long senhaConta, long idPessoa) {
		ContaPoupancaDAO cpDao = new ContaPoupancaDAO();
		ContaPoupanca cp = cpDao.obterContaPoupancaPorNumeroContaESenha(numeroConta, senhaConta);
		cpDao.fecharConexao();
		
		ContaComumDAO ccDao = new ContaComumDAO();
		int response = ccDao.verificarContaDoUsuario(cp.getNumeroConta(), idPessoa);
		ccDao.fecharConexao();
		
		if (response == 1)
			return cp;
		else
			return null;
	}
	
}
