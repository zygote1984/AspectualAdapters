package zygote.binding.example.shapes;

import java.util.ArrayList;

import zygote.binding.example.shapes.gen.CircleAdapter;
import zygote.binding.example.shapes.gen.Shapes;
import zygote.binding.lib.Adapter;
import zygote.binding.lib.AdapterSelector;

public class ShapeInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ShapeCreator.createSomeShapes();
			
		for(Adapter s: AdapterSelector.getAdaptors(Shapes.aspectOf().getMap()))
		{
			System.out.println(((ShapeArea)s).getArea());
			System.out.println(((ShapeCircum)s).getCircum());
		}
		
	
	}

}
