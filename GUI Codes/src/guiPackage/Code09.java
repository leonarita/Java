package guiPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Code09 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code09 frame = new Code09();
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
	public Code09() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spN = new JSpinner();
		
		spN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spN.setBounds(10, 20, 44, 27);
		contentPane.add(spN);
		
		JLabel label = new JLabel("! =");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(46, 23, 56, 19);
		contentPane.add(label);
		
		JLabel lblRes = new JLabel("1");
		lblRes.setForeground(new Color(255, 0, 0));
		lblRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRes.setBounds(94, 22, 63, 19);
		contentPane.add(lblRes);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(33, 72, 227, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Demonstrar");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(163, 18, 116, 28);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Code09.class.getResource("/images/sinal-de-aviso (1).png")));
		label_1.setBounds(278, 38, 32, 61);
		contentPane.add(label_1);
		
		spN.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			
				int n = Integer.parseInt(spN.getValue().toString());
				int f = 1;
				int c = n;
				
				while (c>=1)
				{
					f *= c;
					c--;
				}
				
				lblRes.setText(Integer.toString(f));
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n = Integer.parseInt(spN.getValue().toString());
				
				int num=0, fat=1;
				String formula = "";
				
				for (int c=n; c>1; c--) {
					fat *= c;
					formula += c + " x ";
				}
				
				formula += "1 = " + fat;
				textField.setText(formula);
			}
		});
		
	}

}
