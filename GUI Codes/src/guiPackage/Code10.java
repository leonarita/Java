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
import java.awt.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Code10 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code10 frame = new Code10();
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
	public Code10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnicio = new JLabel("\u00CDnicio");
		lblnicio.setHorizontalAlignment(SwingConstants.TRAILING);
		lblnicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnicio.setBounds(10, 10, 61, 20);
		contentPane.add(lblnicio);
		
		JLabel lblNewLabel_1 = new JLabel("Fim");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 53, 61, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Passo");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 94, 61, 20);
		contentPane.add(lblNewLabel_2);
		
		JSlider sliA = new JSlider();
		sliA.setMaximum(20);
		
		sliA.setValue(0);
		sliA.setBounds(81, 10, 200, 22);
		contentPane.add(sliA);
		
		JSlider sliB = new JSlider();
		sliB.setMaximum(20);
		
		sliB.setValue(0);
		sliB.setBounds(81, 53, 200, 22);
		contentPane.add(sliB);
		
		JSlider sliC = new JSlider();
		sliC.setMinimum(-20);
		sliC.setMaximum(20);
		sliC.setValue(0);
		sliC.setBounds(81, 96, 200, 22);
		contentPane.add(sliC);
		
		JLabel lblC = new JLabel("0");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblC.setBounds(291, 94, 32, 20);
		contentPane.add(lblC);
		
		JLabel lblA = new JLabel("0");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblA.setBounds(291, 10, 32, 20);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("0");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblB.setBounds(291, 53, 32, 20);
		contentPane.add(lblB);
		
		List list = new List();
		list.setBounds(333, 17, 108, 161);
		contentPane.add(list);
		
		JButton btnContar = new JButton("Contar");
		
		btnContar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnContar.setBounds(128, 145, 132, 33);
		contentPane.add(btnContar);
		
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
		
		btnContar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = sliA.getValue();
				int f = sliB.getValue();
				int p = sliC.getValue();
				
				DefaultListModel lista = new DefaultListModel();
				
				for (int c=1; c<=f; c+=p) {
					lista.addElement(c);
					list.add(Integer.toString(c));
				}
			}
		});
	}
}
