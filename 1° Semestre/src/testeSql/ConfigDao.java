package testeSql;

import java.sql.*;

public class ConfigDao {
    private Connection conexao;

    public String conectaBD() {

        String strCon = "jdbc:mysql://localhost/dpbd?useSSL=false";
        try {
            conexao = DriverManager.getConnection(strCon, "root", "123456");
            return "Sucesso";
        } catch (Exception e) {
            return "Tipo de Exceção: " + e.getClass().getSimpleName() + "\n * Mensagem: " + e.getMessage(); 
        }
    }

    public void desconectaBD() {
        try {
            conexao.close();
        } catch (Exception e) {
        }
    }

    public Connection getConexaoBD() {
        return conexao;
    }
}