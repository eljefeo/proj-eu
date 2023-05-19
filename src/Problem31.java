import java.util.ArrayList;
import java.util.List;

public class Problem31 implements Problem  {

	/*
	 * In the United Kingdom the currency is made up of pound ($) and pence (p).
	 * There are eight coins in general circulation:
	 * 
	 * 1p, 2p, 5p, 10p, 20p, 50p, x$1 (100p), and x$2 (200p).
	 * 
	 * It is possible to make $2 in the following way:
	 * 
	 * 1x1 + 1x50p + 2x20p + 1x5p + 1x2p + 3x1p How many different ways can $2
	 * be made using any number of coins?
	 * 
	 */
	// public static List<Integer[]> allcombs;

	public static void main(String[] args) {
		Problem p = new Problem31();
		p.runProblem();
	}

	static List<List<Integer>> all;

	public Object problem() {
		all = new ArrayList<List<Integer>>();
		int[] UKcoins = {1,2,5,10,20,50,100,200} ;
		int agoal = 200;
		
		//int[] nums = new int[] { 1, 2, 3};
		//int goal = 6;
		
		//long startT = System.nanoTime();
		
		//findAllNumsThatAddToNumWithResults(nums, goal);
		int res = findAllNumsThatAddToNumJustCount(UKcoins, agoal);
		
		//long endT = System.nanoTime();
		
		//double time = (double) (endT - startT)/1000000000;
		  
		return res;
		
	}
	
	private static int findAllNumsThatAddToNumJustCount(int[] nums, int goal){
		return recurLoopJustCount(nums, goal, 0, 0);
		//System.out.println("Found " + count + " solutions ");
	}
	
	private static int recurLoopJustCount(int[] allNums, int goal,  int ind, int counter) {
		if (goal==0) {
			counter++;
		} else if (goal>0) {
			for (int i = ind; i < allNums.length; i++) {
				int newGoal = goal - allNums[i];
				if(newGoal>=0){
					counter = recurLoopJustCount(allNums, newGoal, i, counter);
				} 
			}
		} 
		return counter;
	}
	
	private static void findAllNumsThatAddToNumWithResults(int[] nums, int goal){
		recurLoopWithResults(nums, goal, new ArrayList<Integer>(), 0);
		System.out.println("Heres " + all.size() + " solutions we found (nums in each solution are in no particular order, order doesnt matter for this):");
		
		for (List<Integer> li : all) {
			for (Integer i : li) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}


	private static boolean recurLoopWithResults(int[] allNums, int goal, List<Integer> myNums, int ind) {

		if (goal==0) {
			/*if(cc % 150 == 0){
				System.out.print("\nFound #" + cc + " :: ");
			}*/
				all.add(myNums);
				return true;
		} else if (goal>0) {//1 2 3
			for (int i = ind; i < allNums.length; i++) {
			List<Integer> ll = new ArrayList<Integer>();
			ll.addAll(myNums);
			ll.add(allNums[i]);
				int newGoal = goal - allNums[i];
				if(newGoal >= 0){
					boolean lte0 = recurLoopWithResults(allNums, newGoal, ll, i);
					if(lte0){
						return false;
					}	
				} 
			}
		} else if (goal < 0) {
			return true;
		}
		return false;
	}


}
