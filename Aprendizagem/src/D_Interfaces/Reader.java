package D_Interfaces;

public class Reader {

	String text;
	
	public void readIt (IReadable readMaterial) {
		text = readMaterial.read();
	}
	
	public void printIt () {
		if (text!=null)
			System.out.println(text);
	}
}
