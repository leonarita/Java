package aula02.models.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import aula02.models.abstractclasses.ItemAcervo;

public class Acervo {

	private String assunto;
	private Bibliotecario gestor;
	private List<ItemAcervo> itemsAcervo;
	
	public Acervo() {
		this.itemsAcervo = new ArrayList<ItemAcervo>();
	}

	public Acervo(String assunto, Bibliotecario gestor, List<ItemAcervo> itemsAcervo) {
		this.assunto = assunto;
		this.gestor = gestor;
		
		if(Objects.nonNull(itemsAcervo)) {
			this.itemsAcervo = itemsAcervo;
		}
		else {
			this.itemsAcervo = new ArrayList<ItemAcervo>();
		}
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Bibliotecario getGestor() {
		return gestor;
	}

	public void setGestor(Bibliotecario gestor) {
		this.gestor = gestor;
	}

	public List<ItemAcervo> getItemsAcervo() {
		return itemsAcervo;
	}

	public void setItemsAcervo(List<ItemAcervo> itemsAcervo) {
		this.itemsAcervo = itemsAcervo;
	}
	
}
