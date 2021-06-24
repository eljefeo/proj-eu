import java.util.ArrayList;
import java.util.List;

public class Problem64 {

	
	//Odd period square roots
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		problem	();
	}
	
	private static void problem() {
		int nnn = 23;
		double sn = Math.sqrt(nnn);
		int firstWholeNum = (int) Math.sqrt(nnn);
		
		
		int finalTopWholeNum = firstWholeNum * -1;
		int firstBottom = 1;
		//int firstNum = -4;
		//int firstNumer = 1;
		
		//int firstTopNum = firstNum * -1 ; // + 3
		/// started with 1 / sq23-4
		//int firstBottom = nnn - (firstTopNum * firstTopNum); // 23 - 9 = 14
		/////SHOULD CHECK HERE IF IT SIMPLIFIES TO 1 BECAUSE WE NEED TO DO firstNumer / firstBottom
		//double firstBottomD = firstBottom / firstNumer;
		//if(firstBottomD - (int)firstBottomD != 0) {
		//	System.out.println("ERROR .... with " + firstBottomD + "  for first " +  firstNum + " first numer " + firstNumer);
		//}
		
		//firstBottom = (int) firstBottomD;
		//int extractNextWholeNum = (int) (sn + firstTopNum) / firstBottom;
		//int finalTopWholeNum = firstTopNum - (extractNextWholeNum * firstBottom); // should be 4 - (1*7) = -3
		//System.out.println("111 next line = sq23  + "  + finalTopWholeNum + " / " + firstBottom + " extractedwholenum: " + extractNextWholeNum);
		
		for(int i = 0; i < 6; i++) {
			int firstNum = finalTopWholeNum;
			int firstNumer = firstBottom;
			int firstTopNum = firstNum * -1 ; // + 3
			firstBottom = nnn - (firstTopNum * firstTopNum); // 23 - 9 = 14
			double firstBottomD = firstBottom / firstNumer;
			if(firstBottomD - (int)firstBottomD != 0) {
				System.out.println("ERROR .... with " + firstBottomD + "  for first " +  firstNum + " first numer " + firstNumer);
			}
			firstBottom = (int) firstBottomD;
			int extractNextWholeNum = (int) (sn + firstTopNum) / firstBottom;
			finalTopWholeNum = firstTopNum - (extractNextWholeNum * firstBottom); // should be 4 - (1*7) = -3
			System.out.println("next line = sq23  + "  + finalTopWholeNum + " / " + firstBottom + " extractedwholenum: " + extractNextWholeNum);
		}
		
		
		
	}
	
	private static void problem2() {
		int nnn = 23;
		double sn = Math.sqrt(nnn);
		int firstWholeNum = (int) Math.sqrt(nnn);
		
		int firstNumer = 1;
		
		int firstNum = firstWholeNum * -1; // - 4
		
	
		
		
		int firstTopNum = firstNum * -1 ; // +4
		/// started with 1 / sq23-4
		int firstBottom = nnn - (firstTopNum * firstTopNum); // 7
		
		// now we have sq23 + 4 on top, and 7 on bottom
		
		
		int extractNextWholeNum = (int) (sn + firstTopNum) / firstBottom;
		int finalTopWholeNum = firstTopNum - (extractNextWholeNum * firstBottom); // should be 4 - (1*7) = -3
		//System.out.println("nnn "  + nnn);
		//System.out.println("firstWholeNum "  + firstWholeNum);
		//System.out.println("firstNum "  + firstNum);
		//System.out.println("firstTopNum "  + firstTopNum);
		//System.out.println("firstBottom "  + firstBottom);
		//System.out.println("extractNextWholeNum "  + extractNextWholeNum);
		//System.out.println("finalTopWholeNum "  + finalTopWholeNum);
		System.out.println("next line = sq23  + "  + finalTopWholeNum + " / " + firstBottom + " extractedwholenum: " + extractNextWholeNum);
		
		
		
		
		
		
		
		// now we ahve extractNextWholeNum = 1
		// and sq23 + finalTopWholeNum (which is -3) / firstBottom (which is 7)
		
		//recip and repeat?
		// so 7 / sq23 - 3
		
		// next we do 
		
		int nexttop = finalTopWholeNum; // -3
		
		
	}
	/*	
		//sq23 = 4.795831523312719
		 * int wholenum = (int) sq23;
		 
		 start:
		 
		 firstTopPart = sq23 ;
		 secTopPart = -1 * wholenum;
		 secondpart = wholenum;
		 numer = 1;
		 
		 nextToppart =  sq23^2 - (4^2); // = 23 - 16 = 7
		 (so now we have 7 / ...)
		 nextBottompart = sq23 - (opposite sign of wholenum) so -1 * wholenum; (if wholenum is 
		 so now we have first part is sq23, and second part is -4
		 so first one is 4, sq23 - 4
		 
		 then recip
		 1 / sq23 - 4
		 
		
		  
		  
		- 4 
		= 4.795831523312719 = sq23 - 4
		recip
		1 / sq23 - 4
		
		.... what now
		mult both by s23 (+) 4 to cancel out
		sq23 turns to 23
		then if minus sign for -4 we get -4*4 = -16
		so 23 - 16 = 7
		
		
		since top was 1 = ( sq23 + 4 ) * 1
		since bottom was sq23 - 4 * sq23+4 = 7
		so now sq23 + 4 / 7

		so now we need to extract the whole number...
		so minus denom from whole number on top ( 4 - 7 ) = 1
		so whole num is 1,
		whats left is the sq23 -3 (because 4-7 = -3
		
		
		now we have 1, sq23 - 3 / 7 (dont forget to keep the denom)
		
		repeat
		recip first - so 7 / sq23 - 3
		mult both top and bottom by sq23 opposite minus/pos for -3 so +3
		23 - (3^2) = 23 - 9 = 7*(sq23 + 3) / 14 
		7/14 = 1/2 = sq23 + 3 / 2
		
		
		
		
		*/
		
		/*
		double s = Math.sqrt(23);
		int si = (int) s;
		System.out.println("s23 : " + s + " , and int: " + si);
		
		
		List<Double> parts = new ArrayList<Double>();
		
		for(int i=0; i<25; i++) {
			//double ss =  1 / (s - si);
			s =  1 / (s - si);
			if(parts.contains(s)) {
				//System.out.println("Has it already : " + s);
			} else {
				//System.out.println("Does not have it yet : " + s);
				parts.add(s);
			}
			//System.out.println("s : " + s );
			
			if( s < 1.26 && s > 1.12) {
				System.out.println("Hasrty : " + s);
			}
			
			si = (int) s;
			System.out.println("si : " + si );
		}
		
		*/
		
	//}

}
