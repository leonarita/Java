package _Orientação_A_Objetos;

import javax.swing.JOptionPane;

class Func
{
	float salario, inss, vt, ir;
	
	float desc ()
	{	return (this.inss + this.vt + this.ir);	}

	float sl ()
	{	return this.salario-desc();		}
	
	Func (float salario)
	{	this.salario = salario;
		this.inss = (float)0.11*salario;
		this.vt = (float)0.06*salario;
		this.ir = 0.0f;
		
		if ( this.salario > 12696 && this.salario <= 25380 )
			this.ir = (float)0.15*salario;
		else if ( this.salario > 25380 )
			this.ir = (float)0.275*salario;
		else
			this.ir = 0;
	}
	
	Func (float salario, float inss, float vt, float ir)
	{	this.salario = salario;
		this.inss = inss;
		this.vt = vt;
		this.ir = ir;
	}
	
	Func ()
	{	this.salario = 1000.00f;
		this.inss = 110.0f;
		this.vt = 60.0f;
		this.ir = 0.0f;
	}
	
	void contracheque ()
	{	JOptionPane.showMessageDialog (null, "Salário bruto : R$ \t\t" + this.salario + "\n" + "INSS : R$ \t\t" + this.inss + "\n" +
			"Imposto de Renda: R$ \t\t" + this.ir + "\n" + "Vale transporte : R$ \t\t" + this.vt + "\n" + "---------------------\t\t" + "\n" +
			"Descontos : R$ \t\t" + desc () + "\n" +"Salário líquido : R$ \t\t" + sl());
	}
}

public class Aula8 
{	
	public static void main (String args[])
	{	String texto;
		float sb;
		
		texto = JOptionPane.showInputDialog("Digite o valor do salário bruto: ");
		sb = Float.parseFloat (texto);
		
		Func funcionario = new Func (sb);
		funcionario.contracheque();
		
		System.exit(0);
	}
}
