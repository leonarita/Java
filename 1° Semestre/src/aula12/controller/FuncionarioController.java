package aula12.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import aula12.dao.FuncionarioDao;
import aula12.model.cargo.Cargo;
import aula12.model.funcionario.Funcionario;
import aula12.model.funcionario.FuncionarioValidacao;

public class FuncionarioController {
	private FuncionarioDao funcDao;

	public ArrayList<String> insere(String nome, String sexo, String salario, boolean planoSaude, Cargo cargo) {
		funcDao = new FuncionarioDao();
		Funcionario funcionario = new Funcionario();
		
		// Os métodos set abaixo criam um objeto Funcionario contendo os dados do funcionário informado.
		// Este objeto será enviado à classe DAO, que fará a inserção de seus dados no banco.
		if (!nome.equals(""))
			funcionario.setNome(nome);

		if (sexo.equals("Masculino"))
			funcionario.setSexo('M');
		else
			funcionario.setSexo('F');

		if (!salario.equals(""))
			funcionario.setSalario(new BigDecimal(salario));
		
		funcionario.setPlanoSaude(planoSaude);
		
		if (cargo != null)
			funcionario.setCargo(cargo);
		
		// Retorna um ArrayList contendo os erros encontrados em regras de validação e de negócios.
		ArrayList<String> erros = FuncionarioValidacao.validaFuncionario(funcionario);

		// Se nenhum erro de validação for encontrado, tenta inserir o funcionário no banco.
		if (erros.size() == 0) 
			erros.add(funcDao.insereFuncionario(funcionario)); 
		
		// Retorna o ArrayList contendo:
		// - Em caso de sucesso: null no 1º elemento; OU
		// - Em caso de falha: Uma mensagem de exceção no 1º elemento; OU
		// - Em caso de falha: As mensagens de erro incluídas pela classe FuncionarioValidacao.
		return erros; 
	}
	
}