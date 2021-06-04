import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem121 {

	
	/*
	 * A bag contains one red disc and one blue disc. In a game of chance a player takes a disc at random and its colour is noted. After each turn the disc is returned to the bag, an extra red disc is added, and another disc is taken at random.

The player pays £1 to play and wins if they have taken more blue discs than red discs at the end of the game.

If the game is played for four turns, the probability of a player winning is exactly 11/120, and so the maximum prize fund the banker should allocate for winning in this game would be £10 before they would expect to incur a loss. Note that any payout will be a whole number of pounds and also includes the original £1 paid to play the game, so in the example given the player actually wins £9.

Find the maximum prize fund that should be allocated to a single game in which fifteen turns are played.
	 */
	
	public static void main(String[] args) {
		problem();
		
		
	}
	
	private static void problem() {
		int turnCount = 9; // breaks at 2 need to fix?
		
		long howMuchToGive = howMuchShouldBankerGive(turnCount);
		System.out.println("Banker should give : " + howMuchToGive);
		
		
		//other(4); //9219406943
				other2(turnCount);
				//System.out.println("Num can be wrong : " + howManyCanBeWrong(4) + " how many total paths: " + getTotalPaths(4));
		
	}
	
	private static int howManyCanBeWrong(int turns){
		return turns - ((turns / 2)  + 1 );
	}
	
	private static int getTotalPaths(int turns){
		return Util.factorial(turns + 1);
	}
	
	private static int howMuchShouldBankerGive(int turns){
		
		long winPaths = howManyPathsWin(turns);
		long totalPaths = getTotalPaths(turns);
		
		double ratio = totalPaths/winPaths;
		
		System.out.println("Turn count: " + turns);
		System.out.println("How many paths win: " + winPaths);
		System.out.println("How many total paths: " + totalPaths);
		System.out.println("ratio win to total count: " + ratio);
		
		for(int i=1; i<10000; i++){
			long bankerGives = i*winPaths;
			long bankerTakes = totalPaths - winPaths;
			
			if(bankerGives > bankerTakes){
				return (i-1) + 1; //we add one here because the banker will also give back the players $1 they paid to play the game
			}
			
		}
		
		return 0;
		
	}

	private static long howManyPathsWin(int turnCount) {

		int allBlue = 1; // always 1 path leads to all blue
		int missCount = howManyCanBeWrong(turnCount);
		
		long totalCount = 0;
		
		System.out.println("How many can be wrong: " + missCount);
		System.out.println("How many need to be right: " + (turnCount - missCount));
		//int totalPaths = getTotalPaths(turnCount);
		
		int[] reds = new int[turnCount];
		for(int i=1; i<=turnCount; i++){ // this builds an array like {1, 2, 3, 4, 5, 6, 7, ... depending on how many turns
											// we will use this to keep track of the different combinations of turns that can be misses
											// and will look through how many reds in each to find out how many paths in the total tree
			reds[i-1] = i;
		}
		
		
		
		
		for(int i=0; i <= missCount;i++) {
			//System.out.println("... totalCount start " + totalCount);
			List<String> combs = new ArrayList<String>();
			Util.findCombinationsOfSizeRecurKeepTrack(reds, "", 0, reds.length, i, combs);
			totalCount = calcPathCombinations(combs, totalCount);
			//System.out.println("... totalCount end " + totalCount);
		}
		
		
		
		
		
		// we are only doing the number of ways for the minimum to win (3 of 5 tries)
				// but what about if they get 4 of 5? That also wins...
		

		
		//totalCount += allBlue; // Since no miss is always an option that works for any case, just always add it now.
		System.out.println("Final totalc : " + totalCount);
		
		return totalCount;
		
	}
	
	
	private static long calcPathCombinations(List<String> combs, long totalCount) {
		System.out.println("Row combination count (size) : " + combs.size() + " totalCount coming in: " + totalCount);
		for(String s : combs){
			s = s.trim();
			//System.out.println("Row combinations to do : " + s);
			String[] spl = s.split(" ");
			
			long oneRowCounter = 1;
				for(int i=0; i<spl.length; i++){
					//System.out.println("One row to do :" + spl[i] + ":");
					
					if(spl[i] != "") { // this means we had a combination of size 0 (no combo of rows)
						Long aRow = Long.parseLong(spl[i]);
						//System.out.println(" oneRowCounter :" + oneRowCounter + ":aRow:" + aRow + " totalCount:" + totalCount + " totalCount * aRow " + (oneRowCounter*aRow));
						oneRowCounter *= aRow;
					} else {
						
					}
					
				}
				
				totalCount += oneRowCounter;
				//System.out.println(" totalc : " + totalCount + "\n");
			
		}
		
		return totalCount;
		
	}
	
	
	private static void other(int limit){
		//int limit = 7;
		long[] outcomes = new long[limit+1];
		outcomes[limit] = 1;
		outcomes[limit-1] = 1;
		                         
		for (int i = 2; i <= limit; i++) {
		    for(int j = 0; j < outcomes.length-1; j++){
		        outcomes[j] = outcomes[j + 1];                    
		    }
		    outcomes[limit] = 0;
		                 
		    for (int j = outcomes.length-1; j > 0; j--) {
		        outcomes[j] += outcomes[j - 1] * i;
		    }
		}
		          
		long positive = 0;
		for (int i = 0; i < limit / 2+1; i++) {
		    positive += outcomes[i];
		}
		
		System.out.println("Positive? " + positive);
		
	}
	
	

	
	private static String other2(int turns) {
		// Dynamic programming
		
		//int turns = 15;
		
		BigInteger[][] ways = new BigInteger[turns + 1][];
		ways[0] = new BigInteger[]{BigInteger.ONE};
		for (int i = 1; i <= turns; i++) {
			ways[i] = new BigInteger[i + 1];
			for (int j = 0; j <= i; j++) {
				BigInteger temp = BigInteger.ZERO;
				if (j < i)
					temp = ways[i - 1][j].multiply(BigInteger.valueOf(i));
				if (j > 0)
					temp = temp.add(ways[i - 1][j - 1]);
				ways[i][j] = temp;
			}
		}
		
		BigInteger numer = BigInteger.ZERO;
		System.out.println("Other guys turns /2 +1 " + (turns / 2 + 1));
		for (int i = turns / 2 + 1; i <= turns; i++)
			numer = numer.add(ways[turns][i]);
		long denoml = Util.factorial(turns + 1);
		BigInteger denom = new BigInteger(""+denoml);
		System.out.println("Done with other guys RUN: " + " denom? " + denom + " numer? " + numer + " ... "+ denom.divide(numer).toString());
		return denom.divide(numer).toString();
	}
		/*
		 different outcomes:
		 br
		 brr
		 brrr
		 brrrr
		 
		 wins:
		1/2 or 2/2 (b)r
		1/3 or 3/3 (b)rr
		1/4 or 4/4 (b)rrr
		1/5 or 5/5 (b)rrrr
		 
		(b)r
		(b)rr
		(b)rrr
		 b(r)rrr
		 
		(b)r
		(b)rr
		(b)rrr
		 br(r)rr
		 
		 etc..
		 
		 
		 for 3
		 br
		 brr
		 brrr
		 
		 with 0 misses = 1 way (all b)
		 with 1 miss = : add all r's plus the first winning all blue = 7
		 with 2 miss = : number of r's in last row * number of r's above ( 3 * 3 )
		 		: plus next row up --- number of rs in this row * num of r's above ( 2 * 1 )
		 		 		= 11 (plus the other solutions above (7) ) = 18
		 with 3 miss = : solutions above plus:
		 		 		+ different ways to make all r's (6)
		 		 		= 24
		 		 		
		 		 		
		 		 		
		 for 4
		 br			1	
		 brr		2
		 brrr		3
		 brrrr		4
		 
		 we are essentially solving for how many combinations of rows to include where size n (where n is number of misses) in ...
		 
		 
		 1 miss = count number of r's (10) plus 0 misses (1) = 11
		 2 miss = top row count of r's * rest of count of r's (1*9 = 9)
		 		plus second row, count of r's * rest of count of r's (2 x 7) = 14,
		 		plus third row, count of r's * rest of count of r's (3 x 4) = 12 = (9 + 14 + 12 = 35)
		 		 plus 1 miss, plus 0 misses (35 + 11) = 46 
		 
		 with 0 misses = 1 way (all b)
		 with 1 miss = : add all r's (10) plus the first winning all blue = 11
		 with 2 miss = : number of r's in last row * number of r's above ( 3 * 3 )
		 		: plus next row up --- number of rs in this row * num of r's above ( 2 * 1 )
		 		 		= 11 (plus the other solutions above (7) ) = 18
		 with 3 miss = : solutions above plus:
		 		 		+ different ways to make all r's (6)
		 		 		= 24
		 		 		
		 
		 b
		 b
		 b
		 
		 b
		 b
		  r
		  
		 b
		 b
		   r
		 
		 b
		 b
		    r
		    
		 b
		  r
		 b
		 
		 b
		  r
		  r
		  
		 etc..
		 
		 
		 */
	

}
