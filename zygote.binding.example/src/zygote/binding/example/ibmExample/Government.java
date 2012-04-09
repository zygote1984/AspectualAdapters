package zygote.binding.example.ibmExample;

import java.util.ArrayList;

import zygote.binding.example.ibmExample.gen.Sensor;
import zygote.binding.example.ibmExample.gen.SensorReader1;

public class Government {

	public static void main(String[] args)
	{
		
		Chernobyl reactor1 = new Chernobyl();
		FukushimaDaiichi reactor2 = new FukushimaDaiichi();
		ArrayList<RadiatorDetector> total = reactor1.rd;
		total.addAll(reactor2.rd);
		
		for(RadiatorDetector s: total)
		{
			/*
			 * Right now the code is ugly but a notation like
			 * s->getStatus() can automatically call the corresponding adaptor and return the result
			 * Actually this is still not what we want
			 * We want to query the SensorRead instances, not the actual sensors...
			 */
			
			SensorRead sr = Sensor.aspectOf().getMap1().get(s);
			System.out.println("Radiation level: " + s.getCurrentRadiationLevel() + "\n SensorStatus:" + sr.getStatus());
			
		}
		
	}
	
	
}
