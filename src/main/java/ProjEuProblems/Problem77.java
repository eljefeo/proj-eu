package ProjEuProblems;

import ProjEuUtil.Util;

public class Problem77 implements Problem{// Took 0.004642 seconds

	/*
	 It is possible to write ten as the sum of primes in exactly five different ways:

		7 + 3
		5 + 5
		5 + 3 + 2
		3 + 3 + 2 + 2
		2 + 2 + 2 + 2 + 2
		
		What is the first value which can be written as the sum of primes in over five thousand different ways?
	 */

	public static void main(String[] args) {
		Problem p = new Problem77();
		p.runProblem();
	}

	
	@Override
	public Object problem() {
		int limit = 5000;
		
		return Util.findNumWithThisManyPrimeSumsRecur(limit);
	}
	
}
