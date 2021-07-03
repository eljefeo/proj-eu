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
	
	static int c = 0;
	static BigInteger bgst = BigInteger.ZERO;
	
	
	public static void main(String[] args) {
		problem();
	}

	private static void problem() {
		
		
		do3Gon();
		System.out.println("We did this many sols for 3 gon: " + c);
		System.out.println("Largest num for 3gon: " + bgst);
		
		//reset nums after 3gon:
		c = 0;
		bgst = BigInteger.ZERO;
		
		
		
		do5Gon();
		
		System.out.println();
		System.out.println("We did this many sols for 5 gon: " + c);
		System.out.println("Largest num for 5gon: " + bgst);
		
	}
	
	private static void do3Gon() {
		//for 3 gon in the project euler example
		int[] r = new int[] {1,2,3,4,5,6};
		int[][] s = new int[][] { {0,0,0}, {0,0,0}, {0,0,0} }; // this will hold the 3gon numbers - filled with 0 for now to indicate there is no number there yet
		doRecurGon(s, r, 0);
	}
	
	private static void do5Gon() {
		//for 5 gon in the project euler example
		int[] r = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[][] s = new int[][] { {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0} }; // this will hold the 5gon numbers - filled with 0 for now to indicate there is no number there yet
		doRecurGon(s, r, 16);
	}
	

	
	public static void doRecurGon(int[][] s, int[] r, int maxNumDigits){
		
		if(!shouldContinueCheckingGon(s)) {
			return;
		}
		if(r.length == 0){
			if(areAllSumsEqual(s)) {
				c++;
				//System.out.println("We found a match for gon: ");// + s1 + " " + s2 + " " + s3);
				//printTwoDIntArray(s);
				doLargestNumCheck(s, maxNumDigits);
				
			}
			return;
		} else {
			for(int i=0; i<r.length; i++){
				int[][] newS = addToTheNextSpot(s, r[i]);
				int[] newR = getNewArrayWithoutIndex(r, i);
				doRecurGon(newS, newR, maxNumDigits);
			}
		}
	}
	
	

	private static void doLargestNumCheck(int[][] s, int maxNumDigits) {
		
		String n = "";
		for(int i=0; i<s.length; i++){
			for(int j=0; j<s[i].length; j++){
				n += s[i][j];
			}
		}
		
		if(maxNumDigits > 0 && n.length() != maxNumDigits) {
			return;
		}
		
		BigInteger b = new BigInteger(n);
		if(b.compareTo(bgst) == 1) {
			bgst = b;
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
		// this gets used to stop processing the recursion if we come across a situation early on that we know wont work. Dont keep going and wasting time
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
			
			if(s[i][0] < s[0][0]) { // this is only so we start with the smallest outer node (like they do in the PE example, also prevents duplicate solutions)
				return false;
			}
			
		}
		return true;
	}

	
	private static int[][] addToTheNextSpot(int[][] s, int n) {
		
		int[][] ret = new int[s.length][s[0].length];
		
		boolean found = false;
		for(int i=0; i<s.length; i++) {
			for(int j=0; j<s[i].length; j++) {
				if(!found && s[i][j] == 0) {
					
					ret[i][j] = n;
					if(i==0 && j==1) {
						ret[s.length-1][2] = n;
					}else if (i != s.length-1 && j == s[i].length-1) {
						ret[i+1][1] = n;
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
	
	//NOTES
	
	// for 3gon
			// a 1 2 3 
			// b 1 2 3 - but b2 must match a3
			// c 1 2 3 - but c2 must match b3 and c3 must match a2
			// all 3 must add to the same number
			// only using nums 1-9 once
			// no repeating nums 1-9
	
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


}
