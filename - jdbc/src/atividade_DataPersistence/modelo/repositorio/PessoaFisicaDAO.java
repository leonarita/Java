package atividade_DataPersistence.modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import atividade_DataPersistence.modelo.PessoaFisica;
import atividade_DataPersistence.modelo.designPattern.factoryMethod.FactoryPessoa;

public class PessoaFisicaDAO extends FabricaConexao {
	
	public int criarPessoaFisica(PessoaFisica pf) {
		
		int id = 0;
		
		try {
			
			String stmtSql = "insert into pessoafisica (nome, endereco, cep, telefone, renda, situacao, rg, cpf, idade) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?) returning id";
			
			PreparedStatement pStmt = obterConexao().prepareStatement(stmtSql);

			pStmt.setString(1, pf.getNomePessoa());
			pStmt.setString(2, pf.getEnderecoPessoa());
			pStmt.setLong(3, pf.getCepPessoa());
			pStmt.setString(4, pf.getTelefonePessoa());
			pStmt.setDouble(5, pf.getRendaPessoa());
			pStmt.setInt(6, pf.getSituacaoPessoa());
			pStmt.setString(7, pf.getRgPessoa());
			pStmt.setString(8, pf.getCpfPessoa());
			pStmt.setInt(9, pf.getSituacaoPessoa());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a pessoa física! " + e.getMessage());
		}
		
		return id;
	}
	
	public PessoaFisica buscarPeloCpf (String cpf) {
		
		PessoaFisica pf = null;
		
		try {
			String stmtSql = "select nome, endereco, cep, telefone, renda, situacao, rg, cpf, idade from pessoafisica where cpf = ?";
			PreparedStatement pStmt = obterConexao().prepareStatement(stmtSql);
			
			pStmt.setString(1, cpf);
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				pf = (PessoaFisica) FactoryPessoa.criarPessoa(1);
				pf.setNomePessoa(rs.getString("nome"));
				pf.setEnderecoPessoa(rs.getString("endereco"));
				pf.setCepPessoa(rs.getLong("cep"));
				pf.setTelefonePessoa(rs.getString("telefone"));
				pf.setRendaPessoa(rs.getDouble("renda"));
				pf.setSituacaoPessoa(rs.getInt("situacao"));
				pf.setRgPessoa(rs.getString("rg"));
				pf.setCpfPessoa(rs.getString("cpf"));
				pf.setIdadePessoa(rs.getInt("idade"));
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar pelo CPF! " + e.getMessage());
		}
		
		return pf;
	}
	
	public int buscarIdPeloCpf(String cpf) {
		int id = 0;
		
		try {
			String stmtSql = "select id from pessoafisica where cpf = ?";
			PreparedStatement pStmt = obterConexao().prepareStatement(stmtSql);
			
			pStmt.setString(1, cpf);
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("id");
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar pelo CPF! " + e.getMessage());
		}
		
		return id;
	}

}
