import java.util.ArrayList;
import java.util.List;

public class Problem73 implements Problem { //Took 0.111773 seconds

	
	
	/*
	 
	 Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d <= 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

It can be seen that there are 3 fractions between 1/3 and 1/2.

How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d <= 12,000?
	 
	 */
	
	//
//	1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

	/*
	  
	
	
				 1/2
			3/7    	4/7
	 		2/5    	3/5
	 		3/8 	5/8
	 		1/3 	2/3
	 		2/7	 	5/7
	 		1/4		3/4
	 		1/5		4/5
	 		1/6		5/6
	 		1/7		6/7
	 		1/8 	7/8
	 		
	 */
	public static void main(String[] args) {
		Problem p = new Problem73();
		p.runProblem();
	}


	
	@Override
	public String problem() {
		// we go through all fractions for each denom
		// we count the fractions that are > 1/3 and < 1/2 and also that are not reduceable
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		
		int max = 12000, counter = 0;
		int rightNumerGoal = 1, rightDenomGoal = 2;
		int leftNumerGoal = 1, leftDenomGoal = 3;
		
		double leftDoub =  (double)leftNumerGoal / leftDenomGoal;
		double rightDoub = (double)rightNumerGoal / rightDenomGoal;
		
		int num = 2;
		
		while (num++ < max) {
			List<Integer> facts  = new ArrayList<Integer>();
			int n = num;
			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				//if(prime > sqrt) {
				if(prime > Math.sqrt(n)) {
					if(n == num) 
						primes.add(num); // n was never divided, had no divisors - means its prime
					 else if(n > 1) 
							facts.add(n);
					
					break;
				}
				
				if (n % prime == 0) {
					facts.add(prime);
					while(n % prime == 0)
						n /= prime;
				}
			}
			
			int minFraction = (int) (num * leftDoub); // like 8/3
			int maxFraction = num / rightDenomGoal; // like 8/2
			
			if((double)minFraction/num <= leftDoub) 
				minFraction++;
			
			if((double)maxFraction/num < rightDoub) 
				maxFraction++;
			
			if(facts.size() > 0) {
				for (int i = minFraction; i < maxFraction; i++) {
					boolean shouldSkip = false;
					for(Integer f : facts) 
						if(i % f == 0) {
							shouldSkip = true; // skip fractions where numerator is not coprime with denom. In other words, fractions that can be reduced, we skip since we will count those later when we get to the reduced version
							break;
						}
					
					if(!shouldSkip) 
						counter++;
				}
			} else {
				counter += maxFraction - minFraction; // we just count them all since denom is prime and nothing is not coprime with prime .. did I say that right?
			}
		}

		System.out.println("Counter = " + counter);
		
		return "" + counter;
	}
	public String problemBestChanceStillSucks() {
		int max = 12000, counter = 0;
		long rightNumerGoal = 1, rightDenomGoal = 2;
		long leftNumerGoal = 1, leftDenomGoal = 3;
		//long rightNumerGoal = 9, rightDenomGoal = 10;
		//long leftNumerGoal = 1, leftDenomGoal = 10;
		
		
		
		int cc = 0;
		while(rightNumerGoal != leftNumerGoal || rightDenomGoal != leftDenomGoal) {
			//break;
			
			long[] res = Util.getFractionToTheLeft(max, rightNumerGoal, rightDenomGoal);
			
			if(res[0] == 0 || res[1] == 0) {
				System.out.println("Broken at " + rightNumerGoal + "/" + rightDenomGoal + " == " + res[0] + "/" + res[1]);
				break;
			}
			
			if(cc++ % 100 == 0) {
				System.out.println("at cc = " + cc  +" -- trying " + rightNumerGoal + "/" + rightDenomGoal + " == " + res[0] + "/" + res[1] + " == " + ((double) res[0] / res[1]));
				
				//System.out.println("at num " + cc + " :: " + rightNumerGoal + "/" + rightDenomGoal + " == " + ((double)rightNumerGoal / rightDenomGoal)); 
			}
			
			rightNumerGoal = res[0];
			rightDenomGoal = res[1];
			
			counter++;
		}
		counter--;
		System.out.println("Counted this many: " + counter);
		
		return "";
	}
	public String problemTest() {
		
		int maxDenom = 8;
		
		// for sample ascending order of fractions with d<=8, and 1<= n < d
		int[] numers = new int[] {1,1,1,1,1,2,1,3,2,3,1,4,3,5,2,5,3,4,5,6,7};
		int[] denoms = new int[] {8,7,6,5,4,7,3,8,5,7,2,7,5,8,3,7,4,5,6,7,8};
		
		if(numers.length != denoms.length) {
			System.out.println("diff sizes arrs: " + numers.length + " vs " + denoms.length);
			return "blah";
		}
		
		int gc = 0;
		
		for(int i=1; i<numers.length; i++) {
			double dec = (double)numers[i] / denoms[i];
			System.out.println(numers[i] + "/" + denoms[i] + " = " + dec + " -- Looking for....");
			long[] left = Util.getFractionToTheLeft(maxDenom, numers[i], denoms[i]);
			
			
			if(left[0] != numers[i-1] || left[1] != denoms[i-1]) {
				System.out.println("*************ERRORRRRRRR --- wrong answer...for " + numers[i] + "/" + denoms[i] + " ..we got " + left[0] + "/" + left[1] + " instead of " + numers[i-1] + "/" + denoms[i-1]);
			} else {
				gc++;
				System.out.println("YESSSSSS To the left of " +numers[i] + "/" + denoms[i] + " = " + dec  + " = " + left[0] + "/" + left[1]);
			}
		}
		
		
		
		System.out.println("Done with " + gc + " =?= " + (numers.length-1) + " = " + (gc == numers.length-1) );
		return "doneskeez";
		
	}


	public String problemo() {
		
		int counter = 0;
		
		System.out.println("start");
		int max = 8;
		long rightNumerGoal = 1, rightDenomGoal = 4;
		long leftNumerGoal = 1, leftDenomGoal = 3;
		System.out.println("iseq " + (rightNumerGoal != leftNumerGoal && rightDenomGoal != leftDenomGoal));
		//while(rightNumerGoal != leftNumerGoal || rightDenomGoal != leftDenomGoal) {
			
			//for(int i=max; i > 1; i--) { 	// denom
			for(int i=2; i < max; i++) {
				System.out.println("doing rN=" + rightNumerGoal + "/ rD=" + rightDenomGoal + " with i = " + i);
				if(i == rightDenomGoal) {
					System.out.println("Skipping " + i + " because " + i + " == " + rightDenomGoal);// lets assume there are other numbers in between...like 3/7 and 4/7 have some numbers in between lets just assume
					continue;
				}
				
				if(i > rightDenomGoal ) {
					
					if(i % rightDenomGoal == 0) {
						System.out.println("Skipping " + i + " because " + i + " % " + rightDenomGoal + " == " + (i % rightDenomGoal) + " ::: skipped fraction: " );
						continue;
					}
					
					
				} else if(rightDenomGoal % i == 0) {
					System.out.println("qSkipping " + i + " because " + rightDenomGoal + " % " + i + " == " + (rightDenomGoal % i) + " ::: skipped fraction: " );
					continue;
				}
				
				long[] lcm  = Util.lcmWithMult(i, rightDenomGoal);
				
				long w = rightDenomGoal < i ? lcm[0] / rightDenomGoal : lcm[1];
				System.out.println("found w = " + w + " from lcm = " + lcm[0] + " with multiple = " + lcm[1]);
				 // the second thing in the array
					// is how many to mult the HIGHER num to to get the lcm
					// but we dont know if the i we are testing is higher / lower than dGoal
					// so we need to do this only if dGoal is less than i
					
				
				long newNumerator = (rightNumerGoal * w) - 1;
				System.out.println("finding new numerator : " + rightNumerGoal + "*" + w +" - 1 ==" + newNumerator);
				long[] red = Util.reduceFraction(newNumerator, lcm[0]);
				System.out.println("ooFraction is " + red[0] + "/" + red[1] + " from " + newNumerator + "/" + lcm[0]);
				
//				1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

				if(red[1] <= max) {
					counter++;
					System.out.println("LEFT OF " + rightNumerGoal + "/" + rightDenomGoal + " is " + red[0] + "/" + red[1]);
					//System.out.println("Answer: " + red[0]);
					rightNumerGoal = red[0];
					rightDenomGoal = red[1];
					break;
					//return "" + red[0];
				} else {
					System.out.println("couldnt find it " + rightNumerGoal + "/" + rightDenomGoal + " with " + red[0] + "/" + red[1] + " with i = " + i);
				}
				
			}
		//}
		System.out.println("done "+counter);
		return null;
	}
	

	
	
	/*
	 ---- so it dawned on me that we dont really need to know the order of these fractions
	 we just need to know how many are between 1/3 and 1/2...
	 I know it sayysss that we are doing it in an ordered list, but I dont think that needs to be part of it
	 we could just look through the different denominators, skip the reduceable fractions
	  and count how many are less than 1/2 but greater than 1/3...
	  lets try that, hopefully that is pretty quick ...
	  so we go through all the denoms, 12000 11999 11998 11997...... 4 3 2
	  if that denom is prime, then we need to check all the fractions with that denom
	  if that denom is not prime, we only want to check the fractions that are not reduceable
	   iow we only check the numerators that are coprime with the denom...
	   we could do that by getting the factors of the denom
	   then going through the numerators and checking if the numer is divisible by any of those factors
	   if not, then we check it..
	 
	 
	 --- its almost like it would also be helpful to check if we are doing a fraction
	 on which side of 1/2
	 since it seems to be a mirror of eachother from one end to the middle (from end to 1/2 and from 1/2 to other end)
	 its almost like if you are above 1/2 you are working backwards
	 and if you are < 1/2 you are working fowards with seemingly the same algorithm....
	 hmmm interesting, something to keep in mind.
	 
	 
	 ok so lets think about this....
	 lets say we want the next smallest (to the left of) to 1/4
	 Ideally the first place to look would be what, what is our best guess if we had to do one
	 I guess it would be the next fraction up...like next denom up or down?
	 like for 1/7 best choice to start with would be 1/8 (which happens to be the correct answer)
	 
	 but sometimes its not the correct answer like in :
	2/3 *5/7* 3/4 4/5
	(in the above example we are working above 1/2 - kinda like we are working backwards)
	
	
	when we go from 4/5 we do 3/4 - this does seem to follow our first instinct
	but then we would think we should do 3/4 -> 2/3...
	buuuuuttttttt there appears to be a fraction that fits in between that ::: 5/7
	... so what we could do is get the next fraction (in this case 2/3)... 
	... bt then somehow come up with a way to identify anything that could fit in between?
	
	 ....hmmmmmmmmmmmmmmm
	 
	 */
	
}
