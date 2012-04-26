package zygote.binding.example.ibmExample.gen;

import zygote.binding.example.ibmExample.RadiationDetector;
import zygote.binding.example.ibmExample.SensorRead;
import zygote.binding.lib.Adapter;
import zygote.binding.lib.AdapterAspect;

public class SensorReader2 extends Adapter implements SensorRead{
	
	RadiationDetector pc_rad2 = null;
	
	public String _getStatus(RadiationDetector detector)
	{
		pc_rad2 =  detector;
		return this.getStatus();
	}


	@Override
	public String getStatus() {
		System.out.println("Fukushima");
		if(pc_rad2.getCurrentRadiationLevel() > 20)
			return "X-MEN";
		else
			return "OK";
	}
	
	
	@Override
	public void setSensor(Object sensor) {
		pc_rad2 = (RadiationDetector)sensor;
		
	}
	

}
