import java.math.BigInteger;

public class Problem53 {
	
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
		problem();
		//int fact = Util.factorial(6);
		//BigInteger bFact = factorial(new BigInteger(""+6));
		//System.out.println("Test " + fact + " ... " + bFact);
		
		
	}
	
	public static BigInteger factorial(BigInteger num) {
		BigInteger fact = new BigInteger(""+1); 
		for (BigInteger i = new BigInteger(""+1); i.compareTo(num) != 1; i = i.add(new BigInteger(""+1))) {
			fact = fact.multiply(i);
		}
		return fact;
	}
	
	private static void problem(){
		
		int min = 1;
		int max = 101;
		
		BigInteger goal = new BigInteger(""+1000000); //one million
		int counter = 0;
		for(int i=min; i < max; i++){
			
			for(int j = 1; j < i; j++){
				BigInteger result = getNumberOfCombinations(i,j);
				if(result.compareTo(goal) == 1){
					counter++;
				}
			}
			
			
		}
		
		System.out.println("Count : " + counter);
		
	}

	private static BigInteger getNumberOfCombinations(int n, int r) {

		BigInteger nb = new BigInteger(""+n);
		BigInteger rb = new BigInteger(""+r);
		
		//n! / r! * (n-r)!
		BigInteger nFact = factorial(nb);
		BigInteger rFact = factorial(rb);
		BigInteger nMinusRFact = factorial(nb.subtract(rb));
		
		try{
			
			BigInteger sol = nFact.divide(rFact.multiply(nMinusRFact));
			//System.out.println("Sol  for n=" + n + " and r=" + r + " ::: " + sol);
			return sol;
		} catch(Exception e){
			System.out.println("Failed at n, r ::: " + n + " , " + r);
			System.out.println("nFact, rFact, nMinusRFact ::: " + nFact + ", " + rFact + ", " + nMinusRFact);
			System.exit(0);
		}
		
		
		
		return new BigInteger(""+0);
		
		
	}

}
