package sistema.controleProcessos;

import java.sql.Date;

public class Funcionario extends Pessoa {

	private int ra;
	private Date dataAdmissao;
	
	public Funcionario(int codigo, String nome, Date nascto, int ra, Date dataAdmissao) {
		
		super(codigo, nome, nascto);

		this.ra = ra;
		this.dataAdmissao = dataAdmissao;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	@SuppressWarnings("deprecation")
	public String setDataAdmissao(Date dataAdmissao) {
		return dataAdmissao.getYear() + "-" + (dataAdmissao.getMonth()+1) + "-" + dataAdmissao.getDay();
	}
}
