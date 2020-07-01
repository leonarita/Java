package A_Calculadora;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal {

	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Calculadora");
		JTextField primeiro = new JTextField(10);
		JTextField segundo = new JTextField(10);
		JButton botao = new JButton(" = ");
		JLabel resultado = new JLabel("    ?     ");
		JLabel x = new JLabel("x");
		
		botao.addActionListener(new AcaoBotao(primeiro, segundo, resultado));		
		
		JPanel painel = new JPanel();
		painel.add(primeiro);
		painel.add(x);
		painel.add(segundo);
		painel.add(botao);
		painel.add(resultado);
		
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setPreferredSize(new Dimension(450, 300));
		janela.pack();
		janela.setVisible(true);
		
	}
}
