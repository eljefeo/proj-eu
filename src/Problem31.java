import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		//problem();
		p();
	}

	static int goalcounter = 0;
	static int allCounter = -1;
	static int baseCounter = -1;
	static int cc = 0;
	static int[] data1 = { 25,10,5,1 };
	static int[] data2 = { 3,2,1 };
	static int tgoal = 50;
	static List<List<Integer>> allGood;
	static List<List<Integer>> allTries;
	static List<List<Integer>> all;
	static int ggoal = 6;
	static int[] alln = new int[] {1,2,3};
	//static List<int[]> allTries;
	static int[][] sd;
	static int[] prev;
	private static void p(){
		allGood = new ArrayList<List<Integer>>();
		//recurLoop(0,0,data2,6, new ArrayList<Integer>(), all);
		problem();
	}
	
	private static void problem() {
		// int[] nums = new int[] { 1, 2, 3 };
		// int goal = 6;
		// recurs("", "abcd");
		// recurn(new ArrayList<Integer>(), Arrays.asList(new
		// Integer[]{1,2,3}));

		int[] nums = new int[] { 1, 2, 3};
		// int[] data = { 0, 1, 2, 5, 10, 20, 100, 200 };
		int[] data = { 100, 20, 10, 5, 2, 1 };
		int[] data1 = {1,2,5,10,20,100} ;
		int[] nums2 = { 1,5,10,25 };

		int goal = 6;
		int agoal = 200;
		int bgoal = 50;
		sd = new int[goal+1][goal+1];
		prev = new int[goal+1];
		System.out.println("prev 0 " + prev[0]);
		/*
		 * List<Integer[]> allcombs =
		 * Util.createAllCombinationsWithRepeatsAddToNum(new int[]{ 0, 1, 2, 3
		 * }, 11, 6); for(Integer[] l : allcombs){ for(Integer i : l){
		 * System.out.print(i+" "); } System.out.println(); }
		 */
		/*
		 * 0 3 3 1 2 3 2 2 2
		 */
		
		// recurOfLength(nums[0], 0, nums, goal, new ArrayList<Integer>(), "",
		// alls );
		all = new ArrayList<List<Integer>>();
		//List<int[]> all = new ArrayList<int[]>();
		allTries = new ArrayList<List<Integer>>();
		//allTries = new ArrayList<int[]>();
		//recurOfLength(0, 0, nums, goal, new ArrayList<Integer>(), all);
		long startT = System.nanoTime();
	
		recurLoop(data1, 200, 0);
		//rrr(alln, 0);
		 long endT = System.nanoTime();
		  
		  // Time = (end time - start time ) divided by a billion : because it is in nano seconds
		  double time = (double) (endT - startT)/1000000000;
		  
		all.add(Arrays.asList(0));
		//System.out.println("Heres " + all.size() + " solutions we found:");
		cc++;
		System.out.println("Heres " + cc + " solutions we found:");
		
		for (List<Integer> li : all) {
			for (Integer i : li) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println("Did all in " + time +" seconds");
	}
/*
private static boolean listContains(List<List<Integer>> all, List<Integer> one){
	for(List<Integer> a : all){
		List<Integer> aa = new ArrayList<Integer>();
		aa.addAll(a);
		Collections.sort(a);
		
	}
	return false;
}*/
	
	
	/*
	 if we are trying to make 6 with 1 2 and 3
	 we can just say, if we have 3 and 2 and they are not greater than 6, we found a solution...
	 can we leave out 1s?
	 then 2s
	 then ...?
	 */
	
	private static void rrr(int[] d, int cur, int ind){
		
		if(cur == ggoal) cc++;
		for(int i=ind; i<d.length; i++){
			for(int j=d[i]; j<ggoal; j++){
				//1-1=0
			}
		}
		
		// make combos of 3 and 2 of length 3 where order doesnt matter
	
	}

	private static void recurLoop(int[] allNums, int goal,  int ind) {
	
		
		
		
		if (goal==0) {
				if(cc % 150 == 0){
					System.out.print("\nFound #" + cc + " :: ");
				}
				cc++;
				
		} else if (goal>0) {//1 2 3
			for (int i = ind; i < allNums.length; i++) {
				
			List<Integer> ll = new ArrayList<Integer>();
			int newGoal = goal - allNums[i];
			recurLoop(allNums, newGoal, i);
					
			}
		} 
	}
	
	
	
	private static boolean recurLoop2(int[] allNums, int goal, List<Integer> myNums, int ind) {
		
		//if(recoginze this one...) return this one?
		//curTot += aNum; //System.out.println("adding " + curTot + "+" + aNum);
		//int ng = goal;
		//if(prev[ng] == 0){
		//if(sd[goal][anum] == 0){
		//allTries
		/*if(Util.listListContainsIntArray(allTries, myNums)){
			System.out.print("Contains this one already : " );
			Util.printListInteger(myNums);
			return false;
		} else{
			System.out.println("x adding a try ");
			Util.printListInteger(myNums);
			allTries.add(myNums);
		}*/
		//allTries.add(myNums);
		
		
		if (goal==0) {
			if (!Util.listListContainsIntArray(all, myNums)) {
			
				if(cc > 73000){
					
					System.out.println("Went tooooo far " + cc);
					System.exit(0);
				}	else if(cc % 150 == 0){
				
					System.out.print("\nFound #" + cc + " :: ");
				} // Why are we adding duplicates
				/*if(cc % 150 == 0){
					System.out.print("\nFound #" + cc + " :: ");
				}*/
				/*System.out.print("\nFound #" + all.size() + " :: ");
				Util.printListInteger(myNums);
				*/
				//all.add(myNums);
				cc++;
				//System.out.println("adding to goals " + goal);
				//prev[ng] = 1;
				return true;
			} else {
				System.out.println("Tried to add duplicate");
			}
		} else if (goal>0) {//1 2 3
			for (int i = 0; i < allNums.length; i++) {
				
			List<Integer> ll = new ArrayList<Integer>();
				ll.addAll(myNums);
			ll.add(allNums[i]);
				
				
				int newGoal = goal - allNums[i];
				if(newGoal >= 0){
					//if(sd[allNums[i]][allNums[anum]] != 1){
						
					
					boolean lte0 = recurLoop2(allNums, newGoal, ll, i);
					
					if(lte0){
						//System.out.println("Skipping this many things : " + (allNums.length-1 - i));
						//Util.printListInteger(ll);
						return false;
					}	
					//}
				} 
				
				///sd[goal][i] = 1;
				//sd[allNums[i]][allNums[anum]] = 1;
			}
		} else if (goal < 0) {
			//System.out.print("Failed : ");
			//Util.printListInteger(myNums);
			//System.out.println("This is too big already: ");
			//Util.printListInteger(myNums);
			return true;
		}
		/*System.out.println("xx adding a try ");
		Util.printListInteger(myNums);*/
		//allTries.add(myNums);
		
		//} else {
		//if(goal != 6){
		//System.out.println("adding to goals " + goal);
		//prev[ng] = 1;
		
		//}
		//}
		return false;
		//store this one?
		//return false;
	}

private static List<List<Integer>> recurOfLength(int aNum, int curTot, int[] allNums, int goal, List<Integer> curnums, List<List<Integer>> all) {
	curTot += aNum; //System.out.println("adding " + curTot + "+" + aNum);
	List<Integer> ll = new ArrayList<Integer>();
	ll.addAll(curnums);
	ll.add(aNum);
	if (curTot == goal) {
		if (!Util.listListContainsIntArray(all, ll)) { // Why are we adding duplicates
			System.out.println("Found #" + all.size());
			all.add(ll);
		}
	} else if (curTot < goal) {
		for (int i = 0; i < allNums.length; i++) {
			recurOfLength(allNums[i], curTot, allNums, goal, ll, all);
		}
	}
	return all;
}


private static List<List<Integer>> recurOfLengthDoesAllBut222(int aNum, int curTot, int[] allNums, int goal, List<Integer> curnums, List<List<Integer>> all) {
	//sd = new int[goal+1][nums.length]; // put this outside somewhere
	curTot += aNum; //System.out.println("adding " + curTot + "+" + aNum);
	List<Integer> ll = new ArrayList<Integer>();
	ll.addAll(curnums);
	ll.add(aNum);
	if (curTot == goal) {
		if (!Util.listListContainsIntArray(all, ll)) { // Why are we adding duplicates
			System.out.println("Found #" + all.size());
			all.add(ll);
		}
	} else if (curTot < goal) {
		for (int i = 0; i < allNums.length; i++) {
			recurOfLength(allNums[i], curTot, allNums, goal, ll, all);
		}
	}
	return all;
}


	private static List<List<Integer>> recurOfLengthBackup(int aNum, int curTot, int[] allNums, int goal,
			List<Integer> curnums, List<List<Integer>> all) {
		if(aNum == goal){
			System.out.println("FFFFFFF : ");
			Util.printListInteger(curnums);
		}
		int newTot = curTot + aNum;
		if(cc <2)System.out.println("first add = "+ aNum + " - " + newTot);
		List<Integer> ll = new ArrayList<Integer>();
		ll.addAll(curnums);
		ll.add(aNum);
		
		
		
		if (newTot == goal) {
			if (!Util.listListContainsIntArray(all, ll)) {
				System.out.println("Found #" + all.size());
				Util.printListInteger(ll);
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
			Util.printListInteger(s);
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
