package zygote.binding.example.ibmExample.gen;

import java.util.ArrayList;

import zygote.binding.example.ibmExample.RadiationDetector;
import zygote.binding.example.ibmExample.SensorRead;
import zygote.binding.lib.Adapter;

public class SensorReader1 extends Adapter implements SensorRead{

	RadiationDetector pc_rad1 = null;
	
	
	

	public String _getStatus(RadiationDetector detector)
	{
		pc_rad1 =  detector;
		return this.getStatus();
	}


	@Override
	public String getStatus() {
		System.out.println("Chernobyl");
		if(pc_rad1.getCurrentRadiationLevel() > 10)
			return "TWO HEADED FISH";
		else
			return "OK";
	}


	@Override
	public void setSensor(Object sensor) {
		pc_rad1 = (RadiationDetector)sensor;
		
	}
	
}
