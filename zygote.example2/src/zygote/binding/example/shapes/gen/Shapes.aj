package zygote.binding.example.shapes.gen;

import java.util.WeakHashMap;
import zygote.binding.example.shapes.*;
import zygote.binding.lib.Adapter;

public aspect Shapes {
	
	
	WeakHashMap<Shape, Adapter> map = new WeakHashMap<Shape, Adapter>(); 
	
	after() returning(Shape s): call(Shape+.new(..)){
		
		if(s instanceof Circle)
			map.put(s, new CircleAdapter((Circle)s));
		else if(s instanceof Rectangle)
			map.put(s, new RectangleAdapter((Rectangle)s));
	}
	

	public WeakHashMap<Shape, Adapter> getMap()
	{
		return map;
	}
}
