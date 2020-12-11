package aula02.models.entities;

import java.util.Date;
import java.util.List;

import aula02.models.abstractclasses.ItemAcervo;
import aula02.models.enumeration.Situacao;

public class Revista extends ItemAcervo {
	
	private int issun;
	private short numero;
	private short volume;
	
	public Revista() {
	}
	
	public Revista(String titulo, String subtitulo, String areaConhecimento, String codigoCatalogacao, Date dataPublicacao, int situacaoItem, Acervo acervo, List<Autoria> autorias, List<InstituicaoEditora> editoras, List<Emprestimo> emprestimos, List<Reserva> reservas, int issun, short numero, short volume) {
		super(titulo, subtitulo, areaConhecimento, codigoCatalogacao, dataPublicacao, situacaoItem, acervo, autorias, editoras, emprestimos, reservas);
		this.issun = issun;
		this.numero = numero;
		this.volume = volume;
	}

	public Revista(String titulo, String subtitulo, String areaConhecimento, String codigoCatalogacao, Date dataPublicacao, Situacao situacaoItem, Acervo acervo, List<Autoria> autorias, List<InstituicaoEditora> editoras, List<Emprestimo> emprestimos, List<Reserva> reservas, int issun, short numero, short volume) {
		super(titulo, subtitulo, areaConhecimento, codigoCatalogacao, dataPublicacao, situacaoItem, acervo, autorias, editoras, emprestimos, reservas);
		this.issun = issun;
		this.numero = numero;
		this.volume = volume;
	}

	public int getIssun() {
		return issun;
	}

	public void setIssun(int issun) {
		this.issun = issun;
	}

	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public short getVolume() {
		return volume;
	}

	public void setVolume(short volume) {
		this.volume = volume;
	}

}
