package atividade.modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import atividade.modelo.ContaEspecial;
import atividade.modelo.designPattern.factoryMethod.FactoryConta;

public class ContaEspecialDAO extends FabricaConexao {
	
	private PreparedStatement pStmt;
	private String stmtSql;
	private ResultSet rs;
	
	public boolean criarContaEspecial(ContaEspecial contaEspecial, int idUsuario) {

		boolean resultado = true;
		
		int idConta = 0;
		
		try {
			
			stmtSql = "insert into contaespecial (aberturaconta, fechamentoconta, " +
				"situacaoconta, senhaconta, saldoconta, limiteConta) values (?, ?, ?, ?, ?, ?) returning numeroconta";
			
			pStmt = obterConexao().prepareStatement(stmtSql);

			pStmt.setObject(1, contaEspecial.getAberturaConta());
			pStmt.setObject(2, contaEspecial.getFechamentoConta());
			pStmt.setInt(3, contaEspecial.getSituacaoConta());
			pStmt.setInt(4, contaEspecial.getSenhaConta());
			pStmt.setDouble(5, contaEspecial.emitirSaldo());
			pStmt.setObject(6, contaEspecial.getLimiteConta());
			
			rs = pStmt.executeQuery();
			
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
	
	public ContaEspecial obterContaEspecialPorNumeroContaESenha(long numeroConta, long senhaConta) {
		
		ContaEspecial resultado = null;
		
		try {
			
			stmtSql = "select numeroconta, aberturaconta, fechamentoconta, " +
				"situacaoconta, senhaconta, saldoconta, limiteconta from contaespecial where numeroconta = ? and senhaconta = ?";
			
			pStmt = obterConexao().prepareStatement(stmtSql);
			
			pStmt.setLong(1, numeroConta);
			pStmt.setLong(2, senhaConta);
			
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				resultado = (ContaEspecial) FactoryConta.criarConta(2);
				
				resultado.setNumeroConta(rs.getLong("numeroconta"));
				resultado.setAberturaConta(rs.getDate("aberturaconta").toLocalDate());
				
				if(rs.getDate("fechamentoconta") != null) {
					resultado.setFechamentoConta(rs.getDate("fechamentoconta").toLocalDate());
				}
				
				resultado.setSituacaoConta(rs.getInt("situacaoconta"));
				resultado.setSenhaConta(rs.getInt("senhaconta"));
				resultado.setSaldoConta(rs.getDouble("saldoconta"));
				resultado.setLimiteConta(rs.getDouble("limiteconta"));
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar a conta comum! " + e.getMessage());
			resultado = null;
		}
		
		return resultado;
	}

}
