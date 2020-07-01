package guiPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class Code05 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code05 frame = new Code05();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Code05() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("");
		lbl.setIcon(new ImageIcon(Code05.class.getResource("/images/genio.png")));
		lbl.setBounds(238, 129, 299, 260);
		contentPane.add(lbl);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Code05.class.getResource("/images/balao-de-fala (1).png")));
		label_1.setBounds(68, 10, 394, 220);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(31, 279, 54, 27);
		contentPane.add(lblNewLabel);
		
		JSpinner spValor = new JSpinner();
		spValor.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spValor.setBounds(95, 281, 60, 27);
		contentPane.add(spValor);
		
		JButton btnPalpitar = new JButton("Palpite");
		
		btnPalpitar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPalpitar.setBounds(41, 316, 103, 27);
		contentPane.add(btnPalpitar);
		
		JLabel lblFrase = new JLabel("Frase");
		lblFrase.setVerticalAlignment(SwingConstants.TOP);
		lblFrase.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFrase.setBounds(117, 65, 155, 77);
		contentPane.add(lblFrase);
		
		lblFrase.setText("<html>Vou pensar em um valor entre <strong>1 e 5</strong>. Tente adivinhar...</html>");
		
		btnPalpitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int valor=0;
				do {
					valor = (int) (Math.random() * (6-1));
				}
				while (valor>6 || valor<1);
								
				int num = Integer.parseInt(spValor.getValue().toString());
				
				String res = (num == valor) ? "<html>ACERTOU</html>!" : ("<html>ERROU! Pensei no valor " + valor + "</html>");
				
				lblFrase.setFont(new Font("Arial Black", Font.PLAIN, 18));
				lblFrase.setText(res);
				
				if (JOptionPane.showConfirmDialog(null, "Deseja tentar novamente?", "Questão", JOptionPane.YES_NO_OPTION) == 0)
					lblFrase.setText("<html>Vou pensar em um valor entre <strong>1 e 5</strong>. Tente adivinhar...</html>");
			}
		});
	}
}
