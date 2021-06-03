
public class Problem54 {
	
	/*
	 * project euler problem 54 talks about 5 card poker rules in depth here....
	 * 
	 * then it says:
	 * 
	 * The file, poker.txt (which I put in Problem54Helper class), contains one-thousand random hands dealt to two players. 
	 * Each line of the file contains ten cards (separated by a single space): 
	 * 	the first five are Player 1's cards and the last five are Player 2's cards. 
	 * 
	 * You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, 
	 * 	and in each hand there is a clear winner.

			How many hands does Player 1 win?
	 * 
	 * 
	 */
	
	public static void main(String[] args){
		problem();
	}

	private static void problem() {
		String[][] allHands = Problem54Helper.getHands(); 
		//String[] aHand =  new String[] {"4S", "3S", "2S", "AS", "5S"};
		//String[] bHand =  new String[] {"7C", "8C", "5C", "QD", "6C"};
		//String res = Util.deadHorseHumanEncodeFullHandEval(aHand[0], aHand[1], aHand[2], aHand[3], aHand[4]);
		//int res = Util.deadHorsePokerHumanEncodeEval5(aHand[0], aHand[1], aHand[2], aHand[3], aHand[4]);
		
		//System.out.println("Resulting hand : " + res);
		//deadHorsePokerHumanEncodeEval5
		
		int player1WinCount = 0;
		
		
		
		for(String[] sa : allHands){
			int player1Result = Util.deadHorsePokerHumanEncodeEval5(sa[0], sa[1], sa[2], sa[3], sa[4]);
			int player2Result = Util.deadHorsePokerHumanEncodeEval5(sa[5], sa[6], sa[7], sa[8], sa[9]);
			
			if(player1Result > player2Result){
				player1WinCount++;
			}
			
		}
		
		System.out.println("player 1 won this many: " + player1WinCount);
		
	}
}
