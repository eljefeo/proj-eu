import java.util.ArrayList;
import java.util.List;

public class Problem125 {
	/*
	 * 
	 * 
	 * The palindromic number 595 is interesting because it can be written as the sum of consecutive squares: 6^2 + 7^2 + 8^2 + 9^2 + 10^2 + 11^2 + 12^2.

There are exactly eleven palindromes below one-thousand that can be written as consecutive square sums, and the sum of these palindromes is 4164. Note that 1 = 0^2 + 1^2 has not been included as this problem is concerned with the squares of positive integers.

Find the sum of all the numbers less than 10^8 that are both palindromic and can be written as the sum of consecutive squares.
	 */

	public static void main(String[] args) {
		problem();
		
		addConsecutiveSquaresFromTo(25,26);
		
	}

	private static void problem() {

		//int maxSum = 1000;
		int power = 8;
		int maxSum = (int) Math.pow(10, power);
		int maxI = (int) Math.sqrt(maxSum) + 1; //(sqr root of 1000)
		System.out.println("Max i : " + maxI);
		List<Integer> palindromicSums = new ArrayList<Integer>();
		
		int i = 1;
		int oldI = i;
		int sum = 0;
		while(i < maxI) {
			
			//System.out.println("Starting with i: " + i);
			int startI = i;
			while(sum < maxSum) {
				
				
					
				
				sum += Math.pow(i, 2);
				
				
				if(i > oldI && sum > 1 && sum < maxSum && Util.isPalindromeInt(sum)) {
					System.out.println("Found a palindrome sum : " + sum + " - with starting i:"+ startI + " and end i: " + i);
					palindromicSums.add(sum);
				}
				
				i++;
				
			}
			
			oldI++;
			i = oldI;
			sum = 0;
			
		}
		
		long finalSum = 0;
		
		for(Integer pal : palindromicSums) {
			System.out.println("All sums : " + pal);
			finalSum += pal;
		}
		System.out.println("Final Sum ::: " + finalSum);
	}
	
	
	private static void addConsecutiveSquaresFromTo(int start, int end) {
		long sum = 0;
		for(int i = start; i <= end; i++) {
			long isq = (long) Math.pow(i, 2);
			System.out.println("Adding " + i + "squared (" + isq + ") to sum " + sum + " - which now makes " + (sum+isq) );
			sum += isq;
		}
		System.out.println("Sums to : " + sum);
	}
	
	
}
