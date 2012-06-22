package zygote.binding.lib;

import java.util.ArrayList;
import java.util.WeakHashMap;

public aspect AdapterCollector {
	
	
	WeakHashMap<String, ArrayList<Adapter>> adapters = new WeakHashMap<String, ArrayList<Adapter>>();
	
	after() returning(Adapter a): call(Adapter+.new(..))
	{
		String key = a.getClass().getSimpleName();
		if(adapters.keySet().contains(key))
		{
			adapters.get(key).add(a);
		}
	}
	
	public ArrayList<Adapter> adapters(String a)
	{
		return adapters.get(a);
	}

}
