import java.util.ArrayList;
import java.util.List;

public class TestAnything extends ProblemImpl{

	public static void main(String[] args) {
		//int test = 9, max = 1000000;
		
		
		new TestAnything().runProblem();
		//List<Integer> primesB = Util.getPrimesUnder(max);
		//testPrimeAccuracy();
	}
	
	public void problem() {
		int max = 10000000;
		List<Integer> primesB = Util.getPrimesUnder(max);
		System.out.println("Got this many primes : " + primesB.size() + " under " + max);
	}
	
	public void problem4() {
		int max = 10000000;
		List<Integer> primesB = Util.getPrimesUnderWithSqrt(max);
		System.out.println("Got this many primes : " + primesB.size() + " under " + max);
	}
	
	public void problem2() {
		int max = 1000000;
		List<Integer> primesA = new ArrayList<Integer>();
		for(int i=1; i<max; i++) {
			if(Util.isPrime(i)) {
				primesA.add(i);
			}
		}
		
		System.out.println("Got this many primes: " + primesA.size() + " under " + max);
		
	}
	
	public static void testPrimeAccuracy() {
		int max = 10000000;
		
		List<Integer> primesA = new ArrayList<Integer>();
		for(int i=1; i<max; i++) {
			if(Util.isPrime(i)) {
				primesA.add(i);
			}
		}
		
		List<Integer> primesB = Util.getPrimesUnder(max);
		
		if(primesA.size() != primesB.size()) {
			System.out.println("ERROR Incorrect size A=" + primesA.size() + " and B=" + primesB.size());
			return;
		}
		
		long aTot = 0, bTot = 0;
		
		for(int i = 0; i < primesA.size(); i++) {
			int pa = primesA.get(i), pb = primesB.get(i);
			aTot += pa;
			bTot += pb;
			if(pa != pb) {
				System.out.println("ERROR WRONG PRIMES A=" + pa + " and B=" + pb);
			}
		}
		
		System.out.println("Got this many primes \n: A = " + primesA.size() + " with totalA = " + aTot + " \n: B = " + primesB.size() + " with totalB = " + bTot);
		System.out.println("Totals equal eachother :  " + (aTot == bTot)); 
		
	}


	
}
