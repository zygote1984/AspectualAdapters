package zygote.binding.example.shapes.binding;

import zygote.binding.example.shapes.*;
import java.util.WeakHashMap;
import zygote.binding.example.shapes.*;

public class CircleAdapter implements ShapeArea, ShapeCircum {

	Circle adaptee;

	public CircleAdapter(Circle adaptee) {
		this.adaptee = adaptee;
	}

	public String getArea() {
		return "" + 3 * adaptee.getR() * adaptee.getR();
	}

	public String getCircum() {
		return "" + 2 * 3 * adaptee.getR();
	}

}
