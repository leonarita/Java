package aula02.models.abstractclasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import aula02.models.entities.Acervo;
import aula02.models.entities.Autoria;
import aula02.models.entities.Emprestimo;
import aula02.models.entities.InstituicaoEditora;
import aula02.models.entities.Reserva;
import aula02.models.enumeration.Situacao;

public abstract class ItemAcervo {
	
	protected String titulo;
	protected String subtitulo;
	protected String areaConhecimento;
	protected String codigoCatalogacao;
	protected Date dataPublicacao;
	protected Situacao situacaoItem;
	protected Acervo acervo;
	private List<Autoria> autorias;
	private List<InstituicaoEditora> editoras;
	private List<Emprestimo> emprestimos;
	private List<Reserva> reservas;
	
	public ItemAcervo() {
		this.autorias = new ArrayList<Autoria>();
		this.editoras = new ArrayList<InstituicaoEditora>();
		this.reservas = new ArrayList<Reserva>();
		this.emprestimos = new ArrayList<Emprestimo>();
	}

	public ItemAcervo(String titulo, String subtitulo, String areaConhecimento, String codigoCatalogacao, Date dataPublicacao, Situacao situacaoItem, Acervo acervo, List<Autoria> autorias, List<InstituicaoEditora> editoras, List<Emprestimo> emprestimos, List<Reserva> reservas) {
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.areaConhecimento = areaConhecimento;
		this.codigoCatalogacao = codigoCatalogacao;
		this.dataPublicacao = dataPublicacao;
		this.situacaoItem = situacaoItem;
		this.acervo = acervo;
		
		if(Objects.nonNull(autorias)) {
			this.autorias = autorias;
		}
		else {
			this.autorias = new ArrayList<Autoria>();
		}
		
		if(Objects.nonNull(editoras)) {
			this.editoras = editoras;
		}
		else {
			this.editoras = new ArrayList<InstituicaoEditora>();
		}
		
		if(Objects.nonNull(reservas)) {
			this.reservas = reservas;
		}
		else {
			this.reservas = new ArrayList<Reserva>();
		}

		if(Objects.nonNull(emprestimos)) {
			this.emprestimos = emprestimos;
		}
		else {
			this.emprestimos = new ArrayList<Emprestimo>();
		}
	}

	public ItemAcervo(String titulo, String subtitulo, String areaConhecimento, String codigoCatalogacao, Date dataPublicacao, int situacaoItem, Acervo acervo, List<Autoria> autorias, List<InstituicaoEditora> editoras, List<Emprestimo> emprestimos, List<Reserva> reservas) {
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.areaConhecimento = areaConhecimento;
		this.codigoCatalogacao = codigoCatalogacao;
		this.dataPublicacao = dataPublicacao;
		this.situacaoItem = Situacao.encontrarPorId(situacaoItem);
		this.acervo = acervo;

		if(Objects.nonNull(autorias)) {
			this.autorias = autorias;
		}
		else {
			this.autorias = new ArrayList<Autoria>();
		}
		
		if(Objects.nonNull(editoras)) {
			this.editoras = editoras;
		}
		else {
			this.editoras = new ArrayList<InstituicaoEditora>();
		}
		
		if(Objects.nonNull(reservas)) {
			this.reservas = reservas;
		}
		else {
			this.reservas = new ArrayList<Reserva>();
		}

		if(Objects.nonNull(emprestimos)) {
			this.emprestimos = emprestimos;
		}
		else {
			this.emprestimos = new ArrayList<Emprestimo>();
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public String getCodigoCatalogacao() {
		return codigoCatalogacao;
	}

	public void setCodigoCatalogacao(String codigoCatalogacao) {
		this.codigoCatalogacao = codigoCatalogacao;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Situacao getSituacaoItem() {
		return situacaoItem;
	}

	public void setSituacaoItem(Situacao situacaoItem) {
		this.situacaoItem = situacaoItem;
	}

	public Acervo getAcervo() {
		return acervo;
	}

	public void setAcervo(Acervo acervo) {
		this.acervo = acervo;
	}
	
	public List<Autoria> getAutorias() {
		return autorias;
	}

	public void setAutorias(List<Autoria> autorias) {
		this.autorias = autorias;
	}

	public List<InstituicaoEditora> getEditoras() {
		return editoras;
	}

	public void setEditoras(List<InstituicaoEditora> editoras) {
		this.editoras = editoras;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

}
