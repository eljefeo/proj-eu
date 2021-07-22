import java.util.List;

public class Problem39 extends ProblemImpl{

	
	/*
	 If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
	
	{20,48,52}, {24,45,51}, {30,40,50}
	
	For which value of p <=1000, is the number of solutions maximised?
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem39();
		p.runProblem();
	}
	
	public void problem(){
		// Right triangle perimeter = a+b + sqrRoot(a^2 + b^2)
		// a and b are the 2 sides on the right angle. C is the longest side
		// a^2 + b^2 = c^2
		// perimeter = a + b + c
		int min = 10;
		int max = 1000;
		
		int maxPCount = 0;
		int maxP = 0;
		for(int p=min; p<=max; p++){
			List<int[]> sols = Util.findRightTriangleSidesFromPerimeter(p);
			if(sols.size() > maxPCount){
				maxPCount = sols.size();
				maxP = p;
			}
		}
		System.out.println("Answer: " + maxP + " with count " + maxPCount);
	}
	


}
