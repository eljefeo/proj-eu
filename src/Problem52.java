
public class Problem52 implements Problem { //Took 0.064497 seconds

	
	/*
	   
	   It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

		Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
	   
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem52();
		p.runProblem();

	}
	
	public String problem(){
		
		for(int i=10; i<Integer.MAX_VALUE; i++){
			boolean hasSame = true;
			for(int j=2; j<7; j++){
				if(!Util.hasSameUniqueDigits(i, i*j)){
					hasSame = false;
					break;
				}
			}
			
			if(hasSame){
				System.out.println("HAS SAME !!! " + i);
				return "" + i;
			}
			
		}
		
		System.out.println("done...no answer??? - You need to go Long...   ;)");
		return null;
	}
	
	
	
	

}
