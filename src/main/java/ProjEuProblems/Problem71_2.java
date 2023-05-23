package ProjEuProblems;

import ProjEuUtil.Util;

public class Problem71_2 implements Problem { //Took 0.001484 seconds

	
	/*
	 
	 Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d <= 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

It can be seen that 2/5 is the fraction immediately to the left of 3/7.

By listing the set of reduced proper fractions for d <= 1,000,000 in ascending order of size, find the numerator of the fraction immediately to the left of 3/7.
	 
	 
	 */
	
	public static void main(String[] args) { //Took 0.029194 seconds
		new Problem71_2().runProblem();
		
		//int a = 30, b = 5;
		//System.out.println("gcd of " + a + " " + b + " = " + Util.gcd(a,b) + " :: reduced " + Util.reduceFractionString(a, b));
		
	}
	
	/*
	 * 
	so I found this actually doesnt work like I thought it would...
	1/2, to the left is 3/7
	if you put 1/2 in here, you get 3/8... which is wrong.. my logic is incorrect
	but I got lucky and got the right answer... but why..
	 
	 
	 :::::
	 ::::: My Original notes before realizing there is an issue in the logic :
	 :::::
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
	

	
/* CODE BELOW IS CURRENT, BUT DOES NOT WORK FOR 1/4 OR 1/6
 1/4 SHOULD GIVE 1/5, INSTEAD IT GIVES 1/6
 1/6 SHOULD GIVE 1/7, INSTEAD IT GIVES 1/8
 * */
	
	@Override
	public String problem() {

		int max = 8;
		int numerGoal = 1;
		int denomGoal = 7;
		//1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
		for(int i=max; i > 1; i--) { 	// denom
			
			//if(i == denomGoal) // lets assume there are other numbers in between...like 3/7 and 4/7 have some numbers in between lets just assume
			if(denomGoal % i == 0)	
				continue;
			
			long[] lcm  = Util.lcmWithMult(i, denomGoal);
			
			long w = denomGoal < i ? lcm[0] / denomGoal : lcm[1];
			
			System.out.println("w = " + w + " l0 = " + lcm[0] + " l1 = " + lcm[1]);
			 // the second thing in the array
				// is how many to mult the HIGHER num to to get the lcm
				// but we dont know if the i we are testing is higher / lower than dGoal
				// so we need to do this only if dGoal is less than i
				
			long newNumerator = (numerGoal * w) - 1;
			long[] red = Util.reduceFraction(newNumerator, lcm[0]);
			System.out.println("wwwFraction is " + red[0] + "/" + red[1]);
			
			if(red[1] % denomGoal == 0)
				continue;
			if(red[1] <= max) {
				System.out.println("Fraction is " + red[0] + "/" + red[1]);
				System.out.println("Answer: " + red[0]);
				return "" + red[0];
			}
			
		}
		return null;
	}

}
