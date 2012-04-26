package zygote.binding.example.ibmExample;

import java.util.ArrayList;

public class FukushimaDaiichi {
	
	public ArrayList<RadiationDetector> rd;
	
	public FukushimaDaiichi()
	{
		rd = new ArrayList<RadiationDetector>();
		rd.add(new RadiationDetector(11));
		rd.add(new RadiationDetector(22));
		rd.add(new RadiationDetector(2));
	}
	

}
