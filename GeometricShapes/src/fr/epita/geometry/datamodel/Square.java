package fr.epita.geometry.datamodel;

public class Square implements Shape {
	
	private double side;

	public Square(double side) {
		super();
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	
	}
	
	public double calculatePerimeter() {
		return this.side * 4;
	}
	public double calculateArea() {
		return this.side * this.side;
	}

}
