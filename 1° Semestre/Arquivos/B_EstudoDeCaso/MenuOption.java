package B_EstudoDeCaso;

public enum MenuOption {

	// declara o conteúdo do tipo enum
	ZERO_BALANCE(1), CREDIT_BALANCE(2), DEBIT_BALANCE(3), END(4);
 
	// opção atual de menu
	private final int value; 

	// construtor
	private MenuOption(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
