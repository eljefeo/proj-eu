
public class Problem82 implements Problem {// Took 0.001596 seconds

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
		
		return doThing();
		
		//int[][] nums = Problem82Helper.getNums();
		//return Util.findMinPath2Ways(nums);
	}
	
	public static int doThing() {
		int[][] nums = new int[][] {
			{131,	673,	234,	103,	18},
			{201,	96,		342,	965,	150},
			{630,	803,	746,	422,	111},
			{537,	699,	497,	121,	956},
			{805,	732,	524,	37,		331}
		};
		int xl = nums[0].length;
		int yl = nums.length;
		int[][] ups = new int[yl][xl];
		int[][] downs = new int[yl][xl];
		int[][] lefts = new int[yl][xl];
		
		System.out.println("Original nums:");
		Util.print2DIntArray(nums);
		
		//int[][] nums2 = new int[nums.length][nums[0].length] ;
		

		
		
		/////////////////////////////////////////////////
		for (int a = 1; a < xl-1; a++) { 
			System.out.println("a is at " + a);
			
			System.out.println("after doing Left edge adding to the right num...lefts:");
			// do left edge numbers:
			for (int i = 0; i < yl ; i++) {
				lefts[i][a] = nums[i][a] + nums[i][a-1];
				System.out.println("Leftsss " + i + " " + a + " adding " + nums[i][a] + " + " + nums[i][a-1] + " = " + lefts[i][a]);
					
			}
			Util.print2DIntArray(lefts);
		
			// do top down numbers, this gives us the value of coming from up above to this cell:
			System.out.println("after doing next column checking up vs left...ups:");
			ups[1][a] = nums[1][a] + lefts[0][a];
			Util.print2DIntArray(ups);
			for (int i = 2; i < yl; i++) { 
				ups[i][a] = nums[i][a] + ( lefts[i-1][a] > ups[i-1][a] ? ups[i-1][a] : lefts[i-1][a] ); //this one need to check the left vs the up
			}
			System.out.println("ups:");
			Util.print2DIntArray(ups);
			
			
			
			// do bottom up numbers, this gives us the value of coming from below to this cell:
			System.out.println("after doing next column checking down vs left...downs:");
			downs[yl-2][a] = nums[yl-2][a] + lefts[yl-1][a];
			System.out.println("checking down " + downs[yl-2][a] + " douss. setting down[" + (yl-2) + "][" + a + "] ... nums["+(yl-2)+"]["+a+"] = " + nums[yl-2][a] + ", lefts[" + (yl-1) + "][" + a + "] = " + lefts[yl-1][a] + " :::: " + (nums[yl-2][a] + lefts[yl-1][a]));
			Util.print2DIntArray(downs);
			for (int i = xl-3; i >= 0; i--) {
				downs[i][a] = nums[i][a] + ( lefts[i+1][a] > downs[i+1][a] ? downs[i+1][a] : lefts[i+1][a]);// nums[i][1] + nums2[i+1][1];
			}
			System.out.println("downs:");
			Util.print2DIntArray(downs);
			
			
			nums[0][a] = lefts[0][a] > downs[0][a] ? downs[0][a] : lefts[0][a];
			System.out.println("Just set nums end nums[0][" + a + "] = " + (lefts[0][a] > downs[0][a] ? downs[0][a] : lefts[0][a]));
			nums[yl-1][a] = lefts[yl-1][a] > ups[yl-1][a] ? ups[yl-1][a] : lefts[yl-1][a];
			System.out.println("Just set nums end nums[" + (yl-1) + "][" + a + "] = " + (lefts[yl-1][a] > ups[yl-1][a] ? ups[yl-1][a] : lefts[yl-1][a]));
			for (int b = 1; b < xl-1; b++) {
				nums[b][a] = Math.min(lefts[b][a], Math.min(ups[b][a], downs[b][a]));
				System.out.println("Just set nums end bnums[" + b + "][" + a + "] = " + (nums[b][a]));
			}
			System.out.println("End of loop, here is nums so far:");
			Util.print2DIntArray(nums);
			
		}
		/////////////////////////////////////////////////

		
		
		System.out.println("after doing Right edge adding to the left num...lefts:");
		// do right edge numbers:
		for (int i = 0; i < yl ; i++) {
			nums[i][yl-1] = nums[i][yl-1] + nums[i][yl-2];
		}
		Util.print2DIntArray(nums);
		
		int finalNum = nums[0][xl-1];
		for(int i=0; i<xl; i++) {
			System.out.println("checking final nums " + i + " " + (xl-1) + " = " + nums[i][xl-1]);
			if(nums[i][xl-1] < finalNum) {
				System.out.println("set new smallest to : " +  nums[i][xl-1]);
				finalNum = nums[i][xl-1];
			}
		}
		
		
		
		//int finalNum = nums[nums.length - 1][nums[0].length - 1];
		return finalNum;
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
	
	public static int findMinPath2Ways(int[][] nums) {

		// This is assuming all the rows and columns have the same num of elements I
		// guess. Like a square
		int xl = nums[0].length;
		int yl = nums.length;

		//System.out.println("after doing edges :");
		// do left edge numbers:
		for (int i = 1; i < yl; i++) {
			nums[i][0] += nums[i - 1][0];
		}

		// do top edge numbers:
		for (int i = 1; i < xl; i++) {
			nums[0][i] += nums[0][i - 1];
		}

		// do all rest of middle numbers:
		for (int i = 1; i < yl; i++) {
			for (int j = 1; j < xl; j++) {
				int left = nums[i][j - 1];
				int up = nums[i - 1][j];
				nums[i][j] += left < up ? left : up;
			}
		}

		//System.out.println("Final array:");
		//Util.print2DIntArray(nums);
		
		int finalNum = nums[nums.length - 1][nums[0].length - 1];
		return finalNum;
	}

	 /*
	 original:
		{131,	673,	234,	103,	18},
		{201,	96,		342,	965,	150},
		{630,	803,	746,	422,	111},
		{537,	699,	497,	121,	956},
		{805,	732,	524,	37,		331}
	 */

	
}
