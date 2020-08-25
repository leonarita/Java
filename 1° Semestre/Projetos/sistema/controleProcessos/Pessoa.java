package sistema.controleProcessos;

import java.sql.Date;

public class Pessoa {

	private int codigo;
	private String nome;
	private Date nascto;
	
	public Pessoa(int codigo, String nome, Date nascto) {
		this.codigo = codigo;
		this.nome = nome;
		this.nascto = nascto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascto() {
		return nascto;
	}

	@SuppressWarnings("deprecation")
	public String setNascto(Date nascto) {
		return nascto.getYear() + "-" + (nascto.getMonth()+1) + "-" + nascto.getDay();
	}
}
