package ProjEuProblems;

import ProjEuUtil.Util;

public class Problem81 implements Problem {// Took 0.001596 seconds

	/*
	 * In the 5 by 5 matrix below, the minimal path sum from the top left to the
	 * bottom right, by only moving to the right and down, is indicated in bold red
	 * and is equal to 2427.
	 * 
	 * 131* 673 234 103 18 201* 96* 342* 965 150 630 803 746* 422* 111 537 699 497
	 * 121* 956 805 732 524 37* 331*
	 * 
	 * Find the minimal path sum from the top left to the bottom right by only
	 * moving right and down in matrix.txt (right click and
	 * "Save Link/Target As..."), a 31K text file containing an 80 by 80 matrix.
	 */

	public static void main(String[] args) { // Took 0.018638 seconds
		Problem p = new Problem81();
		p.runProblem();
	}

	@Override
	public Object problem() {
		int[][] nums = Problem81Helper.getNums();
		return Util.findMinPath2Ways(nums);
	}
	

	 /*
	 original:
		{131,	673,	234,	103,	18},
		{201,	96,		342,	965,	150},
		{630,	803,	746,	422,	111},
		{537,	699,	497,	121,	956},
		{805,	732,	524,	37,		331}
	 */

	/*
	 * 
	 * This wasn't too hard to figure out, did take a bit of thought, though. You can
	 * do it exactly like the other problems with greatest sum path but it is a
	 * similar solution. I did it by adding as we go and simply keeping the smallest
	 * num, starting from top left going down to bottom right.
	 * 
	 * So this original matrix: original:
		{131,	673,	234,	103,	18},
		{201,	96,		342,	965,	150},
		{630,	803,	746,	422,	111},
		{537,	699,	497,	121,	956},
		{805,	732,	524,	37,		331}
			
	 * Turns into this after doing the top and left edges. We can see the cells next
	 * to the top left, went from 673 to 804 (131 + 673) and 201 became 332 because
	 * its 131 + 201. Then 234 became 1038 because 804 + 234. Since that is the only
	 * way to get to that 234 cell. We have to add all the nums up to that cell on
	 * our way there. 
	 * after doing edges :
		131		804		1038	1141	1159	
		332		96		342		965		150	
		962		803		746		422		111	
		1499	699		497		121		956	
		2304	732		524		37		331
	 * 
	 * 
	 * After the edges are done we just continue to do the rest of th nums in the
	 * middle, adding as we go. And when we are at a cell that has 2 ways to get
	 * there we just keep the smallest number. like in the cell [1][1] which is 96
	 * we can get there from either the top or the left if we go the top route we
	 * are adding 804 + 96, and if we went the left route we are doing 332 + 96.
	 * Obviously we keep the 332 + 96. So that cell now becomes 428. Like we
	 * actually change the array changing cell[1][1] to the number 428. So when we
	 * keep on going to figure out the rest of the cells around that num we will
	 * check that 428 to add to the nums next door. Anyway we get a final array like
	 * this: Final array:
		131		804		1038	1141	1159	
		332		428		770		1735	1309	
		962		1231	1516	1938	1420	
		1499	1930	2013	2059	2376	
		2304	2662	2537	2096	2427	
	 * 
	 * And at the end we just take whatever number is in the bottom right which is
	 * 2427
	 * 
	 int[][] nums = new int[][]{ //original
				{131,	673,	234,	103,	18},
				{201,	96,		342,	965,	150},
				{630,	803,	746,	422,	111},
				{537,	699,	497,	121,	956},
				{805,	732,	524,	37,		331}
			};
	
		
		*/
}
