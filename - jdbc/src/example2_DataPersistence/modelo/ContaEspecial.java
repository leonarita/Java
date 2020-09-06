package example2_DataPersistence.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import example2_DataPersistence.modelo.repositorio.ContaEspecialDAO;

public class ContaEspecial extends ContaComum {

	private double limiteConta;

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
	
	public void abrirConta(int id) {
		ContaEspecialDAO ceDao = new ContaEspecialDAO();
		ceDao.criarContaEspecial(this, id);
		ceDao.fecharConexao();
	}
	
}
