package aula11.exercicio4.versao2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	private JMenuBar mbBarra;

	private JMenu mnCadastro;
	private JMenu mnClientes;
	
	private JMenuItem miClientes[];
	private JMenuItem miFornecedor;
	private JMenuItem miSair;
	
	private static final String valuesClientes[] = { "Pessoa Física", "Pessoa Jurídica" };
	
	public Menu() {
		
		mbBarra = new JMenuBar();
		mnCadastro = new JMenu("Cadastro");
		mnClientes = new JMenu("Clientes");
		miClientes = new JMenuItem[2];
		miFornecedor = new JMenuItem("Fornecedor");
		miSair = new JMenuItem("Sair");
		
		for (int i=0; i<miClientes.length; i++) {
			miClientes[i] = new JMenuItem(valuesClientes[i]);
			mnClientes.add(miClientes[i]);
		}
		
		mnCadastro.add(mnClientes);
		mnCadastro.add(miFornecedor);
		mnCadastro.addSeparator();
		mnCadastro.add(miSair);
		mbBarra.add(mnCadastro);
		this.setJMenuBar(mbBarra);
		
		mnClientes.setMnemonic('C');
		miFornecedor.setMnemonic('F');
		miSair.setMnemonic('S');
		
		this.setTitle("Exercicio 4");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(180, 205, 205));
		
		miFornecedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telaFornecedor();
			}
		});
		
		miClientes[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telaPessoaFisica();
			}
		});
		
		miClientes[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telaPessoaJuridica();
			}
		});
	}
	
	private void telaPessoaFisica() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new TelaPessoaFisica().setVisible(true);
			}
		});

	}
	
	private void telaPessoaJuridica() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new TelaPessoaJuridica().setVisible(true);
			}
		});

	}
	
	private void telaFornecedor() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new TelaFornecedor().setVisible(true);
			}
		});

	}
}
