package exercicio1;

public class Conta {

	private int idConta;
	private int agencia;
	private String numeroConta;
	private Cliente titular;
	
	public Conta() {
		this.titular = new Cliente();
	}
	
	public int getIdConta() {
		return idConta;
	}
	
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getTitular() {
		return titular.toString();
	}
	
	public void setTitular(int idConta, String cpf, String endereco, String email) {
		titular.setIdConta(idConta);
		titular.setEmail(email);
		titular.setCpf(cpf);
		titular.setEndereco(endereco);
	}

}
