package C_Herança;

public class Circle extends Shape {
	
	protected double r;

	public Circle(double radius) {
		this.r = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(r,2);
	}
}
