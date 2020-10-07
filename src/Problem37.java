
public class Problem37 {
/*
 The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, 
 and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
	
	
	public static void main(String[] args) {
		problem();
	}
	
	private static void problem(){
		int test = 3797;
		int dcount = Util.countDigits(test);
		boolean isAlwaysPrime = true;
		/**/
		int max = 1000000;
		int sum = 0;
		for(int i=0; i<max; i++){
			if(isTruncatablePrime(test)){
				System.out.println("is truncatable prime : " +i);
				sum += i;
			}
		}
		System.out.println("Sum : " + sum);
		
		//System.out.println(":is zero prime " + Util.isPrime(0));
		
		//System.out.println("test " + test + " : " + n + " Math.pow(10,dcount) " + Math.pow(10,dcount));
	}
	
	public static boolean isTruncatablePrime(int num){
		int dcount = Util.countDigits(num);
		int test = num;
		int test2 = num;
		
		
		
		for(int i=0; i<dcount; i++){
			test = test%(int)Math.pow(10,dcount-i);
			
			if(!Util.isPrime(test)){
				return false;
			}
			
			test2 = test2/10;
			if(test2 != 0 && !Util.isPrime(test2)){
				return false;
			}
			//System.out.println("test2 :: " + test2);
			
			
			
			
			
			/*if(!Util.isPrime(test) || !Util.isPrime(test2)){
				System.out.println("not prime " + test);
				return false; 
			}*/
		}
		return true;
	}
	


}
