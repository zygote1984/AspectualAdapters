package zygote.binding.example.shapes2.gen;

import zygote.binding.example.shapes2.Circle;
import zygote.binding.example.shapes2.ShapeArea;
import zygote.binding.example.shapes2.ShapeCircum;
import zygote.binding.lib.Adapter;

public class CircleAdapter extends ShapeAdapter{
	
	Circle shapes;
	
	public CircleAdapter(Circle shapes)
	{
		super(shapes);
		this.shapes = shapes;
	}

	public String getArea()
	{
		return "Circle Area: " +  3*shapes.getR()*shapes.getR();
	}

	public int area(){
		return  3*shapes.getR()*shapes.getR();
	}
	
	public String getCircum(){
	
		return "Circle Circumference: "  + 2*3*shapes.getR();
	}

}
