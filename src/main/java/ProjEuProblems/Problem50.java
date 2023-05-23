package ProjEuProblems;
import java.util.List;

import ProjEuUtil.Util;

public class Problem50 implements Problem {

	/*
	The prime 41, can be written as the sum of six consecutive primes:

		41 = 2 + 3 + 5 + 7 + 11 + 13
		This is the longest sum of consecutive primes that adds to a prime below one-hundred.

		The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

		Which prime, below one-million, can be written as the sum of the most consecutive primes?
	*/
	
	public static void main(String[] args) {
		Problem p = new Problem50();
		p.runProblem();
		
		
	}
	
	public String problem(){
		int end1 = 1000000;
		int bestPCount = 0;
		int bestPrime = 0;
		for(int i=2; i<end1; i++){

			if(i * bestPCount > end1)
				break; // if this num * the amount of primes we need to beat the new record is > than the max
			// then we will go over, we can just stop
			
			
			if(Util.isPrime(i)){
				
				
				
				int sum = i;
				int pC = 1;
				//for(int j=i+1; (sum+j)<end; j++){ // this will find 41 also (largest sum of consecutive primes below 100) but does many more calculations after 41
				for(int j=i+2; (sum+j)<end1; j+=2){ // this will not find 41 but will skip even numbers to save on unnecessary processing 
					if(Util.isPrime(j)){
						sum+=j;
						pC++;
						if(Util.isPrime(sum)){
							if(pC > bestPCount){
								bestPCount = pC;
								bestPrime = sum;
								//System.out.println("New longest consecutive primes sum to a prime of " + bestPrime + " primes : " + bestPCount);
							}
						}
					}
				}
			}
		}
		//System.out.println("\n*******\nFinal Answer ::: longest consecutive primes that also sum to a prime is " + bestPrime + " with a prime count of: " + bestPCount);
		return "" + bestPrime;
	}
	
	public void problemOtherTriedAndTooSlowCouldntFinish(){
		int end1 = 1000000; //, end2 = end1 / 2;
		int step = end1/10;
		int bestPCount = 0;
		int bestPrime = 0;
		
		int sum = 0;
		List<Integer> primes = Util.getPrimesUnder(end1);
		
		
		//for(int i=0; i < primes.size(); i++) {
		//	sum+= primes.get(i);
		//	System.out.println("prime with running sum " + primes.get(i) + " :: " + sum);
		//}
		//sum = 0;
		System.out.println("Done getting " + primes.size() + " under " + end1);
		for(int i=0; i<primes.size() - bestPCount; i++){
			 
			
			
			int p = primes.get(i);
			
			if(p*bestPCount+(2*bestPCount) > end1) {
				System.out.println("Breaking at " + i + " with p " + p + " = " + (p*bestPCount));
				break;
			}
			
			//System.out.println("sum primes left " + getTotalPrimeSumLeft(primes, i));
			//if(i % step == 0)
				//System.out.println("At i=" + i);
			
			sum = p;
			//System.out.println("start i=" + i + " p=" + p + " sum=" + sum + " with primes left:" + (primes.size()-i+1));
			//int newI = i;
			int c = 1;
			
			for(int j=i+1; j<primes.size(); j++){
				
				//if(j % 100 == 0)
					//System.out.println("At j=" + j);
				int pp = primes.get(j);
				
				sum += pp;
				if(sum > end1)
					break;
				
				c++;
				if(primes.contains(sum) && c > bestPCount) {
					
					bestPrime = sum;
					bestPCount = c;
					System.out.println("new sum? i=" + i + " bestPCount=" + bestPCount + " sum=" + sum);
					
				}
				
			}
			
			
			//while(newI < primes.size()-1 && (sum += primes.get(++newI)) < end1 && !Util.isPrime(sum)) {
			//	c++;
			//}
			//System.out.println("done i with c="+c + " and sum="+ sum + " newI=" + newI);
			//sum -= primes.get(newI);
			//if(c > bestPCount) {
			///	bestPrime = sum;
			//	bestPCount = c;
			//	System.out.println("new sum? i=" + i + " bestPCount=" + bestPCount + " sum=" + sum);
			//}
			
		}
		
		System.out.println("bestPCount=" + bestPCount + " bestPrime=" + bestPrime);
		
		
		//System.out.println("\n*******\nFinal Answer ::: longest consecutive primes that also sum to a prime is " + bestPrime + " with a prime count of: " + bestPCount + " with startPrime = " + startPrime);
	}
	
	public static int getTotalPrimeSumLeft(List<Integer> primes, int ind) {
		int sum = 0;
		for(int i=ind; i<primes.size(); i++) {
			sum += primes.get(i);
		}
		return sum;
	}
	
	
}
