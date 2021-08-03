
public class Problem73 implements Problem { 

	
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

	
	
	/*
	 
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
	
	@Override
	public String problem() {
		
		int maxDenom = 8;
		
		// for sample ascending order of fractions with d<=8, and 1<= n < d
		int[] numers = new int[] {1,1,1,1,1,2,1,3,2,3,1,4,3,5,2,5,3,4,5,6,7};
		int[] denoms = new int[] {8,7,6,5,4,7,3,8,5,7,2,7,5,8,3,7,4,5,6,7,8};
		
		if(numers.length != denoms.length) {
			System.out.println("diff sizes arrs: " + numers.length + " vs " + denoms.length);
			return "blah";
		}
		for(int i=0; i<numers.length; i++) {
			double dec = (double)numers[i] / denoms[i];
			System.out.println(numers[i] + "/" + denoms[i] + " = " + dec + " -- Looking for....");
			long[] left = getFractionToTheLeft(maxDenom, numers[i], denoms[i]);
			System.out.println("To the left of " +numers[i] + "/" + denoms[i] + " = " + dec  + " = " + left[0] + "/" + left[1]);
		}
		
		
		
		return "doneskies";
		
	}
	
	public long[] getFractionToTheLeft(int max, long rightNumerGoal, long rightDenomGoal) {
		if(rightDenomGoal == max && rightNumerGoal == 1) {
			System.out.println("ERROR - asking for left of leftmost fraction... what the heck are you doing???");
			return new long[] {0,0};
			// error - there is no fraction to the left of the leftmost fraction lol..
		}
		long[] ret = new long[2];

		int counter = 0;
		
		for(int i=2; i <= max; i++) {
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
			//System.out.println("found w = " + w + " from lcm = " + lcm[0] + " with multiple = " + lcm[1]);
			 // the second thing in the array
				// is how many to mult the HIGHER num to to get the lcm
				// but we dont know if the i we are testing is higher / lower than dGoal
				// so we need to do this only if dGoal is less than i
				
			
			long newNumerator = (rightNumerGoal * w) - 1;
			//System.out.println("finding new numerator : " + rightNumerGoal + "*" + w +" - 1 ==" + newNumerator);
			long[] red = Util.reduceFraction(newNumerator, lcm[0]);
			System.out.println("ooFraction is " + red[0] + "/" + red[1] + " from " + newNumerator + "/" + lcm[0]);
			
//			1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

			if(red[1] <= max) {
				counter++;
				System.out.println("LEFT OF " + rightNumerGoal + "/" + rightDenomGoal + " is " + red[0] + "/" + red[1]);
				//System.out.println("Answer: " + red[0]);
				//rightNumerGoal = red[0];
				//rightDenomGoal = red[1];
				
				return red;
				
				//break;
				//return "" + red[0];
			} else {
				System.out.println("couldnt find it " + rightNumerGoal + "/" + rightDenomGoal + " with " + red[0] + "/" + red[1] + " with i = " + i);
			}
			
		}
		
		return ret;
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

	
}
