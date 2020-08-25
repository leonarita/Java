package sistema.controleProcessos;

import java.sql.Date;

public class Cliente extends Pessoa {

	private int id;
	
	public Cliente(int codigo, String nome, Date nascto, int id) {
		super(codigo, nome, nascto);

		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
