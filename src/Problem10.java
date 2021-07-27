import java.util.List;

public class Problem10 extends ProblemImpl { //Took 0.110249 seconds

/*	
	The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

			Find the sum of all the primes below two million.*/
	
	public static void main(String[] args) { 
		new Problem10().runProblem();
	}
	
	public void problem(){
		int max = 2000000;
		long runningTotal = 0;
		List<Integer> primes = Util.getPrimesUnder(max);
		for(int i : primes)
			runningTotal += i;
		System.out.println("Found: " + runningTotal);
	}
	
	public void problemOld(){
		
		//Found: 142913828922

		//Took 0.640592 seconds
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
