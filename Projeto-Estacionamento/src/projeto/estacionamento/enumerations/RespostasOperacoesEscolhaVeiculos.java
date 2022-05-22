package projeto.estacionamento.enumerations;

import java.util.Objects;

import projeto.estacionamento.models.Caminhao;
import projeto.estacionamento.models.Carro;
import projeto.estacionamento.models.Veiculo;

public enum RespostasOperacoesEscolhaVeiculos {

	CARRO(1) {
		@Override
		public boolean isIstanceOf(Veiculo veiculo) {
			if(Objects.isNull(veiculo))
				 return false;
			return veiculo instanceof Carro;
		}
	},
	
	CAMINHAO(2) {
		@Override
		public boolean isIstanceOf(Veiculo veiculo) {
			if(Objects.isNull(veiculo))
				 return false;
			return veiculo instanceof Caminhao;
		}
	},
	
	VOLTAR(0) {
		@Override
		public boolean isIstanceOf(Veiculo veiculo) {
			return false;
		}
	};
	
	private int id;
	
	private RespostasOperacoesEscolhaVeiculos(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public static RespostasOperacoesEscolhaVeiculos getById(int id) {
		for(RespostasOperacoesEscolhaVeiculos respostas : RespostasOperacoesEscolhaVeiculos.values()) {
			if(respostas.getId() == id)
				return respostas;
		}
		return null;
	}
	
	public abstract boolean isIstanceOf(Veiculo veiculo);
}
