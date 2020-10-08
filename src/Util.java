import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {
	public static boolean isPrime(long num) {
		
		if (num < 0 || num == 1) {
			return false;
		}
		if (num == 2) {
			return true;
		}

		if (num % 2 == 0) {
			return false;
		}
		for (long i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static BigInteger getTriangleNumberBigInt(int num) {
		BigInteger total = BigInteger.valueOf(0);
		for (long i = 1; i <= num; i++) {
			total = total.add(BigInteger.valueOf(i));
		}
		return total;
	}

	public static long getTriangleNumberLong(int num) {
		long total = 0;
		for (long i = 1; i <= num; i++) {
			total += i;
		}
		return total;
	}

	public static int getTriangleNumberInt(int num) {
		int total = 0;
		for (int i = 1; i <= num; i++) {
			total += i;
		}
		return total;
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

	public static Set<Integer> getFactorsInt(int num) {

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
		int half = num / 2;
		for (int i = 2; i <= half; i++) {
			if (num % i == 0) {
				factors.add(i);
			}
		}
		return factors;
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
		for (int i = 1; i <= num / 2; i++) {

			int num2 = num - i;
			if (Util.isAbundantNumber(i) && Util.isAbundantNumber(num)) {
				return true;
			}

		}
		return false;

	}

	public static boolean isAbundantNumber(int num) {
		return Util.addAllIntegers(Util.getProperDivisors(num)) > num;
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

	public static boolean isPalindromeString(String str) {
//
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

	public static int[] splitIntNumsToArray(int num) {

		int digitCount = countDigits(num);
		int[] digits = new int[digitCount];
		for (int i = digitCount - 1; i >= 0; i--) {
			int r = num % 10;
			digits[i] = r;
			num /= 10;
		}
		return digits;
	}
	
	public static long[] splitIntNumsToArray(long num) {

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

	public static boolean hasPandigitalIdentity(int[] multiplicandsAndMultipliers, int product) {

		//used in problem 32
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

	public static int getFirstNullIntArrArr(int[][] combos) {
		for (int i = 0; i < combos.length; i++) {
			if (combos[i] == null) {
				return i;
			}
		}
		return -1;
	}
	/*
	 * private static void printIntArray(int[] arr) { System.out.print(
	 * "printing array : "); for (int i : arr) { System.out.print(i + " "); }
	 * System.out.println(""); }
	 */

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

	public static boolean intHasAZeroInIt(int num) {

		int[] digits = Util.splitIntNumsToArray(num);
		for (int i : digits) {
			if (i == 0) {
				return true;
			}
		}
		return false;
	}

	public static long gcd(long a, long b) {
	    return b == 0 ? a : gcd(b, a % b);
	}

	public static String reduceFraction(long a, long b) {
	    long gcd = gcd(a, b);
	    return (a / gcd) + "/" + (b / gcd);
	}
	
	public static int sumOfDigitFactorial(int num){
		int[] digits = splitIntNumsToArray(num);
		int total = 0;
		for(int d : digits){
			total += factorial(d);
		}
		return total;
	}
	
	public static long sumOfDigitFactorial(long num){
		long[] digits = splitIntNumsToArray(num);
		int total = 0;
		for(long d : digits){
			total += factorial(d);
		}
		return total;
	}
	

	public static String bin16(int i){
		return String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0');
	}
	public static String bin32(int i){
		return String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0');
	}
	public static String bin64(long i){
		return String.format("%64s", Long.toBinaryString(i)).replace(' ', '0');
	}
	
	public static int[] intToBitArray(int num) {
		int[] bits = new int[countBits(num)];
		for(int i=0; i<bits.length; i++){
			bits[i] = num&1;
			num>>=1;
		}
		return bits;
	}
	
	public static int countBits(int num){
		int count=0;
		while(num>0){
			count++;
			num = num>>1;
		}
		return count;
	}
	
	public static boolean isBinaryPalindromeNumber(int num){
		int bitCount = Util.countBits(num);
		int n = 0;
		int temp = num;
		for(int i=0; i<bitCount; i++){
			if((temp&1) == 1){
				n += (int) Math.pow(2,(bitCount-i-1));
			}
			temp>>=1;
		}
		return num == n;
	}
		  
	public static int reverseDigits(int num){
		int test = 0;
		int[] digits = Util.splitIntNumsToArray(num);
		for(int i=0; i<digits.length; i++){
			test += digits[i]* Math.pow(10, i);
		}
		return test;
	}
	
	public static boolean isTruncatablePrimeBackwardsAndForwards(int num) {
		int dcount = Util.countDigits(num);
		int test = num;
		int test2 = num;

		for (int i = 0; i < dcount; i++) {
			test = test % (int) Math.pow(10, dcount - i);
			test2 = test2 / 10;
			if (!Util.isPrime(test)) {
				return false;
			}

			if (test2 != 0 && !Util.isPrime(test2)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPandigitalNumber(int num){
		String s = num+"";
		for(int i=1;i<10;i++){
			String iString = i+"";
			int ind = s.indexOf(iString);
			if(ind != -1){
				String left = s.substring(0, ind);
				String right = s.substring(ind+1);
				s = left+right;
				if(s.indexOf(iString) != -1){
					//System.out.println("false at index " + ind + " for i=" + i + " -- " + left + " " + right + " :: " + s);
					return false;
				}
			} else{
				//System.out.println("false " + s + " for num " + i);
				return false;
			}
		}
		return true;
	}
	
	public static int appendIntToInt(int first, int second){
		String f = first+""+second;
		return Integer.parseInt(f);
	}
	
	public static List<int[]> findRightTriangleSidesFromPerimeter(int p){
		
		
		List<int[]> sols = new ArrayList<int[]>();
		for(int i=p; i>2; i--){
			int c = i-2; // how big can c be?
			int a = p-c-1;
			int b = p-c-a;
			for(int j=1; j < p-c && b<=a;  j++){
				if((a*a) + (b*b) == (c*c)){
					sols.add(new int[]{p,a,b,c});
					System.out.println("Found sol for " + p + " : " + a + " " + b + " " + c ); 
				}
				a = p-c-j;
				b = p-c-a;
			}	
		}
		return sols;
	}
	
	public static boolean isInteger(double d){
		return d - (int)d > 0;
	}
	
	public static boolean isInteger(float f){
		return f - (int)f > 0;
	}
	

	public static int findNthDigitOfAllNums(int nthDigit){
		if(nthDigit < 0) return -1;
		if(nthDigit < 10) return nthDigit;
		int temp=10;
		int c = 1;
		int stage = temp;
		while(temp-1<nthDigit){ // stage will store the start of the range we are talking about, 2890, 38890, etc 
			stage = temp;
			temp += (9*(c+1)) * (int)Math.pow(10, c++);
		}
		int diffModC=(nthDigit-stage)%c;
		int startingNum = ((nthDigit-stage)/c) + (int)Math.pow(10, c-1); 
		int actualNumber = startingNum/(int)Math.pow(10, c-diffModC-1)%10;
		return actualNumber;
	}
	
	public static String findNthDigitOfAllNumsEasy(int num){
		String b = makeAllNumsStringFromTo(0, 15000);
		return b.charAt(num)+"";
	}

	
	public static String makeAllNumsStringUpTo(int n){
		String b = "";
		for(int i=0; i<n; i++){
			b+=i;
		}
		return b;
	}
	
	public static String makeAllNumsStringFromTo(int start, int end){
		String b = "";
		for(int i=start; i<end; i++){
			b+=i;
		}
		return b;
	}
}
