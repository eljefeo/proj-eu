import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		//problemBestSoFar();
		
		//problemhmmmm();
		problem();
}
	
	
	private static void problem() {
		period(23);
	}
	
	private static void continuedFraction(int ii) {
		int t = 100;
		BigInteger num = BigInteger.ONE;
		BigInteger den = new BigInteger("" + Util.getEPeriod(t));
		
		for(int i=t; i > 0; i--) {
			t--;
			BigInteger next = new BigInteger("" + Util.getEPeriod(t));
			num = den.multiply(next).add(num);
			BigInteger temp = num;
			num = den; 
			den = temp;

			
		}
		System.out.println(num + " / " + den);
		System.out.println("Digits sum : " + Util.addUpAllDigits(num));
		
	}
		
	
	private static void period(int i) {
		
		//int max = 10000;
		
		//for(int i = 2; i < max; i++) {
			
			double sn = Math.sqrt(i);
			int firstWholeNum = (int) sn;
			
			int startNumerator = firstWholeNum;
			int startDenom = 1;
			int prevNum = 1;
			int prevDenom = 0;
			
			System.out.println("start numerator : " + startNumerator + ", startDenom : " + startDenom + ", previousNumerator : " + prevNum + ", previousDenom : " + prevDenom);
			
			if(sn - firstWholeNum == 0) {
				return; // dont do normal squares...
			}
			
			
			// first fraction is 4 / 1
			// we use the 4 to get the next period 1
			// we do 4 * period 1 + prev fraction numerator (1 to start)
			
			firstWholeNum = firstWholeNum * -1;
			int firstBottom = 1;
			
			List<Integer[]> track = new ArrayList<Integer[]>();
			//System.out.println("first whole num : " + (firstWholeNum*-1)  + " top " + firstWholeNum + " bottom " + firstBottom);
			track.add(new Integer[] {firstWholeNum, firstBottom} );
			
			boolean foundPeriod = false;
			while(!foundPeriod) {
				int firstNumer = firstBottom; // do reciprocal first, numer becomes denom for next iteration
				firstWholeNum = firstWholeNum * -1 ; // + 3
				firstBottom = i - (firstWholeNum * firstWholeNum); // 23 - 9 = 14
				double firstBottomD = firstBottom / firstNumer;
				
				// check if numer and denom can be simplified down to 1 on the numerator (like 7/14 or 5/20 ... error if something like 9/12)
				if(firstBottomD - (int)firstBottomD != 0) {
					System.out.println("ERROR .... with " + firstBottomD + "  for first " +  firstWholeNum + " first numer " + firstNumer);
					return;
				}
				
				firstBottom = (int) firstBottomD;
				

				
				
				int extractNextWholeNum = (int) (sn + firstWholeNum) / firstBottom;
				firstWholeNum = firstWholeNum - (extractNextWholeNum * firstBottom); // should be 4 - (1*7) = -3
				//System.out.println("Next whole num : " + extractNextWholeNum  + " top " + firstWholeNum + " bottom " + firstBottom);
				//System.out.println("extractNextWholeNum : " + extractNextWholeNum);
				// Check for period:
				Integer[] current = new Integer[] {firstWholeNum, firstBottom};
				
				int nextNumerator = startNumerator * extractNextWholeNum + prevNum;
				int nextDenominator = startDenom * extractNextWholeNum + prevDenom;
				//System.out.println("Next numerator: " + nextNumerator + ", next denominator: " + nextDenominator);
				prevNum = startNumerator;
				startNumerator = nextNumerator;
				
				prevDenom = startDenom;
				startDenom = nextDenominator;
				
				//System.out.println("Next startNumerator: " + startNumerator + ", next prevNum: " + prevNum);
				//System.out.println("Next startDenom: " + startDenom + ", next prevDenom: " + prevDenom);
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
				
				for(int j=0; j < track.size();j++) {
					Integer[] ia = track.get(j);
					if(ia.length == 2 && ia[0] == current[0] && ia[1] == current[1]) {
						int periodSize = track.size() - j;

						foundPeriod = true;
						break;
					}
				}
				
				track.add(current);
				
			}
		//}
		
		for(int j=0; j < track.size();j++) {
			Integer[] ia = track.get(j);
			System.out.println("ia " + ia[0] + ", " + ia[1]);
		}
		
		//System.out.println("Odd period count under " + max + " :: " + oddPerCounter);
		
	}
	
	private static void problemhmmmm() {
		
		BigInteger result = BigInteger.ZERO;
		BigInteger pmax = BigInteger.ZERO;
		 
		//for(BigInteger D = BigInteger.TWO; D.compareTo(new BigInteger(""+1000)) == -1; D=D.add(BigInteger.ONE)){
		for(int i = 7; i <= 7; i++) {
			BigInteger D = new BigInteger(""+i);
			System.out.println("At d = " + D);
			
		    BigInteger limit = D.sqrt();
		    
		    System.out.println("Square root integer of " + i + " = " + limit);
		    if ((limit.multiply(limit)).compareTo(D) == 0) {
		    	System.out.println("Skipping " + D);
		    	continue;
		    }
		 
		    BigInteger m = BigInteger.ZERO;
		    BigInteger d = BigInteger.ONE;
		    BigInteger a = limit;
		 
		    System.out.println("m=" + m + ", d=" + d + ", a=" + a);
		    
		    BigInteger numm1 = BigInteger.ONE;
		    BigInteger x = a;
		    System.out.println("numm1=" + numm1 + ", num=" + x );
		    BigInteger denm1 = BigInteger.ZERO;
		    BigInteger y = BigInteger.ONE;
		    System.out.println("denm1=" + denm1 + ", den=" + y );
		    
		    //num*num - D*den*den != 1
		    BigInteger x2 = x.multiply(x);
		    BigInteger dy2 = D.multiply(y).multiply(y);
		    BigInteger x2Minus_dy2 = x2.subtract(dy2);
		    System.out.println();
		    System.out.println("trying x^2 - Dy^2 = 1");
		    System.out.println("trying " + x + "^2 - " + D + " * " + y + "^2");
		    System.out.println("trying " + x2 + " - " + dy2 + " = " + x2Minus_dy2);
		    System.out.println();
		    while(x2Minus_dy2.compareTo(BigInteger.ONE) != 0){
		    	
		    	System.out.println("m=" + m + ", d=" + d + ", a=" + a);
		    	System.out.println("doing d*a - m = " + d + " * " + a + " - " + m);
		        m = (d.multiply(a)).subtract(m);
		        System.out.println("m = " + m);
		        BigInteger m2 = m.multiply(m);
		        System.out.println("m2 = " + m2);
		        d = (D.subtract(m2)).divide(d);
		        System.out.println("doin (D.subtract(m2)).divide(d) = " + D + " - " + m2 + " / " + d);
		        a = (limit.add(m)).divide(d);
		        System.out.println("doin  a = (limit.add(m)).divide(d) = " + limit + " + " + m + " / " + d + " = " + a);
		 
		        System.out.println("Now m=" + m + ", d=" + d + ", a=" + a);
		        
		        BigInteger numm2 = numm1;
		        numm1 = x;
		        BigInteger denm2 = denm1;
		        denm1 = y;
		 
		        x =(a.multiply(numm1)).add(numm2);
		        y =(a.multiply(denm1)).add(denm2);
		        
		        
		        //set var to keep track
		        x2 = x.multiply(x);
			    dy2 = D.multiply(y).multiply(y);
			    x2Minus_dy2 = x2.subtract(dy2);
			    if(x2Minus_dy2.compareTo(BigInteger.ONE) == 0) {
			    	System.out.println("Found answer! x="+x+", y="+y+", d="+D);
			    } else {
			    	System.out.println("No answer yet with x="+x+", y="+y+", d="+D);
			    }
			   // System.out.println("new ret " + ret);
		        
		    }
		    
		    
		 
		    if (x.compareTo(pmax) == 1) {
		        pmax = x;
		        result = D;
		        System.out.println("New Max " + pmax + "  for d="+i);
		    }
		}
		
		System.out.println("Max " + pmax);
	}
	
	private static void problemBestSoFar() { 
		//d = x^2   - 1 / y^2
		// y^2 = x^2   - 1 / d
		// x = sqrt ( Dy^2 + 1)
		
		
		
		
		
		//d = x^2   - 1 / y^2 ::::: or y^2 = x^2   - 1 / d
		
		// some square number y times d is equal to one less than x^2( x^2 - 1)
		
		//Dy^2 - 1
		
		/*
		3^2 – 2×2^2 = 1
		2^2 – 3×1^2 = 1
		9^2 – 5×4^2 = 1  --> 9 is highlighted in red in the picture because it is the largest <= 7 as requested below
		5^2 – 6×2^2 = 1
		8^2 – 7×3^2 = 1
		*/
		
		
		long maxX = 0;
		long maxD = 0;
		long maxY = 0;
		
		long maxIsquareRoot = Long.MAX_VALUE;
		
		int max = 61;
		for(int d = 61; d <=max; d++) {
			
			
			double checkSquare = Math.sqrt(d);
			if(checkSquare - (long)checkSquare == 0) {
				continue;
			}
			
			//for(long y = 1; y <= 100; y++) {
			long y = 225000000L; // went up to y=120,000,000
			while(true) {
				y++;
				
				if(y % 100000 == 0) {
					System.out.println("at y="+y);
				}
				
				//int xs = (int) Math.pow(x, 2);
				
				long y2d = (long) Math.pow(y, 2) * d;
				
				//double x = Math.sqrt(y2d+1);
				BigDecimal x = new BigDecimal("" + (y2d+1)).sqrt(MathContext.DECIMAL128);
				
				BigDecimal fractionalPart = x.remainder(BigDecimal.ONE);
				
				//System.out.println("x = " + x + " , " + fractionalPart + " and equals : " + (fractionalPart.compareTo(BigDecimal.ZERO) == 0));

				if(fractionalPart.compareTo(BigDecimal.ZERO) == 0) {
					//System.out.println("skipping : " + d);
					//continue;
					System.out.println("Found x=" + x  + ", y=" + y + ", d=" + d + ", y2d=" + y2d );
					break;
					//if(x > maxX) {
					//	maxX = (long)x;
					//	maxY = y;
					//	maxD = d;
					//}
				}
				
				//if(x - (long)x == 0) {
					//System.out.println("Found x=" + x  + ", y=" + y + ", d=" + d + ", y2d=" + y2d + ", x^2=" + (Math.pow(x, 2)));
					
				//	if(x > maxX) {
					//	maxX = (long)x;
					//	maxY = y;
					//	maxD = d;
					//}
					
					//break;
				//}
				
				
				
				
				
			}
		}
		
		
		System.out.println("biggest x = " + maxX + ", y=" + maxY + ", d=" + maxD);
		
		
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
