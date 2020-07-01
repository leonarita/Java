package guiPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Code07 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code07 frame = new Code07();
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
	public Code07() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Segmento a");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 26, 101, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Segmento b");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 69, 101, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Segmento c");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 110, 101, 20);
		contentPane.add(lblNewLabel_2);
		
		JSlider sliA = new JSlider();
		sliA.setMaximum(50);
		sliA.setValue(0);
		
		sliA.setBounds(121, 26, 200, 22);
		contentPane.add(sliA);
		
		JSlider sliB = new JSlider();
		sliB.setMaximum(50);
		sliB.setValue(0);
		
		sliB.setBounds(121, 69, 200, 22);
		contentPane.add(sliB);
		
		JSlider sliC = new JSlider();
		sliC.setMaximum(50);
		sliC.setValue(0);
		
		sliC.setBounds(121, 112, 200, 22);
		contentPane.add(sliC);
		
		JLabel lblA = new JLabel("0");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblA.setBounds(331, 26, 61, 20);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("0");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblB.setBounds(331, 69, 61, 20);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("0");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblC.setBounds(331, 110, 61, 20);
		contentPane.add(lblC);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Code07.class.getResource("/images/matematica (1).png")));
		label.setBounds(386, 32, 93, 98);
		contentPane.add(label);
		
		JButton btnVerificar = new JButton("Verificar");
		
		btnVerificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVerificar.setBounds(22, 185, 112, 40);
		contentPane.add(btnVerificar);
		
		JPanel panel = new JPanel();
		panel.setBounds(155, 159, 332, 111);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStatus = new JLabel("New label");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(new Color(30, 144, 255));
		lblStatus.setBackground(Color.BLACK);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(58, 10, 197, 34);
		panel.add(lblStatus);
		
		JLabel lblTipo = new JLabel("New label");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setForeground(new Color(255, 0, 0));
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipo.setBounds(58, 53, 197, 34);
		panel.add(lblTipo);
		
		panel.setVisible(false);
		
		sliA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblA.setText(Integer.toString(sliA.getValue()));
			}
		});
		
		sliB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblB.setText(Integer.toString(sliB.getValue()));
			}
		});
		
		sliC.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblC.setText(Integer.toString(sliC.getValue()));
			}
		});
		
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = sliA.getValue();
				int b = sliB.getValue();
				int c = sliC.getValue();
				
				if (a<b+c && b<a+c && c<a+b) {
					lblStatus.setText("Formam um triângulo!");
					
					if (a==b && b==c)
						lblTipo.setText("Equilátero");
					else if (a!=b && b!=c && a!=c)
						lblTipo.setText("Escaleno");
					else 
						lblTipo.setText("Isósceles");
				}
				else {
					lblStatus.setText("Não formam um triângulo!");
					lblTipo.setText("-----");
				}
				
				panel.setVisible(true);
			}
		});
	}
}
