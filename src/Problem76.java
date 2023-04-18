
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
	
	/*
	 * NOTES:
	 * 
	 -------- I visualize 5 like this: --------
	 
	 1 1 1 1 1 :: 1st way (five 1's)
	 1 1 1 \ / :: 2nd way (three 1's and a 2)
	        2
	 1 \ /  
	    2   2  :: 3rd way (one 1 and two 2's)
	    
	 (cant combine that last 1 with anything, so back to all 1's 1 1 1 1 1)
	 1 1 \ | /
	       3  :: 4th way (two 1's and a 3)
	 \ /   
	  2    3  :: 5th way (one 2 and one 3)
	    
	 (nothing left to combine.. so back to all 1's)
	 1 \ \ / /
	      4   :: 6th way (one 1 and one 4)
	      
	 (nothing left to combine, and we cant go to the next number, 5, because thats the starting number)
	 
	 we are done, we found 6 ways to do it.
	   
	 */
	
	/*
	 -------- I visualize 6 it like this: --------
	 6:
	 1 1 1 1 1 1 :: 1st way (6 1's)
	 1 1 1 1 \ / :: 2nd way (four 1's and a 2)
	          2
	 1 1 \ /  
	      2   2  :: 3rd way (two 1 and two 2's)
	      
	 \ /   
	  2   2   2  :: 4rd way (three 2's)
	    
	 (cant combine anything else as 2's, so back to all 1's 1 1 1 1 1)
	 1 1 1 \ | /
	         3  :: 5th way (three 1's and a 3)
	 
	 1 1 1 \ | /
	 \ | /
	   3     3  :: 6th way (two 3's)
	   
	 (nothing left to combine, but we need to check that 3 on the right again, it can become a 2 and a 1)
	 1 1 1 \ | /
	   \ /
	    2    3  :: 7th way (one 1, one 2, and a 3)
	    
	 (cant combine that last 1, and now we are all the way on the left and are doing combos of 2, so we are done with the 3, back to all 1's)
	 
	 1 1 \ \ / /
	        4   :: 8th way (two 1's and one 4)
	 
	 
	 
	 \ /   
	  2     4   :: 9th way (one 2 and one 3)
	    
	 (nothing left to combine.. so back to all 1's)
	 
	 1 \ \ | / /
	       5    :: 10th way (one 1 and one 5)
	       
	 (cant combine that 1 with anything, and we are at 5 which is 1 less than the starting number, so we are complete now) 
	 10 ways for the number 6

	   
	 */
	
	
	/*
	 ways to make 5:
		2 + 3
		1 + 4
		1 + 1 + 3
		1 + 2 + 2
		1 + 1 + 1 + 2
		1 + 1 + 1 + 1 + 1
		
	ways to make 4:
		2 + 2
		1 + 3
		1 + 1 + 2
		1 + 1 + 1 + 1
		
	ways to make 3:

		1 + 2
		1 + 1 + 1
		
	ways to make 2: 
		1 + 1
		
		
		
		
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
	
	public static void entr() {
		int test = 6;
		int count = 1; //since every number has 1 1 1 1 1... as a way to make that number
		int sub = test - 1; // 5
		int left = test - sub; //1
		
		recr(test,sub);
	}
	
	//This code doesnt work or do anything yet, 
	public static void recr(int sn, int sub) {
		//this one will do some stuff, like find out how many ways to make this number
		//but part of finding that out will be to find how manyways to make the smaller numbers inside
		//like this will try to find how many ways to make 6, but part of that is finding out how many
		// 	ways to make 5 in a certain combination, and part of finding out 5 will be to find out 4 in some way etc..
		//so this function will call itself, hence it is a recursive function
		
		//... do some stuff
		int nextNum = sn-sub;
		sub--;
		//then
		recr(nextNum, sub);//
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
