package zygote.binding.example.shapes;

import java.util.ArrayList;

import zygote.binding.example.shapes.gen.Shapes;

public class ShapeInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
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
		
		for(Shape s:shapes)
		{
			System.out.println(((ShapeArea)Shapes.aspectOf().getMap().get(s)).getArea());
			System.out.println(((ShapeCircum)Shapes.aspectOf().getMap().get(s)).getCircum());
		}
		
	
	}

}
