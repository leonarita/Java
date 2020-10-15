package testeSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import aula12.model.cargo.Cargo;

public class CargoDao {
	private ConfigDao cfgDao= new ConfigDao();
	private String instrucaoSQL;
    private Connection conexao;
    private PreparedStatement comando; 
    private ResultSet registros;

    public ArrayList<Cargo> recuperaCargosComecandoComString(String string){
        Cargo c;
        ArrayList<Cargo> cargos = new ArrayList<>();

        try {
        	String erro = cfgDao.conectaBD();
        	if (erro.equals("Sucesso")) {
	            conexao = cfgDao.getConexaoBD();
	            instrucaoSQL = "SELECT IdCargo, Descricao, Departamento FROM cargo WHERE Descricao LIKE '" + string + "%'";
	            comando = conexao.prepareStatement(instrucaoSQL);
	            
	            registros = comando.executeQuery(); 
	            
	            if (registros.next()) {
	                registros.beforeFirst();

	                while (registros.next()) {

	                    Integer idCargo = Integer.parseInt(registros.getString("IdCargo"));
	                    String descricao = registros.getString("Descricao");

	                    c = new Cargo();
	                    c.setIdCargo(idCargo);
	                    c.setDescricao(descricao);
	                    cargos.add(c);
	                }
	            }
	            cfgDao.desconectaBD();
        	} else
        		cargos = null;
        } catch (Exception e) {
        	cargos = null;
        }
        return cargos;
	}
    
    public ArrayList<Cargo> recuperaCargosComecandoEstaEntre(int a, int b){
        Cargo c;
        ArrayList<Cargo> cargos = new ArrayList<>();

        try {
        	String erro = cfgDao.conectaBD();
        	if (erro.equals("Sucesso")) {
	            conexao = cfgDao.getConexaoBD();
	            instrucaoSQL = "SELECT IdCargo, Descricao, Departamento FROM cargo WHERE IdCargo BETWEEN " + a + " AND " + b;
	            comando = conexao.prepareStatement(instrucaoSQL);
	            
	            registros = comando.executeQuery(); 
	            
	            if (registros.next()) {
	                registros.beforeFirst();

	                while (registros.next()) {

	                    Integer idCargo = Integer.parseInt(registros.getString("IdCargo"));
	                    String descricao = registros.getString("Descricao");

	                    c = new Cargo();
	                    c.setIdCargo(idCargo);
	                    c.setDescricao(descricao);
	                    cargos.add(c);
	                }
	            }
	            cfgDao.desconectaBD();
        	} else
        		cargos = null;
        } catch (Exception e) {
        	cargos = null;
        }
        return cargos;
	}
    
    public ArrayList<Cargo> recuperaCargosComecandoEstaEntreRange(int a, int b){
        Cargo c;
        ArrayList<Cargo> cargos = new ArrayList<>();

        try {
        	String erro = cfgDao.conectaBD();
        	if (erro.equals("Sucesso")) {
	            conexao = cfgDao.getConexaoBD();
	            instrucaoSQL = "SELECT IdCargo, Descricao, Departamento FROM cargo WHERE IdCargo IN " + buildString(a, b);
	            comando = conexao.prepareStatement(instrucaoSQL);
	            
	            registros = comando.executeQuery(); 
	            
	            if (registros.next()) {
	                registros.beforeFirst();

	                while (registros.next()) {

	                    Integer idCargo = Integer.parseInt(registros.getString("IdCargo"));
	                    String descricao = registros.getString("Descricao");

	                    c = new Cargo();
	                    c.setIdCargo(idCargo);
	                    c.setDescricao(descricao);
	                    cargos.add(c);
	                }
	            }
	            cfgDao.desconectaBD();
        	} else
        		cargos = null;
        } catch (Exception e) {
        	cargos = null;
        }
        return cargos;
	}
    
    public String buildString(int a, int b) {

    	if (a > b)
    		return "()";
    	
    	StringBuilder s = new StringBuilder();

    	
    	s.append("(");
    	
    	for(int i=a; i<=b; i++) {
    		s.append(i);
    		
    		if(i != b)
    			s.append(", ");
    	}
    	
    	s.append(")");
    	return s.toString();
    }
}
