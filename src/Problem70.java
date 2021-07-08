import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Problem70 {

	/*
	 * Euler's Totient function, phi(n) [sometimes called the phi function], is used
	 * to determine the number of positive numbers less than or equal to n which are
	 * relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less
	 * than nine and relatively prime to nine, phi(9)=6. The number 1 is considered
	 * to be relatively prime to every positive number, so phi(1)=1.
	 * 
	 * Interestingly, phi(87109)=79180, and it can be seen that 87109 is a
	 * permutation of 79180.
	 * 
	 * Find the value of n, 1 < n < 10^7, for which phi(n) is a permutation of n and
	 * the ratio n/phi(n) produces a minimum.
	 * 
	 * 
	 */

	public static void main(String[] args) {

		long startT = System.nanoTime();
		// problem();
		problemBeforeOtherSecret();
		long endT = System.nanoTime();

		double time = (double) (endT - startT) / 1000000000;
		System.out.println("Took " + time + " seconds");

		;
		System.out.println(":::: has same digits " + Util.isPermutationDigits(213245, 542312));
	}




	private static void problemBeforeOtherSecret() {

		int max = 10000000, step = max/10;
		double smalD = 10;
		int smalN = 0;
		int smalPhi = 0;

		List<Integer> primes = new ArrayList<Integer>();

		// for testing:
		// int test = max;
		// addAllPrimesUpto(primes, test);
		// System.out.println("Done getting this many primes to test: " +
		// primes.size());
		// for (int i = test; i < test+1; i++) { // this is all the numbers we need to
		// check 2 - a million

		for (int i = 2; i < max; i++) {

			if (i % step == 0)
				System.out.println("Doing : " + i);
			
			int phi = 1; // set to 1 because every number has 1 has a coprime?
			int tempI = i;

			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				
				if (prime > tempI)
					break;
				// break out early if the primes are larger than our num, no need to continue. Save some time

				if (i % prime == 0) {
					
					phi *= (prime - 1);
					tempI = tempI / prime;
					while (tempI % prime == 0) {
						tempI /= prime;
						phi *= prime;
					}
				}
			}
			
			if (phi == 1) {
				primes.add(i); // add primes as we go for the next larger numbers
			} else {

				if(Util.isPermutationDigits(i, phi)) {
					double nOverPhi = (double) i / phi;
					if (nOverPhi < smalD) {
						smalD = nOverPhi;
						smalN = i;
						smalPhi = phi;
						System.out.println("New smallest permutation nOverPhi = " + smalD + " for num = " + smalN + " with phi=" + smalPhi);
						
					}
				}
				
				
			}
		}

		System.out.println("Smallest nOverPhi = " + smalD + " for num = " + smalN + " with phi=" + smalPhi);

	}
	

	private static void problem() {
		
		/*
		 
		 so it seems like the smallest n / phi(n) appears to just be the prime numbers.
		 so 2
		 then the next smallest is 3
		 then 5 then 7 then 11 etc...
		 
		 ...so just do prime numbers ?
		 get that phi which is prime-1?
		 
		 look for permutations for the smallest one?
		 
		 
		 
		 no ^ wont work because although primes are the smallest.... their phi value will NOT be a permutation.
		 ...right? 
		 97 is prime...its phi is 97-1 = 96....that will never be a permutation of 97
		 */
		
		int max = 16;
		double maxD = 0;
		int maxN = 0;
		int maxPhi = 0;

		int n = 1;
		int latestPrime = 1;
		int phi = 1;
		List<Integer> primes = new ArrayList<Integer>();

		while (latestPrime < max) {
			getNextPrime(primes, n++);
			latestPrime = primes.get(primes.size()-1);
			phi = latestPrime - 1;
			
			
			
		}


		System.out.println("Found : " + latestPrime);

	}

	
	private static void getNextPrime(List<Integer> primes, int n) {

		int pr = n;
		while (true) {
			pr++;

			boolean foundPrime = true;
			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				if (pr % prime == 0) {
					foundPrime = false;
					break;
				}
			}

			if (foundPrime) {
				primes.add(pr);
				return;
			}

		}

	}

	private static void addAllPrimesUpto(List<Integer> primes, int test) {
		for (int i = 2; i < test; i++) {
			if (Util.isPrime(i)) {
				primes.add(i);
			}
		}

	}
	
	

	private static void problem2() {

		int test = 510510; // ten million
		// 210 2310 30030 510510
		List<Integer> facts = Util.getPrimeFactors(test);

		for (Integer i : facts) {
			System.out.println("Factor : " + i);
		}
		System.out.println("**********");
		// facts = Util.getPrimeFactors2(test);

	}

	/*
	 * Factor : 2 Factor : 2 Factor : 2 Factor : 5 Factor : 5 Factor : 5 Factor : 5
	 * Factor : 7
	 */

}
