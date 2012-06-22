package zygote.binding.example.ibmExample.binding; 

import zygote.binding.example.ibmExample.*; 
import java.util.WeakHashMap;
import zygote.binding.example.ibmExample.*; 
public class SensorReader3 
	  implements   AdvancedSensorRead {
	
	TemperatureGauge adaptee;
	
	public SensorReader3(TemperatureGauge adaptee)
	{
		this.adaptee = adaptee;
	}
	
	public String getStatus () { 
		if ( adaptee .readTemperature ( ) > 100 ) return "HOT" ; else return "OK" ; 
	} 
	
	
	
}
