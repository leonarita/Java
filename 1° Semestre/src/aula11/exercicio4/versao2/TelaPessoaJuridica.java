package aula11.exercicio4.versao2;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TelaPessoaJuridica extends JDialog {
	
	private Container cp;

	public TelaPessoaJuridica() {
		
		this.setTitle("Pessoa Jurídica");
		this.setSize(200, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.getContentPane().setBackground(new Color(180, 205, 205));
		
		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));
	
		this.setModal(true);
	}
}
