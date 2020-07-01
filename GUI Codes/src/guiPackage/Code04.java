package guiPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Code04 extends JFrame {

	private JPanel contentPane;
	private JTextField txtResto;
	private JTextField txtCubo;
	private JTextField txtRaizQ;
	private JTextField txtRaizC;
	private JTextField txtVal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code04 frame = new Code04();
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
	public Code04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informe um valor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 23, 134, 36);
		contentPane.add(lblNewLabel);
		
		JSpinner spValor = new JSpinner();
		spValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spValor.setBounds(154, 29, 77, 26);
		contentPane.add(spValor);
		
		JButton btnCalcular = new JButton("Calcular");
		
		
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCalcular.setBounds(264, 23, 134, 36);
		contentPane.add(btnCalcular);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Code04.class.getResource("/images/calc_calculator_10824 (1).png")));
		label.setBounds(10, 121, 128, 128);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(138, 84, 314, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRestoDaDiviso = new JLabel("Resto da divis\u00E3o por 2");
		lblRestoDaDiviso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRestoDaDiviso.setBounds(10, 20, 148, 19);
		panel.add(lblRestoDaDiviso);
		lblRestoDaDiviso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtResto = new JTextField();
		txtResto.setBounds(168, 19, 119, 26);
		panel.add(txtResto);
		txtResto.setEditable(false);
		txtResto.setColumns(10);
		
		txtCubo = new JTextField();
		txtCubo.setBounds(168, 55, 119, 26);
		panel.add(txtCubo);
		txtCubo.setEditable(false);
		txtCubo.setColumns(10);
		
		JLabel lblElevadoAoCubo = new JLabel("Elevado ao cubo");
		lblElevadoAoCubo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblElevadoAoCubo.setBounds(39, 49, 119, 36);
		panel.add(lblElevadoAoCubo);
		lblElevadoAoCubo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtRaizQ = new JTextField();
		txtRaizQ.setBounds(168, 91, 119, 26);
		panel.add(txtRaizQ);
		txtRaizQ.setEditable(false);
		txtRaizQ.setColumns(10);
		
		txtRaizC = new JTextField();
		txtRaizC.setBounds(168, 127, 119, 26);
		panel.add(txtRaizC);
		txtRaizC.setEditable(false);
		txtRaizC.setColumns(10);
		
		JLabel lblRaizCbida = new JLabel("Raiz c\u00FAbida");
		lblRaizCbida.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRaizCbida.setBounds(74, 119, 84, 36);
		panel.add(lblRaizCbida);
		lblRaizCbida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtVal = new JTextField();
		txtVal.setBounds(168, 165, 119, 26);
		panel.add(txtVal);
		txtVal.setEditable(false);
		txtVal.setColumns(10);
		
		JLabel lblValorAbsoluto = new JLabel("Valor absoluto");
		lblValorAbsoluto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblValorAbsoluto.setBounds(56, 157, 102, 36);
		panel.add(lblValorAbsoluto);
		lblValorAbsoluto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblRaizQuadrada = new JLabel("Raiz quadrada");
		lblRaizQuadrada.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRaizQuadrada.setBounds(56, 83, 102, 36);
		panel.add(lblRaizQuadrada);
		lblRaizQuadrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResultado.setBounds(33, 69, 66, 36);
		contentPane.add(lblResultado);
		
		panel.setVisible(false);
		
		btnCalcular.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int num = Integer.parseInt(spValor.getValue().toString());
				
				if (num%2==0)
					lblResultado.setText("Par");
				else
					lblResultado.setText("Ímpar");
				
				txtResto.setText(Integer.toString(num%2));
				txtCubo.setText(Double.toString(Math.pow(num, 3)));
				txtRaizQ.setText(String.format("%.2f", Math.sqrt(num)));
				txtRaizC.setText(String.format("%.2f", Math.cbrt(num)));
				txtVal.setText(Integer.toString(Math.abs(num)));
				
				panel.setVisible(true);
			}
		});
	}
}
