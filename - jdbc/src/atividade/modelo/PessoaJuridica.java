package atividade.modelo;

import atividade.modelo.repositorio.PessoaJuridicaDAO;

public class PessoaJuridica extends Pessoa {

	private String cnpjPessoa;
	
	private static PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
	
	public PessoaJuridica() { }

	public PessoaJuridica(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa, double rendaPessoa) {
		super(nomePessoa, enderecoPessoa, cepPessoa, telefonePessoa, rendaPessoa, 3);
	}

	public String getCnpjPessoa() {
		return cnpjPessoa;
	}

	public boolean setCnpjPessoa(String cnpjPessoa) {

		if (validarCnpj(cnpjPessoa)) {
			this.cnpjPessoa = cnpjPessoa;
			return true;
		}
		
		return false;
	}
	
	public static PessoaJuridicaDAO getPjDao() {
		return pjDao;
	}

	public int registrarPessoa() {
		int cod = 0;
		
		int id = pjDao.buscarIdPeloCnpj(this.getCnpjPessoa());
		
		if (id == 0)
			cod = pjDao.criarPessoaJuridica(this);
		
		return cod;
	}
	
	private boolean validarCnpj(String cnpj) {
		if(cnpj.length() == 14)
			return true;
		return false;
	}
	
	public static String consultarCnpj(String cnpj) {
		
		PessoaJuridica p = pjDao.buscarPeloCnpj(cnpj);

		if(p != null) {
			return "\t\tNome: " + p.getNomePessoa() + ", Endere�o: " + p.getEnderecoPessoa() + ", CEP: " + p.getCepPessoa() +
					", Telefone: " + p.getTelefonePessoa() + ", Renda: " + p.getRendaPessoa() + ", Situa��o: " + p.getSituacaoPessoa() +
					", CNPJ: " + p.getCnpjPessoa();
		}
		else {
			return "\t\tCNPJ n�o cadastrado";
		}
	}
	
	public int buscarIdPelaCredencial(String credencial) {
		return pjDao.buscarIdPeloCnpj(credencial);
	}
	
}
