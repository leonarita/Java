package aula17.exercicio2;

public class Caso1 {
	
	// EXTRAIR MÉTODO
	
	private String _nome;
	private double _valor;
	
	public void imprimirSaldo(int conta)
	{
		imprimirCabecalho(conta);
		imprimirDetalhes();
	}
	public void imprimirCabecalho(int conta)
	{
		Response.write("Saldo da conta do cliente: " + conta);
		Response.write("Cliente VIP");
	}

	public void imprimirDetalhes()
	{
		Response.write("Nome: " + _nome);
		Response.write("Valor: " + _valor);
	}
	
	public static class Response {
		
		public static void write(String value) {
			System.out.println(value);
		}
	}

}
