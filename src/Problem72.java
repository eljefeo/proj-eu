import java.util.ArrayList;
import java.util.List;

public class Problem72 extends ProblemImpl { //Took 0.217028 seconds

	/*
	 * Consider the fraction, n/d, where n and d are positive integers. If n<d and
	 * HCF(n,d)=1, it is called a reduced proper fraction.
	 * 
	 * If we list the set of reduced proper fractions for d <= 8 in ascending order
	 * of size, we get:
	 * 
	 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3,
	 * 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
	 * 
	 * It can be seen that there are 21 elements in this set.
	 * 
	 * How many elements would be contained in the set of reduced proper fractions
	 * for d <= 1,000,000?
	 */
	
	/*
	 
	n	Relatively Prime	phi(n)	n/phi(n)
	2	1				1	2
	3	1,2				2	1.5
	4	1,3				2	2
	5	1,2,3,4			4	1.25
	6	1,5				2	3
	7	1,2,3,4,5,6		6	1.1666...
	8	1,3,5,7			4	2
	9	1,2,4,5,7,8		6	1.5
	10	1,3,7,9			4	2.5
	 
	 */

	public static void main(String[] args) {
		Problem p = new Problem72();
		p.runProblem();
	}

	public void problem() {

		int max =  1000000 + 1;
		long totalCounter = 0;
		
		List<Integer> primes = new ArrayList<Integer>();
		
		for (int i = 2; i < max; i++) {
			
			int phi = 1; // set to 1 because every number has 1 has a coprime?
			int tempI = i;
			int sqrt = (int)Math.sqrt(tempI);
			for (int p = 0; p < primes.size(); p++) {
				int prime = primes.get(p);
				if(prime > sqrt) 
					break;
				
				if (i % prime == 0) {
					phi *= (prime - 1);
					tempI = tempI / prime;
					while (tempI % prime == 0) {
						tempI /= prime;
						phi *= prime;
					}
					
					sqrt = (int)Math.sqrt(tempI);
				}
			}
			
			if(tempI == i) {
				phi = i-1;
				primes.add(i); 
			} else if(tempI > 1){
				phi *= (tempI - 1);
			}  
			
			totalCounter += phi;
		}
		
		System.out.println("Total: " + totalCounter);
		
	}

}
