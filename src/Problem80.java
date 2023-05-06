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
		int num = 10;
		longDivSqrRt(num);
		//calcSquareRootOfTwoCheckIfNumerMoreDigitsThanDenom(9);
		
		//Util.compare2PrimeFunctionsResults(2000000);
		//Util.compare2PrimeFunctionsTimings();
		closestSquareUnderOrEqualN(25);
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
		for(int i=1; i<n; i++) {
			squares.add(i*i);
		}
		return squares;
	}
	
	public void longDivSqrRt(int num) {
		
		//int sqrtCounter = 2;
		//int sqrtNext = 3;
		//int sqrt = 1;
		List<Integer> squares = getPerfectSquaresUnder(num);
		int numDecimals = 10;
		int decCount = 0;
		
		for(int i=12345; i<12346; i++) {
			//sqrtCounter++;
			if(squares.contains(i)) {
				System.out.println(i + " is  a perfect square");
				continue;
			}
			//System.out.println("i = " + i + ", sqrtCounter = " + sqrtCounter + ", sqrtNext = " + sqrtNext + ", sqrt = " + 1);
			
			
			int sqrt = closestSquareUnderOrEqualN(i);
			int digitCount = (int)(Math.log10(i)+1); // should be 5 for the number 12,345
			int realDigitCount = digitCount;
			int firstDigits = i;
			if(digitCount%2 == 0) {//if even num of digits, we go with the first 2 
				//firstDigits = (int) (i / (Math.pow(10, digitCount-2)));
				//digitCount -= 2;
			} else { //if odd num digits we go with the first 1 digit
				//firstDigits = (int) (i / (Math.pow(10, digitCount-1)));
				//digitCount--;
				digitCount++;
			}
			System.out.println("before First digit: " + firstDigits + " ::: " +(Math.pow(10, digitCount-2)));
			int next = i;
			while(digitCount > 0) {
				firstDigits = next / (int) (Math.pow(10, digitCount-2));
				System.out.println("loop First digit: " + firstDigits + " digitc now=" + digitCount);
				System.out.println("next was : " + next);
				next = next - (firstDigits * (int) (Math.pow(10, digitCount-2)));
				System.out.println("next is now : " + next);
				digitCount-=2;
				
			}
			
			System.out.println("First digit: " + firstDigits);
			System.out.println("Nearest sqrt less than or equal " + i + " is " + sqrt);
			
			
			//so we got the 1, now we want the 23
			//int next2Digits = i - (firstDigits * (int)Math.pow(10, digitCount));
			//System.out.println("1Next 2 digit: " + next2Digits);
			//if(digitCount%2 == 0) {//if even num of digits, we go with the first 2 
			//next2Digits =  next2Digits - (int) (next2Digits / (Math.pow(10, digitCount-2)));
				//digitCount -= 2;
				/*} else { //if odd num digits we go with the first 1 digit
				firstDigits = (int) (i / (Math.pow(10, digitCount-1)));
				digitCount--;
			}*/
			//System.out.println("2Next 2 digit: " + next2Digits);
			
			
			
			
			getFirstD(i);
			
			String decs = sqrt + "";
			int sqrd = sqrt*sqrt; //for this example we are doing 10. so this sqrd = 3*3 = 9
			int dif = i - sqrd; // dif then is 10 - 9 = 1
			int left = sqrt + sqrt; //db is to double the 3, so 3 + 3 = 6
			
			//we need to do the whole number first. like if its 12345, need to do 1, then 23 then 45...
			//how do we get the 1st digit if its an odd number of digits, and the first 2 if its even num of digits.
			
			//we could do like a log(10) to get num of digits, then if even we get the first, else get the first 2
			// or we could loop and divide by 100 getting the last 2 digits of the number, put those in some list and go through the list backwards...
			//ill just try the log way first
			
			
			
			while(decCount < numDecimals) {
				//then we bring 2 more digits down. since we know 10 is already 2 digits and 
				//we are at the end of the whole number, we start bringing decimal zeros
			
				//we need to update above to do the whole number 2 digits at a time. 
					//like 12345 we would do the 1 first, then 23, then 45..then start doing decimal zeros 2 at a time
				System.out.println("i=" + i + ", sqrt=" + sqrt + ", sqrd=" + sqrd + ", dif=" + dif + ", left=" + left);
				int timesHundred = dif * 100; //add 2 zeros = 1 * 100 = 100
				//so now we need to do 60 * 0 , or 61*1 or 62*2 or 63*3 etc. until we get as close to 100 without going over.
				//int mult = left * 10; //we move the 6 over 1 place, so its 60. then we can start the 60*0 or 61*1 etc..
				
				left *= 10;//we move the 6 over 1 place, so its 60. then we can start the 60*0 or 61*1 etc..
				
				int multAdd = 10;
				int smaller = timesHundred + 1; //just make it bigger to go into this loop
				while(smaller > timesHundred) {
					//for this what if we go backwards like from 9 down to 0 so we dont have to do -1 after this loop since we would go over in this loop
					multAdd--;
					smaller = (left + multAdd) * multAdd;
					System.out.println("Multadd for " + i + " is now smaller=" + smaller + ", left + multAdd=" + (left + multAdd) + ", multadd=" + multAdd + "   > " + timesHundred);
					
				}
				System.out.println("Ended with Multadd for " + i + " is now smaller=" + smaller + ", multadd=" + multAdd + ", left=" + left);
				decs += multAdd;
				System.out.println("decs increased to " + decs);
				dif = timesHundred - smaller; //should be 100 - 61
				left +=  multAdd + multAdd; //this is the 61 + 1 (whatever that last digit ended up being, we double it. So if its 67, then add 7 = 74. this one was 1, so 61+1
			
				if(decs.length() > 10)break;
			
			}
			
			
			System.out.println("DECS : " + decs);
			
			
			
			/*dif = timesHundred - left; //should be 100 - 61
			left += multAdd; //this is the 61 + 1 (whatever that last digit ended up being, we double it. So if its 67, then add 7 = 74. this one was 1, so 61+1
			System.out.println("Added " + multAdd + " to m, m is now = " + left + ", and new dif = " + dif);
			
			
			//do it all over again.
			timesHundred = dif * 100;
			//db = m;
			System.out.println("timesHundred again:  " + timesHundred  + " with m = " + left);
			
			mult = left * 10;
			multAdd = 9;
			left = timesHundred + 1; //just make it bigger to go into this loop
			while(left > timesHundred) {
				//for this what if we go backwards like from 9 down to 0 so we dont have to do -1 after this loop since we would go over in this loop
				multAdd--;
				left = (mult + multAdd) * multAdd;
				System.out.println("Multadd for " + i + " is now m=" + left + ", mult=" + mult + ", multadd=" + multAdd);
				
			}
			System.out.println("Ended with Multadd for " + i + " is now m=" + left + ", mult=" + mult + ", multadd=" + multAdd);
			*/
			
			
			
			
			
			
			
			/*
			int multAdd = 0;
			int m = mult;
			while(m < timesHundred) {
				//for this what if we go backwards like from 9 down to 0 so we dont have to do -1 after this loop since we would go over in this loop
				multAdd++;
				m = (mult + multAdd) * multAdd;
				System.out.println("Multadd for " + i + " is now m=" + m + ", mult=" + mult + ", multadd=" + multAdd);
				
			}
			
			System.out.println("Ended with Multadd for " + i + " is now m=" + m + ", mult=" + mult + ", multadd=" + multAdd);
			m /= multAdd;
			m--;
			System.out.println("Fixed m -- Ended with Multadd for " + i + " is now m=" + m + ", mult=" + mult + ", multadd=" + multAdd);
			*/
			
			/*if(sqrtCounter > sqrtNext) { // here is where we calculate the next square root
				//System.out.println("sqrtCount is OVER... " + sqrtCounter + " > " + (sqrtNext-2));
				sqrtNext += 2;
				sqrtCounter = sqrtNext-sqrtCounter;
				sqrt++;
			}  	*/
			
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
