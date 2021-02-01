package modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "contaspoupancas")
public class ContaPoupanca extends ContaComum {
		
	/* ATRIBUTOS */
	
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name = "aniversarioconta")
	private Calendar aniversarioConta;
	
	
	/* CONSTRUTORES */
	
	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(Calendar aniversarioConta) {
		
		super();
		this.aniversarioConta = aniversarioConta;
	}
	
	public ContaPoupanca(long numeroConta, Calendar aberturaConta, Calendar fechamentoConta, int situacaoConta,
			int senhaConta, double saldoConta) {
		
		super(numeroConta, aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta);
	}
	
	public ContaPoupanca(long numeroConta, Calendar aberturaConta, Calendar fechamentoConta, int situacaoConta,
			int senhaConta, double saldoConta, Calendar aniversarioConta) {
		
		super(numeroConta, aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta);
		this.aniversarioConta = aniversarioConta;
	}
	
	
	/* GETTERS AND SETTERS */

	public Calendar getAniversarioConta() {
		return aniversarioConta;
	}

	public void setAniversarioConta(Calendar aniversarioConta) {
		this.aniversarioConta = aniversarioConta;
	}
	
	
}
