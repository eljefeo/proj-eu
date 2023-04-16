import java.util.ArrayList;
import java.util.Collections;
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
		//Problem pp = new Problem75();
		//pp.runProblem();
		//printAllPythagoreanTriplesWithALessThan(75);
		//printAllPythagoreanTriplesWithALessThanWithDetails(100);
		//printOddsAndSquaresOrder(1000);
		
		//doLotsOfDiffsAndSumsOfSquares(20);
		
		
		//findTripsThenCompareDiffAndSums(40, false);
		System.out.println("===========");
		System.out.println("===========");
		System.out.println("===========");
		//findTripsThenCompareDiffAndSumsReduced(70, false);
		
		//printReducedTriples(70);
		//printTripFromThisA2(9);
		System.out.println("===========");
		//find2NumsForThisTrip(65,2112,2113);
		//printTripsFromAtoA(1,20);
		
		//testGetTripsFromAvsA2(3000);
		//printPythTriplesOnlyReducedNotPredictable(800);
		
		//doOtherGuys(70, max, false);
		
		
		//generateSomeTriplesUpToXY(10);
		maybeTryProblem(1500000);
	}

	public static String maybeTryProblem(int maxPerim){
		//int maxPerim = 100;
		int count = 0;
		boolean jJustMaxed = false;
		int i = 0;
		int j = 0;
		List<Integer> sols = new ArrayList<Integer>();
		Set<Integer> solset = new HashSet<Integer>();
		int[] sums = new int[maxPerim + 1];
		//for(int i =  1; i < max; i++) { //while(true) i++;
		while(true) {
			i++;
			
			j = i;
			//System.out.println("start i " + i + " j " + j); 
			//for(int j = i+1; j < max; j++) {
			while (true) {
				j++;
				//System.out.println("start j " + " : x y = " + i + "," + j);
				//hopefully this is ok to be here, skip this i and j if both are odd or both are even 
				// (we seem to always get a multiple of a previous trip when both i and j are odd or both are even
				if((i%2 == 0) == (j%2 == 0)) {
					//System.out.println("Skipping trip where both i and j are odd/even " + " : x y = " + i + "," + j);
					continue;
					//System.out.println("Skipping trip where both i and j are odd/even " + gcd1 + " : x y = " + i + "," + j + " : " + a + "," + b + "," + c + " :: " + sum);
					//if(gcd1 == 1) {
					//	System.out.println("Really bad...exiting");
					//	System.exit(1);
					//}
				}
				
		
				
				int i2 = i*i, j2 = j*j;
				//int ab = j2 - i2;
				int a = j2 - i2;
				int b = 2 * i * j;
				int c = j2 + i2;
				int sum = a + b + c;
				//System.out.println("x y = " + i + "," + j + " : " + a + "," + b + "," + c + " :: " + sum);
				
				//TODO if i and j are same!!!!!!!!! 
				
				
				if(sum > maxPerim) {
					if(jJustMaxed) {
						System.out.println("Looks like we are at the end.. every other i and j will just go over the max perimeter of " + maxPerim);
						System.out.println("Count is " + count);
						int cc = 0;
						for(Integer k : sums)
							if(k.compareTo(1) == 0)
								cc++;
						System.out.println("cc is " + cc);
						return "" + cc;
					}
					//System.out.println("Went over max perim: " + a + "," + b + "," + c + " : " + sum + " : " + i + "," + j);
					jJustMaxed = true;
					break;
				} else {
					jJustMaxed = false;
				}
				
				int gcd1 = Util.gcd(a, b);
				//boolean ieven = i%2 == 0;
				//boolean jeven = j%2 == 0;
				
				
				
				
				
				if(gcd1 == 1) {
					
					
					
					//can remove this little thing later:
					//if(ieven == jeven) {
					//	System.out.println("NOOOOO this is a valid reduced trip where both i and j are odd/even: x y = " + i + "," + j + " : " + a + "," + b + "," + c + " :: " + sum);
					//	System.exit(1);
					//} 
					//if(sum > maxPerim) 
						//System.out.println("Already above max! will skip this one altogether :: " + "x y = " + i + "," + j + " : " + a + "," + b + "," + c + " :: " + sum);
					//else {
						sols.add(sum);
						if(!solset.add(sum)) {
							
						}
						
						//System.out.println("x y = " + i + "," + j + " : " + a + "," + b + "," + c + " :: " + sum);
					//}
					///end remove
					
					
					//count++;
					
					//int m = 2;
					int nSum = sum;
					while(nSum <= maxPerim) {
						
						count++;
						sums[nSum]++;
						//System.out.println("adding sum = " + nSum + " count is now " + count);
						nSum += sum; // * m++;
						
					}
					
				} else {
					
					
					//if(ieven == jeven) {
						//System.out.println("skippiing this multiple trip where both i and j are odd/even: x y = " + i + "," + j + " : " + a + "," + b + "," + c + " :: " + sum);
					//} else { 
					//	System.out.println("RARE skippiing this multiple trip where both i and j are NOT odd/even " + gcd1 + " : x y = " + i + "," + j + " : " + a + "," + b + "," + c + " :: " + sum);
					//}
				}
				//System.out.println();

					
			}
		}
		//System.out.println("done, found this many triples: " + sols.size());
		//return "" + count;
		
	}
	
	public static List<Integer[]> generateSomeTriplesUpToXY(int max){
		
		List<Integer[]> sols = new ArrayList<Integer[]>();
		for(int i =  1; i < max; i++) {
			for(int j = i+1; j < max; j++) {
				
				
				if(i == j) {
					System.out.println("THEY ARE THE SAMEEEEEE");
					System.exit(1);
				}
				
				
				//TODO if i and j are same!!!!!!!!! 
				int i2 = i*i, j2 = j*j;
				int ab = j2 - i2;
				int c = j2 + i2;
				int ba = 2 * i * j;
				int a,b;
				if(ab > ba) {
					b = ab;
					a = ba;
				} else {
					a = ab;
					b = ba;
				}
				
				
				
				
				
				//System.out.print("x y = " + i + "," + j + " : " + a + "," + b + "," + c + " :: ");

				int gcd1 = Util.gcd(a, b);
				
				//System.out.println("gcd1 and 2 : " + gcd1 + " " + gcd2);
				///Removing this because it seems that no num of the 3 should have a factor in common, hopefully that is true...
				// Im removing this extra check with that assumption...
				/*
				if(gcd1 > 1) {
					
					int gcd2 = Util.gcd(b, c);
					if(gcd1 == gcd2) {
						System.out.print("possible multiple: gcd in common found: " + gcd1 + " -- Original triple: " + (a/gcd1) + "," + (b/gcd1) + "," + (c/gcd1));
					} else {
						System.out.println("@@So the gcd of a and b was > 1 but the gcd of b and c was not the same..." + gcd1 + ", " + gcd2);
						System.exit(1);//putting this here to see if we even need to check the gcd of b and c, or we can just do a and b
						//seems like it may be that none of the 3 numbers would have a common factor... that saves us some computing..
					}
					
				} else {
					sols.add(new Integer[] {a, b, c});
				}
				*/
				
				
				if(gcd1 == 1) {
					sols.add(new Integer[] {a, b, c});
					System.out.println("x y = " + i + "," + j + " : " + a + "," + b + "," + c + " :: ");
				}
				//System.out.println();

					
			}
		}
		System.out.println("done, found this many triples: " + sols.size());
		return sols;
	}
	
	public static void find2NumsForThisTrip(int a, int b, int c) {
		
		int max = 100000;
		
		
		//int max = 10;
		for(int i =  1; i < max; i++) {
			for(int j = i+1; j < max; j++) {
				//TODO if i and j are same!!!!!!!!! 
				int i2 = i*i, j2 = j*j;
				int diff = j2 - i2;
				int sum = j2 + i2;
				
				if((diff == a || diff == b) && sum == c) {
					System.out.println("Found for trip: + " + a + "," + b + "," + c);
					System.out.println("i: " + i + " j: " + j + " ::: ");
					System.out.println("Diff: " + diff + " sum: " + sum);
					return;
				}
					
				
					
			}
		
		}
		
	}
	
	public static List<Integer[]> getLotsOfDiffsAndSumsOfSquares(int max, boolean shouldPrint) {
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
	
	public static void findTripsThenCompareDiffAndSumsReduced(int max, boolean shouldPrint) {

		
		List<Integer[]> trips = getLotsOfTriplesButOnlyReducedLessThanThisA(max);
		List<Integer[]> ds = getLotsOfDiffsAndSumsOfSquares(max, shouldPrint);
		for(Integer[] trip : trips) {
			boolean f = false;
			for(Integer[] difSum : ds) {
				if((trip[0].compareTo(difSum[0]) == 0 || trip[1].compareTo(difSum[0]) == 0) && trip[2].compareTo(difSum[1]) == 0) {
					System.out.print("Found a match... dif: " + difSum[0] + " sum: " + difSum[1] + " orig2: " + difSum[2] + "," + difSum[3] +  " -- matching trip: " + trip[0] + "," + trip[1] + "," + trip[2]);
					
					if(trip[0].compareTo(difSum[0]) == 0) {
						System.out.print(" --- found " + trip[0] + " and " + trip[2] + " but are missing B " + trip[1]);
					}
					if(trip[1].compareTo(difSum[0]) == 0) {
						System.out.print(" --- found " + trip[1] + " and " + trip[2] + " but are missing A " + trip[0]);
					}
					System.out.println();
					f = true;
					break;
				}
			}
			if(!f) {
				System.out.println("Could not find match for trip: " + trip[0] + "," + trip[1] + "," + trip[2]);
			}
		}
	}
	
	
	public static void findTripsThenCompareDiffAndSums(int howmany, boolean shouldPrint) {
		int max = 40;
		List<Integer[]> trips = getAllPythagoreanTriplesWithALessThan(max);
		List<Integer[]> ds = getLotsOfDiffsAndSumsOfSquares(max, shouldPrint);
		for(Integer[] trip : trips) {
			boolean f = false;
			for(Integer[] difSum : ds) {
				if((trip[0].compareTo(difSum[0]) == 0 || trip[1].compareTo(difSum[0]) == 0) && trip[2].compareTo(difSum[1]) == 0) {
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
	
	public static void printTripsFromAtoA(int start, int end) {
		List<Integer[]> l = getTripsWithAFromAtoA(start, end);
		for(Integer[] tr : l) {
			System.out.println(tr[0] + "," + tr[1] + "," + tr[2]);
		}
	}
	public static void printTripFromThisA2(int num) {
		System.out.println("2trips from: " + num);
		List<Integer[]> l = getPythagoreanTriplesFromThisA2(num);
		for(Integer[] tr : l) {
			System.out.println(tr[0] + "," + tr[1] + "," + tr[2]);
		}
	}
	
	public static List<Integer[]> getTripsWithAFromAtoA(int start, int end){
		List<Integer[]> l = new ArrayList<Integer[]>();
		for(int i = start; i < end; i++) {
			List<Integer[]> trips = getPythagoreanTriplesFromThisA2(i);
			l.addAll(trips);
		}
		return l;
	}
	
	public static void printReducedTriples(int max) {
		List<Integer[]> l = getLotsOfTriplesButOnlyReducedLessThanThisA(max);
		for(Integer[] tr : l) {
			System.out.println(tr[0] + "," + tr[1] + "," + tr[2]);
		}
	}
	
	
	
	public static void printPythTriplesOnlyReducedNotPredictable(int max) {
		List<Integer[]> sols = getLotsOfTriplesButOnlyReducedMaxSum(max);
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
		List<Integer[]> sols = getLotsOfTriplesButOnlyReducedMaxSum(max);
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
	
	
	public static void testGetTripsFromAvsA2(int max) {
		
		boolean allSame = true;
		
		for(int i = 1; i < max; i++) {
			if(i % 100 == 0)System.out.println("Doing " + i); //just logging in case I want to do lotts of things
			List<Integer[]> a = getPythagoreanTriplesFromThisA(max);
			List<Integer[]> a2 = getPythagoreanTriplesFromThisA2(max);
			boolean same = true;
			if((a.size() == a2.size())) {
				//System.out.println("Size same for " + i + " TRUE");
				for(int j = 0; j < a.size(); j++) {
					Integer[] t1 = a.get(j);
					Integer[] t2 = a2.get(j);
					if(t1[0].compareTo(t2[0]) == 0 && t1[1].compareTo(t2[1]) == 0 && t1[2].compareTo(t2[2]) == 0) {
						//System.out.println("Equals : " + "t1: " + t1[0] + "," + t1[1] + "," + t1[2] + " -- t2: " + t2[0] + "," + t2[1] + "," + t2[2] );
					} else {
						System.out.println("NOT EQUALS : " + "t1: " + t1[0] + "," + t1[1] + "," + t1[2] + " -- t2:" + t2[0] + "," + t2[1] + "," + t2[2] );
						if(t1[0] == t2[0]) System.out.println("a is ok " + t1[0] + " : " + t2[0] + " :: " + (t1[0] == t2[0]));
						else System.out.println("a is wrong!!! " + t1[0] + " : " + t2[0] + " :: " + (t1[0] == t2[0]));
						
						if(t1[1] == t2[1]) System.out.println("b is ok " + t1[1] + " : " + t2[1] + " :: " + (t1[1] == t2[1]));
						else System.out.println("b is wrong!!! " + t1[1] + " : " + t2[1] + " :: " + (t1[1] == t2[1]));
						
						if(t1[2] == t2[2]) System.out.println("c is ok " + t1[2] + " : " + t2[2] + " :: " + (t1[2] == t2[2]));
						else System.out.println("c is wrong!!! " + t1[2] + " : " + t2[2] + " :: " + (t1[2] == t2[2]));
						same = false;
						break;
					}
					
					
				}
			} else {
				same = false;
				System.out.println("Size same for " + i + " FALSE!!!!!!!");
			}
			
			if(!same) {
				System.out.println("NOT SAME for " + i);
				allSame = false;
				
			}
			
			
		}
		
		if(allSame) {
			System.out.println("ALL SAME !");
		} else {
			System.out.println("ALL NOT SAME ERRRRRORRRR !");
		}
		
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


public static List<Integer[]> getLotsOfTriplesButOnlyReducedLessThanThisA(int maxA) { //did I mess this up? Are some missing? Its too late, brain hurting
	int min = 3; //, max = 40;
	//String ans = getPythagoreanTripleFromThisA(19);
	
	List<Integer[]> sols = new ArrayList<Integer[]>();
		//int[] ans = getPythagoreanTriplesFromThisA(i);
	//while(sum <= maxSum) {
	for(int i=0; i<maxA; i++) {
		if(i % 1000 == 0) {
			System.out.println("At i = " + i);
		}
		
		List<Integer[]> tr = getPythagoreanTriplesFromThisA2(i);
		for(int ia = 0; ia < tr.size(); ia++) {
			Integer[] ii = tr.get(ia);
			
			if(ii == null) {
				System.out.println("no sol for : " + ia );
				continue;
			}
			
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
				System.out.println("Exiting now...");
				System.exit(0);
			}
		}
	}

	//System.out.println("Test gcd : " + Util.gcd(6, 8) + " : " + Util.gcd(10, 8));
	
	return sols;
}

public static List<Integer[]> getLotsOfTriplesButOnlyReducedMaxSum(int maxSum) { //did I mess this up? Are some missing? Its too late, brain hurting
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
				System.out.println("Exiting now...");
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
