
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
	 ways to make 5:
	 	4 + 1
		3 + 2
		3 + 1 + 1
		2 + 2 + 1
		2 + 1 + 1 + 1
		1 + 1 + 1 + 1 + 1
		
		reversed:
		
		2 + 3
		1 + 4
		1 + 1 + 3
		1 + 2 + 2
		1 + 1 + 1 + 2
		1 + 1 + 1 + 1 + 1
		
		ways to make 4:
		3 + 1
		2 + 2
		2 + 1 + 1
		1 + 1 + 1 + 1
		
		reversed:
		2 + 2
		1 + 3
		1 + 1 + 2
		1 + 1 + 1 + 1
		
		ways to make 3:
		2 + 1
		1 + 1 + 1
		
		reversed:
		1 + 2
		1 + 1 + 1
		
		ways to make 2: 
		1 + 1
	 */
	public static void main(String[] args) {
		Problem p = new Problem76();
		p.runProblem();

	}

	@Override
	public Object problem() {
		System.out.println("Here we go");
		entry();
		return null;
	}
	
	private static void entry() {
		
		
		int test = 5;
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
