import java.util.ArrayList;
import java.util.List;

public class Problem33 {
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
		problem();
	}

	private static void problem() {

		double a = 4;
		double b = 8;
		System.out.println("here " + (a / b));

		List<int[]> sols = new ArrayList<int[]>();

		for (double n = 11; n < 100; n += 1) {
			for (double d = 11; d < 100; d += 1) {
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
						if (!hasAlready(sols, (int) n, (int) d)) {
							sols.add(new int[] { (int) n, (int) d });
						}
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
		System.out.println("sol reduced tot : " + Util.reduceFraction(numTot, denTot));
	}

	private static boolean hasAlready(List<int[]> sols, int a, int b) {
		for (int[] arr : sols) {
			if ((arr[0] == a && arr[1] == b) || (arr[1] == a && arr[0] == b)) {
				return true;
			}
		}
		return false;
	}
	

	
	

}
