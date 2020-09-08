package atividade_DataPersistence.modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import atividade_DataPersistence.modelo.PessoaJuridica;

public class PessoaJuridicaDAO extends FabricaConexao {
	
	public int criarPessoaJuridica(PessoaJuridica pj) {
		
		int id = 0;
		
		try {
			
			String stmtSql = "insert into pessoajuridica (nome, endereco, cep, telefone, renda, situacao, cnpj) "
					+ "values (?, ?, ?, ?, ?, ?, ?) returning id";
			
			PreparedStatement pStmt = conexao.prepareStatement(stmtSql);

			pStmt.setString(1, pj.getNomePessoa());
			pStmt.setString(2, pj.getEnderecoPessoa());
			pStmt.setLong(3, pj.getCepPessoa());
			pStmt.setString(4, pj.getTelefonePessoa());
			pStmt.setDouble(5, pj.getRendaPessoa());
			pStmt.setInt(6, pj.getSituacaoPessoa());
			pStmt.setString(7, pj.getCnpjPessoa());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a pessoa juridica! " + e.getMessage());
		}
		
		return id;
	}
	
	public PessoaJuridica buscarPeloCnpj (String cnpj) {
		
		PessoaJuridica pf = null;
		
		try {
			String stmtSql = "select nome, endereco, cep, telefone, renda, situacao, cnpj from pessoajuridica where cnpj = ?";
			PreparedStatement pStmt = conexao.prepareStatement(stmtSql);
			
			pStmt.setString(1, cnpj);
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				pf = new PessoaJuridica();
				pf.setNomePessoa(rs.getString("nome"));
				pf.setEnderecoPessoa(rs.getString("endereco"));
				pf.setCepPessoa(rs.getLong("cep"));
				pf.setTelefonePessoa(rs.getString("telefone"));
				pf.setRendaPessoa(rs.getDouble("renda"));
				pf.setSituacaoPessoa(rs.getInt("situacao"));
				pf.setCnpjPessoa(rs.getString("cnpj"));
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar pelo CPF! " + e.getMessage());
		}
		
		return pf;
	}

	public int buscarIdPeloCnpj(String cnpj) {
		int id = 0;
		
		try {
			String stmtSql = "select id from pessoajuridica where cnpj = ?";
			PreparedStatement pStmt = conexao.prepareStatement(stmtSql);
			
			pStmt.setString(1, cnpj);
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("id");
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar pelo CNPJ! " + e.getMessage());
		}
		
		return id;
	}

}