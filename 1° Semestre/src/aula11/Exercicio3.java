package aula11;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Exercicio3 extends JFrame {
	
	private Container cp;
	private JLabel lblValor, lbEstado, lbPostagem, lbResultados[];
	private JTextField tfValor;
	private JCheckBox ckFidelidade;
	private JComboBox<String> cbEstado;
	private ButtonGroup bgOpcoes; 
	private JRadioButton rbOpcoes[];
	private JButton btCalcular;

	private static String resultados[] = { "Valor do Produto: ", "Valor do Frete: ", "Valor Total: " };
	private static final String opcoes[] = { "Sedex", "Sedex 10" };
	private static final String estados[] = { "SP", "RG", "MG", "ES" };
		
	public Exercicio3() {
		lblValor = new JLabel("Valor do produto");
		lbPostagem = new JLabel("Tipo de postagem");
		tfValor = new JTextField();
		bgOpcoes = new ButtonGroup();
		lbEstado = new JLabel("Estado");
		ckFidelidade = new JCheckBox("Cliente com fidelidade");
		cbEstado = new JComboBox<>(estados);
		btCalcular = new JButton("Calcular");
		rbOpcoes = new JRadioButton[2];
		lbResultados = new JLabel[3];
		
		for(int i=0; i<rbOpcoes.length; i++) {
			rbOpcoes[i] = new JRadioButton(opcoes[i]);
			rbOpcoes[i].setBackground(new Color(180, 205, 205));
			bgOpcoes.add(rbOpcoes[i]);
		}
		
		for(int i=0; i<lbResultados.length; i++) {
			lbResultados[i]  = new JLabel(resultados[i]);
		}
		
		this.setTitle("Exercicio 3");
		this.setSize(600, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblValor.setBounds(20, 20, 150, 20);
		tfValor.setBounds(130, 20, 150, 20);
		ckFidelidade.setBounds(20, 60, 200, 20);
		lbEstado.setBounds(70, 100, 100, 20);
		cbEstado.setBounds(130, 100, 100, 20);
		lbPostagem.setBounds(20, 140, 100, 20);
		btCalcular.setBounds(60, 250, 150, 40);
		
		for(int i=0; i<lbResultados.length; i++)
			lbResultados[i].setBounds(350, 20 + 30 * i, 250, 20);
		
		for(int i=0; i<rbOpcoes.length; i++)
			rbOpcoes[i].setBounds(40, 170 + 30 * i, 250, 20);
		
		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));
		
		ckFidelidade.setBackground(new Color(180, 205, 205));
		
		cp.add(lblValor);
		cp.add(tfValor);
		cp.add(ckFidelidade);
		cp.add(lbEstado);
		cp.add(cbEstado);
		cp.add(lbPostagem);
		cp.add(btCalcular);
		
		for(int i=0; i<lbResultados.length; i++)
			cp.add(lbResultados[i]);
		
		for(int i=0; i<rbOpcoes.length; i++)
			cp.add(rbOpcoes[i]);
		
		btCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calcular();

			}
		});
		
//		cbEstado.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(cbEstado.getSelectedIndex());
//
//			}
//		});
	}
	
	private void calcular() {
		
		try {
			float n = Float.parseFloat(tfValor.getText());
			
			if(ckFidelidade.isSelected()) {
				n -= n/10;
			}
			
			float frete;
			
			switch (cbEstado.getSelectedIndex()) {
			
				case 0:
					frete = n * 10 / 100;
					break;
					
				case 1:
				case 2:
					frete = n * 15 / 100;
					break; 
				
				case 3:
					frete = n * 20 / 100;
					break;
				
				default:
					System.out.println(cbEstado.getSelectedIndex());
					frete = 0;
					break;
			}
			
			if(rbOpcoes[1].isSelected()) {
				frete = frete + frete * 20 / 100;
			}
			
			lbResultados[0].setText(resultados[0] + n);
			lbResultados[1].setText(resultados[1] + frete);
			lbResultados[2].setText(resultados[2] + (n + frete));
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Números não válidos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Exercicio3().setVisible(true);
			}
			
		});

	}

}
