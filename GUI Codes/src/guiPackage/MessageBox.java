package guiPackage;

import javax.swing.JOptionPane;

public class MessageBox {

	public static void main (String[] args) {
		
		int n, s = 0;
		
		do {
			
			n = Integer.parseInt (
					JOptionPane.showInputDialog(null, "<html> Informe um n�mero: <br> <em>(Valor 0 interrompe) </em></html>"));
			
			s += n;
		}
		while (n != 0);
		
		JOptionPane.showMessageDialog(null, "<html>Resultado final: <br><hr><br>Somat�rio vale " + s + "</html>");
	}
	
}
