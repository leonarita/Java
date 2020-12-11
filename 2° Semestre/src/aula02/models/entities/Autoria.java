package aula02.models.entities;

import aula02.models.abstractclasses.ItemAcervo;

public class Autoria {
	
	private boolean eEditor;
	private Autor autor;
	private ItemAcervo itemAcervo;
	
	public Autoria() {
	}

	public Autoria(boolean eEditor, Autor autor, ItemAcervo itemAcervo) {
		super();
		this.eEditor = eEditor;
		this.autor = autor;
		this.itemAcervo = itemAcervo;
	}

	public boolean iseEditor() {
		return eEditor;
	}

	public void seteEditor(boolean eEditor) {
		this.eEditor = eEditor;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public ItemAcervo getItemAcervo() {
		return itemAcervo;
	}

	public void setItemAcervo(ItemAcervo itemAcervo) {
		this.itemAcervo = itemAcervo;
	}

}
