package example2_DataPersistence.modelo;

import example2_DataPersistence.modelo.repositorio.PessoaJuridicaDAO;

public class PessoaJuridica extends Pessoa {

	private String cnpjPessoa;
	
	public PessoaJuridica() {
		
	}

	public PessoaJuridica(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa) {
		super(nomePessoa, enderecoPessoa, cepPessoa, telefonePessoa, rendaPessoa);
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
	
	public int registrarPessoa() {
		PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
		int cod = pjDao.criarPessoaJuridica(this);
		pjDao.fecharConexao();
		return cod;
	}
	
	private boolean validarCnpj(String cnpj) {
		if(cnpj.length() == 14)
			return true;
		return false;
	}
	
	public static String consultarCnpj(String cnpj) {
		PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
		
		PessoaJuridica p = pjDao.buscarPeloCnpj(cnpj);
		pjDao.fecharConexao();

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
		PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
		
		int id = pjDao.buscarIdPeloCnpj(cnpj);
		pjDao.fecharConexao();
		return id;
	}
	
}
