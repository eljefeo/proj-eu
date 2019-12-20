import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Problem7 {

	public static void main(String[] args) {
		problem();

	}
	
	/*
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

		What is the 10 001st prime number?
	 */
	
	public static void problem(){
		
		
		List<Long> primes = new ArrayList<Long>();
		
		primes.add((long) 2);
		
		int maxSize = 10001;
		long testNumber = 2;
		while(primes.size() < maxSize){
			testNumber++;
			if(Util.isPrime(testNumber)){
				primes.add(testNumber);
			}
		}
		
		System.out.print("Found " + primes.get(primes.size()-1));
		
		
	}
	


}
