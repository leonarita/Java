package c.factory.method;

import java.util.List;

import b.template.method.GeradorArquivo;

public class ServicoProduto extends ServicoAbstrato<ServicoProduto.Produto> {
	
	public ServicoProduto(GeradorArquivo gerador) {
		super(gerador);
	}

	private DAO<Produto> dao;
	
	public DAO<Produto> getDAO(){
	
		if(dao == null){
			dao = new ProdutoDAO();
		}
		
		return dao;
	}
	
	//Funcionalidade específica
	public double getPrecoProduto(Object produtoId){
		Produto p = getDAO().recuperarPorId(produtoId);
		return p.getPreco();
	}
	
	public class Produto {
		
		private double preco;
		
		double getPreco() {
			return this.preco;
		}
	}
	
	public class ProdutoDAO implements DAO<Produto> {

		@Override
		public Produto recuperarPorId(Object id) {
			return null;
		}

		@Override
		public void salvar(Produto entidade) {
			
		}

		@Override
		public void excluir(Object id) {
			
		}

		@Override
		public List<Produto> listarTodos() {
			return null;
		}
		
	}

}
