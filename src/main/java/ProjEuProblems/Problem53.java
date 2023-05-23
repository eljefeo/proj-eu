package ProjEuProblems;
import java.math.BigInteger;

import ProjEuUtil.Util;

public class Problem53 implements Problem { //Took 0.115581 seconds
	
	/*
	 There are exactly ten ways of selecting three from five, 12345:

		123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
		
		In combinatorics, we use the notation, (5 over 3) = 10
		.
		
		In general, 
		 
		(n over r) = n! / r!(n-r)!, where , , and .
		
		It is not until n=23, ( 23 over 10 ) that a value exceeds one-million: 1,144,066
		.
		
		How many, not necessarily distinct, values of (n over r) 
		 for 1 <= n <= 100, are greater than one-million?
			 
			 
	 */

	public static void main(String[] args) {
		Problem p = new Problem53();
		p.runProblem();
		//int fact = Util.factorial(6);
		//BigInteger bFact = factorial(new BigInteger(""+6));
		//System.out.println("Test " + fact + " ... " + bFact);
		
		
	}

	
	public String problem(){
		
		int min = 1;
		int max = 101;
		
		BigInteger goal = new BigInteger(""+1000000); //one million
		int counter = 0;
		for(int i=min; i < max; i++){
			
			for(int j = 1; j < i; j++){
				BigInteger result = Util.getNumberOfCombinations(i,j);
				if(result.compareTo(goal) == 1){
					counter++;
				}
			}
			
			
		}
		
		//System.out.println("Count : " + counter);
		return "" + counter;
		
	}



}
