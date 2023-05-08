import java.util.Set;

public class Problem12 implements Problem { // Took 0.215236 seconds
	/*
	 * 
	 * The sequence of triangle numbers is generated by adding the natural numbers.
	 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first
	 * ten terms would be:
	 * 
	 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
	 * 
	 * Let us list the factors of the first seven triangle numbers:
	 * 
	 * 1: 1 3: 1,3 6: 1,2,3,6 10: 1,2,5,10 15: 1,3,5,15 21: 1,3,7,21 28:
	 * 1,2,4,7,14,28 We can see that 28 is the first triangle number to have over
	 * five divisors.
	 * 
	 * What is the value of the first triangle number to have over five hundred
	 * divisors?
	 */

	public static void main(String[] args) {
		Problem p = new Problem12();
		p.runProblem();
	}


	@Override
	public Object problem() {

		int factorLimit = 500;
		int ind = 1;
		int biggestFactorSize = 0;
		while (true) {
			int tri = Util.getNthTriangleNumber(ind);
			Set<Integer> factors = Util.getDistinctFactorsInt(tri);
			if (factors.size() > factorLimit) {
				System.out.print("Found: " + tri + " with " + factors.size() + " factors");
				return tri;
			} else if (factors.size() > biggestFactorSize) {
				biggestFactorSize = factors.size();
				System.out.println("new largest: " + tri + " : with " + biggestFactorSize + " factors"); //just to log some interesting data
			}
			ind++;
		}

	}

}
