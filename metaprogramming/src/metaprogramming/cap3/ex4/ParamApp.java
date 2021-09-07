package metaprogramming.cap3.ex4;

public class ParamApp {

	@Parametro("-p")
	private boolean possui;

	@Parametro("-n")
	private boolean naoPossui;
	
	@Parametro("-a")
	private String[] arquivos;
	
	@Parametro("-s")
	private String saida;

	public boolean isPossui() {
		return possui;
	}

	public void setPossui(boolean possui) {
		this.possui = possui;
	}

	public boolean isNaoPossui() {
		return naoPossui;
	}

	public void setNaoPossui(boolean naoPossui) {
		this.naoPossui = naoPossui;
	}

	public String[] getArquivos() {
		return arquivos;
	}

	public void setArquivos(String[] arquivos) {
		this.arquivos = arquivos;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}
	
	
}
