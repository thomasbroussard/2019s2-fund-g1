package fr.epita.geometry.launcher;

import java.util.Arrays;
import java.util.List;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Shape;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;

public class Launcher {

	public static void main(String[] args) {
		Shape t1 = new Triangle(1, 2, 3, 1.5);
		Shape t2 = new Triangle(10, 20, 20, 15);

		Shape c1 = new Circle(2);
		Shape c2 = new Circle(20);

		Shape s1 = new Square(1);
		Shape s2 = new Square(10);

		List<Shape> shapes = Arrays.asList(t1, t2, c1, c2, s1, s2);
		double globalArea = 0;
		double globalPerimeter = 0;
		for (Shape shape : shapes) {
			globalArea += shape.calculateArea();
			globalPerimeter += shape.calculatePerimeter();
		}
		
		System.out.println(globalArea);
		System.out.println(globalPerimeter);

	}

}
