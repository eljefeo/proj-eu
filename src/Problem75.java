import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

Heres a couple interesting things:
20,21,29 - middle is 25, which which is 1/2 of the one below (48,52 mid is 50)
20,48,52 - middle is 50, which is 1/2 of the one below (99,101 mid is 100)
20,99,101 

odds are weird still
21,28,35 	- mid is 31.5 which is 3/7 of the one below... and also extra:  28/72 is 14/46 and 7/18,,, and 35/75 is 7/15 || mid is 31.5
21,72,75 	- mid is 73.5 which is 1/3 of the one below (73.5 * 3 = 220.5)
21,220,221	- mid is 220.5


24,32,40 - mid is 36 	/12 = 3, 3/4 of the one below
24,45,51 - mid is 48 	/12 = 4, 2/3 of the one below
24,70,74 - mid is 72 	/12 = 6, 1/2 of the one below
24,143,145 mid is 144	/12 = 12


25,60,65 	- mid is 62.5  = 1/5 of one below
25,312,313 	- mid is 312.5 


27,36,45   - mid is 40.5  /40.5 = 1 - this is 1/3 of the one below (121.5 / 40.5)
27,120,123 - mid is 121.5 /40.5 = 3 - this is 1/3 of the one below (121.5 / 364.5)
27,364,365 - mid is 364.5 /40.5 = 9

28,45,53   - mid is 49  /7 = 7  = 1/2 of the one below
28,96,100  - mid is 98  /7 = 14 = 1/2 of the one below
28,195,197 - mid is 196 /7 = 28

29,420,421

30,40,50   - mid is 45  /15 = 3 = 3/5 of the one below
30,72,78   - mid is 75  /15 = 5 = 1/3 of the one below
30,224,226 - mid is 225 /15 = 15

31,480,481

this ones weird
32,60,68   - mid is 64  = 1/2 of the one below
32,126,130 - mid is 128 = 1/2 of the one below
32,255,257 - mid is 256 


33,44,55
33,56,65
33,180,183
33,544,545
....
-----------------------
20, 21, 29, a/4: 5, a/4^2: 25 :: c-b: 8 c-cmb/2: 25.0
a2 b2 c2 = 400, 441, 841   abDiff=1, acDiff=9, bcDiff=8, a2b2Diff=41, a2c2Diff=441, b2c2Diff=400
facts of a:  2 2 5
facts of b:  3 7
facts of c:  29

28, 45, 53, a/4: 7, a/4^2: 49 :: c-b: 8 c-cmb/2: 49.0
a2 b2 c2 = 784, 2025, 2809   abDiff=17, acDiff=25, bcDiff=8, a2b2Diff=1241, a2c2Diff=2025, b2c2Diff=784
facts of a:  2 2 7
facts of b:  3 3 5
facts of c:  53

33, 56, 65, a/4: no, a/4^2: 1 :: c-b: 9 c-cmb/2: 60.5
a2 b2 c2 = 1089, 3136, 4225   abDiff=23, acDiff=32, bcDiff=9, a2b2Diff=2047, a2c2Diff=3136, b2c2Diff=1089
facts of a:  3 11
facts of b:  2 2 2 7
facts of c:  5 13

36, 77, 85, a/4: 9, a/4^2: 81 :: c-b: 8 c-cmb/2: 81.0
a2 b2 c2 = 1296, 5929, 7225   abDiff=41, acDiff=49, bcDiff=8, a2b2Diff=4633, a2c2Diff=5929, b2c2Diff=1296
facts of a:  2 2 3 3
facts of b:  7 11
facts of c:  5 17

39, 80, 89, a/4: no, a/4^2: 1 :: c-b: 9 c-cmb/2: 84.5
a2 b2 c2 = 1521, 6400, 7921   abDiff=41, acDiff=50, bcDiff=9, a2b2Diff=4879, a2c2Diff=6400, b2c2Diff=1521
facts of a:  3 13
facts of b:  2 2 2 2 5
facts of c:  89

44, 117, 125, a/4: 11, a/4^2: 121 :: c-b: 8 c-cmb/2: 121.0
a2 b2 c2 = 1936, 13689, 15625   abDiff=73, acDiff=81, bcDiff=8, a2b2Diff=11753, a2c2Diff=13689, b2c2Diff=1936
facts of a:  2 2 11
facts of b:  3 3 13
facts of c:  5 5 5

48, 55, 73, a/4: 12, a/4^2: 144 :: c-b: 18 c-cmb/2: 64.0
a2 b2 c2 = 2304, 3025, 5329   abDiff=7, acDiff=25, bcDiff=18, a2b2Diff=721, a2c2Diff=3025, b2c2Diff=2304
facts of a:  2 2 2 2 3
facts of b:  5 11
facts of c:  73

51, 140, 149, a/4: no, a/4^2: 1 :: c-b: 9 c-cmb/2: 144.5
a2 b2 c2 = 2601, 19600, 22201   abDiff=89, acDiff=98, bcDiff=9, a2b2Diff=16999, a2c2Diff=19600, b2c2Diff=2601
facts of a:  3 17
facts of b:  2 2 5 7
facts of c:  149

52, 165, 173, a/4: 13, a/4^2: 169 :: c-b: 8 c-cmb/2: 169.0
a2 b2 c2 = 2704, 27225, 29929   abDiff=113, acDiff=121, bcDiff=8, a2b2Diff=24521, a2c2Diff=27225, b2c2Diff=2704
facts of a:  2 2 13
facts of b:  3 5 11
facts of c:  173

57, 176, 185, a/4: no, a/4^2: 1 :: c-b: 9 c-cmb/2: 180.5
a2 b2 c2 = 3249, 30976, 34225   abDiff=119, acDiff=128, bcDiff=9, a2b2Diff=27727, a2c2Diff=30976, b2c2Diff=3249
facts of a:  3 19
facts of b:  2 2 2 2 11
facts of c:  5 37

60, 91, 109, a/4: 15, a/4^2: 225 :: c-b: 18 c-cmb/2: 100.0
a2 b2 c2 = 3600, 8281, 11881   abDiff=31, acDiff=49, bcDiff=18, a2b2Diff=4681, a2c2Diff=8281, b2c2Diff=3600
facts of a:  2 2 3 5
facts of b:  7 13
facts of c:  109

60, 221, 229, a/4: 15, a/4^2: 225 :: c-b: 8 c-cmb/2: 225.0
a2 b2 c2 = 3600, 48841, 52441   abDiff=161, acDiff=169, bcDiff=8, a2b2Diff=45241, a2c2Diff=48841, b2c2Diff=3600
facts of a:  2 2 3 5
facts of b:  13 17
facts of c:  229

65, 72, 97, a/4: no, a/4^2: 1 :: c-b: 25 c-cmb/2: 84.5
a2 b2 c2 = 4225, 5184, 9409   abDiff=7, acDiff=32, bcDiff=25, a2b2Diff=959, a2c2Diff=5184, b2c2Diff=4225
facts of a:  5 13
facts of b:  2 2 2 3 3
facts of c:  97

68, 285, 293, a/4: 17, a/4^2: 289 :: c-b: 8 c-cmb/2: 289.0
a2 b2 c2 = 4624, 81225, 85849   abDiff=217, acDiff=225, bcDiff=8, a2b2Diff=76601, a2c2Diff=81225, b2c2Diff=4624
facts of a:  2 2 17
facts of b:  3 5 19
facts of c:  293

69, 260, 269, a/4: no, a/4^2: 1 :: c-b: 9 c-cmb/2: 264.5
a2 b2 c2 = 4761, 67600, 72361   abDiff=191, acDiff=200, bcDiff=9, a2b2Diff=62839, a2c2Diff=67600, b2c2Diff=4761
facts of a:  3 23
facts of b:  2 2 5 13
facts of c:  269

75, 308, 317, a/4: no, a/4^2: 1 :: c-b: 9 c-cmb/2: 312.5
a2 b2 c2 = 5625, 94864, 100489   abDiff=233, acDiff=242, bcDiff=9, a2b2Diff=89239, a2c2Diff=94864, b2c2Diff=5625
facts of a:  3 5 5
facts of b:  2 2 7 11
facts of c:  317

76, 357, 365, a/4: 19, a/4^2: 361 :: c-b: 8 c-cmb/2: 361.0
a2 b2 c2 = 5776, 127449, 133225   abDiff=281, acDiff=289, bcDiff=8, a2b2Diff=121673, a2c2Diff=127449, b2c2Diff=5776
facts of a:  2 2 19
facts of b:  3 7 17
facts of c:  5 73

84, 187, 205, a/4: 21, a/4^2: 441 :: c-b: 18 c-cmb/2: 196.0
a2 b2 c2 = 7056, 34969, 42025   abDiff=103, acDiff=121, bcDiff=18, a2b2Diff=27913, a2c2Diff=34969, b2c2Diff=7056
facts of a:  2 2 3 7
facts of b:  11 17
facts of c:  5 41

85, 132, 157, a/4: no, a/4^2: 1 :: c-b: 25 c-cmb/2: 144.5
a2 b2 c2 = 7225, 17424, 24649   abDiff=47, acDiff=72, bcDiff=25, a2b2Diff=10199, a2c2Diff=17424, b2c2Diff=7225
facts of a:  5 17
facts of b:  2 2 3 11
facts of c:  157

88, 105, 137, a/4: 22, a/4^2: 484 :: c-b: 32 c-cmb/2: 121.0
a2 b2 c2 = 7744, 11025, 18769   abDiff=17, acDiff=49, bcDiff=32, a2b2Diff=3281, a2c2Diff=11025, b2c2Diff=7744
facts of a:  2 2 2 11
facts of b:  3 5 7
facts of c:  137

95, 168, 193, a/4: no, a/4^2: 1 :: c-b: 25 c-cmb/2: 180.5
a2 b2 c2 = 9025, 28224, 37249   abDiff=73, acDiff=98, bcDiff=25, a2b2Diff=19199, a2c2Diff=28224, b2c2Diff=9025
facts of a:  5 19
facts of b:  2 2 2 3 7
facts of c:  193

96, 247, 265, a/4: 24, a/4^2: 576 :: c-b: 18 c-cmb/2: 256.0
a2 b2 c2 = 9216, 61009, 70225   abDiff=151, acDiff=169, bcDiff=18, a2b2Diff=51793, a2c2Diff=61009, b2c2Diff=9216
facts of a:  2 2 2 2 2 3
facts of b:  13 19
facts of c:  5 53

104, 153, 185, a/4: 26, a/4^2: 676 :: c-b: 32 c-cmb/2: 169.0
a2 b2 c2 = 10816, 23409, 34225   abDiff=49, acDiff=81, bcDiff=32, a2b2Diff=12593, a2c2Diff=23409, b2c2Diff=10816
facts of a:  2 2 2 13
facts of b:  3 3 17
facts of c:  5 37

105, 208, 233, a/4: no, a/4^2: 1 :: c-b: 25 c-cmb/2: 220.5
a2 b2 c2 = 11025, 43264, 54289   abDiff=103, acDiff=128, bcDiff=25, a2b2Diff=32239, a2c2Diff=43264, b2c2Diff=11025
facts of a:  3 5 7
facts of b:  2 2 2 2 13
facts of c:  233

115, 252, 277, a/4: no, a/4^2: 1 :: c-b: 25 c-cmb/2: 264.5
a2 b2 c2 = 13225, 63504, 76729   abDiff=137, acDiff=162, bcDiff=25, a2b2Diff=50279, a2c2Diff=63504, b2c2Diff=13225
facts of a:  5 23
facts of b:  2 2 3 3 7
facts of c:  277

119, 120, 169, a/4: no, a/4^2: 1 :: c-b: 49 c-cmb/2: 144.5
a2 b2 c2 = 14161, 14400, 28561   abDiff=1, acDiff=50, bcDiff=49, a2b2Diff=239, a2c2Diff=14400, b2c2Diff=14161
facts of a:  7 17
facts of b:  2 2 2 3 5
facts of c:  13 13

120, 209, 241, a/4: 30, a/4^2: 900 :: c-b: 32 c-cmb/2: 225.0
a2 b2 c2 = 14400, 43681, 58081   abDiff=89, acDiff=121, bcDiff=32, a2b2Diff=29281, a2c2Diff=43681, b2c2Diff=14400
facts of a:  2 2 2 3 5
facts of b:  11 19
facts of c:  241

133, 156, 205, a/4: no, a/4^2: 1 :: c-b: 49 c-cmb/2: 180.5
a2 b2 c2 = 17689, 24336, 42025   abDiff=23, acDiff=72, bcDiff=49, a2b2Diff=6647, a2c2Diff=24336, b2c2Diff=17689
facts of a:  7 19
facts of b:  2 2 3 13
facts of c:  5 41

136, 273, 305, a/4: 34, a/4^2: 1156 :: c-b: 32 c-cmb/2: 289.0
a2 b2 c2 = 18496, 74529, 93025   abDiff=137, acDiff=169, bcDiff=32, a2b2Diff=56033, a2c2Diff=74529, b2c2Diff=18496
facts of a:  2 2 2 17
facts of b:  3 7 13
facts of c:  5 61

140, 171, 221, a/4: 35, a/4^2: 1225 :: c-b: 50 c-cmb/2: 196.0
a2 b2 c2 = 19600, 29241, 48841   abDiff=31, acDiff=81, bcDiff=50, a2b2Diff=9641, a2c2Diff=29241, b2c2Diff=19600
facts of a:  2 2 5 7
facts of b:  3 3 19
facts of c:  13 17

160, 231, 281, a/4: 40, a/4^2: 1600 :: c-b: 50 c-cmb/2: 256.0
a2 b2 c2 = 25600, 53361, 78961   abDiff=71, acDiff=121, bcDiff=50, a2b2Diff=27761, a2c2Diff=53361, b2c2Diff=25600
facts of a:  2 2 2 2 2 5
facts of b:  3 7 11
facts of c:  281

161, 240, 289, a/4: no, a/4^2: 1 :: c-b: 49 c-cmb/2: 264.5
a2 b2 c2 = 25921, 57600, 83521   abDiff=79, acDiff=128, bcDiff=49, a2b2Diff=31679, a2c2Diff=57600, b2c2Diff=25921
facts of a:  7 23
facts of b:  2 2 2 2 3 5
facts of c:  17 17

175, 288, 337, a/4: no, a/4^2: 1 :: c-b: 49 c-cmb/2: 312.5
a2 b2 c2 = 30625, 82944, 113569   abDiff=113, acDiff=162, bcDiff=49, a2b2Diff=52319, a2c2Diff=82944, b2c2Diff=30625
facts of a:  5 5 7
facts of b:  2 2 2 2 2 3 3
facts of c:  337

204, 253, 325, a/4: 51, a/4^2: 2601 :: c-b: 72 c-cmb/2: 289.0
a2 b2 c2 = 41616, 64009, 105625   abDiff=49, acDiff=121, bcDiff=72, a2b2Diff=22393, a2c2Diff=64009, b2c2Diff=41616
facts of a:  2 2 3 17
facts of b:  11 23
facts of c:  5 5 13

207, 224, 305, a/4: no, a/4^2: 1 :: c-b: 81 c-cmb/2: 264.5
a2 b2 c2 = 42849, 50176, 93025   abDiff=17, acDiff=98, bcDiff=81, a2b2Diff=7327, a2c2Diff=50176, b2c2Diff=42849
facts of a:  3 3 23
facts of b:  2 2 2 2 2 7
facts of c:  5 61


 */


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
		//Problem pp = new Problem75();
		//pp.runProblem();
		//printAllPythagoreanTriplesWithALessThan(75);
		//printAllPythagoreanTriplesWithALessThanWithDetails(100);
		//printOddsAndSquaresOrder(1000);
		
		//doLotsOfDiffsAndSumsOfSquares(20);
		findTripsThenCompareDiffAndSums(40);
		//printPythTriplesOnlyReducedNotPredictable(800);
		
		//doOtherGuys(70, max, false);
	}
	
	
	
	public static List<Integer[]> doLotsOfDiffsAndSumsOfSquares(int max, boolean shouldPrint) {
		int x = 0, y = 0;
		List<Integer[]> l = new ArrayList<Integer[]>();
		
		//int max = 10;
		for(int i =  1; i < max; i++) {
			for(int j = i+1; j < max; j++) {
				//TODO if i and j are same!!!!!!!!! 
				int i2 = i*i, j2 = j*j;
				int diff = j2 - i2;
				int sum = j2 + i2;
				l.add(new Integer[] {diff, sum, i, j});
				if(shouldPrint) {
					System.out.print("i: " + i + " j: " + j + " ::: ");
					System.out.println("Diff: " + diff + " sum: " + sum);
				}
					
			}
			//System.out.println("Diff: " + (i*i) + " sum: " + ())
		}
		return l;
	}
	
	public static void findTripsThenCompareDiffAndSums(int howmany) {
		int max = 40;
		List<Integer[]> trips = getAllPythagoreanTriplesWithALessThan(max);
		List<Integer[]> ds = doLotsOfDiffsAndSumsOfSquares(max, true);
		for(Integer[] trip : trips) {
			boolean f = false;
			for(Integer[] difSum : ds) {
				if((trip[0] == difSum[0] || trip[1] == difSum[0]) && trip[2] == difSum[1]) {
					System.out.println("Found a match... dif: " + difSum[0] + " sum: " + difSum[1] + " orig2: " + difSum[2] + "," + difSum[3] +  " -- matching trip: " + trip[0] + "," + trip[1] + "," + trip[2]);
					f = true;
					break;
				}
			}
			if(!f) {
				System.out.println("Could not find match for trip: " + trip[0] + "," + trip[1] + "," + trip[2]);
			}
		}
	}
	
	
	
	public static void printOddsAndSquaresOrder(int howMany) {
		
		int odd = 1;
		int sq = 1;
		for(int i=1; i<howMany; i++) {
			
			System.out.println("#" + i + " odd: " + odd + " sq: " + sq);
			odd +=2;
			sq += odd;
		}
	}
	public static void printPythTriplesOnlyReducedNotPredictable(int max) {
		List<Integer[]> sols = printLotsOfTriplesButOnlyReduced(max);
		List<Integer[]> ret = new ArrayList<Integer[]>() ;
		for(Integer[] ii : sols) {
			int a = ii[0], b = ii[1], c = ii[2], cbDiff = c - b;
			
			boolean isEven = a%2 == 0;
			
			//if(true){//
			if(( !isEven && b < (c-1) ) || (isEven && b < (c-2))) {
			//if(isEven && b < (c-2)) {
			//if( !isEven && b < (c-1)) {
			//
				int a4 = -1;
				boolean a4b = a%4 == 0; 
				if(a4b) {
					a4 = a / 4;
				}
				
				int cmb = c-b;
				double cMhalfcmb = (c - (double)cmb/2);
				boolean cmbEven = cmb % 2 == 0;
				int a2 = a*a, b2 = b*b, c2 = c*c;
				System.out.println();
				System.out.println(a + ", " + b + ", " + c + ", a/4: " + (a4b ? a4 : "no") + ", a/4^2: " + (a4 * a4) + " :: c-b: " + cmb + " c-cmb/2: " + cMhalfcmb);
				System.out.println("a2 b2 c2 = " + a2 + ", " + b2 + ", " + c2 + "   abDiff=" + (b-a) + ", acDiff=" + (c-a) + ", bcDiff=" + (c-b) + ", a2b2Diff=" + (b2-a2)  + ", a2c2Diff=" + (c2-a2) + ", b2c2Diff=" + (c2-b2));
				ret.add(ii);
				List<Integer> facts = Util.getPrimeFactors(a);
				System.out.print("facts of a: ");
				for(int jk : facts) {
					System.out.print(" " + jk);
				}
				System.out.println();
				
				facts = Util.getPrimeFactors(b);
				System.out.print("facts of b: ");
				for(int jk : facts) {
					System.out.print(" " + jk);
				}
				System.out.println();
				
				facts = Util.getPrimeFactors(c);
				System.out.print("facts of c: ");
				for(int jk : facts) {
					System.out.print(" " + jk);
				}
				System.out.println();
			} else {
				//System.out.println("Skipping: " + a + ", " + b + ", " + c);
			}
			
		}
	}
	
	public static void printPythTriplesOnlyReducedButWithFactors(int max) {
		//int max = 1500;
		
		Set<Integer> sums = new HashSet<Integer>();
		Set<Integer> dups = new HashSet<Integer>();
		List<Integer[]> sols = printLotsOfTriplesButOnlyReduced(max);
		for(Integer[] ii : sols) {
			int a = ii[0], b = ii[1], c = ii[2], cbDiff = c - b;
			if((a % 2 == 0 && cbDiff != 2) || (a % 2 != 0 && cbDiff != 1)) {
				System.out.println(a + ", " + b + ", " + c + " || \t c - b: " + cbDiff );
				List<Integer> facts = Util.getPrimeFactors(a);
				System.out.print("facts of a: ");
				for(int jk : facts) {
					System.out.print(" " + jk);
				}
				System.out.println();
				
				facts = Util.getPrimeFactors(b);
				System.out.print("facts of b: ");
				for(int jk : facts) {
					System.out.print(" " + jk);
				}
				System.out.println();
				
				facts = Util.getPrimeFactors(c);
				System.out.print("facts of c: ");
				for(int jk : facts) {
					System.out.print(" " + jk);
				}
				System.out.println();
				
				
			}
			
			int sum = 0;
			int i = 1;
			while(sum <= max) {
				sum = (a*i) + (b*i) +  (c*i);
				//System.out.println("mult : " + (ii[0]*i) + ", " + (ii[1]*i) + ", " + (ii[2]*i) + " sum: " + sum);
				if(sum > max) {
					//System.out.println("**sum is greater than " + max + " :: " + (ii[0]*i) + ", " + (ii[1]*i) + ", " + (ii[2]*i) + " sum: " + sum);
					continue;
				} 
				
				
				if(!sums.add(sum)) {
					dups.add(sum);
					//System.out.println("adding to dups : " + (ii[0]*i) + ", " + (ii[1]*i) + ", " + (ii[2]*i) + " sum: " + sum);
				} else { 
					//System.out.println("adding to sums : " + (ii[0]*i) + ", " + (ii[1]*i) + ", " + (ii[2]*i) + " sum: " + sum);
				}
				i++;
			}
		}
		
		
		//for(Integer i : sums) {
		//	System.out.println("JJ good Tri " + i + " : " + i);
		//}
		
		//for(Integer i : dups) {
		//	System.out.println("JJ dups Tri " + i + " : " + i);
		//}
		//printPythTriplesOnlyWithMultipleSolutionsForA(100);
		System.out.println("sums: " + sums.size() + " dups: " + dups.size() + " diff: " + (sums.size() - dups.size()));
		
	}
	
	public static void printPythTriplesOnlyWithMultipleSolutionsForA(int max) {
		for(int i=3; i<max; i++) {
			List<Integer[]> sols = getPythagoreanTriplesFromThisA2(i);
			if(sols.size() > 1) {
				for (Integer[] in : sols) {
					System.out.println("a b c : " + in[0] + ", " + in[1] + ", " + in[2]);
				}
			}
		}
	}

	public String problem() {
		
		/*
		05/26/2022
		Here is some interesting stuff...
		So we know how to generate triples from a = odd number (where b and c are always 1 away):
		(( a^2 ) + 1) / 2 = c, b = c - 1
		
		And from even numbers (where b and c are always 2 away):
		( a / 2 )^2 , then -1 and +1 gives you b and c
		
		But there are some triples that are missing...like these..
		These have an a that is sometimes even, sometimes odd... and b and c are not 1 or 2 away...
		But the b and c difference to seem to have some correlation with the factors of a
		like if a has Two 2's as its smallest factors, b and c are 8 away
		if there is a 3 as its smallest factor, then its 9 away...
		if the smallest is 5, then its 25 away... 
		This reminds me of the totient function...
		
		here are other interesting things..
		if b and c are 8 away, since there are Two 2s in the factors, lets divide out the Two 2s
		so 20 / 2 / 2 = 5
		if you square 5 you get 25, and that is right in between b and c (21 and 29) and each one is 4 away (2*2)
		Seems to work for all of these below that  b and c diff = 8
		
		what about the 9s... they have 3 as smallest factor. lets divide out the 3
		33 / 3 = 11... then square = 121... hmm yea same thing, because 121 / 2 = 60.5 which is exactly between b and c (56 and 65)
		same for 57, / 3 = 19, ^2 = 361, / 2 = 180.5 (between 1176 and 185)
		
		
		What about 18... the factors for a where b and c are diff=18 , they all seem to have a 2 and a 3 in the factors...
		
		But 60 is weird
		60, 91, 109 || 	 c - b: 18 || facts of a:  2 2 3 5
		60, 221, 229 || 	 c - b: 8 || facts of a:  2 2 3 5
		
		because it has diff = 18 and diff = 8...
		
		
20, 21, 29 || 	 c - b: 8 || facts of a:  2 2 5
28, 45, 53 || 	 c - b: 8 || facts of a:  2 2 7
33, 56, 65 || 	 c - b: 9 || facts of a:  3 11
36, 77, 85 || 	 c - b: 8 || facts of a:  2 2 3 3
39, 80, 89 || 	 c - b: 9 || facts of a:  3 13
44, 117, 125 || 	 c - b: 8 || facts of a:  2 2 11
48, 55, 73 || 	 c - b: 18 || facts of a:  2 2 2 2 3
51, 140, 149 || 	 c - b: 9 || facts of a:  3 17
52, 165, 173 || 	 c - b: 8 || facts of a:  2 2 13
57, 176, 185 || 	 c - b: 9 || facts of a:  3 19
60, 91, 109 || 	 c - b: 18 || facts of a:  2 2 3 5
60, 221, 229 || 	 c - b: 8 || facts of a:  2 2 3 5
65, 72, 97 || 	 c - b: 25 || facts of a:  5 13
68, 285, 293 || 	 c - b: 8 || facts of a:  2 2 17
69, 260, 269 || 	 c - b: 9 || facts of a:  3 23
75, 308, 317 || 	 c - b: 9 || facts of a:  3 5 5
76, 357, 365 || 	 c - b: 8 || facts of a:  2 2 19
84, 187, 205 || 	 c - b: 18 || facts of a:  2 2 3 7
84, 437, 445 || 	 c - b: 8 || facts of a:  2 2 3 7
85, 132, 157 || 	 c - b: 25 || facts of a:  5 17
87, 416, 425 || 	 c - b: 9 || facts of a:  3 29
88, 105, 137 || 	 c - b: 32 || facts of a:  2 2 2 11
92, 525, 533 || 	 c - b: 8 || facts of a:  2 2 23
93, 476, 485 || 	 c - b: 9 || facts of a:  3 31
95, 168, 193 || 	 c - b: 25 || facts of a:  5 19
96, 247, 265 || 	 c - b: 18 || facts of a:  2 2 2 2 2 3
100, 621, 629 || 	 c - b: 8 || facts of a:  2 2 5 5
104, 153, 185 || 	 c - b: 32 || facts of a:  2 2 2 13
105, 208, 233 || 	 c - b: 25 || facts of a:  3 5 7
105, 608, 617 || 	 c - b: 9 || facts of a:  3 5 7
111, 680, 689 || 	 c - b: 9 || facts of a:  3 37
115, 252, 277 || 	 c - b: 25 || facts of a:  5 23
119, 120, 169 || 	 c - b: 49 || facts of a:  7 17
120, 209, 241 || 	 c - b: 32 || facts of a:  2 2 2 3 5
120, 391, 409 || 	 c - b: 18 || facts of a:  2 2 2 3 5
132, 475, 493 || 	 c - b: 18 || facts of a:  2 2 3 11
133, 156, 205 || 	 c - b: 49 || facts of a:  7 19
135, 352, 377 || 	 c - b: 25 || facts of a:  3 3 3 5
136, 273, 305 || 	 c - b: 32 || facts of a:  2 2 2 17
140, 171, 221 || 	 c - b: 50 || facts of a:  2 2 5 7
145, 408, 433 || 	 c - b: 25 || facts of a:  5 29
152, 345, 377 || 	 c - b: 32 || facts of a:  2 2 2 19
155, 468, 493 || 	 c - b: 25 || facts of a:  5 31
160, 231, 281 || 	 c - b: 50 || facts of a:  2 2 2 2 2 5
161, 240, 289 || 	 c - b: 49 || facts of a:  7 23
165, 532, 557 || 	 c - b: 25 || facts of a:  3 5 11
168, 425, 457 || 	 c - b: 32 || facts of a:  2 2 2 3 7
175, 288, 337 || 	 c - b: 49 || facts of a:  5 5 7
180, 299, 349 || 	 c - b: 50 || facts of a:  2 2 3 3 5
184, 513, 545 || 	 c - b: 32 || facts of a:  2 2 2 23
189, 340, 389 || 	 c - b: 49 || facts of a:  3 3 3 7
200, 609, 641 || 	 c - b: 32 || facts of a:  2 2 2 5 5
203, 396, 445 || 	 c - b: 49 || facts of a:  7 29
204, 253, 325 || 	 c - b: 72 || facts of a:  2 2 3 17
207, 224, 305 || 	 c - b: 81 || facts of a:  3 3 23
217, 456, 505 || 	 c - b: 49 || facts of a:  7 31
220, 459, 509 || 	 c - b: 50 || facts of a:  2 2 5 11
225, 272, 353 || 	 c - b: 81 || facts of a:  3 3 5 5
228, 325, 397 || 	 c - b: 72 || facts of a:  2 2 3 19
231, 520, 569 || 	 c - b: 49 || facts of a:  3 7 11
240, 551, 601 || 	 c - b: 50 || facts of a:  2 2 2 2 3 5
252, 275, 373 || 	 c - b: 98 || facts of a:  2 2 3 3 7
261, 380, 461 || 	 c - b: 81 || facts of a:  3 3 29
276, 493, 565 || 	 c - b: 72 || facts of a:  2 2 3 23
279, 440, 521 || 	 c - b: 81 || facts of a:  3 3 31
280, 351, 449 || 	 c - b: 98 || facts of a:  2 2 2 5 7
297, 304, 425 || 	 c - b: 121 || facts of a:  3 3 3 11
308, 435, 533 || 	 c - b: 98 || facts of a:  2 2 7 11
319, 360, 481 || 	 c - b: 121 || facts of a:  11 29
336, 377, 505 || 	 c - b: 128 || facts of a:  2 2 2 2 3 7
336, 527, 625 || 	 c - b: 98 || facts of a:  2 2 2 2 3 7
341, 420, 541 || 	 c - b: 121 || facts of a:  11 31
368, 465, 593 || 	 c - b: 128 || facts of a:  2 2 2 2 23
396, 403, 565 || 	 c - b: 162 || facts of a:  2 2 3 3 11
		
		 */
		
		/////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		/* WE ARE MISSING SOME !!! THE CODE DOESNT CALCULATE THESE FOR EXAMPLE:::::
		20 21 29 = 70
		40 42 58 = 140
		
		28 45 53 = 126
		
		14 48 50 = 112
		
		so we need to find these...
		We need to find the triples that are like the primes of pythagorean triples..
		What is that, is that like triples that have no factors in common? They are reduced?
		
		like 3 4 5
		but not 6 8 10
		
		Then 5 12 13
		then 7 24 25
		... what about 9
		9 40 41 yep
		
		what about the difference of squares I remember from highschool days...
		that is (c-b)(c+b) = c^2 - b^2
		can we use that at all, is it even helpful
		
		if we know A, lets say..
		then a2 = c2 - b2
		a2 = (c-b)(c+b) 
		
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		*/
		
		
		//testSomeStartingATriples();
			//testThing();
		//printLotsOfTriples();
		
		//int a = 3, b = 4;
		//if((double)b/a - (b/a) != 0) 
		//	System.out.println("ERROR:::::::::: " + (double)b/a + " " + (b/a));
		
		//printLotsOfTriplesJustPrimes();
		////////printLotsOfTriplesJustPrimesAndActuallyDoProblem();
		
		//List<Integer[]> tr = getPythagoreanTriplesFromThisA(22);
		
		//for(Integer[] ii : tr) {
		//	System.out.println("trip: " + ii[0] + "," + ii[1] + "," + ii[2] );
		//}
		
		//testAs();
		Set<Integer> sums = new HashSet<Integer>();
		Set<Integer> dups = new HashSet<Integer>();
		int max = 150, counter = 0, oddStep = 1;
		int aOdd = 3, bOdd = aOdd + 1, cOdd = bOdd + 1;
		//int a = 0, b = 0, c = 0;
		//
		int sum = aOdd + bOdd + cOdd;
		while(sum <= max) { // sum <= max
			//odds
			//if(!sums.add(sum)) {
			//	dups.add(sum);
			//}
			
			//System.out.println("a: " + aOdd + " , b: " + bOdd + " c: " + cOdd + ", oddStep: " + oddStep + " sum: " + sum);
			int cc = 1;
			// do all multiples of this triple, like if its 3,4,5 then do 6,8,10 9,12,15 12,16,20 etc..
			while(sum <= max) { // sum <= max
				
				if(!sums.add(sum)) {
					dups.add(sum);
					System.out.println("oDuplicate :: " + (aOdd*cc) + ", " + (bOdd*cc) + ", " + (cOdd*cc) + ", oddStep: " + oddStep + " sum: " + sum);
				} else {
					System.out.println("onot dup yet :: " + (aOdd*cc) + ", " + (bOdd*cc) + ", " + (cOdd*cc) + ", oddStep: " + oddStep + " sum: " + sum);
				}
				cc++;
				//counter++;
				sum = (aOdd*cc) + (bOdd*cc) + (cOdd*cc);
				
				
				//System.out.println("ad: " + (aOdd*cc) + " , bd: " + (bOdd*cc) + " cd: " + (cOdd*cc) + " sum: " + sum);
			}
			
			//counter++;
			oddStep++;
			
			aOdd += 2;
			bOdd = (aOdd * oddStep) + oddStep;
			cOdd = bOdd + 1;
			sum = aOdd + bOdd + cOdd;
			//counter--;
			
		}
		//counter--;
		//System.out.println("count: " + counter);
		
		
		int evStep = 7;
		int aEv = 8, bEv = aEv + evStep, cEv = bEv + 2;
		//counter = 0;
		
		sum = aEv + bEv + cEv; // reset for evens before we combine the functions for odd and even
		//System.out.println(aEv + ", " + bEv + ", " + cEv + ", evStep: " + evStep + " sum: " + sum);
		
		while(sum <= max) { // sum <= max
			//even
			/*
			 * if(!sums.add(sum)) { dups.add(sum); }
			 */
			
			int cc = 1;
			while(sum <= max) { // sum <= max
				if(!sums.add(sum)) {
					dups.add(sum);
					System.out.println("eDuplicate: " + (aEv*cc) + " ," + (bEv*cc) + ", " + (cEv*cc) + " sum: " + sum);
				} else {
					System.out.println("enot dup yet: " + (aEv*cc) + " ," + (bEv*cc) + ", " + (cEv*cc) + " sum: " + sum);
				}
				cc++;
				sum = (aEv*cc) + (bEv*cc) + (cEv*cc);
				
			}
			//counter++;
			evStep += 2;
			
			aEv += 2;
			bEv +=  evStep;
			cEv = bEv + 2;
			sum = aEv + bEv + cEv;
			
			//counter--;
			
			
			//System.out.println(aEv + ", " + bEv + ", " + cEv + ", evStep: " + evStep + " sum: " + sum);
			
			
		}
		//counter--;
		System.out.println("count: " + counter + ", sums size " + sums.size() + ", dups size " + dups.size() + " diff = " + (sums.size() - dups.size()));
			
		for(Integer i : sums) {
			System.out.println("Sums : " + i);
		}
		System.out.println("");
		for(Integer i : dups) {
			System.out.println("dups : " + i);
			sums.remove(i);
		}
		System.out.println("");
		for(Integer i : sums) {
			System.out.println("unique Sums : " + i);
		}
		System.out.println("unique Sums count: " + sums.size());
		return "";
	}
	//05/14/2022 
		/*
		 Alright, so turns out that primes are only a in 1 triple, and b and c are 1 away from each other 
		 3,4,5
		 5,12,13
		 7,24,25
		 11,60,61
		 ...
		 19,180,181
		 ...
		 
		 
		 but what about this pattern that I am seeing...
		 3,4,5 = 3 * 1 + 1
		 5,12,13 5 * 2 + 2
		 7,24,25 7 * 3 + 3
		 its like the number of odd num you are on... 3 = use the first odd number (1)
		 5 = 2
		 7 = 3
		 9 = 4
		 11 = 5
		 13 = 6
		 15 = 7
		 17 = 8
		 19 = 9
		 21 = 10
		 primes you will only have 1 triple where a = that prime, and b and c are 1 away
		 
		 but what about something like 9
		 9,12,15 - this is a multiple of 3,4,5
		 9,40,41 - this is 9 * 4 + 4
		 
		 then lets look at ones that have more than 1
		 : 21,28,35 (7 away) - not sure, I guess they are just multiples of smaller triples.. we can just find them that way
		 21,72,75 - (3 away) - not sure, I guess they are just multiples of smaller triples.. we can just find them that way
		 21,220,221 - 21 = 10th odd number... so 21 * 10 + 10 ( and this one is 1 away)


so thats how to find triples of odd numbers ^

what about evens...
looks like evens are all 2 away instead of 1 away
6,8,10
8,15,17
10,24,26
		//12,16,20
12,35,37
 14,48,50
 16,63,65
 18,80,82
 20,99,101
 22,120,122
24,143,145

looks like if you start with 6,8,10
8,15,17 - then the next even num (8) has b = +7 from previous b (8 + 7
10,24,26 - then the next b is +9
12,35,37 - b is +11
... just keep adding the next odd number to get the next b

		 
		 
		 */
	
	//05/14/2022
	/*
	 it seems to me after looking at these numbers that we can make pyth triple where A = any number except 1,2,4...
	 so far it seems every other number can be A
	 and furthermore, I cant prove either of these yet, but it also seems that only 1 pyth triple exists for each A
	 	meaning if 3,4,5 is a triple, there are no other triples where a=3
	 	
	 if these 2 points are true, we may be on our way to understanding how to find this answer...These 2 things feel very important
	 
	 if 3,4,5 is a triple, and 3 has another triple, that means there are 2 other squares who are also 3^2 (9) away from each other,
	 	because 3,4,5 = 5^2 - 4^2 = 3^2
	 	but I thought all squares go up consistently incrementing by every odd number... so 2 squares are 9 apart, but no others are..
	 	
	 and we know that 1,2,4 are not a...because we can test all possibilities for squares that are less than 4^2 away from each other, 
	 after a certain point the numbers just keep getting farther from each other and will never be 4^2 away..
	 
	 but how do we know that all other integers can be a, except 1,2,4...?
	 We can just run with these assumptions and see if we can code something up...
	 
	 */
	
	
	//04/27/2022
	/*
	 so...
	 first one is 3,4,5
	 and I found that multiples also work..
	 3n, 4n, 5n
	 so 
	 6 8 10 work
	 9 12 15
	 12 16 20 etc..
	 
	 then Im thinking... 
	 we know the smallest number can be 3 (in 3,4,5)
	 can all numbers be the smallest number of the 3 numbers?...
	 like can a pythagorean triple start with 4? 5? 6? 7? etc...
	 
	 well we can try it..
	 because if the smallest number is 4, then the other two numbers are 4^2 away, they are 16 away..
	 as numbers get bigger, they all get more than 16 away, so there are not that many we have to try
	 
	 if smallest number is 4, then next number can be 5 and 6
	 25 and 36.... are 11 away. Close but not 16
	 what about 5 and 7
	 25 and 49
	 24 away, too much..
	 so 5 is not the next number of the 3, because the third number will just get larger and farther from 16
	 so what about 6 and 7
	 they are 36 and 49
	 13 away, closer but not it
	 6 and 8?
	 36 and 64 - 28 away nope too big
	 what about 7 and 8
	 49 and 64 - they are 15 away, closer still but not 16
	 and that means 7 and 9 is too big (49 and 81) cause 81 - 49 = 32, way too big
	 
	 ... we can see that as we make the second number higher, the smallest difference goes up by 2..
	 like we did 5 and 6, they were 11 away (25 and 36). then 5 and 7 (25 and 49) were 24 away
	 6 and 7 (36 and 49) were 13 away, and then 6 and 8 ( 36 and 64) were 28 away..
	 7 and 8 (49 and 64) are 15 away, and then 7 and 9 (49 and 81) are 32 away
	 8 and 9 (64 and 81) are 17 away, and now its too big, all higher numbers will just be larger apart
	 
	 so nums that are 1 away are 11 apart, 13 apart, 15 apart, 17 apart, etc.. (they go up by previous number plus 2, essentially all the odd numbers)
	 and nums that are 2 away are 24 apart, 28 apart, 32, 36, 40 (they go up by previous number plus 4)
	 and nums that are 3 away are 27 apart, 33 apart, 39, 45, 51 (they go up by previous number plus 6)
	 
	 that means if we wanted a pyth triple where 4 is the smallest number, we need the other 2 nums to different to 16
	 but since they only go up by odd nums 11,13,15,17 etc.. we skipped 16. 
	 in fact, checking any combo of squares, turns out no, there are no triples that start with 4...interesting... 
	 
	 
	 ------
	 so 3 yes, 4 no
	 interesting, what about 5?
	 5^2 = 25
	 what other two square nums are 25 apart.
	 
	 lets just make a function to find if there is one...lol
	 .. ok did that, now we have getPythagoreanTripleFromThisA()
	 
	 and we see that 3 yes, 4 no, 5 yes, 6 yes (because multiple of 3)
	 7 yes (seems like all odd numbers are a yes...)
	 8 yes
	 9 yes (because multiple of 3)
	 10
	 
	 ..
	 ok so we used that new function to test a bunch of numbers
	 we found that only 1,2,4 are NOT able to be the smallest number of a pyth triple...
	 well, we only tested up to 6000
	 
	 I feel like at that point all other numbers are going to be multiples of those numbers
	 EXCEPT primes... primes will not be multiples of any number ...
	 
	 but... all primes are odd... and it seems like all odd numbers can be the smalles number of a triple?
	 I dont know that for sure....
	 ------------
	 
	 
	 
	 so what does that mean, what if we assume thats true, that all numbers except 1,2,4 can be the start of a triple..
	 can a smallest number be in 2 triples? I want to say no.. but I dont know for sure
	 
	 We may be wrong, but just to start somewhere:
	 lets assume every number is only the smallest num of 1 triple **** 05/22/2022 - this is not true... like a=15 has at least 2 triples...
	 lets also assume all nums after 4 can be the smallest num of a triple..
	 
	 
	 ----
	 
	 hmm after looking at a bunch of triples thanks to that function...
	 it seems like primes are key here.
	 so a prime starting A like 3, seems to have the b and c being 1 away from each other.
	 like 3,4,5 : the 4 and 5 are 1 away
	 5, 12, 13
	 6, 8, 10 ( b and c are 2 away, because 6 is 3*2 )
	 7, 24, 25
	 8, 15, 17 ( this was interesting because there is no A=4, but we have A=4*2 (I guess because 2 is prime and 1 is not? Does that have anything to do with it? )
	 9, 12, 15 ( 3 away because 3*3 = 9)
	 10, 24, 26 ( 2 away because 5*2)
	 11, 60, 61 ( 1 away because 11 is prime)
	 12, 16, 20 ( 3*4)
	 13, 84, 85 ( prime )
	 14, 48, 50 ( 7*2 )
	 15, 20, 25 (5*3 ? .... 5 away? hmm)
	 
	 ...
	 105, 140, 175 ( 35 away I guess cause 105 = 3*5*7 and 5*7 = 35... )
	 
	 why is the number 3 so damn important, the diff from b and c is like the multiple of 3... even if there are other factors.
	 if 3 is a factor..
	 
	 anyways...can we figure out how to figure out the b and c? if we know the factors maybe?
	 Or just calculate all pyth triples from 1 to N?
	 
	 I think we can... its like we have the info here, we just need to figure out the relationship..
	 -----
	 
	 
	 
	3,4,5
	 5, 12, 13 : 5 is prime, and b and c are both 8 more than previous 3 prime
	 6, 8, 10 ( b and c are 2 away, because 6 is 3*2 )
	 7, 24, 25 : 7 is prime, b and c are now 12 away from previous prime... first it was 8 then now 12
	 8, 15, 17 ( this was interesting because there is no A=4, but we have A=4*2 (I guess because 2 is prime and 1 is not, wow thats honestly so cool) )
	 9, 12, 15 ( 3 away because 3*3 = 9)
	 10, 24, 26 ( 2 away because 5*2)
	 11, 60, 61 : 11 is prime, b and c are 36 away
	 12, 16, 20 ( 3*4)
	 13, 84, 85 ( prime, b and c are 24 away...)
	 14, 48, 50 ( 7*2 )
	 15, 20, 25
	16, 30, 34
	17, 144, 145
	18, 24, 30
	19, 180, 181
	20, 21, 29
	21, 28, 35
	22, 120, 122
	23, 264, 265
	24, 32, 40
	25, 60, 65
	26, 168, 170
	27, 36, 45
	28, 45, 53
	29, 420, 421
	30, 40, 50
	31, 480, 481
	32, 60, 68
	33, 44, 55
	34, 288, 290
	35, 84, 91
	36, 48, 60
	37, 684, 685
	38, 360, 362
	39, 52, 65
	40, 42, 58
	
	---- just primes:
	3, 4, 5
	5, 12, 13
	7, 24, 25
	11, 60, 61
	13, 84, 85
	17, 144, 145
	19, 180, 181
	23, 264, 265
	29, 420, 421
	31, 480, 481
	37, 684, 685
	41, 840, 841
	43, 924, 925
	47, 1104, 1105
	53, 1404, 1405
	59, 1740, 1741
	61, 1860, 1861
	67, 2244, 2245
	71, 2520, 2521
	73, 2664, 2665
	79, 3120, 3121
	83, 3444, 3445
	89, 3960, 3961
	97, 4704, 4705
	
	im curious about the jumps from b and c between the primes being a
	...printLotsOfTriplesJustPrimes() wrote this to help check
	
	
	
...3,4,5
5,12,13 ||| diff from last: 2, 8, 8 |||  b or c / a = 4, diff of last diff: -1
7,24,25 ||| diff from last: 2, 12, 12 |||  b or c / a = 6, diff of last diff: 2
11,60,61 ||| diff from last: 4, 36, 36 |||  b or c / a = 9, diff of last diff: 3
13,84,85 ||| diff from last: 2, 24, 24 |||  b or c / a = 12, diff of last diff: 3
17,144,145 ||| diff from last: 4, 60, 60 |||  b or c / a = 15, diff of last diff: 3
19,180,181 ||| diff from last: 2, 36, 36 |||  b or c / a = 18, diff of last diff: 3
23,264,265 ||| diff from last: 4, 84, 84 |||  b or c / a = 21, diff of last diff: 3
29,420,421 ||| diff from last: 6, 156, 156 |||  b or c / a = 26, diff of last diff: 5
31,480,481 ||| diff from last: 2, 60, 60 |||  b or c / a = 30, diff of last diff: 4
37,684,685 ||| diff from last: 6, 204, 204 |||  b or c / a = 34, diff of last diff: 4
41,840,841 ||| diff from last: 4, 156, 156 |||  b or c / a = 39, diff of last diff: 5
43,924,925 ||| diff from last: 2, 84, 84 |||  b or c / a = 42, diff of last diff: 3
47,1104,1105 ||| diff from last: 4, 180, 180 |||  b or c / a = 45, diff of last diff: 3
53,1404,1405 ||| diff from last: 6, 300, 300 |||  b or c / a = 50, diff of last diff: 5
59,1740,1741 ||| diff from last: 6, 336, 336 |||  b or c / a = 56, diff of last diff: 6
61,1860,1861 ||| diff from last: 2, 120, 120 |||  b or c / a = 60, diff of last diff: 4
67,2244,2245 ||| diff from last: 6, 384, 384 |||  b or c / a = 64, diff of last diff: 4
71,2520,2521 ||| diff from last: 4, 276, 276 |||  b or c / a = 69, diff of last diff: 5
73,2664,2665 ||| diff from last: 2, 144, 144 |||  b or c / a = 72, diff of last diff: 3
79,3120,3121 ||| diff from last: 6, 456, 456 |||  b or c / a = 76, diff of last diff: 4
83,3444,3445 ||| diff from last: 4, 324, 324 |||  b or c / a = 81, diff of last diff: 5
89,3960,3961 ||| diff from last: 6, 516, 516 |||  b or c / a = 86, diff of last diff: 5
97,4704,4705 ||| diff from last: 8, 744, 744 |||  b or c / a = 93, diff of last diff: 7
101,5100,5101 ||| diff from last: 4, 396, 396 |||  b or c / a = 99, diff of last diff: 6
103,5304,5305 ||| diff from last: 2, 204, 204 |||  b or c / a = 102, diff of last diff: 3
107,5724,5725 ||| diff from last: 4, 420, 420 |||  b or c / a = 105, diff of last diff: 3
109,5940,5941 ||| diff from last: 2, 216, 216 |||  b or c / a = 108, diff of last diff: 3
113,6384,6385 ||| diff from last: 4, 444, 444 |||  b or c / a = 111, diff of last diff: 3
127,8064,8065 ||| diff from last: 14, 1680, 1680 |||  b or c / a = 120, diff of last diff: 9
131,8580,8581 ||| diff from last: 4, 516, 516 |||  b or c / a = 129, diff of last diff: 9
137,9384,9385 ||| diff from last: 6, 804, 804 |||  b or c / a = 134, diff of last diff: 5
139,9660,9661 ||| diff from last: 2, 276, 276 |||  b or c / a = 138, diff of last diff: 4
149,11100,11101 ||| diff from last: 10, 1440, 1440 |||  b or c / a = 144, diff of last diff: 6
151,11400,11401 ||| diff from last: 2, 300, 300 |||  b or c / a = 150, diff of last diff: 6
157,12324,12325 ||| diff from last: 6, 924, 924 |||  b or c / a = 154, diff of last diff: 4
163,13284,13285 ||| diff from last: 6, 960, 960 |||  b or c / a = 160, diff of last diff: 6
167,13944,13945 ||| diff from last: 4, 660, 660 |||  b or c / a = 165, diff of last diff: 5
173,14964,14965 ||| diff from last: 6, 1020, 1020 |||  b or c / a = 170, diff of last diff: 5
179,16020,16021 ||| diff from last: 6, 1056, 1056 |||  b or c / a = 176, diff of last diff: 6
181,16380,16381 ||| diff from last: 2, 360, 360 |||  b or c / a = 180, diff of last diff: 4
191,18240,18241 ||| diff from last: 10, 1860, 1860 |||  b or c / a = 186, diff of last diff: 6
193,18624,18625 ||| diff from last: 2, 384, 384 |||  b or c / a = 192, diff of last diff: 6
197,19404,19405 ||| diff from last: 4, 780, 780 |||  b or c / a = 195, diff of last diff: 3
199,19800,19801 ||| diff from last: 2, 396, 396 |||  b or c / a = 198, diff of last diff: 3
211,22260,22261 ||| diff from last: 12, 2460, 2460 |||  b or c / a = 205, diff of last diff: 7
223,24864,24865 ||| diff from last: 12, 2604, 2604 |||  b or c / a = 217, diff of last diff: 12
227,25764,25765 ||| diff from last: 4, 900, 900 |||  b or c / a = 225, diff of last diff: 8
229,26220,26221 ||| diff from last: 2, 456, 456 |||  b or c / a = 228, diff of last diff: 3
233,27144,27145 ||| diff from last: 4, 924, 924 |||  b or c / a = 231, diff of last diff: 3
239,28560,28561 ||| diff from last: 6, 1416, 1416 |||  b or c / a = 236, diff of last diff: 5
241,29040,29041 ||| diff from last: 2, 480, 480 |||  b or c / a = 240, diff of last diff: 4
251,31500,31501 ||| diff from last: 10, 2460, 2460 |||  b or c / a = 246, diff of last diff: 6
257,33024,33025 ||| diff from last: 6, 1524, 1524 |||  b or c / a = 254, diff of last diff: 8
263,34584,34585 ||| diff from last: 6, 1560, 1560 |||  b or c / a = 260, diff of last diff: 6
269,36180,36181 ||| diff from last: 6, 1596, 1596 |||  b or c / a = 266, diff of last diff: 6
271,36720,36721 ||| diff from last: 2, 540, 540 |||  b or c / a = 270, diff of last diff: 4
277,38364,38365 ||| diff from last: 6, 1644, 1644 |||  b or c / a = 274, diff of last diff: 4
281,39480,39481 ||| diff from last: 4, 1116, 1116 |||  b or c / a = 279, diff of last diff: 5
283,40044,40045 ||| diff from last: 2, 564, 564 |||  b or c / a = 282, diff of last diff: 3
293,42924,42925 ||| diff from last: 10, 2880, 2880 |||  b or c / a = 288, diff of last diff: 6

...ahh interesting... so the b or c divided by a = 6, 9, 12, 15, 18, 21.... now we are talking..
They all go up by 3,
but then we get to 29,420,421 and that one went up by 5. In fact the next ones seems to be random, just like prime numbers... damn sucks
so does that mean we can find all triples now?

I was hoping if we find primes, then could we know what b and c are?

so far.... no...



	 */

public void testAs(int max) {
	
	// = 100000;
	
	for(int i=1; i < max; i++) {
		if(i % 1000 == 0)System.out.println("Doing " + i);
		if(getPythagoreanTripleFromThisA(i) == null) {
			System.out.println("no sol for " + i);
		}
	}
}
public void printLotsOfTriplesJustPrimes() {
	
	List<Integer> primes = Util.getPrimesUnderWithSqrt(1300);
	//int min = 3, max = 40;
	//String ans = getPythagoreanTripleFromThisA(19);
	int la = 3, lb = 4, lc = 5, ld = 5; // I just start with 5 because it makes it say -1, since there is no answer as this is the first one... 5 means nothing here just dummy data
	for(Integer i : primes) {
		if(i == 2 || i == 3)continue;
		
		int[] ans = getPythagoreanTripleFromThisA(i);
		
		if(ans == null) 
			System.out.println("no sol for " + i);
		else {
			
		
			int ta = ans[0] - la; // temp a - last a
			int tb = ans[1] - lb; // temp b - last b
			int tc = ans[2] - lc; // temp c - last c
			
			la = ans[0];
			lb = ans[1];
			lc = ans[2];
			
			if((double)tb/ta - (tb/ta) != 0) {
				System.out.println("ERROR:::::::::: " + (double)tb/ta);
			}
			int nd = (tb/ta);
			int testlast = (nd - ld);
			
			int sum = ans[0] + ans[1] + ans[2];
			System.out.println(sum + " :: " + ans[0] + "," + ans[1] + "," + ans[2] + " ||| diff from last: " + ta + ", " + tb + ", " + tc + " ||| " + " b or c / a = " + nd + ", diff of last diff: \t" + testlast + " , " + (testlast-ta) );
			
			ld = nd;
		}
	}
}

public void printLotsOfTriplesJustPrimesAndActuallyDoProblem() {
	
	List<Integer> primes = Util.getPrimesUnderWithSqrt(1300); //1300
	//int min = 3, max = 40;
	//String ans = getPythagoreanTripleFromThisA(19);
	int la = 3, lb = 4, lc = 5, ld = 5; // I just start with 5 because it makes it say -1, since there is no answer as this is the first one... 5 means nothing here just dummy data
	int max = 1500000;
	int counter = 0;
	Set<Integer> sums = new HashSet<Integer>();
	//List<Integer> primesWithDups = new ArrayList<Integer>();
	Set<Integer> dups = new HashSet<Integer>();
	//Map<Integer, boolean> dups = new HashSet<Integer>();
	System.out.println("Removing " + primes.get(0));
	primes.remove(0);
	primes.add(0,8);
	for(Integer i : primes) {

		
		//if(i == 2 )continue;
		List<Integer[]> trips = getPythagoreanTriplesFromThisA(i);
		//int[] ans = getPythagoreanTripleFromThisA(i);
		
		for(Integer[] ans : trips) {
			//System.out.println("trip: " + ii[0] + "," + ii[1] + "," + ii[2] );
		//}
		
			if(ans == null) {
				System.out.println("skipping : " + ans[0] + " " + ans[1] + " " + ans[2]); 
				continue;
			} //else if(i == 8) {
			//	System.out.println("here with 8 : " +  ans[0] + " " + ans[1] + " " + ans[2]); 
			//}
			int sum = ans[0] + ans[1] + ans[2];
			
			la = ans[0];
			lb = ans[1];
			lc = ans[2];
			//System.out.println(sum + " \tfound a trip: " + ans[0] + "," + ans[1] + "," + ans[2]);
			//if(ans == null) {
			//	System.out.println("no sol for " + i);
			//}
			//else {
			if(sum > max) {
				
				System.out.println("Stopppping here because sum = " + sum + " for " + ans[0] + "," + ans[1] + "," + ans[2]);
				System.out.println("and all multiples will be bigger, and the next triple will be bigger, there is no more to do under " + max);
				break;
			}
			
			/*if(sums.add(sum)) {
				counter++;
			} else {
				dups.add(sum);
			}*/
			
			int multiple = 1;
			while(sum <= max) {
				if(sums.add(sum)) {
					counter++;
					System.out.println(sum + " \tanother trip " + ans[0] + "," + ans[1] + "," + ans[2]);
				} else {
					dups.add(sum);
				}
				multiple++;
				ans[0] = la * multiple;
				ans[1] = lb * multiple;
				ans[2] = lc * multiple;
				sum = ans[0] + ans[1] + ans[2];
				
			}
			
			
			/*while(sum <= max) {
				
				ans[0] = ans[0] + la;
				ans[1] = ans[1] + lb;
				ans[2] = ans[2] + lc;
				sum = ans[0] + ans[1] + ans[2];
				if(max > sum) {
					//System.out.println(sum + " \tanother trip " + ans[0] + "," + ans[1] + "," + ans[2]);
					if(sums.add(sum)) {
						counter++;
					} else {
						dups.add(sum);
					}
				} else { 
					//break;
				}
				
				
			} */
			sum = 0;
			//}
		}
	}
	System.out.println("Sum count: " + sums.size() + ", dup count: " + dups.size() + ", diff = " + (sums.size() - dups.size()) + " counter:" + counter);
	for(Integer i : dups) {
		sums.remove(i);
	}
	System.out.println("Sum count: " + sums.size());
	
}

public static List<Integer[]> getAllPythagoreanTriplesWithALessThan(int max) {
	List<Integer[]> l = new ArrayList<Integer[]>();
	int min = 3;
	for(int i = min; i <= max; i++) {
		//int[] ans = getPythagoreanTriplesFromThisA(i);
		List<Integer[]> tr = getPythagoreanTriplesFromThisA(i);
		
		for(int ia = 0; ia < tr.size(); ia++) {
			Integer[] ii = tr.get(ia);
			if(ii != null)
				l.add(new Integer[]{ii[0],ii[1],ii[2]});
			//else System.out.println("no sol for : " + ia );
		}
		
		
		//if(ans != null)
		//	System.out.println(ans[0] + ", " + ans[1]+ ", " + ans[2]);
	}
	return l;
}

public static void printAllPythagoreanTriplesWithALessThan(int max) {
	List<Integer[]> l = getAllPythagoreanTriplesWithALessThan(max);
	for(Integer[] ii : l) {
		System.out.println(ii[0] + "," + ii[1] + "," + ii[2] );
	}

}
public static void printAllPythagoreanTriplesWithALessThanWithDetails(int max) {
	int min = 3; //, max = 40;
	//String ans = getPythagoreanTripleFromThisA(19);
	for(int i = min; i <= max; i++) {
		//int[] ans = getPythagoreanTriplesFromThisA(i);
		List<Integer[]> tr = getPythagoreanTriplesFromThisA(i);
		
		for(int ia = 0; ia < tr.size(); ia++) {
			Integer[] ii = tr.get(ia);
			
			if(ii != null) {
				int a=ii[0], b=ii[1], c=ii[2], ao=(a*2 -1), bo=(b*2 -1), co=(c*2 -1);
				int a2 = a*a, b2 = b*b, c2 = c*c;
				List<Integer> factsa = Util.getPrimeFactors(a);
				List<Integer> factsb = Util.getPrimeFactors(b);
				List<Integer> factsc = Util.getPrimeFactors(c);
				System.out.println("triple:\t" + a + "\t" + b + "\t" + c);
				System.out.println("sq:\t" + a2 + "\t" + b2 + "\t" + c2);
				System.out.println("odd:\t" + ao + "\t" + bo + "\t" + co);
				System.out.print("odds between b and c: ");
				int t = bo;
				while(t < co) System.out.print((t+=2) + " ");
				System.out.println();
				System.out.println("diff:\tb-a: " + (b-a) + "\tc-a: " + (c-a) + "\tc-b: " + (c-b));
				System.out.println("diff2:\tb2-a2: " + (b2-a2) + "\tc2-a2: " + (c2-a2) + "\tc2-b2: " + (c2-b2));
				System.out.print("facts a: ");
				for(Integer ai : factsa) {
					System.out.print(ai + " ");
				}
				System.out.println();
				System.out.print("facts b: ");
				for(Integer bi : factsb) {
					System.out.print(bi + " ");
				}
				System.out.println();
				System.out.print("facts c: ");
				for(Integer ci : factsc) {
					System.out.print(ci + " ");
				}
				System.out.println();
				System.out.println();
				//System.out.println(ii[0] + " (" + ao + ")," + ii[1] + "(" + bo + ")," + ii[2] + "(" + co + ")");
			} else {
				System.out.println("no sol for : " + ia );
			}
		}
		//if(ans != null)
		//	System.out.println(ans[0] + ", " + ans[1]+ ", " + ans[2]);
	}
}

public static List<Integer[]> printLotsOfTriplesButOnlyReduced(int maxSum) {
	int min = 3; //, max = 40;
	//String ans = getPythagoreanTripleFromThisA(19);
	int sum = 0, i = min;
	List<Integer[]> sols = new ArrayList<Integer[]>();
		//int[] ans = getPythagoreanTriplesFromThisA(i);
	//while(sum <= maxSum) {
	while(i*3 < maxSum) { //////need to fix this, should be better
		
		if(i % 1000 == 0) {
			System.out.println("At i = " + i);
		}
		
		List<Integer[]> tr = getPythagoreanTriplesFromThisA2(i);
		//System.out.println("tr before size for a = " + i + " : " + tr.size() + ", sols size: " + sols.size());
		//if(sols.size() > 0) {
		//	System.out.println("first sol?? " + sols.get(0)[0] + ", " +  sols.get(0)[1] + ", " + sols.get(0)[2]);
		//}
		for(int ia = 0; ia < tr.size(); ia++) {
			Integer[] ii = tr.get(ia);
			
			
			
			
			if(ii == null) {
				//System.out.println("no sol for : " + ia );
				continue;
			}
			
			sum = ii[0] + ii[1] + ii[2];
			//System.out.println("new sum : " + sum);
			if(sum > maxSum)
				continue;
			
			int gcd1 = Util.gcd(ii[0], ii[1]);
			
			//System.out.println("gcd1 and 2 : " + gcd1 + " " + gcd2);
			if(gcd1 == 1) {
				// this means a and b have no factors in common
				// this means we dont even check factors for c, because we are only interested in all abc having no common factors
				// and if a and b already dont have factors, then it doesnt matter what c has...
				//...trip? 
				//System.out.println("trip in lowest form: " + ii[0] + "," + ii[1] + "," + ii[2] );
				sols.add(new Integer[] {ii[0], ii[1], ii[2]});
				continue;
			}
			
			int gcd2 = Util.gcd(ii[1], ii[2]);
			
			if(gcd1 == gcd2) {
				//System.out.println("trip: " + ii[0] + "," + ii[1] + "," + ii[2] + " ::: reduced: " + (ii[0]/gcd1) + "," + (ii[1]/gcd1) + "," + (ii[2]/gcd1) + " gcd: " + gcd1);
				int gcd12 = Util.gcd(ii[0]/gcd1, ii[1]/gcd1);
				int gcd22 = Util.gcd(ii[1]/gcd2, ii[2]/gcd2);
				if(gcd12 != 1 && gcd12 == gcd22) {
					System.out.println("HAS MORE THAN ONE FACTOR IN COMMON ^^ " + gcd12 + " :: " + ii[0] + "," + ii[1] + "," + ii[2]);
				} else {
					//sols.add(new Integer[] {ii[0]/gcd1, ii[1]/gcd1, ii[2]/gcd1});
				}
			} else { 
				System.out.println("ddtrip: " + ii[0] + "," + ii[1] + "," + ii[2] );
				
				sols.add(new Integer[] {ii[0], ii[1], ii[2]});
				System.exit(0);
			}
		//} else {
			//System.out.println("no sol for : " + ia );
			//continue;
			//}
			
			
			
		}
		//System.out.println("tr after for a = " + i + " : " + sols.size());
		i++;
		//if(ans != null)
		//	System.out.println(ans[0] + ", " + ans[1]+ ", " + ans[2]);
		
	}
	//System.out.println("Test gcd : " + Util.gcd(6, 8) + " : " + Util.gcd(10, 8));
	
	return sols;
}

	public void testSomeStartingATriples() {
		int min = 3000, max = 4000;
		for(int i = min; i < max; i++) {
			int[] ans = getPythagoreanTripleFromThisA(i);
			if(ans == null) {
				System.out.println("No solution for " + i);
			}
		}
		System.out.println("Done..");
	}
	
	public static List<Integer[]> getPythagoreanTriplesFromThisA2(int a) {
		List<Integer[]> trips = new ArrayList<Integer[]>();
		/*
		 05/23/2022
		//so we have a.. how do we find numbers that are a^2 apart..
		// can we use the fact that we know some small thing about squares...
		// that squares go up by all odd numbers.. 
		// like 2^2 = 4, then the next square is +5
		0^2 = 0
		1^2 = 1 (+1)
		2^2 = 4 (+3)
		3^2 = 9 (+5)
		4^2 = 16 (+7)
		5^2 = 25 (+9)
		6^2 = 36 (+11)
		7^2 = 49 (+13)
		8^2 = 64 (+15)
		9^2 = 81 (+17)
		10^2 = 100(+19)
		11^2 = 121(+21)
		12^2 = 144(+23)
		13^2 = 169(+25)
		14^2 = 196(+27)
		15^2 = 225(+29)
		so what if we have 5^2 for example, and we want to find 2 squares that are 5^2 away
		first can we find the odd number corresponding to 5^2 ? its (+9) === we can do *2 - 1, so 5*2 -1 = 9
		then we start with b = 5+1 I guess which is 6^2 (+11)
		
		...wait ... so we can see since 25 is an odd number, we already know what 2 squares can be b and c.. 
		we just find the square that is (+25) to the next square...
		do that by reversing a*2 - 1 = 25
		25 + 1 = 26 / 2 = 13
		and the one before is 25 away, so 12 and 13 are b and c... niceeeeeeee
		thats nice..
		But are there any others where a = 5? and what about evens?
		lets figure out how to do more than 1 for this number first (before we do evens.)
		
		lets use 20 for the even, since it has more than 1 triple (20 21 29, 20 99 101) and 33 if we want to do another odd (33,56,65 :: 33,544,545)
		(I guess we have to do evens
		
		alright so if we want to find 2 squares that are next to eachother, we just use the odd number trick..
		But what if they are not right next to eachother... what do we do... do we find a combination of odd numbers that add to the num or something?
		so 33...
		(33,56,65 :: 33,544,545)
		
		33^2 = 1089
		we use the odd number trick = 1089 + 1 = 1090, 1090 / 2 = 545. So c = 545, b = 545 - 1 (544) yay we did it guys and gals..
		but what about the other trip for 33, 33 56 65
		does that mean 1089 is also the combination of 1 or more consecutive odd numbers? I mean I guess
		56^2 = 3136
		65^2 = 4225
		 
		so how do we find those 2 that are 1089 away...
		
		
		... for evens, its easy
		just (a / 2) ^2
		so if a = 12, then 12/2 = 6, 6^2 = 36, and that means b and c are on either side of 36, so 35 and 37..
		
		.. then gotta find a way to do all 3 of these for 21
		21,28,35 (7 away) - not sure, I guess they are just multiples of smaller triples.. we can just find them that way
		21,72,75 - (3 away) - not sure, I guess they are just multiples of smaller triples.. we can just find them that way
		21,220,221 - ( 1 away) 21 = 10th odd number... so 21 * 10 + 10 ( and this one is 1 away)
		
		it is interesting that 7 away, 3 away, 1 away, are the factors of 21.. hmm
		 
		 etc...
		 */
		int b = a+1, c = a+2;
		//System.out.println("Starting with a=" + a + " b=" + b + " c=" + c + " ||| ");
		while (true) {
			int a2 = a*a, b2 = b*b, c2 = c*c;
			int diff = c2 - b2;
			//System.out.println("Now with a=" + a + " b=" + b + " c=" + c + " ||| " + "a2=" + a2 + " b2=" + b2 + " c2=" + c2 + " .. diff=" + diff);
			if(diff == a2) {
				//System.out.println("Yay we found one : " + a + ", " + b + ", " + c);
				trips.add(new Integer[] {a,b,c});
				b++;
				c = b+1;
				//System.out.println("incrementing b to " + b + ", and putting c to " + c + " to check for more sols..");
				continue;
			} else if(diff < a2) {
				c++;
				//System.out.println("incrementing c to " + c);
			} else {
				if(c-b == 1) { // if diff > a^2, and c and b are right net to each other, then we are at the limit, any next nums will be even larger.
					break;
				}
				b++;
				c = b+1;
			}
		}
		return trips;
	}
	
public static List<Integer[]> getPythagoreanTriplesFromThisA(int a) {
	// similar to below function, but this will find all triples where a=...
	List<Integer[]> trips = new ArrayList<Integer[]>();
		
		// so we will start with a as smallest
		// and the next b and c are next two nums up
		int b = a+1, c = a+2;
		//System.out.println("Starting with a=" + a + " b=" + b + " c=" + c + " ||| ");
		while (true) {
		
			int a2 = a*a, b2 = b*b, c2 = c*c;
			int diff = c2 - b2;
			
			//System.out.println("Now with a=" + a + " b=" + b + " c=" + c + " ||| " + "a2=" + a2 + " b2=" + b2 + " c2=" + c2 + " .. diff=" + diff);
			if(diff == a2) {
				//System.out.println("Yay we found it");
				//return a + ", " + b + ", " + c;
				trips.add(new Integer[] {a,b,c});
				//return a + ", " + b + ", " + c + " ||| " + a2 + ", " + b2 + ", " + c2 + " ||||| " + a2 + "+" + b2 + "=" + (a2+b2);
			}
			
			if(diff < a2) { //like 9 is less than 16 at the beginning if a=3
				//then what, we increment c, leave b alone
				
				c++;
				//System.out.println("incrementing c to " + c);
			} else {
				// else diff is bigger. then we went too far
				//so put c back
				if(c-b == 1) {
					//return "no solution... with smallest number being " + a;
					//return null;
					break;
				}
				b++;
				c = b+1;
				//System.out.println("incrementing b to " + b + ", and putting c to " + c);
			}
			
		}
		
		return trips;
	}
	
	public int[] getPythagoreanTripleFromThisA(int a) {
		
		// so we will start with a as smallest
		// and the next b and c are next two nums up
		int b = a+1, c = a+2;
		//System.out.println("Starting with a=" + a + " b=" + b + " c=" + c + " ||| ");
		while (true) {
		
			int a2 = a*a, b2 = b*b, c2 = c*c;
			int diff = c2 - b2;
			
			//System.out.println("Now with a=" + a + " b=" + b + " c=" + c + " ||| " + "a2=" + a2 + " b2=" + b2 + " c2=" + c2 + " .. diff=" + diff);
			if(diff == a2) {
				//System.out.println("Yay we found it");
				//return a + ", " + b + ", " + c;
				return new int[] {a,b,c};
				//return a + ", " + b + ", " + c + " ||| " + a2 + ", " + b2 + ", " + c2 + " ||||| " + a2 + "+" + b2 + "=" + (a2+b2);
			}
			
			if(diff < a2) { //like 9 is less than 16 at the beginning if a=3
				//then what, we increment c, leave b alone
				
				c++;
				//System.out.println("incrementing c to " + c);
			} else {
				// else diff is bigger. then we went too far
				//so put c back
				if(c-b == 1) {
					//return "no solution... with smallest number being " + a;
					return null;
				}
				b++;
				c = b+1;
				//System.out.println("incrementing b to " + b + ", and putting c to " + c);
			}
			
		}
	}
	
	
	public void testThing(){
		int a = 3, b = 4, c = 5;
		int max = 15;
		System.out.print( " ----");
		for(int i = 1; i < max; i++) {
			long ai = (a*i), bi = (b*i), ci = (c*i);
			long a2 = ai*ai, b2 =  bi*bi, c2 = ci*ci;
			System.out.println(ai + " " + bi + " " + ci );
			
			System.out.print( " ----" + a2 + " " + b2 + " " + c2 + " ::: " + (a2 + b2) + " = " + c2 );
			if((a2 + b2) != c2) {
				//System.out.println("--Yes--");
			//} else  {
				System.out.println("--No--");
				return;
			}
			//System.out.println("----");
			 
		}
		
		System.out.println("\nYay all worked");
	}

	/////////////////////////From last time I tried to think about it:
	
	public String problem1() {
		
		/*
		 so a2 + b2 = c2....
		 c is bigger than a and b
		 
		 so some number N + b = c
		 N cant just be anything, there is some limit right?
		 like for b to become some larger square number, you have to add at least a certain amount to get to, at the very least, the next square above b
		 
		 
		 so like 6, 8, 10 = 36, 64, 100
		 lets say we didnt know a, 36
		 N + 64 = ...?
		 well the next square above 8^2 (64) is 9^2 (81)
		 so something plus 64.... that something has to at the very least be 17 so you have to find a square >= than 17
		 you need to at least go up to, or past, the next square above b..
		 SO ---- if we were trying to find pythagorum triples and we were testing with 64 as B..
		 then A cant be 1, 2, 3, 4 since those are < 17 when squared
		 its sqrt(64) + 1 = 9
		 9^2 = 81
		 81 - 64 = 17
		 do all squares so that 17 <= N <= 64
		 which only leaves 5, 6, 7 ... 
		 I wonder how many will fit in the gap for higher numbers...
		 
		 looks like that gap widens as numbers get higher...meaning this formula is quick when numbers are small, but gets slower and slower as we go higher
		 
		 */
		int totalMax = 100;
		//int maxx = 1500000;
		int maxx = 1800;
		List<Long> sqrs = new ArrayList<Long>();
		List<Long> sqrrts = new ArrayList<Long>();
		
		List<Long> dupsList = new ArrayList<Long>();
		List<Long> totsList = new ArrayList<Long>();
		
		int count = 0, track = 3;
		//so what if this number i is the B
		long sq = 1;
		for(long b=2; b < totalMax; b++) {
			
			
			//We are essentially looking for 2 squares that are a square number away from each other...hmmm 
			
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
				//System.out.println("b=" + b + " sqr=" + sq + " nextSquare=" + nextSquare + " diff=" + diff +  " difsrt=" + difsrt + "::: how many squares to check between = " + (b - difsrt));
			//}

			// now srt is where a should start, then go until i
			long tracka = 0;
			for(long a = difsrt; a < b; a++) {
				//long sum = (a*a) + sq;
				double c = (double)Math.sqrt((a*a) + sq);
				
				//System.out.println("Trying : " + a + "  " + b + "  " + c);
				if(c - (long)c == 0) {
					long tots = (long) (a + b + c); 
					if(tots > maxx || tots < 0) {
						System.out.println("hmm wierd total " + tots + " a=" + a + " b=" + b + " c=" + c);
					} else {
						count++;
					}
					
					double a2 = a*a, b2 = b*b, c2 = c*c;
					//System.out.println("Did it work? " + a2 + " : " + b2 + " : " + c2 + " ========= " + ((a2 + b2) == c2));
					//System.out.println("Did it work1? " + Math.sqrt(a2) + " : " + Math.sqrt(b2) + " : " + Math.sqrt(c2));
					if(((double)a*a) + ((double)b*b) == ((double)c*c)) {
						
					}
					
					if(totsList.contains(tots)) {
						System.out.println("Duplicate: " + tots);
						totsList.remove(tots);
						dupsList.add(tots);
					} else {
						totsList.add(tots);
						System.out.println(tots + ": (" + a + "," + b + "," + c + ") (" + a2 + "," + b2 + "," + c2 + ")" + " " + (b-a) + "," + (c-b) + " :: " + (b2-a2) + "," + (c2-b2));
					}
				}
			}
			
		}
		
		long lastLong = 0;
		System.out.println("Found " + count + " under " + totalMax);
		Collections.sort(totsList);
		for(long l : totsList) {
			System.out.println(l + " :: " + (l-lastLong));
			lastLong = l;
		}
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
	
	
	
	public static void doOtherGuys(int sumToLog, int max, boolean shouldPrint) {
		int limit = max;
		long[] triangles = new long[limit+1];
		 
		int result =0;
		int mlimit = (int)Math.sqrt(limit / 2);
		 
		for (long m = 2; m < mlimit; m++) {
		    for (long n = 1; n < m; n++) {
		        if (((n + m) % 2) == 1 && Util.gcd(n, m) == 1) {
		            long a = m * m + n * n;
		            long b = m * m - n * n;
		            long c = 2 * m * n;
		            long p = a + b + c;
		            while(p <= limit){
		                triangles[(int) p]++;
		                if(p == sumToLog) System.out.println("abc: " + a + " "+ b  + " " + c + " == " + (a + b + c) + " P=" + p);
		                if (triangles[(int) p] == 1) {result++;}
		                if (triangles[(int) p] == 2) { result--;}
		                p += a+b+c;
		                //if(p == 112) System.out.println("abc: " + a + " "+ b  + " " + c + " == " + (a + b + c) + " P=" + p);
		            }
		        }
		    }
		}
		
		if(shouldPrint) {
			List<Integer> good = new ArrayList<Integer>();
			List<Integer> dups = new ArrayList<Integer>();
			for (int i = 0; i < triangles.length; i++) {
				if( triangles[i] == 1) {
						//System.out.println("good Tri " + i + " : " + triangles[i]);
					good.add(i);
				}
				else if (triangles[i] > 1)
					dups.add(i);
					//System.out.println("dup Tri " + i + " : " + triangles[i]);
			}
			
			for(Integer i : good) {
				System.out.println("good Tri " + i + " : " + i);
			}
			
			for(Integer i : dups) {
				System.out.println("dups Tri " + i + " : " + i);
			}
		}
		
		
		System.out.println(" resssss " + result);
		
	}
	

}
