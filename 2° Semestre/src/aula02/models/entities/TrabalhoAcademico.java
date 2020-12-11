package aula02.models.entities;

import java.util.Date;
import java.util.List;

import aula02.models.abstractclasses.ItemAcervo;
import aula02.models.enumeration.Situacao;
import aula02.models.enumeration.TipoTrabalho;

public class TrabalhoAcademico extends ItemAcervo {
	
	private Date dataDefesa;
	private String nomeCurso;
	private TipoTrabalho tipoTrabalho;
	
	public TrabalhoAcademico() {	
	}

	public TrabalhoAcademico(String titulo, String subtitulo, String areaConhecimento, String codigoCatalogacao, Date dataPublicacao, int situacaoItem, Acervo acervo, List<Autoria> autorias, List<InstituicaoEditora> editoras, List<Emprestimo> emprestimos, List<Reserva> reservas, Date dataDefesa, String nomeCurso, TipoTrabalho tipoTrabalho) {
		super(titulo, subtitulo, areaConhecimento, codigoCatalogacao, dataPublicacao, situacaoItem, acervo, autorias, editoras, emprestimos, reservas);
		this.dataDefesa = dataDefesa;
		this.nomeCurso = nomeCurso;
		this.tipoTrabalho = tipoTrabalho;
	}

	public TrabalhoAcademico(String titulo, String subtitulo, String areaConhecimento, String codigoCatalogacao, Date dataPublicacao, Situacao situacaoItem, Acervo acervo, List<Autoria> autorias, List<InstituicaoEditora> editoras, List<Emprestimo> emprestimos, List<Reserva> reservas, Date dataDefesa, String nomeCurso, TipoTrabalho tipoTrabalho) {
		super(titulo, subtitulo, areaConhecimento, codigoCatalogacao, dataPublicacao, situacaoItem, acervo, autorias, editoras, emprestimos, reservas);
		this.dataDefesa = dataDefesa;
		this.nomeCurso = nomeCurso;
		this.tipoTrabalho = tipoTrabalho;
	}

	public Date getDataDefesa() {
		return dataDefesa;
	}

	public void setDataDefesa(Date dataDefesa) {
		this.dataDefesa = dataDefesa;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public TipoTrabalho getTipoTrabalho() {
		return tipoTrabalho;
	}

	public void setTipoTrabalho(TipoTrabalho tipoTrabalho) {
		this.tipoTrabalho = tipoTrabalho;
	}

}
