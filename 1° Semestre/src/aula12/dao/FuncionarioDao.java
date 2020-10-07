package aula12.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import aula12.model.funcionario.Funcionario;

public class FuncionarioDao {
	private ConfigDao cfgDao; // Objeto para conex�o com o banco de dados.
	private String instrucaoSQL; // Instru��o SQL a ser executada.
    private Connection conexao; // Objeto que recebe os dados de conex�o com o banco de dados.
    private PreparedStatement comando; // Objeto usado para preparar e executar instru��es SQL.
    
    // Recebe um objeto Funcionario e tenta inserir seus dados no banco.
	public String insereFuncionario(Funcionario funcionario){
		cfgDao = new ConfigDao();
		
        try {
        	String erro = cfgDao.conectaBD(); // Abre a conex�o com o banco de dados.
        	if (erro == null) { 
	            conexao = cfgDao.getConexaoBD(); // Obt�m os dados de conex�o com o banco de dados.
	            instrucaoSQL = "INSERT INTO funcionario VALUES (null, "
		                        + "'" + funcionario.getNome() + "'," 
		                        + "'" + funcionario.getSexo() + "',"
		                        + funcionario.getSalario() + ","
		                        + funcionario.isPlanoSaude() + ","
		                        + funcionario.getCargo().getIdCargo() + ")"; 
	            comando = conexao.prepareStatement(instrucaoSQL); // Prepara a instru��o SQL.
	            comando.execute(); // Executa a instru��o SQL.
	            cfgDao.desconectaBD(); // Fecha a conex�o com o banco de dados.
        	} else
        		return erro; // Caso ocorra exce��o ao tentar conectar com o banco de dados.
        } catch (Exception e) {
        	// Caso ocorra qualquer tipo de exce��o.
            return "Tipo de Exce��o: " + e.getClass().getSimpleName() + "\n * Mensagem: " + e.getMessage(); 
        }
        return null; // Se o funcion�rio foi inserido com sucesso.
	}
}