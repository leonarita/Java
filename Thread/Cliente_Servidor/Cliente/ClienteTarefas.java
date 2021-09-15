package Cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 12345);
		System.out.println("Conexão Estabelecida");
				
		Thread threadEnviaComando = new Thread(() -> {
			
			try (Scanner teclado = new Scanner(System.in); PrintStream saida = new PrintStream(socket.getOutputStream())) {
				System.out.println("Pode enviar comandos!");
				
				while (teclado.hasNextLine()) {
					String linha = teclado.nextLine();
					
					if (linha.trim().equals(""))
						break;
					saida.println(linha);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		
		Thread threadRecebeResposta = new Thread(() -> {
			try(Scanner respostaServidor = new Scanner(socket.getInputStream())) {
				System.out.println("Recebendo dados do servidor");
				
				while (respostaServidor.hasNextLine()) {
					String linha = respostaServidor.nextLine();
					System.out.println(linha);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		threadRecebeResposta.start();
		threadEnviaComando.start();
		
		//thread main espera
		threadEnviaComando.join();
		System.out.println("Fechando o socket do cliente");
		socket.close();
		
	}
}
