
public class Problem50 {

	/*
	The prime 41, can be written as the sum of six consecutive primes:

		41 = 2 + 3 + 5 + 7 + 11 + 13
		This is the longest sum of consecutive primes that adds to a prime below one-hundred.

		The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

		Which prime, below one-million, can be written as the sum of the most consecutive primes?
	*/
	public static void main(String[] args) {
		problem();
	}
	
	private static void problem(){
		//int sum = 0;
		//int pCounter = 0;
		int end = 1000000;
		int bestPCount = 0;
		int bestPrime = 0;
		for(int i=2; i<end; i++){
			
			if(Util.isPrime(i)){
				//System.out.println("Starting with prime " + i);
				int sum = i;
				int pC = 1;
				for(int j=i+1; (sum+j)<end; j++){
					if(Util.isPrime(j)){
						sum+=j;
						pC++;
						if(Util.isPrime(sum)){
							if(pC > bestPCount){
								bestPCount = pC;
								bestPrime = sum;
								System.out.println("New longest consecutive primes sum to a prime of " + bestPrime + " primes : " + bestPCount);
							}
						}
					}
				}
				
				
			}
		}
		System.out.println("\n*******\nFinal Answer ::: longest consecutive primes sum to a prime is " + bestPrime + " with a count of: " + bestPCount);
	}
	
/*	public static List<Integer> getLotsOfConsecutivePrimes(){
		
	}*/

}
