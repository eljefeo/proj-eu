import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Problem70 {
	
	/*
	 Euler's Totient function, phi(n) [sometimes called the phi function], is used to determine the number of positive numbers less than or equal to n which are relatively prime to n. 
	 For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, phi(9)=6.
The number 1 is considered to be relatively prime to every positive number, so phi(1)=1.

Interestingly, phi(87109)=79180, and it can be seen that 87109 is a permutation of 79180.

Find the value of n, 1 < n < 107, for which phi(n) is a permutation of n and the ratio n/phi(n) produces a minimum.
	 
	 
	 */

public static void main(String[] args) {
		
		long startT = System.nanoTime();
		problem();
		long endT = System.nanoTime();
		  
		  double time = (double) (endT - startT)/1000000000;
		System.out.println("Took " + time + " seconds");

		
		System.out.println("::::");
	}

private static void problem2() {
	
	int test = 10000000; // ten million
	
	List<Integer> facts = Util.getPrimeFactors(test);
	
	for(Integer i : facts) {
		System.out.println("Factor : " + i);
	}
	System.out.println("**********");
	//facts = Util.getPrimeFactors2(test);
	
	
	
}


	private static void problem() {
		
		int max = 10000000;
		double maxD = 0;
		int maxN = 0;
		int maxPhi = 0;
		
		List<Integer> primes = new ArrayList<Integer>();
		
		//for testing:
		//int test = max; 
		//addAllPrimesUpto(primes, test);
		//System.out.println("Done getting this many primes to test: " + primes.size());
		//for (int i = test; i < test+1; i++) { // this is all the numbers we need to check 2 - a million
		
		for (int i = 2; i < max; i++) {
			
			if(i % 100000 == 0)
				System.out.println("Doing : " + i);
			
			int phi = 1; // set to 1 because every number has 1 has a coprime?
			int tempI = i;
			
			for(int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				//if(prime > (int)Math.sqrt(tempI))
				if(prime > tempI)
					break; 
					// break out early if the primes are larger than our num, no need to continue. Save some time
			
				if(i % prime == 0) {
					phi *= (prime-1);
					tempI = tempI/prime;
					while(tempI % prime == 0) {
						tempI /= prime;
						phi *= prime;
					}
				}
			}
			
			if(phi == 1) {
				phi = i-1;
				primes.add(i); // add primes as we go for the next larger numbers
			} 
			
			double nOverPhi = (double) i/phi;
			//System.out.println("phi for " + i + " = " + phi + " with nphi = " + nOverPhi);
			if(nOverPhi > maxD) {
				maxD = nOverPhi;
				maxN = i;
				maxPhi = phi;
			}
		}
		
		System.out.println("Max nOverPhi = " + maxD +  " for num = " + maxN + " with phi=" + maxPhi);
		
	}
	
	private static void addAllPrimesUpto(List<Integer> primes, int test) {
		for(int i = 2; i<test; i++) {
			if(Util.isPrime(i)) {
				primes.add(i);
			}
		}
		
	}

	
	/*
	 Factor : 2
Factor : 2
Factor : 2
Factor : 5
Factor : 5
Factor : 5
Factor : 5
Factor : 7
	 */
	

}
