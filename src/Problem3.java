

public class Problem3 implements Problem {
	
/*	The prime factors of 13195 are 5, 7, 13 and 29.

	What is the largest prime factor of the number 600851475143 ?*/

	public static void main(String[] args) {
		Problem p = new Problem3();
		p.runProblem();
	}
	
	
	
	@Override
	public String problem(){
		// if a number is not prime, it is a composite number.
		// all composite numbers have at least 1 prime factor that is less than or equal to the number's square root
		//if a number has a prime factor less than or equal to its square root, it is not prime.
		long goal = 600851475143l;
		long answer = Util.getLargestPrimeFactor(goal);
		
		return "" + answer;
		
	}
}
