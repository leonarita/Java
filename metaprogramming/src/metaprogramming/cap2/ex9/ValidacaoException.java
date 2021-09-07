package metaprogramming.cap2.ex9;

import java.util.List;

@SuppressWarnings("serial")
public class ValidacaoException extends Exception{
	
	private List<Exception> erros;
	
	public ValidacaoException(List<Exception> erros) {
		this.erros = erros;
	}
	
	public List<Exception> getErros() {
		return erros;
	}

}
