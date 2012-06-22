package zygote.binding.example.ibmExample;

public class RadiationDetector {
	
	
	int rad = 0;
	public RadiationDetector(int rad) {
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
