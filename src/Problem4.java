import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem4 {

	
/*	A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

			Find the largest palindrome made from the product of two 3-digit numbers.*/
	
	
	public static void main(String[] args) {
		
		problem();
	}
	
	public static void problem(){
		
		Set<Integer> palindromes = new HashSet<Integer>();
		
		int min = 100;
		int max = 999;
		for (int i = min; i <= max; i++){
			for (int j = min; j <= max; j++){
				int prod = i*j;
				String prodStr = prod + "";
				if(Util.isPalindromeString(prodStr)){
					palindromes.add(prod);
				}
				
			}
		}
		
		int largestPal = Collections.max(palindromes);
		System.out.println("Largest palindrome " + largestPal); 
	}
	
	

}
