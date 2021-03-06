package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoasfisicas")
public class PessoaFisica extends Pessoa {
	
	/* ATRIBUTOS */

	private static final long serialVersionUID = 1l;

	@Column(name = "cpf")
	private String cpfPessoa;

	@Column(name = "rg")
	private String rgPessoa;
	
	@Column(name = "idade")
	private int idadePessoa;
	
	
	/* CONSTRUTORES */
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String cpfPessoa, String rgPessoa, int idadePessoa) {
		super();
		this.cpfPessoa = cpfPessoa;
		this.rgPessoa = rgPessoa;
		this.idadePessoa = idadePessoa;
	}

	public PessoaFisica(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa, int situacaoPessoa) {
		
		super(nomePessoa, enderecoPessoa, cepPessoa, telefonePessoa, rendaPessoa, situacaoPessoa);
	}
	
	public PessoaFisica(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa, int situacaoPessoa, String cpfPessoa, String rgPessoa, int idadePessoa) {
		
		super(nomePessoa, enderecoPessoa, cepPessoa, telefonePessoa, rendaPessoa, situacaoPessoa);
		
		this.cpfPessoa = cpfPessoa;
		this.rgPessoa = rgPessoa;
		this.idadePessoa = idadePessoa;
	}
	
	
	
	/* GETTERS AND SETTERS */

	public String getCpfPessoa() {
		return cpfPessoa;
	}
	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}
	public String getRgPessoa() {
		return rgPessoa;
	}
	public void setRgPessoa(String rgPessoa) {
		this.rgPessoa = rgPessoa;
	}
	public int getIdadePessoa() {
		return idadePessoa;
	}
	public void setIdadePessoa(int idadePessoa) {
		this.idadePessoa = idadePessoa;
	}
	
}
