package E_Classes_Aninhadas;

public class Reader {
	
	class DefaultReadingMaterial implements IReadable {
		
		@Override
		public String read() {
				return "Bula de remédio!";
		}
	}

	String text;
	
	public void readIt (IReadable readMaterial) {
		text = readMaterial.read();
	}
	
	public void printIt () {
		if (text==null)
			readIt(new DefaultReadingMaterial());
			
		System.out.println(text);
	}
}
