package aula12.view.cargo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import aula12.controller.CargoController;

@SuppressWarnings("serial")
public class CargoCadastro extends JDialog {
	private JLabel lbTitulo, lbDescricao, lbDepartamento;
	private JTextField tfDescricao, tfDepartamento;
	private JButton btCadastrar;
	private Container cp;
	
	private CargoController cc;
	
	public CargoCadastro() {
		// Instanciação e configuração dos componentes de interface.
		setTitle("Cadastro de Cargos"); // Título da janela.
		setSize(500, 250); // Tamanho da janela em pixels.
		setLocationRelativeTo(null); // Centraliza a janela na tela.
		setModal(true); // Torna a janela "modal" (janela que não permite acesso a outras janelas abertas).
				
		this.lbTitulo = new JLabel("Cadastro de Cargos");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19)); // Ajusta a fonte do JLabel.
		
		this.lbDescricao = new JLabel("Descrição");
		this.lbDepartamento = new JLabel("Departamento");
		this.tfDescricao = new JTextField();
		this.tfDepartamento = new JTextField();
		
		btCadastrar = new JButton("Cadastrar");

		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));
		
		lbTitulo.setBounds(125, 10, 300, 25);
		lbDescricao.setBounds(20, 50, 100, 25);
		tfDescricao.setBounds(100, 50, 360, 25);
		lbDepartamento.setBounds(20, 90, 100, 25);
		tfDepartamento.setBounds(100, 90, 360, 25);
		btCadastrar.setBounds(200, 150, 100, 25);
		
		cp.add(lbTitulo);
		cp.add(lbDescricao);
		cp.add(lbDepartamento);
		cp.add(tfDescricao);
		cp.add(tfDepartamento);
		cp.add(btCadastrar);
		
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btCadastrarAction();
			}
		});
	}
	
	private void btCadastrarAction() {
		cc = new CargoController();
		
		String response = cc.insere(tfDescricao.getText(), lbDepartamento.getText());
		
		if(response == null) {
			JOptionPane.showMessageDialog(this, "Cargo cadastrado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
		}
		else
			JOptionPane.showMessageDialog(this, response, "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	
}
