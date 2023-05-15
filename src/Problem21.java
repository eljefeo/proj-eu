import java.util.HashSet;
import java.util.Set;

public class Problem21 implements Problem { //Took 0.076784 seconds

	public static void main(String[] args) {
		Problem p = new Problem21();
		p.runProblem();
	}

	/*
	 * Let d(n) be defined as the sum of proper divisors of n (numbers less than
	 * n which divide evenly into n). If d(a) = b and d(b) = a, where a != b,
	 * then a and b are an amicable pair and each of a and b are called amicable
	 * numbers.
	 * 
	 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22,
	 * 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1,
	 * 2, 4, 71 and 142; so d(284) = 220.
	 * 
	 * Evaluate the sum of all the amicable numbers under 10000.
	 * 
	 */

	@Override
	public Object problem() {
		Set<Integer> an = new HashSet<Integer>();
		int runningTotal = 0;
		for (int i = 1; i < 10000; i++) {
			if (an.contains(i)) {
				System.out.println("Skipping " + i);
				continue;
			}
			int amicableNum = Util.getAmicableNumber(i);
			if (amicableNum != 0) {
				if(an.add(i))
					runningTotal += i;
				
				if(an.add(amicableNum))
					runningTotal += amicableNum;
			}
		}
		//for (Integer sum : an) {
		//	runningTotal += sum;
		//}
		//System.out.println("Final sum : " + runningTotal);
		return runningTotal;
	}

}
