package aula11;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Exercicio2 extends JFrame {

	private Container cp;
	private JLabel lblTemperatura;
	private JTextField tfTemperatura;
	private ButtonGroup bgOpcoes; 
	private JRadioButton rbOpcoes[];
	
	private static final String values[] = { "Celsius para Fahrenheit", "Fahrenheit para Celsius", "Celsius para Kelvin", 
			"Kelvin para Celsius", "Fahrenheit para Kelvin", "Kelvin para Fahrenheit" };
	
	public Exercicio2() {
		lblTemperatura = new JLabel("Temperatura");
		tfTemperatura = new JTextField();
		bgOpcoes = new ButtonGroup();
		rbOpcoes = new JRadioButton[6];
		
		for(int i=0; i<rbOpcoes.length; i++) {
			rbOpcoes[i] = new JRadioButton(values[i]);
			rbOpcoes[i].setBackground(new Color(180, 205, 205));
			bgOpcoes.add(rbOpcoes[i]);
		}
		
		this.setTitle("Exercicio 2");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));
		
		lblTemperatura.setBounds(20, 20, 100, 25);
		tfTemperatura.setBounds(100, 20, 150, 25);
		
		for(int i=0; i<rbOpcoes.length; i++)
			rbOpcoes[i].setBounds(50, 70 + 25 * i, 200, 25);
		
		cp.add(lblTemperatura);
		cp.add(tfTemperatura);
		
		for(int i=0; i<rbOpcoes.length; i++)
			cp.add(rbOpcoes[i]);
	
		rbOpcoes[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calcularTemperatura(0);
			}
		});
		
		rbOpcoes[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calcularTemperatura(1);
			}
		});
		
		rbOpcoes[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calcularTemperatura(2);
			}
		});
		
		rbOpcoes[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calcularTemperatura(3);
			}
		});
		
		rbOpcoes[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calcularTemperatura(4);
			}
		});
		
		rbOpcoes[5].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calcularTemperatura(5);
			}
		});
	}
	
	private void calcularTemperatura(int op) {
		
		try {
		
			float n = Float.parseFloat(tfTemperatura.getText());
			double result=0;
			
			switch(op) {
			
				case 0:
					result = n * 1.8 + 32;
					break;
					
				case 1:
					result = (n - 32) / 1.8;
					break;
					
				case 2:
					result = n + 273.15;
					break;
					
				case 3:
					result = n - 273.15;
					break;
					
				case 4:
					result = (n + 459.67) / 1.8;
					break;
					
				case 5:
					result = n * 1.8 - 459.67;
					break;
					
				default:
					result = 0;
					break;
			}
			
			JOptionPane.showMessageDialog(this, "O resultado da operação é: " + result, "Resultado", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Números não válidos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Exercicio2().setVisible(true);
			}
			
		});

	}
	
}
