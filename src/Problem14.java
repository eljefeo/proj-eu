import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem14 implements Problem { // Took 0.208588 seconds

	public static void main(String[] args) {
		Problem p = new Problem14();
		p.runProblem();
	}

	
	/*
	 * 
	 * The following iterative sequence is defined for the set of positive integers:


It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), 
it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
	 * 
	 */
	
	@Override
	public Object problem(){
		
		int biggestNumOfSteps = 0;
		int finalNum = 0;
		for(int i = 3; i < 1000000; i++){
			//System.out.println("on number: " + i);
			long test = i;
			int steps = 0;
			while(test!=1){
				//steps++;
				//test = Util.collatzConjectureNextNum(test);
				if(test % 2 == 0){
					test /= 2;
					steps++;
				} else { // save a step by dividing by 2 as well, 3n+1 will always be an even number anyway
					test = ((test * 3) + 1) / 2;
					steps += 2;
				}
			}
			if(steps > biggestNumOfSteps){
				biggestNumOfSteps = steps;
				finalNum = i;
				//System.out.println("new biggest: " + i + " with "  + steps  + " steps");
			}
		}
		
		System.out.println("Found " + finalNum + " with " + biggestNumOfSteps + " steps");
		return finalNum;
	}
	
	
	// this way keeps track of numbers we have already done, so we dont have to redo a num we have already hit..
	// but seems to take longer. Keeping track of all that info is heavy and takes a lot of work I guess
	public static String problem2(){
		
		//System.out.println("Here in 2");
		//long biggestTest = 0;
		int max = 1000000;
		//int[] oldy = new int[max];
		int biggestNumOfSteps = 0;
		int finalNum = 0;
		HashMap<Long, Integer> nums = new HashMap<Long, Integer>();
		for(int i = 3; i < max; i++){
			//System.out.println("Starting on number: " + i);
			List<Long> thisNums = new ArrayList<Long>();
			//thisNums.add((long)i);
			long test = i;
			int steps = 0;
			while(test!=1){
				//if(test > biggestTest) // this is just to see the highest number that we got up to 
				//	biggestTest = test;
				
				if(nums.containsKey(test)) {
					//System.out.println("on " + i + " : " + test + ", already did it: " + nums.get(test));
					steps += nums.get(test);
					break;
				} else {
					//System.out.println("thisnums adding i=" + i + ", test=" + test + " at step " + steps);
					thisNums.add(test);
					steps++;
					test = Util.collatzConjectureNextNum(test);
				}
			}
			
			if(steps > biggestNumOfSteps){
				biggestNumOfSteps = steps;
				finalNum = i;
				//System.out.println("new biggest: " + i + " with "  + steps  + " steps");
			}
			
			//System.out.println("done with " + i + ", steps = " + steps);
			for(Long l : thisNums) {
				//System.out.println("Putting into nums: " + l + " and steps " + steps + ": ");
				nums.put(l, steps--);
				
			}
		}
		System.out.println("Found " + finalNum + " with " + biggestNumOfSteps + " steps, with nums= " + nums.size());// + ", and biggest test = " + biggestTest);
		return "" + finalNum;
	}


}
