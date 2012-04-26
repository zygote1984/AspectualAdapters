package zygote.binding.example.ibmExample;

import java.util.ArrayList;

public class Chernobyl {
	
	
	public ArrayList<RadiationDetector> rd;
	public TemperatureGauge tg;
	
	public Chernobyl() {
		rd = new ArrayList<RadiationDetector>();
		rd.add(new RadiationDetector(11));
		rd.add(new RadiationDetector(8));
		tg = new TemperatureGauge(130);
	}
	


}
