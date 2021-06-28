import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
		
		
		Map<Integer, Integer> mm = new HashMap<Integer, Integer>();
		mm.put(5, 23);
		mm.put(2, 243);
		mm.put(4, 323);
		mm.put(3, 233);
		
		//System.out.println("Is all done " + isAllDone(mm, 5));
		
		
		//BigDecimal sq = new BigDecimal(""+4).sqrt(MathContext.DECIMAL64);
		//BigDecimal fractionalPart = sq.remainder(BigDecimal.ONE);
		//if(sq.signum() == 0 || sq.scale() <= 0 || sq.stripTrailingZeros().scale() <= 0) {
		//if(fractionalPart.compareTo(BigDecimal.ZERO) == 0) {
		//	System.out.println("skipping : " + 3 + " fraction : " + fractionalPart);
		//}
		
		//x+1 = 36470, x-1 = 36468, decimalD = 761, all mult together = 1012120837560, sqrt = 1006042
			//	Found x = 36469 ::: D = 761 ::: y = 1322
		
		//new with 64 decimal: 761 Found x = 1280001 ::: D = 761 ::: y = 46400
		BigDecimal xp1 = new BigDecimal("1280002");
		BigDecimal xm1 = new BigDecimal("1280000");
		BigDecimal d = new BigDecimal("761");
		BigDecimal m = xp1.multiply(xm1).multiply(d);
		//BigDecimal s = new BigDecimal("169876986986234234.23").sqrt(MathContext.DECIMAL32);
		BigDecimal s = m.sqrt(MathContext.DECIMAL128);
		//System.out.println("m = " + m + " , s = " + s);
		
		//761
		//wrong!
		//761 Found x = 36469 ::: D = 761 ::: y = 1322
		// some error with the math, maybe something with BigDecimals or something... those numbers dont add up... close but off by 437 ish, should be 1
	}
	private static void problem() { 
		//d = x^2   - 1 / y^2
		int max = 7;
		for(int d = 2; d <= max; d++) {
			for(int x = 2; x <= 100; x++) {
				int xs = (int) Math.pow(x, 2);
				
				
				
			}
		}
	}
	private static void problem3() { 
		//x^2 - Dy^2 = 1
		
		//int d = 7;	
		
		
		// what if we just go through x's, finding d's and y's
		// and just keep track of the d's we find
		// but we can tell when we have gone too far? Like x is always going to be greater than y...
		// so like x = 2...
		// x^2 is 4
		// and x^2 -1 = Dy^2
		// so one less than 4 (3) is some square number (1,4,16,25,36...) times some number D
		/*
		 
		  so get x... then minus 1
		  then go through other square numbers.... and divide by <= 1000? something like that?
		  // we can find other shortcuts too? like get factors of the y^2
		    
		    and we know y will be less than x right?
		    so what numbers less than x also divide by another number less than 1000
		   * 
		   * 
		   or what if we do D
		 
		 */
		
		BigInteger maxX = BigInteger.ZERO;
		int maxD = 0;
		int max = 1000;
		/*
		3^2 – 2×2^2 = 1
		2^2 – 3×1^2 = 1
		9^2 – 5×4^2 = 1  --> 9 is highlighted in red in the picture because it is the largest <= 7 as requested below
		5^2 – 6×2^2 = 1
		8^2 – 7×3^2 = 1
		*/
		
		
		Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
		//for(int x = 2; x <= max; x++) {
		int x = 1;
		//System.out.println("test : " + nums.get(7));
		while (!isAllDone(nums, max)){
			
			if(x % 200 == 0) {
					System.out.println(" at " + x);
			}
			
			if(x > 4000)
				break;
		
			x++;
			int xs = (x*x) - 1;
			//System.out.println("xs : " + xs);
			
			Set<Integer> fact = Util.getDistinctFactorsInt(xs);
			
			for (Integer i : fact) {
				//System.out.println("factor : " + i);
				
				double sq = Math.sqrt(i);
				if(sq - (int)sq == 0 ) {
					int d = (int)xs / (int)i;
					
					if(d == 661) {
						System.out.println("Found d=" + d +" for x="+x + " and y=" + sq);
					}
					
					//System.out.println("Found d=" + d +" for x="+x + " and y=" + sq);
					
					// need to limit so d is never above 1000
					//should we do this? Or if we already found it can we be sure its already smaller? I think so, maybe dont do this...
					if(d > max || d < 0) {
						continue;
					}
					if(nums.get(d) != null) {
						if(x < nums.get(d)) {
							nums.put(d, x);
						}
					} else {
						//System.out.println("Found new d " + d + " and x=" + x);
						nums.put(d, x);
					}
					
				}
				
			}
			
			
		}
		
		int xx = 0;
		int dd = 0;
		//System.out.println("d 5 = " + nums.get(5));
		for(Integer d : nums.keySet()) {
			int xc = nums.get(d);
			if(xc > xx) {
				xx = xc;
				dd = d;
			}
		}
		
		
		System.out.println("Largest x=" + xx + " for d=" + dd);
		getMissing(nums, max);
		System.out.println("661 " + nums.get(661));
		
	}

	private static boolean isAllDone(Map<Integer, Integer> nums, int expected) {
		int total = 0;
		
		//for(Integer i : nums.keySet()) {
		//	total += i;
			
		//}
		for(int d = 2; d <= expected; d++) {
			double sq = Math.sqrt(d);
			
			if(sq - (int)sq != 0 ) {
				if(nums.get(d) == null) {
					return false;
				}
			}
			
		}
	
		return total == Util.summationFromTo(2, expected);
	}

	private static void getMissing(Map<Integer, Integer> nums, int expected) {
		for(int d = 2; d <= expected; d++) {
			double sq = Math.sqrt(d);
			System.out.println("doing end " + d + " and sq  " + sq);
			if(sq - (int)sq == 0 ) {
				System.out.println("skipping end : " + d);
				continue;
			}
				if(nums.get(d) == null) {
					System.out.println("missing " + d);
				}
			
			
		}
	}
	
	private static void problem2() { 
		// brute force solving for y. Trying all x from 1,2,3,4,....
		// until we get a y integer..
		// super slow..
		
		int max = 661;
		//int d = 7;	
		
		BigInteger maxX = BigInteger.ZERO;
		int maxD = 0;
		for(int d = 661; d <= max; d++) {
			
			//if(d % 100 == 0) {
			//	System.out.println(" at " + d);
			//}
			System.out.println(" at " + d);
			
			BigInteger x = BigInteger.ONE;
			BigDecimal y = new BigDecimal(""+0.1);

			//skip perfect squares
			BigDecimal sq = new BigDecimal(""+d).sqrt(MathContext.DECIMAL64);
			BigDecimal fractionalPart = sq.remainder(BigDecimal.ONE);


			if(fractionalPart.compareTo(BigDecimal.ZERO) == 0) {
				System.out.println("skipping : " + d);
				continue;
			}

			
			fractionalPart = y.remainder(BigDecimal.ONE); // Result:  0.4523434
			boolean hasDecimal = fractionalPart.compareTo(BigDecimal.ZERO) == 1;
			
			while(hasDecimal) {
				
				x = x.add(BigInteger.ONE);
				
				if(x.mod(new BigInteger("100000")).compareTo(BigInteger.ZERO) == 0) {
					System.out.println(" at x = " + x + "  for d = " + d);
				}

				BigDecimal xDecimal = new BigDecimal("" + x.toString());
				BigDecimal xPlusOne = xDecimal.add(BigDecimal.ONE);
				BigDecimal xMinusOne = xDecimal.subtract(BigDecimal.ONE);
				BigDecimal dBig  = new BigDecimal("" + d);
				BigDecimal xx = dBig.multiply(xPlusOne).multiply(xMinusOne);
				BigDecimal xxSquareRoot = xx.sqrt(MathContext.DECIMAL64);
				
				fractionalPart = xxSquareRoot.remainder( BigDecimal.ONE ); // Result:  0.4523434
				if(fractionalPart.compareTo(BigDecimal.ZERO) == 1) {
					//System.out.println("square root has dec, skipping : " + xxSquareRoot + " for d="+d+" and x="+x);
					continue;
				}
				
				BigDecimal dDecimal = new BigDecimal("" + d);
				
				try{
					y = xxSquareRoot.divide(dDecimal);
					fractionalPart = y.remainder( BigDecimal.ONE ); // Result:  0.4523434
					hasDecimal = fractionalPart.compareTo(BigDecimal.ZERO) == 1;
					
					//hasDecimalOrIsZero = yy.signum() == 0 || yy.scale() <= 0 || yy.stripTrailingZeros().scale() <= 0;
				} catch (Exception e) {
					hasDecimal = true;
				}
				
			}
			
			System.out.println("Found x = " + x + " ::: D = " + d + " ::: y = " + y);

			if(x.compareTo(maxX) == 1) {
				maxX = x;
				maxD = d;
				System.out.println("New biggest :: y = " + y + ", x = " + x + ", d = " + d);
			}
			
			
		}
		
		
		System.out.println("Max d = " + maxD);
		
	}

}
