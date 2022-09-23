
public interface Problem {
	
	public default String runProblem() {
		long startT = System.nanoTime();
		String answer = "" + problem();
		long endT = System.nanoTime();
		double time = (double) (endT - startT) / 1000000000;
		System.out.printf("Took %f seconds\n", time);
		System.out.printf("Answer : %s", answer);
		return answer;
	}
	
	
	
	/*
	 // Example:
	 public class Problem999 implements Problem{
	 
			 public static void main(String[] args) {
				
				//then you can either just do this one line :
				new Problem999().runProblem();
				
				
				// or you can do this
				Problem p = new Problem999();
				p.runProblem();
				
				
				//you can also do this to run other methods in here for some testing maybe
				((Problem999) p).test();
			}
	 
	 
			 @Override
			 public void problem(){
			 	// do all the stuff here
			 }
			 
			 public void test() {
			 // some other test stuff here maybe
				System.out.println("Hello test");
			}
	 
	 }
	 
	 */

	
	public Object problem();

}
