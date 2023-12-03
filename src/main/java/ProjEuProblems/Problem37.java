package ProjEuProblems;

import ProjEuUtil.Util;

public class Problem37 implements Problem {
	/*
	 * The number 3797 has an interesting property. Being prime itself, it is
	 * possible to continuously remove digits from left to right, and remain
	 * prime at each stage: 3797, 797, 97, and 7. Similarly we can work from
	 * right to left: 3797, 379, 37, and 3.
	 * 
	 * Find the sum of the only eleven primes that are both truncatable from
	 * left to right and right to left.
	 * 
	 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
	 */

	public static void main(String[] args) {
		Problem p = new Problem37();
		p.runProblem();
	}

	public Object problem() {
		int sum = 0, count = 0, expectedPrimeCount = 11, num = 11;
		while(count < expectedPrimeCount) {
			if (Util.isTruncatablePrimeBackwardsAndForwards(num)) {
				//System.out.println("is truncatable prime : " + num);
				sum += num;
				count++;
			}
			num += 2; //since we want primes, skip even numbers
		}
		
		System.out.println("Found all " + count + " primes! :: Sum : " + sum);
		
		return sum;
	}

}
