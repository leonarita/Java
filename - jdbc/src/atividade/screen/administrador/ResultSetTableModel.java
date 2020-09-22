package atividade.screen.administrador;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private final Connection connection;
	private final Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;

	// monitora o status da conex�o de banco de dados
	private boolean connectedToDatabase = false;

	// construtor inicializa resultSet e obt�m seu objeto de metadados, determinando o n�mero de linhas
	public ResultSetTableModel(String url, String username, String password, String query) throws SQLException {

		// conecta-se ao banco de dados
		connection = DriverManager.getConnection(url, username, password);

		// cria Statement para consultar o banco de dados
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// atualiza status de conex�o de banco de dados
		connectedToDatabase = true;
		
		// configura consulta e a executa
		setQuery(query);
	}
 
	// obt�m a classe que representa o tipo de coluna
	public Class<?> getColumnClass(int column) throws IllegalStateException {

		// certifica-se de que h� uma conex�o dispon�vel com o banco de dados
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// determina a classe Java de coluna
		try {
			String className = metaData.getColumnClassName(column + 1);

			// retorna objeto Class que representa className�
			return Class.forName(className);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return Object.class; // se ocorrerem os problemas acima, sup�e tipo Object
	}

	// obt�m n�mero de colunas em ResultSet
	public int getColumnCount() throws IllegalStateException {

		// certifica-se de que h� uma conex�o dispon�vel com o banco de dados
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// determina n�mero de colunas
		try {
			return metaData.getColumnCount();
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		// se ocorrerem os problemas acima, retorna 0 para o n�mero de colunas
		return 0; 
	}

	// obt�m nome de uma coluna particular em ResultSet
	public String getColumnName(int column)	 throws IllegalStateException {

		// certifica-se de que h� uma conex�o dispon�vel com o banco de dados
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// determina o nome de coluna
		try {
			return metaData.getColumnName(column + 1);
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		// se ocorrerem problemas, retorna string vazia para nome de coluna
		return ""; 
	}

	// retorna n�mero de linhas em ResultSet
	public int getRowCount() throws IllegalStateException {

		// certifica-se de que h� uma conex�o dispon�vel com o banco de dados
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		return numberOfRows;
	}

	// obt�m valor na linha e coluna especificadas continua
	public Object getValueAt(int row, int column) throws IllegalStateException {

		// certifica-se de que h� uma conex�o dispon�vel com o banco de dados
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// obt�m um valor na linha e coluna de ResultSet especificada
		try {
			resultSet.absolute(row + 1); 	
			return resultSet.getObject(column + 1);
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		// se ocorrerem problemas, retorna objeto string vazio
		return ""; 
	}

	// configura nova string de consulta de banco de dados
	public void setQuery(String query) throws SQLException, IllegalStateException {

		// certifica-se de que h� uma conex�o dispon�vel com o banco de dados
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// especifica consulta e a executa
		resultSet = statement.executeQuery(query);

		// obt�m metadados para o ResultSet
		metaData = resultSet.getMetaData();

		// determina o n�mero de linhas em ResultSet
		resultSet.last(); // move para a �ltima linha
		numberOfRows = resultSet.getRow(); // obt�m n�mero de linha

		// notifica a JTable de que o modelo foi alterado
		fireTableStructureChanged();
	}

	// fecha Statement e Connection 
	public void disconnectFromDatabase() { 

		if (connectedToDatabase) { 

			// fecha Statement e Connection 
			try { 
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch (SQLException sqlException) {
				sqlException.printStackTrace(); 
			} 
			// atualiza status de conex�o de banco de dados
			finally 
			{ 
				connectedToDatabase = false; 
			} 
		}
	}

}
