import java.util.ArrayList;
import java.util.List;

public class Problem43 implements Problem{
	/*
	 * The number, 1406357289, is a 0 to 9 pandigital number because it is made
	 * up of each of the digits 0 to 9 in some order, but it also has a rather
	 * interesting sub-string divisibility property.
	 * 
	 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we
	 * note the following:
	 * 
	 * d2d3d4=406 is divisible by 2 d3d4d5=063 is divisible by 3 d4d5d6=635 is
	 * divisible by 5 d5d6d7=357 is divisible by 7 d6d7d8=572 is divisible by 11
	 * d7d8d9=728 is divisible by 13 d8d9d10=289 is divisible by 17 Find the sum
	 * of all 0 to 9 pandigital numbers with this property.
	 */
	
	
	//this one I optimized legitimately - no assumptions or magic knowledge
	public static void main(String[] args) {
		Problem p = new Problem43();
		p.runProblem();
	}

	public String problem() {

		long end = 9;
		int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17 };
		List<Long> alln = makeAllPanditalNumsFromTo(0, end, primes);

		long sum = 0;
		for (int i = 0; i < alln.size(); i++) {
				sum += alln.get(i);
		}

		return "" + sum;
	}
	
	public static List<Long> makeAllPanditalNumsFromTo(long start, long end, int[] primes){
		List<Long> all = new ArrayList<Long>();
		String s = "";
		for(long i=start; i<=end; i++){
			s += i;
		}
		makeAllPermutationsRecur("", s, all, primes);
		return all;
	}
	
	public static void makeAllPermutationsRecur(String s, String r, List<Long> all, int[] primes){
		
		// lets check as we go... if the primes even work so far...
		if(s.length() > 2) 
			for (int j = 1; j < s.length()-2; j++)  // only go to 7 since we get j+2 which ends up being index 7,8,9 with 9 as the final number
				if (Long.parseLong(s.substring(j, j + 3)) % (primes[j - 1]) != 0) 
					return; //if primes dont work just quit here, go do the next set
				
		if(r.length() == 0){
			all.add(Long.parseLong(s));
		} else {
			for(int i=0; i<r.length(); i++){
				if(s.startsWith("0"))
					return; //zero disappears if a num starts with zero, doesnt count
				
				String newS = s + r.charAt(i);
				String newR = r.substring(0,i) + r.substring(i+1);
				makeAllPermutationsRecur(newS, newR, all, primes);
			}
		}
	}



}
