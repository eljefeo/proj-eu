import java.util.HashSet;
import java.util.Set;

public class Problem33 implements Problem  { //Took 0.002508 seconds
	/*
	 * The fraction 49/98 is a curious fraction, as an inexperienced
	 * mathematician in attempting to simplify it may incorrectly believe that
	 * 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
	 * 
	 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
	 * 
	 * There are exactly four non-trivial examples of this type of fraction,
	 * less than one in value, and containing two digits in the numerator and
	 * denominator.
	 * 
	 * If the product of these four fractions is given in its lowest common
	 * terms, find the value of the denominator.
	 */

	public static void main(String[] args) {
		Problem p = new Problem33();
		p.runProblem();
	}
	
	public String problem() {

		double a = 4;
		double b = 8;
		System.out.println("here " + (a / b));

		Set<int[]> sols = new HashSet<int[]>();

		for (double n = 11; n < 100; n++) {
			for (double d = n; d < 100; d++) {
				if (n % 10 == 0 || n == d) {
					continue;
				}
				
				double n1 = (int) (n / 10) % 10;
				double n2 = (int) n % 10;
				double d1 = (int) (d / 10) % 10;
				double d2 = (int) d % 10;
				if (d1 == 0 || d2 == 0) {
					continue;
				} else {
					if (((n1 == d2) && n2 / d1 == (n / d)) || ((n2 == d1) && n1 / d2 == (n / d))) { 
						sols.add(new int[] { (int) n, (int) d });
					}
				}

			}
		}
		int numTot = 1;
		int denTot = 1;
		for(int[] arr : sols){
			System.out.println("sol : " + arr[0] + " / " + arr[1]);
			numTot *= arr[0];
			denTot *= arr[1];
		}
		System.out.println("sol tot : " + numTot + " / " + denTot);
		
		int[] reduced = Util.reduceFraction(numTot, denTot);
		
		System.out.println("sol reduced tot : " + reduced[0] + " / " + reduced[1]);
		
		return "" + reduced[1];
	}

}
