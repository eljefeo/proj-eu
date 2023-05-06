import java.util.List;

public class Problem5 implements Problem { // Took 0.001103 seconds

	
	/*
	 * 
	 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

		What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 * 
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem5();
		p.runProblem();
		
	}

	public String problem(){

		/*
		 to get the num that is divisible by all numbers below 20
		 we need to get all the prime factors of each number
		 and multiply by the highest number of each factor
		 
		 so 20 for example has prime factors of 2, 2, 5
		 and 10 has prime factors of  2, 5
		 
		 so we need a number with 2, 2, 5 at least
		 
		but then 16 has 2, 2, 2, 2
		so we need at least four 2's (instead of just the two 2's from 20)
		 
		 we essentially get all prime factors of each num
		 then get the highest count of prime factors for each prime
		 multiply them all together to get our number
		 */
		
		int max = 21;
		List<Integer> primes = Util.getPrimesUnder(max);
		
		int[] primeCounts = new int[max];
		
		for(int i = 2; i < max; i++) {
			
			int t = i;
			int[] tempCount = new int[max];
			for(Integer p : primes) {
				if(p > Math.sqrt(t)) {
					tempCount[t]++;
					break;
				}
				while(t % p == 0) {
					tempCount[p]++;
					t /= p;
				}
			}
			
			for(int j=0; j < tempCount.length; j++) 
				if(tempCount[j] > primeCounts[j]) 
					primeCounts[j] = tempCount[j];
		}
		
		int tot = 1;
		for(int i=0; i< primeCounts.length; i++) 
			if(primeCounts[i] > 0)
				tot *= Math.pow(i, primeCounts[i]);
		
		//System.out.println("Found : " + tot);
		return "" + tot;
	}
	
	
	
	public void problemOldSlow(){
		
		boolean found = false;
		
		int ind = 0;
		while(!found){
			ind++;
			boolean bad = false;
			for(int i=1; i <= 20; i++){
				if(ind%i!=0){
					bad = true;
					break;
				}
			}
			if(!bad){
				found = true;
			}
			
		}
		System.out.println("Found : " + ind);
	}

}
