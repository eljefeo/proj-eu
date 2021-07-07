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
	private static void problem() {
		
		
		
		
		/*
		 if we start with 2 
		 we do 2 * 2 
		 = 4
		 then check from last (2) through 4
		 // the idea is if we check all combinations, any numbers in between should be prime?
		   
		  so 2 - 4 we find 3
		  add 3 to primes
		  now primes has 2,3
		  
		  go through again (but we already did 2*2)....so 2 loops, second loop can start where we left off? at 3?
		  
		  so 2*3
		  = 6
		  
		  go through 4 - 6
		  gives us 5 - add to primes?
		  
		 
		  
		  then 3*3
		  = 9
		  
		    6+2 = 8..
		  is 8 < then 9? yes then 8-1 is prime?
		  
		  7 add to primes...
		  
		  
		  
		  
		  
		 */
		
		int max = 1000;
		//int[] nums = new int[max];
		List<Integer> primes = new ArrayList<Integer>();
		//primes.add(2);
		
		//int c = 0;
		
		
		 
		
		//2 3 5 = 30 - good
		//(two 2's)2 2 3 5 = 60 = 16 , 17 = 1 (2) ::: this is because we removed 30 because of 3 mult of 2, then we removed 30 again because 5 mult of 3
		// 2 2 2 3 5 = 120 = 32 , 35 = 3 (4)
		// 2 2 2 2 3 5 = 240 = 64 , 71 = 7 (8)
		// 2 2 2 2 2 3 5 = 480 = 128 , 143 = 15 (16)
		
		// (one 2 and two 3s) 2 3 3 5 = 90 = 24 , 26 = 2 (3)
		// (one 2s and three 3s) 2 3 3 3 5 = 270 = 72 , 80 = 8 (9)
		// (one 2s and four 3s) 2 3 3 3 5 = 810 = 216 , 242 = 26 (27)
		// (one 2s and five 3s) 2 3 3 3 5 = 2,430 = 648 , 728 = 80 (81)
		
		////(two 2's) 2 2 3 5 7 = 420 = 96 , 125 = 29 (30) ::: 
		////(two 2's) 2 2 3 5 11 = 660 = 160 , 197 = 37 (38) ::: +8
		////(two 2's) 2 2 3 5 13 = 780 = 192 , 233 = 41 (42) :::+4
		////(two 2's) 2 2 3 5 17 = 1020 = 256 , 305 = 49 (50) :::+8
		////(two 2's) 2 2 3 5 19 = 1140 = 288 , 341 = 53 (54) :::+8
		
		
	////(two 2's) 2 2 3 7 11 = 924 = 240 , 281 = 41 (42) ::: 
			////(two 2's) 2 2 3 7 13 = 1092 = 288 , 333 = 45 (46) :::+4
			////(two 2's) 2 2 3 5 17 = 1020 = 256 , 305 = 49 (50) :::+8
			////(two 2's) 2 2 3 5 19 = 1140 = 288 , 341 = 53 (54) :::+8
		
	////(two 2's) 2 2 7 11 = 308 = 120 , 121 = 1 (2) ::: 
	////(two 2's) 2 2 7 13 = 364 = 144 , 145 = 1 (2) ::: 
		
	////(two 2's) 2 2 7 11 17 = 5236 = 1920 , 1989 = 69 (70) ::: 
	////(two 2's) 2 2 7 13 17 = 6188 = 2304 , 2377 = 73 (74) ::: 
		
		// 2 7 11 17 = 2618 = 960 , 993 = 33 (34) === is this 17 * 2? or 17 + 11 + 7 +2  = 37 no
		// 2 7 11 29 = 4466 = 1680 , 1725 = 45 (46) === is this .??? 29 + 11 + 7 + 2 = 49 no
		
		//17 29 41 = 20213 = 17920 = good
		// when we have 3 factors....we are good.... 4 or more....we are bad...and worse as it goes
		
		// (two 2s and two 3s) 2 2 3 3 5 = 180 = 48 , 53 = 5 (6) - this is like the one 2 and two 3, but *2 because we have another 2?
		// (two 2s and three 3s) 2 2 3 3 3 5 = 540 = 144 , 161 = 17 (18) * 
		// (two 2s and four 3s) 2 2 3 3 3 3 5 = 1,620 = 432 , 485 = 53 (54)
		
		
		// (three 2s and two 3s) 2 2 2 3 3 5 = 360 = 96 , 107  = 12-1=11 - this is like the one 2 and two 3, but *2 because we have another 2?
		
		// I think we are taking away too many, like we take away some 3's but we already took some away from the 2's? something like that...
		//taking away too many for sure I think
		
		
		/*
		//( two 2's two 3's two 5's one 7 ) 2 2 3 3 5 5 7
		// 6,300
		// real 1440 
		// ours 1917
		// over 477 (478)
		
		(two 2's two 3's one 5 one 7) 2 2 3 3 5 7 = 1,260 = 288 , 381 = 93 (94)
		 
		 ok so I think I figured it out
		 its how many of each factor.....
		 
		 so if there are two 2's then we need to do 2 to the power of 1 (however many 2's -1)
		 so if there were three 2's its 2to the power of 3-1 = 2 ==== 2 to the power of 2
		 And do that for each factor
		 so if there are three 3's and four 5's we do 3^2 * 5^3 = 9 * 125
		 
		 lets try 2 2 3 3 3 5 5 5 7 7 11
		 7,276,500
		 2^1 = 2
		 3^2 = 9
		 5^2 = 25
		 7^1 = 7
		 11^0 = 1
		 phi for 7276500 = 2334144 with nphi = 3.1174169202928352
		 - 3,150
		 2,330,994
		 
		 real phi 1512000
		 
		 ....???? 
		 we are over by 822,144???
		 
		 
		 what if we try:
		 lets try 2 2 3 3 3 5 5 5 7 11
		 1,039,500
		 real: 216000
		 
		 ours : 333444 (333445)
		 diff of : 117,444 (117,445)
		 2 2's
		 n 3 
		 no 7's ???
		 
		 */
		
		//for testing:
		int test = 60; // 30 is good, bad: 60 should be 16, 120, 180....540... are all bad
		addAllPrimesUpto(primes, test);
		System.out.println("Done getting this many primes to test: " + primes.size());
		
		
		// for this approach I am trying to find all the numbers that DO HAVE SOMETHING IN COMMON with the number. Then take the difference at the end...
		// so for 6 we try to find 2,3,4
		// that should leave 1,5
		for (int i = test; i < test+1; i++) { // this is all the numbers we need to check 2 - a million
		
			//System.out.println("new I = " + i);
			
			//int numToGetPhiFor = i;
			List<Integer> facts = new ArrayList<Integer>();
			
			// go through all primes in our list (should be only primes less than this number)
			// if divisible by any - not prime..
			// if at the end of the list not divisible..prime?
			boolean isPrime = true;
			int phi = 0; // set to 1 because every number has 1 has a coprime?
			for(int p = 0; p < primes.size(); p++) {
				
				
				int prime = primes.get(p);
				
				
				if(i % prime == 0) { // i is not prime - but we found a factor...
					// what do we do with this factor now...
					
					isPrime = false;
					
					int numOfThisNumInI = i / prime;
					numOfThisNumInI -= 1;
					// we take away 1 because we are only looking at numbers BELOW this num...
					// so for 6 (with prime=2) 6/2 = 3 ... meaning there are three 2's in 6 (2,4,6) but we only want below 6 so 3-1 = 2 (2,4)
					
					int howManyOfTheseFactors = 0;
					int tempI = i;
					
					
					
					while(tempI % prime == 0) {
						tempI /= prime;
						howManyOfTheseFactors++;
						//System.out.println("counted one " + howManyOfTheseFactors);
					}
					System.out.println("Counted this many factors of " + prime + " for " + i + " = " + howManyOfTheseFactors);
					
					
					
					phi += numOfThisNumInI;
					System.out.println("Adding " + (numOfThisNumInI) + " to phi for " + prime + "'s in " + i + " ::: in " + i + " we have " + numOfThisNumInI + " " + prime + "'s");
					for(int jk=1; jk <= numOfThisNumInI; jk++) {
						System.out.print(" " + (prime*jk));
						
					}
					System.out.println(" ");
					System.out.println("So now for " + i + " with have oppositePhi of " + phi);
					int runningFactTimes = 1;
					for(int j = 0; j < facts.size(); j++) {
						
						
						
						int f = facts.get(j);
						System.out.println("running fact * = " + runningFactTimes);// + " and pf = " + pf + " and mult=" + mult);
						runningFactTimes *= f;
						
					}
					for(int j = 0; j < facts.size(); j++) {
						//int f = facts.get(j);
						//int pf = prime * f;
						//int mult = i / (pf);
						int mult = i / prime;
						System.out.println("Checking mod for mult " + mult);
						for(int jk=1; jk < mult; jk++) { 
							System.out.println("Checking mod for " + (prime*jk));
							if((prime*jk) % runningFactTimes == 0) {
								
								//mult++;
								phi--;
								System.out.println((prime*jk) + " is getting skipped for prime " + prime + " with factor and jk " + jk + " running:"+ runningFactTimes);
								//System.out.println((prime*f*jk) + " is mod 0 for " + runningFactTimes + " new phi " + phi);
							} else {
								
								System.out.println((prime*jk) + " is getting Kept for prime " + prime + " with   and jk " + jk);
							}
							
						}
						
						phi--; //CAREFUL MIGHT PUT THIS BACK?
						
						System.out.println("Sooooo now for " + i + " with have oppositePhi of " + phi);
						//numOfThisNumInI -= mult;
						//phi -= (mult-1);
						
						
						
						
						
						//System.out.println("But we should remove " + (mult-1) + " " + prime + "'s because they are mults of " + f + " :::: mult = i / (prime * f); " + i + " / (" + prime + " * " + f+ " )" );
						for(int jk=1; jk < mult; jk++) {
							System.out.print(" " + (prime*jk));
							
						}
						System.out.println(" so now phi is "+ phi);
					}
					facts.add(prime);
					
					//int howMany = i / prime;
					// if we are doing 12 lets say (i = 12)
					// and this prime is 2
					// then howMany is 6
					// so 6-1 = 5 is how many 2's are below 12
					
					// then we get to 3
					// howMany gives us 4-1 = 3
					// so 3 3's below 12... but we dont want the 6...
					
				}
				
				
				
			}
			
			if(isPrime) {
				//System.out.println(i + " is prime...adding to primes");
				phi = i-1;
				primes.add(i);
			} else {
				phi = i - 1 - phi; // -1 because we really just have 5 numbers to look at for 6 = all numbers BELOW, not including
				// so we have 1,2,3,4,5 to work with... we have found 3 so far for 6 (2,3,4) so 5-3 = 2 (1,5)
			}
			
			
			double nOverPhi = (double) i/phi;
			System.out.println("phi for " + i + " = " + phi + " with nphi = " + nOverPhi);
			//if(i == 18 || i == 12)
				//System.out.println("Adding 1 to " + nums[i] + " with i=" + i + " is now " + (nums[i]+1));
			//nums[i]++;
			if(i % 1000 == 0) {
				System.out.println("Doing : " + i);
			}
			
		}
		
	}
	
	private static void addAllPrimesUpto(List<Integer> primes, int test) {
		for(int i = 2; i<test; i++) {
			if(Util.isPrime(i)) {
				primes.add(i);
			}
		}
		
	}
	private static void problem456() {
		
		List<Integer> primes = new ArrayList<Integer>();
		// TODO Auto-generated method stub
		//find factors other than 1 that are in both numbers...
		
		// 6 and 4 are not coprime because they have 2 in common
		double maxD = 0;
		int maxN = 0;
		int max = 100;
		
		int[] nums = new int[max]; // this will maybe hold all the numbers to a million, index is the num (so a million indexes?) and the value is the ... value (num of coprimes)
		//this might not work...toobig?
		
		for (int i = 2; i < max; i++) { // this is all the numbers we need to check 2 - a million
		
			
			
			
			
			//if(i == 18 || i == 12)
				//System.out.println("Adding 1 to " + nums[i] + " with i=" + i + " is now " + (nums[i]+1));
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
			//System.out.println("DOING NEW PRIME: " + i + " = " + d + " NOW DOING ALL MULTIPLES OF " + i);
			
			int ij = 0;
			for (int j = 2; (ij=i*j) < max; j++) {
			
				ij = i*j;
				//System.out.println("Doing i=" + i + " , j=" + j + " : i*j = " + (i*j));
				
				//if((ij) == 18) {
				//	System.out.println("18 Doing i=" + i + " , j=" + j + " : ij = " + ij + " :: and adding " + (j-1) + " to " + nums[ij]);
				//}
				//should it be i * (j-1)? then check for mult of those? random thought
				
				
				//for (int k = 1; k < j; k++) {
				//	System.out.println("heres the nums for " + ij + " : " + (i*k));
				//}
				
				int div = 0;
				//if(j > i) {
					for(Integer k : primes) {
						for (int l = 2; l < j; l++) {
							if((l*i) % k == 0) {
								div++;
							}
						}
						//if(j % k == 0) {
						//	System.out.println("divisible skipping : "+ j + " with " + k + " for num(ij) " + ij + " for prime " + i);
							
						//}
					}
				//}
				//boolean isDiv = false;
				//for(Integer k : primes) {
				//	if(j % k == 0) {
				//		System.out.println("divisible skipping : "+ j + " with " + k + " for num(ij) " + ij + " for prime " + i);
				//		isDiv = true;
				//		break;
				//	}
				//}
				
						
				
				nums[ij] += j-1-div;
				
				//System.out.println("num " + ij + " final div = " + div + " for prime "+ i + " and j-1=" + (j-1) + " :: so finally adding " + (j-1-div));
					//div = howManyDivisibleBy(primes, j);
				//if(!howManyDivisibleBy(primes, j)) {
					//System.out.println("is not divisible .... going with  i=" + i + " ij=" + ij);
				//if((ij) == 18) {
					//	System.out.println("Doing i=" + i + " , j=" + j + " : i*j = " + ij + " :: and adding " + (j-1) + " to " + nums[ij]);
				//	System.out.println(" .... going with  i=" + i + " j=" + j + " ij=" + ij + " :: div = "+ div + " and then j-1-div=" + (j-1-div));
				//}
					
				
					
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

}
