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

	public static void main(String[] args) { // this thing takes like 22 minutes.... we should use the actual formula instead of trying to use our little brain. Need to look up totient equations

		int n = 10000000;
		//int nt = n/10;
		long startT = System.nanoTime();
		
		//doFactorsStuff();
		
		 //problem();
		
		 //List<Integer> primes =  getPrimesUnder(n);
		 //System.out.println("prime count: " + primes.size());
		 
		 List<Integer> primes =  getPrimesUnderNoSqr(n);
		 System.out.println("prime count: " + primes.size());
		 
		 /*
		 int[] c = new int[nt];
		 for(int i = 1; i < n; i++) {
			 int sqrt = (int)Math.sqrt(i);
			 //System.out.println("Sqrt of " + i + " = " + sqrt);
			 c[sqrt]++;
		 }
		 
		 for(int i = 0; i < nt; i++) {
			 System.out.println("Sqrt count of " + i + " = " + c[i]);
		 }
		 
		 */
			/*
			 * for(Integer i : primes) { System.out.println("prime : " + i); }
			 */
		//problemBeforeOtherSecret(); // we could speed it up by only doing 2 primes, all combos of just 2 primes...
		// but we dont know that for sure..like that would work, but how do I know that would work and not just by chance.
		
		
		//screw it lets see if we can do it with just 2 primes...
		// I guess it makes sense...since the more primes we have, the larger the number gets, and since we want a ratio as small as possible, then we want the number and phi(n) to be as close to each other as possible
		// but we cant do primes, since that has a lot of numbers in phji
		
		
		//doFactorsStuff();
		
		long endT = System.nanoTime();

		double time = (double) (endT - startT) / 1000000000;
		System.out.println("problem Took " + time + " seconds");

		
		//startT = System.nanoTime();
		//randPrime(n);
		//endT = System.nanoTime();
		//time = (double) (endT - startT) / 1000000000;
		//System.out.println("randPrime Took " + time + " seconds");
		
		
		//startT = System.nanoTime();
		//isppp(n);
		//endT = System.nanoTime();
		//time = (double) (endT - startT) / 1000000000;
		//System.out.println("isppp Took " + time + " seconds");
		
		
		
		//System.out.println(":::: has same digits " + Util.isPermutationDigits(213245, 542312));
	}




	private static void problem() {
		// TODO Auto-generated method stub
		
	}




	private static void doFactorsStuff() {
		List<Integer> thingsToFactor = new ArrayList<Integer>();
		thingsToFactor.add(10);
		thingsToFactor.add(21);
		thingsToFactor.add(291);
		thingsToFactor.add(2817);
		thingsToFactor.add(2991);
		thingsToFactor.add(4435);
		thingsToFactor.add(20617);
		thingsToFactor.add(45421);
		thingsToFactor.add(69271);
		thingsToFactor.add(75841);
		thingsToFactor.add(162619);
		thingsToFactor.add(176569);
		thingsToFactor.add(284029);
		thingsToFactor.add(400399);
		thingsToFactor.add(474883);
		thingsToFactor.add(732031);
		thingsToFactor.add(778669);
		thingsToFactor.add(783169);
		thingsToFactor.add(1014109);
		thingsToFactor.add(1288663);
		thingsToFactor.add(1504051);
		thingsToFactor.add(1514419);
		thingsToFactor.add(1924891);
		thingsToFactor.add(1956103);
		thingsToFactor.add(2006737);
		thingsToFactor.add(2044501);
		thingsToFactor.add(2094901);
		thingsToFactor.add(2239261);
		thingsToFactor.add(2710627);
		thingsToFactor.add(2868469);
		thingsToFactor.add(3582907);
		thingsToFactor.add(3689251);
		thingsToFactor.add(4198273);
		thingsToFactor.add(4696009);
		thingsToFactor.add(5050429);
		thingsToFactor.add(5380657);
		thingsToFactor.add(5886817);
		thingsToFactor.add(6018163);
		thingsToFactor.add(6636841);
		thingsToFactor.add(7026037);
		thingsToFactor.add(7357291);
		thingsToFactor.add(7507321);
		thingsToFactor.add(8316907);
		thingsToFactor.add(8319823);
		thingsToFactor.add(8319823);
		
		for(Integer i : thingsToFactor) {
			showFactors(i);
		}
		
		
	}

	private static void showFactors(Integer i) {
		List<Integer> facts = Util.getPrimeFactors(i);
		
		if(facts.size() != 2) {
			System.out.println("WWWOOHHHHH not 2 factors?????");
		}
		
		System.out.println(facts.size()  + " factors of " + i + " -- with a diff of " + (facts.get(1) - facts.get(0)) + " and ratio " + (i - (facts.get(1) - facts.get(0))) + " and " + (i + (facts.get(1) - facts.get(0))));
		for(int a : facts) {
			System.out.print(" " + a);
		}
		System.out.println("");
		
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

			//List<Integer> factors = new ArrayList<Integer>();
			
			int phi = 1; // set to 1 because every number has 1 has a coprime?
			int tempI = i;
			
			boolean shouldSkip = false;
			int factorCount = 0;
			
			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				
				if (tempI == 1) {
					//System.out.println("Breaking out for prime : " + prime + " with num " + i + " with tempI "+ tempI);
					break;
				}
				// break out early if the primes are larger than our num, no need to continue. Save some time

				if (i % prime == 0) {
					factorCount++;
					
					if(factorCount > 2) { // smallest ratio should be with numbers that are composed of only 2 primes...
						shouldSkip = true;
						//System.out.println("skipping due to > 2 prime factors");
						break;
					}
				
					//factors.add(prime);
					
					phi *= (prime - 1);
					tempI /= prime;
					while (tempI % prime == 0) {
						factorCount++;
						if(factorCount > 2) { // smallest ratio should be with numbers that are composed of only 2 primes...
							shouldSkip = true;
							//System.out.println("skipping due to > 2 prime factors");
							break;
						}
						//factors.add(prime);
						tempI /= prime;
						phi *= prime;
					}
					if(shouldSkip || factorCount > 2) {
						//break;
					 // smallest ratio should be with numbers that are composed of only 2 primes...
						shouldSkip = true;
						//System.out.println("skipping due to > 2 prime factors");
						break;
					}
						
				}
			}

			if(shouldSkip)
				continue;
			
			boolean isPrime = false;
			
			
			if (phi == 1) {
				//isPrime = true;
				//phi = i - 1;
				primes.add(i); // add primes as we go for the next larger numbers
			} else {

				if(Util.isPermutationDigits(i, phi)) {
					double nOverPhi = (double) i / phi;
					// System.out.println("phi for " + i + " = " + phi + " with nphi = " +
					// nOverPhi);
					if (nOverPhi < smalD) {
						smalD = nOverPhi;
						smalN = i;
						smalPhi = phi;
						System.out.println("New smallest permutation nOverPhi = " + smalD + " for num = " + smalN + " with phi=" + smalPhi);
						//System.out.println("Factors for " + i + " :");
						//for(Integer f : factors) {
						//	System.out.print(" " + f);
						//}
						System.out.println("");
					}
				}
				
				
			}
		}

		System.out.println("Smallest nOverPhi = " + smalD + " for num = " + smalN + " with phi=" + smalPhi);

	}
	
	private static List<Integer> getPrimesUnderNoSqr(int max) {
		
		int n = 1;
		List<Integer> primes = new ArrayList<Integer>();
		
		int sqrtCounter = 1;
		int sqrtNext = 3;
		int sqrt = 1;
		
		primes.add(2);
		
		
		while ((n+=2) < max) {
			
			sqrtCounter+=2;
			
			boolean foundPrime = true;
			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				if(prime > sqrt)
					break;
				
				if (n % prime == 0) {
					foundPrime = false;
					break;
				}
			}
			if (foundPrime) {
				primes.add(n);
			}
			//System.out.println("Doing " + n + " with sqrtnext = " + sqrtNext + " with counter = " + sqrtCounter + " , and sqrt = " + sqrt );
				
			
			if(sqrtCounter > sqrtNext-2) {
				sqrtNext += 2;
				sqrtCounter = sqrtNext-sqrtCounter;
				sqrt++;
				//System.out.println("Setting sqrtnext to " + sqrtNext + " with counter now " + sqrtCounter + " , and sqrt is now " + sqrt );
			
			}  	
				
		}
		
		
		
		return primes;
		
	}
	
private static List<Integer> getPrimesUnder(int max) {
		
		int n = 1;
		List<Integer> primes = new ArrayList<Integer>();
		
		//int sqrtCounter = 1;
		//int sqrtNext = 3;
		//int sqrt = 1;
		
		primes.add(2);
		
		
		while ((n+=2) < max) {
			
			//sqrtCounter+=2;
			
			
			int sqrt = (int) Math.sqrt(n);
			
			
			boolean foundPrime = true;
			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				if(prime > sqrt)
					break;
				
				if (n % prime == 0) {
					foundPrime = false;
					break;
				}
			}
			if (foundPrime) {
				primes.add(n);
			}
			//System.out.println("Doing " + n + " with sqrtnext = " + sqrtNext + " with counter = " + sqrtCounter + " , and sqrt = " + sqrt );
				
			
			
				
		}
		
		
		
		return primes;
		
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
}
