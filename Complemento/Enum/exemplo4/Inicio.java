package exemplo4;

public class Inicio {

	public static void main(String[] args) {

		Turno turno = Turno.MANHA;
		Turno turno2 = Turno.TARDE;
		Turno turno3 = Turno.NOITE;
		
		System.out.println(turno);
		System.out.println(turno.ordinal());
		System.out.println(turno.name());
		
		System.out.println("\n\n");
		System.out.println(turno2);
		System.out.println(turno2.ordinal());
		System.out.println(turno2.name());
		
		System.out.println("\n\n");
		System.out.println(turno3);
		System.out.println(turno3.ordinal());
		System.out.println(turno3.name());
		
		System.out.println("\n\n");
		for (Turno t : Turno.values()) {
		      System.out.println(t.getDescricao());
		}
	}
}
