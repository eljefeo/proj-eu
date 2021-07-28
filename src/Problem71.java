
public class Problem71 extends ProblemImpl{

	
	/*
	 
	 Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d <= 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

It can be seen that 2/5 is the fraction immediately to the left of 3/7.

By listing the set of reduced proper fractions for d <= 1,000,000 in ascending order of size, find the numerator of the fraction immediately to the left of 3/7.
	 
	 
	 */
	
	public static void main(String[] args) { //Took 0.029194 seconds
		new Problem71().runProblem();
	}
	/*
	 
	 so after looking at these fractions for a while here's what Im thinking
	 3/7 is next to 2/5 because:
	 we work our way down the denoms from the highest (8,7,6,5...)
	 until we find a fraction where the reduced fraction has  a denom less than our max (8)
	 so:
	 3/7 -> 8
	 lcm of 7 and 8 = 56
	 so 3/7 = 8/56
	 this means the fraction directly to the left would be 7/56
	 can we reduce 7/56 to the point where the denom is <8?
	 no...
	 
	 so go to the next one (skip 7 since we are doing 7)
	 7 and 6 = 42
	 so 3/7 = 18/42
	 so we need 17/42
	 can we reduce 42 below 8? No...
	 on to 5...
	 7 and 5 = 35
	 so 15/35 means we need 14/35
	 hmm both are divisible by 7
	 14/35 = 2/5
	 5 is below 8, there we go...
	 answer is 2/5
	 lets try it
	 
	 
	 
	 */
	

	
	
	public long[] lcmWithMult(long a, long b) { //assuming both nums are positive
		
		long h, l;
		if(a == b) 
			return new long[] { a, 1 };
		
		if(a < b) {
			l = a;
			h = b;
		} else {
			h = a;
			l = b;
		}
		int i = 2;
		long lcm = h;
		while(lcm % l != 0) {
			//System.out.println("lcm is " + lcm + " i="+ i + " h=" + h + " l=" + l);
			lcm = h * i++;
			//System.out.println("new lcm is " + lcm + " i="+ i + " h=" + h + " l=" + l);
		}
		
		// the second thing in the array is how much to multiple the HIGHER number to to get the lcm
		return new long[] { lcm, i-1 };
	}
	
	public long[] reduceFraction(long n, long d) {
		
		//int i = 2;
		long na = n, da = d;
		for(int i=2; i < d/2; i++) {
			if(na % i == 0 && da % i == 0) {
				while (na % i == 0 && da % i == 0) {
					na /= i;
					da /= i;	
				}
				i++;
			}
		}
		
		return new long[] {na, da};
	}
	
	@Override
	public void problem() {

		int max = 1000000;
		int nGoal = 3, dGoal = 7;
		
		for(int i=max; i > 0; i--) { 	// denom
			
			if(i == dGoal)
				continue;
			
			long[] dets  = lcmWithMult(i, dGoal);
			
			long w = dets[1];
			if(dGoal < i) // the second thing in the array
				// is how many to mult the HIGHER num to to get the lcm
				// but we dont know if the i we are testing is higher / lower than dGoal
				// so we need to do this only if dGoal is less than i
				w = dets[0] / dGoal;
			

			long newN = (nGoal * w) - 1;
			long[] red = reduceFraction(newN, dets[0]);
			if(red[1] <= max) {
				System.out.println("Fraction is " + red[0] + "/" + red[1]);
				System.out.println("Answer: " + red[0]);
				return;
			}
			
		}
		
	}

}
