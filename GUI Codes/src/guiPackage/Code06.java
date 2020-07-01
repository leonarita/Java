package guiPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Code06 extends JFrame {

	private JPanel contentPane;
	private JTextField txtDelta;
	private JTextField txtRaiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code06 frame = new Code06();
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
	public Code06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner txtA = new JSpinner();
		
		txtA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtA.setBounds(50, 34, 46, 28);
		contentPane.add(txtA);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(85, 22, 68, 44);
		contentPane.add(lblNewLabel);
		
		JSpinner txtC = new JSpinner();
		
		txtC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtC.setBounds(217, 34, 46, 28);
		contentPane.add(txtC);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(169, 25, 68, 44);
		contentPane.add(lblNewLabel_1);
		
		JSpinner txtB = new JSpinner();
		
		txtB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtB.setBounds(136, 33, 47, 29);
		contentPane.add(txtB);
		
		JLabel lblNewLabel_1_1 = new JLabel("= 0");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(247, 25, 68, 44);
		contentPane.add(lblNewLabel_1_1);
		
		lblNewLabel.setText("<html>X<sup>2</sup> + </html>");
		lblNewLabel_1.setText("<html>X + </html>");
		lblNewLabel_1_1.setText("<html> = 0 </html>");
		
		JLabel lblNewLabel_2 = new JLabel("<html> &Delta; = </html>");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(48, 95, 46, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblB = new JLabel("<html> B </html>");
		lblB.setForeground(Color.RED);
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblB.setBounds(86, 99, 46, 36);
		contentPane.add(lblB);
		
		JLabel lblB_1 = new JLabel("<html> - 4 . </html>");
		lblB_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblB_1.setBounds(119, 99, 38, 36);
		contentPane.add(lblB_1);
		
		JLabel lblA = new JLabel("<html> A </html>");
		lblA.setForeground(Color.RED);
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblA.setBounds(154, 99, 38, 36);
		contentPane.add(lblA);
		
		JLabel lblC = new JLabel("<html> C </html>");
		lblC.setForeground(Color.RED);
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblC.setBounds(186, 99, 38, 36);
		contentPane.add(lblC);
		
		JLabel lblB_1_1_2 = new JLabel("<html> . </html>");
		lblB_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblB_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblB_1_1_2.setBounds(175, 99, 38, 36);
		contentPane.add(lblB_1_1_2);
		
		JLabel lblB_2 = new JLabel("<html> <sup> 2 </sup> </html>");
		lblB_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblB_2.setBounds(105, 95, 46, 36);
		contentPane.add(lblB_2);
		
		JButton btnCalculardelta = new JButton("<html> Calcular &Delta; </html>");
		
		btnCalculardelta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCalculardelta.setBounds(247, 99, 130, 41);
		contentPane.add(btnCalculardelta);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 163, 385, 114);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblValorDedelta = new JLabel("<html> Valor de &Delta; </html>");
		lblValorDedelta.setHorizontalAlignment(SwingConstants.TRAILING);
		lblValorDedelta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorDedelta.setBounds(29, 34, 105, 13);
		panel.add(lblValorDedelta);
		
		JLabel lblTiposDeRaizes = new JLabel("<html> Tipos de Raizes </html>");
		lblTiposDeRaizes.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTiposDeRaizes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTiposDeRaizes.setBounds(29, 69, 105, 13);
		panel.add(lblTiposDeRaizes);
		
		txtDelta = new JTextField();
		txtDelta.setBounds(163, 29, 195, 27);
		panel.add(txtDelta);
		txtDelta.setColumns(10);
		
		txtRaiz = new JTextField();
		txtRaiz.setColumns(10);
		txtRaiz.setBounds(163, 68, 195, 27);
		panel.add(txtRaiz);
		
		txtA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblA.setText(txtA.getValue().toString());
			}
		});
		
		txtB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblB.setText(txtB.getValue().toString());
			}
		});
		
		txtC.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblC.setText(txtC.getValue().toString());
			}
		});
		
		btnCalculardelta.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int a = Integer.parseInt(txtA.getValue().toString());
				int b = Integer.parseInt(txtB.getValue().toString());
				int c = Integer.parseInt(txtC.getValue().toString());
				
				double d = (b * b) - ( 4 * a * c);
				txtDelta.setText(String.format("%.1f", d));
				
				if (d < 0) {
					txtRaiz.setText("Não há raizes reais!");
				}
				else if (d == 0)
					txtRaiz.setText("Há apenas uma raiz, e ela é real!");
				else
					txtRaiz.setText("Há raizes reais!");
				
				panel.setVisible(true);
			}
		});
		
		panel.setVisible(false);
	}
}
