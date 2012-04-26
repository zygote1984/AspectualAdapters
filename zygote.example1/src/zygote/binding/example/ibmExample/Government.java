package zygote.binding.example.ibmExample;

import java.util.ArrayList;
import java.util.WeakHashMap;

import zygote.binding.example.ibmExample.binding.*;
import zygote.binding.lib.Adapter;
import zygote.binding.lib.AdapterSelector;

public class Government {

	public static void main(String[] args)
	{
//		
		Chernobyl reactor1 = new Chernobyl();
		FukushimaDaiichi reactor2 = new FukushimaDaiichi();
		
		for(Adapter sr: AdapterSelector.getAdaptors(SensorReadBinding.aspectOf().getMap1()))
		{
			System.out.println("\n SensorStatus:" + ((SensorRead)sr).getStatus());
			
		}
		
	}
	
	
}
