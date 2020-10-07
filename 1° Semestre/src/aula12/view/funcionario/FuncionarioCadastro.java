package aula12.view.funcionario;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import aula12.controller.CargoController;
import aula12.controller.FuncionarioController;
import aula12.model.cargo.Cargo;

@SuppressWarnings("serial")
public class FuncionarioCadastro extends JDialog {
	private JLabel lbTitulo, lbNome, lbSexo, lbSalario, lbCargo;
	private JTextField tfNome;
	private JFormattedTextField tfSalario;
	private static final String valSexo[] = {"Masculino", "Feminino"}; // Valores dos JRadioButtons.
	private JRadioButton rbSexo[];
	private ButtonGroup bgSexo; // Grupo de bot�es para agrupar os JRadioButtons.
	private JComboBox<Cargo> cbCargo;
	private JCheckBox ckPlanoSaude;
	private JButton btCadastrar;
	private Container cp; // Container para organizar os componentes na janela.	
	private FuncionarioController fc;
	private CargoController cc;

	public FuncionarioCadastro() { // Construtor.
		// Instancia��o e configura��o dos componentes de interface.
		setTitle("Cadastro de Funcion�rios"); // T�tulo da janela.
		setSize(500, 335); // Tamanho da janela em pixels.
		setLocationRelativeTo(null); // Centraliza a janela na tela.
		setModal(true); // Torna a janela "modal" (janela que n�o permite acesso a outras janelas abertas).
		
		lbTitulo = new JLabel("Cadastro de Funcion�rios");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19)); // Ajusta a fonte do JLabel.
		
		lbNome = new JLabel("Nome");
		lbSexo = new JLabel("Sexo");
		lbSalario = new JLabel("Sal�rio (R$)");
		lbCargo = new JLabel("Cargo");
		
		tfNome = new JTextField();
		
        tfSalario = new JFormattedTextField(); // Campo de texto que permite definir m�scaras de entrada de dados.
		// Inclui uma m�scara de entrada no campo Sal�rio.
		DecimalFormat df = new DecimalFormat("##,##0.00"); // #: d�gitos opcionais; 0: d�gitos obrigat�rios.
        NumberFormatter nf = new NumberFormatter(df);
        nf.setFormat(df); // Define o formato num�rico, conforme a m�scara configurada.
        nf.setAllowsInvalid(false); // Impede que o usu�rio digite caracteres n�o compat�veis com a m�scara definida.
        // Associa a m�scara configurada ao JFormattedTextField.
        tfSalario.setFormatterFactory(new DefaultFormatterFactory(nf));
		
		rbSexo = new JRadioButton[2];
		bgSexo = new ButtonGroup();
		for (int i = 0; i < rbSexo.length; i++){
			// Adiciona os valores "Masculino" e "Feminino" aos JRadioButtos.
			rbSexo[i] = new JRadioButton(valSexo[i]); 
			rbSexo[i].setBackground(new Color(180, 205, 205)); // Cor de fundo dos JRadioButtons.
			bgSexo.add(rbSexo[i]); // Adiciona os JRadioButtons ao ButtonGroup.
		}
		rbSexo[0].setSelected(true); // Faz com que o JRadioButton "Masculino" fique marcado.
		
		ckPlanoSaude = new JCheckBox("Possui Plano de Sa�de");
		ckPlanoSaude.setBackground(new Color(180, 205, 205)); // Cor de fundo do JCheckBox.
		
		cbCargo = new JComboBox<>();
		cc = new CargoController();
		// Retorna um ArrayList de objetos Cargo, contendo o Id e a Descri��o dos cargos cadastrados.
		ArrayList<Cargo> cargos = cc.recuperaCargos();	
		if (cargos != null) { // Se existir pelo menos um cargo cadastrado.
			for (Cargo c : cargos)
				// O m�todo addItem adiciona o objeto Cargo (contendo os atributos Id e Descri��o) ao JComboBox. Ao ser carregado,
				// o JComboBox chama automaticamente o m�todo toString dos objetos Cargo para convert�-los para String, pois o
				// dado a ser exibido no JComboBox deve ser deste tipo. Como o m�todo toString foi sobrescrito na classe Cargo, 
				// de modo a retornar a descri��o do cargo, � esta a informa��o que ser� exibida no JComboBox.
				cbCargo.addItem(c); 
		} else { // Se n�o existir nenhum cargo cadastrado.
			JOptionPane.showMessageDialog(this, "N�o existem cargos cadastrados!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		btCadastrar = new JButton("Cadastrar");

		cp = getContentPane(); // Instancia o container da janela.
		cp.setLayout(null); // Configura o layout do container como nulo.
		cp.setBackground(new Color(180, 205, 205)); // Configura a cor de fundo do container.

		// Posicionamento dos componentes de interface na janela.
		lbTitulo.setBounds(125, 10, 300, 25); // x, y, largura, altura.
		lbNome.setBounds(20, 50, 100, 25);
		tfNome.setBounds(100, 50, 360, 25);
		lbSexo.setBounds(20, 90, 100, 25);
		rbSexo[0].setBounds(100, 90, 100, 25);
		rbSexo[1].setBounds(200, 90, 100, 25);
		lbSalario.setBounds(20, 130, 100, 25);
		tfSalario.setBounds(100, 130, 100, 25);
		lbCargo.setBounds(20, 170, 100, 25);
		cbCargo.setBounds(100, 170, 220, 25);
		ckPlanoSaude.setBounds(16, 210, 250, 25);
		btCadastrar.setBounds(200, 250, 100, 25);

		// Adi��o dos componentes de interface ao container.
		cp.add(lbTitulo);
		cp.add(lbNome);
		cp.add(tfNome);
		cp.add(lbSexo);
		cp.add(rbSexo[0]);
		cp.add(rbSexo[1]);
		cp.add(lbSalario);
		cp.add(tfSalario);
		cp.add(lbCargo);
		cp.add(cbCargo);
		cp.add(ckPlanoSaude);
		cp.add(btCadastrar);

		// Declara��o do processador de evento referente ao clique no bot�o Cadastrar.
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btCadastrarAction();
			}
		});
	} // Final do construtor.

	private void btCadastrarAction() { // M�todo acionado pelo clique no bot�o Cadastrar.
		fc = new FuncionarioController();
		String sexo = "";
		for (JRadioButton rb : rbSexo) // Recupera o texto do JRadionButton selecionado.
			if (rb.isSelected())
				sexo = rb.getText();
		// Envia os dados do funcion�rio (informados no formul�rio) ao controller. 
		// O controller retorna ent�o um ArrayList contendo os erros de valida��o encontrados. 
		ArrayList<String> erros = fc.insere(tfNome.getText(),
											sexo,
											tfSalario.getText().replace(".", "").replace(",", "."),
				                            ckPlanoSaude.isSelected(),
				                            (Cargo) cbCargo.getSelectedItem());

		if (erros.get(0) == null) { // Se o primeiro elemento do ArrayList for null.
			JOptionPane.showMessageDialog(this, "Funcion�rio cadastrado com sucesso!", 
					                      "Informa��o", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false); // Fecha a janela.
		} else { // Se o primeiro elemento do ArrayList n�o for null.
			String mensagem = "Erro(s) encontrado(s):\n";
			for (String e : erros) // Cria uma mensagem contendo todos os erros armazenados no ArrayList.
				mensagem = mensagem + " * " + e + "\n";
			JOptionPane.showMessageDialog(this, mensagem, "Erros", JOptionPane.ERROR_MESSAGE);
		}
	}
}