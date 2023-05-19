
public interface Problem {
	
	
	public Object problem();
	public default String runProblem() {
		long startT = System.nanoTime();
		String answer = problem().toString();
		long endT = System.nanoTime();
		double time = (double) (endT - startT) / 1000000000;
		System.out.printf("Took %f seconds\n", time);
		System.out.printf("Answer : %s", answer);
		return answer;
	}
	
	public default int getId() {
		//System.out.println("Class: " + pp.getClass().toString());
		int classNum = Integer.parseInt(this.getClass().toString().split("class Problem")[1]);
		//System.out.println("Class: " + pp.getClass().toString() + ":::: " + classNum);
		return classNum;
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

	
	

}
