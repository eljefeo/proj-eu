package ProjEuProblems;

import ProjEuUtil.Util;

public class Problem58 implements Problem { //Took 0.384939 seconds

	
	/*
	 Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.

37 36 35 34 33 32 31
38 17 16 15 14 13 30
39 18  5  4  3 12 29
40 19  6  1  2 11 28
41 20  7  8  9 10 27
42 21 22 23 24 25 26
43 44 45 46 47 48 49

It is interesting to note that the odd squares lie along the bottom right diagonal, 
but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; 
that is, a ratio of 8/13 is about 62%.

If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. 
If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals 
	first falls below 10%?
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem58();
		p.runProblem();
		
	}

	
	public String problem() {
		
		int currNum = 1, sideLength = 2, totalCornerCount = 1, primeCornerCount = 0;
		double cutoffPercent = 0.1, ratio = 0;
		while(true) {
			for(int j = 0; j < 4; j++) { // 4 corners
				currNum += sideLength;
				totalCornerCount++;
				if(Util.isPrime(currNum)){
					primeCornerCount++;
				}
			}
			
			ratio = (double)primeCornerCount / (double)totalCornerCount;
			if(ratio < cutoffPercent) {
				//System.out.println("Dropped below " + cutoffPercent + "  with side length: " + (sideLength+1));
				return "" + (sideLength+1);
			}
			sideLength+=2;
		}
	}
	
}
