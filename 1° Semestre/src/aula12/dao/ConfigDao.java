package aula12.dao;

import java.sql.*;

public class ConfigDao {
    private Connection conexao; // Objeto que receber� os dados para conex�o com o banco de dados.

    public String conectaBD() { // Abre a conex�o com o banco de dados.
        // String de conex�o (Dados: servidor, porta de conex�o, banco de dados, usu�rio, senha, uso de SSL e fuso hor�rio).
    	// O protocolo SSL criptografa o fluxo de dados entre o servidor de banco de dados 
    	// e a aplica��o cliente, protegendo-o de ataques externos.
    	// Dependendo da vers�o do MySQL e de como seu servidor est� configurado, tamb�m
    	// pode ser preciso determinar um fuso hor�rio espec�fico do servidor MySQL.
        String strCon = "jdbc:mysql://localhost/dpbd?useSSL=false";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de acesso ao MySQL.
            conexao = DriverManager.getConnection(strCon, "root", "123456");
        } catch (Exception e) {
        	// Caso ocorra qualquer tipo de exce��o.
            return "Tipo de Exce��o: " + e.getClass().getSimpleName() + "\n * Mensagem: " + e.getMessage(); 
        }
        return null; // Caso a conex�o ocorra com sucesso.
    }

    public void desconectaBD() { // Fecha a conex�o com o banco de dados.
        try {
            conexao.close();
        } catch (Exception e) {
        	// Caso ocorra exce��o, o tratamento ser� feito pelo m�todo chamador.
        }
    }

    public Connection getConexaoBD() { // Retorna o objeto que cont�m os dados para conex�o com o banco de dados.
        return conexao;
    }
}