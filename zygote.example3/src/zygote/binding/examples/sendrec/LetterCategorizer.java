package zygote.binding.examples.sendrec;

import zygote.binding.examples.sendrec.gen.Letters;
import zygote.binding.lib.Adapter;
import zygote.binding.lib.AdapterSelector;

public class LetterCategorizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		sendLetters();
		int i  = 9;
		
		for(Adapter l:AdapterSelector.getAdaptors(Letters.aspectOf().getMap()))
		{
			((LetterMonitor)l).checkLetter(i);
		}
		
	}

	
	
	public static void sendLetters()
	{
		
		Sender s = new Sender();
		s.send("Kardelen");
		s.send("Kardelen213");
		s.send("Kardelenfdbfdbfd");
		s.send("Kardelenbfd");
		s.send("Kardelenfdbdnhsfjsnsf");
		s.send("Kar");
		s.send("Kardelendfs");
		s.send("Kardelen777");
		s.send("Kardelen9878963543576");
		
		
	}
}
