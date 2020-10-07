package aula12.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import aula12.view.cargo.CargoCadastro;
import aula12.view.funcionario.*;

@SuppressWarnings("serial")
public class Index extends JFrame {
	private JMenuBar mbBarra; // Barra do menu.
	private JMenu mnCadastro; // Menu Cadastro.
	
	// Submenus e itens do menu Cadastro.
	private JMenu mnCadCargo; // Submenu Cargos do menu Cadastro.
	private JMenu mnCadFunc; // Submenu Funcionários do menu Cadastro.
	private JMenuItem miCadCargo[]; // Itens do submenu Cargos.
	private JMenuItem miCadFunc[]; // Itens do submenu Funcionarios.
	// Valores dos itens dos submenus Cargos e Funcionários.
	private static final String cadItens[] = {"Cadastrar", "Consultar"}; 
	private JMenuItem miCadSair; // Item Sair do menu Cadastro.
	
	public Index() { // Construtor.	
		// Instanciação dos componentes de interface.
		mbBarra = new JMenuBar();
		mnCadastro = new JMenu("Cadastro");
		mnCadCargo = new JMenu("Cargos");
		mnCadFunc = new JMenu("Funcionários");
		miCadCargo = new JMenuItem[2];
		miCadFunc = new JMenuItem[2];
		miCadSair = new JMenuItem("Sair");

		// Configuração dos componentes de interface.
		setTitle("Sistema de Departamento Pessoal"); // Título da janela.
		setSize(500, 300); // Tamanho da janela em pixels.
		setLocationRelativeTo(null); // Centraliza a janela na tela.
		// Ao fechar a janela, libera todos os recursos usados pela aplicação.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		getContentPane().setBackground(new Color(180, 205, 205)); // Configura a cor de fundo do container.	
		for (int i = 0; i < 2; i++){
			miCadCargo[i] = new JMenuItem(cadItens[i]); // Configura os valores dos itens do submenu Cargos.
			mnCadCargo.add(miCadCargo[i]); // Adiciona os itens ao submenu Cargos.
			miCadFunc[i] = new JMenuItem(cadItens[i]); // Configura os valores dos itens do submenu Funcionários.
			mnCadFunc.add(miCadFunc[i]); // Adiciona os itens ao submenu Funcionários.
		}
		mnCadastro.add(mnCadCargo); // Adiciona o submenu Cargos ao menu Cadastro.
		mnCadastro.add(mnCadFunc); // Adiciona o submenu Funcionários ao menu Cadastro.
		mnCadastro.addSeparator(); // Adiciona uma linha separadora ao menu.
		mnCadastro.add(miCadSair); // Adiciona o item Sair ao menu Cadastro.
		mbBarra.add(mnCadastro); // Adiciona o menu Cadastro à barra de menus.
		setJMenuBar(mbBarra); // Adiciona a barra de menus à janela.
		
		miCadCargo[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { miCadCargcAction(); }
		});

		// Declaração do processador de evento referente ao clique no item Cadastrar do submenu Funcionários.
		miCadFunc[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { miCadFuncAction(); }
		});
		
		// Declaração do processador de evento referente ao clique no item Sair.
		miCadSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { miCadSairAction(); }
		});
	} // Final do construtor.
	
	private void miCadSairAction() { // Método acionado pelo clique no item Sair do menu Cadastro.	
		System.exit(0); // Fecha a aplicação.
	}
	
	private void miCadCargcAction() { // Método acionado pelo clique no item Cadastrar do submenu Funcionários.		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){ new CargoCadastro().setVisible(true); }});
	}
	
	private void miCadFuncAction() { // Método acionado pelo clique no item Cadastrar do submenu Funcionários.		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){ new FuncionarioCadastro().setVisible(true); }});
	}
	
	public static void main(String[] args) { // Início da aplicação.
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){ new Index().setVisible(true); }});
	}
}