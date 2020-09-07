package example2_DataPersistence.modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import example2_DataPersistence.modelo.ContaPoupanca;

public class ContaPoupancaDAO extends FabricaConexao {
	
	public boolean criarContaPoupanca(ContaPoupanca contaEspecial, int idUsuario) {

		boolean resultado = true;
		
		int idConta = 0;
		
		try {
			
			String stmtSql = "insert into contapoupanca (aberturaconta, fechamentoconta, " +
				"situacaoconta, senhaconta, saldoconta, aniversarioConta) values (?, ?, ?, ?, ?, ?) returning numeroconta";
			
			PreparedStatement pStmt = conexao.prepareStatement(stmtSql);

			pStmt.setObject(1, contaEspecial.getAberturaConta());
			pStmt.setObject(2, contaEspecial.getFechamentoConta());
			pStmt.setInt(3, contaEspecial.getSituacaoConta());
			pStmt.setInt(4, contaEspecial.getSenhaConta());
			pStmt.setDouble(5, contaEspecial.emitirSaldo());
			pStmt.setObject(6, contaEspecial.getAniversarioConta());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				idConta = rs.getInt(1);
			}
			
			stmtSql = "INSERT INTO pessoaconta (idpessoa, idconta) VALUES (?, ?)";
			pStmt = conexao.prepareStatement(stmtSql);
			
			pStmt.setLong(1, idUsuario);
			pStmt.setLong(2, idConta);
			pStmt.execute();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a conta comum! " + e.getMessage());
			resultado = false;
		}
		
		return resultado;
	}
	
	public ContaPoupanca obterContaPoupancaPorNumeroContaESenha(long numeroConta, long senhaConta) {
		
		ContaPoupanca resultado = null;
		
		try {
			
			String stmtSql = "select numeroconta, aberturaconta, fechamentoconta, " +
				"situacaoconta, senhaconta, saldoconta, aniversarioconta from contapoupanca where numeroconta = ? and senhaconta = ?";
			
			PreparedStatement pStmt = conexao.prepareStatement(stmtSql);
			
			pStmt.setLong(1, numeroConta);
			pStmt.setLong(2, senhaConta);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				resultado = new ContaPoupanca();
				
				resultado.setNumeroConta(rs.getLong("numeroconta"));
				resultado.setAberturaConta(rs.getDate("aberturaconta").toLocalDate());
				
				if(rs.getDate("fechamentoconta") != null) {
					resultado.setFechamentoConta(rs.getDate("fechamentoconta").toLocalDate());
				}
				
				resultado.setSituacaoConta(rs.getInt("situacaoconta"));
				resultado.setSenhaConta(rs.getInt("senhaconta"));
				resultado.setSaldoConta(rs.getDouble("saldoconta"));
				resultado.setAniversarioConta(rs.getDate("aniversarioConta").toLocalDate());
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar a conta comum! " + e.getMessage());
			resultado = null;
		}
		
		return resultado;
	}

}
