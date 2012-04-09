package zygote.binding.example.ibmExample;

public class RadiatorDetector {
	
	
	int rad = 0;
	public RadiatorDetector(int rad) {
		this.rad = rad;
		// TODO Auto-generated constructor stub
	}
	
	public void setRad(int rad) {
		this.rad = rad;
	}
	
	
	public double getCurrentRadiationLevel(){
	    return rad;
	  }
	

}
