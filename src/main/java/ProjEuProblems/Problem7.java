package ProjEuProblems;
import java.util.ArrayList;
import java.util.List;

import ProjEuUtil.Util;

public class Problem7 implements Problem { //Took 0.014207 seconds

	public static void main(String[] args) {
		Problem p = new Problem7();
		p.runProblem();

	}
	
	/*
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

		What is the 10 001st prime number?
	 */
	
	public String problem(){
		int prime = Util.getNthPrimeNumber(10001);
		System.out.println(prime);
		return "" + prime;
	}
	
	public String problemOrig(){
		
		
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
		
		//System.out.print("Found " + primes.get(primes.size()-1));
		
		return "" + primes.get(primes.size()-1);
	}

}
