package exemplo01;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ArrancaServidor {
	
	public static void main(String argv[]) {
		try {
			Registry rgsty = LocateRegistry.createRegistry(1888);
			System.out.println("Arrancando servidor...");
			rgsty.rebind("ServidorMat_1", new ServidorMat());
		}
		catch (Exception e) {
			System.out.println("Ocorreu um problema no arranque do servidor.\n"+e.toString());
		}
	}
}