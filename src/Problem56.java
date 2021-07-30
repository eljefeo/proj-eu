import java.math.BigInteger;

public class Problem56 extends ProblemImpl { //Took 0.092728 seconds

	
	/*
	 A googol (10^100) is a massive number: one followed by one-hundred zeros; 
	 100^100 is almost unimaginably large: one followed by two-hundred zeros. 
	 Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem56();
		p.runProblem();

	}

	
	public void problem() {
		
		int max = 100;
		int largestSum = 0;
		int largestI = 0;
		int largestJ = 0;
		
		for(int i=1; i<max; i++) {
			for(int j=1; j<max; j++) {
				BigInteger b = new BigInteger(""+i);
				BigInteger s = b.pow(j);
				int sum = Util.addUpAllDigits(s);
				if(sum > largestSum) {
					largestSum = sum;
					largestI = i;
					largestJ = j;
				}
			}
		}
		
		System.out.println("Largest sum: " + largestSum + " from " + largestI + " to the power " + largestJ);
		
	}
	

	
}
