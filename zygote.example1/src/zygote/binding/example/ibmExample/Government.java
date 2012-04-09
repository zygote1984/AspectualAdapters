package zygote.binding.example.ibmExample;

import java.util.ArrayList;
import java.util.WeakHashMap;

import zygote.binding.example.ibmExample.gen.Sensor;
import zygote.binding.example.ibmExample.gen.SensorReader1;

public class Government {

	public static void main(String[] args)
	{
//		
//		Chernobyl reactor1 = new Chernobyl();
//		FukushimaDaiichi reactor2 = new FukushimaDaiichi();
//		ArrayList<RadiatorDetector> total = reactor1.rd;
//		total.addAll(reactor2.rd);
		
		WeakHashMap map = Sensor.aspectOf().getMap1();
		ArrayList<SensorRead> total = (ArrayList) map.values();
		
		for(SensorRead s: total)
		{
			/*
			 * Right now the code is ugly but a notation like
			 * s->getStatus() can automatically call the corresponding adaptor and return the result
			 * Actually this is still not what we want
			 * We want to query the SensorRead instances, not the actual sensors...
			 */
			System.out.println("\n SensorStatus:" + s.getStatus());
			
		}
		
	}
	
	
}
