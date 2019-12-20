
public class Problem10 {

/*	
	The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

			Find the sum of all the primes below two million.*/
	
	public static void main(String[] args) {
		problem();

	}
	
	public static void problem(){
		int max = 2000000;
		long runningTotal = 2;
		for(int i = 3; i < max; i+=2){
			if(Util.isPrime(i)){
				runningTotal += i;
			}
		}
		System.out.println("Found: " + runningTotal);
	}

}
