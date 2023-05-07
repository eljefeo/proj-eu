import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Fidelity;

public class Problem80 implements Problem{// Took 0.030950 seconds

	
	/*
	 It is well known that if the square root of a natural number is not an integer, then it is irrational. The decimal expansion of such square roots is infinite without any repeating pattern at all.

The square root of two is 1.41421356237309504880..., and the digital sum of the first one hundred decimal digits is 475.

For the first one hundred natural numbers, find the total of the digital sums of the first one hundred decimal digits for all the irrational square roots.Given that the three characters are always asked for in order, analyse the file so as to determine the shortest possible secret passcode of unknown length.
	 */
	
	public static void main(String[] args) { //Took 0.036950 seconds
		Problem p = new Problem80();
		p.runProblem();
	}

	
	static int t1 = 0;
	static int t2 = 0;
	@Override
	public Object problem() {
		int howManyNums = 100;
		int howManyDecimals = 100;
		System.out.println("sqr : " + Util.getPerfectSquaresUnderOrEqualTo(howManyNums));
		return longDivisionSquareRoot(howManyNums, howManyDecimals);
	}


	

	
	public int longDivisionSquareRoot(int howManyToCalculate, int numDecimals) {
		int total = 0;
		List<Integer> squares = Util.getPerfectSquaresUnderOrEqualTo(howManyToCalculate);
		int numCounter = 0;
		numDecimals--; //since all nums will have at least 1 whole num, dont need to go past 99 ever
		int decCount = 0;
		BigInteger i=new BigInteger("1");
		BigInteger hundred = new BigInteger("" + 100);
		while(numCounter < howManyToCalculate) {
			numCounter++;
			if(squares.contains(i.intValue())) {
				i = i.add(BigInteger.ONE);
				continue;
			}
			
			int digitCount = i.toString().length();
			BigInteger firstDigits = BigInteger.ZERO;
			if(digitCount%2 != 0) {//if even num of digits, we go with the first 2 
				digitCount++;
			} 
			firstDigits = i.divide(BigInteger.TEN.pow(digitCount-2));
			BigInteger sqrt = Util.closestSquareUnderOrEqualN(firstDigits);
			//String decs = sqrt + ""; // if you want to actually see the digits:
			total+= sqrt.intValue();
			BigInteger dif = firstDigits.subtract(sqrt.multiply(sqrt)) ; 
			BigInteger next = new BigInteger("" + i);
			BigInteger left = sqrt.add(sqrt);
			digitCount-=2;
			while(decCount++ < numDecimals) {
				if(digitCount > 0) {
					next = next.subtract((firstDigits.multiply(BigInteger.TEN.pow(digitCount))));
					firstDigits = next.divide(BigInteger.TEN.pow(digitCount-2));
				} else {
					firstDigits = BigInteger.ZERO;
				}
				
				BigInteger timesHundred = dif.multiply(hundred).add(firstDigits);
				left = left.multiply(BigInteger.TEN);
				int multAdd = 10;
				BigInteger smaller = timesHundred;
				
				while(smaller.compareTo(timesHundred) >= 0) {
					multAdd--;
					BigInteger m = new BigInteger(""+multAdd);
					smaller = left.add(m).multiply(m);
				}
				
				//decs += multAdd; // if you want to actually see the digits
				total+= multAdd;
				dif = timesHundred.subtract(smaller);
				left = left.add(new BigInteger("" + multAdd)).add(new BigInteger(""+multAdd));
				digitCount-=2;
			}
			
			decCount = 0;
			
			// if you want to actually see the digits:
			//int thisTotal = 0;
			//for(int j = 0; j < decs.length(); j++) {
			//	thisTotal+=Integer.parseInt(decs.charAt(j) + "");
			//}
			//System.out.println("Done with i=" + i + " ::: " + decs + ", sumDigits=" + thisTotal + " decslength: " + decs.length());
			//total+=thisTotal;
			i = i.add(BigInteger.ONE);
			
		}
		
		System.out.println("total final: " + total);
		return total;
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
