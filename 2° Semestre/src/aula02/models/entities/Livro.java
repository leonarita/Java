package aula02.models.entities;

import java.util.Date;
import java.util.List;

import aula02.models.abstractclasses.ItemAcervo;
import aula02.models.enumeration.Situacao;

public class Livro extends ItemAcervo {
	
	private short edicao;
	private long isbn;
	
	public Livro() {
	}

	public Livro(String titulo, String subtitulo, String areaConhecimento, String codigoCatalogacao, Date dataPublicacao, int situacaoItem, Acervo acervo, List<Autoria> autorias, List<InstituicaoEditora> editoras, List<Emprestimo> emprestimos, List<Reserva> reservas, short edicao, long isbn) {
		super(titulo, subtitulo, areaConhecimento, codigoCatalogacao, dataPublicacao, situacaoItem, acervo, autorias, editoras, emprestimos, reservas);
		this.edicao = edicao;
		this.isbn = isbn;
	}

	public Livro(String titulo, String subtitulo, String areaConhecimento, String codigoCatalogacao, Date dataPublicacao, Situacao situacaoItem, Acervo acervo, List<Autoria> autorias, List<InstituicaoEditora> editoras, List<Emprestimo> emprestimos, List<Reserva> reservas, short edicao, long isbn) {
		super(titulo, subtitulo, areaConhecimento, codigoCatalogacao, dataPublicacao, situacaoItem, acervo, autorias, editoras, emprestimos, reservas);
		this.edicao = edicao;
		this.isbn = isbn;
	}

	public short getEdicao() {
		return edicao;
	}

	public void setEdicao(short edicao) {
		this.edicao = edicao;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

}
