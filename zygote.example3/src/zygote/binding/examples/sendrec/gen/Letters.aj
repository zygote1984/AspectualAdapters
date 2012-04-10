package zygote.binding.examples.sendrec.gen;

import zygote.binding.examples.sendrec.*;
import java.util.WeakHashMap;
import zygote.binding.lib.Adapter;


public aspect Letters {
	
	WeakHashMap<String,Adapter> map = new WeakHashMap<String,Adapter>();
	
	
	after(String letter): call(* Sender.send(..)) && args(letter)
	{
		map.put(letter, new LetterAdapter(letter));
	}
	
	public WeakHashMap<String, Adapter> getMap()
	{
		return map;
	}

}
