package ProjEuProblems;
import java.math.BigInteger;

public class Problem66 implements Problem { //Took 0.041852 seconds
	
	/*
	 
	  
	  Consider quadratic Diophantine equations of the form:

x^2 - Dy^2 = 1

For example, when D=13, the minimal solution in x is 649^2 - 13�180^2 = 1.

It can be assumed that there are no solutions in positive integers when D is square.

By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:

3^2 � 2�2^2 = 1
2^2 � 3�1^2 = 1
9^2 � 5�4^2 = 1  --> 9 is highlighted in red in the picture because it is the largest <= 7 as requested below
5^2 � 6�2^2 = 1
8^2 � 7�3^2 = 1

Hence, by considering minimal solutions in x for D <= 7, the largest x is obtained when D=5.

Find the value of D <= 1000 in minimal solutions of x for which the largest value of x is obtained.
	 
	 */

	
	/*
	 its next whole num * last numerator + prev numerator?
	 same thing for denom?
	 
	 
	 
	 sqrt of 23: 1 / 0
	A[0]/B[0] = 4/1, a[0] = 4
	start periodic part
	A[1]/B[1] = 5/1, a[1] = 1
	A[2]/B[2] = 19/4, a[2] = 3
	A[3]/B[3] = 24/5, a[3] = 1
	A[4]/B[4] = 211/44, a[4] = 8
	Next fraction: 916 / 191
	
	*/
	
	public static void main(String[] args) {
		Problem p = new Problem66();
		p.runProblem();
}
	
	
	public String problem() {
		int max = 1000;
		BigInteger maxX = BigInteger.ZERO;
		int maxD = 0;
		for(int d = 2; d <= max; d++) {
			//System.out.println("doing d= " + d);
			BigInteger x = pellsEquation(d);
			//period(23);
			if(x != null && x.compareTo(maxX) == 1) {
				maxX = x;
				maxD = d;
			}
			
		}
		
		System.out.println("Max d = " + maxD + ", with x = " + maxX);
		return "" + maxD;
		
	}
	
	
	private static BigInteger pellsEquation(int i) { // currently returns x only, we can have it return y later if needed in the future
		
			double sn = Math.sqrt(i);
			
			if(sn - (int)sn == 0) {
				return null; // dont do perfect squares...
			}
			int sni = (int)sn;
			BigInteger d = new BigInteger(""+i);
			BigInteger snb = new BigInteger(""+sni);
			BigInteger firstWholeNum = new BigInteger(""+sni);
			BigInteger startNumerator = new BigInteger(""+firstWholeNum);
			BigInteger startDenom = BigInteger.ONE;
			BigInteger prevNum = BigInteger.ONE;
			BigInteger prevDenom = BigInteger.ZERO;
			
			//System.out.println("start numerator : " + startNumerator + ", startDenom : " + startDenom + ", previousNumerator : " + prevNum + ", previousDenom : " + prevDenom);
			
			// first fraction is 4 / 1
			// we use the 4 to get the next period 1
			// we do 4 * period 1 + prev fraction numerator (1 to start)
			
			firstWholeNum = firstWholeNum.multiply(new BigInteger(""+(-1)));
			BigInteger firstBottom = BigInteger.ONE;
			
			while(true) {
				//so here we use a trick I figured out, the pattern where we use the last 2 numerators and the period number to find the next convergent.
				// its numerator * period (next whole number) and then + the previous numerator. This gives you the next numerator for the next convergent fraction
				// same goes for denominator : denominator * period (next whole number) and then + the previous denominator
				// this way we just keep figuring out the next fraction until we find one that works.
				BigInteger periodNum = BigInteger.ZERO;
				BigInteger firstNumer = firstBottom; // do reciprocal first, numer becomes denom for next iteration
				firstWholeNum = firstWholeNum.multiply(new BigInteger(""+(-1)));
				firstBottom = d.subtract(firstWholeNum.multiply(firstWholeNum)); // 23 - 9 = 14
				firstBottom = firstBottom.divide(firstNumer);
				periodNum = snb.add(firstWholeNum).divide(firstBottom);
				firstWholeNum = firstWholeNum.subtract(periodNum.multiply(firstBottom)); // should be 4 - (1*7) = -3
				BigInteger x = startNumerator.multiply(periodNum).add(prevNum);
				BigInteger y = startDenom.multiply(periodNum).add(prevDenom);
				prevNum = startNumerator;
				startNumerator = x;
				prevDenom = startDenom;
				startDenom = y;
				//System.out.println("Next fraction: " + x + " / " + y + " with period: " + periodNum);
				//check now if x^2 - Dy^2 = 1;
				BigInteger x2 = x.multiply(x);
				BigInteger dy2 = d.multiply(y.multiply(y));
				//System.out.println("Next fraction: " + x + " / " + y + " with period: " + periodNum + " with result = " + x2 + " - " + dy2 + " = " + (x2.subtract(dy2)));
				if(x2.subtract(dy2).compareTo(BigInteger.ONE) == 0) {
					//System.out.println("yay found it for d=" + d + ", x = " + x + ", y = " + y);
					return x;
				}
				
			}
	}
	
private static void pellsEquationPeriodInt(int i) { // pretty much same function above but for int instead of bigInteger
			double sn = Math.sqrt(i);
			int firstWholeNum = (int) sn;
			
			int startNumerator = firstWholeNum;
			int startDenom = 1;
			int prevNum = 1;
			int prevDenom = 0;
			
			System.out.println("-----------------------------start numerator : " + startNumerator + ", startDenom : " + startDenom + ", previousNumerator : " + prevNum + ", previousDenom : " + prevDenom);
			
			if(sn - firstWholeNum == 0) {
				return; // dont do normal squares...
			}
			
			
			// first fraction is 4 / 1
			// we use the 4 to get the next period 1
			// we do 4 * period 1 + prev fraction numerator (1 to start)
			
			firstWholeNum = firstWholeNum * -1;
			//System.out.println("start firstWholeNum " +firstWholeNum);
			int firstBottom = 1;
			int coun = 0;
			
			boolean foundPeriod = false;
			while(!foundPeriod) {
				
				if(coun++ == 5) {
					foundPeriod = true;
				}
				
				int firstNumer = firstBottom; // do reciprocal first, numer becomes denom for next iteration
				firstWholeNum = firstWholeNum * -1 ; // + 3
				firstBottom = i - (firstWholeNum * firstWholeNum); // 23 - 9 = 14
				firstBottom = firstBottom / firstNumer;
				int extractNextWholeNum = (int) (sn + firstWholeNum) / firstBottom;
				firstWholeNum = firstWholeNum - (extractNextWholeNum * firstBottom); 
				int nextNumerator = startNumerator * extractNextWholeNum + prevNum;
				int nextDenominator = startDenom * extractNextWholeNum + prevDenom;
				prevNum = startNumerator;
				startNumerator = nextNumerator;
				prevDenom = startDenom;
				startDenom = nextDenominator;
				
				System.out.println("Next fraction: " + nextNumerator + " / " + nextDenominator);
				
				// how to show each continued fraction convergent
				/*
				 its next whole num * last numerator + prev numerator?
				 same thing for denom?
				 
				 
				 
				 sqrt of 23: 1 / 0
				A[0]/B[0] = 4/1, a[0] = 4
				start periodic part
				A[1]/B[1] = 5/1, a[1] = 1
				A[2]/B[2] = 19/4, a[2] = 3
				A[3]/B[3] = 24/5, a[3] = 1
				A[4]/B[4] = 211/44, a[4] = 8
				
				*/
				
		
				
				
			}
		
	}
	


	

}
