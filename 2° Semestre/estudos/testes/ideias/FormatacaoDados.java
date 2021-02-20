package testes.ideias;

public class FormatacaoDados {
	
	public static void main (String[] args) {
		
		System.out.println(formatCpf("01234567890"));
		System.out.println(formatCpf("012.345.678-90"));
		
		System.out.println("");
		System.out.println(unformatCpf("01234567890"));
		System.out.println(unformatCpf("012.345.678-90"));
		
		System.out.println("");
		System.out.println(formatMoney("00"));
		System.out.println(formatMoney("000"));
		System.out.println(formatMoney("0000"));
		System.out.println(formatMoney("00000"));
		System.out.println(formatMoney("000000"));
		System.out.println(formatMoney("0000000"));
		System.out.println(formatMoney("00000000"));
		System.out.println(formatMoney("99912783467863483456789"));
		
	}
	
	public static String formatCpf(String cpf) {
		
		cpf = unformatCpf(cpf);
		
		cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
		
		return cpf;
	}
	
	public static String unformatCpf(String cpf) {
		return cpf.replace(".", "").replace("-", "");
	}
	
	public static String formatMoney(String value) {
		
		int pointsQtd = (int) (Math.floor(value.length() - 3)/3);
		
		value = value.substring(0, value.length() - 2) + "," + value.substring(value.length() - 2, value.length());
		
		for(int i=0; i<pointsQtd; i++) {
			
			value = 
					value.substring(0, value.length() - (3 + (i) + 3 * (i + 1))) 
					+ "." 
					+ value.substring(value.length() - (3 + (i) + 3 * (i + 1)), value.length());
		}
		
		if(value.startsWith(","))
			value = 0 + value;
		
		return "R$ " + value;
	}

}
