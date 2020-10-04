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
		// problem2();
		/*
		 * String s= "abcd"; int i=1; String rest = s.charAt(i)+""; String
		 * remaining = s.substring(0,i) + s.substring(i+1);
		 * System.out.println("rest:" + rest + " remaining:" + remaining);
		 * System.out.println("char at i:"+s.charAt(i)); System.out.println(
		 * "s.substring 0,"+i+ ":"+s.substring(0,i) + " ---- +s.substring "
		 * +(i+1)+":"+s.substring(i+1));
		 * System.out.println("remaining:"+remaining);
		 */
		problem();

	}

	static int goalcounter = 0;
	static int allCounter = -1;
	static int baseCounter = -1;

	private static void problem() {
		// int[] nums = new int[] { 1, 2, 3 };
		// int goal = 6;
		// recurs("", "abcd");
		// recurn(new ArrayList<Integer>(), Arrays.asList(new
		// Integer[]{1,2,3}));

		int[] nums = new int[] { 1, 2, 3, 6 };
		// int[] data = { 0, 1, 2, 5, 10, 20, 100, 200 };
		int[] data = { 100, 20, 10, 5, 2, 1 };
		int[] data1 = { 25, 10, 5, 1 };

		int goal = 6;
		int agoal = 200;
		int bgoal = 100;
		/*
		 * List<Integer[]> allcombs =
		 * Util.createAllCombinationsWithRepeatsAddToNum(new int[]{ 0, 1, 2, 3
		 * }, 11, 6); for(Integer[] l : allcombs){ for(Integer i : l){
		 * System.out.print(i+" "); } System.out.println(); }
		 */
		/*
		 * 0 3 3 1 2 3 2 2 2
		 */
		List<String> alls = new ArrayList<String>();
		// recurOfLength(nums[0], 0, nums, goal, new ArrayList<Integer>(), "",
		// alls );
		List<List<Integer>> all = new ArrayList<List<Integer>>();
		recurOfLength(0, 0, data, agoal, new ArrayList<Integer>(), all);
		/*
		 * System.out.print("Found : " + goalcounter); for(String s : alls){
		 * System.out.println("solution : " + s); }
		 */
		all.add(Arrays.asList(200));
		System.out.println("Heres " + all.size() + " solutions we found:");
		
		/*for (List<Integer> li : all) {
			for (Integer i : li) {
				System.out.print(i + " ");
			}
			System.out.println();
		}*/
	}
static int cc = 0;

private static List<List<Integer>> recurOfLength(int aNum, int curTot, int[] allNums, int goal, List<Integer> curnums, List<List<Integer>> all) {
	if(cc < 10)System.out.println("FFFFFFF : " + aNum + " " +cc++);
	/*if(curTot == goal){
		System.out.println("FFFFFFF : " + aNum + " " +cc);
		printA(curnums);
	}*/
	//int newTot = curTot + aNum;
	curTot += aNum; //System.out.println("adding " + curTot + "+" + aNum);
	//if(cc <2)System.out.println("first add = "+ aNum + " - " + curTot);
	List<Integer> ll = new ArrayList<Integer>();
	ll.addAll(curnums);
	ll.add(aNum);
	
	
	
	if (curTot == goal) {
		if (!Util.listListContainsIntArray(all, ll)) {
			System.out.println("Found #" + all.size());
			//printA(ll);
			all.add(ll);
		}
	} else if (curTot < goal) {

		for (int i = 0; i < allNums.length; i++) {
			//if(cc++ == 0)System.out.println("first i = "+allNums[i]);
			recurOfLength(allNums[i], curTot, allNums, goal, ll, all);
		}
	}
	return all;
}


	private static List<List<Integer>> recurOfLengthBackup(int aNum, int curTot, int[] allNums, int goal,
			List<Integer> curnums, List<List<Integer>> all) {
		if(aNum == goal){
			System.out.println("FFFFFFF : ");
			printA(curnums);
		}
		int newTot = curTot + aNum;
		if(cc <2)System.out.println("first add = "+ aNum + " - " + newTot);
		List<Integer> ll = new ArrayList<Integer>();
		ll.addAll(curnums);
		ll.add(aNum);
		
		
		
		if (newTot == goal) {
			if (!Util.listListContainsIntArray(all, ll)) {
				System.out.println("Found #" + all.size());
				printA(ll);
				all.add(ll);
			}
		} else if (newTot < goal) {

			for (int i = 0; i < allNums.length; i++) {
				if(cc++ == 0)System.out.println("first i = "+allNums[i]);
				recurOfLength(allNums[i], newTot, allNums, goal, ll, all);
			}
		}
		return all;
	}

	private static void recurs(String sofar, String rest) {
		if (rest.length() == 0) {
			System.out.println(sofar);
		} else {
			for (int i = 0; i < rest.length(); i++) {
				String next = sofar + rest.charAt(i);
				String remaining = rest.substring(0, i) + rest.substring(i + 1);
				recurs(next, remaining);
			}
		}
	}

	private static void recurn(List<Integer> s, List<Integer> r) {
		if (r.isEmpty()) {
			printA(s);
		} else {
			for (int i = 0; i < r.size(); i++) {
				List<Integer> n = new ArrayList<Integer>();
				n.addAll(s);
				n.add(r.get(i));
				List<Integer> m = new ArrayList<Integer>();
				m.addAll(r.subList(0, i));
				m.addAll(r.subList(i + 1, r.size()));
				recurn(n, m);
			}
		}
	}

	private static void printA(List<Integer> l) {
		for (Integer i : l) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void problem3() {
		int[] nums = new int[] { 1, 2, 5, 10, 20, 50, 100, 200 };
		int goal = 200;
		List<List<Integer>> allc = new ArrayList<List<Integer>>();
		List<Integer> comb = new ArrayList<Integer>();

		int ii = 0;
		while (goal > 0) {
			goal -= nums[ii];
			comb.add(nums[ii]);
			if (goal == 0) {
				System.out.println("We got one!");
				allc.add(comb);
				comb = new ArrayList<Integer>();
				break;
			}
			if (goal < 0) {
				System.out.println("Went tooo far");
				comb = new ArrayList<Integer>();
				break;
			}
			if (ii == nums.length) {
				ii = 0;
			}

		}

		System.out.println("asolution : ");
		for (List<Integer> l : allc) {
			for (Integer i : l) {
				System.out.print(" " + i);
			}
			System.out.println("\n count : " + l.size());
		}
	}

	private static void problem2() {
		int[] nums = new int[] { 0, 1, 2 };
		int goal = 3;

		// figure out max size of combination
		int[] temp = nums.clone();
		Arrays.sort(temp);
		int smallest = temp[0] == 0 ? temp[1] : temp[0];
		int combSize = goal / smallest;
		System.out.println("Max Combination size : " + combSize);

		List<Integer[]> allcombs = createAllCombinationsWithRepeatsAddToNum(new int[] { 0, 1, 2, 3, 4, 5, 6 }, combSize,
				goal);
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
			if (Util.addsUp(comb, goal)) {
				Integer[] temp = comb.clone();
				Arrays.sort(temp);
				if (!Util.listContainsIntArray(allcombs, temp))
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

	public static boolean isRow(int row, double[][] array) {
		return array != null && row >= 0 && row < array.length && array[row] != null;
	}

	private static boolean listContainsStringInt(List<String> l) {
		for (String s : l) {
			int aInt = Integer.parseInt(s);
		}
		return false;
	}

	/*
	 * 
	 * What are all the ways to make 200 with biggest num (200)... 1 (then take
	 * that num away) what are all the ways to make 200 with the second biggest
	 * num (100)... a lot (then take 100 away)
	 * 
	 * 
	 */

}
