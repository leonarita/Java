package teste;

import java.util.List;

public class Main {
	private static CargoRepository cr = new CargoRepository();

	public static void main(String[] args) {

		//cadastrar()
		listarTodos();
		//obterPorId();
	}
	
	public void cadastrar() {
		Cargo c = new Cargo();
		c.setDescricao("Analista de usabilidade");
		c.setDepartamento("Gerência de usabilidade");
		cr.salvar(c);
	}
	
	public static void listarTodos() {
		List<Cargo> cargos = cr.listarTodos();
		
		for(Cargo c : cargos) {
			System.out.println(c.getDescricao() + " - " + c.getDepartamento());
		}
	}
	
	public static void obterPorId() {
		Cargo c = cr.obterPorId(7);
		System.out.println(c.getDescricao() + " - " + c.getDepartamento());
		atualizar(c);
		
		c = cr.obterPorId(8);
		System.out.println(c.getDescricao() + " - " + c.getDepartamento());
		remover(c);
	}
	
	public static void atualizar(Cargo c) {
		c.setDepartamento("Departamento oculto");
		cr.salvar(c);
	}
	
	public static void remover(Cargo c) {
		cr.remover(c);
	}

}
