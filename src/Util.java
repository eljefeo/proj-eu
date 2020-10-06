import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {
	public static boolean isPrime(long num) {
		if (num < 0) {
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

	public static boolean isPalindrome(String str) {

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
	
	public static boolean listContainsIntArray(List<Integer[]> lis, Integer[] arr){
		for(Integer[] ar : lis){
			if(Arrays.equals(ar, arr)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean listListContainsIntArray(List<List<Integer>> lis, List<Integer> arr){
		List<Integer> aa = new ArrayList<Integer>();
		aa.addAll(arr);
		Collections.sort(aa);
		for(List<Integer> li : lis){
			List<Integer> lli = new ArrayList<Integer>();
			lli.addAll(li);
			Collections.sort(lli);
			if(lli.equals(aa)){
			/*	System.out.println("Found a dup:");
				printListInteger(arr);
				System.out.print("  of  " );
				printListInteger(li);*/
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean listListContainsIntArray(List<int[]> lis, int[] arr){
		int[] aa = arr;
		Arrays.sort(aa);
		for(int[] li : lis){
			int[] lli = li;
			Arrays.sort(lli);
			
			if(lli.equals(aa)){
				/*System.out.println("Found a dup:");
				printListInteger(arr);
				System.out.print("  of  " );
				printListInteger(li);*/
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

	public static int countDigits(int num) {
		int count = 0;
		while (num != 0) {
			num /= 10;
			++count;
		}
		return count;
	}
	
	public static int factorial(int num){
		int fact = 1;
		for(int i=1; i<=num; i++ ){
			fact *= i;	
		}
		return fact;

	}
}
