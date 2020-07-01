package exercicio1;

public class Produto {

	private int codigo;
	private String descricao;
	private float preco;
	private boolean ativo;
	
	
	public Produto(int codigo, String descricao, float preco, boolean ativo) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.ativo = ativo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public void mensagem()
	{
		System.out.println("Sucesso!");
	}
}