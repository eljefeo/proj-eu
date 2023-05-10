import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem81 implements Problem{// Took 0.018977 seconds

	
	/*
	In the 5 by 5 matrix below, the minimal path sum from the top left to the bottom right, by only moving to the right and down, is indicated in bold red and is equal to 2427.

		131*	673		234		103		18
		210*	96*		342*	965		105
		630		803		746*	422*	111
		537		699		497		121*	956
		805		732		524		37*		331*

Find the minimal path sum from the top left to the bottom right by only moving right and down in matrix.txt 
(right click and "Save Link/Target As..."), a 31K text file containing an 80 by 80 matrix.
	 */
	
	public static void main(String[] args) { //Took 0.018638 seconds
		Problem p = new Problem81();
		p.runProblem();
	}

	@Override
	public Object problem() {
		return run();
	}
	
	
	public static int run() {
		
		int[][] nums = new int[][]{
				{131,	673,	234,	103,	18},
				{210,	96,		342,	965,	105},
				{630,	803,	746,	422,	111},
				{537,	699,	497,	121,	956},
				{805,	732,	524,	37,		331}
			};
			
			int xl = nums[0].length;
			int yl = nums.length;
			for(int i=yl-1; i > 0; i--) {
				
				for(int j=xl-1; j > 0; j--) {
					
					System.out.println("i=" + i + " j=" + j);
					int left = nums[i][j-1];
					int up = nums[i-1][j];
					System.out.println("at row xy: " + nums[i][j] + " left=" + left + ", up=" + up);
					
				}
				
			}
		
		return 0;
	}

	
	
}
