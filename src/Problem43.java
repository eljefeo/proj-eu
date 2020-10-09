import java.util.List;

public class Problem43 {
	/*
	 * The number, 1406357289, is a 0 to 9 pandigital number because it is made
	 * up of each of the digits 0 to 9 in some order, but it also has a rather
	 * interesting sub-string divisibility property.
	 * 
	 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we
	 * note the following:
	 * 
	 * d2d3d4=406 is divisible by 2 d3d4d5=063 is divisible by 3 d4d5d6=635 is
	 * divisible by 5 d5d6d7=357 is divisible by 7 d6d7d8=572 is divisible by 11
	 * d7d8d9=728 is divisible by 13 d8d9d10=289 is divisible by 17 Find the sum
	 * of all 0 to 9 pandigital numbers with this property.
	 */
	public static void main(String[] args) {
		problem();
	}

	private static void problem() {

		long end = 9;
		List<Long> alln = Util.makeAllPanditalNumsFromZeroTo(end);

		int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17 };
		long sum = 0;
		for (int i = 0; i < alln.size(); i++) {
			Long num = alln.get(i);
			boolean isDivisibleByAll = true;
			for (int j = 1; j <= 7; j++) { // only go to 7 since we get j+2 which ends up being index 7,8,9 with 9 as the final number
				long sub1 = getSubIntFromIndexToIndex(j, j + 3, alln.get(i));
				if (sub1 % (primes[j - 1]) != 0) {
					isDivisibleByAll = false;
					break;
				}
			}
			if (isDivisibleByAll) {
				sum += num;
			}

		}
		System.out.println("Sum : " + sum );
	}

	public static int getSubIntFromIndexToIndex(int start, int end, int num) {
		String s = "" + num;
		return Integer.parseInt(s.substring(start, end));
	}

	public static long getSubIntFromIndexToIndex(int start, int end, long num) {
		String s = "" + num;
		return Long.parseLong(s.substring(start, end));
	}

}
