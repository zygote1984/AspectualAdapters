package zygote.binding.example.ibmExample.binding; 

import zygote.binding.example.ibmExample.*; 

import java.util.WeakHashMap;
import zygote.binding.example.ibmExample.*; 

   aspect SensorReadBinding 
{
	pointcut pc_rad1()  : call( public RadiatorDetection .new( ) )   ;
	WeakHashMap<RadiationDetector, SensorReader1>  RadiationDetector_SensorReader1_map = new WeakHashMap<RadiationDetector, SensorReader1>(); 
	after() returning(RadiationDetector instance): pc_rad1()
	{
		 RadiationDetector_SensorReader1_map.put(instance, new SensorReader1(instance));
	}
	pointcut pc_rad2()  : call( public RadiatorDetection .new( ) )   ;
	WeakHashMap<RadiationDetector, SensorReader2>  RadiationDetector_SensorReader2_map = new WeakHashMap<RadiationDetector, SensorReader2>(); 
	after() returning(RadiationDetector instance): pc_rad2()
	{
		 RadiationDetector_SensorReader2_map.put(instance, new SensorReader2(instance));
	}
	pointcut pc_temp()  : call( public TemperatureGauge .new( ) )   ;
	WeakHashMap<TemperatureGauge, SensorReader3>  TemperatureGauge_SensorReader3_map = new WeakHashMap<TemperatureGauge, SensorReader3>(); 
	after() returning(TemperatureGauge instance): pc_temp()
	{
		 TemperatureGauge_SensorReader3_map.put(instance, new SensorReader3(instance));
	}
}
