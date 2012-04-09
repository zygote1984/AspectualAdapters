package zygote.binding.example.ibmExample;

import java.util.ArrayList;

public class Chernobyl {
	
	
	public ArrayList<RadiatorDetector> rd;
	
	public Chernobyl() {
		rd = new ArrayList<RadiatorDetector>();
		rd.add(new RadiatorDetector(11));
		rd.add(new RadiatorDetector(8));
	}
	


}
