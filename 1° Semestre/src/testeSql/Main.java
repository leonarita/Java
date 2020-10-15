package testeSql;

import java.util.ArrayList;

import aula12.model.cargo.Cargo;

public class Main {

	public static void main(String[] args) {

		CargoDao c = new CargoDao();
		
		ArrayList<Cargo> cargos = c.recuperaCargosComecandoComString("Ana");
		for(Cargo cargo : cargos) {
			System.out.println("ID " + cargo.getIdCargo() + " - " + cargo.getDescricao());
		}
		
		System.out.println("\n");
		cargos = c.recuperaCargosComecandoEstaEntre(2, 6);
		for(Cargo cargo : cargos) {
			System.out.println("ID " + cargo.getIdCargo() + " - " + cargo.getDescricao());
		}
		
		System.out.println("\n");
		cargos = c.recuperaCargosComecandoEstaEntreRange(2, 6);
		for(Cargo cargo : cargos) {
			System.out.println("ID " + cargo.getIdCargo() + " - " + cargo.getDescricao());
		}

	}

}
