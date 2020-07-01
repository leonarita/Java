package Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPrincipal extends JFrame {
	
    private Container contentPane; //entram componentes em fila
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnExemplos, mnAtividades;
    private JMenuItem miSair, miBotao, miEventoBotoes, miCaixa, CalcularProdutos; //miCaixa - caixa de opção
    
    public MenuPrincipal() {
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes() {
        setTitle ("Menu Principal");
        setBounds(0, 0, 800, 600);
        contentPane = getContentPane();
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu ("Arquivo");
        mnArquivo.setMnemonic('A');
        mnExemplos = new JMenu ("Exemplos");
        mnExemplos.setMnemonic('E');
        mnAtividades = new JMenu ("Atividades"); //
        mnAtividades.setMnemonic('B'); //
        
        miSair = new JMenuItem ("Sair", new ImageIcon("sair.PNG"));
        miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        miBotao = new JMenuItem ("Botão");
        miCaixa = new JMenuItem ("Caixa de opção"); //texto
        miEventoBotoes = new JMenuItem ("Evento Botoes"); //
      
        mnArquivo.add (miSair);
        mnExemplos.add (miBotao);
        mnExemplos.add (miCaixa);
        mnAtividades.add (miEventoBotoes);//
        mnBarra.add (mnArquivo);
        mnBarra.add (mnExemplos);
        mnBarra.add (mnAtividades); //
        setJMenuBar (mnBarra);
}
    private void definirEventos () {

    	miSair.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
                System.exit(0);
                
            }
        });
/*  
    	miBotao.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
                //
                GuiBotao botao = new GuiBotao();
                contentPane.removeAll();
                contentPane.add(botao);
                contentPane.validate();
            } 
        });
        
         miCaixa.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
               GuiCaixaOpcao caixa = new GuiCaixaOpcao();
               contentPane.removeAll();
               contentPane.add(caixa);
               contentPane.validate();
            } 
        });
*/
    }
    
    public static void abrir () {
        MenuPrincipal frame = new MenuPrincipal ();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation ((tela.width - frame.getSize().width) / 2,
        (tela.height - frame.getSize().height) / 2 );
        frame.setVisible(true);
    }

}