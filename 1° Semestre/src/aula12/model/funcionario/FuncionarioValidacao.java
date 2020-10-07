package aula12.model.funcionario;

import java.util.ArrayList;

public class FuncionarioValidacao {
	private static ArrayList<String> erros; // ArrayList para armazenar as mensagens de erro.
	
	// Valida os dados informados conforme as regras abaixo.
	public static ArrayList<String> validaFuncionario(Funcionario funcionario){
		erros = new ArrayList<>();
		
		// Valida��o do campo Nome.
		if (funcionario.getNome() != null) {
			if (funcionario.getNome().length() < 5 || funcionario.getNome().length() > 100)
				erros.add("O Nome deve ter entre 5 e 100 caracteres!");
		} else {
			erros.add("O Nome n�o foi informado!");
		}
		
		// Valida��o do campo Sal�rio.
		if (funcionario.getSalario() != null) {
			if (funcionario.getSalario().doubleValue() < 1000 || funcionario.getSalario().doubleValue() > 10000)
				erros.add("O Sal�rio deve ser de R$ 1.000,00 � R$ 10.000,00!");
		} else
			erros.add("O Sal�rio n�o foi informado!");
		
		// Valida��o do campo Cargo (para o caso de n�o existirem cargos cadastrados).
		if (funcionario.getCargo() == null)
			erros.add("O Cargo n�o foi informado!");
		
		// O campo Sexo n�o necessita de valida��o, pois seus valores s�o predefinidos.
		// O campo Plano de Sa�de n�o necessita de valida��o, pois seus valores s�o booleanos (true ou false).
		
		return erros; // Retorna o ArrayList contendo as mensagens de erro.
	}
}