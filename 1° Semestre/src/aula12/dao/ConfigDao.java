package aula12.dao;

import java.sql.*;

public class ConfigDao {
    private Connection conexao; // Objeto que receberá os dados para conexão com o banco de dados.

    public String conectaBD() { // Abre a conexão com o banco de dados.
        // String de conexão (Dados: servidor, porta de conexão, banco de dados, usuário, senha, uso de SSL e fuso horário).
    	// O protocolo SSL criptografa o fluxo de dados entre o servidor de banco de dados 
    	// e a aplicação cliente, protegendo-o de ataques externos.
    	// Dependendo da versão do MySQL e de como seu servidor está configurado, também
    	// pode ser preciso determinar um fuso horário específico do servidor MySQL.
        String strCon = "jdbc:mysql://localhost/dpbd?useSSL=false";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de acesso ao MySQL.
            conexao = DriverManager.getConnection(strCon, "root", "123456");
        } catch (Exception e) {
        	// Caso ocorra qualquer tipo de exceção.
            return "Tipo de Exceção: " + e.getClass().getSimpleName() + "\n * Mensagem: " + e.getMessage(); 
        }
        return null; // Caso a conexão ocorra com sucesso.
    }

    public void desconectaBD() { // Fecha a conexão com o banco de dados.
        try {
            conexao.close();
        } catch (Exception e) {
        	// Caso ocorra exceção, o tratamento será feito pelo método chamador.
        }
    }

    public Connection getConexaoBD() { // Retorna o objeto que contém os dados para conexão com o banco de dados.
        return conexao;
    }
}