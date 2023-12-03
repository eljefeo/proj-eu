package ProjEuProblems;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ProjEuUtil.Util;

public class Problem80 implements Problem{// Took 0.018977 seconds

	
	/*
	 It is well known that if the square root of a natural number is not an integer, then it is irrational. 
	 The decimal expansion of such square roots is infinite without any repeating pattern at all.

The square root of two is 1.41421356237309504880..., and the digital sum of the first one hundred decimal digits is 475.

For the first one hundred natural numbers, find the total of the digital sums of the first 
one hundred decimal digits for all the irrational square roots. 

*/
	
	public static void main(String[] args) { //Took 0.018638 seconds
		Problem p = new Problem80();
		p.runProblem();
	}

	@Override
	public Object problem() {
		int howManyNums = 100;
		int howManyDecimals = 100;
		//System.out.println("facts : " + );
		
		//System.out.println("sqr : " + Util.getPerfectSquaresUnderOrEqualTo(howManyNums));
		//Scanner scanner = new Scanner(System.in);
		//int howManyNums = scanner.nextInt();
		//System.out.println("myint: " + howManyNums);
		//int howManyDecimals = scanner.nextInt();
		//System.out.println("myint: " + howManyDecimals);
		
		//scanner.close();
		
		
		//for(int i = 1; i < 1001; i++) {
		//	for(int j = 1; j < 1001; j++) {
		//		System.out.println("Going to call: " + i + " " + j);
		//		longDivisionSquareRoot(i, j);
		//	}
		//}
		
		return longDivisionSquareRoot(howManyNums, howManyDecimals);
		
		//return longDivisionSquareRoot(howManyNums, howManyDecimals);
	}
	
	
	

	
	public int longDivisionSquareRoot(int howManyToCalculate, int numDecimals) {
		int total = 0;
		int accuracyBuffer = 3;
		List<Integer> squares = getPerfectSquaresUnderOrEqualTo(howManyToCalculate);
		List<Integer> primes = Util.getPrimesUnderOrEqual(howManyToCalculate);
		int numCounter = 0;
		//numDecimals--; //since all nums will have at least 1 whole num, dont need to go past 99 ever
		int decCount = 0;
		Map<Integer, String> roots = new HashMap<Integer, String>();
		BigInteger i = new BigInteger("1");
		BigInteger hundred = new BigInteger("" + 100);
		BigInteger dif;
		BigInteger next;
		BigInteger left;
		//BigInteger timesHundred;
		BigInteger smaller;
		BigInteger sqrt;
		BigInteger firstDigits;
		BigInteger m = BigInteger.ZERO;
		int numDecimalsExtra = numDecimals + accuracyBuffer; // since we are going to multiply the roots of the primes together to get the roots of the composites, we need extra digits for accuracy
		while(numCounter++ < howManyToCalculate) {
			//System.out.println("Doing " + i);
			 if(squares.contains(i.intValue())) {
				i = i.add(BigInteger.ONE);
				continue;
			} 
			 else if(!primes.contains(i.intValue())) { // if this is a composite number, we just multiply together the roots of the factors of this num
				List<Integer> factors = Util.getPrimeFactors(i.intValue());
				BigInteger tot = BigInteger.ONE;
				for(Integer fact : factors) {
					BigInteger dd = new BigInteger(roots.get(fact));
					tot = tot.multiply(dd);
				}
				total += addFirstThisManyDigitsInString(tot.toString(), numDecimals);
				i = i.add(BigInteger.ONE);
				continue;
			} 
			
			 //else if we get to this part then we know we are dealing with a prime number. We do need to calculate that square root of this num then..
			 
			int digitCount = i.toString().length();
			if(digitCount%2 != 0) {//if even num of digits, we go with the first 2 
				digitCount++;
			} 
			firstDigits = i.divide(BigInteger.TEN.pow(digitCount-2));
			sqrt = closestSquareUnderOrEqualN(firstDigits);
			String decs = sqrt + ""; // if you want to actually see the digits:
			//total += sqrt.intValue();// if you just want to count
			dif = firstDigits.subtract(sqrt.multiply(sqrt)) ; 
			left = sqrt.add(sqrt);
			digitCount-=2;
			while(decCount++ < numDecimalsExtra) {
				if(digitCount > 0) {
					next = i.subtract(firstDigits.multiply(BigInteger.TEN.pow(digitCount)));
					dif = dif.multiply(hundred).add(next.divide(BigInteger.TEN.pow(digitCount-2)));
					digitCount-=2;
				} else {
					dif = dif.multiply(hundred);
				}
				
				left = left.multiply(BigInteger.TEN);
				int multAdd = 10;
				smaller = dif;
				
				while(smaller.compareTo(dif) >= 0) {
					multAdd--;
					m = new BigInteger(""+multAdd);
					smaller = left.add(m).multiply(m);
				}
				
				decs += multAdd; // if you want to actually see the digits
				//total+= multAdd; // if you just want to count
				dif = dif.subtract(smaller);
				left = left.add(m).add(m);
			}
			
			decCount = 0;
			roots.put(i.intValue(),decs);
			//System.out.println("Square root of " + i + ": " + decs);
			total += addFirstThisManyDigitsInString(decs, numDecimals); //only add the first hundred, we calculated extra for accuracy during mulo
			i = i.add(BigInteger.ONE);
		}
		
		//System.out.println("done calculating all square roots... ");
		//for(Integer d : roots.keySet()) {
		//	System.out.println("root " + d + " =\t" + roots.get(d) + " sum: " + addFirstThisManyDigitsInString(roots.get(d), 100));
		//}
		
		//System.out.println("total: " + total);
		return total;
	}
	
	public static int addAllDigitsInString(String s) {
		int thisTotal = 0;
		for(int j = 0; j < s.length(); j++) {
			thisTotal+=Integer.parseInt(s.charAt(j) + "");
		}
		return thisTotal;
	}
	
	public static int addFirstThisManyDigitsInString(String s, int howMany) {
		int thisTotal = 0;
		if(s.length() < howMany) {
			System.out.println("cannot sum these digits, string doesnt have enough characters " + s.length() + " howmany:" + howMany);
			return 0;
		} 
			
		for(int j = 0; j < howMany; j++) {
			thisTotal+=Integer.parseInt(s.charAt(j) + "");
		}
		return thisTotal;
	}
	public static BigInteger closestSquareUnderOrEqualN(BigInteger n) {
		BigInteger i = BigInteger.ZERO, t = BigInteger.ZERO;
		while(n.compareTo(i.multiply(i)) >= 0) {
			t = i;
			i = i.add(BigInteger.ONE);
		}
		return t;
	}

	public static List<Integer> getPerfectSquaresUnderOrEqualTo(int n){
		List<Integer> squares = new ArrayList<Integer>();
		int i = 0, t = 0;
		while(n >= (i*i)) {
			t = i;
			i++;
			squares.add(t*t);
		}
		return squares;
	}
	
public void longDivisionSquareRootInt(int num) {

		List<Integer> squares = Util.getPerfectSquaresUnderOrEqualTo(num);
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
			
			int sqrt = Util.closestSquareUnderOrEqualN(firstDigits);
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
	
	


}
