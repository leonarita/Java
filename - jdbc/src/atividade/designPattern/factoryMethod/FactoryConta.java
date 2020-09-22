package atividade.designPattern.factoryMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import atividade.modelo.ContaComum;
import atividade.modelo.ContaEspecial;
import atividade.modelo.ContaPoupanca;
import atividade.modelo.Movimento;
import atividade.modelo.enumeration.SituacaoContaEnum;

public class FactoryConta {
	
	public static ContaComum criarConta(int op, LocalDate aberturaConta, LocalDate fechamentoConta, int situacaoConta,
			int senhaConta, BigDecimal saldoConta, ArrayList<Movimento> movimentosConta) {
		
		if (op == SituacaoContaEnum.CONTACOMUM.getSituacao())
			return new ContaComum(aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta, movimentosConta);
		else if (op == SituacaoContaEnum.CONTAESPECIAL.getSituacao())
			return new ContaEspecial(aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta, movimentosConta);
		else if (op == SituacaoContaEnum.CONTAPOUPANCA.getSituacao())
			return new ContaPoupanca(aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta, movimentosConta);
		return null;
	}

	public static ContaComum criarConta(int op) {
		if (op == SituacaoContaEnum.CONTACOMUM.getSituacao())
			return new ContaComum();
		else if (op == SituacaoContaEnum.CONTAESPECIAL.getSituacao())
			return new ContaEspecial();
		else if (op == SituacaoContaEnum.CONTAPOUPANCA.getSituacao())
			return new ContaPoupanca();
		return null;
	}
}
