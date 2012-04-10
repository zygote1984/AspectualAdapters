package zygote.binding.examples.sendrec.gen;

import zygote.binding.examples.sendrec.LetterMonitor;
import zygote.binding.lib.Adapter;

public class LetterAdapter extends Adapter implements LetterMonitor {

	String letters;
	
	public LetterAdapter(String letter)
	{
		this.letters = letter;
	}
	
	@Override
	public void checkLetter(int i){
		if(letters.length() < i)
			System.out.println("Short Letter");
		else
			System.out.println("Long Letter");
	}


}
