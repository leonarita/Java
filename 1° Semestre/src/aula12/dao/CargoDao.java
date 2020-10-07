package aula12.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import aula12.model.cargo.Cargo;

public class CargoDao {
	private ConfigDao cfgDao= new ConfigDao();; // Objeto para conex�o com o banco de dados.
	private String instrucaoSQL; // Instru��o SQL a ser executada.
    private Connection conexao; // Objeto que recebe os dados de conex�o com o banco de dados.
    private PreparedStatement comando; // Objeto usado para preparar e executar instru��es SQL.
    private ResultSet registros; // Objeto que recebe os dados retornados por uma instru��o SQL.
	
	// Recupera os cargos cadastrados no banco de dados para que sejam carregados no JComboBox Cargo.
	public ArrayList<Cargo> recuperaCargosBd(){
        Cargo c;
        ArrayList<Cargo> cargos = new ArrayList<>();

        try {
        	String erro = cfgDao.conectaBD(); // Abre a conex�o com o banco de dados.
        	if (erro.equals("Sucesso")) {
	            conexao = cfgDao.getConexaoBD();
	            instrucaoSQL = "SELECT IdCargo, Descricao FROM cargo";
	            comando = conexao.prepareStatement(instrucaoSQL);
	            
	            // Executa a instru��o SQL e retorna os dados ao objeto ResultSet.
	            registros = comando.executeQuery(); 
	            
	            if (registros.next()) { // Se for retornado pelo menos um registro.
	                registros.beforeFirst(); // Retorna o cursor para antes do 1� registro.
	                while (registros.next()) { // Percorre os registros retornados.
	                    Integer idCargo = Integer.parseInt(registros.getString("IdCargo")); // Obt�m o id armazenado no registro.
	                    String descricao = registros.getString("Descricao"); // Obt�m a descri��o armazenada no registro.
	
	                    // Atribui os dados do cargo ao objeto Cargo por meio dos m�todos set e
	                    // adiciona este objeto ao ArrayList cargos.
	                    c = new Cargo();
	                    c.setIdCargo(idCargo);
	                    c.setDescricao(descricao);
	                    cargos.add(c);
	                }
	            }
	            cfgDao.desconectaBD(); // Fecha a conex�o com o banco de dados.
        	} else
        		cargos = null; // Caso ocorra exce��o ao tentar conectar com o banco de dados.
        } catch (Exception e) {
        	cargos = null; // Caso ocorra qualquer outra exce��o.
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
	            cfgDao.desconectaBD(); // Fecha a conex�o com o banco de dados.
        	}
			
			return null;
		}
		catch (Exception e) {
			return "Tipo de Exce��o: " + e.getClass().getSimpleName() + "\n * Mensagem: " + e.getMessage();
		}
	}
}
