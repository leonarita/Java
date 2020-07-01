package guiPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class Code03 extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdade;
	private JTextField txtSit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code03 frame = new Code03();
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
	public Code03() {
		setTitle("Calcular Idade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(2000, 1900, 2020, 1));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner.setBounds(177, 14, 62, 31);
		contentPane.add(spinner);
		
		JLabel lblNewLabel = new JLabel("Data de Nascimento");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(35, 14, 144, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int ano = Integer.parseInt(spinner.getValue().toString());
				int idade = 2020 - ano;
				txtIdade.setText(Integer.toString(idade));
				
				if (idade<16)
					txtSit.setText("Não pode votar!");
				else
					txtSit.setText((idade<18 || idade>60) ? "Voto facultativo!" : "Voto obrigatório!");
			}
		});
		btnCalcular.setIcon(new ImageIcon(Code03.class.getResource("/images/old-calculator_icon-icons.com_56065.png")));
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCalcular.setBounds(260, 12, 144, 41);
		contentPane.add(btnCalcular);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Code03.class.getResource("/images/user_person_customer_man_1532.png")));
		lblNewLabel_1.setBounds(296, 59, 161, 157);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdade.setBounds(34, 75, 56, 34);
		contentPane.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setEditable(false);
		txtIdade.setBounds(93, 80, 137, 29);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		txtSit = new JTextField();
		txtSit.setEditable(false);
		txtSit.setColumns(10);
		txtSit.setBounds(94, 136, 136, 29);
		contentPane.add(txtSit);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSituao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSituao.setBounds(20, 131, 71, 34);
		contentPane.add(lblSituao);
	}
}
