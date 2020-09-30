import java.util.ArrayList;
import java.util.List;

public class Problem26 {
/*	
	A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

		1/2	= 	0.5
		1/3	= 	0.(3)
		1/4	= 	0.25
		1/5	= 	0.2
		1/6	= 	0.1(6)
		1/7	= 	0.(142857)
		1/8	= 	0.125
		1/9	= 	0.(1)
		1/10	= 	0.1
		Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

		Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
		*/
		
	public static void main(String[] args) {
		problem();
		
	}
	public static void problem(){
		int biggestRemainderSet = 0;
		int biggestD = 0; // ;)
		for(int i=1; i<1000; i++){
			int remainderSize = getRepeatingDecimal(10,i);
			if(remainderSize > biggestRemainderSet){
				biggestRemainderSet = remainderSize;
				biggestD = i;
				System.out.println("New biggest set of remainders is size " + biggestRemainderSet + " for d=" + i);
			}
		}
		System.out.println("Biggest set of remainders " + biggestRemainderSet + " for d=" + biggestD);
	}
	private static int getRepeatingDecimal(int numerator, int denom){
		List<Integer> numerators = new ArrayList<Integer>();
		while (numerator != 0){
			numerators.add(numerator);
			int result = numerator/denom;
			int remainder = numerator%denom; 
			numerator = result != 0 ? remainder*10 : numerator *10;
			int numIndex = numerators.indexOf(numerator);
			if(numIndex != -1){
				//System.out.println("I think we are going to repeat, same numerator " + numerator);
				//System.out.println("Final Results for " + denom + ": " + (results.size() - repeatingIndex) + " = " + Arrays.toString(results.toArray()) + "\n");
				return numerators.size() - numIndex;
			}
		}
		return 0;
	}

}
