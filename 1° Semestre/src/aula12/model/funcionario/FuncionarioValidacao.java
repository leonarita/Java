package aula12.model.funcionario;

import java.util.ArrayList;

public class FuncionarioValidacao {
	private static ArrayList<String> erros; // ArrayList para armazenar as mensagens de erro.
	
	// Valida os dados informados conforme as regras abaixo.
	public static ArrayList<String> validaFuncionario(Funcionario funcionario){
		erros = new ArrayList<>();
		
		// Validação do campo Nome.
		if (funcionario.getNome() != null) {
			if (funcionario.getNome().length() < 5 || funcionario.getNome().length() > 100)
				erros.add("O Nome deve ter entre 5 e 100 caracteres!");
		} else {
			erros.add("O Nome não foi informado!");
		}
		
		// Validação do campo Salário.
		if (funcionario.getSalario() != null) {
			if (funcionario.getSalario().doubleValue() < 1000 || funcionario.getSalario().doubleValue() > 10000)
				erros.add("O Salário deve ser de R$ 1.000,00 à R$ 10.000,00!");
		} else
			erros.add("O Salário não foi informado!");
		
		// Validação do campo Cargo (para o caso de não existirem cargos cadastrados).
		if (funcionario.getCargo() == null)
			erros.add("O Cargo não foi informado!");
		
		// O campo Sexo não necessita de validação, pois seus valores são predefinidos.
		// O campo Plano de Saúde não necessita de validação, pois seus valores são booleanos (true ou false).
		
		return erros; // Retorna o ArrayList contendo as mensagens de erro.
	}
}