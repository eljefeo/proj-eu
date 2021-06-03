import java.util.ArrayList;
import java.util.List;

public class Problem51 {

	
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
	
	
	public static void main(String[] args) {
		problem();
	}
	
	private static void problem(){
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
			}
		}
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
				for(int d = 0; d < 10; d++){
					
					for(String sp : spl){
						String ds = ""+d;
						Integer ind = Integer.parseInt(sp);
						nTest = nTest.substring(0,ind) + ds + nTest.substring(ind+1, nTest.length());
					}
					
					if(nTest.startsWith("0")){ // skip if we made the first digit a 0. This changes the number altogether
						continue;
					} 
					Integer parsed = Integer.parseInt(nTest);
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
