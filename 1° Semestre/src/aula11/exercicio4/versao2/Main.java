package aula11.exercicio4.versao2;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Menu().setVisible(true);
			}
			
		});

	}

}
