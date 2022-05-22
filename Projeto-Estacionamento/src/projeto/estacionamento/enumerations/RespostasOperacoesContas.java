package projeto.estacionamento.enumerations;

public enum RespostasOperacoesContas {

	INCLUSAO_DIARIA(1),
	EXCLUSAO_DIARIA(2),
	TOTAL_PAGAR(3),
	VOLTAR(0);
	
	private int id;
	
	private RespostasOperacoesContas(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public static RespostasOperacoesContas getById(int id) {
		for(RespostasOperacoesContas respostas : RespostasOperacoesContas.values()) {
			if(respostas.getId() == id)
				return respostas;
		}
		return null;
	}
}
