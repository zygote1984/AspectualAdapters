package zygote.binding.examples.sendrec;

public class Sender {
	
	
	public String send(String letter)
	{

		System.out.println("[Sender is sending...]" + letter);
		return letter;
	}

}
