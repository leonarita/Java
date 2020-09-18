package atividade.modelo.designPattern.strategy;

import atividade.modelo.ContaComum;
import atividade.modelo.interfaces.ContaInterface;

public class AcessarContaStrategy {

	public static ContaComum acessarConta(ContaInterface c, long numeroConta, long senhaConta, long idPessoa) {
		return c.acessarConta(numeroConta, senhaConta, idPessoa);
	}
}
