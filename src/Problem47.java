import java.util.Set;

public class Problem47 {

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
		long startT = System.nanoTime();
		
		problem();
		
		long endT = System.nanoTime();
		double time = (double) (endT - startT)/1000000000;
		System.out.println("Took " + time + " seconds");
	}
	
	
	private static void problem(){
		int max = 1000000;
		//int max = 30;
		int numFactors = 4;
		for(int i = 20; i< max; i++){
			boolean found = true;
			int m = i+numFactors;
			for(; i<m; i++){
				Set<Integer> factors = Util.getDistinctPrimeFactors(i);
				if(factors.size() != numFactors){
					found = false;
					i++;
					break;
				}
			}
			if(found){
				i-=numFactors; // go backwards to the beginning of the winning nums;
				System.out.println("Win at i " + (i-numFactors));
				//The solution is done. This next snippet is just to print the solution and factors for information purposes...
				System.out.println("We found " + i + ", " + (i+1) + ", " + (i+2) + ", " + (i+3));
				for(int j=0; j<numFactors; j++){
					Set<Integer> factors = Util.getDistinctPrimeFactors(i+j);
					System.out.print("factors of " + (i+j) + " : ");
					for(Integer k : factors){
						System.out.print(k +" ");
					}
					System.out.println();
				}
				return;
			}
		}
	}

}
