package modelo.enumeration;

public enum TipoMovimentoEnum  {
	
	DEPOSITO(1, "depósito"), SAQUE(2, "saque");
	
	private Integer tipoMovimento;
	private String descricao;

	TipoMovimentoEnum (Integer tipoMovimento, String descricao) {
		this.tipoMovimento = tipoMovimento;
		this.descricao = descricao;
	}
	
	public Integer getTipoMovimento() {
		return tipoMovimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public static class Converter extends AbstractEnumConverter {
        public Converter() {
            super();
        }
    }


}
