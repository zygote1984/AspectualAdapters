package zygote.binding.lib;

import java.util.ArrayList;
import java.util.WeakHashMap;

public class AdapterSelector {

	public static ArrayList<Adapter> getAdaptors(WeakHashMap<? extends Object, Adapter> map)
	{
		
		ArrayList<Adapter> adapters = new ArrayList<Adapter>();
		for(Adapter a: map.values())
			adapters.add(a);
		return adapters;
	}
	
	
	//getAdapter(Object o, "HdmiAdapter").stream()
	
}
