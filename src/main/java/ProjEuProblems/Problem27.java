package ProjEuProblems;

import ProjEuUtil.Util;

public class Problem27 implements Problem {
	
	/*
	 Euler discovered the remarkable quadratic formula: n^2 + n + 41
	 It turns out that the formula will produce 40 primes for the consecutive integer values 0 <= n <= 39
	 
	 However, when n=40  is divisible by 41, and certainly when n=41 is clearly divisible by 41.
	 
	 The incredible formula n^2 - 79n + 1601 was discovered, which produces 80 primes for the consecutive values 0 <= n <= 79
	 The product of the coefficients -79 and 1601 is -126479
	 
	 
	 Considering quadratics of the form:
	 n^2 + an + b
	 where absolute value of a is <1000 and absolute value of b is <1000
	 
	 Find the product of the coefficients a and b  for the quadratic expression 
	 that produces the maximum number of primes for consecutive values of n starting with n=0
	 
	 
	 
	 */

	public static void main(String[] args) {
		Problem p = new Problem27();
		p.runProblem();
	
		/*int n=0;
		while(n< 1000){
			n++;
			boolean isp = primes0toIDK(-999,61, n);
			long val = (long)Math.pow(n, 2) + (61*n) -999;
			if(!isp){System.out.println("NOT is prime " + n ); break;}
			else{System.out.println(n + "("+val+") is prime ");}
		}*/
		

	}
	 
	@Override
	public Object problem(){
		int a = -1000;
		int b = -1000;
		int oldb = -1000;
		
		int maxA = 999;
		int maxB = 1000;
		int winningA = 0;
		int winningB = 0;
		
		int bestPCount = 0;
		
		while(a<maxA){
			a++;
			b=oldb;
			while (b<maxB){
				b++; 
				int n = -1;
				while(true){
					n++;
					long val = (long)Math.pow(n, 2) + (a*n) + b;
					if(!Util.isPrime(val)) break;
				}
				if(n > bestPCount){
					bestPCount = n;
					winningA = a;
					winningB = b;
					//System.out.println("New Best PCount : " + n + "\t for n=" + n + " b=" + b + " a=" + a + " and product a*b = " + (a*b));
					
				} /*else if(n == bestPCount){
					System.out.println("SAME TIED Best PCount : " + n + "\t for n=" + n + " b=" + b + " a=" + a + " and product a*b = " + (a*b));
				}*/
			}
		}
		
		
		//System.out.println("Best PCount : " + bestPCount + " with product of a*b : " + (winningA*winningB));
		
		return (winningA*winningB);
	}
	private static void primes1to39(int n){
		long val = (long)Math.pow(n, 2) + n + 41;
		
		if(Util.isPrime(val)){
			System.out.println("Prime! : " + val + "\t\t with n="+n);
		} else {
			System.out.println("Not Prime :(  " + val + "\t\t with n="+n);
		}
	}
	
	private static void primes1to79(int n){


		long val = (long)Math.pow(n, 2) - (79*n) + 1601;
		
		if(Util.isPrime(val)){
			System.out.println("Prime! : " + val + "\t\t with n="+n);
		} else {
			System.out.println("Not Prime :(  " + val + "\t\t with n="+n);
		}
	}
	
	

}
