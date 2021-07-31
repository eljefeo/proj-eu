import java.math.BigInteger;

public class Problem55 implements Problem { //Took 0.082786 seconds

	/*
	 * If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
	 * 
	 * Not all numbers produce palindromes so quickly. For example,
	 * 
	 * 349 + 943 = 1292, 1292 + 2921 = 4213 4213 + 3124 = 7337
	 * 
	 * That is, 349 took three iterations to arrive at a palindrome.
	 * 
	 * Although no one has proved it yet, it is thought that some numbers, like 196,
	 * never produce a palindrome. A number that never forms a palindrome through
	 * the reverse and add process is called a Lychrel number. Due to the
	 * theoretical nature of these numbers, and for the purpose of this problem, we
	 * shall assume that a number is Lychrel until proven otherwise. In addition you
	 * are given that for every number below ten-thousand, it will either (i) become
	 * a palindrome in less than fifty iterations, or, (ii) no one, with all the
	 * computing power that exists, has managed so far to map it to a palindrome. In
	 * fact, 10677 is the first number to be shown to require over fifty iterations
	 * before producing a palindrome: 4668731596684224866951378664 (53 iterations,
	 * 28-digits).
	 * 
	 * Surprisingly, there are palindromic numbers that are themselves Lychrel
	 * numbers; the first example is 4994.
	 * 
	 * How many Lychrel numbers are there below ten-thousand?
	 */

	public static void main(String[] args) {
		// BigInteger b = new BigInteger("1234215");
		// System.out.println(addReverseBigInt(b));

		Problem p = new Problem55();
		p.runProblem();

	}

	public String problem() {
		//int sn = 196; // This is a lychrel number (well it seems to be at least... nothing has been proven)
		int maxIterations = 50;
		int maxNum = 10000;
		int counter = 0;
		for(int i = 1; i < maxNum; i++) {
			if(isLychrelNumber(i, maxIterations)) {
				counter++;
			}
		}
		System.out.println("Count of Lychrel numbers below " + maxNum + " is ::: " + counter);
		return "" + counter;
	}

	private static boolean isLychrelNumber(int n, int howManyIterationsToCheck) {
		BigInteger bn = new BigInteger("" + n);
		for (int i = 1; i < howManyIterationsToCheck; i++) { // this will be 50 instead of 10, just starting with 10 to test size of these things
			bn = Util.reverseDigitsThenAdd(bn);
			if (Util.isPalindromeString(bn.toString())) {
				return false;
			}
		}
		return true;
	}

	

}
