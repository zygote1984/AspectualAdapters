package zygote.binding.example.shapes.binding;

import zygote.binding.example.shapes.*;

import java.util.WeakHashMap;
import zygote.binding.example.shapes.*;

aspect ShapesBinding {
	pointcut shapes()  : call( public Shape + .new( .. ) )   ;

	WeakHashMap<Circle, CircleAdapter> Circle_CircleAdapter_map = new WeakHashMap<Circle, CircleAdapter>();
	WeakHashMap<Rectangle, RectangleAdapter> Rectangle_RectangleAdapter_map = new WeakHashMap<Rectangle, RectangleAdapter>();

	after() returning(Shape instance): shapes()
	{
		if (instance instanceof Circle)
			Circle_CircleAdapter_map.put((Circle) instance, new CircleAdapter(
					(Circle) instance));
		if (instance instanceof Rectangle)
			Rectangle_RectangleAdapter_map.put((Rectangle) instance,
					new RectangleAdapter((Rectangle) instance));
	}
}
