package ProjEuProblems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ProjEuUtil.Util;

public class Problem61 implements Problem { //Took 0.009524 seconds
	
	/*
	 Triangle, square, pentagonal, hexagonal, heptagonal, and octagonal numbers are all figurate (polygonal) numbers and are generated by the following formulae:

Triangle P3,n=n(n+1)/2 1, 3, 6, 10, 15, ...
Square P4,n=n^2 1, 4, 9, 16, 25, ...
Pentagonal P5,n=n(3n-1)/2 1, 5, 12, 22, 35, ...
Hexagonal P6,n=n(2-1) 1, 6, 15, 28, 45, ...
Heptagonal P7,n=n(5n-3)/2 1, 7, 18, 34, 55, ...
Octagonal P8,n=n(3n-2) 1, 8, 21, 40, 65, ...
The ordered set of three 4-digit numbers: 8128, 2882, 8281, has three interesting properties.

The set is cyclic, in that the last two digits of each number is the first two digits of the next number (including the last number with the first).
Each polygonal type: triangle (P3,127=8128), square (P4,91=8281), and pentagonal (P5,44=2882), is represented by a different number in the set.
This is the only set of 4-digit numbers with this property.
Find the sum of the only ordered set of six cyclic 4-digit numbers for which each polygonal type: triangle, square, pentagonal, hexagonal, heptagonal, and octagonal, is represented by a different number in the set.
	 */
	
	static int startPoly = 3, endPoly = 8;
	static int totalPolyCount = (endPoly - startPoly) + 1;
	
	static Map<Integer, Integer[]> allFirstAndLastIndexes; // this is just to help us narrow down the 4 digit nums, smallest and largest 4digit numbers. So we can loop through those and avoid any other numbers
	static Map<Integer, List<Integer>> allPolygonalNumbers;
	static Map<Integer, Boolean> track;
	
	public static void main(String[] args) {
		//new HashMap<Integer, Boolean>();// use to keep track of what ones we have done ( put 5 true means we found a pentagonal num..
		
		Problem p = new Problem61();
		p.runProblem();
	}

	public String problem() {
		allFirstAndLastIndexes = getFirstAndLastIndexes();
		allPolygonalNumbers = getAll4DigitPolygonalNumbers();
		track = getEmptyTracking();
		//start finding triangle numbers that are 4 digits....
		// as we get one... we get the last 2 digits and use those as the first 2 digits for a second number
		// we then go through all 100 other 4 digit numbers that start with those first 2 digits, checking along the way if they are sqaure, pentagonal, hexagonal, heptagonal, or octagonal
		// if we find one of the above.. we then use the last 2 digits of that number to go through the other 100 possible nums and check if they are other polygonal numbers, 
		//until we find one that goes all the way through all polygonal (triangle through octogonal)
		// and make sure the last one is cyclic with the first one...
		
		
		
		
		for(int i=startPoly; i<=endPoly; i++) {
			Integer[] fl = allFirstAndLastIndexes.get(i);
			
			int f = Util.getAPolygonalNumber(i, fl[0]);
			int l = Util.getAPolygonalNumber(i, fl[1]);
			System.out.println("First and last index for " + i + " :: " + fl[0] + ", " + fl[1] + " and those nums are " + f + ", " + l);			
		}
		
		
		
		// start the circle here with a triangle number. Technically can start with any polygonal type, penta / hexa /septa etc...
				// in the end it will all be a circle so doesnt really matter which you start with, just picked triangle..
		// you can start with any other polygon to get the same result ( square = 4, penta = 5, hexa = 6, septa = 7, octa = 8)
		//int startingPolygonalNumType = 6; -- this will start the search with hexagonal for example, doesnt matter any will work since its a circle anyway
		int startingPolygonalNumType = 3;
		
		List<Integer> polygonalNums = allPolygonalNumbers.get(startingPolygonalNumType);
		
		for(Integer num : polygonalNums) {
			// go through each number from whatever starting polygonal type was chosen above, one has to be part of a useable circle... try em all and at least one will work
			
			List<Integer> numsSoFar = new ArrayList<Integer>();
			track.put(startingPolygonalNumType, true); // this doesnt put duplicate entries right? Like 3, true - we cant put another 3, true right?
			numsSoFar.add(num);
			
			// start the recursive check...Put a num in the list, then recursion will go through all other polygonal nums and see if a combination makes a circle
			int res = findPolyNumThatStartsWith(num, numsSoFar);
			if(res > 0)
				return "" + res;
		}
		
		return null;
		
	}
	
	public static int /*List<Integer>*/ findPolyNumThatStartsWith(int num, List<Integer> polyNumsSoFar) {
		
		//the track object is just a boolean for each polygonal type
		// 5 = false (for example) means we have not used a pentagonal number in this circle yet so its up for grabs to try in the circle somewhere
		// 
		if(!track.containsValue(false)) {
			//all are found....
			if(polyNumsSoFar.size() == totalPolyCount) {
				
				if(Util.getLast2DigitsInt(polyNumsSoFar.get(totalPolyCount-1)) == Util.getFirst2DigitsInt(polyNumsSoFar.get(0))) {
					System.out.println("I think we have a winner !");
					
					int sum = 0;
					for(Integer p : polyNumsSoFar) {
						sum += p;
						System.out.println("winning num: " + p);
					}
					System.out.println("winning SUM: " + sum);
					return sum; //polyNumsSoFar;
				}
			} 
		}
		
		
		for(int i=startPoly; i<=endPoly; i++) {
			
			if(track.get(i)) {
				continue;
			}
			
			List<Integer> polyNums = allPolygonalNumbers.get(i);
			
			track.put(i, true); // once we use a polygonal type, set this to true for that polygon so the rest of the recursion will use other types. since we only are going to use 1 of each type in the circle
			for(Integer polyNum : polyNums) {
				if(Util.getLast2DigitsInt(num) == Util.getFirst2DigitsInt(polyNum)) {
					List<Integer> copyOfPn = Util.copyIntegerList(polyNumsSoFar);
					copyOfPn.add(polyNum);
					int possibleSum = findPolyNumThatStartsWith(polyNum, copyOfPn);
					if(possibleSum > 0){
						return possibleSum;
					}
				}
			}
			track.put(i, false); 
		}
		
		return 0; 
		
	}

	
	public static Map<Integer, Boolean> getEmptyTracking() {
		Map<Integer, Boolean> ret = new HashMap<Integer, Boolean>();
		for(int i=startPoly; i<=endPoly; i++) {
			ret.put(i, false);
		}
		return ret;
	}

	
	
	public static Map<Integer, List<Integer>>getAll4DigitPolygonalNumbers(){
		
		Map<Integer, List<Integer>> all = new HashMap<Integer, List<Integer>>();
		
		for(int i=startPoly; i<=endPoly; i++) {
			List<Integer> nums = new ArrayList<Integer>();
			
			Integer[] indexes = allFirstAndLastIndexes.get(i);
			int firstIndex = indexes[0];
			int lastIndex = indexes[1];
			for(int j=firstIndex; j<=lastIndex; j++) {
				nums.add(Util.getAPolygonalNumber(i,j));
			}
			all.put(i, nums);
		}

		return all;
	}

	public static Map<Integer, Integer[]> getFirstAndLastIndexes() {
		Map<Integer, Integer[]> n = new HashMap<Integer, Integer[]>();
		int pNum = 0;
		for(int i=startPoly; i<=endPoly; i++) {
			
			pNum = 0;
			int firstIndex = 0;
			while (!Util.isThisManyDigits(pNum, 4)) {
				firstIndex++;
				pNum = Util.getAPolygonalNumber(i, firstIndex);
			}
			
			pNum = 0;
			int lastIndex = 0;
			while (!Util.isThisManyDigits(pNum, 5)) {
				lastIndex++;
				pNum = Util.getAPolygonalNumber(i, lastIndex);
			}
			lastIndex--;
			
			n.put(i, new Integer[] { firstIndex, lastIndex });
		}
		
		return n;

	}
	

	
}