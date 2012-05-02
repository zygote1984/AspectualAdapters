package zygote.binding.example.shapes2.gen;

import zygote.binding.example.shapes2.Rectangle;
import zygote.binding.example.shapes2.ShapeArea;
import zygote.binding.example.shapes2.ShapeCircum;
import zygote.binding.lib.Adapter;

public class RectangleAdapter extends ShapeAdapter{
	
	Rectangle shapes;
	
	public RectangleAdapter(Rectangle shapes) {
		super(shapes);
		this.shapes = shapes;
	}
	
	
	public String getArea()
	{
		return "Rectangle Area: " + shapes.getA()*shapes.getB();
	}

	public int area(){
		return shapes.getA()*shapes.getB();
	}

	public String getCircum(){
	
		return "Rectangle Circumference: " + 2*(shapes.getA() + shapes.getB());
	}

}
