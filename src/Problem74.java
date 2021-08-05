import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem74 implements Problem {

	
	/*
	 
	 
	 The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:

1! + 4! + 5! = 1 + 24 + 120 = 145

Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it turns out that there are only three such loops that exist:

169 -> 363601 -> 1454 -> 169
871 -> 45361 -> 871
872 -> 45362 -> 872

It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,

69 -> 363600 -> 1454 -> 169 -> 363601 (-> 1454)
78 -> 45360 -> 871 -> 45361 (-> 871)
540 -> 145 (-> 145)

Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a starting number below one million is sixty terms.

How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
	 
	 
	 */
	
	
	public static void main(String[] args) {
		Problem p = new Problem74();
		
		p.runProblem();
	}
	
	public String problem() {
		
		int maxChain = 60, count = 0;
		
		
		
		Map<Integer, Integer> loops = new HashMap<Integer, Integer>();
		
		for(int i=1; i<5; i++) {
			if(i % 100000 == 0)
				System.out.println("doing " + i);
			
			int num = i, lastInd = 0;
			
			List<Integer> hist = new ArrayList<Integer>();
			//while(!hist.contains(num)) {
			while((lastInd = hist.indexOf(num)) == -1) {
				hist.add(num);
				System.out.println("Adding " + num);
				int[] arr = Util.splitIntNumsToArray(num);
				num = 0;
				for(int j : arr) 
					num += Util.factorial(j);
				
			}
			
			
			
			/*
			 so at this point we know we repeat
			 we also know the index of the num we were about to add..
			 so we generated a num with teh factorials of the digits
			 then we found out hey we already did this number..
			 
			 
			 
			 */


			System.out.print("History of " + i + " size=" + hist.size() + " lastIndex=" + lastInd +  " :: ");
			for(int j=0; j<hist.size(); j++) {
				System.out.print(", " + hist.get(j));
				loops.put(hist.get(j), hist.size()-1-j);
			}
			System.out.println();
			
			for(int j : loops.keySet()) {
				System.out.println("loop : " + j + "=" + loops.get(j));
			}
			
			if(hist.size() == maxChain) {
				count++;
			}
			
			
			
			//to speed it up
			/*
			   what if we keep track of the nums that cause a loop...
			   so like
			   	69 -> 363600 -> 1454 -> 169 -> 363601 (-> 1454)
				78 -> 45360 -> 871 -> 45361 (-> 871)
				540 -> 145 (-> 145)
			   
			   so we can put all those numbers in a list? or set better yet?
			   
			 */
			
			for(int j=0; j<hist.size(); j++) {
				if(hist.get(j) == num) {
					System.out.println(i + " repeats at " + j + " == " + hist.get(j) + " :: " + (hist.size()-1));
				}
			}
			
			//so how did we get here
			// either we got in a loop, or we hit 60 numbers
			// if we got here in a loop...well dont they all loop?
			
			
		}
		
		return "" + count;
	}
	
	public String problemWithPrimitiveArr() {
	
		int maxChain = 60, count = 0;
		
		//to speed it up
		/*
		   what if we keep track of the nums that cause a loop...
		   so like
		   	69 -> 363600 -> 1454 -> 169 -> 363601 (-> 1454)
			78 -> 45360 -> 871 -> 45361 (-> 871)
			540 -> 145 (-> 145)
		   
		   so we can put all those numbers in a list? or set better yet?
		   
		 */
		
		
		Set<Integer> loops = new HashSet<Integer>();
		
		for(int i=1; i<1000000; i++) {
			if(i % 100000 == 0)
				System.out.println("doing " + i);
			
			int num = i;
			
			int[] hist = new int[maxChain];
			while(!arrContainsInt(hist, num)) {
				if(addToNextOpenInd(hist, num) == maxChain - 1) {
					count++;
					break;
				}
				int[] arr = Util.splitIntNumsToArray(num);
				num = 0;
				for(int j : arr) {
					int iFact = Util.factorial(j);
					num += iFact;
				}
			}
		}
		
		return "" + count;
	}
	

	private int addToNextOpenInd(int[] arr, int test) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0) {
				arr[i] = test;
				return i;
			}
		}
		return -1;
	}

	public boolean arrContainsInt(int[] arr, int num) {
		// we will assume we are putting values in the array from lower index to higher index
		// and all unused indexes will have value 0
		for(int i=0; i<arr.length; i++) {
			int val = arr[i];
			if(val == 0)
				break;
			
			if(val == num)
				return true;
		}
		
		return false;
	}
	

}
