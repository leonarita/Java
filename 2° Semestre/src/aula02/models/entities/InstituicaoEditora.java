package aula02.models.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import aula02.models.abstractclasses.ItemAcervo;

public class InstituicaoEditora {
	
	private long cnpj;
	private String cidade;
	private String nome;
	private List<ItemAcervo> itemsAcervo;
	
	public InstituicaoEditora() {
		this.itemsAcervo = new ArrayList<ItemAcervo>();
	}

	public InstituicaoEditora(long cnpj, String cidade, String nome, List<ItemAcervo> itemsAcervo) {
		this.cnpj = cnpj;
		this.cidade = cidade;
		this.nome = nome;
		
		if(Objects.nonNull(itemsAcervo)) {
			this.itemsAcervo = itemsAcervo;
		}
		else {
			this.itemsAcervo = new ArrayList<ItemAcervo>();
		}
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ItemAcervo> getItemsAcervo() {
		return itemsAcervo;
	}

	public void setItemsAcervo(List<ItemAcervo> itemsAcervo) {
		this.itemsAcervo = itemsAcervo;
	}

}
