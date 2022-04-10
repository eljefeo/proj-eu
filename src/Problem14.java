
public class Problem14 implements Problem { // Took 0.208588 seconds

	public static void main(String[] args) {
		Problem p = new Problem14();
		p.runProblem();

	}
	
	/*
	 * 
	 * The following iterative sequence is defined for the set of positive integers:


It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
	 * 
	 */
	
	@Override
	public String problem(){
		
		int biggestNumOfSteps = 0;
		int finalNum = 0;
		for(int i = 3; i < 1000000; i++){
			//System.out.println("on number: " + i);
			long test = i;
			int steps = 0;
			while(test!=1){
				steps++;
				test = Util.collatzConjectureNextNum(test);
			}
			if(steps > biggestNumOfSteps){
				biggestNumOfSteps = steps;
				finalNum = i;
				//System.out.println("new biggest: " + i + " with "  + steps  + " steps");
			}
		}
		
		System.out.println("Found " + finalNum + " with " + biggestNumOfSteps + " steps");
		return "" + finalNum;
	}


}
