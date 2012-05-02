package zygote.binding.example.shapes2;

import zygote.binding.example.shapes2.gen.Shapes;
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
			System.out.println(((ShapeColor)s).getColor());
		}
		
	
	}

}
