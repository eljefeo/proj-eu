package ProjEuProblems;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ProjEuUtil.Util;

public class Problem23 implements Problem { //Took 0.384670 seconds

	public static void main(String[] args) {
		Problem p = new Problem23();
		p.runProblem();
	}


	/*
	 * 
	 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
	 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. 
By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. 
However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
	 */
	@Override
	
	public Object problem(){ // Took 0.378610 seconds

		
		//int max = 28123 + 1;
		int max = 28123 + 1 - 12;
		int total = 0;
		//4179871
		List<Integer> abundNums = new ArrayList<Integer>();
		Set<Integer> sumOfAbundNums = new HashSet<Integer>();
		for(int i=1; i<max; i++){
			if(Util.isAbundantNumber(i)){
				abundNums.add(i);
			}
		}
		
		for(int i = 0; i < abundNums.size(); i++) {
			int pi = abundNums.get(i);
			for(int j = i; j < abundNums.size(); j++) {
				
				int pj = abundNums.get(j);
				
				if(pi + pj > max) 
					break;
					//since we put the nums in abundNums list in ascending order
					// we can break if we go above the limit, since next iterations will be even larger
				
				sumOfAbundNums.add(pi + pj);
			}
		}
		
		for(int i=1; i<max; i++)
			if(!sumOfAbundNums.contains(i))
				total+=i;
		
		//System.out.println("Found: " + total);
		return total;
	}
	
}
