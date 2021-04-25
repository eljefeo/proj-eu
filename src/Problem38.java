import java.util.ArrayList;
import java.util.List;

public class Problem38 {
	/*
	 * Take the number 192 and multiply it by each of 1, 2, and 3:
	 * 
	 * 192 x 1 = 192 192 x 2 = 384 192 x 3 = 576 By concatenating each product
	 * we get the 1 to 9 pandigital, 192384576. We will call 192384576 the
	 * concatenated product of 192 and (1,2,3)
	 * 
	 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3,
	 * 4, and 5, giving the pandigital, 918273645, which is the concatenated
	 * product of 9 and (1,2,3,4,5).
	 * 
	 * What is the largest 1 to 9 pandigital 9-digit number that can be formed
	 * as the concatenated product of an integer with (1,2, ... , n) where n >
	 * 1?
	 */

	public static void main(String[] args) {
		problem();
	}

	private static void problem() {
		int maxSol = 0;
		int min = 1;
		int max = 999999;
		List<int[]> numsAndN = new ArrayList<int[]>();
		
		for (int i = min; i < max; i++) {
			int num = i;
			for (int j = 2; j < 10; j++) {
				int newProd = j*i;
				
				if((Util.countDigits(newProd) + Util.countDigits(num)) > 9){
					break;
				}
				
				num = Util.appendIntToInt(num, (j*i));
			
				if(Util.isPandigitalNumberOneToNine(num)){
					if (num>maxSol){
						maxSol = num;
					}
					int[] sol = new int[]{i, j, num};
					numsAndN.add(sol);
				}
			}

		}
		
		for(int[] arr : numsAndN){
			System.out.println("Found sol : " + arr[0]  + " :: 1..." +arr[1] + " = " + arr[2] );
		}
		System.out.println("Max : " + maxSol);
	}
	
/*	private static int[] appendIntArrayToIntArray(int[] someNums, int[]allNums){
		/// go through allnums and when we hit -1, start adding someNums to allNums at that index;
		if(someNums.length > allNums.length){
			System.out.println("ERROR - Cannot add someNums to AllNums, someNums is too big : " + someNums.length + " to fit in " + allNums.length);
			return null;
		}
		int ind = 0;
		for (int i = 0; i < allNums.length; i++) {
			if(allNums[i] == -1){
				ind = i;
				break;
			}
		}
		for (int i = ind; i < allNums.length; i++) {
			allNums[i] = someNums[i];
		}
		return allNums;
	}*/

	
}
