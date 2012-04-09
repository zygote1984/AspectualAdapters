package zygote.binding.example.ibmExample;

import java.util.ArrayList;

public class FukushimaDaiichi {
	
	public ArrayList<RadiatorDetector> rd;
	
	public FukushimaDaiichi()
	{
		rd = new ArrayList<RadiatorDetector>();
		rd.add(new RadiatorDetector(11));
		rd.add(new RadiatorDetector(22));
		rd.add(new RadiatorDetector(2));
	}
	

}
