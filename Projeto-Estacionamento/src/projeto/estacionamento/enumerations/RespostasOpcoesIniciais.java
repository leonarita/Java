package projeto.estacionamento.enumerations;

public enum RespostasOpcoesIniciais {
	
	CLIENTE(1),
	VEICULO(2),
	PATIO(3),
	CONTA(4),
	SAIR(0);
	
	private int id;
	
	private RespostasOpcoesIniciais(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public static RespostasOpcoesIniciais getById(int id) {
		for(RespostasOpcoesIniciais respostas : RespostasOpcoesIniciais.values()) {
			if(respostas.getId() == id)
				return respostas;
		}
		return null;
	}

}
