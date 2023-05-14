
public class Problem82 implements Problem {// Took 0.002268 seconds

	/*
	 NOTE: This problem is a more challenging version of Problem 81.

The minimal path sum in the 5 by 5 matrix below, by starting in any cell in the left column and finishing in any cell in the right column, 
and only moving up, down, and right, is indicated in red and bold; the sum is equal to 994.

 original: (marked the path with asterisks)
		{131,	673,	234*,	103*,	18*},
		{201*,	96*,	342*,	965,	150},
		{630,	803,	746,	422,	111},
		{537,	699,	497,	121,	956},
		{805,	732,	524,	37,		331}
		
Find the minimal path sum from the left column to the right column in matrix.txt 
(right click and "Save Link/Target As..."), a 31K text file containing an 80 by 80 matrix.
	 */

	public static void main(String[] args) { // Took 0.018638 seconds
		Problem p = new Problem82();
		p.runProblem();
	}

	@Override
	public Object problem() {
		int[][] nums = Problem82Helper.getNums();
		return Util.findMinPath3Ways(nums);
	}
	
	
	
	
		//I guess the first thing to do is figure out which num on the left to start at
		// for that I suppose we just add 2 nums left and right and see which is less maybe?
		//hmm
		/*
		 like the top 2 nums, 131 and 673. for the left column you would never come up from the bottom or the top.
		 you would never do more than 1 num on the left column. 
		 
		 the next column over though. You can either come from the top, left, or bottom.
		 Do we just do the same thing as the last problem? add as we go kinda?
		 
		{131,	804L/970D,	234,	103,	18},
		{201,	297L/900U/,	342,	965,	150},
		{630,	1,433L/,	746,	422,	111},
		{537,	1,236/,	497,	121,	956},
		{805,	1,537,	524,	37,		331}
		
		
		Ok so what we are going to try and do.. is left column just add left + right cell next to it
		then once we are in the next column over..
		we will start at the top and go down, calculating the 'From Up' value. We will look at the cell above and 
		choose either its Left or Up value, whichever is cheaper. Thats how we will get the Up value for this cell
		then we go down to the next cell can calculate its Up value, do that we do the same thing... look at the cell 
		above and use either its Left or Up value whichever is cheaper. Then go down to the next etc. until we hit the bottom
		once at the bottom we can calculate the Down values. We start at the bottom and go up, when we go up to the next cell up
		we will look at the cell below's either Left or Down value, whichever is cheaper. That will be this cells Down value (essentially
		the cheapest way to get here is from the left or from below, and the cheapest way to come from below is either from its left or below etc...)
		 
		
		 */
		
		
		
		
	
	
}
