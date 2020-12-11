package aula02.models.entities;

import java.util.Date;
import java.util.List;

import aula02.models.abstractclasses.Pessoa;

public class Autor extends Pessoa {

	private String nomeCitacoes;
	private String orcid;
	private List<Autoria> autorias;
	
	public Autor() {
	}

	public Autor(long cpf, String nome, String sobrenome, String login, String email, String senha, Date nascimento, String nomeCitacoes, String orcid, List<Autoria> autorias) {
		super(cpf, nome, sobrenome, login, email, senha, nascimento);
		this.nomeCitacoes = nomeCitacoes;
		this.orcid = orcid;
		this.autorias = autorias;
	}

	public String getNomeCitacoes() {
		return nomeCitacoes;
	}

	public void setNomeCitacoes(String nomeCitacoes) {
		this.nomeCitacoes = nomeCitacoes;
	}

	public String getOrcid() {
		return orcid;
	}

	public void setOrcid(String orcid) {
		this.orcid = orcid;
	}

	public List<Autoria> getAutorias() {
		return autorias;
	}

	public void setAutorias(List<Autoria> autorias) {
		this.autorias = autorias;
	}
	
}
