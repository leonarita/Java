package sistema.controleProcessos;

import java.sql.Date;

public class Processo {

	private int numero;
	private Date dataAbertura;
	private Date dataEncerramento;
	private short status;
	private Pessoa pessoa;
	
	public Processo(int numero, Date dataAbertura, Date dataEncerramento, short status, Pessoa pessoa) {
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.dataEncerramento = dataEncerramento;
		this.status = status;
		this.pessoa = pessoa;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@SuppressWarnings("deprecation")
	public String getDataAbertura() {
		return dataAbertura.getYear() + "-" + (dataAbertura.getMonth()+1) + "-" + dataAbertura.getDay();
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	@SuppressWarnings("deprecation")
	public String getDataEncerramento() {
		return dataEncerramento.getYear() + "-" + (dataEncerramento.getMonth()+1) + "-" + dataEncerramento.getDay();
	}
	
	public Date getDataEncerramento2() {
		return dataEncerramento;
	}

	@SuppressWarnings("deprecation")
	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
		this.dataEncerramento.setYear(this.dataEncerramento.getYear()+1900+1900);
	}

	public String getStatus() {
		if (this.status==(short)1)
			return "Aberto";
		else if (this.status==(short)2)
			return "Em Trâmite";
		else
			return "Finalizado";
	}
	
	
	public int getStatusInt() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
