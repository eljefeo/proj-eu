

public class Problem41 implements Problem{

	/*
	 We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
	 */
	
	public static void main(String[] args) { // TAKES 12 sec
		//int test = 1233334;
		//System.out.println("count digits : " + Util.countDigitsOld(test) + " vs " + Util.countDigits(test));
		
		Problem p = new Problem41();
		p.runProblem();
		//System.out.println("div : " + (3034/1000));
		
		
		
	}
	
	public String problem(){
		
		int solution = 0;
		// can we just do all pandigital numbers...
		for(int i=2; i<10; i++)
			for(Integer s : Util.makeAllPanditalNumsFromOneTo(i)) 
				if(Util.isPrime(s) && s > solution) 
					solution = s;
		
		//System.out.println("Max: " + solution);
		return "" + solution;
	}  

	public String problem2(){ //old slow way
		int test  = 6582143;
		/*boolean isNthDigitPandigital = isNthDigitPandigitalNumber(test);
		boolean isPrime = Util.isPrime(test);
		System.out.println(test + " is nth digit pandigital? " + isNthDigitPandigital);
		System.out.println(test + " is prime? " + isPrime);*/
		int max = 999999999;
		int solution = 0;
		int step = 10000000;
		for(int i=0; i<max; i++){
			
			if(i > step && i%step==0) System.out.println("At step " + i); // just to log progress as this thing runs
			
			if(!Util.isNthDigitPandigitalNumber(i) || !Util.isPrime(i)) {
				continue;
			}
			
			if(i > solution)
					solution = i;
		}
		System.out.println("Max? " + solution);
		return "" + solution;
	}
	

	


}
