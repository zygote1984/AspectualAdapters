package zygote.binding.example.vga2hdmi.gen;

import zygote.binding.example.vga2hdmi.IDvi;
import zygote.binding.example.vga2hdmi.Vga;
import zygote.binding.lib.Adapter;

public class Vga2Dvi extends Adapter implements IDvi {
	
	Vga vga;
	
	public Vga2Dvi(Vga vga)
	{
		super();
		this.vga = vga;
	}

	@Override
	public String dvi() {
		return "vga -> dvi";
	}

	
}
