import java.util.HashSet;
import java.util.Set;

public class Problem125 extends ProblemImpl{
	/*
	 * 
	 * 
	 * The palindromic number 595 is interesting because it can be written as the sum of consecutive squares: 6^2 + 7^2 + 8^2 + 9^2 + 10^2 + 11^2 + 12^2.

There are exactly eleven palindromes below one-thousand that can be written as consecutive square sums, and the sum of these palindromes is 4164. 
Note that 1 = 0^2 + 1^2 has not been included as this problem is concerned with the squares of positive integers.

Find the sum of all the numbers less than 10^8 that are both palindromic and can be written as the sum of consecutive squares.
	 */

	public static void main(String[] args) {
		Problem p = new Problem125();
		p.runProblem();
		
		//Util.addConsecutiveSquaresFromTo(9,118);
		
	}

	@Override
	public void problem() {

		int power = 8;
		int maxSum = (int) Math.pow(10, power);
		int maxI = (int) Math.sqrt(maxSum); //(sqr root of 10^power - wont need to go above this number, as this will be too big for the sum)
		System.out.println("Max i : " + maxI);
		
		Set<Integer> palSums = new HashSet<Integer>(); // use a set to not allow duplicates (some can be formed with multiple combinations of square sums, 
						//we only want to know if a number can be summed up with consecutive squares, not how many ways can it be summed up with consecutive squares
		
		long finalSum = 0;
		int i = 1;
		int oldI = i;
		int sum = 0;
		while(i < maxI) {
			while(sum < maxSum) { 
				sum += (i*i);
				if(i > oldI && sum < maxSum && Util.isPalindromeInt(sum)) { 
					if(palSums.add(sum)) { // true if not a duplicate
						finalSum += sum;
					}
				}
				i++;
			}
			oldI++;
			i = oldI;
			sum = 0;
		}
		
		System.out.println("Final Sum from " + palSums.size() + " nums ::: " + finalSum);
	}
	
	
	
	
	
}
