package ProjEuProblems;
import java.util.ArrayList;
import java.util.List;

import ProjEuUtil.Util;

public class Problem70 implements Problem{ //Took 1.977199 seconds - probably because doing 10,000,000 not much we can do ...

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

		//doFactorsStuff();
		
		 //problem();
		
		 //List<Integer> primes =  getPrimesUnder(n);
		 //System.out.println("prime count: " + primes.size());
		 
		 //List<Integer> primes =  getPrimesUnderNoSqr(n);
		 //System.out.println("prime count: " + primes.size());
		 
		//testSquareRootStuff();
		 
		 
			/*
			 * for(Integer i : primes) { System.out.println("prime : " + i); }
			 */
		
		Problem p = new Problem70();
		p.runProblem();
	
		// but we dont know that for sure..like that would work, but how do I know that would work and not just by chance.
		
		
		//screw it lets see if we can do it with just 2 primes...
		// I guess it makes sense...since the more primes we have, the larger the number gets, and since we want a ratio as small as possible ( as close to 1 as possible, dont go over too much), then we want the number and phi(n) to be as close to each other as possible
		// but we cant do primes, since that has a lot of numbers in phji
		
		
		//doFactorsStuff();
		
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
	
	
	public Object problem() {
		int max = (int) Math.pow(10, 7), step = max/10;
		double smalD = 10;
		int smalN = 0;
		int smalPhi = 0;

		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		// for testing:
		// int test = max;
		// addAllPrimesUpto(primes, test);
		// System.out.println("Done getting this many primes to test: " +
		// primes.size());
		// for (int i = test; i < test+1; i++) { // this is all the numbers we need to
		// check 2 - a million

		//nums:
		double nOverPhi;
		int phi;
		int tempI;
		int factorCount;
		int innerSqrt;
		int prime;
		
		int sqrtCounter = 1;
		int sqrtNext = 2;
		int sqrt = 1;
		
		for (int i = 3; i < max; i++) {
			sqrtCounter+=1;
			if (i % step == 0) //if you take this check and console log line out, then this problem is usually faster than 1 second...
				System.out.println((i*10/step) + "% complete");
			
			phi = 1; // set to 1 because every number has 1 has a coprime?
			tempI = i;
			factorCount = 0;
			//sqrt = (int) Math.sqrt(tempI); //I think we can optimize by getting rid of this square root function.
			innerSqrt = sqrt;
			for (int p = 0; p < primes.size(); p++) {
				
				prime = primes.get(p);
				
				if(prime > innerSqrt) {
					if(factorCount == 0) {//or if tempI == i { // if no factors below sqrt of num, that num is prime
						primes.add(i);
						break;
						// continue nums;// but we dont want to actually use phi of primes, its too big, so we skip it but use the prime for later
					} else if(tempI > 1) { // else if no other primes under sqrt, but has other factors, then tempI is now prime and is the second factor. 
						// This means we found a num with only 2 factors which is what we want
						phi *= (tempI - 1);
						nOverPhi = (double) i / phi;
						if(nOverPhi < smalD && Util.isPermutationOf(i, phi)){//Util.isPermutationDigits(i, phi)) {
							smalD = nOverPhi;
							smalN = i;
							smalPhi = phi;
						}
						break;
					} else {
						System.out.println("Hmmm we are here with i = " + i + " tempI = " + tempI);
					}
					
				}

				if (tempI % prime == 0) { // we found a factor of i
					tempI /= prime; // divide our temp value, dividing out this factor
					factorCount++;
					if(factorCount > 1 || tempI % prime == 0)  
						break;
						//continue nums;
						// tempI % prime == 0  this num (i) is divisible by the same factor twice, this is not what we want. This will increase phi and we want phi to be closest to 1
						// factorCount > 1  smallest ratio should be with numbers that are composed of only 2 primes (and not the same 2 primes)...
						// if we get here and we found more than 1 factor, we should have caught it above in the sqrt check for a num with only 2 factors. 
						// the fact that we are here means we are at a num with > 2 factors... skip it
						
					phi *= (prime - 1);
					innerSqrt = (int) Math.sqrt(tempI);
				}
			}
			
			if(sqrtCounter > sqrtNext) { // here is where we calculate the next square root so we dont have to do Math.sqrt()
				sqrtNext += 2;
				sqrtCounter = sqrtNext-sqrtCounter;
				sqrt++;
			} 
			
		}

		System.out.println("Smallest nOverPhi = " + smalD + " for num = " + smalN + " with phi=" + smalPhi + " with prime count : " + primes.size() + " under " + max);
		return smalN;
	}
	
	
	public void problemDoAllTwoPrimeCombosTakesForever() {
		//there are simply too many primes to check against each other(under 10million...)
		// might be fine with less primes, but not useable here..
		
		// lets just get all primes under
		// then do combinations of 2 primes...
		int max = (int) Math.pow(10, 7), step = max/10;
		double smalD = 10;
		int smalN = 0;
		int smalPhi = 0;
		List<Integer> primes = Util.getPrimesUnder(max);
		System.out.println("total primes: " + primes.size());
		
		for (int i = 0; i < primes.size(); i++) {
			//int c = 0;
			
			int pi = primes.get(i);
			System.out.println("on prime " + pi);
			for (int j = i; j < primes.size(); j++) {
				//if (c++ % primes.size()/10 == 0)
					//System.out.println("did " + c);
				int pj = primes.get(j);
				
				int phi = (pi-1) * (pj-1);
				int mult = (pi*pj);
				double nOverPhi = (double) mult / phi;
				if(nOverPhi < smalD && Util.isPermutationDigits(mult, phi)) {
					
						smalD = nOverPhi;
						smalN = mult;
						smalPhi = phi;
						System.out.println("New smallest permutation nOverPhi = " + smalD + " for num = " + smalN + " with phi=" + smalPhi);
					
				}
				
			}
			
		}
	}
	
	public void problemd() {
		
		System.out.println("This way calculates phi for all nums, unlike the other that breaks on nums with >2 factors (which is more optimized)");
		
		int max = (int) Math.pow(10, 7), step = max/10;
		double smalD = 10;
		int smalN = 0;
		int smalPhi = 0;
		
		List<Integer> primes = new ArrayList<Integer>();
		
		for (int i = 2; i < max; i++) {
			int phi = 1; // set to 1 because every number has 1 has a coprime?
			int tempI = i;
			int sqrt = (int)Math.sqrt(tempI);
			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				if(prime > sqrt) 
					break;
				
				if (i % prime == 0) {
					phi *= (prime - 1);
					tempI /=  prime;
					while (tempI % prime == 0) {
						tempI /= prime;
						phi *= prime;
					}
					sqrt = (int)Math.sqrt(tempI);
				}
			}
			
			if(tempI == i) {
				phi = i-1;
				primes.add(i); 
			} else if(tempI > 1){
				phi *= (tempI - 1);
			}  
			
			double nOverPhi = (double) i / phi;
			if(nOverPhi < smalD && Util.isPermutationDigits(i, phi)) {
				
					smalD = nOverPhi;
					smalN = i;
					smalPhi = phi;
					//System.out.println("New smallest permutation nOverPhi = " + smalD + " for num = " + smalN + " with phi=" + smalPhi);
				
			}
		}
		
		System.out.println("Smallest nOverPhi = " + smalD + " for num = " + smalN + " with phi=" + smalPhi + " with prime count : " + primes.size() + " under " + max);

		
	}


	public static void testSquareRootStuff() { 
		int n = 1000;
		int nt = n/10;
		int[] c = new int[nt];
		 for(int i = 1; i < n; i++) {
			 int sqrt = (int)Math.sqrt(i);
			 //System.out.println("Sqrt of " + i + " = " + sqrt);
			 c[sqrt]++;
		 }
		 
		 for(int i = 0; i < nt; i++) {
			 System.out.println("Sqrt count of " + i + " = " + c[i]);
		 }
		 
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

	
	
	

	
	
	public static int getSmallestFactor(int n, int startFrom) {
		
		if(n % 2 == 0) {
			return 2;
		}
        
        int sqrt = (int) Math.sqrt(n);
        for (int i = startFrom; i <= sqrt; i += 2) {
        	if(n % i == 0)
        		return i;
        }
        return n;
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
