package example2_DataPersistence.modelo;

import example2_DataPersistence.modelo.repositorio.PessoaFisicaDAO;

public class PessoaFisica extends Pessoa {

	private String cpfPessoa;
	private String rgPessoa;
	private int idadePessoa;
	
	public PessoaFisica () {
		
	}

	public PessoaFisica(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa) {
		
		super(nomePessoa, enderecoPessoa, cepPessoa, telefonePessoa, rendaPessoa, 2);
	}

	public String getCpfPessoa() {
		return cpfPessoa;
	}
	
	public boolean setCpfPessoa(String cpfPessoa) {
		boolean response = validarCpf(cpfPessoa);
	
		if (response)
			this.cpfPessoa = cpfPessoa;
		
		return response;
	}
	
	public String getRgPessoa() {
		return rgPessoa;
	}
	
	public void setRgPessoa(String rgPessoa) {
		this.rgPessoa = rgPessoa;
	}
	
	public int getIdadePessoa() {
		return idadePessoa;
	}
	
	public void setIdadePessoa(int idadePessoa) {
		this.idadePessoa = idadePessoa;
	}

	public int registrarPessoa() {
		PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
		int cod = pfDao.criarPessoaFisica(this);
		pfDao.fecharConexao();
		return cod;
	}
	
	private boolean validarCpf(String cpf) {
		if(cpf.length() == 11)
			return true;
		return false;
	}
	
	public static String consultarCpf(String cpf) {
		PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
		
		PessoaFisica p = pfDao.buscarPeloCpf(cpf);
		pfDao.fecharConexao();

		if(p != null) {
			return "\t\tNome: " + p.getNomePessoa() + ", Endereço: " + p.getEnderecoPessoa() + ", CEP: " + p.getCepPessoa() +
					", Telefone: " + p.getTelefonePessoa() + ", Renda: " + p.getRendaPessoa() + ", Situação: " + p.getSituacaoPessoa() +
					", RG: " + p.getRgPessoa() + ", CPF: " + p.getCpfPessoa() + ", Idade: " + p.getIdadePessoa();
		}
		else {
			return "\t\tCPF não cadastrado";
		}
	}
	
	public static int buscarIdPeloCpf(String cpf) {
		PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
		
		int id = pfDao.buscarIdPeloCpf(cpf);
		pfDao.fecharConexao();
		return id;
	}
	
}
