
public class Problem36 {

	/*
	 * 
	 * The decimal number, 585 = 1001001001 (base)2 (binary), is palindromic in
	 * both bases.
	 * 
	 * Find the sum of all numbers, less than one million, which are palindromic
	 * in base 10 and base 2.
	 * 
	 * (Please note that the palindromic number, in either base, may not include
	 * leading zeros.)
	 * 
	 */

	public static void main(String[] args) {
		problem();
	}

	private static void problem() {
		int max = 1000000;
		int sum = 0;
		
		
		for (int i = 0; i < max; i++) {
			if (Util.isBinaryPalindromeNumber(i) && Util.isPalindromeString(i + "")) {
				sum += i;
			}
		}
		
		System.out.println("Sum of all numbers, less than one million, that are palindromic in base 10 and base 2 : " + sum);

	}

}
