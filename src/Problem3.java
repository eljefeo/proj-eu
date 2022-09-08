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
	
		System.out.println("\n2:");
		long goal = 600851475143l;
		for(int i = 3; i < 70; i++) {
			
			long startT = System.nanoTime();
			long p1 = Problem3.problem2(i);
			long endT = System.nanoTime();
			double time = (double) (endT - startT) / 1000000000;
			
			long startT2 = System.nanoTime();
			long p2 = Problem3.problem2s(i);
			long endT2 = System.nanoTime();
			double time2 = (double) (endT2 - startT2) / 1000000000;
			System.out.println();
			System.out.printf(i + " " + (time > time2 ? " p1 took longer\n" : "p2 took longer\n") );
			
			if(p1 == p2) {
				
			
			//System.out.printf(i + " equals " + (p1 == p2) + " :: " + (time > time2 ? " p1 took longer" : "p2 took longer") );
			} else {
				long real = problemOrig(i);
				
				System.out.println(i + " FALSE!! p1: " + p1 + ", p2: " + p2 + " :: real: " + real);
				if(p1 == real) {
					System.out.println(i + " p2 is wrong ");
				} else if(p2 == real) {
					System.out.println(i + " p1 is wrong ");
				} else {
					System.out.println(i + " !!!!!! p1 and p2 are wrong ");
				}
			}
		}
		
		int primeTest = 15017;
		Problem3.problem2(primeTest);
		System.out.println("is prime " + primeTest + " : " + Util.isPrime(primeTest));
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
		
		
		//Test if even
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
	
	public static long problemOrig(long goal){
		// if a number is not prime, it is a composite number.
		// all composite numbers have at least 1 prime factor that is less than or equal to the number's square root
		//if a number has a prime factor less than or equal to its square root, it is not prime.
		
		
		Set<Long> primes = new HashSet<Long>();
		primes.add((long) 2);
		
		List<Long> factors = new ArrayList<Long>();
	
		long test = 1855;
		System.out.println("Doing number: " + test); 
		//long goal = 600851475143l;
		test = goal;
		
		
		//Test if even
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
		
		return largest;
		
	}
	
	public static long problem2(long goal){
	
		long largest = 0;
		if(goal % 2 == 0) {
			largest = 2;
			while(goal%2==0){
				goal /= 2;
			}
		}
		
		long sqrt = (long) Math.sqrt(goal);
		//System.out.println("sqrt = " + sqrt);
		loop:
		for(long i = 3; sqrt > i; i+=2){
			
			while(goal%i==0){
				goal /= i;
				largest = i;
				if(goal == 1) {
					break loop;
				}	
			}	
		}
		
		if(goal > 1){
			largest = goal;
		}
		
		return largest;
	}
	
	public static long problem2s(long goal){
		
		long largest = 0;
		if(goal % 2 == 0) {
			largest = 2;
			while(goal%2==0){
				goal /= 2;
			}
		}
		
		//long sqrt = (long) Math.sqrt(goal);
		//System.out.println("sqrt = " + sqrt);
		loop:
		for(long i = 3; Math.sqrt(goal) > i; i+=2){
			
			while(goal%i==0){
				goal /= i;
				largest = i;
				if(goal == 1) {
					break loop;
				}	
			}	
		}
		
		if(goal > 1){
			largest = goal;
		}
		
		return largest;
	}
	


}
