import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		int totalMax = 25;
		
		List<Long> sqrs = new ArrayList<Long>();
		long s = 1, track = 3;
		for(long i=2; i < totalMax; i++) {
			
			//squares go up by odd numbers ...
			// 1 4 9 16 25 36
			//  3 5 7  9  11  13  15....
			/*
			 12 cm: (3,4,5)  -- 5 7 9 = 25 49 81  81-49=32  7 more than 25, mid number sqrt more than lowest num?
			24 cm: (6,8,10)  -- 11 15 19 = 121 225 361  361-225=136 = 15 more than 121, mid number sqrt more than lowest num?
			30 cm: (5,12,13) -- 9 23 25  = 81 529 625   625 - 529 = 96  15 away..dang (104 instead)
			36 cm: (9,12,15) -- 17 23 29 = 289 529 841  841 - 529= 312 - 289 = 23..this works too, 
			40 cm: (8,15,17) -- 15 29 33 = 225 841 1089   1089-841-225 = 23...nope...
			48 cm: (12,16,20)-- 23 31 39 = 441 961 1521  1521-961-441 = 119
			 */
			sqrs.add(s);
			
			//System.out.println("adding " + s);
			//i = sq;
			long t = s;
			
			
			for(int j=sqrs.size()-1; j > -1; j--) {
				long asqr = sqrs.get(j);
				
				long neww = t - asqr;
				//System.out.println("neww is now " + neww + " with t = " + t + " and asqr " + asqr);
				
			}
			
			
			s+=track;
			System.out.println("next s = "+ s  + " i=" + i + " track=" + track);
			track += 2;
		}
		
		
		return "";
				
	}
	
	public String problem4() {
		
		int[] tests = new int[] { 12, 24, 30, 36, 40, 48 };
		int totalMax = 1500000;
		int maxx = 1500000;
		int max = maxx/3;
		List<Long> sqrs = getSquaresForRootsBelow(max);
		System.out.println("Squares: " + sqrs.size());
		//System.out.print("squares: " + sqrs.get(0) + " issquare " + (isSquare(sqrs.get(0))!=0));
		for(int i=1; i < 20; i++) {
			System.out.print(", " + sqrs.get(i));
		}
		System.out.println();
		for(int i=0; i < tests.length; i++) {
			
			int t = tests[i];
			System.out.println("at i=" + i + " t = " + t);
			
			for(long sq : sqrs) {
				long newt = t - sq;
				
			}
		}
		
		Set<Long> sols = new HashSet<Long>();
		Set<Long> solsdup = new HashSet<Long>();
		int sqm = sqrs.size()-1;
		for(int i=0; i < sqm; i++) {
			long s1 = sqrs.get(i);
			
			if(s1 == 1)
				continue;
			
			if(i % 1000 == 0)
				System.out.println("i at " + i + " = " + s1);
			
			
			for(int j=i+1; j < sqm; j++) {
				
				long s2 = sqrs.get(j);
				
				if(j % 1000 == 0)
					System.out.println("j at " + j + " = " + s2);
				
				
				long h = s1+s2;
				if(sqrs.contains(h)) {
					double r1 = (double)s1/h;
					double r2 = (double)s2/h;
					long ss1 = (long) Math.sqrt(s1), ss2 = (long)Math.sqrt(s2), hh1 = (long)Math.sqrt(h);
					long ssum = ss1 + ss2 + hh1;
					System.out.println(ss1+ " " + ss2 +  " " + hh1 + " sum = " + ssum);
					
					if(ssum > totalMax)
						System.out.println("Woh too big: " + ss1+ " " + ss2 +  " " + hh1 + " with ratio: " + r1 + ", " + r2);
					
					if(!sols.add(ssum)) {
						solsdup.add(ssum);
					}
					
				}
			}
		}
		
		for(long i : solsdup) {
			sols.remove(i);
		}
		
		System.out.println("found: " + sols.size());
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
		//}
		
		
		System.out.println("testttt " + isSquare(4));
		
		return "";
	}
	
	private List<Long> getSquaresForRootsBelow(int max) {
		long n = 0L;
		List<Long> sqrs = new ArrayList<Long>();
		while(++n < max) 
			sqrs.add(n*n);
		
		return sqrs;
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
