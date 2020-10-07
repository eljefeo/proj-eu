
public class Problem37 {
	/*
	 * The number 3797 has an interesting property. Being prime itself, it is
	 * possible to continuously remove digits from left to right, and remain
	 * prime at each stage: 3797, 797, 97, and 7. Similarly we can work from
	 * right to left: 3797, 379, 37, and 3.
	 * 
	 * Find the sum of the only eleven primes that are both truncatable from
	 * left to right and right to left.
	 * 
	 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
	 */

	public static void main(String[] args) {
		problem();
	}

	private static void problem() {
		int max = 1000000;
		testTruncatablePrimesFromElevenTo(max);
	}

	private static void testTruncatablePrimesFromElevenTo(int max) {
		int sum = 0;
		int count = 0;
		for (int i = 11; i < max; i++) {
			if (Util.isTruncatablePrimeBackwardsAndForwards(i)) {
				System.out.println("is truncatable prime : " + i);
				sum += i;
				count++;
			}
		}
		if (count == 11) {
			System.out.println("Found all " + count + " primes! :: Sum : " + sum);// not
																				// 833554
		} else {
			System.out.println(
					"There should only be 11 truncatable primes that are truncatable left to right and right to left, but you found "
							+ count);
		}
	}



}
