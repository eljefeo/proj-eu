import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Util {
	public static boolean isPrime(int num) {

		if (num == 2) 
			return true;
		
		if (num < 0 || num == 1 || num % 2 == 0) 
			return false;
		
		for (long i = 3; i <= Math.sqrt(num); i += 2) 
			if (num % i == 0) 
				return false;
			
		return true;
	}
	
	public static boolean isPrime(long num) {

		if (num == 2) 
			return true;
		
		if (num < 0 || num == 1 || num % 2 == 0) 
			return false;
		
		for (long i = 3; i <= Math.sqrt(num); i += 2) 
			if (num % i == 0) 
				return false;
			
		return true;
	}
	
	public int lcm(int a, int b) { //assuming both nums are positive
		int h, l;
		if(a < b) {
			l = a;
			h = b;
		} else {
			h = a;
			l = b;
		}
		int i = 2, lcm = h;
		while(lcm % l != 0) 
			lcm = h * i++;
		
		
		return lcm;
	}
	
	
	public long lcm(long a, long b) { //assuming both nums are positive
		long h, l;
		if(a < b) {
			l = a;
			h = b;
		} else {
			h = a;
			l = b;
		}
		//int i = 2;
		long lcm = h;
		while(lcm % l != 0) 
			lcm += h;
		
		
		return lcm;
	}


	
	
	public static long[] lcmWithMult(long a, long b) { //assuming both nums are positive
		
		long h, l;
		if(a == b) 
			return new long[] { a, 1 };
		
		// we get the higher number
		// since we are looking for multiples that agree with both a and b
		// less iterations if we do multiples of the bigger num
		
		if(a < b) {
			l = a;
			h = b;
		} else {
			h = a;
			l = b;
		}
		int i = 2;
		long lcm = h;
		while(lcm % l != 0) {
			//System.out.println("lcm is " + lcm + " i="+ i + " h=" + h + " l=" + l);
			lcm = h * i++;
			//System.out.println("new lcm is " + lcm + " i="+ i + " h=" + h + " l=" + l);
		}
		
		// the second thing in the array is how much to multiple the HIGHER number to to get the lcm
		return new long[] { lcm, i-1 };
	}


	public static int getAPolygonalNumber(int which, int ind) {
		
		switch (which) {
		case 3:
			return Util.getNthTriangleNumber(ind);
			
		case 4:
			return Util.getNthSquareNumber(ind);
			
		case 5:
			return Util.getNthPentagonalNumber(ind);
			
		case 6:
			return Util.getNthHexagonalNumber(ind);
			
		case 7:
			return Util.getNthHeptagonalNumber(ind);
			
		case 8:
			return Util.getNthOctagonalNumber(ind);
			
		default:
			break;
		}
		
		return 0;
	}

	
	public static BigInteger getTriangleNumber(BigInteger n){
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		return (n.add(one).multiply(n)).divide(two);
	}
	
	public static long getIndexOfTriangleNumber(long t) {
		long s = (long) Math.sqrt(t * 2);
		if (getNthTriangleNumber(s) == t) {
			return s;
		}
		return -1;
	}

	public static boolean isTriangleNumber(long n) {
		return getIndexOfTriangleNumber(n) > 0;
	}

	public static void testTriangleNumbers() {

		int max = 1000000;
		for (long i = 1; i < max; i++) {
			long tri = getNthTriangleNumber(i);
			long ind = getIndexOfTriangleNumber(tri);
			if (i != ind) {
				System.out.println("This one doesnt work!! i:" + i + " hex:" + tri + " ind:" + ind);
				return;
			}
		}
		System.out.println("All passed triangle numbers from 1 to " + max + " (using longs)");
	}
	
	
	public static int getNthSquareNumber(int i) {
		return (int) Math.pow(i, 2);
	}
	
	public static int getNthPentagonalNumber(int i) {
		//n=n(3n-1)/2 1, 5, 12, 22, 35, 
		return  i * ((3*i) - 1) / 2;
	}
	
	public static int getNthHexagonalNumber(int i) {
		//n=n(2n-1) 1, 6, 15, 28, 45, ... 
		return ((2*i) - 1) * i;
	}
	
	public static int getNthHeptagonalNumber(int i) {
		//n=n(5n-3)/2 1, 7, 18, 34, 55, ...
		return i * ((5*i) - 3) / 2;
	}
	
	public static int getNthOctagonalNumber(int i) {
		//n=n(3n-2) 1, 8, 21, 40, 65, ...
		return ((3*i) - 2) * i;
	}

	
	public static List<Integer> getPrimeFactorsOrig(int num) {
        int n = num;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
	

	public static List<Integer> getPrimeFactors(int num) {
        int n = num;
        
        List<Integer> factors = new ArrayList<Integer>();
        
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
        	while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }

	public static Set<BigInteger> getFactorsBigInt(BigInteger num) {

		Set<BigInteger> factors = new HashSet<BigInteger>();
		BigInteger half = num.divide(BigInteger.valueOf(2));
		for (BigInteger i = new BigInteger("1"); i.compareTo(half) < 1; i = i.add(BigInteger.valueOf(1))) {
			if (num.mod(i).compareTo(BigInteger.valueOf(0)) == 0) {
				factors.add(i);
			}
		}
		factors.add(num);
		return factors;
	}

	public static Set<Long> getFactorsLong(Long num) {

		Set<Long> factors = new HashSet<Long>();
		factors.add((long) 1);
		Long half = num / 2;
		for (Long i = (long) 2; i <= half; i++) {
			if (num % i == 0) {
				factors.add(i);
			}
		}
		factors.add(num);
		return factors;
	}

	public static Set<Integer> getDistinctFactorsInt(int num) {

		Set<Integer> factors = new HashSet<Integer>();
		factors.add(1);
		int limit = num;
		for (int i = 2; i < limit; i++) {
			if (num % i == 0) {
				limit = num / i;
				factors.add(i);
				factors.add(limit);
			}
		}
		factors.add(num);
		return factors;
	}
	
	/* trying to think of shortcuts for factoring..
	public static Set<Integer> getDistinctFactorsIntN(int num) {

		Set<Integer> factors = new HashSet<Integer>();
		factors.add(1);
		
		
		while(num % 2 == 0) {
			num /= 2;
			factors.add(num);
		}
		
		int limit = (int) Math.sqrt(num);
		int i = 3;
		while(i <= limit) {
			while(num % i == 0) {
				num /= i;
				factors.add(num);
			}
			i += 2;
		}
		
		return factors;
	}
	*/
	
	public static long getLargestPrimeFactor(long goal){
		
		long largest = 0;
		if(goal % 2 == 0) {
			largest = 2;
			while(goal%2==0){
				goal /= 2;
			}
		}
		
		loop:
		for(long i = 3; i <= Math.sqrt(goal) ; i+=2){
			while(goal%i==0){
				goal /= i;
				largest = i;
				if(goal == 1) {
					break loop;
					// can just return here
					// return largest; ?
				}	
			}	
		}
		
		if(goal > 1){
			largest = goal;
		}
		
		return largest;
	}
	
	public static Set<Integer> getDistinctFactorsIntOldSlow(int num) {

		Set<Integer> factors = new HashSet<Integer>();
		factors.add(1);
		int half = num / 2;
		for (int i = 2; i <= half; i++) {
			if (num % i == 0) {
				factors.add(i);
			}
		}
		factors.add(num);
		return factors;
	}

	//TODO we can optimize this without isPrime...I think...
	public static Set<Integer> getDistinctPrimeFactors(int num) {

		Set<Integer> factors = new HashSet<Integer>();
		int limit = num;
		for (int i = 2; i < limit; i++) {
			if (num % i == 0 && isPrime(i)) {
				limit = num / i;
				factors.add(i);
			}
		}
		return factors;
	}
	
	public static Set<Integer> getDistinctPrimeFactorsOldSlow(int num) {

		Set<Integer> factors = new HashSet<Integer>();
		//factors.add(1);
		int half = num / 2;
		for (int i = 2; i <= half; i++) {
			if (num % i == 0 && isPrime(i)) {
				factors.add(i);
			}
		}
		//factors.add(num);
		return factors;
	}
	
	public static void getNextPrime2(List<Integer> primes, int n) {
		int pr = n;
		while(true) {
			pr++;
			boolean foundPrime = true;
			for(int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				if(pr % prime == 0) {
					foundPrime = false;
					break;
				}
			}
			if(foundPrime) {
				primes.add(pr);
				return;
			}
			
		}
		
	}
	
	public static int getNextPrime(List<Integer> primes, int n) {
		int pr = n;
		int sqrt = (int) (Math.sqrt(n)+1);
		while (true) {
			pr++;
			boolean foundPrime = true;
			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				if(prime > sqrt)
					break;
				
				if (pr % prime == 0) {
					foundPrime = false;
					break;
				}
			}
			if (foundPrime) 
				return pr;
			
		}

	}
	
	public static int stringToInt(String numStr) {
		return Integer.parseInt(numStr);
	}

	public static int findGreatestSumPath(int[][] allnums) {
		System.out.println("At line " + 1);
		allnums[1][0] += allnums[0][0];
		allnums[1][1] += allnums[0][0];
		for (int i = 2; i < allnums.length; i++) {
			System.out.println("At line " + (i + 1));
			for (int j = 0; j < allnums[i].length; j++) {
				if (j == 0) {
					allnums[i][j] += allnums[i - 1][j];
				} else if (j == allnums[i].length - 1) {
					allnums[i][j] += allnums[i - 1][allnums[i - 1].length - 1];
				} else {
					allnums[i][j] += allnums[i - 1][j - 1] > allnums[i - 1][j] ? allnums[i - 1][j - 1]
							: allnums[i - 1][j];
				}

			}
		}
		int greatestSum = 0;
		for (int i = 0; i < allnums[allnums.length - 1].length; i++) {
			if (allnums[allnums.length - 1][i] > greatestSum) {
				greatestSum = allnums[allnums.length - 1][i];
			}
		}

		return greatestSum;
	}

	public static int getNumOfDaysInMonth(int month, int year) {
		if (month == 9 || month == 4 || month == 6 || month == 11) {
			return 30;
		} else if (month == 2) {
			return isLeapYear(year) ? 29 : 28;
		} else {
			return 31;
		}
	}

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public static Set<Integer> getProperDivisors(int num) {

		Set<Integer> factors = new HashSet<Integer>();
		factors.add(1);
		int limit = num;
		for (int i = 2; i < limit; i++) {
			if (num % i == 0) {
				limit = num / i;
				factors.add(i);
				factors.add(limit);
			}
		}
		return factors;
	}
	
	public static Set<Integer> getProperDivisorsOld(int num) {

		Set<Integer> factors = new HashSet<Integer>();
		factors.add(1);
		int half = num / 2;
		for (int i = 2; i <= half; i++) {
			if (num % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}
	
	public static int summation(int num) {
		
		return summationFromTo(1, num);
	}
	
public static int summationFromTo(int start, int end) {
		
		int ret = 0;
		for (int i = start; i <= end; i++) {
			ret += i;
		}
		return ret;
	}

	public static int addAllIntegers(Set<Integer> nums) {
		int result = 0;
		for (Integer num : nums) {
			result += num;
		}
		return result;
	}

	public static int getAmicableNumer(int num) {
		// return 0 if no amicable number found
		int sum1 = Util.addAllIntegers(Util.getProperDivisors(num));
		int sum2 = Util.addAllIntegers(Util.getProperDivisors(sum1));
		if (num == sum2 && num != sum1) {
			return sum2;
		}

		return 0;

	}

	public static boolean isSumOfAbundantNumbers(int num) {
		for (int i = 12; i <= num ; i++) {
			if (Util.isAbundantNumber(i) ) {
				int diff = num - i;
				if(isAbundantNumber(diff)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isSumOfAbundantNumbersWithLog(int num) {
		for (int i = 12; i <= num/2 ; i++) {
			if (Util.isAbundantNumber(i) ) {
				int diff = num - i;
				if(isAbundantNumber(diff)) {
					System.out.println(num + " = " + i + " + " + diff + " = " + (i+diff));
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isAbundantNumberSlowerSimpler(int num) {
		return Util.addAllIntegers(Util.getProperDivisors(num)) > num;
	}
	
	public static boolean isAbundantNumber(int num) {
		
		int total = 1;
		Set<Integer> factors = new HashSet<Integer>();
		factors.add(1);
		int limit = num;
		for (int i = 2; i < limit; i++) {
			if (num % i == 0) {
				limit = num / i;
				
				if(factors.add(i)) {
					total += i;
					if(total > num)
						return true;
				}
				if(factors.add(limit)) {
					total += limit;
					if(total > num)
						return true;
				}
			}
		}
		return false;
	}

	public static boolean isCircularPrime(int num) {
		String intStr = num + "";
		for (int i = 0; i < intStr.length(); i++) {
			intStr = intStr.substring(1) + intStr.charAt(0);
			Integer newInt = Integer.parseInt(intStr);
			if (!isPrime((long) newInt)) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
public static boolean isPalindromeInt(int i) {
		return isPalindromeString(""+i);
	}


public static boolean isPalindromeIntSlower(int num) { 
	//slower but just fun to do with only ints and no strings
		int dCount = Util.countDigits(num);
		int t = num, mp = 0;
		for(int i=1; i<dCount; i+=2){
			mp = (int) Math.pow(10, dCount-i);
			if(t/mp != t%mp%10) 
				return false;
			t = (t%mp)/10;
		}
		return true;
}

	
	public static boolean isPalindromeLong(long i) {
		return isPalindromeString(""+i);
	}

	public static boolean isPalindromeString(String str) {
		
		if (str.length() > 0) {

			int half = str.length() / 2;
			for (int i = 0; i <= half; i++) {
				char a = str.charAt(i);
				char b = str.charAt(str.length() - 1 - i);
				if (a != b) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static boolean isDone(Integer[] nums, int maxVal) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != maxVal) {
				return false;
			}
		}
		return true;
	}

	public static boolean addsUp(Integer[] nums, int goal) {
		int total = 0;
		for (Integer i : nums) {
			total += i;
			if (total > goal) {
				return false;
			}
		}
		return total == goal;
	}

	public static int getIndex(int[] data, int num) {

		for (int i = 0; i < data.length; i++) {
			if (data[i] == num) {
				return i;
			}
		}
		return 0;
	}

	public static boolean listContainsIntArray(List<Integer[]> lis, Integer[] arr) {
		for (Integer[] ar : lis) {
			if (Arrays.equals(ar, arr)) {
				return true;
			}
		}
		return false;
	}

	public static boolean listListContainsIntArray(List<List<Integer>> lis, List<Integer> arr) {
		List<Integer> aa = new ArrayList<Integer>();
		aa.addAll(arr);
		Collections.sort(aa);
		for (List<Integer> li : lis) {
			List<Integer> lli = new ArrayList<Integer>();
			lli.addAll(li);
			Collections.sort(lli);
			if (lli.equals(aa)) {
				/*
				 * System.out.println("Found a dup:"); printListInteger(arr);
				 * System.out.print("  of  " ); printListInteger(li);
				 */
				return true;
			}
		}

		return false;
	}

	public static boolean listListContainsIntArray(List<int[]> lis, int[] arr) {
		int[] aa = arr;
		Arrays.sort(aa);
		for (int[] li : lis) {
			int[] lli = li;
			Arrays.sort(lli);

			if (lli.equals(aa)) {
				/*
				 * System.out.println("Found a dup:"); printListInteger(arr);
				 * System.out.print("  of  " ); printListInteger(li);
				 */
				return true;
			}
		}

		return false;
	}

	public static void printListInteger(List<Integer> l) {
		for (Integer i : l) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void printListInteger(int[] l) {
		for (int i : l) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static int getSubIntFromIndexToIndex(int start, int end, int num) {
		String s = "" + num;
		return Integer.parseInt(s.substring(start, end));
	}

	public static long getSubIntFromIndexToIndex(int start, int end, long num) {
		String s = "" + num;
		return Long.parseLong(s.substring(start, end));
	}

	public static int[] getMissingDigits1Through9(int[] numDigits) {
		int[] rest = new int[9 - numDigits.length];
		for (int i = 0; i < rest.length; i++) {
			for (int j = 1; j < 10; j++) {
				if (!intArrayHasInt(numDigits, j) && !intArrayHasInt(rest, j)) {
					rest[i] = j;
				}

			}
		}
		return rest;
	}

	public static boolean intArrayHasInt(int[] nums, int num) {
		for (int i : nums) {
			if (i == num) {
				return true;
			}
		}
		return false;
	}
	
	public static int addUpAllDigits(BigInteger b) {
		String bs = b.toString();
		int sum = 0;
		for(int i=0; i<bs.length(); i++) {
			String aChar = bs.charAt(i)+"";
			Integer a = Integer.parseInt(aChar);
			sum += a;
		}
		return sum;
	}
	
	

	public static int[] splitIntNumsToArray(int num) {
		if(num == 0)
			return new int[] {0};
		
		int digitCount = countDigits(num);
		int[] digits = new int[digitCount];
		for (int i = digitCount - 1; i >= 0; i--) {
			int r = num % 10;
			digits[i] = r;
			num /= 10;
		}
		return digits;
	}
	
	

	public static long[] splitLongNumsToArray(long num) {

		int digitCount = countDigits(num);
		long[] digits = new long[digitCount];
		for (int i = digitCount - 1; i >= 0; i--) {
			long r = num % 10;
			digits[i] = r;
			num /= 10;
		}
		return digits;
	}

	public static int countDigits(int num) {
		return (int)(Math.log10(num)+1);
	}
	
	public static int countDigitsOld(int num) {
		int count = 0;
		while (num != 0) {
			num /= 10;
			++count;
		}
		return count;
	}

	public static int countDigits(long num) {
		int count = 0;
		while (num != 0) {
			num /= 10;
			++count;
		}
		return count;
	}

	public static int factorial(int num) {
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact *= i;
		}
		return fact;
	}

	public static long factorial(long num) {
		long fact = 1;
		for (long i = 1; i <= num; i++) {
			fact *= i;
		}
		return fact;
	}
	
	
	public static BigInteger factorial(BigInteger num) {
		BigInteger fact = new BigInteger(""+1); 
		for (BigInteger i = new BigInteger(""+1); i.compareTo(num) != 1; i = i.add(new BigInteger(""+1))) {
			fact = fact.multiply(i);
		}
		return fact;
	}
	
	public static BigInteger getNumberOfCombinations(int n, int r) {

		BigInteger nb = new BigInteger(""+n);
		BigInteger rb = new BigInteger(""+r);
		
		//n! / r! * (n-r)!
		BigInteger nFact = factorial(nb);
		BigInteger rFact = factorial(rb);
		BigInteger nMinusRFact = factorial(nb.subtract(rb));
		
		try{
			
			BigInteger sol = nFact.divide(rFact.multiply(nMinusRFact));
			//System.out.println("Sol  for n=" + n + " and r=" + r + " ::: " + sol);
			return sol;
		} catch(Exception e){
			System.out.println("Failed at n, r ::: " + n + " , " + r);
			System.out.println("nFact, rFact, nMinusRFact ::: " + nFact + ", " + rFact + ", " + nMinusRFact);
			System.exit(0);
		}
		
		
		
		return new BigInteger(""+0);
		
		
	}

	public static boolean hasPandigitalIdentity(int[] multiplicandsAndMultipliers, int product) {

		// used in problem 32
		// should check somewhere if product and/or array doesnt have duplicate
		// digits
		// we do this check before calling this. Works I guess. Just gotta do it
		// somewhere.
		for (int i = 0; i < multiplicandsAndMultipliers.length; i++) {
			int[] s1 = getIntsSublist(multiplicandsAndMultipliers, 0, i);
			int[] s2 = getIntsSublist(multiplicandsAndMultipliers, i);
			int sint1 = getIntFromIntArr(s1);
			int sint2 = getIntFromIntArr(s2);
			if (s1.length == 0 || s2.length == 0) {
				continue;
			}
			if ((sint1 * sint2) == product) {
				return true;
			}
		}
		return false;
	}

	public static boolean intHasDuplicateDigits(int num) {
		int[] digits = Util.splitIntNumsToArray(num);
		for (int i = 0; i < digits.length; i++) {
			for (int j = 0; j < digits.length; j++) {
				if (j != i && digits[i] == digits[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static int getIntFromIntArr(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result += nums[i] * (Math.pow(10, nums.length - 1 - i));
		}
		return result;
	}

	public static int[][] getAllCombinationsInt(int[][] combos, int[] nums, int[] choices, Integer comboInd) {

		if (choices.length == 0) {
			int firstnull = getFirstNullIntArrArr(combos);
			combos[firstnull] = nums;
		} else {
			for (int i = 0; i < choices.length; i++) {
				int[] nextNums = new int[nums.length + 1];
				for (int j = 0; j < nums.length; j++) {
					nextNums[j] = nums[j];
				}
				nextNums[nextNums.length - 1] = choices[i];

				int[] choicesSub1 = getIntsSublist(choices, 0, i);
				int[] choicesSub2 = getIntsSublist(choices, i + 1);
				int[] newChoices = appendTwoIntArrays(choicesSub1, choicesSub2);
				getAllCombinationsInt(combos, nextNums, newChoices, comboInd);
			}
		}

		return combos;

	}
	
	
	
	public static List<Integer> makeAllPanditalNumsFromZeroTo(int end){
		return makeAllPanditalNumsFromTo(0,end);
	}
	
	public static List<Integer> makeAllPanditalNumsFromOneTo(int end){
		return makeAllPanditalNumsFromTo(1,end);
	}
	
	
	/*
	public static List<Integer> makeAllPrimePanditalNumsFromOneTo(int end){
		return makeAllPrimePanditalNumsFromTo(1,end);
	}
	
	public static List<Integer> makeAllPrimePanditalNumsFromTo(int start, int end){
		List<String> all = new ArrayList<String>();
		String s = "";
		for(int i=start; i<=end; i++){
			s += i;
		}
		Util.makeAllPrimePermutationsRecur("", s, all);
		List<Integer> alln = new ArrayList<Integer>();
		for(String st : all){
			alln.add(Integer.parseInt(st));
		}
		return alln;
	}
	
	public static void makeAllPrimePermutationsRecur(String s, String r, List<String> all){
		if(r.length() == 0){
			all.add(s);
		} else {
			
			//System.out.println("Continuing to do r = " + r);
			for(int i=0; i<r.length(); i++){
				String newS = s + r.charAt(i);
				String newR = r.substring(0,i) + r.substring(i+1);
				
				boolean shouldSkip = true;
				for(int j=0; j<newR.length(); j++){
					System.out.println("Checking newR=" + newR + " specifically " + newR.charAt(j));
					if(Integer.parseInt(newR.charAt(j)+"") % 2 != 0) { 
						// check if the only numbers that are left are all even,  then the last number will end up being even, so not prime
						//System.out.println("Should not skip because newR = " + newR);
						shouldSkip = false;
						break;
					}
				}
				
				if(shouldSkip) {
					System.out.println("Should yes skip because newR = " +newR);
					continue;
				}
					
				
				makeAllPermutationsRecur(newS, newR, all);
			}
		}
	}
	*/
	public static List<Integer> makeAllPanditalNumsFromTo(int start, int end){
		List<String> all = new ArrayList<String>();
		String s = "";
		for(int i=start; i<=end; i++){
			s += i;
		}
		Util.makeAllPermutationsRecur("", s, all);
		List<Integer> alln = new ArrayList<Integer>();
		for(String st : all){
			alln.add(Integer.parseInt(st));
		}
		return alln;
	}
	
	public static List<Long> makeAllPandigitalNumsFromZeroTo(long end){
		return makeAllPanditalNumsFromTo(0,end);
	}
	
	public static List<Long> makeAllPanditalNumsFromOneTo(long end){
		return makeAllPanditalNumsFromTo(1,end);
	}
	
	public static List<Long> makeAllPanditalNumsFromTo(long start, long end){
		List<String> all = new ArrayList<String>();
		String s = "";
		for(long i=start; i<=end; i++){
			s += i;
		}
		Util.makeAllPermutationsRecur("", s, all);
		List<Long> alln = new ArrayList<Long>();
		for(String st : all){
			if(st.charAt(0) != '0')
			alln.add(Long.parseLong(st));
		}
		return alln;
	}

	public static int getFirstNullIntArrArr(int[][] combos) {
		for (int i = 0; i < combos.length; i++) {
			if (combos[i] == null) {
				return i;
			}
		}
		return -1;
	}


	public static int[] getIntsSublist(int[] nums, int start, int end) {
		// goes from start index inclusive, to end of array
		int size = end - start;
		int[] sub = new int[size];
		int newArrCount = 0;
		for (int i = start; i < end; i++) {
			sub[newArrCount++] = nums[i];
		}
		return sub;
	}

	public static int[] getIntsSublist(int[] nums, int start) {
		if (start < 0)
			start = 0;
		int size = nums.length - start;
		int[] sub = new int[size];
		int newArrCount = 0;
		for (int i = start; i < nums.length; i++) {
			sub[newArrCount++] = nums[i];
		}
		return sub;
	}

	public static int[] appendTwoIntArrays(int[] arr1, int[] arr2) {
		int newSize = arr1.length + arr2.length;
		int[] newArr = new int[newSize];
		int newCounter = 0;
		for (int i : arr1) {
			newArr[newCounter++] = i;
		}
		for (int i : arr2) {
			newArr[newCounter++] = i;
		}
		return newArr;
	}

	public static boolean intHasAZeroInItMaybeSlower(int num) {
		int[] digits = Util.splitIntNumsToArray(num);
		for (int i : digits) {
			if (i == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean intHasAZeroInIt(int n) {
		while(n > 0) {
			if(n % 10 == 0) 
				return true;
			n /= 10;
		}
		return false;
	}

	public static long gcd(long numer, long denom) {
		return denom == 0 ? numer : gcd(denom, numer % denom);
	}
	
	public static int gcd(int numer, int denom) {
		return denom == 0 ? numer : gcd(denom, numer % denom);
	}
	

	public static String reduceFractionString(long numer, long denom) {
		long gcd = gcd(numer, denom);
		return (numer / gcd) + "/" + (denom / gcd);
	}
	
	public static int[] reduceFractionSlow(int numer, int denom) {// this can probably be optimized
		int na = numer, da = denom;
		for(int i=2; i < denom/2; i++) {
			if(na % i == 0 && da % i == 0) {
				while (na % i == 0 && da % i == 0) {
					na /= i;
					da /= i;	
				}
			}
		}
		
		return new int[] {na, da};
	}
	
	public static long[] reduceFractionSlow(long n, long d) {
		//int i = 2;
		long na = n, da = d;
		for(long i=2; i < d/2; i++) {
			if(na % i == 0 && da % i == 0) {
				while (na % i == 0 && da % i == 0) {
					na /= i;
					da /= i;	
				}
				i++;
			}
		}
		
		return new long[] {na, da};
	}
	
	
	public static long[] reduceFraction(long numer, long denom) {
		long gcd = gcd(numer, denom);
		return new long[] {(long) (numer / gcd), (long) (denom / gcd)};
	}
	
	
	public static int[] reduceFraction(int numer, int denom) {
		int gcd = gcd(numer, denom);
		return new int[] {(int) (numer / gcd), (int) (denom / gcd)};
	}
	public static int sumOfDigitFactorial(int num) {
		int[] digits = splitIntNumsToArray(num);
		int total = 0;
		for (int d : digits) {
			total += factorial(d);
		}
		return total;
	}

	public static long sumOfDigitFactorial(long num) {
		long[] digits = splitLongNumsToArray(num);
		int total = 0;
		for (long d : digits) {
			total += factorial(d);
		}
		return total;
	}

	public static String bin16(int i) {
		return String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0');
	}

	public static String bin32(int i) {
		return String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0');
	}

	public static String bin64(long i) {
		return String.format("%64s", Long.toBinaryString(i)).replace(' ', '0');
	}

	public static int[] intToBitArray(int num) {
		int[] bits = new int[countBits(num)];
		for (int i = 0; i < bits.length; i++) {
			bits[i] = num & 1;
			num >>= 1;
		}
		return bits;
	}

	public static int countBits(int num) {
		int count = 0;
		while (num > 0) {
			count++;
			num = num >> 1;
		}
		return count;
	}

	public static boolean isBinaryPalindromeNumber(int num) {
		int bitCount = Util.countBits(num);
		int n = 0;
		int temp = num;
		for (int i = 0; i < bitCount; i++) {
			if ((temp & 1) == 1) {
				n += (int) Math.pow(2, (bitCount - i - 1));
			}
			temp >>= 1;
		}
		return num == n;
	}

	public static int reverseDigits(int num) {
		int test = 0;
		int[] digits = Util.splitIntNumsToArray(num);
		for (int i = 0; i < digits.length; i++) {
			test += digits[i] * Math.pow(10, i);
		}
		return test;
	}
	
	public static long reverseDigits(long num) {
		long test = 0;
		long[] digits = Util.splitLongNumsToArray(num);
		for (int i = 0; i < digits.length; i++) {
			test += digits[i] * Math.pow(10, i);
		}
		return test;
	}
	
	
	public static String reverseString(String s) {
		 String reversed = "";
		 for (int i = s.length()-1; i >= 0; i--) {
			 reversed += s.charAt(i);
		  } 
		 return reversed; 
	}
	 
	 public static BigInteger reverseDigitsThenAdd(BigInteger num) {
			String reversed = Util.reverseString("" + num);
			return num.add(new BigInteger(reversed));
	 }
	 

	public static boolean isTruncatablePrimeBackwardsAndForwards(int num) {
		int dcount = Util.countDigits(num);
		int test = num, test2 = num;

		for (int i = 0; i < dcount; i++) {
			test = test % (int) Math.pow(10, dcount - i);
			test2 = test2 / 10;
			if (!Util.isPrime(test) || (test2 != 0 && !Util.isPrime(test2))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPandigitalNumberFromTo(int start, int end, int num){
		String s = num + "";
		for (int i = start; i <= end; i++) {
			String iString = i + "";
			int ind = s.indexOf(iString);
			if (ind != -1) {
				String left = s.substring(0, ind);
				String right = s.substring(ind + 1);
				s = left + right;
				if (s.indexOf(iString) != -1) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean isPandigitalNumberOneToNine(int num) {
		return isPandigitalNumberFromTo(1, 9, num);
	}
	
	public static boolean isPandigitalNumberZeroToNine(int num) {
		return isPandigitalNumberFromTo(0, 9, num);
	}

	public static boolean isNthDigitPandigitalNumber(int num) {
		int count = Util.countDigits(num);
		return isPandigitalNumberFromTo(1, count, num);
	}

	public static int appendIntToInt(int first, int second) {
		return Integer.parseInt(first + "" + second);
	}

	public static List<int[]> findRightTriangleSidesFromPerimeter(int p) {

		List<int[]> sols = new ArrayList<int[]>();
		for (int i = p; i > 2; i--) {
			int c = i - 2; // how big can c be?
			int a = p - c - 1;
			int b = p - c - a;
			for (int j = 1; j < p - c && b <= a; j++) {
				if ((a * a) + (b * b) == (c * c)) {
					sols.add(new int[] { p, a, b, c });
					System.out.println("Found sol for " + p + " : " + a + " " + b + " " + c);
				}
				a = p - c - j;
				b = p - c - a;
			}
		}
		return sols;
	}

	public static boolean isInteger(double d) {
		return d - (int) d > 0;
	}

	public static boolean isInteger(float f) {
		return f - (int) f > 0;
	}

	public static int findNthDigitOfAllNums(int nthDigit) {
		if (nthDigit < 0)
			return -1;
		if (nthDigit < 10)
			return nthDigit;
		int c = 1;
		int stage = 10;
		// stage will store the start of the range we are talking about, 10+ (2 digit nums), 190+ (3 digits), 2890 (4), 38890(5), 488890(6), 5888890(7)....
		while (stage - 1 < nthDigit) { 
			stage += 9 * (c + 1) * (int) Math.pow(10, c++);
		}
		stage -= 9 * c * (int)Math.pow(10, c-1);
		int whatDigit = (nthDigit - stage) % c;
		int startingNum = ((nthDigit - stage) / c) + (int) Math.pow(10, c - 1);
		int actualNumber = startingNum / (int) Math.pow(10, c - whatDigit - 1) % 10;
		System.out.println("whatDigit: "+whatDigit+" startingNum:"+startingNum+" actualNumber:"+actualNumber);
		return actualNumber;
	}

	public static String findNthDigitOfAllNumsEasy(int num) {
		String b = makeAllNumsStringFromTo(0, 15000);
		return b.charAt(num) + "";
	}

	public static String makeAllNumsStringUpTo(int n) {
		String b = "";
		for (int i = 0; i < n; i++) {
			b += i;
		}
		return b;
	}

	public static String makeAllNumsStringFromTo(int start, int end) {
		String b = "";
		for (int i = start; i < end; i++) {
			b += i;
		}
		return b;
	}
	
	public static void makeAllPermutationsRecur(String s, String r, List<String> all){
		if(r.length() == 0){
			all.add(s);
		} else {
			for(int i=0; i<r.length(); i++){
				String newS = s + r.charAt(i);
				String newR = r.substring(0,i) + r.substring(i+1);
				makeAllPermutationsRecur(newS, newR, all);
			}
		}
	}
	
	public static void makeAllPermutationsRecurNoDupesSet(String s, String r, Set<String> all){
		if(r.length() == 0){
			all.add(s);
		} else {
			for(int i=0; i<r.length(); i++){
				String newS = s + r.charAt(i);
				String newR = r.substring(0,i) + r.substring(i+1);
				makeAllPermutationsRecurNoDupesSet(newS, newR, all);
			}
		}
	}
	
	public static boolean isPermutationOf(long n1, long n2) {
		int[] d1 = new int[] {0,0,0,0,0,0,0,0,0,0};
		int[] d2 = new int[] {0,0,0,0,0,0,0,0,0,0};
		int r = 0;	
		while (n1 != 0) {
			r = (int) (n1 % 10);
			d1[r]++;
			n1 /= 10;
		}
		while (n2 != 0) {
			r = (int) (n2 % 10);
			d2[r]++;
			n2 /= 10;
		}
		for(int i=0; i<d1.length; i++)
			if(d1[i] != d2[i])
				return false;
		
		return true;
	}
	
	public static void findCombinationsOfSizeRecur(int[] A, String out, int index, int lengthOfThing, int sampleSize) {
        // invalid input
        if (sampleSize > lengthOfThing) {
            return;
        }
 
        // base case: combination size is `k`
        if (sampleSize == 0) {
            System.out.println(out);
            return;
        }
 
        // start from the next index till the last index
        for (int j = index; j < lengthOfThing; j++) {
        	findCombinationsOfSizeRecur(A, out + " " + (A[j]) , j + 1, lengthOfThing, sampleSize - 1);
 
            // uncomment the following code to handle duplicates
            /* while (j < n - 1 && A[j] == A[j + 1]) {
                j++;
            } */
        }
    }
	
	public static void findCombinationsOfSizeRecurKeepTrack(int[] A, String out, int index, int lengthOfThing, int sampleSize, List<String> keepTrack) {
        // invalid input
        if (sampleSize > lengthOfThing) {
            return;
        }
 
        // base case: combination size is `k`
        if (sampleSize == 0) {
            keepTrack.add(out);
            return;
        }
 
        // start from the next index till the last index
        for (int j = index; j < lengthOfThing; j++) {
        	findCombinationsOfSizeRecurKeepTrack(A, out + " " + (A[j]) , j + 1, lengthOfThing, sampleSize - 1, keepTrack);
 
            // uncomment the following code to handle duplicates
            /* while (j < n - 1 && A[j] == A[j + 1]) {
                j++;
            } */
        }
    }
	
	public static void addConsecutiveSquaresFromTo(int start, int end) {
		long sum = 0;
		for(int i = start; i <= end; i++) {
			long isq = (i*i);
			sum += isq;
		}
		System.out.println("Sums to : " + sum);
	}
	
	public static int getNthTriangleNumber(int n){
		return ((n+1)*n)/2;
	}
	
	public static long getNthTriangleNumber(long n){
		return ((n+1)*n)/2;
	}
	
	public static void testTriangleNumberIndexFinder(long to){
		for(long i=0; i<to; i++){
			long t = Util.getNthTriangleNumber(i);
			long s = getNIndexfromTriangleNumber(t); 
			if(s != i){
				System.out.println("WRONG : i=" + i + " t=" + t + " s=" + s);
				return;
			}
		}
	}
	
	public static boolean isTriangleNumber(int t){
		int test = getNIndexOfTriangleNumber(t);
		int actual = getNthTriangleNumber(test);
		return t == actual;
	}
	
	public static int getNIndexOfTriangleNumber(int t){
		int n =(int)Math.sqrt(t*2); 
		int real = Util.getNthTriangleNumber(n);
		if(t == real){
			return n;
		}
		return -1;
			
	}
	
	public static long getNIndexfromTriangleNumber(long n){
		return (long)Math.sqrt(n*2);
	}
	
	public static int getIntValForLetter(char c){
		return (int)c-64;
		
	}
	public static int getWordToTriangleNumber(String s){
		int total = 0;
		for(int i=0; i<s.length();i++){
			total += getIntValForLetter(s.charAt(i));
		}
		return total;
	}
	
	public static void testPentagonalNumbers(){ // test pentagonal number creation and solving the index
		int max = 200000000;
		for(int i=1; i < max; i++){
			long pent = getPentagonalNumber(i);
			long ind = getIndexOfPentagonalNumber(pent);
			if(ind < 0){
				System.out.println("FALSE :::: Test Pent #" + i + " :: pent=" + pent + " :: supposedly was this index:" +ind );//66845
				return;
			}
		}
		System.out.println("All Passed up to n=" + max);
	}
	
	public static long getPentagonalNumber(long n){
		return n * (3*n - 1) /2;
	}
	
	public static long getIndexOfPentagonalNumber(long n){
		long pent =  (long)(Math.sqrt(n*6) + 1) / 3;
		if(getPentagonalNumber(pent) == n){
			return pent;
		}
		return -1;
	}
	
	
	public static boolean isPentagonalNumber(long n){//1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
		return getIndexOfPentagonalNumber(n) > 0;
		
	}
	
	public static int getHexagonalNumber(int n){
		return n * ((n*2) -1);
	}
	
	public static long getHexagonalNumber(long n){
		return n * ((n*2) -1);
	}
	
	public static int getIndexFromHexagonal(int n){
		int t = n / (int)Math.sqrt(n*2);
		if(getHexagonalNumber(t) == n){
			return t;
		}
		return -1;
	}
	
	public static long getIndexOfHexagonal(long n){
		long t = n / (long)Math.sqrt(n*2);
		if(getHexagonalNumber(t) == n){
			return t;
		}
		return -1;
	}
	
	public static boolean isHexagonalNumber(long n){
		return getIndexOfHexagonal(n) > 0;
	}
	

	
	public static void testHexNumbers(){
		int max = 1000000;
		for(long i=1; i<max; i++){
			long hex = Util.getHexagonalNumber(i);
			long ind = Util.getIndexOfHexagonal(hex);
			if(i != ind){
				System.out.println("This one doesnt work!! i:"+i + " hex:"+hex + " ind:" +ind);
				return;
			}
		}
		System.out.println("All passed hexagonal numbers from 1 to " + max + " (using longs)");
	}
	
public static boolean isPermutationDigits(int a, int b){
		
		String at = a+"";
		String bt = b+"";
		// lets assume the solution has unique digits, no duplicate digits. This is like the example given in problem 52, and the example made no mention of allowing duplicate digits..
		// if we find an answer, and it is wrong on the website, we can switch to allowing duplicate digits....
		
		
		
		if(at.length() != bt.length() || a == b){
			return false;
		}
		
		for(int i=0; i<at.length(); i++){
			char c = at.charAt(i);
			boolean hasThisDigit = false;
			for(int j=0; j<bt.length(); j++){
				char d = bt.charAt(j);
				if(c == d){
					hasThisDigit = true;
					bt = bt.substring(0,j) + bt.substring(j+1);
					break;
				}
			}
			if(!hasThisDigit){
				return false;
			}
		}
		
		return true;
	}
	
public static boolean hasSameUniqueDigits(int a, int b){
		
		String at = a+"";
		String bt = b+"";
		// lets assume the solution has unique digits, no duplicate digits. This is like the example given in problem 52, and the example made no mention of allowing duplicate digits..
		// if we find an answer, and it is wrong on the website, we can switch to allowing duplicate digits....
		
		if(hasDuplicateDigit(a) || hasDuplicateDigit(b) || at.length() != bt.length() || a == b){
			return false;
		}
		
		for(int i=0; i<at.length(); i++){
			char c = at.charAt(i);
			boolean hasThisDigit = false;
			for(int j=0; j<bt.length(); j++){
				char d = bt.charAt(j);
				if(c == d){
					hasThisDigit = true;
					break;
				}
			}
			if(!hasThisDigit){
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean hasDuplicateDigit(int a){
		String at = a+"";
		if(at.length()>1){
			for(int i=0; i<at.length(); i++){
				char c = at.charAt(i);
				for(int j=i+1; j<at.length(); j++){
					if(c == at.charAt(j)){
						return true;
					}
				}
			}
		}
		return false;
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
	 * 
	 * THESE FUNCTIONS ARE COPIED FROM DEADHORSE EVAL BY ELJEFEO - HOPEFULLY IF THEY GET UPDATED OVER THERE I REMEMBER TO UPDATE HERE....
	 * SHOULD DO MAVEN LOL
	 * 
	 */
	public static int deadHorseEval5(int a,int b,int c,int d,int e){
		int x=(a^b^c^d^e)&8191,y=(a|b|c|d|e)&8191,z=y^x,v=y&y-1;
		if((v&=v-1)==0)
			return (a+b+c+d+e-x&8191)==(8191&(y^x)<<2) 
			  ?0x1C000000|x|z<<13:0x18000000|z|x<<13; //4 of a kind or full house
		else if((v&=v-1)==0)
			return z!=0?0x8000000|x|z<<13
			:0xC000000|(v=((a&b)==(a&8191)?a:(c&d)==(c&8191)?c:e)&8191^y)|v<<13;
		else if((v&=v-1)==0) return 0x4000000|x|z<<13;
		boolean strt=0x1F1D100%y==0,flsh=(a&b&c&d&e)!=0;
		return strt?(x==4111?15:x)|(flsh?0x20000000:0x10000000):flsh?0x14000000:x;
	}  
	
	// can send user readable strings into here like 'As or Jc or 9h'..
	//capital letter for face cards and UPPER case letter for suit 
	public  static int deadHorsePokerHumanEncodeEval5(String as, String bs, String cs, String ds, String es){

		//convert string to numbers that the eval recognizes
		int a = getSinglePokerCardValueFromHumanReadable(as);
		int b = getSinglePokerCardValueFromHumanReadable(bs);
		int c = getSinglePokerCardValueFromHumanReadable(cs);
		int d = getSinglePokerCardValueFromHumanReadable(ds);
		int e = getSinglePokerCardValueFromHumanReadable(es);
		return deadHorseEval5(a, b, c, d, e);
	}
	
	public static int getSinglePokerCardValueFromHumanReadable(String card) {
		
		if(card.length() != 2) {
			System.out.println("ERROR WITH CARD VALUE FOR POKER HAND, INVALID CARD : " + card);
			return 0;
		}
		
		char ac=card.charAt(0);

		return ((ac=='A'?1<<12:ac=='K'?1<<11:ac=='Q'?1<<10:ac=='J'?1<<9:ac=='T'?1<<8:1<<(ac-50))
		|((ac=card.charAt(1))=='S'?0x10000:ac=='H'?0x8000:ac=='C'?0x4000:0x2000));
	}

	//give it human readable string cards, it will spit back a human readable hand type(pair, full house etc..)
	public static String deadHorseHumanEncodeFullHandEval(String as, String bs, String cs, String ds, String es){
		int res= Util.deadHorsePokerHumanEncodeEval5(as,bs,cs,ds,es);
		return "unique hand value = " +res+ "\n"+ as + ", " + bs + ", " +cs+", " +ds+", "+es+"\n= "+ handNames[res>>26];
	}
	static String[] handNames = 
		{
			"High Card", "Pair", "Two Pair", "3 of a kind", 
			"Straight", "Flush", "Full House", "4 of a kind", "Straight Flush"
		};

	/*
	 * END DEADHORSE FUNCTIONS
	 * 
	 */
	
	public static int getEPeriod(int n) {
		//2; 1, 2, 1, 1, 4, 1, 1, 6, 1, 1, 8...
		
		if(n == 1) {
			return 2;
		} else if(n == 2) {
			return 1;
		}
		
		if(n % 3 == 0) {
			return (n/3) * 2;
		}
		
		return 1;
	}
	
	public static boolean isThisManyDigits(int n, int howManyDigits) {
		return ("" + n).length() == howManyDigits;
	}
	
	
	public static List<Integer> copyIntegerList(List<Integer> li){
		List<Integer> ret = new ArrayList<Integer>();
		for(Integer i : li) {
			ret.add(i);
		}
		return ret;
	}
	
	
	public static int getFirst2DigitsInt(int n) {
		int num = n;
		while(num > 100) {
			num /= 10;
		}
		return num;
	}
	
	public static int getLast2DigitsInt(int n) {
		return (n%100);
	}
	
	public static String getLast2Characters(int n) {
		String ns = n+"";
		if(ns.length() < 2) {
			return "";
		}
		String ret = ns.charAt(ns.length()-2) + "" + ns.charAt(ns.length()-1);
		return ret;
	}
	
	public static String getFirst2Characters(int n) {
		String ns = n+"";
		if(ns.length() < 2) {
			return "";
		}
		return ns.charAt(0) + "" + ns.charAt(1);
	}
	
	public static List<Integer> getPrimesUnderOrEqual(int max) {
		return getPrimesUnder(++max);
	}
	
	
	public static List<Integer> getPrimesUnder(int max) {
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
	
	public static List<Integer> getPrimesUnderOld(int max) {
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
	
	public static List<Integer> getPrimesUnderWithSqrt(int max) {
		int n = 1;
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		while ((n+=2) < max) {
			int sqrt = (int) Math.sqrt(n);
			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				if(prime > sqrt) {
					primes.add(n);
					break;
				}
				
				if (n % prime == 0) 
					break;
			}
		}
		return primes;
	}



	public static List<Integer> getPrimesUnderSlow(int num) {
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < num; i++) {
			if (Util.isPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
	}
	
	
	public static int getNthPrimeNumber(int max) {
		// this method does not have to calculate the square root of the number to find the limit
		// we use some pattern I noticed to know what the square root is
		// a little faster because we dont have to do Math.sqrt(num)
		int n = 1;
		List<Integer> primes = new ArrayList<Integer>();
		
		int sqrtCounter = 1;
		int sqrtNext = 3;
		int sqrt = 1;
		
		primes.add(2);
		
		while (primes.size() < max) {
			n+=2;
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
			
			if(sqrtCounter > sqrtNext-2) { // here is where we calculate the next square root
				sqrtNext += 2;
				sqrtCounter = sqrtNext-sqrtCounter;
				sqrt++;
			}  	
				
		}
		
		return primes.get(primes.size()-1);
		
	}
	
	public static int doFactorialChainUntilLoop(int n) {
		int num = n;
		int count = 0;
		int[] hist = new int[60];
		while(!arrContainsInt(hist, num)) {
			count++;
			System.out.println("" + num);
			
			if(addToNextOpenInd(hist, num) == 60 - 1) {
				count++;
				break;
			}
			int[] arr = Util.splitIntNumsToArray(num);
			num = 0;
			for(int j : arr) {
				num += Util.factorial(j);
			}
		}
		System.out.println("looped at " + num);
		System.out.println("Count " + count);
		return count;
	}
	
	public static int addToNextOpenInd(int[] arr, int test) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0) {
				arr[i] = test;
				return i;
			}
		}
		return -1;
	}

	public static boolean arrContainsInt(int[] arr, int num) {
		// we will assume we are putting values in the array from lower index to higher index
		// and all unused indexes will have value 0
		for(int i=0; i<arr.length; i++) {
			int val = arr[i];
			if(val == 0)
				break;
			
			if(val == num)
				return true;
		}
		
		return false;
	}
	
	
	public static long[] getFractionToTheLeft(int max, long rightNumerGoal, long rightDenomGoal) {
		
		//System.out.println("Doing here " + rightNumerGoal + "/" + rightDenomGoal);
		
		if(rightDenomGoal == max && rightNumerGoal == 1) {
			System.out.println("ERROR - asking for left of leftmost fraction... what the hell are you doing??llollol?");
			return new long[] {0,0};
			// error - there is no fraction to the left of the leftmost fraction lollloll..
		}
		long[] ret = new long[2];
		boolean isDEven = rightDenomGoal % 2 == 0;
		int inc = isDEven ? 2 : 1;
		if(isDEven && max % 2 == 0)
			max--;
		
		for(int i=max; i > 2; i-=inc) {
			if(isDEven && i % 2 == 0) {
				//System.out.println("continuing because isdevn and " + i + " % 2 == 0");
				continue;
			}
			
			if(i == rightDenomGoal) {
				//System.out.println("continuing because " + i + " == " + rightDenomGoal);
				continue;
			}
			
			if(i > rightDenomGoal ) {
				if(i % rightDenomGoal == 0) {
					//System.out.println("continuing because " + i + " % " + rightDenomGoal + " == 0");
					continue;
				}
				
			} else if(rightDenomGoal % i == 0) {
				//System.out.println("continuing because " + rightDenomGoal + " % " + i + " == 0");
				continue;
			}
			
			long[] lcm  = Util.lcmWithMult(i, rightDenomGoal); // returns lcm and how many to multiply the higher num to get there
			
			long w = rightDenomGoal < i ? lcm[0] / rightDenomGoal : lcm[1];
			
			long newNumerator = (rightNumerGoal * w) - 1;
			long[] red = Util.reduceFraction(newNumerator, lcm[0]);
			//System.out.println(newNumerator + "/" + lcm[0] + " Reduced to " + red[0] + "/" + red[1]);
//			1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

			if(red[1] <= max) {
				return red;
			} else {
				//System.out.println("couldnt find it " + rightNumerGoal + "/" + rightDenomGoal + " with " + red[0] + "/" + red[1] + " with i = " + i);
			}
		}
		
		return ret;
	}
	
	public static boolean isCube(long c) {
		double d = Math.cbrt(c);
		return ( d - (long)d ) == 0;
	}

	public static boolean isLychrelNumber(int n, int howManyIterationsToCheck) {
		BigInteger bn = new BigInteger("" + n);
		for (int i = 1; i < howManyIterationsToCheck; i++) { // this will be 50 instead of 10, just starting with 10 to test size of these things
			bn = Util.reverseDigitsThenAdd(bn);
			if (Util.isPalindromeString(bn.toString())) {
				return false;
			}
		}
		return true;
	}
	
	public static int collatzConjectureNextNum(int num){
		if(num % 2 == 0){
			return num / 2;
		} else { 
			return 3*num + 1;
		}
	}
	
	public static long collatzConjectureNextNum(long num){
		if(num % 2 == 0){
			return num / 2;
		} else { 
			return 3*num + 1;
		}
	}
	
	public static int findNumWithThisManyPrimeSums(int limit) {
		int num = 1;
		int numWays = 0;
		List<Integer> primes = Util.getPrimesUnder(limit);
		
		while(numWays < limit) {
			num++;
			//numWays = howManyWaysToSumToN_print(0, num, 0, primes.size()-1, primes, " ");
			numWays = howManyWaysToSumPrimesToN_Primesrecur(0, num, 0, primes.size()-1, primes);
			//System.out.println("Ways to make : " + num + " = " + numWays);
			
		}
		return num;
	}
	
	

	public static int howManyWaysToSumPrimesToN_Primesrecur(int num, int goal,  int count, int end, List<Integer> primes) {
		if(num == goal) {
			count++;
		} else if(num < goal) {
			for(int i = 0; i <= end; i++) {
				count = howManyWaysToSumPrimesToN_Primesrecur(num + primes.get(i), goal, count, i, primes);
			}
		}
		return count;
	}
	
	public static int howManyWaysToSumToN_print(int num, int goal,  int count, int end, List<Integer> primes, String sofar) {
		if(num == goal) {
			System.out.println("Found one : " + sofar);
			count++;
		} else if(num < goal) {
			for(int i = 0; i <= end; i++) {
				//System.out.println("Doing sofar " + sofar + " + " + primes.get(i) + " : num " + num);
				count = howManyWaysToSumToN_print(num + primes.get(i), goal, count, i, primes, sofar + " " + primes.get(i));
			}
		}
		return count;
	}
	
	public static int howManyWaysToSumToN_recurEntry(int num) {
		return Util.howManyWaysToSumToN_recur(0, num, 0, num-1);
	}
	
	public static int howManyWaysToSumToN_recur(int num, int goal,  int count, int end) {
		if(num == goal) {
			count++;
		} else if(num < goal) {
			for(int i = 1; i <= end; i++) {
				count = howManyWaysToSumToN_recur(num + i, goal, count, i);
			}
		}
		return count;
	}
	
	public static BigInteger howManyWaysToSumToNEulers(int num) {
		List<BigInteger> all = new ArrayList<BigInteger>();
		all.add(new BigInteger("1"));
		all.add(new BigInteger("1"));
		num++;
		int ii = 2;
		while(ii < num) {
			BigInteger run = new BigInteger("0");
			BigInteger neg = new BigInteger("-1");
			BigInteger posNeg = new BigInteger("1");
			int odd = 1;
			int nat = 1;
			int nToDo = ii;
			boolean shouldSubOdd = false;
			int numToSub = odd;
			while(true) {
				nToDo = nToDo - numToSub ;
				if(nToDo < 0 ) {
					break;
				}
				run = run.add((all.get(nToDo).multiply(posNeg)));
				if(shouldSubOdd = !shouldSubOdd) {
					odd += 2;//make all odd numbers, 1 3 5 7 9 etc..
					numToSub = nat;
				} else {
					nat++;//make all natural numbers, 1 2 3 4 5 6 7 ...
					numToSub = odd;
					posNeg = posNeg.multiply(neg);
				}
			}
			all.add(run);
			ii++;
		}
		return all.get(all.size()-1);
	}
	
	public int howManyWaysToSumToNEulers_divisibleMillion() {
		List<BigInteger> all = new ArrayList<BigInteger>();
		all.add(new BigInteger("1"));
		all.add(new BigInteger("1"));
	
		BigInteger million = new BigInteger("1000000");
		int ii = 2;
		while(true) {
			BigInteger run = new BigInteger("0");
			int i = 2;
			BigInteger neg = new BigInteger("-1");
			BigInteger posNeg = new BigInteger("1");
			int odd = 1;
			int nat = 1;
			int nToDo = ii;
			
			while(true) {
				nToDo = nToDo - odd;
				if(nToDo < 0 ) {
					break;
				}
				run = run.add((all.get(nToDo).multiply(posNeg)));
				
				nToDo = nToDo - nat;
				if(nToDo < 0 ) {
					break;
				}
				run = run.add((all.get(nToDo).multiply(posNeg)));
				odd += 2; //make all odd numbers, 1 3 5 7 9 etc..
				nat++;
				posNeg = posNeg.multiply(neg);
			}
			
			if(run.mod(million).equals(BigInteger.ZERO)) {
				System.out.println("ans: " + ii + " : " + run);
				return ii;
			}
			all.add(run);
			ii++;
		}
	}
	
	
	public static void compare2PrimeFunctionsResults(int howManyPrimesToCalc) {
		List<Integer> p1 = getPrimesUnder(howManyPrimesToCalc);
		List<Integer> p2 = getPrimesUnderOld(howManyPrimesToCalc);
		
		System.out.println("Primes count: " + p1.size() + " : " + p2.size() + " : " + (p1.size() == p2.size()));
		for(int i = 0; i < p1.size(); i++) {
			if(p1.get(i).compareTo(p2.get(i)) == 0) {
				//System.out.println("YES " + p1.get(i) + " : " + p2.get(i));
			} else {
				System.out.println("NOOOOOO they are not equal " + p1.get(i) + " : " + p2.get(i));
				System.exit(1);
			}
		}
		System.out.println("Yes all results matched");
	}
	public static void compare2PrimeFunctionsTimings() {
		List<Double> times1 = new ArrayList<Double>();
		List<Double> times2 = new ArrayList<Double>();
		int howManyPrimesToCalculate = 20000;
		int howManyTimesToTest = 1000;
		for(int i = 0; i < howManyTimesToTest; i++) {
		
			long startT = System.nanoTime();
			List<Integer> p1 = getPrimesUnder(howManyPrimesToCalculate);
			long endT = System.nanoTime();
			double time = (double) (endT - startT) / 1000000000;
			times1.add(time);
			//System.out.printf("1st one Took %f seconds\n", time);
			
			long startT2 = System.nanoTime();
			List<Integer> p2 = getPrimesUnderOld(howManyPrimesToCalculate);
			long endT2 = System.nanoTime();
			double time2 = (double) (endT2 - startT2) / 1000000000;
			times2.add(time2);
			//System.out.printf("2nd one Took %f seconds\n", time2);
		}
		
		
		int t1Greater = 0;
		int t2Greater = 0;
		int t1t2Same = 0;
		for(int i=0; i<times1.size(); i++) {
			int comp = times1.get(i).compareTo(times2.get(i));
			if(comp > 0) {
				t1Greater++;
			} else if(comp < 0) {
				t2Greater++;
			} else {
				t1t2Same++;
			}
		}
		
		double tt = (double)t1Greater/howManyTimesToTest * 100;
		double tt2 = (double)t2Greater/howManyTimesToTest  * 100;;
		System.out.println("t1 was slower : " + tt + "% of the time, t2 was slower " + tt2 + "% of the time, same: " + t1t2Same);
	}
	
	public static int closestSquareUnderOrEqualN(int n) {
		int i = 0, t = 0;
		while(n >= (i*i)) {
			t = i;
			i++;
		}
		return t;
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
	
	public static boolean isPerfectSquare(int n) {
		int odd = 1;
		while(n > 0) {
			n-=odd;
			odd+=2;
		}
		return n == 0;
	}

	
	/*
	public boolean areCoPrime(int a, int b) {
		didnt really do this yet..
		int na = a, nb = b;
		
		if(a % b == 0 || b % a == 0) {
			return false;
		}
        
        List<Integer> factors = new ArrayList<Integer>();
        
        
        
        while (n % 2 == 0) {
            //factors.add(2);
            n /= 2;
        }
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
        	while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            factors.add(n);
        }
        return factors;
		
		return true;
	}
	*/
}
