package aula05.exercicio2;

public class Inicio {

	public static void main(String[] args) {
		
		Pessoa p = new Pessoa();
		p.setCpf("123456789");
		p.setNome("Leo");
		p.setRg("333344445");
		p.setEndereco("Rua Vargas", 12, "Santana", "S�o Paulo", "S�o Paulo");
		
		System.out.println("CPF: " + p.getCpf());
		System.out.println("Nome: " + p.getNome());
		System.out.println("RG: " + p.getRg());
		
		System.out.println("Endere�o");
		System.out.println(p.getEndereco());
	}

}
