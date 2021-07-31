
public class Problem73 implements Problem { 

	
	//
//	1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

	public static void main(String[] args) {
		Problem p = new Problem73();
		p.runProblem();

	}

	@Override
	public String problem() {
		
		int counter = 0;
		
		System.out.println("start");
		int max = 12000;
		long rightNumerGoal = 1, rightDenomGoal = 2;
		long leftNumerGoal = 1, leftDenomGoal = 3;
		System.out.println("iseq " + (rightNumerGoal != leftNumerGoal && rightDenomGoal != leftDenomGoal));
		//while(rightNumerGoal != leftNumerGoal || rightDenomGoal != leftDenomGoal) {
			System.out.println("doing rN=" + rightNumerGoal + "/ rD=" + rightDenomGoal);
			for(int i=max; i > 1; i--) { 	// denom
			
				if(i == rightDenomGoal) // lets assume there are other numbers in between...like 3/7 and 4/7 have some numbers in between lets just assume
					continue;
				
				long[] lcm  = Util.lcmWithMult(i, rightDenomGoal);
				
				long w = rightDenomGoal < i ? lcm[0] / rightDenomGoal : lcm[1];
				 // the second thing in the array
					// is how many to mult the HIGHER num to to get the lcm
					// but we dont know if the i we are testing is higher / lower than dGoal
					// so we need to do this only if dGoal is less than i
					
				long newNumerator = (rightNumerGoal * w) - 1;
				long[] red = Util.reduceFraction(newNumerator, lcm[0]);
				//System.out.println("ooFraction is " + red[0] + "/" + red[1]);
				if(red[1] % rightDenomGoal == 0)
					continue;
				
				if(red[1] <= max) {
					counter++;
					//System.out.println("Fraction is " + red[0] + "/" + red[1]);
					//System.out.println("Answer: " + red[0]);
					rightNumerGoal = red[0];
					rightDenomGoal = red[1];
					//break;
					//return "" + red[0];
				}
				
			}
		//}
		System.out.println("done "+counter);
		return null;
	}

	
}
