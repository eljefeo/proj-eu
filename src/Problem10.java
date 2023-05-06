import java.util.List;

public class Problem10 implements Problem{ //Took 0.065293 seconds

/*	
	The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

	Find the sum of all the primes below two million.
*/
	
	public static void main(String[] args) { 
		new Problem10().runProblem();
	}
	
	public Object problem(){
		int max = 2000000;
		long runningTotal = 0;
		List<Integer> primes = Util.getPrimesUnder(max);
		for(int i : primes)
			runningTotal += i;
		
		return runningTotal;
	}
	
	
}
