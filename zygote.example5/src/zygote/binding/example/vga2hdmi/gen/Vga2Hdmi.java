package zygote.binding.example.vga2hdmi.gen;

import zygote.binding.example.vga2hdmi.IHdmi;
import zygote.binding.lib.Adapter;

public class Vga2Hdmi extends Adapter implements IHdmi{
	
	
	Vga2Dvi adapters;

	public Vga2Hdmi(Vga2Dvi adapters) {
		super();
		this.adapters = adapters;
	}




	@Override
	public String hdmi() {
		return adapters.dvi() + "->hdmi";
	}
	
	

}
