package atividade.modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import atividade.modelo.ContaComum;
import atividade.modelo.designPattern.factoryMethod.FactoryConta;

public class ContaComumDAO extends FabricaConexao {
	
	private PreparedStatement pStmt;
	private String stmtSql;
	private ResultSet rs;
	
	public int criarContaComum(ContaComum contaComum, int idUsuario) {
		
		int idConta = 0;
		
		try {
			
			stmtSql = "insert into contascomuns (aberturaconta, fechamentoconta, " +
				"situacaoconta, senhaconta, saldoconta) values (?, ?, ?, ?, ?) returning numeroconta";
			
			pStmt = obterConexao().prepareStatement(stmtSql);

			pStmt.setObject(1, contaComum.getAberturaConta());
			pStmt.setObject(2, contaComum.getFechamentoConta());
			pStmt.setInt(3, contaComum.getSituacaoConta());
			pStmt.setInt(4, contaComum.getSenhaConta());
			pStmt.setDouble(5, contaComum.emitirSaldo());
			
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				idConta = rs.getInt(1);
			}
			
			return idConta;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a conta comum! " + e.getMessage());
		}
		
		return idConta;
	}
	
	public void criarRelacaoPessoaConta(int idConta, int idUsuario) {
			
		try {
			
			stmtSql  = "INSERT INTO pessoaconta (idpessoa, idconta) VALUES (?, ?)";
			pStmt = conexao.prepareStatement(stmtSql);
			
			pStmt.setLong(1, idUsuario);
			pStmt.setLong(2, idConta);
			pStmt.execute();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a conta comum! " + e.getMessage());
		}
	}
	
	public int verificarContaDoUsuario(long codConta, long codPessoa) {
		int resp = 0;
		
		try {
			stmtSql = "SELECT idpessoa FROM pessoaconta where idpessoa = ? and idconta = ?";
			
			pStmt = obterConexao().prepareStatement(stmtSql);
			pStmt.setLong(1, codPessoa);
			pStmt.setLong(2, codConta);
			
			rs = pStmt.executeQuery();
			
			if (rs.next()) {
				resp = 1;
			}
		}
		catch (Exception e) {
			resp = 0;
		}
		
		return resp;
	}
	
	public int atualizarContaComum(ContaComum contaComum) {
		
		int resultado = 0;
		
		try {
			
			stmtSql = "update contascomuns set aberturaconta = ?, fechamentoconta = ?, " +
				"situacaoconta = ?, senhaconta = ?, saldoconta = ? where numeroconta = ? ";
			
			pStmt = obterConexao().prepareStatement(stmtSql);
			
			pStmt.setObject(1, contaComum.getAberturaConta());
			pStmt.setObject(2, contaComum.getFechamentoConta());
			pStmt.setInt(3, contaComum.getSituacaoConta());
			pStmt.setInt(4, contaComum.getSenhaConta());
			pStmt.setDouble(5, contaComum.emitirSaldo());
			pStmt.setLong(6, contaComum.getNumeroConta());
			
			resultado = pStmt.executeUpdate();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar a conta comum! " + e.getMessage());
		}
		
		return resultado;
	}
	
	public ContaComum obterContaComumPorNumeroContaESenha(long numeroConta, long senhaConta) {
		
		ContaComum resultado = null;
		
		try {
			
			stmtSql = "select numeroconta, aberturaconta, fechamentoconta, " +
				"situacaoconta, senhaconta, saldoconta from contascomuns where numeroconta = ? and senhaconta = ?";
			
			pStmt = obterConexao().prepareStatement(stmtSql);
			
			pStmt.setLong(1, numeroConta);
			pStmt.setLong(2, senhaConta);
			
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				resultado = FactoryConta.criarConta(1);
				
				resultado.setNumeroConta(rs.getLong("numeroconta"));
				resultado.setAberturaConta(rs.getDate("aberturaconta").toLocalDate());
				
				if(rs.getDate("fechamentoconta") != null) {
					resultado.setFechamentoConta(rs.getDate("fechamentoconta").toLocalDate());
				}
				
				resultado.setSituacaoConta(rs.getInt("situacaoconta"));
				resultado.setSenhaConta(rs.getInt("senhaconta"));
				resultado.setSaldoConta(rs.getDouble("saldoconta"));
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar a conta comum! " + e.getMessage());
			resultado = null;
		}
		
		return resultado;
	}
}
