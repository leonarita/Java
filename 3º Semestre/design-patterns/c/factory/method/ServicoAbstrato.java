package c.factory.method;

import java.io.IOException;
import java.util.HashMap;

import b.template.method.GeradorArquivo;

public abstract class ServicoAbstrato<E> {
	
	public GeradorArquivo gerador;
	
	public ServicoAbstrato(GeradorArquivo gerador){
		this.gerador = gerador;
	}
	
	public abstract DAO<E> getDAO();
	
	//Servi�o geral
	public void gravarEntidadeEmArquivo(Object id, String nomeArquivo) throws IOException{
		E entidade = getDAO().recuperarPorId(id);
		
		gerador.gerarArquivo(nomeArquivo, new HashMap<String, Object>());
	}

}
