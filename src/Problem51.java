import java.util.ArrayList;
import java.util.List;

public class Problem51 {

	
	/*
	 By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, 
	yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
	 */
	
	public static void main(String[] args) {
		problem();
	}
	
	private static void problem(){
		//int max = 56004;
		int maxPCount = 0;
		int smallpr = 0;
		//for(int i = 10; i < max; i++){
		int i = 9;
		while(maxPCount < 8){
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
		
		
		int smallestPrime = 0;
		int[] returnData = new int[2];
		
		for(int howManyXs = 1; howManyXs < test.length(); howManyXs++){
			List<String> differentCombinationsOfIndexes = new ArrayList<String>();
	        findCombinationsOfSizeRecurKeepTrack(inds, "", 0, inds.length, howManyXs, differentCombinationsOfIndexes);
	        
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
					
					if(nTest.startsWith("0")){
						//System.out.println("Skipping : " + nTest);
						continue;
					} else {
						//System.out.println("Not skipping : " + nTest);
					}
					
					/*if(d == 0){
						smallestNTest = nTest;
					}*/
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
					//System.out.println("new larger Prime Count: " + pCount +  " :: From : " + smallestNTest);
				}
			}
		}
		
		return returnData;
		
	}
	

	
	public static void findCombinationsOfSizeRecurKeepTrack(int[] A, String out, int index, int lengthOfThing, int sampleSize, List<String> keepTrack) {
        // invalid input
        if (sampleSize > lengthOfThing) {
            return;
        }
 
        // base case: combination size is `k`
        if (sampleSize == 0) {
            keepTrack.add(out);
            return;
        }
 
        // start from the next index till the last index
        for (int j = index; j < lengthOfThing; j++) {
        	findCombinationsOfSizeRecurKeepTrack(A, out + " " + (A[j]) , j + 1, lengthOfThing, sampleSize - 1, keepTrack);
 
            // uncomment the following code to handle duplicates
            /* while (j < n - 1 && A[j] == A[j + 1]) {
                j++;
            } */
        }
    }
	
	


}
