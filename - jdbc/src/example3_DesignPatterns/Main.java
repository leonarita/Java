package example3_DesignPatterns;

import example3_DesignPatterns.modelo.Pessoa;
import example3_DesignPatterns.modelo.repositorio.FabricaConexaoSingleton;
import example3_DesignPatterns.modelo.repositorio.PessoaDAOSingleton;

public class Main {

	public static void main(String[] args) {
		Pessoa p2 = new Pessoa();
		
		p2.setNomePessoa("Maria dos Santos");
		p2.setEnderecoPessoa("Av. do Estado, 2020");
		p2.setCepPessoa(12971621);
		p2.setTelefonePessoa("(11) 1213-1415");
		p2.setRendaPessoa(6750.65);
		
		PessoaDAOSingleton pDaoSing = new PessoaDAOSingleton();
		
		p2.setIdPessoa(pDaoSing.criarPessoa(p2));
		
	    if(p2.getIdPessoa() > 0) {
			  System.out.println("\nId da pessoa inserida: " + p2.getIdPessoa());
	    }
		
		FabricaConexaoSingleton.fecharConexao();
	}

}
