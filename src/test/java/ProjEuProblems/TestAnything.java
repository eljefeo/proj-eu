package ProjEuProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ProjEuUtil.Util;

public class TestAnything implements Problem{
	
	
	
	

	public static void main(String[] args) {
		
		Problem51 pp = new Problem51();
		
		
		//int test = 9, max = 1000000;
		long startT = System.nanoTime();
		
		//int[] n = new int[] {6,1,2,4,5,6,7,8};
		//System.out.println(fizzBuzz(500000));
		
		//String answer = "" + problem();
		long endT = System.nanoTime();
		double time = (double) (endT - startT) / 1000000000;
		System.out.printf("Took %f seconds\n", time);
		//System.out.printf("Answer : %s", answer);
		
		//new TestAnything().runProblem();
		
		
		//List<Integer> primesB = Util.getPrimesUnder(max);
		//testPrimeAccuracy();
		System.out.println("Class: " + pp.getClass().toString());
		//int classNum = Integer.parseInt(pp.getClass().toString().split("class Problem")[1]);
		System.out.println("dup digits: " + Util.intHasDuplicateDigits2(33));
		
		
	}
	
	 public static List<String> fizzBuzz(int n) {
	        //  String[] ret = new String[n];
	        List<String> ret = new ArrayList<String>();
	        for (int i=0; i<n; i++) {
	            //ret[i] = getNextNum(i+1);
	            ret.add(getNextNum(i+1));
	        }
	        
	        //return Arrays.asList(ret);
	        return ret;
	    }
	
    public static String getNextNum(int n){
        if(n % 3 == 0){
            if(n % 5 == 0){
                return "FizzBuzz";
            }
            return "Fizz";
        }
        if(n % 5 == 0){
            return "Buzz";   
        }
        return n + "";
    }
	
	public static boolean duplicate(int[] nums) {
		Set<Integer> s = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(!s.add(nums[i]))
				return true;
		}
		return false;
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

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
