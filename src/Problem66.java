import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Problem66 {
	
	/*
	 
	  
	  Consider quadratic Diophantine equations of the form:

x^2 - Dy^2 = 1

For example, when D=13, the minimal solution in x is 649^2 - 13×180^2 = 1.

It can be assumed that there are no solutions in positive integers when D is square.

By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:

3^2 – 2×2^2 = 1
2^2 – 3×1^2 = 1
9^2 – 5×4^2 = 1  --> 9 is highlighted in red in the picture because it is the largest <= 7 as requested below
5^2 – 6×2^2 = 1
8^2 – 7×3^2 = 1

Hence, by considering minimal solutions in x for D <= 7, the largest x is obtained when D=5.

Find the value of D <= 1000 in minimal solutions of x for which the largest value of x is obtained.
	 
	 */

	public static void main(String[] args) {
		problem();
		//346323031
		//wrong!
	}

	private static void problem() {
		int max = 1000;
		//int d = 7;	
		
		BigInteger maxX = BigInteger.ZERO;
		
		for(int d = 2; d <= max; d++) {
			
			if(d % 10 == 0) {
				System.out.println(" at " + d);
			}
			
			
			BigInteger x = BigInteger.ONE;
			BigDecimal y = new BigDecimal(""+0.1);

			
			BigDecimal sq = new BigDecimal(""+d).sqrt(MathContext.DECIMAL32);
			if(sq.signum() == 0 || sq.scale() <= 0 || sq.stripTrailingZeros().scale() <= 0) {
				continue;
			}
			//try {
			//	sq.toBigIntegerExact();
			//	continue;
			//} catch(Exception e) {
				
			//}
			//if(sq - (int)sq == 0) {
				//System.out.println("Skipping " + d);
			//	continue;
				//return;
			//}
			
			//System.out.println("start x = " + x + " ::: D = " + d + " ::: y = " + y + ", y - int y : " +(y - (int)y));
			
			boolean hasDecimalOrIsZero = y.signum() == 0 || y.scale() <= 0 || y.stripTrailingZeros().scale() <= 0; // maybe alter this, this function might actually change y - maybe use a duplicate var
			//try {
			//	y.toBigIntegerExact();
			//	continue;
			//} catch(Exception e) {
				
			//}
			
			while(!hasDecimalOrIsZero) {
				
				x = x.add(BigInteger.ONE);
				// y = sqrt ( D(x+1)(x-1) ) / D
				//System.out.println("(x+1) = " + (x+1)  +", (x-1) = " + (x-1));
				//System.out.println("sqrt " + ((x+1) * (x-1) ) + " , x= "+ x + " ::: D = " + d + " ::: y = " + y);
				BigDecimal xDecimal = new BigDecimal("" + x);
				BigDecimal xPlusOne = xDecimal.add(BigDecimal.ONE);
				BigDecimal xMinusOne = xDecimal.subtract(BigDecimal.ONE);
				BigDecimal dBig = new BigDecimal("" + d);
				BigDecimal xx = dBig.multiply(xPlusOne).multiply(xMinusOne);
				//if(d % 10 == 0) {
				//	System.out.println("XX : " + xx);
				//}
				BigDecimal xxSquareRoot = xx.sqrt(MathContext.DECIMAL32);
				BigDecimal dDecimal = new BigDecimal("" + d);
				try{
					y = xxSquareRoot.divide(dDecimal);
					hasDecimalOrIsZero = y.signum() == 0 || y.scale() <= 0 || y.stripTrailingZeros().scale() <= 0;
				} catch (Exception e) {
					hasDecimalOrIsZero = false;
				}
				
				hasDecimalOrIsZero = y.signum() == 0 || y.scale() <= 0 || y.stripTrailingZeros().scale() <= 0;
				//System.out.println("doing x = " + x + " ::: D = " + d + " ::: y = " + y);
				
			}
			
			//System.out.println("Found x = " + x + " ::: D = " + d + " ::: y = " + y);
			//if(x > 0 ) {
			//	System.out.println("ERROR : " + x);
			//}
			if(x.compareTo(maxX) == 1) {
				maxX = x;
			}
			
			
		}
		
		
		System.out.println("Max x = " + maxX);
		
	}

}
