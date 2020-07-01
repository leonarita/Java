package guiPackage;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Code01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code01 frame = new Code01();
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
	public Code01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClicar = new JButton("Clique em mim");
		
		btnClicar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClicar.setBounds(158, 182, 130, 32);
		contentPane.add(btnClicar);
		
		JLabel lblMensagem = new JLabel("Eis a mensagem");
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensagem.setBounds(158, 111, 130, 32);
		contentPane.add(lblMensagem);
		
		btnClicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblMensagem.setText("Olá, mundo!");
			}
		});
	}
}
