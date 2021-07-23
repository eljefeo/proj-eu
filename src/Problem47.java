import java.util.List;

public class Problem47 extends ProblemImpl {

	/*
	 The first two consecutive numbers to have two distinct prime factors are:

		14 = 2 x 7
		15 = 3 x 5
		
		The first three consecutive numbers to have three distinct prime factors are:
		
		644 = 2^2 x 7 x 23
		645 = 3 x 5 x 43
		646 = 2 x 17 x 19.
		
		Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
			 
	 */
	public static void main(String[] args) {
		Problem p = new Problem47();
		p.runProblem();
	}
	
	public void problem(){
		
		int howManyFactors = 4, howManyConsecutive = 4, i = 20;
		List<Integer> primes = Util.getPrimesUnder(i);
		
			doit:
			for(int m = i+howManyConsecutive; i<m; i++){
				// we pretty much just start counting the prime factors of i
				// we keep track of primes as we go, so finding factors is just go through the list of primes to see if they are a factor
				// we keep extending the condition of the for loop. That way the only way out of the for loop is to solve the problem
				int temp = i, factCount = 0;
				for(Integer p : primes) {
					if(p > Math.sqrt(temp)) {
						if(factCount == 0) {
							primes.add(i);
							m = i+howManyConsecutive+1;
							continue doit;
						} else if(temp > 1) {
							factCount++; 
						}
						break;
					}
					if(temp % p == 0) {
						factCount++;
						if(factCount > 4) {
							m = i+howManyConsecutive+1;
							continue doit;
						}
						
						while(temp % p == 0)
							temp /= p;
					}
				}
				
				if(factCount != howManyFactors) {
					m = i+howManyConsecutive+1;
					continue doit;
				}
			}
			
			System.out.println("First prime (of " + howManyConsecutive + " consecutive) to have " + howManyFactors + " factors: " + (i-howManyConsecutive));

	}


}
