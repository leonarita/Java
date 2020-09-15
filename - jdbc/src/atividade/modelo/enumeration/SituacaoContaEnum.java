package atividade.modelo.enumeration;

public enum SituacaoContaEnum {

	CONTACOMUM(1), CONTAESPECIAL(2), CONTAPOUPANCA(3);
	
	private int situacao=1;
	
	SituacaoContaEnum(int valor) {
		situacao = valor;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	
	
}
