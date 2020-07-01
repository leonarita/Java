package aula01;

import javax.swing.JOptionPane;

public class Exercicio2 {

	public static void main(String[] args) {

		float prec = Float.parseFloat(JOptionPane.showInputDialog("Informe o preço do produto:"));
		float porc = Float.parseFloat(JOptionPane.showInputDialog("Informe o desconto: \n(em porcentagem)"))/100;
		JOptionPane.showMessageDialog(null, "O produto, com desconto, custa R$" + (prec - (prec * porc)));
	}

}
