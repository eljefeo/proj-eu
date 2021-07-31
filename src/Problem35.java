

/*
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
 * 
 * 
 */
public class Problem35 implements Problem {
	
	public static void main(String[] args){
		Problem p = new Problem35();
		p.runProblem();
	}
	
	public String problem(){
		int max = 1000000;
		int counter = 0;
		//System.out.println("Is Cir Prime : " + 5 + " : " +  Util.isCircularPrime(a));
		
		for(int i=2; i<max; i++){
			if(Util.isCircularPrime(i)){
				System.out.println("cirprime: " + i);
				counter++;
			}
		}
		
		//System.out.println("Found : " + counter);
		return "" + counter;
	}
	
}
