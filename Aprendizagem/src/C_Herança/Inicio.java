package C_Herança;

public class Inicio {

	public static void main(String[] args) {

		Shape[] shapes = new Shape[2];
		
		shapes[0] = new Circle(2);
		shapes[0].setColor("Blue");
		
		shapes[1] = new Square(2);
		shapes[1].setColor("Red");

		for (Shape s: shapes) {
			System.out.println("\n\nCor:" + s.getColor() + "\nÁrea do " + s.getClass() + ": " + s.getArea());
		}
	}
}
