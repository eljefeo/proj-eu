import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem68 {

	
	/*
	 Magic 5-gon ring

		Problem 68
		
		
		
	 Consider the following "magic" 3-gon ring, filled with the numbers 1 to 6, and each line adding to nine.
	 ......
	 Working clockwise, and starting from the group of three with the numerically lowest external node (4,3,2 in this example), each solution can be described uniquely. For example, the above solution can be described by the set: 4,3,2; 6,2,1; 5,1,3.

It is possible to complete the ring with four different totals: 9, 10, 11, and 12. There are eight solutions in total.

Total	Solution Set
9	4,2,3; 5,3,1; 6,1,2
9	4,3,2; 6,2,1; 5,1,3
10	2,3,5; 4,5,1; 6,1,3
10	2,5,3; 6,3,1; 4,1,5
11	1,4,6; 3,6,2; 5,2,4
11	1,6,4; 5,4,2; 3,2,6
12	1,5,6; 2,6,4; 3,4,5
12	1,6,5; 3,5,4; 2,4,6

By concatenating each group it is possible to form 9-digit strings; the maximum string for a 3-gon ring is 432621513.

Using the numbers 1 to 10, and depending on arrangements, it is possible to form 16- and 17-digit strings. What is the maximum 16-digit string for a "magic" 5-gon ring?


	 */
	
	static int MAX_NUM_DIGITS = 16;
	
	static int c = 0;
	static BigInteger bgst = BigInteger.ZERO;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//			6
		// 	4	3	2
		//			1
				  //   5
		
		problem();
		
		
		
	}

	private static void problem() {
		int numOfLines = 3;
		int lineSize = 3;
		int[] l1 = new int[lineSize];
		int[][] ll = new int[numOfLines][lineSize];
		
		
		// for 3gon
		// a 1 2 3 
		// b 1 2 3 - but b2 must match a3
		// c 1 2 3 - but c2 must match b3 and c3 must match a2
		// all 3 must add to the same number
		// only using nums 1-9 once
		// no repeating nums 1-9
		
		List<Integer> oneNine = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		//int[] ott = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		
		//int[] r = new int[] {1,2,3,4,5,6};
		//int[][] s = new int[][] { {0,0,0}, {0,0,0}, {0,0,0} }; // this will hold the 3gon numbers - filled with 0 for now to indicate there is no number there yet
		//doRecur3Gon(s, r);
		
		
		int[] r = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[][] s = new int[][] { {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0} };
		doRecur5Gon(s, r);
		
		System.out.println("We did this many sols: " + c);
		System.out.println("Largest nums: " + bgst);
		
	}
	

	
	public static void doRecur5Gon(int[][] s, int[] r){
		
		if(!shouldContinueCheckingGon(s)) {
			return;
		}
		if(r.length == 0){
			if(areAllSumsEqual(s)) {
				c++;
				System.out.println("We found a match for 5gon: ");// + s1 + " " + s2 + " " + s3);
				printTwoDIntArray(s);
				doLargestNumCheck(s);
				
			}
			return;
		} else {
			for(int i=0; i<r.length; i++){
				int[][] newS = addToTheNextSpot5Gon(s, r[i]);
				int[] newR = getNewArrayWithoutIndex(r, i);
				doRecur5Gon(newS, newR);
			}
		}
	}
	
	

	private static void doLargestNumCheck(int[][] s) {
		
		String n = "";
		for(int i=0; i<s.length; i++){
			for(int j=0; j<s[i].length; j++){
				n += s[i][j];
			}
		}
		
		if(n.length() != MAX_NUM_DIGITS) {
			return;
		}
		
		BigInteger b = new BigInteger(n);
		if(b.compareTo(bgst) == 1) {
			bgst = b;
		}
		
	}

	public static void doRecur3Gon(int[][] s, int[] r){
		
		if(!shouldContinueCheckingGon(s)) {
			return;
		}
		
		if(r.length == 0){
			//if(c == 3)
				//System.exit(0);
			
			// for 3gon
			// a 1 2 3 
			// b 1 2 3 - but b2 must match a3
			// c 1 2 3 - but c2 must match b3 and c3 must match a2
			// all 3 must add to the same number
			// only using nums 1-9 once
			// no repeating nums 1-9
			// check here for the rules?
			//all.add(s);
			
			//hardcode 3gon rules for now
			
			//System.out.println("We ended 3gon:");
			
		//	printTwoDIntArray(s);
			
			//we should do some other function to check along the way if the lines add up to the same number,
			// if like, lines 1 and 2 dont add up to the same, then dont bother doing line 3?
			//if(s[1][1] == s[0][2] && s[2][1] == s[1][2] && s[2][2] == s[0][1]) {
			
			//boolean areAllSumsEqual = areAllSumsEqual(s);
			
				//int s1 = s[0][0] + s[0][1] + s[0][2];
				//int s2 = s[1][0] + s[1][1] + s[1][2];
				//int s3 = s[2][0] + s[2][1] + s[2][2];
				
				//System.out.println("in the right spot at least... sums:" + s1 + " , " + s2 + " , " + s3);
				
				//if(s1 == s2 && s2 == s3) {
				if(areAllSumsEqual(s)) {
					c++;
					System.out.println("We found a match for 3gon:");// + s1 + " " + s2 + " " + s3);
					printTwoDIntArray(s);
					doLargestNumCheck(s);
				}
			//}
			
			return;
			
			
		} else {
			for(int i=0; i<r.length; i++){
				int[][] newS = addToTheNextSpot3Gon(s, r[i]);
				int[] newR = getNewArrayWithoutIndex(r, i);
				doRecur3Gon(newS, newR);
			}
		}
	}
	
	private static boolean areAllSumsEqual(int[][] s) {
		
		int firstTot = 0;
		for(int i=0; i<s[0].length; i++){
			firstTot += s[0][i]; 
		}
		
		for(int i=1; i<s.length; i++){
			int tot = 0;
			for(int j=0; j<s[i].length; j++){
				tot += s[i][j];
			}
			if(tot != firstTot) {
				return false;
			}
		}
		return true;
	}

	private static boolean shouldContinueCheckingGon(int[][] s) {
		int firstTot = 0;
		for(int i=0; i<s[0].length; i++){
			if(s[0][i] == 0) {
				return true;
			}
			firstTot += s[0][i]; 
		}
		
		for(int i=1; i<s.length; i++){
			int tot = 0;
			for(int j=0; j<s[i].length; j++){
				if(s[i][j] == 0) {
					return true;
				} else {
					tot += s[i][j];
				}
			}
			
			if(tot != firstTot) {
				return false;
			}
			
			if(s[i][0] < s[0][0]) {
				return false;
			}
			
		}
		return true;
	}

	
	private static int[][] addToTheNextSpot5Gon(int[][] s, int n) {
		
		int[][] ret = new int[s.length][s[0].length];
		
		boolean found = false;
		for(int i=0; i<s.length; i++) {
			for(int j=0; j<s[i].length; j++) {
				if(!found && s[i][j] == 0) {
					
					ret[i][j] = n;
					if(i==0 && j==1) {
						ret[4][2] = n;
					}else if(i==0 && j==2) {
						ret[1][1] = n;
					} else if(i==1 && j==2) {
						ret[2][1] = n;
					} else if(i==2 && j==2) {
						ret[3][1] = n;
					} else if(i==3 && j==2) {
						ret[4][1] = n;
					}
					
					found = true;
					
				}  else if(ret[i][j] == 0) {
					ret[i][j] = s[i][j];
				}
			}
		}
		return ret;
	}
	
	private static int[][] addToTheNextSpot3Gon(int[][] s, int n) {
		
		
		//this is assuming the unused places are filled with 0
		// so when we first find a 0 we put the n there, then put everything else back the way it was otherwise
		
		int[][] ret = new int[s.length][s[0].length];
		
		boolean found = false;
		for(int i=0; i<s.length; i++) {
			
			for(int j=0; j<s[i].length; j++) {
				if(!found && s[i][j] == 0) {
					
					
					
					ret[i][j] = n;
					if(i==0 && j==1) {
						ret[2][2] = n;
					}else if(i==0 && j==2) {
						ret[1][1] = n;
					} else if(i==1 && j==2) {
						ret[2][1] = n;
					}
					
					found = true;
					
				}  else if(ret[i][j] == 0) {
					ret[i][j] = s[i][j];
				}
			}
			
		}
		
		
		return ret;
	}

	public static int[] getNewArrayWithoutIndex(int[] current, int indexToRemove) {
		
		int[] ret = new int[current.length-1];
		int retCounter = 0;
		for(int i=0; i<current.length; i++) {
			if(i != indexToRemove) {
				ret[retCounter++] = current[i];
			}
		}
		return ret;
	}
	
	
	public static void printTwoDIntArray(int[][] s) {
		for(int i=0; i<s.length; i++){
			int[] l = s[i];
			for(int j=0; j<l.length; j++){
				System.out.print(" " + l[j]);
			}
			System.out.println(":");
		}
	}

}
