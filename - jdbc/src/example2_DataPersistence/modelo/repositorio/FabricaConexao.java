package example2_DataPersistence.modelo.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FabricaConexao {
	
	protected Connection conexao;
	
	public FabricaConexao() {
		
		try {
			String url = "jdbc:postgresql://localhost/controlebancariobd";
			
			Properties props = new Properties();
			props.setProperty("user", "postgres");
			props.setProperty("password", "postgres");
			props.setProperty("ssl", "false");
			
			this.conexao = DriverManager.getConnection(url, props);
			
			System.out.println("Conex�o criada com sucesso!");
		}
		catch (Exception e) {
			System.out.println("Erro ao criar uma conex�o! " + e.getMessage());
		}
	}
	
	public void fecharConexao() {

		try {
			
			if(this.conexao != null) {
				this.conexao.close();
				System.out.println("Conex�o fechada com sucesso!");
			}
		}
		catch (Exception e)	{
			System.out.println("Erro ao fechar a conex�o! " + e.getMessage());
		}
	}
}
