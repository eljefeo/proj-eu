import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

	public String problem(){
		int maxPerimeter = 1500000;
		//jJustMaxed is to help us save time. if i and j are 1,8 (for example) and this combo produces a triple that adds up over the max
		// then we skip it, obviously. But.. if the next iteration of 2,3 aallllso goes above the max, then we know already there is no point
		//of continuing the program, all triples from here on out will be above the max.
		//we do this check because sometimes 1,8 will be above the max, but next iteration of 2,3 will not, so we do 2,3 and 2,5 and 2,7 etc.
		//until we go above the max again.... saves a lot of processing
		boolean jJustMaxed = false;
		int i = 0;
		int j = 0;
		int[] sums = new int[maxPerimeter + 1];
		while(true) {
			i++;
			j = i;
			while (true) {
				j++;
				
				// skip this i and j if both are odd or both are even (we seem to always get a multiple of a previous trip when both i and j are odd or both are even
				if((i%2 == 0) == (j%2 == 0)) 
					continue;
				
				int i2 = i*i;
				int j2 = j*j;
				int a = j2-i2;
				int b = 2*i*j; 
				int c = j2+i2;
				int sum = a + b + c;

				if(sum > maxPerimeter) {
					if(jJustMaxed) {
						int cc = 0;
						for(int k : sums)
							if(k == 1)
								cc++;
						return "" + cc;
					}
					jJustMaxed = true;
					break;
				} else {
					jJustMaxed = false; 
				}
				
				if(Util.gcd(a, b) == 1) {
					int nSum = sum;
					while(maxPerimeter > nSum) {
						sums[nSum]++;
						nSum += sum;
					}
				} 
			}
		}
	}
}
