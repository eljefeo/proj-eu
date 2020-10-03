import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem31 {

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
		//problem2();
		/*String s= "abcd";
		int i=1;
		String rest = s.charAt(i)+"";
		String remaining = s.substring(0,i) + s.substring(i+1);
		System.out.println("rest:" + rest + " remaining:" + remaining);
		System.out.println("char at i:"+s.charAt(i));
		System.out.println("s.substring 0,"+i+ ":"+s.substring(0,i) + " ---- +s.substring "+(i+1)+":"+s.substring(i+1));
		System.out.println("remaining:"+remaining);*/
		problem();
		
	}
	
	private static void problem(){
		int[] nums = new int[] {1,2,3};
		int goal = 6;
		recur("", "abc");
		
	}
	static int counter = 0;
	private static void recur(String sofar, String rest){
		///System.out.println(counter + " here sofar : " + sofar + " rest : " + rest);
		if(rest.length() == 0){
			System.out.println(sofar);
		} else {
			for (int i = 0; i < rest.length(); i++) {
				
				String next = sofar + rest.charAt (i);
				String remaining = rest.substring(0,i) + rest.substring(i+1);
				//System.out.println("doing sofar:"+sofar+" rest:"+rest+ " next:" + next+ " remaining:" + remaining + " rest.charAt("+i+"):" + rest.charAt(i) + " rest.substring(0,"+i+"):"+rest.substring(0,i)+"  rest.substring("+i+"+1):"+rest.substring(i+1));
				recur(next, remaining);
			}
			System.out.println("Done with "+ counter++);
			
		}
	}
	
	private static void problem3(){
		int[] nums = new int[] {1,2,5,10,20,50,100,200};
		int goal = 200;
		List<List<Integer>> allc = new ArrayList<List<Integer>>();
		List<Integer> comb = new ArrayList<Integer>();
		
		int ii=0;
		while(goal>0){
			goal -= nums[ii];
			comb.add(nums[ii]);
			if(goal == 0){
				System.out.println("We got one!");
				allc.add(comb);
				comb = new ArrayList<Integer>();
				break;
			} 
			if(goal<0){
				System.out.println("Went tooo far");
				comb = new ArrayList<Integer>();
				break;
			}
			if(ii == nums.length){
				ii = 0;
			}
			
			
		}
		
		System.out.println("asolution : ");
		for(List<Integer> l : allc){
			for(Integer i : l){
				System.out.print(" "+i);
			}
			System.out.println("\n count : " + l.size());
		}
	}
	
	private static void problem2(){
		int[] nums = new int[] {0,1,2};
		int goal = 3;
		
		//figure out max size of combination
		int[] temp = nums.clone();
		Arrays.sort(temp);
		int smallest = temp[0] == 0 ? temp[1] : temp[0];
		int combSize = goal/smallest;
		System.out.println("Max Combination size : " + combSize);
		
		
		List<Integer[]> allcombs = createAllCombinationsWithRepeatsAddToNum(new int[]{ 0, 1, 2, 3, 4, 5, 6 }, combSize, goal);
		for (Integer[] in : allcombs) {
			for (int i = 0; i < in.length; i++) {
				System.out.print(" " + in[i]);
			}
			System.out.println();
		}

		System.out.println("Final count of combinations : " + allcombs.size());
	}
	
	static List<Integer[]> createAllCombinationsWithRepeatsAddToNum(int[] data, int combinationSize, int goal) {
		List<Integer[]> allcombs = new ArrayList<Integer[]>();
		
		int indexToChange = combinationSize - 1; // start with last num in comb
		Integer[] comb = new Integer[combinationSize];
		for (int i = 0; i < combinationSize; i++) {
			comb[i] = data[0];
		}
		if (Util.addsUp(comb, goal)) {
			allcombs.add(comb.clone());
		}
		while (true) {
			boolean reset = false;
			while (comb[indexToChange] == data[data.length - 1] && indexToChange > 0) {
				comb[indexToChange] = data[0];
				indexToChange--;
				reset = true;
			}
			int lasti = Util.getIndex(data, comb[indexToChange]);
			comb[indexToChange] = data[lasti + 1];
			if (Util.addsUp(comb, goal) ) {
				Integer[] temp = comb.clone();
				Arrays.sort(temp);
				if(!Util.listContainsIntArray(allcombs, temp))
					allcombs.add(temp);
			}

		if (reset)
			indexToChange = combinationSize - 1;

		if (Util.isDone(comb, data[data.length - 1])) {
			break;
		}
	}

	return allcombs;

	}
	
	public static boolean isRow(int row, double[][] array)
	{
	    return array != null && row >= 0 && row < array.length && array[row] != null;
	}
	



	/*
	 
	 What are all the ways to make 200 with biggest num (200)... 1 (then take that num away)
	 what are all the ways to make 200 with the second biggest num (100)... a lot (then take 100 away)
	 
	 
	 */

}
