
public class Problem37 implements Problem {
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
		Problem p = new Problem37();
		p.runProblem();
	}

	public String problem() {
		int max = 1000000, sum = 0, count = 0, expectedPrimeCount = 11;
		
		for (int i = expectedPrimeCount; i < max; i++) {
			if (Util.isTruncatablePrimeBackwardsAndForwards(i)) {
				System.out.println("is truncatable prime : " + i);
				sum += i;
				count++;
			}
		}
		if (count == 11) {
			System.out.println("Found all " + count + " primes! :: Sum : " + sum);
																				 
		} else {
			System.out.println(
					"There should only be 11 truncatable primes that are truncatable left to right and right to left, how the hell did you find "
							+ count);
		}
		
		return "" + sum;
	}




}
