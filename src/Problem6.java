
public class Problem6 {

	public static void main(String[] args) {
		problem();

	}

	
	/*
	 * The sum of the squares of the first ten natural numbers is,
		
		1^2 + 2^2 + ... + 10^2 = 385
		The square of the sum of the first ten natural numbers is,
		
		(1 + 2 + ... + 10)^2 = 552 = 3025
		Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
		
		Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	 * 
	 */
	
	public static void problem(){
		
		int sqSum = 0;
		int sumSq = 0;
		int max = 100;

		for(int i = 1; i <= 100; i++){
			sqSum += (int) Math.pow(i, 2);
		}
		
		for(int i = 1; i <= 100; i++){
			sumSq += i;
		}
		sumSq = (int)Math.pow(sumSq,2);
		
		
		System.out.println("squared first then added: " + sqSum);
		System.out.println("Added first then squared: " + sumSq);
		System.out.println("Diff: " + (sumSq - sqSum));
		
	}
	
}
