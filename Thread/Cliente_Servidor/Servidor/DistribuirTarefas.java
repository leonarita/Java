package Servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	
	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		try (
				Scanner entradaCliente = new Scanner(socket.getInputStream()); 
				PrintStream saidaCliente = new PrintStream(socket.getOutputStream())
		) {
			System.out.println("Distribuindo as tarefas para o cliente: " + socket);
			
			while (entradaCliente.hasNextLine()) {
				String comando = entradaCliente.nextLine();
				System.out.println("Comando: " + comando);

				switch (comando) {
				
					case "ola":
						saidaCliente.println(" mundo ");
						break;

					case "palmeiras":
						saidaCliente.println(" não tem mundial ");
						break;
					
					default:
						saidaCliente.println("comando não encontrado ");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
