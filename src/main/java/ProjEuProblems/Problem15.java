package ProjEuProblems;


public class Problem15 implements Problem { //Took 0.000206 seconds

	public static void main(String[] args) {
		Problem p = new Problem15();
		p.runProblem();
	}
	
	/*Starting in the top left corner of a 2�2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
	How many such routes are there through a 20�20 grid?*/

	@Override
	public  Object problem() {
		int height = 21;
		long[][] arr = new long[height][height];
		
		for(int i = 0; i < height; i++){
			arr[i][0] = 1;
			arr[0][i] = 1;
		}
		
		for(int i = 1; i < height; i++){
			for(int j = 1; j < height; j++){
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		
		//System.out.println("result: " + arr[height-1][height-1] );
		return arr[height-1][height-1];
	}
}
