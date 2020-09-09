package atividade.modelo.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FabricaConexao {
	
protected static Connection conexao;
	
	public static Connection obterConexao()  {
		
		if(conexao == null) {
			
			try {
				String url = "jdbc:postgresql://localhost/controlebancariobd";
				
				Properties props = new Properties();
				props.setProperty("user", "postgres");
				props.setProperty("password", "postgres");
				props.setProperty("ssl", "false");
				
				conexao = DriverManager.getConnection(url, props);
				
			}
			catch (Exception e) {
				System.out.println("Erro ao criar uma conexão! " + e.getMessage());
			}
		}
		
		return conexao;
	}
	
	public static void fecharConexao() {
		
		try {
			
			if(conexao != null) {
				
				conexao.close();
				conexao = null;
			}
		}
		catch (Exception e) {
			System.out.println("Erro ao fechar a conexão! " + e.getMessage());
		}
	}
}
