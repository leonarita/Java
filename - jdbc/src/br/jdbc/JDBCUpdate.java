package br.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCUpdate {

	public static void main(String[] args) {
		
		String sql = "update carros set placa=?, nome_dono=? where id=?";
				
		try {
		
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, "12341234");
			stmt.setString(2, "Carlos");
			stmt.setInt(3, 3);
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());		
		}

	}
}
