package atividade.designPattern.mediator;

import atividade.modelo.ContaComum;

public class CriarContaMediator {

	public static int criarConta(ContaComum contaComum, int idUsuario) {
		int idConta = ContaComum.getCcDao().criarContaComum(contaComum, idUsuario);
		
		if(idConta != 0) {
			ContaComum.getCcDao().criarRelacaoPessoaConta(idConta, idUsuario);
		}
		
		return idConta;
	}
}
