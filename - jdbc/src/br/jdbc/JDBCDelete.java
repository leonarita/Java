package br.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCDelete {

public static void main(String[] args) {
		
		String sql = "delete from carros where id=?";
				
		try {
		
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, 3);
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());		
		}

	}
}
