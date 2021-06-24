import java.math.BigInteger;

public class Problem63 {
	
	/*
	 	The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.

		How many n-digit positive integers exist which are also an nth power?
	 */

	public static void main(String[] args) {
		//solved by just doing a whole bunch and seeing what the number is at the end
		// dont know when to stop though....
		int min = 1;
		int max = 30000;
		int count = 0;
		int maxExponent = 50;
		//int targetNumberOfCubes = 5;
		
		//Map<Long, Integer> alln = new HashMap<Long, Integer>();
		
		for(int i = min; i < max; i++) {
			
			
			if(i%1000 == 0) { // just for logging
				System.out.println("Doing " + i + "....");
			}
			
			BigInteger b1 = new BigInteger("" + i);
			
			for(int j=1; j<=maxExponent; j++) {
				BigInteger b2 = b1.pow(j);
				
				if(b2.toString().length() == j) {
					count++;
					
					System.out.println("Count at " + count + " for i=" + i + " and exponent=" + j + " for " + b2);
						
					
				}
			}
			
		}
		
		System.out.println("FINAL Count at " + count); 

	}

}
