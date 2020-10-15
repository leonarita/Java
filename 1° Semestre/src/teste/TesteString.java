package teste;

public class TesteString {

	public static void main(String[] args) {
		
		String a1 = "12345678901234567890"; // 20 caracteres
		
		System.out.println(validar(a1, 10) + " -> " + validar(a1, 10).length());
		System.out.println(validar(a1, 20) + " -> " + validar(a1, 19).length());
		System.out.println(validar(a1, 20) + " -> " + validar(a1, 20).length());
		System.out.println(validar(a1, 20) + " -> " + validar(a1, 21).length());
		System.out.println(validar(a1, 30) + " -> " + validar(a1, 30).length());
		
		System.out.println(validar(null, 20));
		
		System.out.println("9AJDF734".toLowerCase());
	}
	
	public static String validar(String s, int n) {
		if (s == null)
			return s;
		else
			return s.substring(0, s.length() < n ? s.length() : n);
	}

}
