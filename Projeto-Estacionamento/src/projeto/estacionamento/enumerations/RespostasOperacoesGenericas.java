package projeto.estacionamento.enumerations;

public enum RespostasOperacoesGenericas {

	CADASTRO(1),
	ALTERACAO(2),
	EXCLUSAO(3),
	CONSULTA(4),
	RELATORIO(5),
	LOTACAO(6),
	VOLTAR(0);
	
	private int id;
	
	private RespostasOperacoesGenericas(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public static RespostasOperacoesGenericas getById(int id) {
		for(RespostasOperacoesGenericas respostas : RespostasOperacoesGenericas.values()) {
			if(respostas.getId() == id)
				return respostas;
		}
		return null;
	}
}
