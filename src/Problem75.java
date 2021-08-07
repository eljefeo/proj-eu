import java.util.ArrayList;
import java.util.List;

public class Problem75 implements Problem{
	
	/*
	 
	 It turns out that 12 cm is the smallest length of wire that can be bent to form an integer sided right angle triangle in exactly one way, but there are many more examples.

12 cm: (3,4,5)
24 cm: (6,8,10)
30 cm: (5,12,13)
36 cm: (9,12,15)
40 cm: (8,15,17)
48 cm: (12,16,20)

In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer sided right angle triangle, 
and other lengths allow more than one solution to be found; 
for example, using 120 cm it is possible to form exactly three different integer sided right angle triangles.

120 cm: (30,40,50), (20,48,52), (24,45,51)

Given that L is the length of the wire, for how many values of L <= 1,500,000 can exactly one integer sided right angle triangle be formed?
	 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem p = new Problem75();
		p.runProblem();
		
		
		
	}
	
	public String problem() {
		
		int[] tests = new int[] { 12, 24, 30, 36, 40, 48 };
		
		List<Integer> sqrs = getSquaresBelow(100);
		System.out.print("squares: " + sqrs.get(0) + " issquare " + (isSquare(sqrs.get(0))!=0));
		for(int i=1; i < sqrs.size(); i++) {
			System.out.print(", " + sqrs.get(i) + " issquare " + (isSquare(sqrs.get(0))!=0));
		}
		System.out.println();
		for(int i=0; i < tests.length; i++) {
			
			int t = tests[i];
			System.out.println("at i=" + i + " t = " + t);
			
			for(int sq : sqrs) {
				int newt = t - sq;
				
			}
			
			/*
			for(int j=t; j > 0; j--) {
				System.out.println("doing j=" + j);
				int sq = isSquare(j);
				if(sq != 0) {
					System.out.println(j + " issqr " + sq);
				}
			}
			
			*/
			
			//System.out.println(i + " = " + t + " isqr? " + isSquare(t));
		}
		
		
		System.out.println("testttt " + isSquare(4));
		
		return "";
	}
	
	private List<Integer> getSquaresBelow(int max) {
		int n = 1, s = 0;
		List<Integer> sqrs = new ArrayList<Integer>();
		while((s = ++n*n) < max) 
			sqrs.add(s);
		
		return sqrs;
	}

	public int isSquare(int n) {
		double d = Math.sqrt(n);
		//System.out.println("checking if " + n + " is square : " + d + " ==== " + (d-(int)d));
		return d - (int)d == 0 ? (int)d : 0;
	}

}
