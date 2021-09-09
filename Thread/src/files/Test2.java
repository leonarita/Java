package files;

import java.math.BigDecimal;
import java.util.List;

public class Test2 {
	
	public static void main(String[] args) {
		List<BigDecimal> valoresDeTeste = List.of(new BigDecimal(100), new BigDecimal(50), new BigDecimal(20), new BigDecimal(10));
		
		for(BigDecimal valor : valoresDeTeste) {
			System.out.println("TESTE PARA " + valor);
			
			for(int i=0; i<=5; i++) {
				System.out.println("\tCom " + i + " parcela(s) : R$ " + calcularValorComDesconto(i, valor));
			}
			
			System.out.println("");
		}
	}
	
	public static BigDecimal calcularValorComDesconto(int quantidadeParcelas, BigDecimal valorDaCompra) {
		Integer porcentagemDeDesconto = buscarDescontoAPartirDaQuantidadeDeParcelas(quantidadeParcelas);
		BigDecimal desconto = new BigDecimal(porcentagemDeDesconto).divide(new BigDecimal(100));
		return valorDaCompra.subtract(valorDaCompra.multiply(desconto));
	}
	
	public static Integer buscarDescontoAPartirDaQuantidadeDeParcelas(int quantidadeParcelas) {
		switch(quantidadeParcelas) {
			case 1: return 10;
			case 2: return 8;
			case 3: return 6;
			case 4: return 4;
			case 5: return 2;
			default: return 0;
		}
	}

}
