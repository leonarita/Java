package D_Interfaces;

public class Inicio {

	public static void main(String[] args) {

		Reader reader = new Reader();
		
		reader.readIt(new IReadable () {
			
			@Override
			public String read() {
				return "Classe anônima com base na interface IReadable";
			}
			
		});
		
		reader.printIt();

		System.out.println("\n\n");
		reader.readIt(new Runes());
		reader.printIt();
	}

}
