package projeto.estacionamento.utils;

import projeto.estacionamento.Main;

public class Mensagens {
	
	public static final String PULAR_LINHA = "\n";
	public static final String ESPACAMENTO = "\t";

	public static String getMensagem(String mensagem, int espacamentos) {
		return ESPACAMENTO.repeat(espacamentos) + mensagem;
	}
	
	public static String getMensagem(String mensagem, int espacamentos, int pularLinha) {
		return PULAR_LINHA.repeat(pularLinha) + getMensagem(mensagem, espacamentos);
	}
	
	public static boolean confirm() {
		do {
			System.out.print(getMensagem("Deseja mesmo excluir? [S/N] : ", 3));
			String resp = Main.scanner.nextLine();
			
			if(resp.equalsIgnoreCase("S"))
				return true;
			else if(resp.equalsIgnoreCase("N"))
				return false;
		}
		while(true);
	}

}
