package teste;

public class ValidacaoString {

	public static void main(String[] args) {

		if (!validateFirstName("Leonardoo"))
			System.out.println("Invalid first name");
		else if (!validateLastName("Narita"))
			System.out.println("Invalid last name");
		else if (!validateAddress("rua Legal"))
			System.out.println("Invalid address");
		else if (!validateCity("São Paulo"))
			System.out.println("Invalid city");
		else if (!validateState("SP"))
			System.out.println("Invalid state");
		else if (!validateZip("abc"))
			System.out.println("Invalid zip code");
		else if (!validatePhone("1111111111"))
			System.out.println("Invalid phone number");
		else
			System.out.println("Valid input. Thank you.");
	}
	
	public static boolean validateFirstName(String firstName) {
		return firstName.matches("[A-Z][a-zA-Z]*");
	}

	
	public static boolean validateLastName(String lastName) {
		return lastName.matches("[a-zA-z]+(['-][a-zA-Z]+)*");
	}

	public static boolean validateAddress(String address) {
		return address.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
	}

	public static boolean validateCity(String city) {
		return city.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
	}
	
	public static boolean validateState(String state) {
		return state.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
	}

	public static boolean validateZip(String zip) {
		return zip.matches("\\d{5}");
	}

	public static boolean validatePhone(String phone) {
		return phone.matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}");
	}

}
