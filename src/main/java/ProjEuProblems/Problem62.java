package ProjEuProblems;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ProjEuUtil.Util;

public class Problem62 implements Problem {
	
	 /*
	 
	  The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3). 
	  In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.

		Find the smallest cube for which exactly five permutations of its digits are cube.
	 

	 */
	

	static Set<Long> allNums;
	
	public static void main(String[] args) { //Took 1.548868 seconds
		
		allNums = new HashSet<Long>();
		Problem p = new Problem62();
		p.runProblem();
		
		/// WHAT IF instead of this super slow way (didnt know it would be that slow)
		// we just get all (a bunch?) of cubes, then check if any have the same digits? Would that take even longer - 
		//Update: no this was super fast...solved this way. Still longer than 1 second to run though, need to optimize somehow
		//System.out.println("anything?");
	}
	
	/*
	 numbers cubed and what they end in
	 1 = 1
	 2 = 8
	 3 = 27
	 4 = 64
	 5 = 125
	 6 = 216
	 7 =  343
	 8 = 512
	 9 = 729
	 
	 no 2, no
	 */
	
	public String problem() {
		int min = 200;
		int targetNumberOfCubes = 5;
		
		Map<Long, Integer> alln = new HashMap<Long, Integer>();
		
		int i = min;
		long digitTester = 1;
		while(true) {
			
			if(i%1000 == 0) { // just for logging
				System.out.println("Doing " + i + "....");
			}
			
			long cb = (long) Math.pow(i, 3);
			
			//This will test if our cubes are now another digit longer, like going from 999 to 10000 (3 digits to 4)
			//when this happens we are not going to get any more permutations obviously of the numbers before, so lets
				//just clear out the map so we are not checking on old stuff we know is not going to be true
			if(cb / digitTester > 10) {
				alln = new HashMap<Long, Integer>();
				digitTester = digitTester*10 + 1; //add another 1 to our digit tester, 11 goes to 111, or goes to 1111 etc..
			}
				
			long res = alreadyHas2(cb, alln);
			
			if(res != 0) {
				int exc = alln.get(res);
				int newCount = exc + 1;
				
				if(newCount == targetNumberOfCubes) {
					System.out.println("Found : " + res);
					return "" + res;
				} else {
					alln.put(res, newCount);
				}
			} else {
				alln.put(cb, 1);
			}
			i++;
		}
		
		//return null;
		
	}
	
	public static long alreadyHas2(long n, Map<Long, Integer> alln) {
		for(Long l : alln.keySet()) {
			if(Util.isPermutationOf(n, l)) {
				return l;
			}
		}
		
		return 0;
	}
	
	private static void problemTOOSLOW() {
		// just start getting cubes... then permute their digits until we find one with 4 other cubes? Math.cbrt... (check if integer..)
		int min = 200;//4640
		int max = 10000;
		int targetNumberOfCubes = 5;
		int skippedCount = 0;
		long lastLong = Long.MAX_VALUE;
		
		System.out.println("Last long: " + lastLong + " and max test " + Math.pow(max, 3) + " and is ok? " + (lastLong > Math.pow(max, 3) ? " yes " : " no"));
		for(int i = min; i < max; i++) {
			
			if(i%10 == 0) {
				System.out.println("Doing " + i + ", skipped " + skippedCount);
			}
			
			long cb = (long) Math.pow(i, 3);
			
			if(alreadyHas(cb)) {
				skippedCount++;
				System.out.println("Continuing : " + cb + " for " + i);
				continue;
			} else {
				allNums.add(cb);
			}
			
			Set<String> perm = new HashSet<String>();
			perm.add(cb+"");
			
			makeAllPermutationsRecurNoDupesSet("", cb+"", perm);
			int cubeCounter = perm.size();
		    if(cubeCounter == targetNumberOfCubes) {
		    	
		    	for(String s : perm) {
						System.out.println("A cube : " + s);
				}
		    	System.out.println("Found a thing : " + cb + " for " + i);
		    	return;
		    	
		    }
		}
	}
	
	public static void makeAllPermutationsRecurNoDupesSet(String s, String r, Set<String> all){
		
		if(s.startsWith("0"))
			return;
		
		if(r.length() == 0){
			if(Util.isCube(Long.parseLong(s))){
				all.add(s);
			}
			
		} else {
			for(int i=0; i<r.length(); i++){
				
				if(s.startsWith("0"))
					return;
				
				String newS = s + r.charAt(i);
				String newR = r.substring(0,i) + r.substring(i+1);
				makeAllPermutationsRecurNoDupesSet(newS, newR, all);
			}
		}
	}
	
	public static boolean alreadyHas(long n) {
		for(Long l : allNums) {
			if(Util.isPermutationOf(n, l)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	

}
