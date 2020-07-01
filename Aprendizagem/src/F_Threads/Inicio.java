package F_Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

//Sincroniza��o de threads � um t�pico avan�ado!

public class Inicio {

	public static void main(String[] args) {
		
		Printer p1 = new Printer("Eduardo", 100, 20);
		Printer p2 = new Printer("M�nica", 100, 20);
		
		//run executa linearmente
/*		p1.run();
		p2.run();
*/
		//Inicia as threads efetivamente com start
		p1.start();
		p2.start();
		
		//join n�o permite o programa encerrar enquanto houver threads executando
		try {
			p1.join();
			p2.join();
		}
		catch (InterruptedException ex) {
			Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
