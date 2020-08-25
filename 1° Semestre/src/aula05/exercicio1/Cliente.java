package aula05.exercicio1;

public class Cliente {

	private int idConta;
	private String cpf;
	private String endereco;
	private String email;
	
	public int getIdConta() {
		return idConta;
	}
	
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\n\t idConta=" + idConta + "\n\t cpf=" + cpf + "\n\t endereco=" + endereco + "\n\t email=" + email;
	}
	
	
	
}
