package modelo;

public class PessoaJuridica extends Pessoa {

	/* ATRIBUTOS */

	private static final long serialVersionUID = 1l;

	private String cnpjPessoa;


	/* CONSTRUTORES */
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String cnpjPessoa) {
		super();
		this.cnpjPessoa = cnpjPessoa;
	}
	
	public PessoaJuridica(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa, int situacaoPessoa) {
		
		super(nomePessoa, enderecoPessoa, cepPessoa, telefonePessoa, rendaPessoa, situacaoPessoa);
	}
	
	public PessoaJuridica(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa, int situacaoPessoa, String cnpjPessoa) {
		
		super(nomePessoa, enderecoPessoa, cepPessoa, telefonePessoa, rendaPessoa, situacaoPessoa);
		this.cnpjPessoa = cnpjPessoa;
	}



	/* GETTERS AND SETTERS */

	public String getCnpjPessoa() {
		return cnpjPessoa;
	}

	public void setCnpjPessoa(String cnpjPessoa) {
		this.cnpjPessoa = cnpjPessoa;
	}


}
