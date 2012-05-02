package zygote.binding.example.shapes2.gen;

import java.util.WeakHashMap;

import zygote.binding.example.shapes2.*;
import zygote.binding.lib.Adapter;
import zygote.binding.lib.AdapterAspect;

@AdapterAspect
public aspect Shapes {
	
	
	WeakHashMap<Shape, Adapter> map = new WeakHashMap<Shape, Adapter>(); 
	
	pointcut pc(int i, Circle c): call(* Circle.setR(..)) && args(i) &&this(c) && if(c.getR() > 5);
	
	after(int i, Circle c):pc(i, c)
	{
		System.out.println("***************" +i);
	}
	
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
