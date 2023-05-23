package ProjEuProblems;
import java.math.BigInteger;

import ProjEuUtil.Util;

public class Problem76 implements Problem{// Took 0.002646 seconds

	/*
	 It is possible to write five as a sum in exactly six different ways:
		How many ways to make 5:
		4 + 1
		3 + 2
		3 + 1 + 1
		2 + 2 + 1
		2 + 1 + 1 + 1
		1 + 1 + 1 + 1 + 1
		
	How many different ways can one hundred be written as a sum of at least two positive integers?
	190569291
	 */

	public static void main(String[] args) {
		Problem p = new Problem76();
		p.runProblem();
	}
	
	@Override
	public Object problem() {
		int num = 100;
		//we subtract 1 because this problem is asking just how many ways to SUM to this num. but partition count includes the number itself. so we minus 1
		BigInteger ans = Util.howManyWaysToSumToNEulers(num).subtract(BigInteger.ONE);
		return ans;
	}
	
	
	//Just an extra func for testing:
	public static int howManyWaysToSumToN_printAnswers(int num, int goal,  int count, int end, String text) {
			for(int i = 1; i <= end; i++) {
				int ni = num + i;
				if(ni > goal) {
					//t++;
					//System.out.println(" too far " + num + " + " + i);
					return count;
				} else if (ni == goal) {
					text += " " + i;
					System.out.println("found: " + text);
					count++;
					break;
					//return count;
				}
				else {
					count = howManyWaysToSumToN_printAnswers(ni, goal, count, i, text + " " + i);
				}
				
			}
		
		return count;
	}

}
