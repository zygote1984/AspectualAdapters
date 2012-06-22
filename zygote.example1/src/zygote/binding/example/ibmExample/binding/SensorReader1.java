package zygote.binding.example.ibmExample.binding; 

import zygote.binding.example.ibmExample.*; 
import java.util.WeakHashMap;
import zygote.binding.example.ibmExample.*; 
public class SensorReader1 
	  implements   SensorRead {
	
	RadiationDetector adaptee;
	
	public SensorReader1(RadiationDetector adaptee)
	{
		this.adaptee = adaptee;
	}
	
	public String getStatus () { 
		if ( adaptee .getCurrentRadiationLevel ( ) > 10 ) return "TWO HEADED FISH" ; else return "OK" ; 
	} 
	
	
	
}
