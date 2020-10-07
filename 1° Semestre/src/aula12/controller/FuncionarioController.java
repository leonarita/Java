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
		
		// Os m�todos set abaixo criam um objeto Funcionario contendo os dados do funcion�rio informado.
		// Este objeto ser� enviado � classe DAO, que far� a inser��o de seus dados no banco.
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
		
		// Retorna um ArrayList contendo os erros encontrados em regras de valida��o e de neg�cios.
		ArrayList<String> erros = FuncionarioValidacao.validaFuncionario(funcionario);

		// Se nenhum erro de valida��o for encontrado, tenta inserir o funcion�rio no banco.
		if (erros.size() == 0) 
			erros.add(funcDao.insereFuncionario(funcionario)); 
		
		// Retorna o ArrayList contendo:
		// - Em caso de sucesso: null no 1� elemento; OU
		// - Em caso de falha: Uma mensagem de exce��o no 1� elemento; OU
		// - Em caso de falha: As mensagens de erro inclu�das pela classe FuncionarioValidacao.
		return erros; 
	}
	
}