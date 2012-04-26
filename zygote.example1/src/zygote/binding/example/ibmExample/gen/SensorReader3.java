package zygote.binding.example.ibmExample.gen;

import zygote.binding.example.ibmExample.RadiationDetector;
import zygote.binding.example.ibmExample.SensorRead;
import zygote.binding.example.ibmExample.TemperatureGauge;
import zygote.binding.lib.Adapter;

public class SensorReader3 extends Adapter implements SensorRead {
	
	TemperatureGauge pc_temp = null;
	

	public String _getStatus(TemperatureGauge gauge)
	{
		pc_temp =  gauge;
		return this.getStatus();
	}


	@Override
	public String getStatus() {
		if(pc_temp.readTemperature() > 100)
			return "HOT";
		else
			return "OK";
	}
	
	@Override
	public void setSensor(Object sensor) {
		pc_temp = (TemperatureGauge)sensor;
		
	}
	

}
