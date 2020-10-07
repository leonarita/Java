package aula12.controller;

import java.util.ArrayList;

import aula12.dao.CargoDao;
import aula12.model.cargo.Cargo;

public class CargoController {
	private CargoDao cargoDao;

	// Recupera os cargos cadastrados no banco de dados para que sejam carregados no JComboBox Cargo.
	public ArrayList<Cargo> recuperaCargos(){
		cargoDao = new CargoDao();
		ArrayList<Cargo> cargos = cargoDao.recuperaCargosBd();		
		if (cargos != null)
			return cargos;
		else
			return null;
	}
}
