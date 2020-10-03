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
		Set<Integer[]> allcombs = Util.createAllCombinationsWithRepeatsAddToNum(new int[]{ 0, 1, 2, 3 }, 3, 6);
		for (Integer[] in : allcombs) {
			for (int i = 0; i < in.length; i++) {
				System.out.print(" " + in[i]);
			}
			System.out.println();
		}

		System.out.println("Final count of combinations : " + allcombs.size());
	}

/*	static Set<Integer[]> createAllCombinationsWithRepeats(int[] data, int combinationSize, int goal) {
		Set<Integer[]> allcombs = new HashSet<Integer[]>();
		//int goal = 200;

		//int[] data = { 0, 1, 2 };
		//int[] data = { 0, 1, 2, 5, 10, 20, 100, 200 };
		//List<Integer[]> allcombs = new ArrayList<Integer[]>();
		

		int indexToChange = combinationSize - 1; // start with last num in comb
		Integer[] comb = new Integer[combinationSize];
		for(int i=0; i<combinationSize; i++){
			comb[i] = data[0];
		}
		if(addsUp(comb, goal)){
			Integer[] temp = comb.clone();
			Arrays.sort(temp);
			allcombs.add(temp);
		}
		//allcombs.add(comb.clone());
		
		while (true) {
			boolean reset = false;
			while (comb[indexToChange] == data[data.length - 1] && indexToChange > 0) {
				comb[indexToChange] = data[0];
				indexToChange--;
				reset = true;
			}
			int lasti = getIndex(data, comb[indexToChange]);
			comb[indexToChange] = data[lasti + 1];
			if(addsUp(comb, goal)){
				Integer[] temp = comb.clone();
				Arrays.sort(temp);
				allcombs.add(temp);
			}
			//allcombs.add(comb.clone());
			if (reset)
				indexToChange = combinationSize - 1;

			if (isDone(comb, data[data.length - 1])) {
				break;
			}
		}
		
		return allcombs;

		

	}

	private static boolean isDone(Integer[] nums, int maxVal) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != maxVal) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean addsUp(Integer[] nums, int goal){
		int total = 0;
		for(Integer i : nums){
			total += i;
			if(total > goal){
				return false;
			}
		}
		return total == goal;
	}

	private static int getIndex(int[] data, int num) {

		for (int i = 0; i < data.length; i++) {
			if (data[i] == num) {
				return i;
			}
		}
		return 0;
	}*/

}
