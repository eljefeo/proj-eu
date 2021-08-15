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
		
		/*
		 so a2 + b2 = c2....
		 c is bigger than a and b
		 
		 so some number N + b = c
		 N cant just be anything, there is some limit right?
		 like for b to become some larger square number, you have to add at least a certin amount to get to at the very least, the next square above b
		 
		 
		 so like 6, 8, 10 = 36, 64, 100
		 lets say we didnt know a, 36
		 N + 64 = ...?
		 well the next square above 8^2 (64) is 9^2 (81)
		 so something plus 64, that something has to at the very least be 17 so you have to find a square LARGER than 17
		 you need to at least go up to, or past, the next square above b..
		 SO ---- if we were trying to find pythagorum triples and we were testing with 64 as B..
		 then A cant be 1, 2, 3, 4.. since those are < 17 when squared
		 its sqrt(64) + 1 = 9
		 9^2 = 81
		 81 - 64 = 17
		 do all squares so that 17 <= N <= 64
		 which only leaves 5, 6, 7 ... 
		 I wonder how many will fit in the gap for higher numbers...
		 
		 
		 
		 */
		int totalMax = 10;
		
		List<Long> sqrs = new ArrayList<Long>();
		List<Long> sqrrts = new ArrayList<Long>();
		int count = 0, track = 3;
		//so what if this number i is the B
		long sq = 1;
		for(long b=2; b < totalMax; b++) {
			
			
			
			
			// starts with 2 ..
			// if 2 is b, then c is something larger than 2.. obviously
			// and a is something less than 2
			// the next square above 2 (4) is 3^2 = 9
			// so 9 - 4 = 5
			//for a to be able to add to b to form a square c, a has to be at least sqrt(5) or larger
			
			//long sqr = i * i;// i squared
			//System.out.println("i=" + i + " sqr=" + sqr);
			sq += track;
			//System.out.println("i=" + i + " sqr=" + sqr);
			track += 2;
			long nextSquare = sq + track;
			long diff = nextSquare - sq; // 9 - 4 = 5
			long difsrt = (long) Math.sqrt(diff);// + 1L; // if this is a perfect square than we dont want to add 1.. might save processing just to not add 1 and do the extra step sometimes.. rather than check if perfect square
			
			//if(i%1000 == 0) {
				//System.out.println("\ndoing b at " + i);
				System.out.println("b=" + b + " sqr=" + sq + " nextSquare=" + nextSquare + " diff=" + diff +  " difsrt=" + difsrt + "::: how many squares to check between = " + (b - difsrt));
			//}

			// now srt is where a should start, then go until i
				long tracka = 0;
			for(long a = difsrt; a < b; a++) {
				long sum = (a*a) + sq;
				double c = (double)Math.sqrt(sum);
				
				System.out.println("Trying : " + a + "  " + b + "  " + c);
				if(c - (long)c == 0) {
					long tots = (long) (a + b + c); 
					if(tots > 1500000 || tots < 0) {
						System.out.println("hmm wierd total " + tots + " a=" + a + " b=" + b + " c=" + c);
					} else {
						count++;
					}
					
					
					System.out.println("found a triple : " + a + " + " + b + " = " + c);
				}
			}
			
		}
		
		System.out.println("Found " + count + " under " + totalMax);
		
		/*
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
		/*
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
		*/
		
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
