
public class Problem46 {
	
	/*
	 It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
		
		9 = 7 + 2x1^2
		15 = 7 + 2x2^2
		21 = 3 + 2x3^2
		25 = 7 + 2x3^2
		27 = 19 + 2x2^2
		33 = 31 + 2x1^2
		
		It turns out that the conjecture was false.
		
		What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
	 */

	public static void main(String[] args) {
		long max = 1000000;
		for(long i = 9; i < max; i+=2){
			
			if(Util.isPrime(i)){
				continue; // only want composite numbers
			}
			
			boolean isMatch = true;
			for(long j=1; (2*Math.pow(j, 2)) < i-1; j++){
				long dif = i - (long)(2*Math.pow(j, 2));
				if(Util.isPrime(dif)){
					isMatch = false;  // this means it CAN be written as sum of a prime and twice a square.
					break;
				}
			}
			if(isMatch) { 
				System.out.println("Yay : " + i );
				return;
			}
			
		}

	}

}
