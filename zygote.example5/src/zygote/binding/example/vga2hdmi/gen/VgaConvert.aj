package zygote.binding.example.vga2hdmi.gen;

import java.util.WeakHashMap;

import zygote.binding.example.vga2hdmi.*;
import zygote.binding.lib.Adapter;

public aspect VgaConvert{
	
	
	WeakHashMap<RootInterface, Adapter> map = new WeakHashMap<RootInterface, Adapter>();
	WeakHashMap<Vga2Dvi, Vga2Hdmi> map2 = new WeakHashMap<Vga2Dvi, Vga2Hdmi>();
	
	
	after() returning(Vga a): call(Vga.new(..))
	{
		Vga2Dvi b = new Vga2Dvi(a);
		map.put(a, b);
		map2.put(b, new Vga2Hdmi(b));
		
	}
	
	public Vga2Hdmi convert(Vga a)
	{
		Vga2Dvi b = (Vga2Dvi) map.get(a);
		return (Vga2Hdmi)map2.get(b);
	}

}
