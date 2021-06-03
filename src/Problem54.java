
public class Problem54 {
	
	
	public static void main(String[] args){
		problem();
	}

	private static void problem() {
		String[][] allHands = Problem54Helper.getHands(); 
		String[] aHand =  new String[] {"TS", "KS", "JS", "AS", "QS"};
		String[] bHand =  new String[] {"7C", "8C", "5C", "QD", "6C"};
		String res = Util.deadHorseHumanEncodeFullHandEval(aHand[0], aHand[1], aHand[2], aHand[3], aHand[4]);
		System.out.println("Resulting hand : " + res);
		//deadHorsePokerHumanEncodeEval5
	}
}
