package zygote.binding.example.ibmExample.gen;

import java.util.ArrayList;

import zygote.binding.example.ibmExample.RadiatorDetector;
import zygote.binding.example.ibmExample.SensorRead;

public class SensorReader1 implements SensorRead{

	RadiatorDetector pc_rad1 = null;
	
	
	

	public String _getStatus(RadiatorDetector detector)
	{
		pc_rad1 =  detector;
		return this.getStatus();
	}


	@Override
	public String getStatus() {
		if(pc_rad1.getCurrentRadiationLevel() > 10)
			return "TWO HEADED FISH";
		else
			return "OK";
	}


	@Override
	public void setSensor(Object sensor) {
		pc_rad1 = (RadiatorDetector)sensor;
		
	}
	
}
