package atividade_DataPersistence.modelo;

import atividade_DataPersistence.modelo.repositorio.PessoaFisicaDAO;

public class PessoaFisica extends Pessoa {

	private String cpfPessoa;
	private String rgPessoa;
	private int idadePessoa;
	
	private static PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
	
	public PessoaFisica () {
		
	}

	public PessoaFisica(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa) {
		
		super(nomePessoa, enderecoPessoa, cepPessoa, telefonePessoa, rendaPessoa, 2);
	}

	public String getCpfPessoa() {
		return cpfPessoa;
	}
	
	public static PessoaFisicaDAO getPfDao() {
		return pfDao;
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
		int cod = 0;
		
		int id = pfDao.buscarIdPeloCpf(this.getCpfPessoa());
		
		if(id == 0)
			cod = pfDao.criarPessoaFisica(this);

		return cod;
	}
	
	private boolean validarCpf(String cpf) {
		if(cpf.length() == 11)
			return true;
		return false;
	}
	
	public static String consultarCpf(String cpf) {
		
		PessoaFisica p = pfDao.buscarPeloCpf(cpf);

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
		
		int id = pfDao.buscarIdPeloCpf(cpf);
		return id;
	}
	
}
