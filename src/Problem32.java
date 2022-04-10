import java.util.ArrayList;
import java.util.List;

public class Problem32 implements Problem  { //Took 0.890304 seconds - can probably be optimized, just stopped when < 1sec

	/*
	 * We shall say that an n-digit number is pandigital if it makes use of all
	 * the digits 1 to n exactly once; for example, the 5-digit number, 15234,
	 * is 1 through 5 pandigital.
	 * 
	 * The product 7254 is unusual, as the identity, 39 x 186 = 7254, containing
	 * multiplicand, multiplier, and product is 1 through 9 pandigital.
	 * 
	 * Find the sum of all products whose multiplicand/multiplier/product
	 * identity can be written as a 1 through 9 pandigital.
	 * 
	 * HINT: Some products can be obtained in more than one way so be sure to
	 * only include it once in your sum.
	 * 
	 */
	
	
	// I think we could optimize this, but it is just under 1 second. 
	//Barely though, might need to speed it up a bit just in case
	
	public static void main(String[] args) { 
		Problem p = new Problem32();
		p.runProblem();
	}

	public String problem() {
		List<Integer> foundNums = new ArrayList<Integer>();
		int max = 10000;
		int step = 1000; // just used for logging
		for (int i = 10; i < max; i++) {
			if(i > step && i % step == 0){
				System.out.println("Currently at : " + i); // just logging...
			}
			if(Util.intHasAZeroInIt(i) || Util.intHasDuplicateDigits(i)){
				continue; // skip if there is a zero or more than 1 of any digit (this is already not pandigital)
			}
			
			int[] numDigits = Util.splitIntNumsToArray(i);
			int[] rest = Util.getMissingDigits1Through9(numDigits);
			int numOfCombos = Util.factorial(rest.length);
			int[][] combosInput = new int[numOfCombos][];
			int[][] combos = Util.getAllCombinationsInt(combosInput, new int[0], rest, 0);

			for (int[] arr : combos) {
				if (Util.hasPandigitalIdentity(arr, i)) {
					foundNums.add(i);
					break;
				}
			}
		}
		
		System.out.println("Solutions:");
		Util.printListInteger(foundNums);
		int total = 0;
		for(Integer i : foundNums){
			total += i;
		}
		//System.out.println("Total: " + total);
		return "" + total;
	}


	
}
