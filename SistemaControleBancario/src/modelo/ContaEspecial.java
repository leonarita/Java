package modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "contasespeciais")
@PrimaryKeyJoinColumn(name="numeroConta")
public class ContaEspecial extends ContaComum {
	
	/* ATRIBUTOS */
	
	private static final long serialVersionUID = 1l;

	@Column(name = "limiteconta")
	private double limiteConta;
	
	
	/* CONSTRUTORES */

	public ContaEspecial() {
		super();
	}

	public ContaEspecial(double limiteConta) {
		super();
		this.limiteConta = limiteConta;
	}

	public ContaEspecial(long numeroConta, Calendar aberturaConta, Calendar fechamentoConta, int situacaoConta,
			int senhaConta, double saldoConta) {
		
		super(numeroConta, aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta);
	}
	
	public ContaEspecial(long numeroConta, Calendar aberturaConta, Calendar fechamentoConta, int situacaoConta,
			int senhaConta, double saldoConta, double limiteConta) {
		
		super(numeroConta, aberturaConta, fechamentoConta, situacaoConta, senhaConta, saldoConta);
		this.limiteConta = limiteConta;
	}
	
	
	/* GETTERS AND SETTERS */

	public double getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(double limiteConta) {
		this.limiteConta = limiteConta;
	}
	
}
