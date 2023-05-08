import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		//System.out.println("facts : " + );
		
		//System.out.println("sqr : " + Util.getPerfectSquaresUnderOrEqualTo(howManyNums));
		//Scanner scanner = new Scanner(System.in);
		//String myString = scanner.next();
		//int howManyNums = scanner.nextInt();
		//System.out.println("myint: " + howManyNums);
		//int howManyDecimals = scanner.nextInt();
		//System.out.println("myint: " + howManyDecimals);
		
		//scanner.close();
		//return longDivisionSquareRoot(howManyNums, howManyDecimals);
		longDivisionSquareRoot(howManyNums, howManyDecimals);
		test();
		return 0;
	}
	
	public static void test() {
		String r2 = "2449489742783178098197284074705891391965947480656670128432692567250960377457315026539859433104640234";
		String r3 = "3316624790355399849114932736670686683927088545589353597058682146116484642609043846708843399128290650";
		String r6 = "8774964387392122060406388307416309560875876827554503590927695629782764646219306281675693157068705755";
		System.out.println("digit count: " + r2.length() + " " + r3.length() + " " + r6.length());
		
		int r2s = addFirstThisManyDigitsInString(r2, 100);
		int r3s = addFirstThisManyDigitsInString(r3, 100);
		int r6s = addFirstThisManyDigitsInString(r6, 100);
		System.out.println("sum2: " + r2s + ", sum3: " + r3s + ", sum6: " + r6s);
		
		
		
		BigInteger b2 = new BigInteger(r2);
		BigInteger b3 = new BigInteger(r3);
		BigInteger b6 = new BigInteger(r6);
		
		BigInteger b23 = b2.multiply(b3);
		BigInteger b23Abb = new BigInteger(b23.toString().substring(0,100));
		System.out.println("b2 * b3: " + b23);
		System.out.println("b23Abb: " + b23Abb);
		System.out.println("b6: " + b6);
		
		
		List<Integer> p = Util.getPrimeFactors(72);
		for(Integer ps : p) {
			System.out.println("factors: " + ps);
		}
		
	}

	

	
	public int longDivisionSquareRoot(int howManyToCalculate, int numDecimals) {
		int total = 0;
		List<Integer> squares = getPerfectSquaresUnderOrEqualTo(howManyToCalculate);
		List<Integer> primes = Util.getPrimesUnder(howManyToCalculate);
		int numCounter = 0;
		//numDecimals--; //since all nums will have at least 1 whole num, dont need to go past 99 ever
		int decCount = 0;
		Map<Integer, String> roots = new HashMap<Integer, String>();
		BigInteger i=new BigInteger("1");
		BigInteger hundred = new BigInteger("" + 100);
		BigInteger dif;
		BigInteger next;
		BigInteger left;
		//BigInteger timesHundred;
		BigInteger smaller;
		BigInteger sqrt;
		BigInteger firstDigits;
		BigInteger m = BigInteger.ZERO;
		int numDecimalsExtra = numDecimals + 3;
		while(numCounter++ < howManyToCalculate) {
			System.out.println("Doing " + i);
			 if(squares.contains(i.intValue())) {
				i = i.add(BigInteger.ONE);
				continue;
			} 
			 else if(!primes.contains(i.intValue())) {
				List<Integer> factors = Util.getPrimeFactors(i.intValue());
				BigInteger tot = BigInteger.ONE;
				for(Integer fact : factors) {
					BigInteger primeRoot = new BigInteger(roots.get(fact));
					System.out.println("Got this root saved for " + fact + " : " + primeRoot.toString());
					tot = tot.multiply(primeRoot);
					
					
					
					//get the decimals of the known prime, then multiple them all together
					//cause sqrt of 15 is just the sqrt of 3 * sqrt of 5
					//so since we already did 3 and 5, go get those 100 digits, multiply together
					//and that is the answer to sqrt of 15. You do have to calc sqrt of 3 and 5 to a few
					//more digits than just 100 though, because when we multiply it may need extra digits 		
										// for accuracy I think? not exactly sure how many, gotta think a little hmm....
					
				}
				System.out.println("we now found this root for " + i  + " : " + tot);
				total += addFirstThisManyDigitsInString(tot.toString(), numDecimals);
				roots.put(i.intValue(), tot.toString()); // YOU CAN PROBABLY REMOVE ME LATER AFTER SOME TESTING :)
				i = i.add(BigInteger.ONE);
				continue;
			} 
			
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
			
			// if you want to actually see the digits:
			
			//System.out.println("Done with i=" + i + " ::: " + decs + ", sumDigits=" + thisTotal + " decslength: " + decs.length());
			roots.put(i.intValue(),decs);
			total += addFirstThisManyDigitsInString(decs, numDecimals);
			i = i.add(BigInteger.ONE);
			
		}
		
		System.out.println("done calculating all square roots... ");
		for(Integer d : roots.keySet()) {
			System.out.println("root " + d + " =\t" + roots.get(d) + " sum: " + addFirstThisManyDigitsInString(roots.get(d), 100));
		}
		
		System.out.println("total: " + total);
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
