import java.util.ArrayList;
import java.util.List;

public class Problem64 implements Problem { //Took 0.067875 seconds

	
	//Odd period square roots
	
	public static void main(String[] args) {
		Problem p = new Problem64();
		p.runProblem();
	}
	
	public String problem() {
		
		int max = 10000;
		int oddPerCounter = 0;

		for(int i = 2; i < max; i++) {
			
			double sn = Math.sqrt(i);
			int firstWholeNum = (int) sn;
			
			if(sn - firstWholeNum == 0) {
				continue; // dont do normal squares...
			}
			
			firstWholeNum = firstWholeNum * -1;
			int firstBottom = 1;
			
			List<Integer[]> track = new ArrayList<Integer[]>();
			
			track.add(new Integer[] {firstWholeNum, firstBottom} );
			
			boolean foundPeriod = false;
			while(!foundPeriod) {
				int firstNumer = firstBottom; // do reciprocal first, numer becomes denom for next iteration
				firstWholeNum = firstWholeNum * -1 ; // + 3
				firstBottom = i - (firstWholeNum * firstWholeNum); // 23 - 9 = 14
				double firstBottomD = firstBottom / firstNumer;
				
				// check if numer and denom can be simplified down to 1 on the numerator (like 7/14 or 5/20 ... error if something like 9/12)
				if(firstBottomD - (int)firstBottomD != 0) {
					System.out.println("ERROR .... with " + firstBottomD + "  for first " +  firstWholeNum + " first numer " + firstNumer);
					return "-1";
				}
				
				firstBottom = (int) firstBottomD;
				int extractNextWholeNum = (int) (sn + firstWholeNum) / firstBottom;
				firstWholeNum = firstWholeNum - (extractNextWholeNum * firstBottom); // should be 4 - (1*7) = -3
				
				// Check for period:
				Integer[] current = new Integer[] {firstWholeNum, firstBottom};
				for(int j=0; j < track.size();j++) {
					Integer[] ia = track.get(j);
					if(ia.length == 2 && ia[0] == current[0] && ia[1] == current[1]) {
						int periodSize = track.size() - j;

						if(periodSize > 0 && periodSize % 2 != 0) {
							oddPerCounter++;
						}
						foundPeriod = true;
						break;
					}
				}
				
				track.add(current);
				
			}
		}
		
		//System.out.println("Odd period count under " + max + " :: " + oddPerCounter);
		return "" + oddPerCounter;
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
		
	
	//}

}
