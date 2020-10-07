package aula12.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import aula12.model.funcionario.Funcionario;

public class FuncionarioDao {
	private ConfigDao cfgDao; // Objeto para conexão com o banco de dados.
	private String instrucaoSQL; // Instrução SQL a ser executada.
    private Connection conexao; // Objeto que recebe os dados de conexão com o banco de dados.
    private PreparedStatement comando; // Objeto usado para preparar e executar instruções SQL.
    
    // Recebe um objeto Funcionario e tenta inserir seus dados no banco.
	public String insereFuncionario(Funcionario funcionario){
		cfgDao = new ConfigDao();
		
        try {
        	String erro = cfgDao.conectaBD(); // Abre a conexão com o banco de dados.
        	if (erro == null) { 
	            conexao = cfgDao.getConexaoBD(); // Obtém os dados de conexão com o banco de dados.
	            instrucaoSQL = "INSERT INTO funcionario VALUES (null, "
		                        + "'" + funcionario.getNome() + "'," 
		                        + "'" + funcionario.getSexo() + "',"
		                        + funcionario.getSalario() + ","
		                        + funcionario.isPlanoSaude() + ","
		                        + funcionario.getCargo().getIdCargo() + ")"; 
	            comando = conexao.prepareStatement(instrucaoSQL); // Prepara a instrução SQL.
	            comando.execute(); // Executa a instrução SQL.
	            cfgDao.desconectaBD(); // Fecha a conexão com o banco de dados.
        	} else
        		return erro; // Caso ocorra exceção ao tentar conectar com o banco de dados.
        } catch (Exception e) {
        	// Caso ocorra qualquer tipo de exceção.
            return "Tipo de Exceção: " + e.getClass().getSimpleName() + "\n * Mensagem: " + e.getMessage(); 
        }
        return null; // Se o funcionário foi inserido com sucesso.
	}
}