package atividade.modelo.enumeration;

public enum SituacaoPessoaEnum {

	PESSOA(1), PESSOAFISICA(2), PESSOAJURIDICA(3);
	
	private int situacao=1;
	
	SituacaoPessoaEnum(int valor) {
		situacao = valor;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	
	
}
