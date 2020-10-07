package aula12.controller;

import java.util.ArrayList;

import aula12.dao.CargoDao;
import aula12.model.cargo.Cargo;

public class CargoController {
	private CargoDao cargoDao = new CargoDao();

	// Recupera os cargos cadastrados no banco de dados para que sejam carregados no JComboBox Cargo.
	public ArrayList<Cargo> recuperaCargos(){
		ArrayList<Cargo> cargos = cargoDao.recuperaCargosBd();
		if (cargos != null)
			return cargos;
		else
			return null;
	}

	public String insere(String departamento, String descricao) {
		String message;
		
		Cargo cargo = new Cargo();
			
		if (!departamento.equals(""))
			cargo.setDepartamento(departamento);
			
		if (!descricao.equals(""))
			cargo.setDescricao(descricao);
			
		message = cargoDao.insereCargoBd(cargo);
		
		return message;
	}

}
