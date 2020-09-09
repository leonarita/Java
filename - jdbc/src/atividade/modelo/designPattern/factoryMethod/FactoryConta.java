package atividade.modelo.designPattern.factoryMethod;

import java.time.LocalDate;
import java.util.ArrayList;

import atividade.modelo.ContaComum;
import atividade.modelo.ContaEspecial;
import atividade.modelo.ContaPoupanca;
import atividade.modelo.Movimento;

public class FactoryConta {
	
	public static ContaComum criarConta(int op, LocalDate aberturaConta, LocalDate fechamentoConta, int situacaoConta,
			int senhaConta, double saldoConta, ArrayList<Movimento> movimentosConta) {
		
		if (op == 1)
			return new ContaComum(aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta, movimentosConta);
		else if (op == 2)
			return new ContaEspecial(aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta, movimentosConta);
		else if (op == 3)
			return new ContaPoupanca(aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta, movimentosConta);
		return null;
	}

	public static ContaComum criarConta(int op) {
		if (op == 1)
			return new ContaComum();
		else if (op == 2)
			return new ContaEspecial();
		else if (op == 3)
			return new ContaPoupanca();
		return null;
	}
}
