package example1_DataPersistence;

import example1_DataPersistence.modelo.Pessoa;
import example1_DataPersistence.modelo.repositorio.PessoaDAO;

public class Main {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa();
		
		p1.setNomePessoa("José da Silva");
		p1.setEnderecoPessoa("Av. Brasil, 2017");
		p1.setCepPessoa(90860510);
		p1.setTelefonePessoa("(55) 5555-7777");
		p1.setRendaPessoa(5000.0);
		
		PessoaDAO pDao = new PessoaDAO();
		p1.setIdPessoa(pDao.criarPessoa(p1));
		System.out.println("Id da pessoa inserida: " + p1.getIdPessoa());
		pDao.fecharConexao();
	}
}
