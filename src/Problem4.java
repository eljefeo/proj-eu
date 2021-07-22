import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem4 extends ProblemImpl{

	
/*	A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

			Find the largest palindrome made from the product of two 3-digit numbers.*/
	
	
	public static void main(String[] args) {
		
		Problem p = new Problem4();
		p.runProblem();
	}
	
	public void problem(){
		
		Set<Integer> palindromes = new HashSet<Integer>();
		
		int min = 100;
		int max = 999;
		int largest = 0;
		for (int i = min; i <= max; i++){
			for (int j = min; j <= max; j++){
				int prod = i*j;
				if(Util.isPalindromeInt(prod) && prod > largest){
					largest = prod;
				}
			}
		}
		
		System.out.println("Largest palindrome " + largest); 
	}
	
	

}
