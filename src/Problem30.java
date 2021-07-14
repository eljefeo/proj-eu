
public class Problem30 extends ProblemImpl{
	
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
	}
	
	@Override
	public void problem(){
		int pow = 5;
		int num = 2;
		int tottot = 0;
		// TODO while (???? How do we know when to stop????? - 
		// I just went up to 10,000,000 hoping they would all be below 10,000,000 but how would I have known when I found them all?
		// neeed to figure out the proof of how they knew when to stop looking for the 4th powers...
		for(int i=2; i< 10000000; i++){
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
		System.out.println("Total!  :::  " + tottot);
	}

}
