package zygote.binding.example.shapes.binding; 

import zygote.binding.example.shapes.*; 
import java.util.WeakHashMap;
import zygote.binding.example.shapes.*; 
public class RectangleAdapter 
	  implements   ShapeArea  , ShapeCircum {
	
	Rectangle adaptee;
	
	public RectangleAdapter(Rectangle adaptee)
	{
		this.adaptee = adaptee;
	}
	
	public String getArea () { 
		return "Rectangle Area: " + adaptee .getA ( ) * adaptee .getB ( ) ; 
	} 
	public String getCircum () { 
		return "Rectangle Circumference: " + 2 * ( adaptee .getA ( ) + adaptee .getB ( ) ) ; 
	} 
	
	
	
}
