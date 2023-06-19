package ProjEuProblems;

import ProjEuUtil.Util;

public class Problem71 implements Problem { //Took 0.001084 seconds

	
	///TODO double check if this implementation works 100% of the time.
	//there was a bug in the original code, this latest code I think should be fine. but maybe double check one day when you get bored.
	
	/*
	 
	 Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d <= 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

It can be seen that 2/5 is the fraction immediately to the left of 3/7.

By listing the set of reduced proper fractions for d <= 1,000,000 in ascending order of size, find the numerator of the fraction immediately to the left of 3/7.
	 
	 
	 */
	
	public static void main(String[] args) { //Took 0.029194 seconds
		new Problem71().runProblem();
		//problem5();
	}
	
	@Override
	public Object problem() {
		long[] leftFraction = Util.getFractionToTheLeft(1000000, 3, 7);
		//System.out.println("Found " + leftFraction[0] + "/" + leftFraction[1]);
		
		return leftFraction[0];
	}
	
	/*
	 
	 so after looking at these fractions for a while here's what Im thinking
	 3/7 is next to 2/5 because:
	 we work our way down the denoms from the highest (8,7,6,5...)
	 until we find a fraction where the reduced fraction has  a denom less than our max (8)
	 so:
	 3/7 -> 8
	 lcm of 7 and 8 = 56
	 so 3/7 = 8/56
	 this means the fraction directly to the left would be 7/56
	 can we reduce 7/56 to the point where the denom is <8?
	 no...
	 
	 so go to the next one (skip 7 since we are doing 7)
	 7 and 6 = 42
	 so 3/7 = 18/42
	 so we need 17/42
	 can we reduce 42 below 8? No...
	 on to 5...
	 7 and 5 = 35
	 so 15/35 means we need 14/35
	 hmm both are divisible by 7
	 14/35 = 2/5
	 5 is below 8, there we go...
	 answer is 2/5
	 lets try it
	 
	 
	 
	 */
	

	

	//OLD - just leaving here for references and to keep me humbled
	public static String problem5() { // So this was the first solution I worked on but it has issues with some numbers
		// like 1/2 should have 3/7 to the left, but this returns 3/8...
		// I found another way to do it above anyways, and it works correctly.

		//int max = 1000000;
		int max = 8;
		int nGoal = 1, dGoal = 2;
		//1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

		
		for(int i=max; i > 0; i--) { 	// denom
			
			if(i == dGoal)
				continue;
			
			long[] dets  = Util.lcmWithMult(i, dGoal);
			
			long w = dets[1];
			if(dGoal < i) // the second thing in the array
				// is how many to mult the HIGHER num to to get the lcm
				// but we dont know if the i we are testing is higher / lower than dGoal
				// so we need to do this only if dGoal is less than i
				w = dets[0] / dGoal;
			

			long newN = (nGoal * w) - 1;
			long[] red = Util.reduceFraction(newN, dets[0]);
			if(red[1] <= max) {
				System.out.println("Fraction is " + red[0] + "/" + red[1]);
				System.out.println("Answer: " + red[0]);
				return "" + red[0];
			}
			
		}
		return null;
		
	}

}