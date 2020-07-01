package guiPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Code02 extends JFrame {

	private JPanel contentPane;
	private JTextField txtN2;
	private JTextField txtN1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code02 frame = new Code02();
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
	public Code02() {
		setTitle("Soma Simples");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtN2 = new JTextField();
		txtN2.setBounds(162, 110, 77, 45);
		contentPane.add(txtN2);
		txtN2.setColumns(10);
		
		txtN1 = new JTextField();
		txtN1.setColumns(10);
		txtN1.setBounds(37, 110, 77, 45);
		contentPane.add(txtN1);
		
		JLabel lblNewLabel = new JLabel("+");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(115, 114, 47, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblRes = new JLabel("0");
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRes.setBounds(343, 114, 47, 31);
		contentPane.add(lblRes);
		
		JButton btnSoma = new JButton("=");
		btnSoma.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int n1 = Integer.parseInt(txtN1.getText());
				int n2 = Integer.parseInt(txtN2.getText());
				
				lblRes.setText(Integer.toString(n1+n2));
			}
		});
		btnSoma.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSoma.setBounds(259, 114, 65, 31);
		contentPane.add(btnSoma);
	}
}
