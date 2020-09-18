package atividade.modelo.designPattern.strategy;

import atividade.modelo.interfaces.PessoaInterface;

public class EncontrarCredencialStrategy {

	public static int encontrarCredencial(PessoaInterface p, String credencial) {
		return p.buscarIdPelaCredencial(credencial);
	}
}
