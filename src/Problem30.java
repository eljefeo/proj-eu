
public class Problem30 implements Problem {
	
	/*
	 Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
	 1634 = 1^4 + 6^4 + 3^4 + 4^4
	 8208 = 8^4 + 2^4 + 0^4 + 8^4
	 9474 = 9^4 + 4^4 + 7^4 + 4^4 
	 
	 As 1 = 1^4 is not a sum it is not included.
	 
	 The sum of these numbers is 1634 + 8208 + 9474 = 19316.
	 Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
	 
	 
	 */

	public static void main(String[] args) {
		
		Problem p = new Problem30();
		p.runProblem();
		//problemOrig();
		//int n = 9;
		//System.out.println("");
		//for(int i=1; i < 10; i++)
		//	System.out.println("Fifth power of " + i + " : " + Math.pow(i, 5));
		
		
		//problem1();
	}
	
	
	public static Object problem1(){
		int pow = 5;
		int num = 9;
		int tottot = 0;
		// TODO while (???? How do we know when to stop????? - 
		// I just went up to 1,000,000 hoping they would all be below 1,000,000 but how would I have known when I found them all?
		// neeed to figure out some way of knowing when to stop looking for the 4th or 5th or Nth powers...
		//194980
		//for(int i=2; i< 12; i++) {
			String is = num+"";
			int tot = 0;
			for(char c : is.toCharArray()){
				System.out.println("i: " + num + " c: " + c );
				tot += Math.pow(Integer.parseInt(c+""),pow);
			}
			if(tot == num) {
				tottot += tot;
				System.out.println("Found one!  :::  " + num + " with tot: " + tot );
			}
		//}
		System.out.println("Total!  :::  " + tottot + " " + tot);
		return tottot;
	}
	
	/*
	 so lets think about when to stop..
	 The question says: Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
	 Meaning there is a finite number of these.. how can we tell when we have gone too far..
	 fifth powers and sum of their digits
	 10000 = 1
	 10002 = 33
	 99999 = 295245
	 
	 
	 
	 
	 */
	
	@Override
	public Object problem(){
		int pow = 5;
		int tottot = 0;
		// TODO while (???? How do we know when to stop????? - 
		// I just went up to 10,000,000 hoping they would all be below 10,000,000 but how would I have known when I found them all?
		// neeed to figure out the proof of how they knew when to stop looking for the 4th powers...
		for(int i=2; i< 1000000; i++){
			String is = i+"";
			int tot = 0;
			for(char c : is.toCharArray()){
				tot += Math.pow(Integer.parseInt(c+""),pow);
			}
			if(tot == i){
				tottot += tot;
				System.out.println("Found one!  :::  " + i);
			}
		}
		//System.out.println("Total!  :::  " + tottot);
		return tottot;
	}

	@Override
	public int getId() {
		return 30;
	}
}
