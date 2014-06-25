
public class Calculate {

	private 
	int count;
	int length;
	double percentage;
	
	public Calculate(int ammount, int len ){count = ammount; length = len;}
	
	public void displayResult(){
		System.out.println("\n");
	   	percentage = ((float)count/length)*100.0;
	   	System.out.println("\nNumber of copied sentences: " + count + 
			  "\n" + "ratio of copied sentences: " + (int)percentage + "%\n");
	}
	
}
