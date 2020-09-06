package example2_DataPersistence.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import example2_DataPersistence.modelo.repositorio.ContaPoupancaDAO;

public class ContaPoupanca extends ContaComum {

	private LocalDate aniversarioConta;
	
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
	
	public void abrirConta(int id) {
		ContaPoupancaDAO cpDao = new ContaPoupancaDAO();
		cpDao.criarContaPoupanca(this, id);
		cpDao.fecharConexao();
	}
	
}
