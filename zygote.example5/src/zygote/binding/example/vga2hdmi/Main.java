package zygote.binding.example.vga2hdmi;

import zygote.binding.example.vga2hdmi.gen.VgaConvert;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Computer c = new Computer();
		Ledtv l = new Ledtv();
		
		System.out.println(VgaConvert.aspectOf().convert(c.getOut()).hdmi());

	}

}
