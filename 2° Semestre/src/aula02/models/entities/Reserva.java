package aula02.models.entities;

import java.time.LocalDateTime;

import aula02.models.abstractclasses.ItemAcervo;

public class Reserva {
	
	private LocalDateTime dataReserva;
	private LocalDateTime dataExpiracao;
	private ItemAcervo itemAcervo;
	private UsuarioComum usuarioComum;
	
	public Reserva() {
	}

	public Reserva(LocalDateTime dataReserva, LocalDateTime dataExpiracao, ItemAcervo itemAcervo, UsuarioComum usuarioComum) {
		this.dataReserva = dataReserva;
		this.dataExpiracao = dataExpiracao;
		this.itemAcervo = itemAcervo;
		this.usuarioComum = usuarioComum;
	}

	public LocalDateTime getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDateTime dataReserva) {
		this.dataReserva = dataReserva;
	}

	public LocalDateTime getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(LocalDateTime dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
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
