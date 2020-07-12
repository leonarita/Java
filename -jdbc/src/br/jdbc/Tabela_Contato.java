package br.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Tabela_Contato {

	public static void main(String[] args) throws SQLException {
		
		ContatoDao bd = new ContatoDao();

		//inserirContato(bd, "Gustavo", "gustavo@gmail.com", "rua Legal");
		
		List<Contato> contatos = bd.buscarTodosContato();
		
		for (Contato i : contatos) {
			System.out.println(i.getNome() + " _ " + i.getEmail());
		}
		
		//bd.altera(contatos.get(2));
		//bd.remove(contatos.get(3));
	}
	
	public static void inserirContato(ContatoDao bd, String nome, String email, String endereco) throws SQLException {
		
		// pronto para gravar
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(Calendar.getInstance());
		
		// grave nessa conexão!!!
		bd.adiciona(contato);

		System.out.println("Gravado!");
	}


	static class Contato {

		private Long id;
		private String nome;
		private String email;
		private String endereco;
		private Calendar dataNascimento;
		
				
		public Contato() {
		}
				
		public Contato(Long id, String nome, String email, String endereco, Calendar dataNascimento) {
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.endereco = endereco;
			this.dataNascimento = dataNascimento;
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public Calendar getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(Calendar dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
	}
	
	
	static public class ContatoDao {
		
		// a conexão com o banco de dados
		private Connection connection;

		public ContatoDao() {		
			this.connection = new ConnectionFactory().getConnection();
		}
		
		public void adiciona(Contato contato) {
			
			String sql = "insert into contatos " +
			"(nome,email,endereco,dataNascimento)" +
			" values (?,?,?,?)";
			
			try {
				Connection con = new ConnectionFactory().getConnection();
			
				// prepared statement para inserção		
				PreparedStatement stmt = con.prepareStatement(sql);
				
				// seta os valores		
				stmt.setString(1,contato.getNome());
				stmt.setString(2,contato.getEmail());
				stmt.setString(3,contato.getEndereco());
				stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
		
				// executa	
				stmt.execute();		
				stmt.close();

			} catch (SQLException e) {		
				throw new RuntimeException(e);
			}	
		}
		
		public List<Contato> buscarTodosContato() throws SQLException {
			
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from contatos");
					
			ResultSet rs = stmt.executeQuery();
			List<Contato> contatos = new ArrayList<Contato>();
			
			while (rs.next()) {
			
				// criando o objeto Contato
				Contato contato = new Contato();
				
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				// adicionando o objeto à lista			
				contatos.add(contato);			
			}
			
			rs.close();		
			stmt.close();	

			return contatos;
		}
		
		public void altera(Contato contato) {
			
			String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
			
			try {
			
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, contato.getNome());
				stmt.setString(2, contato.getEmail());
				stmt.setString(3, contato.getEndereco());
				stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
				stmt.setLong(5, contato.getId());
			
				stmt.execute();		
				stmt.close();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void remove(Contato contato) {
						
			try {

				PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
				stmt.setLong(1, contato.getId());
				stmt.execute();
				stmt.close();
			} 
			catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
