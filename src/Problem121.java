import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem121 implements Problem { //Took 0.048192 seconds

	
	/*
	 * A bag contains one red disc and one blue disc. In a game of chance a player takes a disc at random and its colour is noted. After each turn the disc is returned to the bag, an extra red disc is added, and another disc is taken at random.

The player pays £1 to play and wins if they have taken more blue discs than red discs at the end of the game.

If the game is played for four turns, the probability of a player winning is exactly 11/120, and so the maximum prize fund the banker should allocate for winning in this game would be £10 before they would expect to incur a loss. Note that any payout will be a whole number of pounds and also includes the original £1 paid to play the game, so in the example given the player actually wins £9.

Find the maximum prize fund that should be allocated to a single game in which fifteen turns are played.
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem121();
		p.runProblem();
	}
	
	@Override
	public Object problem() {
		int turnCount = 15; // breaks at 2 need to fix?
		
		BigInteger howMuchToGive = howMuchShouldBankerGive(turnCount);
		//System.out.println("Banker should give : " + howMuchToGive);
		return howMuchToGive;
	}
	
	private static int howManyCanYouMiss(int turns){
		return turns - ((turns / 2)  + 1 );
	}
	
	private static BigInteger getTotalPaths(int turns){
		return Util.factorial(new BigInteger(""+ (turns + 1)));
	}
	
	private static BigInteger howMuchShouldBankerGive(int turns){
		
		BigInteger winPaths = howManyPathsWin(turns);
		BigInteger totalPaths = getTotalPaths(turns);
		
		//double ratio = totalPaths/winPaths;
		
		//System.out.println("Turn count: " + turns);
		//System.out.println("How many paths win: " + winPaths);
		//System.out.println("How many total paths: " + totalPaths);
		BigInteger ratio =  totalPaths.divide(winPaths);
		//System.out.println("ratio win to total count: " + ratio);
		
		return ratio;
		
	}

	private static BigInteger howManyPathsWin(int turnCount) {

		int missCount = howManyCanYouMiss(turnCount);
		BigInteger totalCount = BigInteger.ZERO;
		
		System.out.println("How many can be wrong: " + missCount);
		System.out.println("How many need to be right: " + (turnCount - missCount));
		
		int[] reds = new int[turnCount];
		for(int i=1; i<=turnCount; i++){ // this builds an array like {1, 2, 3, 4, 5, 6, 7, ... depending on how many turns
											// we will use this to keep track of the different combinations of turns that can be misses
											// and will look through how many reds in each to find out how many paths in the total tree
			reds[i-1] = i;
		}
		
		for(int i=0; i <= missCount;i++) { // if there are 5 turns, then you could win with 0 misses, 1 miss, or 2 misses...
											// we are doing it kinda reversed. We are assuming there is a winning turn,
												// and then calculating how many different ways you could win that way
												// like if you win on turns 1, 2, 3 - how many different combos of the other reds on turns 4 and 5 could there be?
												// that is the number of ways to win on turns 1,2,3
												// then do the same for the other combinations of winning turns
												//(this for loop is to inlcude winning with 0 misses, 1 miss, etc.. up until max num of misses)
			List<String> combs = new ArrayList<String>();
			Util.findCombinationsOfSizeRecurKeepTrack(reds, "", 0, reds.length, i, combs);
			totalCount = calcPathCombinations(combs, totalCount);
		}
		
		System.out.println("Final totalc : " + totalCount);
		
		return totalCount;
		
	}
	
	
	private static BigInteger calcPathCombinations(List<String> combs, BigInteger totalCount) {
		System.out.println("Row combination count (size) : " + combs.size() + " totalCount coming in: " + totalCount);
		for(String s : combs){
			s = s.trim();
			String[] spl = s.split(" ");
			BigInteger oneRowCounter = BigInteger.ONE;
				for(int i=0; i<spl.length; i++){
					if(spl[i] != "") { // this means we had a combination of size 0 (no combo of rows)
						int aRow = Integer.parseInt(spl[i]);
						oneRowCounter = oneRowCounter.multiply(new BigInteger(""+aRow));
					}
				}
				
				totalCount = totalCount.add(oneRowCounter);
		}
		
		return totalCount;
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
