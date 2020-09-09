package atividade_DataPersistence.modelo;

import atividade_DataPersistence.modelo.repositorio.PessoaJuridicaDAO;

public class PessoaJuridica extends Pessoa {

	private String cnpjPessoa;
	
	private static PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
	
	public PessoaJuridica() {
		
	}

	public PessoaJuridica(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa, double rendaPessoa) {
		super(nomePessoa, enderecoPessoa, cepPessoa, telefonePessoa, rendaPessoa, 3);
	}

	public String getCnpjPessoa() {
		return cnpjPessoa;
	}

	public boolean setCnpjPessoa(String cnpjPessoa) {
		boolean response = validarCnpj(cnpjPessoa);

		if (response)
			this.cnpjPessoa = cnpjPessoa;

		return response;
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
			return "\t\tNome: " + p.getNomePessoa() + ", Endereço: " + p.getEnderecoPessoa() + ", CEP: " + p.getCepPessoa() +
					", Telefone: " + p.getTelefonePessoa() + ", Renda: " + p.getRendaPessoa() + ", Situação: " + p.getSituacaoPessoa() +
					", CNPJ: " + p.getCnpjPessoa();
		}
		else {
			return "\t\tCNPJ não cadastrado";
		}
	}
	
	public static int buscarIdPeloCnpj(String cnpj) {
		
		int id = pjDao.buscarIdPeloCnpj(cnpj);
		return id;
	}
	
}
