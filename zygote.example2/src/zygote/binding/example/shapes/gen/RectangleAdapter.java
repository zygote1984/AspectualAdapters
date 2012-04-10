package zygote.binding.example.shapes.gen;

import zygote.binding.example.shapes.Rectangle;
import zygote.binding.example.shapes.ShapeArea;
import zygote.binding.example.shapes.ShapeCircum;
import zygote.binding.lib.Adapter;

public class RectangleAdapter extends Adapter implements ShapeArea, ShapeCircum {
	
	Rectangle shapes;
	
	public RectangleAdapter(Rectangle shapes) {
		this.shapes = shapes;
	}
	
	
	public String getArea()
	{
		return "Rectangle Area: " + shapes.getA()*shapes.getB();
	}


	public String getCircum(){
	
		return "Rectangle Circumference: " + 2*(shapes.getA() + shapes.getB());
	}

}
