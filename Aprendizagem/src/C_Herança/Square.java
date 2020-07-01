package C_Heran�a;

public class Square extends Shape {
	
	protected double l;

	public Square(double sideLength) {
		this.l = sideLength;
	}

	@Override
	public double getArea() {
		return Math.pow(l,2);
	}
}
