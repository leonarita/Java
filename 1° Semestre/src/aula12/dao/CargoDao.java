package aula12.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import aula12.model.cargo.Cargo;

public class CargoDao {
	private ConfigDao cfgDao= new ConfigDao();; // Objeto para conexão com o banco de dados.
	private String instrucaoSQL; // Instrução SQL a ser executada.
    private Connection conexao; // Objeto que recebe os dados de conexão com o banco de dados.
    private PreparedStatement comando; // Objeto usado para preparar e executar instruções SQL.
    private ResultSet registros; // Objeto que recebe os dados retornados por uma instrução SQL.
	
	// Recupera os cargos cadastrados no banco de dados para que sejam carregados no JComboBox Cargo.
	public ArrayList<Cargo> recuperaCargosBd(){
        Cargo c;
        ArrayList<Cargo> cargos = new ArrayList<>();

        try {
        	String erro = cfgDao.conectaBD(); // Abre a conexão com o banco de dados.
        	if (erro.equals("Sucesso")) {
	            conexao = cfgDao.getConexaoBD();
	            instrucaoSQL = "SELECT IdCargo, Descricao FROM cargo";
	            comando = conexao.prepareStatement(instrucaoSQL);
	            
	            // Executa a instrução SQL e retorna os dados ao objeto ResultSet.
	            registros = comando.executeQuery(); 
	            
	            if (registros.next()) { // Se for retornado pelo menos um registro.
	                registros.beforeFirst(); // Retorna o cursor para antes do 1º registro.
	                while (registros.next()) { // Percorre os registros retornados.
	                    Integer idCargo = Integer.parseInt(registros.getString("IdCargo")); // Obtém o id armazenado no registro.
	                    String descricao = registros.getString("Descricao"); // Obtém a descrição armazenada no registro.
	
	                    // Atribui os dados do cargo ao objeto Cargo por meio dos métodos set e
	                    // adiciona este objeto ao ArrayList cargos.
	                    c = new Cargo();
	                    c.setIdCargo(idCargo);
	                    c.setDescricao(descricao);
	                    cargos.add(c);
	                }
	            }
	            cfgDao.desconectaBD(); // Fecha a conexão com o banco de dados.
        	} else
        		cargos = null; // Caso ocorra exceção ao tentar conectar com o banco de dados.
        } catch (Exception e) {
        	cargos = null; // Caso ocorra qualquer outra exceção.
        }
        return cargos; // Retorna o ArrayList de objetos Cargo.
	}
	
	public String insereCargoBd(Cargo cargo) {
		
		try {
			String erro = cfgDao.conectaBD();
			
			if (erro.equals("Sucesso")) {
	            conexao = cfgDao.getConexaoBD();
	            instrucaoSQL = "INSERT INTO cargo VALUES (null, "
	            		+ "'" + cargo.getDescricao() + "', "
	            		+ "'" + cargo.getDepartamento() + "')";
	            
	            comando = conexao.prepareStatement(instrucaoSQL);
	            comando.execute();
	            cfgDao.desconectaBD(); // Fecha a conexão com o banco de dados.
        	}
			
			return null;
		}
		catch (Exception e) {
			return "Tipo de Exceção: " + e.getClass().getSimpleName() + "\n * Mensagem: " + e.getMessage();
		}
	}
}
