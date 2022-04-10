import java.util.ArrayList;
import java.util.List;

public class TestAnything implements Problem{

	public static void main(String[] args) {
		//int test = 9, max = 1000000;
		
		
		new TestAnything().runProblem();
		//List<Integer> primesB = Util.getPrimesUnder(max);
		//testPrimeAccuracy();
	}
	
	//public String problem() {
	public String problemFacts() {	
		int n = 24;
		List<Integer> facts = Util.getPrimeFactors(n);
		
		for(int i : facts) {
			System.out.println("Factor : " + i);
		}
		
		return "";
		
	}
	
	public String problem() {
	//public String problem() {
		int max = 70000;
		List<Integer> primesB = Util.getPrimesUnder(max);
		System.out.println("Got this many primes : " + primesB.size() + " under " + max);
		for(Integer p : primesB) {
			if(p > 40000) {
				System.out.println("Prime : " + p);
			}
		}
		return "";
	}
	
	//public String problemTestPrimesUnder2() {
	public String problemSqrtPrimes() {
		int max = 10000000;
		List<Integer> primesB = Util.getPrimesUnderWithSqrt(max);
		System.out.println("Got this many primes : " + primesB.size() + " under " + max);
		return "";
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
