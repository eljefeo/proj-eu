import java.util.ArrayList;
import java.util.List;

public class Problem51 implements Problem{

	
	/*
	 By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, 
	yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
	 */
	
	
	//TODO Need to skip duplicates
	// for example when we do 12, 13, 14, 15...
	// we end up doing 1x for each
	// which ends up being 11, 12, 13, 14, 15.... over and over again...
	
	
	public static void main(String[] args) { //takes 15 sec, need to speed up
		Problem p = new Problem51();
		p.runProblem();
		//problem2(); -- Work from here to optimize maybe
		
		/*
		List<String> differentCombinationsOfIndexes = new ArrayList<String>();
		int[] inds = new int[] {5,3,2,4,1};
        Util.findCombinationsOfSizeRecurKeepTrack(inds, "", 0, inds.length, 2, differentCombinationsOfIndexes);
        
        for(String s : differentCombinationsOfIndexes) {
        	System.out.println("comb : " + s);
        }
        

        */
	}
	
	public void problem3(){
		

		int maxPCount = 0;
		int smallpr = 0;
		//int i = 9;
		
		int desiredPrimeCount = 8;
		
		// what if we focus on digit count instead of all nums
		// so if we had a start num like 111 - we can do a base number lets say 11X (the two 1's) and the thing we will test replacing is the X
		// we can increment the base and do it again 
		// like 111 -> 112 113 114 115 etc..
		// then
		// 121 122 123 124 125 126, then 131 132 133
		
		
		// so like for 1111 we do 111X then 11XX then 1X1X etc...
		// we can keep track of the base ( the 1's above) and the thing to change (the X's above)
		// we can just keep track of the indexes
		// int[] baseIndexes = new int[];
		// int[] xIndexes = new int[];
		// we can start with digit counts
		// do 2 digits, then do 3 digits, then do 4 then 5, 6 etc...
		/*
		 
		  so for 2 digits
		  lets start with 3 digits, harder to do but will get the idea down because there is a number in the middle instead of just the ends
		 
		 */
		
		int dCount = 3; // digit count
		// 111 
		
		for(int i=1; i<dCount; i++){
			int base = dCount - i; // how many digits we use to stay the same
			int xs = dCount - base;
			System.out.printf("\nbase = %s   xs = %s", base, xs);
			// first is 2, next iteration is 1
			// we always want to replace at least one digit, and never want to replace them all
			
			// now we know how many digits will be static and how many will be x's ( will be changing through 1-9)
			// we find all combinations of......
		}
	}
	
	// or can we do something with finding all primes under some num
	// then can we be super smart and check if the digits of those primes match up somehow?
	// we could do 2 digit primes, then 3 then 4 etc.. and run our algorithm?
	//
	public static void problem2(){
		int maxDigitCountPlusOne = 4, numToStop = (int) Math.pow(10, maxDigitCountPlusOne+1);
		System.out.printf("\nhighestDigitCount = %d   numToStop = %d", maxDigitCountPlusOne, numToStop);
		List<Integer> allP = Util.getPrimesUnder(numToStop);
		// all digit primes 5 or less digits
		//int howManyMaxDigits = 
		//List<List<Integer>> allDigitPrimes = new ArrayList<List<Integer>>();
		
		
		// where are the changes in digit counts?
		// like in that list of primes, index 23 is the first of 3 digit primes? and index 389 is first 4 digit? etc..
		//int digitChanges = new int[maxDigitCountPlusOne-1];
		
		
		//for(int i=0; i<allP.size(); i++){
		int pi = 0;
		for(int i=1; i<maxDigitCountPlusOne; i++){	
			int p, tens = (int) Math.pow(10, i);
			while((p = allP.get(pi)) < tens) {
				
				System.out.println(i + " digits = " + p + " :: tens = " + tens);
				
				if(pi == allP.size()-1) 
					break;
				
				
				pi++;
			}
			
			// do our magic which we still need to write - that handles this many digits..
			//1x 2x 3x etc..
			// then x1 x2 x3 etc..
			
			
		}
	}
	
	public String problem(){
		int maxPCount = 0;
		int smallpr = 0;
		int i = 9;
		
		int desiredPrimeCount = 8;
		
		
		while(maxPCount < desiredPrimeCount){
			i++;
			int[] newData = replaceDigitsCheckForPrimes(i, maxPCount);
			int newPCount = newData[0];
			int smallestPrime = newData[1];
			if(newPCount > maxPCount){
				maxPCount = newPCount;
				smallpr = smallestPrime;
				System.out.println("!!New max p count : " + newPCount + " for number : " + smallpr);
			} else if (newPCount == 3) {
				System.out.println("!!3 p count : " + newPCount + " for number : " + smallestPrime);
			}
		}
		
		return "" + smallpr;
		
	}
	
	private static int[] replaceDigitsCheckForPrimes(int num, int maxPCount){
		
		//String test = "56003";
		String test = "" + num;
		// create an array of all indexes for the string in question 
		// string 5436 :: this can have indexes 0, 1, 2, 3 which correspond respectively to numbers 5, 4, 3, 6
		int[] inds = new int[test.length()];
		for(int i=0; i<test.length(); i++){
			inds[i] = i;
		}
		
		// now that we have an array of the various indexes. We will get all combinations of indexes 
		// we will then change all the digits at those indexes to the numbers 0-9 to check for primes
		
		int[] returnData = new int[2];
		
		for(int howManyXs = 1; howManyXs < test.length(); howManyXs++){
			List<String> differentCombinationsOfIndexes = new ArrayList<String>();
	        Util.findCombinationsOfSizeRecurKeepTrack(inds, "", 0, inds.length, howManyXs, differentCombinationsOfIndexes);
	        
			for(String s : differentCombinationsOfIndexes){
				s = s.trim();
				
				String[] spl = s.split(" ");
				String smallestNTest = "";
				int pCount = 0;
				String nTest = test;
				
				//l:
				for(int d = 0; d < 10; d++){
					
					for(String sp : spl){
						//if(sp == (""+(nTest.length()-1)) && d%2==0)
							//continue l; // attempt to skip numbs that are even
						
						
						//String ds = ""+d;
						Integer ind = Integer.parseInt(sp);
						nTest = nTest.substring(0,ind) + d + nTest.substring(ind+1); //, nTest.length());
					}
					
					if(nTest.startsWith("0")){ // skip if we made the first digit a 0. This changes the number altogether
						continue;
					} 
					Integer parsed = Integer.parseInt(nTest);
					//if(parsed % 2 == 0)
					//	continue;
					
					if(Util.isPrime(parsed)){
						pCount++;
						if(smallestNTest == ""){
							smallestNTest = nTest;
							
						}
					}
				}
				if(pCount > maxPCount){
					maxPCount = pCount;
					returnData[0] = pCount;
					returnData[1] = Integer.parseInt(smallestNTest);
				}
			}
		}
		
		return returnData;
		
	}
	

	

	
	


}
