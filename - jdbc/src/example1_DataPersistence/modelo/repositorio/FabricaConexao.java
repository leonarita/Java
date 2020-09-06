package example1_DataPersistence.modelo.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FabricaConexao {

	protected Connection conn;
	
	public FabricaConexao() {
		try {
			String url = "jdbc:postgresql://localhost/testepgdb";
			Properties props = new Properties();
			props.setProperty("user", "postgres");
			props.setProperty("password", "postgres");
			props.setProperty("ssl", "false");
			conn = DriverManager.getConnection(url, props);
		}
		catch (Exception e) {
			System.out.println("Erro ao criar conexão! \n\t" + e.getMessage());
		}
	}
	
	public void fecharConexao() {
		try {
			this.conn.close();
			System.out.println("Conexão fechada!");
		}
		catch (Exception e) {
			System.out.println("Erro ao fechar conexão! \n\t" + e.getMessage());
		}
	}
}
