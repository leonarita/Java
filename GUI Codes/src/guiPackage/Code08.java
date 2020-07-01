package guiPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Code08 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code08 frame = new Code08();
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
	public Code08() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContagem = new JLabel("Contagem");
		lblContagem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContagem.setBounds(31, 32, 68, 19);
		contentPane.add(lblContagem);
		
		JLabel lblCont = new JLabel("");
		lblCont.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCont.setBounds(109, 32, 296, 19);
		contentPane.add(lblCont);
		
		JButton btnNewButton = new JButton("Contar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int c = 0;
				String contagem = "";
				
				while (c < 5) {
					contagem += c + " ";
					c++;
				}
				
				lblCont.setText(contagem);
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(127, 81, 140, 33);
		contentPane.add(btnNewButton);
	}

}
