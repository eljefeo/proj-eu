import java.util.ArrayList;
import java.util.List;

public class Problem32 {

	/*
	 * We shall say that an n-digit number is pandigital if it makes use of all
	 * the digits 1 to n exactly once; for example, the 5-digit number, 15234,
	 * is 1 through 5 pandigital.
	 * 
	 * The product 7254 is unusual, as the identity, 39 x 186 = 7254, containing
	 * multiplicand, multiplier, and product is 1 through 9 pandigital.
	 * 
	 * Find the sum of all products whose multiplicand/multiplier/product
	 * identity can be written as a 1 through 9 pandigital.
	 * 
	 * HINT: Some products can be obtained in more than one way so be sure to
	 * only include it once in your sum.
	 * 
	 */
	public static void main(String[] args) {

		// System.out.println(" f "+tt + " " + (t) + " " + t/10);

		problem();
	}

	private static void problem() {
		List<Integer> foundNums = new ArrayList<Integer>();
		// int test = 7254;
		int max = 19999999;
		int step = 100000;
		for (int i = 10; i < max; i++) {
			if(i > step && i % step == 0){
				System.out.println("Running at : " + i);
			}
			int[] numDigits = Util.splitIntNumsToArray(i);
			int[] rest = Util.getMissingDigits1Through9(numDigits);
			int numOfCombos = Util.factorial(rest.length);
			int[][] combosInput = new int[numOfCombos][];
			int[][] combos = getAllCombinationsInt(combosInput, new int[0], rest, 0);

			/// time to try multiplying?
			for (int[] arr : combos) {
				if (hasPandigitalIdentity(arr, i)) {
					foundNums.add(i); //4396 4396 5346 5346 5346 5346 5796 5796 5796 5796 6952 6952 6956 6956 6970 6970 7096 7096 7254 7254 
					break;
				}
			}
		}
		
		System.out.println("Solutions:");
		Util.printListInteger(foundNums);
		int total = 0;
		for(Integer i : foundNums){
			total += i;
		}
		System.out.println("Tota: " + total);

	}

	private static boolean hasPandigitalIdentity(int[] multiplicandsAndMultipliers, int product) {
		for (int i = 0; i < multiplicandsAndMultipliers.length; i++) {
			int[] s1 = getIntsSublist(multiplicandsAndMultipliers, 0, i);
			int[] s2 = getIntsSublist(multiplicandsAndMultipliers, i);
			int sint1 = getIntFromIntArr(s1);
			int sint2 = getIntFromIntArr(s2);
			if ((sint1 * sint2) == product) {
				// if(!foundNums.contains(t)){
				return true;
				// System.out.println("Found one! " + sint1 + " * " + sint2 + "
				// = " + t);
				// }
			}
		}
		return false;
	}

	private static int getIntFromIntArr(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result += nums[i] * (Math.pow(10, nums.length - 1 - i));
		}
		// System.out.println("get int from arr : " + result + " , from:");
		// printIntArray(nums);

		return result;
	}

	public static int[][] getAllCombinationsInt(int[][] combos, int[] nums, int[] choices, Integer comboInd) {// ,
																												// int
																												// numsInd)
																												// {
		// total num of combinations = nums.length factorial

		// int[][] allCombos = new int[numOfCombos][];
		if (choices.length == 0) {
			// printIntArray(nums);
			int firstnull = getFirstNullIntArrArr(combos);
			combos[firstnull] = nums;
			// System.out.println("at index:" + comboInd + " added combos? " +
			// (combos[firstnull] == null ? " No " : " Yes "));
		} else {
			// int[] nextCombo = combos[ind];
			for (int i = 0; i < choices.length; i++) {
				int[] nextNums = new int[nums.length + 1];
				for (int j = 0; j < nums.length; j++) {
					nextNums[j] = nums[j];
				}
				nextNums[nextNums.length - 1] = choices[i];

				int[] choicesSub1 = getIntsSublist(choices, 0, i);
				int[] choicesSub2 = getIntsSublist(choices, i + 1); // Careful
																	// here with
																	// i+1 could
																	// be out of
																	// range,
																	// lets see
				int[] newChoices = appendTwoIntArrays(choicesSub1, choicesSub2);
				// if(newChoices.length == 0) comboInd++;
				// System.out.println("Choices size was " + choices.length + "
				// and is now " + newChoices.length);
				getAllCombinationsInt(combos, nextNums, newChoices, comboInd);// ,
																				// numsInd)

			}
		}

		return combos;

	}

	private static int getFirstNullIntArrArr(int[][] combos) {
		// System.out.println("Getting first null for array of size
		// :"+combos.length);
		for (int i = 0; i < combos.length; i++) {
			if (combos[i] == null) {
				return i;
			} // else {
				// System.out.println("this is not null arr arr");
				// printIntArray(combos[i]);
				// }
		}
		return -1;
	}

	private static void printIntArray(int[] arr) {
		System.out.print("printing array : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("");
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
		int size = nums.length - start; // System.out.println("doing sublist
										// just start. nums length: " +
										// nums.length + " and start: " +
										// start);
		int[] sub = new int[size];
		int newArrCount = 0;
		for (int i = start; i < nums.length; i++) {
			sub[newArrCount++] = nums[i];
		}
		return sub;
	}

	private static int[] appendTwoIntArrays(int[] arr1, int[] arr2) {
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

}
