
public class Problem76 implements Problem{
	/*
	 It is possible to write five as a sum in exactly six different ways:

		4 + 1
		3 + 2
		3 + 1 + 1
		2 + 2 + 1
		2 + 1 + 1 + 1
		1 + 1 + 1 + 1 + 1
		
	How many different ways can one hundred be written as a sum of at least two positive integers?
	
	
	 */

	public static void main(String[] args) {
		Problem p = new Problem76();
		p.runProblem();
		//entry();

	}
	
	@Override
	public Object problem() {
		entr();
		
		return "";
	}
	/*
		6:
		
		 1 5						1 5
		 2 4						2 4s
		 1 1 4
		 3 3 
		 1 2 3 						3 3s
		 1 1 1 3
		 2 2 2 
		 1 1 2 2 					3 2s
		 1 1 1 1 2					
		 1 1 1 1 1 1 				1 1
		 ::: 6 has 10 ways
	*/
	
	/*
	 if we are at 3 3
	 recur loop 1 ( the far right 3 )
	 original num (6) -3
	 gives us 3
	 
	 func(num){
	 	num is 3
	 	
	 }
	 
	 sub = 3;
	 left = sn - sub;
	 (left is 3)
	 
	 send left back into the recur function
	 woopwAbblyWoopppFlutterWaaahhh (*recurive sounds, like going through a time warp black hole*)
	 
	 
	 
	 
	 
	 */
	
	public static void entr() {
		int test = 6;
		int count = 1; //since every number has 1 1 1 1 1... as a way to make that number
		int sub = test - 1; // 5
		int left = test - sub; //1
		
		int result = recr(test);
		System.out.println("FINAL for " + test + " : " + result);
	}
	public static int recr(int sn) {
		
		//if(sn == 1) {
		//	System.out.println("Got 1 .,... going to return 0");
		//	return 0;
		//}
		
		int count = 0;
		int sn2 = sn;
		
		System.out.println("SSSSS to while loop for sn: " + sn + " sn2: " + sn2 + " starting count: " + count);
		while(sn2-- > 1) {
			int left = sn - sn2;
			count++;
			System.out.println("In CALL while loop for sn: " + sn + " ... dcrmnt sn2 to: " + sn2 + " left: " + left + " -- count is now: " + count + " calling recr(" + left + ")");
			int rCount = recr(left);
			
			count += rCount;
			System.out.println("In RETURNED while loop for sn: " + sn + " ... sn2: " + sn2 + " left: " + left + " -- rCount count: " + rCount + " ::: added rCount, count is now: " + count);
		}
		
		System.out.println("OOOOO of while loop for sn: " + sn + " sn2: " + sn2 + " returning count: " + count);
		return count;
		
	}
	
	//This code doesnt work or do anything yet, 
	public static int recr_2(int sn, int count) {
		//this one will do some stuff, like find out how many ways to make this number
		//but part of finding that out will be to find how manyways to make the smaller numbers inside
		//like this will try to find how many ways to make 6, but part of that is finding out how many
		// 	ways to make 5 in a certain combination, and part of finding out 5 will be to find out 4 in some way etc..
		//so this function will call itself, hence it is a recursive function
		
		//... do some stuff
		//so we get 6 in...
		//
		
		if(sn < 2) {
			System.out.println("returning 0 for sn: " + sn + ", count: " + count);
			return 0;
		}
		
		//can this stand for the sn number just being all 1's? any number that passes 
		//  the check sn < 2 can be all 1's so we give it 1 count already?
		int newCount = 1; 
		
		int sub = sn - 1;
		while(sub > 1) {
			int nn;
			//while((nn = sn - sub) > 1){
			nn = sn - sub;
			newCount++;
			
			if(nn == 1 || nn == 0) {
				continue;
			}
			
			int nCount = recr_2(nn, count);
			System.out.println("got nCount returned: " + nCount + " for nn: " + nn + " sn: " + sn + " sub: " + sub);
			
			sub--;
		}
		
		return newCount;
		
	}
	public Object problem2() {
		
		
		int test = 6;
		int count = 1; //since every number has 1 1 1 1 1... as a way to make that number
		int sub = test - 1; // 5
		int left = test - sub; //1
		//now we check everything for whats left (1)
		
		if(left == 1 || left == 0) {
			//thats the end of the line, cant combine anything else if we are just left with a 1 or 0
			//this is wher we would break in some loop I assume we would put this code in.
		}
		
		//next iteration:
		
		sub--; //sub was 5, now its 4
		left = test - sub; //test is 6 so now left is 2
		
		if(left == 1 || left == 0) {
			//this is false, because left is 2
		} else {
			//we check if we can subtract all numbers from sub to 2. Sub is 4, so we try 4, then 3, then 2
			int otherLeft = left - sub;
			if(otherLeft == 1 || otherLeft == 0) {
				//break;
			} else if(otherLeft < 0) {
				//we get here because 2 - 4 is -2
				//end of the line for this
			}
		}
		
		
		for(int i=test-1; i > 1; i--) {
			
			int nLeft = left;
			System.out.println("starting for loop, left = " + left + ", i = " + i);
			while(true) {
				nLeft -= i;
				if(nLeft > 0) {
					System.out.println("breaking 1 loop, i = " + i + ", nLeft = " + nLeft);
					break;
				} else {
					System.out.println("still in 1 loop, i = " + i + ", nLeft = " + nLeft);
				}
			}
			
			System.out.println("In loop, i = " + i + ", nLeft = " + nLeft);
			if(nLeft > 1) {
				count ++;
			}
		}
		
		
		
		
		
		//entr();
		return "";
	}


	
	
	
	
	
	
	
	
	/* all the code below here is just messing around with some initial ideas, doesnt solve the problem at all yet. */
	
	
	
	
	
	
	
	
	public Object problemOther() {
		System.out.println("Here we go");
		
		
		/*
		 so we do 6, lets see..
		 
		 
		 */
		int test = 6;
		int count = 1; //since every number has 1 1 1 1 1... as a way to make that number
		int sub = test - 1; // 5
		int left = test - sub; //1
		while(true) {
			
			
			
			while(left > 1) {
				left = test - sub; //this gives us 1 and 5, sub is 5, which leave left is 1
				int nSub = sub; //nSub is 5
				System.out.println("1 Left is now: " + left + ", and nSub is " + nSub);
				
				if(left > 0) {
					count++;
					System.out.println("first count up, count is now : " + count);
				} else {
					System.out.println("How did we get here? " + count);
					System.out.println("errrr Left is now: " + left + ", and nSub is " + nSub);
				}
				
				//then we want to go through the rest of the num (after taking away 5) and see how many times we can take away another 5, then 4, and 3, and 2
				//so... what do we do 
				
				
				while(left > 1) {
					left -= nSub;
					//if(left > 1) {
						count++;
						System.out.println("2 Left is now: " + left + ", and nSub is " + nSub);
					//}
				}
				
				count++;
			}
			
			
			
			
			if(4 < 90) {
				break;
			}
		}
		
		count++; //because the start number can already be imagined as all 1's
		
		//then we start doing combos of 2? Or should we start with highest num 5?
		//lets stick with our visualization below and we can switch to the highest to lowest if we want
		//we will do lowest to highest (combos of 2, then 3, then 4, etc..)
		// so we minus the first 2 (do the first combo of 2 for the two 1's on the right)
		
		if(test < 2) { //I guess if we ever go below 2 then we know we cant combine anything else so we return maybe this return is early?
			//return count; // done actually return from this function as a whole, need to change numToCombo to increment
			sub++;
		}
		
		//DOING 2 first
		
		
		
		int next = test - sub; // 4
		count++;
		
		if(test < 2) {
			//return count;
			sub++;
		}
		
		
		next = test - sub; // 2
		count++;
		
		if(test < 2) {
			//return count;
			sub++;
		}
		
		next = test - sub; // 0
		count++;
		
		if(test < 2) {
			//return count;
			sub++; // so now the next is at 0, so we increase the num to combo and go back and do it again?
		}
		
		
		
		return null;
	}
	
	
	

	
	
	/////messing with recur here below, not completed, dont use until you finish it. Go work on the other way as described in comments above
	private static void entry() {
		
		
		int test = 6;
		int ways = recur(test);
		System.out.println("ways to make " + test + " : " + ways);
	}
	private static int recur(int n) {
		
		if(n < 2) return 0;
		
		int waysToMakeN = 0;
		System.out.println("starting recur with " + n);
		int sub = 0;
		while(sub < n) {
			
			
			sub++;
			
			
			
			int diff = n - sub;
			if(diff > 1) {
				System.out.println("gonna call recur again for n: " + n + " with sub: " + sub + " diff: " + diff);
				int newWays = recur(diff);
				System.out.println("inside got this many ways to make " + diff + " with sub: " + sub + " : ways = " + newWays + " ::: waysToMakeN was " + waysToMakeN);
				waysToMakeN += newWays;
				System.out.println(" and now it is : " + waysToMakeN);
			} else if (diff == 1){ //we end here this recur?
				System.out.println("breaking at diff: " + diff + ", sub: " + sub + " for n: " + n);
				waysToMakeN++;
				break;
			} else {
				System.out.println("ERROR " + diff + ", sub: " + sub + " for n: " + n);
			}
			
			
			
		}
		
		
		
		System.out.println("returning " + waysToMakeN + " for n :" + n);
		return waysToMakeN;
				
	}
	

	
}
