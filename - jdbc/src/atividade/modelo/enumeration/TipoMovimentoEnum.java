package atividade.modelo.enumeration;

public enum TipoMovimentoEnum {

	DEPOSITO(1), SAQUE(2);
	
	private int tipoMovimento;
	
	TipoMovimentoEnum (int valor) {
		tipoMovimento = valor;
	}

	public int getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(int tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
}
