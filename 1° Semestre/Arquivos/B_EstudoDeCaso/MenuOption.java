package B_EstudoDeCaso;

public enum MenuOption {

	// declara o conte�do do tipo enum
	ZERO_BALANCE(1), CREDIT_BALANCE(2), DEBIT_BALANCE(3), END(4);
 
	// op��o atual de menu
	private final int value; 

	// construtor
	private MenuOption(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
