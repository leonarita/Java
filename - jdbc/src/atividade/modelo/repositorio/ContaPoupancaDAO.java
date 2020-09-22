package atividade.modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import atividade.administrador.log.GravarErro;
import atividade.designPattern.factoryMethod.FactoryConta;
import atividade.modelo.ContaPoupanca;

public class ContaPoupancaDAO extends FabricaConexao {
	
	private PreparedStatement pStmt;
	private String stmtSql;
	private ResultSet rs;
	
	public int criarContaPoupanca(ContaPoupanca contaEspecial, int idUsuario) {
		
		int idConta = 0;
		
		try {
			
			stmtSql = "insert into contapoupanca (aberturaconta, fechamentoconta, " +
				"situacaoconta, senhaconta, saldoconta, aniversarioConta) values (?, ?, ?, ?, ?, ?) returning numeroconta";
			
			pStmt = obterConexao().prepareStatement(stmtSql);

			pStmt.setObject(1, contaEspecial.getAberturaConta());
			pStmt.setObject(2, contaEspecial.getFechamentoConta());
			pStmt.setInt(3, contaEspecial.getSituacaoConta());
			pStmt.setInt(4, contaEspecial.getSenhaConta());
			pStmt.setBigDecimal(5, contaEspecial.emitirSaldo());
			pStmt.setObject(6, contaEspecial.getAniversarioConta());
			
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
			GravarErro.relatarErro(e.getMessage());
		}
		
		return idConta;
	}
	
	public ContaPoupanca obterContaPoupancaPorNumeroContaESenha(long numeroConta, long senhaConta) {
		
		ContaPoupanca resultado = null;
		
		try {
			
			stmtSql = "select numeroconta, aberturaconta, fechamentoconta, " +
				"situacaoconta, senhaconta, saldoconta, aniversarioconta from contapoupanca where numeroconta = ? and senhaconta = ?";
			
			pStmt = obterConexao().prepareStatement(stmtSql);
			
			pStmt.setLong(1, numeroConta);
			pStmt.setLong(2, senhaConta);
			
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				resultado = (ContaPoupanca) FactoryConta.criarConta(3);
				
				resultado.setNumeroConta(rs.getLong("numeroconta"));
				resultado.setAberturaConta(rs.getDate("aberturaconta").toLocalDate());
				
				if(rs.getDate("fechamentoconta") != null) {
					resultado.setFechamentoConta(rs.getDate("fechamentoconta").toLocalDate());
				}
				
				resultado.setSituacaoConta(rs.getInt("situacaoconta"));
				resultado.setSenhaConta(rs.getInt("senhaconta"));
				resultado.setSaldoConta(rs.getBigDecimal("saldoconta"));
				resultado.setAniversarioConta(rs.getDate("aniversarioConta").toLocalDate());
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar a conta comum! " + e.getMessage());
			GravarErro.relatarErro(e.getMessage());
			resultado = null;
		}
		
		return resultado;
	}

}
