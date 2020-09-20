package atividade.modelo.interfaces;

import atividade.modelo.ContaComum;

public interface ContaInterface {

	ContaComum acessarConta(long numeroConta, long senhaConta, long idPessoa);
	int abrirConta(int id);
	
}
