package zygote.binding.example.shapes2;

import java.util.ArrayList;

public class ShapeCreator {
	
	public static void createSomeShapes()
	{
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle(5));
		shapes.add(new Rectangle(5, 4));
		shapes.add(new Circle(8));
		shapes.add(new Rectangle(9, 4));
		shapes.add(new Circle(11));
		shapes.add(new Rectangle(5, 2));
		shapes.add(new Circle(13));
		shapes.add(new Rectangle(4, 9));
		shapes.add(new Circle(5));
		shapes.add(new Rectangle(11, 4));
		shapes.add(new Rectangle(2, 3));
		Circle c = new Circle(6);
		c.setR(10);
	}

}
