
public class Problem28 extends ProblemImpl{
	/*
	 * Starting with the number 1 and moving to the right in a clockwise
	 * direction a 5 by 5 spiral is formed as follows:
	 
	 	21 22 23 24 25 
	 	20  7  8  9 10  
	 	19  6  1  2 11 
	 	18  5  4  3 12 
	 	17 16 15 14 13 
	 				
	 
	 * It can be verified that the sum of the numbers on the diagonals is 101.
	 * 
	 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
	 * formed in the same way?
	 * 
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem28();
		p.runProblem();
	}

	@Override
	public void problem() {
		int side = 1001;
		int sum = addCorners(side);
		if(sum != -1){
			System.out.println("Total sum of all spiral corners for a square of size " + side + " = " + sum);
		}
	}
	
	private static int addCorners(int side){
		if(side < 1 || side%2 == 0){
			System.out.println("A side must be a positive odd integer, ya dummy. Use a different number.");
			return -1;			
		}
		int totalSum = 1;
		while (side > 1){
			for(int i=0; i<4; i++){
				totalSum += side*side - (i*side) + i;
			}
			side -= 2;
		}
		return totalSum;
	}
}
