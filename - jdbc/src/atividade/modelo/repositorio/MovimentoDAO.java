package atividade.modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import atividade.administrador.log.GravarErro;
import atividade.modelo.ContaComum;
import atividade.modelo.Movimento;

public class MovimentoDAO extends FabricaConexao {
	
	private PreparedStatement pStmt;
	private String stmtSql;
	private ResultSet rs;
	
	public int criarMovimento(Movimento movimento) {

		int id = 0;
		
		try {
			
			stmtSql = "insert into movimentos (tipo, datahora, valor, numerocontacomum) values (?, ?, ?, ?) returning id";
			
			pStmt = obterConexao().prepareStatement(stmtSql);
			pStmt.setInt(1, movimento.getTipoMovimento());
			pStmt.setObject(2, movimento.getDataHoraMovimento());
			pStmt.setBigDecimal(3, movimento.getValorMovimento());
			pStmt.setLong(4, movimento.getContaMovimento().getNumeroConta());
			
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("id");
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o movimento! " + e.getMessage());
			GravarErro.relatarErro(e.getMessage());
		}
		
		return id;
	}
	
	
	public ArrayList<Movimento> obterMovimentosPorNumeroConta(long numeroConta) {
		
		ArrayList<Movimento> resultado = null;
		
		try {
			
			stmtSql = "select id, tipo, datahora, valor, numerocontacomum from movimentos where numerocontacomum = ?";
			
			pStmt = obterConexao().prepareStatement(stmtSql);
			
			pStmt.setLong(1, numeroConta);
			
			rs = pStmt.executeQuery();
			
			resultado = new ArrayList<Movimento>();		
			
			while(rs.next()) {
				
				Movimento m = new Movimento();
				
				m.setIdMovimento(rs.getInt("id"));
				m.setTipoMovimento(rs.getInt("tipo"));
				m.setDataHoraMovimento(rs.getTimestamp("datahora").toLocalDateTime());
				m.setValorMovimento(rs.getBigDecimal("valor"));
				
				ContaComum cc = new ContaComum();
				cc.setNumeroConta(rs.getLong("numerocontacomum"));
				
				m.setContaMovimento(cc);
				
				resultado.add(m);
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
