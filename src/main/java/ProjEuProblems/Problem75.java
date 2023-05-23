package ProjEuProblems;
import ProjEuUtil.Util;


public class Problem75 implements Problem{ //Took 0.013769 seconds
	
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
		
		
		Problem p = new Problem75();
		p.runProblem();
	}
	
	//for some reason if we return a String instead of object it actually seems to be a teeny bit faster lol. Objects are heavier than Strings?
	public Object problem(){ 
		int maxPerimeter = 1500000;
		//jJustMaxed is to help us save time. if i and j are 1,8 (for example) and this combo produces a triple who's sum is over the max
		// then we skip it, obviously because we need to stay below the limit. But.. if the next iteration of 2,3 aallllso goes above the max, 
		// then we know we have hit the end of the problem, all triples from here on out will also be above the max.
		// we do this check because sometimes 1,8 will be above the max, but next iteration of 2,3 will not, so we do 2,3 and 2,5 and 2,7 etc.
		// until we go above the max again.... saves a lot of processing
		boolean jJustMaxed = false;
		int i = 0, j = 0;
		int i2, j2, a , b, c, sum;
		int[] sums = new int[maxPerimeter + 1];
		while(true) {
			i++;
			j = i;
			while (true) {
				j++;
				
				// skip this i and j if both are odd or both are even 
				//(we seem to always get a multiple of a previous trip when both i and j are odd or both are even
				//so if both are odd or both are even, we just skip it altogether and go to the next one
				if((i%2 == 0) == (j%2 == 0)) 
					continue;
				
				//a^2 + b^2 = c^2 :: these variables below are just finding those a, b, and c using our fancy formula we figured out.
				// we figured out if you just take 2 nums, like 1 and 2 and put them through those little operations below in a, b, and c
				// you will get triples out. like 3,4,5. Or 5,12,13. So i and j are just us doing all combos of 2 nums to find all the triples we need
				i2 = i*i;
				j2 = j*j;
				a = j2-i2;
				b = 2*i*j; 
				c = j2+i2;
				sum = a + b + c;

				if(sum > maxPerimeter) {
					if(jJustMaxed) { 
						// if we get here, this is the end 
						// we will now count up all the sums that only showed up once and return that count
						int cc = 0;
						for(int k : sums)
							if(k == 1) 
								// this just means, if this sum (like the triple 3,4,5 the sum is 12)
								// if this sum only showed up 1 time, then that is what we want and we count that.
								// some sums showed up more than once, so we dont want those, only the ones where k == 1
								cc++;
						
						return cc; //return the number of unique sums under 1,500,000
					}
					jJustMaxed = true;
					break;
				} else {
					jJustMaxed = false; 
				}
				
				if(Util.gcd(a, b) == 1) {
					// get the greatest common denominator of a and b. This is to check if they have any factors in common.
					// if they do, then we dont even need to check if a or b have any factors in common with c. For a fully reduced triple there will be
					// no factors in common for a, b, or c. If a and b do have a factor in common, then a, b, and c will have that factor in common in which case
					// we also dont need to continue since we only want reduced triples.
					int nSum = sum;
					while(maxPerimeter > nSum) {
						//This is where we count up all the multiples of this triple. Like 3,4,5 we want to also now count 6,8,10 and 9,12,15 etc..
						//so if we have the sum of 12 (3,4,5) then 6,8,10 is just 12 + another 12 which is nSum+=sum (sum=12). keep adding the 3,4,5=12
						sums[nSum]++;
						nSum += sum;
					}
				} 
			}
		}
	}
}
