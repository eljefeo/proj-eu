
public class Problem41 extends ProblemImpl{

	/*
	 We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
	 */
	
	public static void main(String[] args) { // TAKES 12 sec
		Problem p = new Problem41();
		p.runProblem();
	}
	
	public void problem(){
		int test  = 6582143;
		/*boolean isNthDigitPandigital = isNthDigitPandigitalNumber(test);
		boolean isPrime = Util.isPrime(test);
		System.out.println(test + " is nth digit pandigital? " + isNthDigitPandigital);
		System.out.println(test + " is prime? " + isPrime);*/
		int max = 99999999;
		int solution = 0;
		int step = 10000000;
		for(int i=0; i<max; i++){
			
			if(i > step && i%step==0) System.out.println("At step " + i);
			
			if(!Util.isNthDigitPandigitalNumber(i) || !Util.isPrime(i)) {
				continue;
			}
			
			if(i > solution)
					solution = i;
		}
		System.out.println("Max? " + solution);
	}
	

	


}
