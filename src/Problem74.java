import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem74 implements Problem { //Took 0.271176 seconds

	
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
		//doChainUntilLoop(10200);
	}
	
	@Override
	public String problem() {
		
		int maxChain = 60, count = 0;
		Map<Integer, Integer> loops = new HashMap<Integer, Integer>();
		int max = 1000000;
		
		for(int i=1; i<max; i++) {
			if(i % 100000 == 0)
				System.out.println("doing " + i + " with count at " + count);
			
			int num = i, lastInd = 0;
			List<Integer> hist = new ArrayList<Integer>();
			while(true) {
				Integer loopRep = loops.get(num);
				if(loopRep != null) {
					// this means we already encountered this num
					// and we know how many nums until the repeat happens for this num
					// we dont have to go figure that out anymore, done for this num
					for(int j=0; j<hist.size(); j++) 
						loops.put(hist.get(j), loopRep + hist.size() - j);
						
					// we take the num we have found already, then add it to the history size so far for this num
					// the history here is just holding numbers we have not encountered yet
					// we then add them to the loops so we dont have to figure them out in the next
					// 		iterations if we come across them
					
					if(hist.size() + 1 + loopRep == maxChain) 
						count++;
					
					 break;
				}
				
				lastInd = hist.indexOf(num); // index (if exists) of the num we just did in last loop
				
				if(lastInd != -1) {
					
					for(int j=0; j<lastInd+1; j++) 
						loops.put(hist.get(j), hist.size()-1-j);
						
					for(int j=lastInd+1; j < hist.size(); j++) 
						loops.put(hist.get(j), hist.size()-1-lastInd);
						
					if(hist.size() == maxChain) 
						count++;
					
					break;
				}
				
				hist.add(num);
				int[] arr = Util.splitIntNumsToArray(num);
				num = 0;
				for(int j : arr) 
					num += Util.factorial(j);
			}
			
			/*
			for(int j : loops.keySet()) {
				System.out.println("loop : " + j + " = " + loops.get(j) );
				int cc= doChainUntilLoop(j);
				if(cc != loops.get(j)) {
					System.out.println("Do not match : " + j + " = " + cc + " vs " + loops.get(j));
				} else {
					System.out.println("Do YES match : " + j + " = " + cc + " vs " + loops.get(j));
				}
			}
			*/
			
			/*
			 so at this point we know we repeat
			 we also know the index of the num we were about to add..
			 so we generated a num with teh factorials of the digits
			 then we found out hey we already did this number..
			 
			 */

		}
		
		return "" + count;
	}
	
	

	
	public String problemOldSlow() {
	
		int maxChain = 60, count = 0;
		
		for(int i=1; i<1000000; i++) {
			if(i % 100000 == 0)
				System.out.println("doing " + i + " with count at " + count);
			
			int num = i;
			
			int[] hist = new int[maxChain];
			while(!Util.arrContainsInt(hist, num)) {
				if(Util.addToNextOpenInd(hist, num) == maxChain - 1) {
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

		//to speed it up
		/*
		   what if we keep track of the nums that cause a loop...
		   so like
		   	69 -> 363600 -> 1454 -> 169 -> 363601 (-> 1454)
			78 -> 45360 -> 871 -> 45361 (-> 871)
			540 -> 145 (-> 145)
		   
		   so we can put all those numbers in a list? or set better yet? ..... (update: we did this in the new function above, much better)
		   
		 */
		
		
	}
	


	

}
