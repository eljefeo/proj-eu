import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem69 extends ProblemImpl{
	
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
		
		Problem p = new Problem69();
		p.runProblem();
		
		problemWOldFashionedWay();
		
	}
	
	public void problem() {
		
		//this is a shortcut I figured out
		// since the PE problem only asks for N, doesnt care about phi or phi(n) etc..
		//this is a shortcut to find the N that has the largest n/phi(n) without knowing phi at all
		// even more bestest notes:
		// found that the largest numbers are just the primes multiplied by each
		// so 2, then 3
		// then 2*3
		// then 2*3*5
		//then 2*3*5*7
		//then 2*3*5*7*11
		//then 2*3*5*7*11*13 etc....
		/*
		 
		 so whatever highest n/phi(n) you want is just
		 
		 primes from smallest to highest until you go over that number
		 
		 so under 1,000,000?
		 keeping adding the primes until you go over a million
		 
		 // so 2, then 3
		// then 6 = 2*3
		// then 30 = 2*3*5
		//then 210 = 2*3*5*7
		//then 2,310 =  2*3*5*7*11
		//then 30,030 = 2*3*5*7*11*13 
		//then 510,510 = 2*3*5*7*11*13*17
		 //then 9,699,690 = 2*3*5*7*11*13*17*19
		  oops that last one went above 1million
		  then the answer is 510510
		 */
		int max = 1000000;
		
		int n = 1;
		int mult = 1;
		List<Integer> primes = new ArrayList<Integer>();
		
		
		/// NEED TO DO TESTING ON getNextPrime and getNextPrime2
		// WHY DOES GETNEXTPRIME FAIL BUT 2 WORKS???????
		
		while(mult < max) {
			Util.getNextPrime2(primes, n++);
			mult *= primes.get(primes.size()-1);
		}
		
		mult /= primes.get(primes.size()-1);
		
		System.out.println("slipped into winners circle: Found : " + mult);
		
	}
	
	public static void problemWOldFashionedWay() {
		
		System.out.println("This way calculates actual phi, unlike the one above that just goes to the answer without getting phi");
		
		int max = 1000000;
		double maxD = 0;
		int maxN = 0;
		int maxPhi = 0;
		
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
					tempI = tempI / prime;
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
			
			double nOverPhi = (double) i/phi;
			if(nOverPhi > maxD) {
				maxD = nOverPhi;
				maxN = i;
				maxPhi = phi;
				System.out.println("new bigger phi for " + i + " = " + phi + " with nphi = " + nOverPhi);
			}
		}
		
		System.out.println("Max nOverPhi = " + maxD +  " for num (answer is this) = " + maxN + " with phi=" + maxPhi); //2635759
		
		
	}
	
	private static void problemDidntKnowTheSecret() {
		
		int max = 1000000;
		double maxD = 0;
		int maxN = 0;
		int maxPhi = 0;
		
		List<Integer> primes = new ArrayList<Integer>();
		
		//for testing:
		//int test = max; 
		//addAllPrimesUpto(primes, test);
		//System.out.println("Done getting this many primes to test: " + primes.size());
		//for (int i = test; i < test+1; i++) { // this is all the numbers we need to check 2 - a million
		//long totaldone = 0;
		for (int i = 2; i < max; i++) {
			
			if(i % 100000 == 0)
				System.out.println("Doing : " + i);
			
			int phi = 1; // set to 1 because every number has 1 has a coprime?
			int tempI = i;
			
			boolean shouldSkip = false;
			
			for(int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				//if(prime > (int)Math.sqrt(tempI))
				if(prime > tempI)
					break; 
				
					// break out early if the primes are larger than our num, no need to continue. Save some time
			
				if(i % prime == 0) {
					phi *= (prime-1);
					tempI = tempI/prime;
					//totaldone++;
					while(tempI % prime == 0) {
						//totaldone++;
						tempI /= prime;
						phi *= prime;
					}
				}
			}
			
			//if(shouldSkip)
			//	continue;
			
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
				System.out.println("new bigger phi for " + i + " = " + phi + " with nphi = " + nOverPhi);
			}
		}
		
		System.out.println("Max nOverPhi = " + maxD +  " for num (answer is this) = " + maxN + " with phi=" + maxPhi); //2635759
		
	}
	

	
	private static void addAllPrimesUpto(List<Integer> primes, int test) {
		for(int i = 2; i<test; i++) {
			if(Util.isPrime(i)) {
				primes.add(i);
			}
		}
		
	}
}






//original notes:



//				4500 		2 2 3 3 5 5 5 = 1200 or 3300
//				2250		2 3 3 5 5 5 = 	600 or 1650
//				450	 		2 3 3 5 5 = = 	120 or 330
// 				90    		2 3 3 5 = 		24 or 66
//				30 		 	2 3 5 = 	 	8 or 22 

		
/*
 * ---------- ANSWER TO THIS MADNESS -----------
 * 
 so what Im seeing is this....
 the secret value for primes are themselves - 1 (this also is the phi value for said prime)
 so 2 = 1
 3 = 2
 5 = 4
 7 = 6
 11 = 10
 etc...
 
 Then..start with 1
 as you find factors (primes) for any number that has one of those primes you multiply by the secret value (prime-1)
 
 then if they have any duplicates of those primes, you multiply by that prime
 
 so like 5 7 = 35
 this would be 4 * 6 = 24
 
 but if its 3 5 5 7 = 525
 that is 3-1 * 5-1 * 7-1 = 2*4*6 = 48
 but there is more than one 5 so 48*5 = 240
 
 
 yes this actually f*%#ing works ...only took 3 days of staring and thinking trying to find this strange pattern
 The pattern has revealed itself to me. Its not the fasest way Im sure, but I did it myself goshDarnit!
 
  * ---------- / ANSWER TO THIS MADNESS -----------
 
 */

		//			105		7 3 5 = 48 or 57
		//			75		5 3 5 = 40 or 35
		//			45		3 3 5 = 24 or 21
	// 				30 		2 3 5 = 8 or 22

		//    	    65		5 13 =  48 or 17
		//		    55		5 11 =  40 or 15
		//	        35		5 7  =  24 or 11

			//	    39		3 13 =  24 or 15
			//		33    	3 11 =  20 or 13
			//		21		3 7 =   12 or 9
			//	    15    	3 5 =    8 or 6
			//		9		3 3 =    6 or 3

			//		81      3 3 3 3 =  54 or 27
			//		27      3 3 3 	=  18 or 8
			//		9		3 3 	=   6 or 3
			//		3   	3  		=   2 or 1 



			// 		14		2 7 =  6 or 8
			//      10  	2 5 =  4 or 6
			//		6		2 3 =  2 or 4

			//		11		11 =   10 or 1
			//		7   	7  =   6 or 1
			//		5   	5  =   4 or 1
			//		3   	3  =   2 or 1
			//		2   	2  =   1 or 1


// (one 2s and three 3s) 2 3 3 3 5 = 270 = 72 or 198
// (one 2s and four 3s)  2 3 3 3 3 5 = 810 = 216 or 594
// (one 2s and five 3s)  2 3 3 3 3 3 5 = 2,430 = 648 

//			    2 3 5 7 = 210 = 48 or 162
////(two 2's) 2 2 3 5 7 = 420 = 96 or 323(324) == 

//              2 3 5 11 = 330 = 80 or 249 (250)
////(two 2's) 2 2 3 5 11 = 660 = 160 or 499 (500) == up 64 or up 176
////(two 2's) 2 2 3 5 13 = 780 = 192 or 587 (588) == up 32 or up 88
////(two 2's) 2 2 3 5 17 = 1020 = 256 or 763 (764) == up 64 or up 176
////(two 2's) 2 2 3 5 19 = 1140 = 288 or 851 (852)  == up 32 or up 88


	////(two 2's) 2 2 3 7 11 = 924 = 240 
	////(two 2's) 2 2 3 7 13 = 1092 = 288 
	////(two 2's) 2 2 3 5 17 = 1020 = 256
	////(two 2's) 2 2 3 5 19 = 1140 = 288 

////(two 2's) 2 2 7 11 = 308 = 120 , 121 = 1 (2) ::: 
////(two 2's) 2 2 7 13 = 364 = 144 , 145 = 1 (2) ::: 

////(two 2's) 2 2 7 11 17 = 5236 = 1920 , 1989 = 69 (70) ::: 
////(two 2's) 2 2 7 13 17 = 6188 = 2304 , 2377 = 73 (74) ::: 


