package Cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("localhost", 12345);
		
		System.out.println("Conexão Estabelecida");
				
		Thread threadEnviaComando = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					
					System.out.println("Pode enviar comandos!");
					PrintStream saida = new PrintStream(socket.getOutputStream());
					 
					//enviar dados para o servidor
					Scanner teclado = new Scanner(System.in);
					
					while (teclado.hasNextLine()) {
						
						String linha = teclado.nextLine();
						
						if (linha.trim().equals(""))
							break;

						saida.println(linha);
					}
					
					saida.close();
					teclado.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		Thread threadRecebeResposta = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					System.out.println("Recebendo dados do servidor");
					Scanner respostaServidor;
					respostaServidor = new Scanner(socket.getInputStream());
					
					while (respostaServidor.hasNextLine()) {
						String linha = respostaServidor.nextLine();
						System.out.println(linha);
					}

					respostaServidor.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
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
