package testes.annotations.v2;

public interface Pessoa {
	
	@ReadCharacteres(min = 1, max = 20)
	default
	String getName() {
		return "";
	}
	
	@ReadCharacteres(min = 21, max = 23)
	default
	String getValue() {
		return "";
	}

}
