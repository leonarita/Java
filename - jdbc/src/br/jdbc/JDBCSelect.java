package br.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSelect {

	public static void main (String[] args) throws SQLException {
		
		// pega a conexão e o Statement
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from carros");

		// executa um select
		ResultSet rs = stmt.executeQuery();
		
		// itera no ResultSet
		while (rs.next()) {
			String placa = rs.getString("placa");
			String nome_dono = rs.getString("nome_dono");
			System.out.println(placa + " _ " + nome_dono);
		}
		
		stmt.close();
		con.close();
	}
}
