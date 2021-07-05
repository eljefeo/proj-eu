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
		problem();
		
		int n = 2118797532;
		//Set<Integer> sn = getDistinctFactorsIntN(n);
		//for(Integer i : sn) {
		//	System.out.println("Factor : " + i);
		//} 
		
		
		System.out.println("::::");
		
		//Set<Integer> sn = Util.getDistinctFactorsInt(n);
		//for(Integer i : sn) {
		//	System.out.println("old Factor : " + i + " is prime = " + Util.isPrime(i));
		//} 
		
		
		
		//double d = getNOverPhi(13);
		//System.out.println(" n over phi : " + 13 + " = " + d);
	}
	
	public static Set<Integer> getDistinctFactorsIntN(int num) {

		Set<Integer> factors = new HashSet<Integer>();
		factors.add(1);
		
		
		while(num % 2 == 0) {
			num /= 2;
			factors.add(num);
		}
		
		int limit = (int) Math.sqrt(num);
		int i = 3;
		while(i <= limit) {
			while(num % i == 0) {
				num /= i;
				factors.add(num);
			}
			i += 2;
		}
		
		/*for (int i = 2; i < limit; i++) {
			if (num % i == 0) {
				limit = num / i;
				factors.add(i);
				factors.add(limit);
			}
		}
		factors.add(num);
		*/
		return factors;
	}
	
	private static void problem() {
		
		List<Integer> primes = new ArrayList<Integer>();
		// TODO Auto-generated method stub
		//find factors other than 1 that are in both numbers...
		
		// 6 and 4 are not coprime because they have 2 in common
		double maxD = 0;
		int maxN = 0;
		int max = 25;
		
		int[] nums = new int[max]; // this will maybe hold all the numbers to a million, index is the num (so a million indexes?) and the value is the ... value (num of coprimes)
		//this might not work...toobig?
		
		for (int i = 2; i < max; i++) { // this is all the numbers we need to check 2 - a million
		
			
			
			
			
			if(i == 18 || i == 12)
				System.out.println("Adding 1 to " + nums[i] + " with i=" + i + " is now " + (nums[i]+1));
			nums[i]++;
			if(i % 1000 == 0) {
				System.out.println("Doing : " + i);
			}
			
			
			// so here we do 1 number, whatever the index is. We are doing 60 here for example
			
			double d = (double) i / (double)((i-nums[i]));
			//System.out.println("found d=" + d + " for i=" + i + " with nums[i]=" + nums[i]);
			 
			//System.out.println(" n over phi : " + i + " = " + d);
			if(d > maxD) {
				maxD = d;
				maxN = i;
			}
			
			//double d = 0;
			
			//we need to not add duplicates...
			// so for 2 and 3
			// if we add 1 for 2,4,6,8,10,12,14....
			// when we do 3 we need to skip 6,12... etc..
			// because we already did those with 2...
			// I think that is why we are getting some wrong numbers
			
			if(!Util.isPrime(i)) {
				//System.out.println("Skipping nonprime : " + i);
				continue;
			}
			System.out.println("DOING NEW PRIME: " + i + " = " + d + " NOW DOING ALL MULTIPLES OF " + i);
			
			int ij = 0;
			for (int j = 2; (ij=i*j) < max; j++) {
			
				//ij = i*j;
				//System.out.println("Doing i=" + i + " , j=" + j + " : i*j = " + (i*j));
				
				if((ij) == 18) {
					System.out.println("18 Doing i=" + i + " , j=" + j + " : i*j = " + ij + " :: and adding " + (j-1) + " to " + nums[ij]);
				}
				//should it be i * (j-1)? then check for mult of those? random thought
				int div = 0;
				if(j > i) {
					for(Integer k : primes) {
						if(j % k == 0) {
							System.out.println("divisible : "+ j + " with " + k + " for num " + ij + " for prime " + i);
							div++;
						}
					}
				}
				System.out.println("num " + ij + " final div = " + div + " for prime "+ i);
					//div = howManyDivisibleBy(primes, j);
				//if(!howManyDivisibleBy(primes, j)) {
					//System.out.println("is not divisible .... going with  i=" + i + " ij=" + ij);
				if((ij) == 18) {
					//	System.out.println("Doing i=" + i + " , j=" + j + " : i*j = " + ij + " :: and adding " + (j-1) + " to " + nums[ij]);
					System.out.println(" .... going with  i=" + i + " j=" + j + " ij=" + ij + " :: div = "+ div + " and then j-1-div=" + (j-1-div));
				}
					
				nums[ij] += j-1-div;
					
				//} else {
					//System.out.println("IS skipping divisible .... not going with  i=" + i + " ij=" + ij);
				//}
				
				
			}
			
			primes.add(i);
			
			//nums[i] = i-nums[i];
			//final 18 : 14 = 4 ::: 4.5
			// 18 is supposed to be 6, we counted too many, should have counted 12, but we counted 14...
		}
		
		
		for(int i=2; i<nums.length; i++) {
			
			//nums[i] = i-nums[i];
			
			double dd = (double) i / (double)((i-nums[i]));
			System.out.println("final " + i + " : " + nums[i] + " = " + (i-nums[i]) + " ::: " + dd);
		}
		
		System.out.println("Max N = : " + maxN + " with phi/n = " + maxD);
	}
	
	private static int howManyDivisibleBy(List<Integer> primes, int j) {
		int c = 0;
		for(Integer i : primes) {
			if(j % i == 0) {
				System.out.println("divisible : "+ j + " with " + i);
				c++;
			}
		}
		return c;
	}

	private static boolean isDivisibleByAny(List<Integer> primes, int ij) {
		for(Integer i : primes) {
			if(ij % i == 0) {
				return true;
			}
		}
		return false;
	}
	
	//notes:
	// here we are going to give how many multiples of i (2, 3, 5 etc..) are in each number below the max (12 for a test for example)
	// so 4 gets 1 (because just 2 is a mult of 2 below 4)
	// and 6 gets 2 (because 2, 4 are a mult of 2 below 6)
	// and 8 gets 3 (because 2, 4, 6 are a mult of 2 below 8)
	//etc..
	
	// problem is lets say 12 gets 5 mults of 2 (2,4,6,8,10)
	// and 12 has 3 mult of 3 (3,6,9)
	// but we already counted the num 6 for 12
	// so 12 should have 5 (2) + 2(3) instead of 3(3)
	//this gives 12 2,3,4,6,8,9,10
	// instead of giving 2,3,4,6, 6 ,8,9,10
	
	// so how do we avoid giving 12 the duplicate 6...
	// we could use a set? and just let that take care of duplicates?
	// is there a way we can avoid giving duplicates without a set?
	
	// what if we use the mult^2?
	//like for 2 we keep doing 2*2 = 4, *2=8... but what about 6.............
	//we can leave 2 to be special? like just do all 2's, that would take care of all even numbers?
	
	//then for the odd primes we can try squares?
	// like we get to 3, we do ...
	// need to do 3*2 so we can give 6 a 3...
	// then we need to give 9 two 3s because it has 3 and 6...
	// but then we need to give 12 only two 3s as well because 3 and 9 since we already gave 12 the 6 from 2
	// what if instead of 3 * 2, 3 * 3, 3 * 4.. we just did odd nums.. like 3 * 3, 3 * 5
		// because didnt we do all multiples of 2 (all even nums?)
	
	
	// primes = 2, 3, 5, 7, 11, 13, 17, 19
	
	// all multiples of all primes..
	// 2 :::
	// 2*2 = 4 = +1 to 4 and +0 for the 2 because same num?
	// 2*3 = 6 = +2 (2) and +1 for the 3
	// 2*4 = 8 = +3 (2) and +0 for 4 because its not prime?
	// 2*5 = 10 = +4 (2) and +1 for 5 because prime?
	// 2*6 = 12 = +5 (2) and thats it, not prime...
	
	//then we go to 3
	// 3*2 = 6 = +1 (3) and +0 because not prime?
	// 3*3 = 9 = +2 (3) and +0 because same num?
	// 3*4 = 12 = +3 (3) problemHere /// use howManyPrimesDivisible(4) = 1 (since just 2)...so minus 1? so just plus 2?
	//3*5 = 15 = + 4 (3) /// use howManyPrimesDivisible(5) = 0 (since just 2)...so minus 1? so just plus 2?
	//
	

	private static void problem3() {
	
		List<Integer> primes = new ArrayList<Integer>();
		// TODO Auto-generated method stub
		//find factors other than 1 that are in both numbers...
		
		// 6 and 4 are not coprime because they have 2 in common
		double maxD = 0;
		int maxN = 0;
		int max = 19;
		
		int[] nums = new int[max]; // this will maybe hold all the numbers to a million, index is the num (so a million indexes?) and the value is the ... value (num of coprimes)
		//this might not work...toobig?
		
		for (int i = 2; i < max; i++) { // this is all the numbers we need to check 2 - a million
			
			if(i == 18 || i == 12)
				System.out.println("Adding 1 to " + nums[i] + " with i=" + i + " is now " + (nums[i]+1));
			nums[i]++;
			if(i % 1000 == 0) {
				System.out.println("Doing : " + i);
			}
			
			
			// so here we do 1 number, whatever the index is. We are doing 60 here for example
			
			double d = (double) i / (double)((i-nums[i]));
			//System.out.println("found d=" + d + " for i=" + i + " with nums[i]=" + nums[i]);
			 
			//System.out.println(" n over phi : " + i + " = " + d);
			if(d > maxD) {
				maxD = d;
				maxN = i;
			}
			
			//double d = 0;
			
			//we need to not add duplicates...
			// so for 2 and 3
			// if we add 1 for 2,4,6,8,10,12,14....
			// when we do 3 we need to skip 6,12... etc..
			// because we already did those with 2...
			// I think that is why we are getting some wrong numbers
			
			if(!Util.isPrime(i)) {
				System.out.println("Skipping : " + i);
				continue;
			}
			
			for (int j = 2; (j*i) < max; j++) {
				//System.out.println("Doing i=" + i + " , j=" + j + " : i*j = " + (i*j));
				
				if((j*i) == 18 || (j*i) == 12) {
					System.out.println("Doing i=" + i + " , j=" + j + " : i*j = " + (i*j) + " :: and adding " + (j-1) + " to " + nums[j*i]);
				}
				nums[j*i] += j-1;
			}
			
			//nums[i] = i-nums[i];
			//final 18 : 14 = 4 ::: 4.5
			// 18 is supposed to be 6, we counted too many, should have counted 12, but we counted 14...
		}
		
		
		for(int i=2; i<nums.length; i++) {
			
			//nums[i] = i-nums[i];
			
			double dd = (double) i / (double)((i-nums[i]));
			System.out.println("final " + i + " : " + nums[i] + " = " + (i-nums[i]) + " ::: " + dd);
		}
		
		System.out.println("Max N = : " + maxN + " with phi/n = " + maxD);
	}

	private static void problem2() {
		// TODO Auto-generated method stub
		//find factors other than 1 that are in both numbers...
		
		// 6 and 4 are not coprime because they have 2 in common
		double maxD = 0;
		int maxN = 0;
		int max = 10000;
		for (int i = 2; i < max; i++) {
			
			if(i % 1000 == 0) {
				System.out.println("Doing : " + i);
			}
			
			double d = 0;
			
			if(Util.isPrime(i)) {
				d = (double)i / (i-1);
			} else {
				d = getNOverPhi(i);
			}
			
			 
			//System.out.println(" n over phi : " + i + " = " + d);
			if(d > maxD) {
				maxD = d;
				maxN = i;
			}
		}
		
		System.out.println("Max N = : " + maxN + " with phi/n = " + maxD);
	}
	
	private static double getNOverPhi2(int n) {
		// just look at primes...
		//if 2 divides..then all future multiples of 2 are also in...
		// if not, we still need to check further...because 6 could be in since it has 3
		
		
		///then do 3...then 5, then 7?
		// dont need to do 8..because if 2 is not in, then 8 isnt either right?
		//. and if 2 is in, then we kno
		return 0;
		
		//2, 3, 5, 7, 11, 13, 17, 19
		
	}
	
	
	private static double getNOverPhi(int n) {
		double d = 0;
		int c = 0;
		for (int i = 1; i < n; i++) {
			if(areCoPrime(n, i)) {
				//System.out.println("yes coprime : "+ n + " " + i);
				c++;
			} else {
				//System.out.println("no coprime : "+ n + " " + i);
			}
		}
		//System.out.println("doing : "+ n + " / " + c);
		d = c == 0 ? 0 : (double) n / c;
		return d;
	}
	private static boolean areCoPrime(int num, int t) { // doesnt work very well...
		Set<Integer> factors = new HashSet<Integer>();
		factors.add(1);
		
		if(t == 1)
			return true;
		
		if(num == t || num < t || num % t == 0)
			return false;
		
		if(num % 2 == 0 && t % 2 == 0)
			return false;
		
		//int smaller = num < t ? num : t; // use the smaller number
		//int larger = smaller == num ? t : num;
		
		
		//System.out.println("hot here for " + a + " ,  " + b);
		
		int limit = t/2;
		for (int i = 3; i <= limit; i+=2) { // not sure if we should do +=2
			if (num % i == 0) {
				if(t % i == 0) {
					return false;
				}
				limit = limit / i; // this might be wrong
			} 
		}
		return true;
	}

}
