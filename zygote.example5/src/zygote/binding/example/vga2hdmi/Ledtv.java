package zygote.binding.example.vga2hdmi;

public class Ledtv {
	
	Hdmi in;

	public Ledtv() {
		super();
		in = new Hdmi();
	}

	public Hdmi getIn() {
		return in;
	}

	public void setIn(Hdmi in) {
		this.in = in;
	}
	
	

}
