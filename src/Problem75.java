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
		Problem p = new Problem75();
		p.runProblem();
		
		
		
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
		
		List<Integer[]> tr = getPythagoreanTriplesFromThisA(22);
		
		for(Integer[] ii : tr) {
			System.out.println("trip: " + ii[0] + "," + ii[1] + "," + ii[2] );
		}
		
		//testAs();
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
		 primes you will only have 1 triple where a = that prime
		 
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

public void testAs() {
	
	int max = 100000;
	
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

public void printLotsOfTriples() {
	int min = 3, max = 40;
	//String ans = getPythagoreanTripleFromThisA(19);
	for(int i = min; i <= max; i++) {
		int[] ans = getPythagoreanTripleFromThisA(i);
		if(ans != null)
			System.out.println(ans[0] + ", " + ans[1]+ ", " + ans[2]);
	}
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
	
public List<Integer[]> getPythagoreanTriplesFromThisA(int a) {
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

}
