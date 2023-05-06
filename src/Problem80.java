import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Fidelity;

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
		int num = 101;
		//BigInteger test = new BigInteger("" + 77);
		//closestSquareUnderOrEqualN(test);
		
		
		
		longDivSqrRt(num);
		//calcSquareRootOfTwoCheckIfNumerMoreDigitsThanDenom(9);
		
		//Util.compare2PrimeFunctionsResults(2000000);
		//Util.compare2PrimeFunctionsTimings();
		
		return 0;
	}
	
	
	public void longDivSqrrtt(int num) {
		/*
		 10
		 */
		
	}
	
	
	public void getFirstD(int num) {
		System.exit(1);
	}
	
	public List<Integer> getPerfectSquaresUnder(int n){
		List<Integer> squares = new ArrayList<Integer>();
		int ii = 0, temp = 0;
		for(int i=1; ii<n; i++) {
			temp = ii;
			ii = i*i;
			squares.add(temp);
		}
		
		return squares;
	}
	
	public boolean isPerfectSquare(int n) {
		
		//double
		return false;
	}
	
	public void longDivSqrRt(int num) {
		long total = 0;
		//int sqrtCounter = 2;
		//int sqrtNext = 3;
		//int sqrt = 1;
		List<Integer> squares = getPerfectSquaresUnder(num);
		System.out.println("got perfect squares under: " + num);
		int numCounter = 0;
		int numDecimals = 100-1;
		int howManyToCalculate = 100;
		int decCount = 0;
		BigInteger i=new BigInteger("1");
		//for(BigInteger i=new BigInteger("1"); i.compareTo(new BigInteger("100")) < 0; i = i.add(BigInteger.ONE)) {
		while(numCounter < howManyToCalculate) {
			System.out.println("starting i = " + i);
			//sqrtCounter++;
			numCounter++;
			if(squares.contains(i.intValue())) {
				System.out.println(i + " is  a perfect square");
				i = i.add(BigInteger.ONE);
				continue;
			}
			
			//int digitCount = (int)(Math.log10(i)+1); // should be 5 for the number 12,345
			int digitCount = i.toString().length();
			//System.out.println("digitCount = " + digitCount);
			BigInteger firstDigits = BigInteger.ZERO;
			if(digitCount%2 != 0) {//if even num of digits, we go with the first 2 
				digitCount++;
			} 
			//firstDigits = i / (int) (Math.pow(10, digitCount-2));
			//			System.out.println("First digit")
			firstDigits = i.divide(BigInteger.TEN.pow(digitCount-2));
			//System.out.println("firstDigits = " + firstDigits);
			BigInteger sqrt = closestSquareUnderOrEqualN(firstDigits);
			String decs = sqrt + "";
			
			BigInteger sqrd = new BigInteger("" + (sqrt.multiply(sqrt))); //for this example we are doing 10. so this sqrd = 3*3 = 9
			BigInteger dif = firstDigits.subtract(sqrd) ;// new BigInteger("" + (firstDigits - sqrd)); 
			BigInteger next = new BigInteger("" + i);
			BigInteger left = sqrt.add(sqrt);
			System.out.println("firstDigits = " + firstDigits + ", decs: " + decs + ", dif=" + dif  + ", decCount: " + decCount + ", numDecimals: " + numDecimals);
			digitCount-=2;
			while(decCount < numDecimals) {
				decCount++;
				if(digitCount > 0) {
					next = next.subtract((firstDigits.multiply(BigInteger.TEN.pow(digitCount))));
					firstDigits = next.divide(BigInteger.TEN.pow(digitCount-2));
					System.out.println("digitCount > 0, next: " + next + ", firstDigits: " + firstDigits);
					System.out.println("i digitcount, firstDigit=" + firstDigits + ", next=" + next);
				} else {
					firstDigits = BigInteger.ZERO;
					//System.out.println("decCount increased to " + decCount);
					
				}
				
				BigInteger timesHundred = dif.multiply(new BigInteger(""+100)).add(firstDigits);
				
				//System.out.println("Next First digit: " + firstDigits + ", next=" + next  + ", timesHundred=" + timesHundred + ", digitc now=" + digitCount + ", left: " +left);
				left = left.multiply(BigInteger.TEN);
				//System.out.println("beforebeginloop left:" + left);
				int multAdd = 10;
				BigInteger smaller = timesHundred.add(BigInteger.ONE); //just make it bigger to go into this loop
				
				while(smaller.compareTo(timesHundred) > 0) {
					multAdd--;
					smaller = left.add(new BigInteger(""+multAdd)).multiply(new BigInteger(""+multAdd));
					//System.out.println("Multadd for " + firstDigits + " is now smaller=" + smaller + ", left=" + left + ", left + multAdd=" + (left.add(new BigInteger(multAdd+""))) + ", multadd=" + multAdd + "   > " + timesHundred);
				}
				//System.out.println("Ended with Multadd for " + i + " is now smaller=" + smaller + ", multadd=" + multAdd + ", left=" + left);
				
				decs += multAdd;
				//System.out.println("decs increased to " + decs);
				dif = timesHundred.subtract(smaller);
				left = left.add(new BigInteger("" + multAdd)).add(new BigInteger(""+multAdd));
				//System.out.println("i=" + i + ", sqrt=" + sqrt + ", sqrd=" + sqrd + ", dif=" + dif + ", left=" + left);
				//System.out.println("next is now : " + next);
				digitCount-=2;
			}
			
			decCount = 0;
			System.out.println("Done with i=" + i + " ::: " + decs + " decslength: " + decs.length());
			//decs = decs.substring(decs.length() - numDecimals, decs.length() );
			int remove = 0;
			for(int j = 0; j < decs.length(); j++) {
				total+=Integer.parseInt(decs.charAt(j) + "");
				remove+=Integer.parseInt(decs.charAt(j) + "");
				
			}
			System.out.println("decs final for " + i + " with length " + decs.length() + " (" + remove + ") with runningTotal=" + total + " : " + decs);
			i = i.add(BigInteger.ONE);
			for(int u = 0; u < decs.length(); u++) {
				System.out.print("," + decs.charAt(u));
			}
			System.out.println();
		}
		System.out.println("Skipped " + squares.size() + " perfect squares");
		for(Integer j : squares) {
			System.out.println("square: " + j);
		}
		System.out.println("total final: " + total);
		
	}
	
public void longDivSqrRt2(int num) {
		
		//int sqrtCounter = 2;
		//int sqrtNext = 3;
		//int sqrt = 1;
		List<Integer> squares = getPerfectSquaresUnder(num);
		int numDecimals = 5;
		int decCount = 0;
		
		for(int i=12345; i<12346; i++) {
			//sqrtCounter++;
			if(squares.contains(i)) {
				System.out.println(i + " is  a perfect square");
				continue;
			}
			
			
			
			int digitCount = (int)(Math.log10(i)+1); // should be 5 for the number 12,345
			int firstDigits = 0;
			if(digitCount%2 != 0) {//if even num of digits, we go with the first 2 
				digitCount++;
			} 
			firstDigits = i / (int) (Math.pow(10, digitCount-2));
			
			int sqrt = closestSquareUnderOrEqualN(firstDigits);
			String decs = sqrt + "";
			
			int sqrd = sqrt*sqrt; //for this example we are doing 10. so this sqrd = 3*3 = 9
			int dif = firstDigits - sqrd; 
			int next = i;
			int left = sqrt + sqrt;
			digitCount-=2;
			while(decCount < numDecimals) {
				
				if(digitCount > 0) {
					next = next - (firstDigits * (int) (Math.pow(10, digitCount)));
					firstDigits = next / (int) (Math.pow(10, digitCount-2));
				} else {
					firstDigits = 0;
					decCount++;
				}
				
				int timesHundred = dif * 100 + firstDigits; //bring down the next 2 digits 
				
				System.out.println("Next First digit: " + firstDigits + ", next=" + next  + ", timesHundred=" + timesHundred + ", digitc now=" + digitCount);
				left *= 10;
				int multAdd = 10;
				int smaller = timesHundred + 1; //just make it bigger to go into this loop
				while(smaller > timesHundred) {
					multAdd--;
					smaller = (left + multAdd) * multAdd;
					System.out.println("Multadd for " + firstDigits + " is now smaller=" + smaller + ", left + multAdd=" + (left + multAdd) + ", multadd=" + multAdd + "   > " + timesHundred);
				}
				System.out.println("Ended with Multadd for " + i + " is now smaller=" + smaller + ", multadd=" + multAdd + ", left=" + left);
				
				decs += multAdd;
				System.out.println("decs increased to " + decs);
				dif = timesHundred - smaller; //should be 100 - 61
				left +=  multAdd + multAdd;
				System.out.println("i=" + i + ", sqrt=" + sqrt + ", sqrd=" + sqrd + ", dif=" + dif + ", left=" + left);
				System.out.println("next is now : " + next);
				digitCount-=2;
			}
		}
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
	
	public int closestSquareUnderOrEqualN(int n) {
		//TODO change this to work for perfect squares
		int i = 0, t = 0;
		while(n >= (i*i)) {
			t = i;
			i++;
		}
		System.out.println("closest to " + n + "  t=" + t);
		return t;
	}
	
	public BigInteger closestSquareUnderOrEqualN(BigInteger n) {
		//TODO change this to work for perfect squares
		BigInteger i = BigInteger.ZERO, t = BigInteger.ZERO;
		System.out.println("Doing closest square to " + n);
		while(n.compareTo(i.multiply(i)) >= 0) {
			//System.out.println("loop closest square to...i*i=" + (i.multiply(i)) + ", n compare to: " + n.compareTo(i.multiply(i)));
			t = i;
			i = i.add(BigInteger.ONE);
		}
		System.out.println("closest to " + n + "  t=" + t);
		return t;
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
