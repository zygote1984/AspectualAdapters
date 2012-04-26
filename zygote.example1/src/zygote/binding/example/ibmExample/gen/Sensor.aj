package zygote.binding.example.ibmExample.gen;

import java.util.WeakHashMap;

import zygote.binding.example.ibmExample.*;
import zygote.binding.lib.Adapter;
import zygote.binding.lib.AdapterAspect;

@AdapterAspect
public aspect Sensor {
	
	WeakHashMap<Object, Adapter> map1 = new WeakHashMap<Object, Adapter>();
//	WeakHashMap<RadiatorDetector, SensorReader2> map2 = new WeakHashMap<RadiatorDetector, SensorReader2>();
//	WeakHashMap<TemperatureGauge, SensorReader3> map3 = new WeakHashMap<TemperatureGauge, SensorReader3>();

	after() returning(RadiationDetector rd)  : call(RadiatorDetector.new(..))  && within(Chernobyl)
	{
		SensorReader1 sr = new SensorReader1();
		sr.setSensor(rd);
		map1.put(rd, sr );
	}
	
	after() returning(RadiationDetector rd)  : call(RadiatorDetector.new(..))  && within(FukushimaDaiichi)
	{
		SensorReader2 sr = new SensorReader2();
		sr.setSensor(rd);
		map1.put(rd, sr);
	}
	
	after() returning(TemperatureGauge tg)  : call(TemperatureGauge.new(..)) 
	{
		SensorReader3 sr = new SensorReader3();
		sr.setSensor(tg);
		map1.put(tg, sr);
	}
	
	
	public WeakHashMap<Object, Adapter> getMap1()
	{
		return map1;
	}
	
//	after(RadiatorDetector rd): call(* RadiatorDetector->getStatus()) && this(rd)
//	{
//		//search hashmaps for this rd and find the corresponding adaptor 
//		//execute the method
//	}
	
}
