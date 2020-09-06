package example2_DataPersistence.modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import example2_DataPersistence.modelo.ContaEspecial;

public class ContaEspecialDAO extends FabricaConexao {
	
	public boolean criarContaEspecial(ContaEspecial contaEspecial, int idUsuario) {

		boolean resultado = true;
		
		int idConta = 0;
		
		try {
			
			String stmtSql = "insert into contaespecial (aberturaconta, fechamentoconta, " +
				"situacaoconta, senhaconta, saldoconta, limiteConta) values (?, ?, ?, ?, ?, ?) returning numeroconta";
			
			PreparedStatement pStmt = conexao.prepareStatement(stmtSql);

			pStmt.setObject(1, contaEspecial.getAberturaConta());
			pStmt.setObject(2, contaEspecial.getFechamentoConta());
			pStmt.setInt(3, contaEspecial.getSituacaoConta());
			pStmt.setInt(4, contaEspecial.getSenhaConta());
			pStmt.setDouble(5, contaEspecial.getSaldoConta());
			pStmt.setObject(6, contaEspecial.getLimiteConta());
			
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

}
