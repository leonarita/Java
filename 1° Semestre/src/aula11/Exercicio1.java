package aula11;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Exercicio1 extends JFrame {

	private JLabel lbNumero1, lbNumero2, lbOperacao;
	private JTextField tfNumero1, tfNumero2;
	private JComboBox<String> cbOperacao;
	private JButton btCalcular;
	private Container cp;
	
	private static final String valoresOperacao[] = { "+", "-", "*", "/", "%" };
	
	public Exercicio1() {
		lbNumero1 = new JLabel("Valor 1");
		lbNumero2 = new JLabel("Valor 2");
		lbOperacao = new JLabel("Operação");
		
		tfNumero1 = new JTextField();
		tfNumero2 = new JTextField();
		
		cbOperacao = new JComboBox<>(valoresOperacao);
		
		btCalcular = new JButton("Calcular");
		
		this.setTitle("Exercicio 1");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbNumero1.setBounds(20, 20, 50, 25);
		lbNumero2.setBounds(20, 50, 50, 25);
		tfNumero1.setBounds(100, 20, 120, 25);
		tfNumero2.setBounds(100, 50, 120, 25);
		lbOperacao.setBounds(20, 80, 50, 25);
		cbOperacao.setBounds(100, 80, 100, 25);
		btCalcular.setBounds(250, 80, 100, 25);
		
		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));
		
		cp.add(lbNumero1);
		cp.add(lbNumero2);
		cp.add(lbOperacao);
		cp.add(tfNumero1);
		cp.add(tfNumero2);
		cp.add(cbOperacao);
		cp.add(btCalcular);
		
		btCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		
	}
	
	private void calcular() {
		
		try {
			float n1 = Float.parseFloat(tfNumero1.getText());
			float n2 = Float.parseFloat(tfNumero2.getText());
		
			switch(cbOperacao.getSelectedItem().toString()) {
			
				case "+":
					JOptionPane.showMessageDialog(this, "A soma é: " + (n1+n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "-":
					JOptionPane.showMessageDialog(this, "A subtração é: " + (n1-n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "*":
					JOptionPane.showMessageDialog(this, "A multiplicação é: " + (n1*n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "/":
					JOptionPane.showMessageDialog(this, "A divisão é: " + (n1/n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "%":
					if(isInteger(tfNumero1.toString()) && isInteger(tfNumero2.toString()))
						JOptionPane.showMessageDialog(this, "O resto é: " + (n1%n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(this, "Não pôde calcular resto de números decimais", "Erro", JOptionPane.ERROR_MESSAGE);
					break;
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Números não válidos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private static boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Exercicio1().setVisible(true);
			}
			
		});

	}
	
}
