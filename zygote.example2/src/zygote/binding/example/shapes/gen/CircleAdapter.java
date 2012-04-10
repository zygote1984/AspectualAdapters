package zygote.binding.example.shapes.gen;

import zygote.binding.example.shapes.Circle;
import zygote.binding.example.shapes.ShapeArea;
import zygote.binding.example.shapes.ShapeCircum;
import zygote.binding.lib.Adapter;

public class CircleAdapter extends Adapter implements ShapeArea, ShapeCircum{
	
	Circle shapes;
	
	public CircleAdapter(Circle shapes)
	{
		this.shapes = shapes;
	}

	public String getArea()
	{
		return "Circle Area: " +  3*shapes.getR()*shapes.getR();
	}


	public String getCircum(){
	
		return "Circle Circumference: "  + 2*3*shapes.getR();
	}

}
