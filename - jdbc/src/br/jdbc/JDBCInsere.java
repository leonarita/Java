package br.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsere {

	public static void main(String[] args) throws SQLException {
		
		// Conectando
		try (Connection con = new ConnectionFactory().getConnection();) {
			
			// cria um preparedStatement
			String sql = "insert into carros" +
			" (placa, nome_dono)" +
			" values (?,?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// preenche os valores
			stmt.setString(1, "121212");
			stmt.setString(2, "João");
			
			// executa
			stmt.execute();
			stmt.close();
			System.out.println("Gravado!");
			
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
}
