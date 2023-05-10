import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem81 implements Problem{// Took 0.018977 seconds

	
	/*
	In the 5 by 5 matrix below, the minimal path sum from the top left to the bottom right, 
		by only moving to the right and down, is indicated in bold red and is equal to 2427.

		131*	673		234		103		18
		201*	96*		342*	965		150
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
		return goBackwards();
	}
	/*
	 original:
		{131,	673,	234,	103,	18},
		{201,	96,		342,	965,	150},
		{630,	803,	746,	422,	111},
		{537,	699,	497,	121,	956},
		{805,	732,	524,	37,		331}
	 */
	
	//maybe need to look 2 or 3 steps ahead? like if you can check up 1 and up 2 and both of those lefts
	
	public static int goBackwards() {
		
		int[][] nums = new int[][]{
				{7,		6,		5,		4,		3},
				{201,	96,		342,	965,	2},
				{630,	803,	746,	422,	1},
				{537,	699,	497,	121,	38},
				{805,	732,	524,	37,		331}
			};
			
			//nums = Problem81Helper.getNums();
			long total = nums[0][0];
			int xl = nums[0].length;
			int yl = nums.length;
			for(int i=yl-1; i > 0; i--) {
				
				for(int j=xl-1; j >= 0; j--) {
					System.out.print("i=" + i + " j=" + j );
					total += nums[i][j];
					System.out.println(" added: " + nums[i][j] + " total=" + total);
					
					if(i == 0) {
						//i--;
						continue;
					}
					if(j == 0) {
						continue;
					} 
					int left = nums[i][j-1];
					int up = nums[i-1][j];
					//System.out.println("at row xy: " + nums[i][j] + " left=" + left + ", up=" + up);
					if(up < left) {
						i--;
						j++;
						//System.out.println(up + " < " + left + "	switched to: " + nums[i][j] + " left=" + left + ", up=" + up);
					} else {
						//System.out.println(left + " < " + up + "	naturally switched to: " + nums[i][j] + " left=" + left + ", up=" + up);
					}
				}
				
			}
		
		return 0;
	}

	public static int goForwards() {
		
		int[][] nums = new int[][]{
				{131,	673,	234,	103,	18},
				{201,	96,		342,	965,	150},
				{630,	803,	746,	422,	111},
				{537,	699,	497,	121,	956},
				{805,	732,	524,	37,		331}
			};
			
			//nums = Problem81Helper.getNums();
			long total = nums[0][0];
			int xl = nums[0].length;
			int yl = nums.length;
			for(int i=0; i < yl; i++) {
				
				for(int j=0; j < xl; j++) {
					System.out.print("i=" + i + " j=" + j );
					total += nums[i][j];
					System.out.println(" added: " + nums[i][j] + " total=" + total);
					
					if(i == 0) {
						//i--;
						continue;
					}
					if(j == 0) {
						continue;
					} 
					int left = nums[i][j-1];
					int up = nums[i-1][j];
					//System.out.println("at row xy: " + nums[i][j] + " left=" + left + ", up=" + up);
					if(up < left) {
						i--;
						j++;
						//System.out.println(up + " < " + left + "	switched to: " + nums[i][j] + " left=" + left + ", up=" + up);
					} else {
						//System.out.println(left + " < " + up + "	naturally switched to: " + nums[i][j] + " left=" + left + ", up=" + up);
					}
				}
				
			}
		
		return 0;
	}
	
	
}
