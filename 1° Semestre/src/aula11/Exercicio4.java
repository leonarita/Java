package aula11;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import aula11.exercicio4.versao2.Menu;

@SuppressWarnings("serial")
public class Exercicio4 extends JFrame {

	private JMenuBar mbBarra;

	private JMenu mnCadastro;
	private JMenu mnClientes;
	
	private JMenuItem miClientes[];
	private JMenuItem miFornecedor;
	private JMenuItem miSair;
	
	private static final String valuesClientes[] = { "Pessoa Física", "Pessoa Jurídica" };
	
	public Exercicio4() {
		
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
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Menu().setVisible(true);
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
	
	// Como as telas auxiliares são pertencentes à essa tela, declarei as classes dentro do escopo dessa classe 
	
	private class TelaPessoaFisica extends JDialog {
		
		private Container cp;

		public TelaPessoaFisica() {
			
			this.setTitle("Pessoa Física");
			this.setSize(200, 100);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.getContentPane().setBackground(new Color(180, 205, 205));
			
			cp = getContentPane();
			cp.setLayout(null);
			cp.setBackground(new Color(180, 205, 205));
			
			this.setModal(true);
			
		}
	}
	
	private class TelaPessoaJuridica extends JDialog {
		
		private Container cp;

		public TelaPessoaJuridica() {
			
			this.setTitle("Pessoa Jurídica");
			this.setSize(200, 100);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.getContentPane().setBackground(new Color(180, 205, 205));
			
			cp = getContentPane();
			cp.setLayout(null);
			cp.setBackground(new Color(180, 205, 205));
		
			this.setModal(true);
		}
	}

	
	private class TelaFornecedor extends JDialog {
		
		private Container cp;

		public TelaFornecedor() {
			
			this.setTitle("Fornecedor");
			this.setSize(200, 100);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.getContentPane().setBackground(new Color(180, 205, 205));
			
			cp = getContentPane();
			cp.setLayout(null);
			cp.setBackground(new Color(180, 205, 205));
		
			this.setModal(false);
		}
	}
}
