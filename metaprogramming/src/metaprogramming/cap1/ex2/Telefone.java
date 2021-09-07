package metaprogramming.cap1.ex2;

public class Telefone {

	private String codigoPais;
	private String operadora;
	
	public Telefone(String codigoPais, String operadora) {
		this.codigoPais = codigoPais;
		this.operadora = operadora;
	}
	
	@NomePropriedade("codigoInternacional")
	public String getCodigoPais() {
		return codigoPais;
	}
	
	@Ignorar
	public String getOperadora() {
		return operadora;
	}
}
