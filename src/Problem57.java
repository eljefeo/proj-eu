

public class Problem57 implements Problem { //Took 0.029620 seconds
	
	/*
	 
	  It is possible to show that the square root of two can be expressed as an infinite continued fraction. (couldnt show picture)

y expanding this for the first four iterations, we get: (couldnt show picture)
	 3/2 = 1.5
	 7/5 = 1.4
	 17/12 = 1.41666..
	 41/29 = 1.41379..
	 
	 The next three expansions are 
 99/70
, 
 239/169
, and 
 577/408
, but the eighth expansion, 
 1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.

In the first one-thousand expansions, how many fractions contain a numerator with more digits than the denominator?
	 */

	public static void main(String[] args) {
		Problem p = new Problem57();
		p.runProblem();
	}

	public String problem() {
		//1 + 3/2	     7/5      17/12		41/29 
		
		//forget the one for now
		// 		1/2		2/7		5/12		12/29		29/70		70/169		408/985	
		// 1 + 1/ (2 + 1 / (2 + 1 / (2 + 1 / (2...
		
		/*
		 so first do 1/2
		 then 2 + that
		 so 2 * denom + 1 = (2*denom = 4) + 1 = 5
		 ... over 2
		 which is 5/2
		 
		 then take reciprocal 2/5
		 then add 2 again - 2 * denom (2*5=10) + numer (2) = 12/5
		 
		 then reciprocal = (5/12) 
		 then add 2 again..
		 2 * denom (2*12=24) + numer (5) = 29/12
		 
		 keep doing that until you want to stop
		 
		 when you want to stop at the end:
		 reciprocal = (12/29)
		 then add 1
		 (just add denom to numer) 29+12 = 41/29
		 
		 */
		
		int howManyIterations = 1000;
		int res = Util.calcSquareRootOfTwoCheckIfNumerMoreDigitsThanDenom(howManyIterations);
		return "" + res;
	}
	


}
