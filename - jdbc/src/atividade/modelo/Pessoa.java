package atividade.modelo;

import atividade.modelo.enumeration.SituacaoPessoaEnum;
import atividade.modelo.interfaces.PessoaInterface;

public class Pessoa implements PessoaInterface {

	protected int idPessoa;
	protected String nomePessoa;
	protected String enderecoPessoa;
	protected long cepPessoa;
	protected String telefonePessoa;
	protected double rendaPessoa;
	protected SituacaoPessoaEnum situacaoPessoa;
	
	public Pessoa() {
		this.situacaoPessoa = SituacaoPessoaEnum.PESSOA;
	}

	public Pessoa(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa, double rendaPessoa, int situacaoPessoa) {
		this.nomePessoa = nomePessoa;
		this.enderecoPessoa = enderecoPessoa;
		this.cepPessoa = cepPessoa;
		this.telefonePessoa = telefonePessoa;
		this.rendaPessoa = rendaPessoa;
		
		// 'Construtor' do enum (para não dar NullPointer)
		this.situacaoPessoa = SituacaoPessoaEnum.PESSOA;
		
		// Colocar dado no enum
		if(situacaoPessoa == 2 || situacaoPessoa == 3)
			this.situacaoPessoa.setSituacao(situacaoPessoa);
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getEnderecoPessoa() {
		return enderecoPessoa;
	}

	public void setEnderecoPessoa(String enderecoPessoa) {
		this.enderecoPessoa = enderecoPessoa;
	}

	public long getCepPessoa() {
		return cepPessoa;
	}

	public void setCepPessoa(long cepPessoa) {
		this.cepPessoa = cepPessoa;
	}

	public String getTelefonePessoa() {
		return telefonePessoa;
	}

	public void setTelefonePessoa(String telefonePessoa) {
		this.telefonePessoa = telefonePessoa;
	}

	public double getRendaPessoa() {
		return rendaPessoa;
	}

	public void setRendaPessoa(double rendaPessoa) {
		this.rendaPessoa = rendaPessoa;
	}

	public int getSituacaoPessoa() {
		return situacaoPessoa.getSituacao();
	}

	public void setSituacaoPessoa(int situacaoPessoa) {
		this.situacaoPessoa.setSituacao(situacaoPessoa);
	}

	@Override
	public int buscarIdPelaCredencial(String credencial) {
		return 0;
	}

}
