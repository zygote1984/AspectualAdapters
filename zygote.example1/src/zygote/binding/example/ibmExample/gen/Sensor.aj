package zygote.binding.example.ibmExample.gen;

import java.util.WeakHashMap;

import zygote.binding.example.ibmExample.*;

public aspect Sensor {
	
	WeakHashMap<Object, SensorRead> map1 = new WeakHashMap<Object, SensorRead>();
//	WeakHashMap<RadiatorDetector, SensorReader2> map2 = new WeakHashMap<RadiatorDetector, SensorReader2>();
//	WeakHashMap<TemperatureGauge, SensorReader3> map3 = new WeakHashMap<TemperatureGauge, SensorReader3>();

	after() returning(RadiatorDetector rd)  : call(RadiatorDetector.new(..))  && within(Chernobyl)
	{
		SensorReader1 sr = new SensorReader1();
		sr.setSensor(rd);
		map1.put(rd, sr );
	}
	
	after() returning(RadiatorDetector rd)  : call(RadiatorDetector.new(..))  && within(FukushimaDaiichi)
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
	
	
	public WeakHashMap<Object, SensorRead> getMap1()
	{
		return map1;
	}
	
//	after(RadiatorDetector rd): call(* RadiatorDetector->getStatus()) && this(rd)
//	{
//		//search hashmaps for this rd and find the corresponding adaptor 
//		//execute the method
//	}
	
}
