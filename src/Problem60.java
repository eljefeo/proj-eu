import java.util.ArrayList;
import java.util.List;

public class Problem60 {

	
	/*
	 The primes 3, 7, 109, and 673, are quite remarkable. 
	 By taking any two primes and concatenating them in any order the result will always be prime. 
	 For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes, 
	 792, represents the lowest sum for a set of four primes with this property.

Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
	 */
	
	
	static int totalCounter = 0;
	
	public static void main(String[] args) {
		//maybe find all primes lower than 10k and check?
		
		
		problem();
		System.out.println("Counted : " + totalCounter);
	}

	private static void problem() {
		
		
		int end = 10000;
		int start = 3;
		int comboSize = 5;
		int pCount = 0;
		
		for(int i=start; i<end; i+=2) {
			if(Util.isPrime(i)) {
				pCount++;
			}
		}
		int[] nums = new int[pCount];
		System.out.println("Pcount : " + pCount);
		
		pCount = 0;
		for(int i=start; i<end; i++) {
			if(Util.isPrime(i)) {
				nums[pCount++] = i; 
			}
		}
		
		findCombinationsOfSizeRecurCheckPrimesi(nums, new int[comboSize], 0, nums.length, comboSize, 0);
		
	}
	
	public static void findCombinationsOfSizeRecurCheckPrimesi(int[] A, int[] track, int index, int lengthOfThing, int sampleSize, int ti) {
        // invalid input
        if (sampleSize > lengthOfThing) {
            return;
        }
        
        //check so far first
        if(ti>1) {
        	 int[] temp = new int[ti];
             for(int i=0; i<ti; i++) {
             	if(track[i]!=0)
             		temp[i] = track[i];
             }
             if(!checkIntCombinationsForPrimes(temp)) {
             	return;
             }
             
        }
        
        // base case: combination size is k
        if (sampleSize == 0) {
        	if(checkIntCombinationsForPrimes(track)) {
        		System.out.println("Found one");
        		int sum = 0;
        		for(int i:track) {
        			System.out.print(" " + i);
        			sum += i;
        		
        		}
        		System.out.println("\n sum " + sum);
        		System.exit(0);
        		
        	}
        	return;
        }
 
        // start from the next index till the last index
        for (int j = index; j < lengthOfThing; j++) {
        	
        	track[ti] = A[j];
        	findCombinationsOfSizeRecurCheckPrimesi(A, track , j + 1, lengthOfThing, sampleSize - 1, ti + 1);
        	
            // uncomment the following code to handle duplicates
            /* while (j < n - 1 && A[j] == A[j + 1]) {
                j++;
            } */
        }
    }
	
	public static int[] splitStringToNums(String s ) {
		String[] spl = s.trim().split(" ");
    	int[] nums = new int[spl.length];
    	for(int i=0; i<spl.length; i++) {
    		nums[i] = Integer.parseInt(spl[i]);
    	}
    	return nums;
	}
	
	public static boolean checkIntCombinationsForPrimes(int[] nums) {
		
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<nums.length; j++) {
				
				String strNum = nums[i] + "" + nums[j];
				Integer newI = Integer.parseInt(strNum);
				//System.out.println("checking " + newI);
				if(!Util.isPrime(newI)) {
					return false;
				}
				
				strNum = nums[j] + "" + nums[i];
				newI = Integer.parseInt(strNum);
				if(!Util.isPrime(newI)) {
					return false;
				}
				
			}
		}
		
		return true;
	}

}
