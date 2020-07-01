package main;

import javax.swing.JOptionPane;

import classesAbstratas.Conta;
import classesAbstratas.ContaCorrente;
import classesAbstratas.ContaPoupanca;
import interfaces.IDb;
import interfaces.MySQL;
import interfaces.Oracle;

public class Main {
	
	public static void main(String args[]){
		
		Carro c4 = new Carro();
		c4.ligar();
		c4.freio = false;
		c4.trocarMarcha();
		c4.acelerar(50);
		c4.desligar();
		
		Carro ix35 = new Carro();
		ix35.desligar();
		
		ContaCorrente c = new ContaCorrente();
		c.depositar(100);
		c.sacar(50, "123");
		c.verSaldo();
		
		Escrita.Escrever("TESTE");		
		
		String acao = JOptionPane.showInputDialog("Digite o tipo de conta: ");
		
		Conta conta;
		
		if(acao.equals("c")){
			conta = new ContaCorrente();
		} else {
			conta = new ContaPoupanca();
		}
		
		conta.depositar(100);
		conta.sacar();
		conta.verSaldo();
		
		IDb db;
		
		String action = JOptionPane.showInputDialog("Digite o tipo de banco: ");
		
		if(action.equals("m")){
			db = new MySQL();
		} else {
			db = new Oracle();
		}
		
		db.conectar();
		db.desconectar();
	}
	
}