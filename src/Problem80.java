import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem80 implements Problem{// 

	
	/*
	 It is well known that if the square root of a natural number is not an integer, then it is irrational. The decimal expansion of such square roots is infinite without any repeating pattern at all.

The square root of two is 1.41421356237309504880..., and the digital sum of the first one hundred decimal digits is 475.

For the first one hundred natural numbers, find the total of the digital sums of the first one hundred decimal digits for all the irrational square roots.Given that the three characters are always asked for in order, analyse the file so as to determine the shortest possible secret passcode of unknown length.
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem80();
		p.runProblem();
	}

	
	static int t1 = 0;
	static int t2 = 0;
	@Override
	public Object problem() {
		int num = 10;
		longDivSqrRt(num);
		//calcSquareRootOfTwoCheckIfNumerMoreDigitsThanDenom(9);
		
		Util.compare2PrimeFunctionsResults(2000000);
		Util.compare2PrimeFunctionsTimings();
		return 0;
	}
	
	
	public static int calcSquareRootOfTwoCheckIfNumerMoreDigitsThanDenom(int howManyIterations){
		
		BigInteger numer = BigInteger.ONE, denom = BigInteger.TWO;
		int counter = 0;
		
		for(int i=0; i< howManyIterations - 1; i++) { // we do - 1 because we already setup the first one above (1 / 2)
			
			numer = numer.add(denom.multiply(BigInteger.TWO)); // 5
			//then reciprocal
			BigInteger t = numer;
			numer = denom;
			denom = t;
			System.out.println("numer: " + numer + " denom: " + denom);
			// we calculate the final numerator and denominator here just to see if numer has more digits than denom
			// but only temp vars, we discard them as we continue the next loop, since we dont really need them until the very end
			int tempNumerDigitCount = numer.add(denom).toString().length();
			int tempDenomDigitCount = denom.toString().length();
			
			if(tempNumerDigitCount > tempDenomDigitCount) {
				counter++;
			}
		}

		// this will finish the calculation to actually get the final numerator and denominator to show:
		//after the loop - must add 1 at the end
		numer = numer.add(denom);
		System.out.println("Finally:\nNumer :" + numer + " \ndenom: " + denom);
		System.out.println("Finally count of numerators having more digits than denominators : " + counter);
		return counter;
	}
	
	
	public void longDivSqrRt(int num) {
		
		int sqrtCounter = 2;
		int sqrtNext = 3;
		int sqrt = 1;
		
		for(int i=2; i<30; i++) {
			sqrtCounter++;
			
			//System.out.println("i = " + i + ", sqrtCounter = " + sqrtCounter + ", sqrtNext = " + sqrtNext + ", sqrt = " + 1);
			System.out.println("Nearest sqrt less than or equal " + i + " is " + sqrt);
			
			
			if(sqrtCounter > sqrtNext) { // here is where we calculate the next square root
				//System.out.println("sqrtCount is OVER... " + sqrtCounter + " > " + (sqrtNext-2));
				sqrtNext += 2;
				sqrtCounter = sqrtNext-sqrtCounter;
				sqrt++;
			}  	
			
		}
		//so num is 10
		/*
		 first we find the nearest perfect square and squareroot without going over 10, in this case that is 9
		 first num to the left is therefor 3, sqrt of 9
		 
		 
		 */
		
		//how to find the closest sqrt to 10
		
		
	}
	

	public static List<Integer> getPrimesUnder1(int max) {
		// this method does not have to calculate the square root of the number to find the limit
		// we use some pattern I noticed to know what the square root is
		// a little faster because we dont have to do Math.sqrt(num)
		int n = 1;
		List<Integer> primes = new ArrayList<Integer>();
		
		int sqrtCounter = 1;
		int sqrtNext = 3;
		int sqrt = 1;
		
		primes.add(2);
		
		while ((n+=2) < max) {
			
			sqrtCounter+=2;
			
			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				if(prime > sqrt) {
					primes.add(n);
					break;
				}
				
				if (n % prime == 0)
					break;
				
			} //1, 4, 9, 16, 25
			
			if(sqrtCounter > sqrtNext-2) { // here is where we calculate the next square root
				sqrtNext += 2;
				sqrtCounter = sqrtNext-sqrtCounter;
				sqrt++;
			}  	
				
		}
		
		return primes;
		
	}
	
	public static List<Integer> getPrimesUnder2(int max) {
		// this method does not have to calculate the square root of the number to find the limit
		// we use some pattern I noticed to know what the square root is
		// a little faster because we dont have to do Math.sqrt(num)
		int n = 1;
		List<Integer> primes = new ArrayList<Integer>();
		
		int sqrtCounter = 1;
		int sqrtNext = 2;
		int sqrt = 1;
		primes.add(2);
		
		while ((n+=2) < max) {
			
			sqrtCounter+=2;
			
			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				if(prime > sqrt) {
					primes.add(n);
					break;
				}
				if (n % prime == 0)
					break;
			}
			
			if(sqrtCounter > sqrtNext) { // here is where we calculate the next square root
				sqrtNext += 2;
				sqrtCounter = sqrtNext-sqrtCounter;
				sqrt++;
			}  	
		}
		
		return primes;
	}
	
	public int closestSquareToN(int n) {
		return 0;
	}

	/*
	 sqrt closest to num - its going in odd numbers
	 1 = 1
	 2 = 1
	 3 = 1
	 4 = 2
	 5 = 2
	 6 = 2
	 7 = 2
	 8 = 2
	 9 = 3
	 10 = 3
	 11 = 3
	 12 = 3
	 13 = 3
	 14 = 3
	 15 = 3
	 16 = 4
	 17 = 4
	 18
	 19
	 20
	 21
	 22
	 23
	 24
	 25 = 5
	 */
}
