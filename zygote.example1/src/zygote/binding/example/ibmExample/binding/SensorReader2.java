package zygote.binding.example.ibmExample.binding; 

import zygote.binding.example.ibmExample.*; 
import java.util.WeakHashMap;
import zygote.binding.example.ibmExample.*; 
public class SensorReader2 
	  implements   AdvancedSensorRead {
	
	RadiationDetector adaptee;
	
	public SensorReader2(RadiationDetector adaptee)
	{
		this.adaptee = adaptee;
	}
	
	public String getStatus () { 
		if ( adaptee .getCurrentRadiationLevel ( ) > 20 ) return "X-MEN" ; else return "OK" ; 
	} 
	
	
	
}
