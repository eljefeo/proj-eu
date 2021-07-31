import java.util.ArrayList;
import java.util.List;

public class Problem34 implements Problem  {
		/*
		 
		 
		 
		 
		145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
		
		Find the sum of all numbers which are equal to the sum of the factorial of their digits.
		
		Note: As 1! = 1 and 2! = 2 are not sums they are not included.
		 
		 
		 */
	
	
	
	
	public static void main(String[] args) {
		
		Problem p = new Problem34();
		p.runProblem();
		
		
		//int test = 9999;
		//int i = 10;
		//while(true){
			//int sum = Util.sumOfDigitFactorial(i++);
			//if(sum < i){
				//System.out.println("sum of "+i+" = " + sum + " and is greater? " + (sum<i));
			//}
		//}
		
		
	}
	
	public String problem(){
		List<Long> sols = new ArrayList<Long>();
		int max = 9999999;
		for(long i=3; i<max; i++){
			long sum = Util.sumOfDigitFactorial(i);
			if(sum == i){
				sols.add(i);
			}
			
		}
		
		long total = 0;
		for(Long l : sols){
			System.out.println("sol : " + l);
			total += l;
		}
		//System.out.println("Sum of all : " + total);
		return "" + total;
	}

}
