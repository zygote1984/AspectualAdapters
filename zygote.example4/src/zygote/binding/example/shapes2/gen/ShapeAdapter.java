package zygote.binding.example.shapes2.gen;

import zygote.binding.example.shapes2.Shape;
import zygote.binding.example.shapes2.ShapeArea;
import zygote.binding.example.shapes2.ShapeCircum;
import zygote.binding.example.shapes2.ShapeColor;
import zygote.binding.lib.Adapter;

public abstract class ShapeAdapter extends Adapter implements ShapeColor, ShapeArea, ShapeCircum {
	
	Shape shape;
	String color = "RED";
	
	ShapeAdapter(Shape s)
	{
		shape = s;
	}
	
	public String getColor(){
		if (this.area() > 40)
			return "RED";
		else
			return "BLUE";
	}
	


}
