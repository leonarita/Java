package aula02.models.entities;

import java.time.LocalDateTime;
import java.util.Date;

import aula02.models.abstractclasses.ItemAcervo;

public class Emprestimo {
	
	private LocalDateTime dataRetirada;
	private LocalDateTime dataDevolucaoEfetiva;
	private Date dataDevolucaoPrevista;
	private ItemAcervo itemAcervo;
	private UsuarioComum usuarioComum;
	
	public Emprestimo() {
	}

	public Emprestimo(LocalDateTime dataRetirada, LocalDateTime dataDevolucaoEfetiva, Date dataDevolucaoPrevista, ItemAcervo itemAcervo, UsuarioComum usuarioComum) {
		this.dataRetirada = dataRetirada;
		this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		this.itemAcervo = itemAcervo;
		this.usuarioComum = usuarioComum;
	}

	public LocalDateTime getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDateTime dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public LocalDateTime getDataDevolucaoEfetiva() {
		return dataDevolucaoEfetiva;
	}

	public void setDataDevolucaoEfetiva(LocalDateTime dataDevolucaoEfetiva) {
		this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
	}

	public Date getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}

	public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}

	public ItemAcervo getItemAcervo() {
		return itemAcervo;
	}

	public void setItemAcervo(ItemAcervo itemAcervo) {
		this.itemAcervo = itemAcervo;
	}

	public UsuarioComum getUsuarioComum() {
		return usuarioComum;
	}

	public void setUsuarioComum(UsuarioComum usuarioComum) {
		this.usuarioComum = usuarioComum;
	}

}
