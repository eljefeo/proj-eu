import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem69 {
	
	/*
	 
	 Euler's Totient function, phi(n) [sometimes called the phi function], 
	 is used to determine the number of numbers less than n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, 
	 	are all less than nine and relatively prime to nine, phi(9)=6.

n	Relatively Prime	phi(n)	n/phi(n)
2	1				1	2
3	1,2				2	1.5
4	1,3				2	2
5	1,2,3,4			4	1.25
6	1,5				2	3
7	1,2,3,4,5,6		6	1.1666...
8	1,3,5,7			4	2
9	1,2,4,5,7,8		6	1.5
10	1,3,7,9			4	2.5
It can be seen that n=6 produces a maximum n/phi(n) for n <= 10.

Find the value of n <= 1,000,000 for which n/phi(n) is a maximum.
	 
	 */

	public static void main(String[] args) {
		
		long startT = System.nanoTime();
		problem();
		long endT = System.nanoTime();
		  
		  double time = (double) (endT - startT)/1000000000;
		System.out.println("Took " + time + " seconds");

		
		System.out.println("::::");
	}
	private static void problem() {
		
		int max = 10;
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
				if(prime > tempI)
					break; 
					// break out early if the primes are higher than our num, no need to continue. Save some time
			
				if(i % prime == 0) {
					phi *= (prime-1);
					tempI = tempI/prime;
					System.out.println("Just curious what tempI/phi is for i=" + i + " and prime=" + prime + " tempI=" + tempI + " and phi=" + phi + " :: " + (tempI/phi));
					while(tempI % prime == 0) {
						System.out.println("Just curious what tempI/phi is for i=" + i + " and prime=" + prime + " tempI=" + tempI + " and phi=" + phi + " :: " + (tempI/phi));
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
}
