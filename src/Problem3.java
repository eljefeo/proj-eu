import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3 implements Problem {
	
/*	The prime factors of 13195 are 5, 7, 13 and 29.

	What is the largest prime factor of the number 600851475143 ?*/

	public static void main(String[] args) {
		Problem p = new Problem3();
		p.runProblem();
	
		//squareRootOf(47);

	}
	
	@Override
	public String problem(){
		// if a number is not prime, it is a composite number.
		// all composite numbers have at least 1 prime factor that is less than or equal to the number's square root
		//if a number has a prime factor less than or equal to its square root, it is not prime.
		
		
		Set<Long> primes = new HashSet<Long>();
		primes.add((long) 2);
		
		List<Long> factors = new ArrayList<Long>();
	
		long test = 1855;
		System.out.println("Doing number: " + test); 
		long goal = 600851475143l;
		test = goal;
		
		
		//Test if prime
		if(test%2==0){
			factors.add((long) 2);
			while(test%2==0){
				
				test /= 2;
				System.out.println("test / 2 : " + test);
			}
		}
		
		System.out.println("After getting rid of evens: " + test);
		
		
		for(long i = 3; i <= Math.sqrt(test); i+=2){
			while(test%i==0){
				test /= i;
				factors.add(i);
			}
			
		}
		// end test prime
		
		if(test > 2){
			factors.add((long) test);
		}
		
		System.out.println("Prime Factors: ");
		long largest = 0;
		for(Long lon : factors){
			if(lon > largest)
				largest = lon;
			//System.out.print(lon + " ");
		}
		
		return "" + largest;
		
	}
	


}
