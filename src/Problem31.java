import java.util.ArrayList;
import java.util.List;

public class Problem31 {

	/*
	 * In the United Kingdom the currency is made up of pound ($) and pence (p).
	 * There are eight coins in general circulation:
	 * 
	 * 1p, 2p, 5p, 10p, 20p, 50p, x$1 (100p), and x$2 (200p).
	 * 
	 * It is possible to make $2 in the following way:
	 * 
	 * 1x1 + 1x50p + 2x20p + 1x5p + 1x2p + 3x1p How many different ways can $2
	 * be made using any number of coins?
	 * 
	 */
//	public static List<Integer[]> allcombs;

	public static void main(String[] args) {

		go();

	}

	private static void problem2() {
		int arr[] = { 1, 2, 3, 4 };
		// int[] coins = {1,2,5,10,20,100,200};
		int[] coins = { 1, 2, 3 };
		int n = coins.length;
		int combSize = 3;
		//go(coins, n, combSize);
	}

	static void go() {
		
		int combSize = 3;
		
		int[] data = { 0, 1, 2, 3, 4, 5, 6};
		List<Integer[]> allcombs = new ArrayList<Integer[]>();
		
		
		int indexToChange = combSize-1; // start with last num in comb
		boolean fin = false;
		Integer[] comb = new Integer[] {data[0],data[0],data[0]};
		Integer[] fComb = new Integer[] {data[0],data[0],data[0]};
		allcombs.add(fComb);
		System.out.println("finished comb " + comb[0] + " " + comb[1] + " " + comb[2]);
		
		
		while(!fin){
			boolean reset = false;
					while(comb[indexToChange] == data[data.length-1] && indexToChange > 0){
						comb[indexToChange] = data[0];
						indexToChange--;
						reset = true;
					}
					int lasti = getIndex(data, comb[indexToChange]);
					comb[indexToChange] = data[lasti+1];
					
				
			
			System.out.println("indexToChange=" + indexToChange + " comb[indexToChange]="  + comb[indexToChange] );
			//Integer[] addComb = new Integer[combSize];
			boolean isDone = true;
			for(int i=0;i<combSize;i++){
				if(comb[i]!=data[data.length-1]) {
					isDone = false;
				break;
				}
			}

			allcombs.add(comb.clone());
			if(isDone)fin = true;
			System.out.println("finished comb " + comb[0] + " " + comb[1] + " " + comb[2]);
			if(reset) indexToChange = combSize-1;
		
			
		}
		
		
		for (Integer[] in : allcombs){
			for (int i = 0; i < in.length; i++) {
				System.out.print(": " + in[i]);
			}
			System.out.println();
		}
		
		System.out.println("Final count of combinations : " + allcombs.size());
		
		
	}
	
	private static int getIndex(int[] data, int num){
	
		for(int i=0; i<data.length; i++){
			if(data[i] == num){
				return i;
			}
		}
		return 0;
	}


}
