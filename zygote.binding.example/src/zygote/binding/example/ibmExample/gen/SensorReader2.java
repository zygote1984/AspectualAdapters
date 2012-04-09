package zygote.binding.example.ibmExample.gen;

import zygote.binding.example.ibmExample.RadiatorDetector;
import zygote.binding.example.ibmExample.SensorRead;

public class SensorReader2 implements SensorRead{
	
	RadiatorDetector pc_rad2 = null;
	

	public String _getStatus(RadiatorDetector detector)
	{
		pc_rad2 =  detector;
		return this.getStatus();
	}


	@Override
	public String getStatus() {
		if(pc_rad2.getCurrentRadiationLevel() > 20)
			return "X-MEN";
		else
			return "OK";
	}
	
	
	@Override
	public void setSensor(Object sensor) {
		pc_rad2 = (RadiatorDetector)sensor;
		
	}
	

}
