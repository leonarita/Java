package exercicio3;

public class Cliente {
	
	private int codigo;
	private String nome, cpf;
	
	public Cliente ()
	{
		this.codigo = -1;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean setNome(String nome) {
		if (nome.contains(" "))
		{	this.nome = nome;
			return true;
		}
		else
		{	System.out.println("\n\nN�o foi poss�vel inserir o nome " + nome + "! \n(Sobrenome � obrigat�rio)");
			return false;
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public boolean setCpf(String cpf) {
		if (cpf.length() == 11)
		{	this.cpf = cpf;
			return true;
		}
		else
		{	System.out.println("\n\nCPF deve conter 11 digitos!");
			return false;
		}
	}

}
