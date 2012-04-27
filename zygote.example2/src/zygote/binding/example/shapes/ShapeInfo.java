package zygote.binding.example.shapes;

import zygote.binding.example.shapes.binding.*;
import zygote.binding.lib.Adapter;
import zygote.binding.lib.AdapterSelector;

public class ShapeInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ShapeCreator.createSomeShapes();
		System.out.println(ShapesBinding.aspectOf().Circle_CircleAdapter_map.values());
		for(CircleAdapter s: ShapesBinding.aspectOf().Circle_CircleAdapter_map.values())
		{
			System.out.println(((ShapeArea)s).getArea());
			System.out.println(((ShapeCircum)s).getCircum());
		}
		
	
	}

}
