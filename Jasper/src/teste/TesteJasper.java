package teste;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteJasper {

	public Connection getConexao() {
		
		Connection conexao = null;
			
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/hospitalbd?useSSL=false";
			conexao = DriverManager.getConnection(url, "root", "123456");
		}
		catch (Exception e) {
			//Logger.getLogger(TesteJasper.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("ERRO Exception");
		}
		
		return conexao;
	}
	
	public static void main(String[] args) {
		
		TesteJasper teste = new TesteJasper();
		teste.getConexao();
		
	}
}
