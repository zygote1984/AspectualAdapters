package zygote.binding.example.vga2hdmi;

public class Computer {
	
	Vga out;
	
	public Computer(){
		out  = new Vga();	
	}

	public Vga getOut() {
		return out;
	}

	public void setOut(Vga out) {
		this.out = out;
	}
	
	

}
