package exercicio2;

public class Pessoa {

	private String cpf;
	private String nome;
	private String rg;
	private Endereco endereco;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getEndereco() {
		return endereco.toString();
	}
	
	public void setEndereco(String rua, int numero, String bairro, String cidade, String estado) {
		this.endereco = new Endereco(rua, numero, bairro, cidade, estado);
	}
	
}
