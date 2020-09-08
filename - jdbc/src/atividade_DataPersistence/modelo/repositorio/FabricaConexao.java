package atividade_DataPersistence.modelo.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.swing.JOptionPane;

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
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar uma conexão! " + e.getMessage());
		}
	}
	
	public void fecharConexao() {
		
		try {
			if(this.conexao != null) {
				this.conexao.close();
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão! " + e.getMessage());
		}
	}
}
