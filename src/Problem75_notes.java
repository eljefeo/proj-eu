
public class Problem75_notes {

}

/*
 * Uploding some old notes from a while back
 * a^2 + b^2 = c^2
 * 
 * so a^2 = c^2 - b^2
 *    b^2 = c^2 - a^2
 *    c^2 = a^2 + b^2
 *    
 *    so a is the diff of 2 squares
 *    b is also the diff of 2 squres
 *    and c is the sum of 2 squares
 *    
 *    I think we found some interesting things if we mess around with this
 *    
 *    lets take 3,4,5
 *    a is 3
 *    so what are the 2 squares, if 3 is the difference of 2 squares
 *    well 4 and 1 = 3
 *    
 *    and 4 is also the diff of 2 squares so what squares are those? I guess 
 *    
 *    what if we start looking at the differences of squares and the sum of squares
 *    so what are the first 2 squares
 *    1,4
 *    diff of those is 3, sum of those is 5
 *    
 *    what about 1, 9
 *    diff is 8, sum is 10
 *    
 *    
 *    what about 4,9
 *    diff is 5, sum is 13
 *    
 *    
 *    what about 4, 16
 *    diff is 12, sum is 20
 *    
 *    So this is getting kinda interesting...
 *    
 *    3...5
 *    8...10
 *    5...13
 *    12...20
 *    
 *    those all look kinda familiar... they look like they show up in some of the triples dont they?
 *    3,4,5 == 3..5
 *    maybe 6,8,10 for 8...10?
 *    maybe 5,12,13 for 5...13
 		12,15,20 for 12...20?
 		
 		what the hell? I was just looking at factoring the difference of squares because I remember that was 
 			a thing in highschool but I dont remember anything about it or how to do it, 
 			so I figured Ill just start randomly throwing out difference of squares and sum of squares and
 			every single one looks like it has something to do with triples?
 			IS there something fundamental about pythagorean triples and diff and sum of squres?
 			Well I guess duh yea there is obviously, that is the literal pythagorean forumla, diff and sum of squares so 
 				of course they are going to show up in there...
 				
 				so weird. but so awesome
 				
 		ok so now what... We know if we do diff and sum of squares we get some of the pyth triples.. but we dont get all numbers
 		like sometimes it gives us a and c, and sometimes it gives us b and c? is that how it looks?
 		
 		So what does this mean,  we just do all the diff and sum of squares, can we get all triples though?
 			We have been able to find other triples already with other methods, but it didnt find all. Lets test 
 			if we can find all triples with this method...
 		
 		lets write a little function to just spit out a bunch of diffs and sums of squares:
 		...ok done, here are a bunch of diff and sums of squares:
 		i: 1 j: 2 ::: Diff: 3 sum: 5
i: 1 j: 3 ::: Diff: 8 sum: 10
i: 1 j: 4 ::: Diff: 15 sum: 17
i: 1 j: 5 ::: Diff: 24 sum: 26
i: 1 j: 6 ::: Diff: 35 sum: 37
i: 1 j: 7 ::: Diff: 48 sum: 50
i: 1 j: 8 ::: Diff: 63 sum: 65
i: 1 j: 9 ::: Diff: 80 sum: 82
i: 2 j: 3 ::: Diff: 5 sum: 13
i: 2 j: 4 ::: Diff: 12 sum: 20
i: 2 j: 5 ::: Diff: 21 sum: 29
i: 2 j: 6 ::: Diff: 32 sum: 40
i: 2 j: 7 ::: Diff: 45 sum: 53
i: 2 j: 8 ::: Diff: 60 sum: 68
i: 2 j: 9 ::: Diff: 77 sum: 85
i: 3 j: 4 ::: Diff: 7 sum: 25
i: 3 j: 5 ::: Diff: 16 sum: 34
i: 3 j: 6 ::: Diff: 27 sum: 45
i: 3 j: 7 ::: Diff: 40 sum: 58
i: 3 j: 8 ::: Diff: 55 sum: 73
i: 3 j: 9 ::: Diff: 72 sum: 90
i: 4 j: 5 ::: Diff: 9 sum: 41
i: 4 j: 6 ::: Diff: 20 sum: 52
i: 4 j: 7 ::: Diff: 33 sum: 65
i: 4 j: 8 ::: Diff: 48 sum: 80
i: 4 j: 9 ::: Diff: 65 sum: 97
i: 5 j: 6 ::: Diff: 11 sum: 61
i: 5 j: 7 ::: Diff: 24 sum: 74
i: 5 j: 8 ::: Diff: 39 sum: 89
i: 5 j: 9 ::: Diff: 56 sum: 106
i: 6 j: 7 ::: Diff: 13 sum: 85
i: 6 j: 8 ::: Diff: 28 sum: 100
i: 6 j: 9 ::: Diff: 45 sum: 117
i: 7 j: 8 ::: Diff: 15 sum: 113
i: 7 j: 9 ::: Diff: 32 sum: 130
i: 8 j: 9 ::: Diff: 17 sum: 145
 
 ok so now what... we can first use our shitty code to get a big list of pyth triples and then maybe do these diffs and sums 
 and see if we can find corresponding triples I guess?
 
 ok lets try it.. writing some code now...
 ok done with some code... here are some comparisons of diffs and sums of squares against actual lists of trips that we just generated:
 (I went up to 40 I think with the diffs and sums and max for value of 'a' for the trips):
 Found a match... dif: 3 sum: 5 orig2: 1,2 -- matching trip: 3,4,5
Found a match... dif: 5 sum: 13 orig2: 2,3 -- matching trip: 5,12,13
Found a match... dif: 8 sum: 10 orig2: 1,3 -- matching trip: 6,8,10
Found a match... dif: 7 sum: 25 orig2: 3,4 -- matching trip: 7,24,25
Found a match... dif: 15 sum: 17 orig2: 1,4 -- matching trip: 8,15,17
Could not find match for trip: 9,12,15
Found a match... dif: 9 sum: 41 orig2: 4,5 -- matching trip: 9,40,41
Found a match... dif: 24 sum: 26 orig2: 1,5 -- matching trip: 10,24,26
Found a match... dif: 11 sum: 61 orig2: 5,6 -- matching trip: 11,60,61
Found a match... dif: 12 sum: 20 orig2: 2,4 -- matching trip: 12,16,20
Found a match... dif: 35 sum: 37 orig2: 1,6 -- matching trip: 12,35,37
Found a match... dif: 13 sum: 85 orig2: 6,7 -- matching trip: 13,84,85
Found a match... dif: 48 sum: 50 orig2: 1,7 -- matching trip: 14,48,50
Could not find match for trip: 15,20,25
Could not find match for trip: 15,36,39
Found a match... dif: 15 sum: 113 orig2: 7,8 -- matching trip: 15,112,113
Found a match... dif: 16 sum: 34 orig2: 3,5 -- matching trip: 16,30,34
Found a match... dif: 63 sum: 65 orig2: 1,8 -- matching trip: 16,63,65
Could not find match for trip: 17,144,145
Could not find match for trip: 18,24,30
Found a match... dif: 80 sum: 82 orig2: 1,9 -- matching trip: 18,80,82
Could not find match for trip: 19,180,181
Found a match... dif: 21 sum: 29 orig2: 2,5 -- matching trip: 20,21,29
Found a match... dif: 20 sum: 52 orig2: 4,6 -- matching trip: 20,48,52
Found a match... dif: 99 sum: 101 orig2: 1,10 -- matching trip: 20,99,101
Could not find match for trip: 21,28,35
Could not find match for trip: 21,72,75
Could not find match for trip: 21,220,221
Found a match... dif: 120 sum: 122 orig2: 1,11 -- matching trip: 22,120,122
Could not find match for trip: 23,264,265
Found a match... dif: 32 sum: 40 orig2: 2,6 -- matching trip: 24,32,40
Could not find match for trip: 24,45,51
Found a match... dif: 24 sum: 74 orig2: 5,7 -- matching trip: 24,70,74
Could not find match for trip: 24,143,145
Could not find match for trip: 25,60,65
Could not find match for trip: 25,312,313
Could not find match for trip: 26,168,170
Found a match... dif: 27 sum: 45 orig2: 3,6 -- matching trip: 27,36,45
Could not find match for trip: 27,120,123
Could not find match for trip: 27,364,365
Found a match... dif: 45 sum: 53 orig2: 2,7 -- matching trip: 28,45,53
Found a match... dif: 28 sum: 100 orig2: 6,8 -- matching trip: 28,96,100
Could not find match for trip: 28,195,197
Could not find match for trip: 29,420,421
Could not find match for trip: 30,40,50
Could not find match for trip: 30,72,78
Could not find match for trip: 30,224,226
Could not find match for trip: 31,480,481
Found a match... dif: 60 sum: 68 orig2: 2,8 -- matching trip: 32,60,68
Could not find match for trip: 32,126,130
Could not find match for trip: 32,255,257
Could not find match for trip: 33,44,55
Found a match... dif: 33 sum: 65 orig2: 4,7 -- matching trip: 33,56,65
Could not find match for trip: 33,180,183
Could not find match for trip: 33,544,545
Could not find match for trip: 34,288,290
Could not find match for trip: 35,84,91
Could not find match for trip: 35,120,125
Could not find match for trip: 35,612,613
Could not find match for trip: 36,48,60
Found a match... dif: 77 sum: 85 orig2: 2,9 -- matching trip: 36,77,85
Could not find match for trip: 36,105,111
Could not find match for trip: 36,160,164
Could not find match for trip: 36,323,325
Could not find match for trip: 37,684,685
Could not find match for trip: 38,360,362
Could not find match for trip: 39,52,65
Found a match... dif: 39 sum: 89 orig2: 5,8 -- matching trip: 39,80,89
Could not find match for trip: 39,252,255
Could not find match for trip: 39,760,761
Found a match... dif: 40 sum: 58 orig2: 3,7 -- matching trip: 40,42,58
Could not find match for trip: 40,75,85
Found a match... dif: 96 sum: 104 orig2: 2,10 -- matching trip: 40,96,104
Could not find match for trip: 40,198,202
Could not find match for trip: 40,399,401
 
 
 
 *
 */  


/*.
 * 
 09/22/22
 Just some interesting notes before I forget:
 Obviously pyth triples are focused around the factors of the numbers, in our case starting with factors of 'a'
 
 so for ood numbers:
 
 
  -------
Here is 9 for example:
 
triple:	9	12	15
sq:	81	144	225
odd:	17	23	29
odds between b and c: 25 27 29 
diff:	b-a: 3	c-a: 6	c-b: 3
diff2:	b2-a2: 63	c2-a2: 144	c2-b2: 81
facts a: 3 3 
facts b: 2 2 3 
facts c: 3 5 

triple:	9	40	41
sq:	81	1600	1681
odd:	17	79	81
odds between b and c: 81 
diff:	b-a: 31	c-a: 32	c-b: 1
diff2:	b2-a2: 1519	c2-a2: 1600	c2-b2: 81
facts a: 3 3 
facts b: 2 2 2 5 
facts c: 41 

the factors of 9 are 3,3

if we go to the top predictable triple for 9, which the formula again is 
9^2 / 2 === 81/2 = 40.5
You can think of this as using the factor of 1 from 9 (which all nums technically have 1 as a factor)
9,40,41

b and c are 1 away, hence factor 1

but we can divide out the factors of 9 from the middle of b and c

middle of 40 and 41 is 40.5
divide out the factor of 3

40.5 / 3 = 13.5
Now this means 13.5 is 3 away from b and c
so b and c must be 12 and 15, so 9 12 15 is another triple

keep dividing out the factors of A from the middle of the first triple and you will get 
the rest of the triples. This includes the combinations of the factors...By that we mean look at the 
next example using 45:

-----
-----
here for 45:
Same rules as above, lets start with with first top triple
45 ^ 2 / 2 = 1,012.5
45, 1012, 1013
now 1012.5 / factors of 45 (3,3,5)
1012.5 / 3 = 337.5 this means 337.5 is in the middle of b and c and they are 3 away
so 45, 336, 339

then 1012.5 / 5 = 202.5 this means 202.5 is the middle of b and c and they are 5 away
so 45, 200, 205

then 1012.5 / 15 (THE COMBINATION OF THE FACTORS 3 AND 5)
1012.5 / 15 = 67.5 this means 67.5 is middle of b and c and they are 15 away
so 45, 60, 75


Now  you must remember to keep dividing out the factors until we go below the original A
by that I mean although there are Two 3s as a factor in 45, dont just stop diving out 3 twice
1012.5 / 3 = 337.5
then do it again 337.5 / 3 = 112.5 this means since we divided 3 twice, b and c are 3*3 (9) away
so 112.5 is mid of b and c and they are 9 away
so 45, 108, 117

We were able to divide 3 out twice, if you divide 3 again you go below the original A = 45

Dont think we just divided 3 twice because there were two 3s as factors. THERE ARE OTHER NUMBERS
LIKE A=39 WHERE THERE IS ONLY ONE FACTOR OF 3, BUT YOU STILL DIVIDE 3 TWICE.
Keep going until you go below A
^In other words, divide all the factors, not just the prime factors. Since 9 is a factor, divide out 9



triple:	45	60	75
sq:	2025	3600	5625
odd:	89	119	149
odds between b and c: 121 123 125 127 129 131 133 135 137 139 141 143 145 147 149 
diff:	b-a: 15	c-a: 30	c-b: 15
diff2:	b2-a2: 1575	c2-a2: 3600	c2-b2: 2025
facts a: 3 3 5 
facts b: 2 2 3 5 
facts c: 3 5 5 

triple:	45	108	117
sq:	2025	11664	13689
odd:	89	215	233
odds between b and c: 217 219 221 223 225 227 229 231 233 
diff:	b-a: 63	c-a: 72	c-b: 9
diff2:	b2-a2: 9639	c2-a2: 11664	c2-b2: 2025
facts a: 3 3 5 
facts b: 2 2 3 3 3 
facts c: 3 3 13 

triple:	45	200	205
sq:	2025	40000	42025
odd:	89	399	409
odds between b and c: 401 403 405 407 409 
diff:	b-a: 155	c-a: 160	c-b: 5
diff2:	b2-a2: 37975	c2-a2: 40000	c2-b2: 2025
facts a: 3 3 5 
facts b: 2 2 2 5 5 
facts c: 5 41 

triple:	45	336	339
sq:	2025	112896	114921
odd:	89	671	677
odds between b and c: 673 675 677 
diff:	b-a: 291	c-a: 294	c-b: 3
diff2:	b2-a2: 110871	c2-a2: 112896	c2-b2: 2025
facts a: 3 3 5 
facts b: 2 2 2 2 3 7 
facts c: 3 113 

triple:	45	1012	1013
sq:	2025	1024144	1026169
odd:	89	2023	2025
odds between b and c: 2025 
diff:	b-a: 967	c-a: 968	c-b: 1
diff2:	b2-a2: 1022119	c2-a2: 1024144	c2-b2: 2025
facts a: 3 3 5 
facts b: 2 2 11 23 
facts c: 1013 


The problem is as go higher for A, and A has more and more factors.. 
finding them all this way will get harder and harder as we will have more factors combinations to try
to divide out.. 
Once we get closer to understanding maybe there is a way we can build them all from the ground up
I mean we might still be able to find all the 'prime' triples (triples that dont have common factor 
between the 3 numbers) like 20,21,29 - these are a unique, non-reducible prime
we know how to the find the prime triples for evens and odds, but only when b and c are 1 away
if we can find a way to find these other unique 'prime' triples then we can just 
do all the multiples of these triples to get the rest of all the possible triples..

like we do 3,4,5 (then do all multiples 6,8,10 ; 9,12,15 ; 12,16,20 etc...
then do 5,12,13 (then all multiples)
then 6,8,10 is already a multiple so I guess that doesnt count
but then 7,24,25
then 8, 15, 17
....
then 20,21,29  +++++ we just dont know how to get this one magically... if we did we 
	could do all the multiples and continue on our way..


Ok thats all I got for now.

-----

 
 */


/*
triple:	3	4	5
sq:	9	16	25
odd:	5	7	9
odds between b and c: 9 
diff:	b-a: 1	c-a: 2	c-b: 1
diff2:	b2-a2: 7	c2-a2: 16	c2-b2: 9
facts a: 3 
facts b: 2 2 
facts c: 5 

triple:	5	12	13
sq:	25	144	169
odd:	9	23	25
odds between b and c: 25 
diff:	b-a: 7	c-a: 8	c-b: 1
diff2:	b2-a2: 119	c2-a2: 144	c2-b2: 25
facts a: 5 
facts b: 2 2 3 
facts c: 13 

triple:	6	8	10
sq:	36	64	100
odd:	11	15	19
odds between b and c: 17 19 
diff:	b-a: 2	c-a: 4	c-b: 2
diff2:	b2-a2: 28	c2-a2: 64	c2-b2: 36
facts a: 2 3 
facts b: 2 2 2 
facts c: 2 5 

triple:	7	24	25
sq:	49	576	625
odd:	13	47	49
odds between b and c: 49 
diff:	b-a: 17	c-a: 18	c-b: 1
diff2:	b2-a2: 527	c2-a2: 576	c2-b2: 49
facts a: 7 
facts b: 2 2 2 3 
facts c: 5 5 

triple:	8	15	17
sq:	64	225	289
odd:	15	29	33
odds between b and c: 31 33 
diff:	b-a: 7	c-a: 9	c-b: 2
diff2:	b2-a2: 161	c2-a2: 225	c2-b2: 64
facts a: 2 2 2 
facts b: 3 5 
facts c: 17 

triple:	9	12	15
sq:	81	144	225
odd:	17	23	29
odds between b and c: 25 27 29 
diff:	b-a: 3	c-a: 6	c-b: 3
diff2:	b2-a2: 63	c2-a2: 144	c2-b2: 81
facts a: 3 3 
facts b: 2 2 3 
facts c: 3 5 

triple:	9	40	41
sq:	81	1600	1681
odd:	17	79	81
odds between b and c: 81 
diff:	b-a: 31	c-a: 32	c-b: 1
diff2:	b2-a2: 1519	c2-a2: 1600	c2-b2: 81
facts a: 3 3 
facts b: 2 2 2 5 
facts c: 41 

triple:	10	24	26
sq:	100	576	676
odd:	19	47	51
odds between b and c: 49 51 
diff:	b-a: 14	c-a: 16	c-b: 2
diff2:	b2-a2: 476	c2-a2: 576	c2-b2: 100
facts a: 2 5 
facts b: 2 2 2 3 
facts c: 2 13 

triple:	11	60	61
sq:	121	3600	3721
odd:	21	119	121
odds between b and c: 121 
diff:	b-a: 49	c-a: 50	c-b: 1
diff2:	b2-a2: 3479	c2-a2: 3600	c2-b2: 121
facts a: 11 
facts b: 2 2 3 5 
facts c: 61 

triple:	12	16	20
sq:	144	256	400
odd:	23	31	39
odds between b and c: 33 35 37 39 
diff:	b-a: 4	c-a: 8	c-b: 4
diff2:	b2-a2: 112	c2-a2: 256	c2-b2: 144
facts a: 2 2 3 
facts b: 2 2 2 2 
facts c: 2 2 5 

triple:	12	35	37
sq:	144	1225	1369
odd:	23	69	73
odds between b and c: 71 73 
diff:	b-a: 23	c-a: 25	c-b: 2
diff2:	b2-a2: 1081	c2-a2: 1225	c2-b2: 144
facts a: 2 2 3 
facts b: 5 7 
facts c: 37 

triple:	13	84	85
sq:	169	7056	7225
odd:	25	167	169
odds between b and c: 169 
diff:	b-a: 71	c-a: 72	c-b: 1
diff2:	b2-a2: 6887	c2-a2: 7056	c2-b2: 169
facts a: 13 
facts b: 2 2 3 7 
facts c: 5 17 

triple:	14	48	50
sq:	196	2304	2500
odd:	27	95	99
odds between b and c: 97 99 
diff:	b-a: 34	c-a: 36	c-b: 2
diff2:	b2-a2: 2108	c2-a2: 2304	c2-b2: 196
facts a: 2 7 
facts b: 2 2 2 2 3 
facts c: 2 5 5 

triple:	15	20	25
sq:	225	400	625
odd:	29	39	49
odds between b and c: 41 43 45 47 49 
diff:	b-a: 5	c-a: 10	c-b: 5
diff2:	b2-a2: 175	c2-a2: 400	c2-b2: 225
facts a: 3 5 
facts b: 2 2 5 
facts c: 5 5 

triple:	15	36	39
sq:	225	1296	1521
odd:	29	71	77
odds between b and c: 73 75 77 
diff:	b-a: 21	c-a: 24	c-b: 3
diff2:	b2-a2: 1071	c2-a2: 1296	c2-b2: 225
facts a: 3 5 
facts b: 2 2 3 3 
facts c: 3 13 

triple:	15	112	113
sq:	225	12544	12769
odd:	29	223	225
odds between b and c: 225 
diff:	b-a: 97	c-a: 98	c-b: 1
diff2:	b2-a2: 12319	c2-a2: 12544	c2-b2: 225
facts a: 3 5 
facts b: 2 2 2 2 7 
facts c: 113 

triple:	16	30	34
sq:	256	900	1156
odd:	31	59	67
odds between b and c: 61 63 65 67 
diff:	b-a: 14	c-a: 18	c-b: 4
diff2:	b2-a2: 644	c2-a2: 900	c2-b2: 256
facts a: 2 2 2 2 
facts b: 2 3 5 
facts c: 2 17 

triple:	16	63	65
sq:	256	3969	4225
odd:	31	125	129
odds between b and c: 127 129 
diff:	b-a: 47	c-a: 49	c-b: 2
diff2:	b2-a2: 3713	c2-a2: 3969	c2-b2: 256
facts a: 2 2 2 2 
facts b: 3 3 7 
facts c: 5 13 

triple:	17	144	145
sq:	289	20736	21025
odd:	33	287	289
odds between b and c: 289 
diff:	b-a: 127	c-a: 128	c-b: 1
diff2:	b2-a2: 20447	c2-a2: 20736	c2-b2: 289
facts a: 17 
facts b: 2 2 2 2 3 3 
facts c: 5 29 

triple:	18	24	30
sq:	324	576	900
odd:	35	47	59
odds between b and c: 49 51 53 55 57 59 
diff:	b-a: 6	c-a: 12	c-b: 6
diff2:	b2-a2: 252	c2-a2: 576	c2-b2: 324
facts a: 2 3 3 
facts b: 2 2 2 3 
facts c: 2 3 5 

triple:	18	80	82
sq:	324	6400	6724
odd:	35	159	163
odds between b and c: 161 163 
diff:	b-a: 62	c-a: 64	c-b: 2
diff2:	b2-a2: 6076	c2-a2: 6400	c2-b2: 324
facts a: 2 3 3 
facts b: 2 2 2 2 5 
facts c: 2 41 

triple:	19	180	181
sq:	361	32400	32761
odd:	37	359	361
odds between b and c: 361 
diff:	b-a: 161	c-a: 162	c-b: 1
diff2:	b2-a2: 32039	c2-a2: 32400	c2-b2: 361
facts a: 19 
facts b: 2 2 3 3 5 
facts c: 181 

triple:	20	21	29
sq:	400	441	841
odd:	39	41	57
odds between b and c: 43 45 47 49 51 53 55 57 
diff:	b-a: 1	c-a: 9	c-b: 8
diff2:	b2-a2: 41	c2-a2: 441	c2-b2: 400
facts a: 2 2 5 
facts b: 3 7 
facts c: 29 

triple:	20	48	52
sq:	400	2304	2704
odd:	39	95	103
odds between b and c: 97 99 101 103 
diff:	b-a: 28	c-a: 32	c-b: 4
diff2:	b2-a2: 1904	c2-a2: 2304	c2-b2: 400
facts a: 2 2 5 
facts b: 2 2 2 2 3 
facts c: 2 2 13 

triple:	20	99	101
sq:	400	9801	10201
odd:	39	197	201
odds between b and c: 199 201 
diff:	b-a: 79	c-a: 81	c-b: 2
diff2:	b2-a2: 9401	c2-a2: 9801	c2-b2: 400
facts a: 2 2 5 
facts b: 3 3 11 
facts c: 101 

triple:	21	28	35
sq:	441	784	1225
odd:	41	55	69
odds between b and c: 57 59 61 63 65 67 69 
diff:	b-a: 7	c-a: 14	c-b: 7
diff2:	b2-a2: 343	c2-a2: 784	c2-b2: 441
facts a: 3 7 
facts b: 2 2 7 
facts c: 5 7 

triple:	21	72	75
sq:	441	5184	5625
odd:	41	143	149
odds between b and c: 145 147 149 
diff:	b-a: 51	c-a: 54	c-b: 3
diff2:	b2-a2: 4743	c2-a2: 5184	c2-b2: 441
facts a: 3 7 
facts b: 2 2 2 3 3 
facts c: 3 5 5 

triple:	21	220	221
sq:	441	48400	48841
odd:	41	439	441
odds between b and c: 441 
diff:	b-a: 199	c-a: 200	c-b: 1
diff2:	b2-a2: 47959	c2-a2: 48400	c2-b2: 441
facts a: 3 7 
facts b: 2 2 5 11 
facts c: 13 17 

triple:	22	120	122
sq:	484	14400	14884
odd:	43	239	243
odds between b and c: 241 243 
diff:	b-a: 98	c-a: 100	c-b: 2
diff2:	b2-a2: 13916	c2-a2: 14400	c2-b2: 484
facts a: 2 11 
facts b: 2 2 2 3 5 
facts c: 2 61 

triple:	23	264	265
sq:	529	69696	70225
odd:	45	527	529
odds between b and c: 529 
diff:	b-a: 241	c-a: 242	c-b: 1
diff2:	b2-a2: 69167	c2-a2: 69696	c2-b2: 529
facts a: 23 
facts b: 2 2 2 3 11 
facts c: 5 53 

triple:	24	32	40
sq:	576	1024	1600
odd:	47	63	79
odds between b and c: 65 67 69 71 73 75 77 79 
diff:	b-a: 8	c-a: 16	c-b: 8
diff2:	b2-a2: 448	c2-a2: 1024	c2-b2: 576
facts a: 2 2 2 3 
facts b: 2 2 2 2 2 
facts c: 2 2 2 5 

triple:	24	45	51
sq:	576	2025	2601
odd:	47	89	101
odds between b and c: 91 93 95 97 99 101 
diff:	b-a: 21	c-a: 27	c-b: 6
diff2:	b2-a2: 1449	c2-a2: 2025	c2-b2: 576
facts a: 2 2 2 3 
facts b: 3 3 5 
facts c: 3 17 

triple:	24	70	74
sq:	576	4900	5476
odd:	47	139	147
odds between b and c: 141 143 145 147 
diff:	b-a: 46	c-a: 50	c-b: 4
diff2:	b2-a2: 4324	c2-a2: 4900	c2-b2: 576
facts a: 2 2 2 3 
facts b: 2 5 7 
facts c: 2 37 

triple:	24	143	145
sq:	576	20449	21025
odd:	47	285	289
odds between b and c: 287 289 
diff:	b-a: 119	c-a: 121	c-b: 2
diff2:	b2-a2: 19873	c2-a2: 20449	c2-b2: 576
facts a: 2 2 2 3 
facts b: 11 13 
facts c: 5 29 

triple:	25	60	65
sq:	625	3600	4225
odd:	49	119	129
odds between b and c: 121 123 125 127 129 
diff:	b-a: 35	c-a: 40	c-b: 5
diff2:	b2-a2: 2975	c2-a2: 3600	c2-b2: 625
facts a: 5 5 
facts b: 2 2 3 5 
facts c: 5 13 

triple:	25	312	313
sq:	625	97344	97969
odd:	49	623	625
odds between b and c: 625 
diff:	b-a: 287	c-a: 288	c-b: 1
diff2:	b2-a2: 96719	c2-a2: 97344	c2-b2: 625
facts a: 5 5 
facts b: 2 2 2 3 13 
facts c: 313 

triple:	26	168	170
sq:	676	28224	28900
odd:	51	335	339
odds between b and c: 337 339 
diff:	b-a: 142	c-a: 144	c-b: 2
diff2:	b2-a2: 27548	c2-a2: 28224	c2-b2: 676
facts a: 2 13 
facts b: 2 2 2 3 7 
facts c: 2 5 17 

triple:	27	36	45
sq:	729	1296	2025
odd:	53	71	89
odds between b and c: 73 75 77 79 81 83 85 87 89 
diff:	b-a: 9	c-a: 18	c-b: 9
diff2:	b2-a2: 567	c2-a2: 1296	c2-b2: 729
facts a: 3 3 3 
facts b: 2 2 3 3 
facts c: 3 3 5 

triple:	27	120	123
sq:	729	14400	15129
odd:	53	239	245
odds between b and c: 241 243 245 
diff:	b-a: 93	c-a: 96	c-b: 3
diff2:	b2-a2: 13671	c2-a2: 14400	c2-b2: 729
facts a: 3 3 3 
facts b: 2 2 2 3 5 
facts c: 3 41 

triple:	27	364	365
sq:	729	132496	133225
odd:	53	727	729
odds between b and c: 729 
diff:	b-a: 337	c-a: 338	c-b: 1
diff2:	b2-a2: 131767	c2-a2: 132496	c2-b2: 729
facts a: 3 3 3 
facts b: 2 2 7 13 
facts c: 5 73 

triple:	28	45	53
sq:	784	2025	2809
odd:	55	89	105
odds between b and c: 91 93 95 97 99 101 103 105 
diff:	b-a: 17	c-a: 25	c-b: 8
diff2:	b2-a2: 1241	c2-a2: 2025	c2-b2: 784
facts a: 2 2 7 
facts b: 3 3 5 
facts c: 53 

triple:	28	96	100
sq:	784	9216	10000
odd:	55	191	199
odds between b and c: 193 195 197 199 
diff:	b-a: 68	c-a: 72	c-b: 4
diff2:	b2-a2: 8432	c2-a2: 9216	c2-b2: 784
facts a: 2 2 7 
facts b: 2 2 2 2 2 3 
facts c: 2 2 5 5 

triple:	28	195	197
sq:	784	38025	38809
odd:	55	389	393
odds between b and c: 391 393 
diff:	b-a: 167	c-a: 169	c-b: 2
diff2:	b2-a2: 37241	c2-a2: 38025	c2-b2: 784
facts a: 2 2 7 
facts b: 3 5 13 
facts c: 197 

triple:	29	420	421
sq:	841	176400	177241
odd:	57	839	841
odds between b and c: 841 
diff:	b-a: 391	c-a: 392	c-b: 1
diff2:	b2-a2: 175559	c2-a2: 176400	c2-b2: 841
facts a: 29 
facts b: 2 2 3 5 7 
facts c: 421 

triple:	30	40	50
sq:	900	1600	2500
odd:	59	79	99
odds between b and c: 81 83 85 87 89 91 93 95 97 99 
diff:	b-a: 10	c-a: 20	c-b: 10
diff2:	b2-a2: 700	c2-a2: 1600	c2-b2: 900
facts a: 2 3 5 
facts b: 2 2 2 5 
facts c: 2 5 5 

triple:	30	72	78
sq:	900	5184	6084
odd:	59	143	155
odds between b and c: 145 147 149 151 153 155 
diff:	b-a: 42	c-a: 48	c-b: 6
diff2:	b2-a2: 4284	c2-a2: 5184	c2-b2: 900
facts a: 2 3 5 
facts b: 2 2 2 3 3 
facts c: 2 3 13 

triple:	30	224	226
sq:	900	50176	51076
odd:	59	447	451
odds between b and c: 449 451 
diff:	b-a: 194	c-a: 196	c-b: 2
diff2:	b2-a2: 49276	c2-a2: 50176	c2-b2: 900
facts a: 2 3 5 
facts b: 2 2 2 2 2 7 
facts c: 2 113 

triple:	31	480	481
sq:	961	230400	231361
odd:	61	959	961
odds between b and c: 961 
diff:	b-a: 449	c-a: 450	c-b: 1
diff2:	b2-a2: 229439	c2-a2: 230400	c2-b2: 961
facts a: 31 
facts b: 2 2 2 2 2 3 5 
facts c: 13 37 

triple:	32	60	68
sq:	1024	3600	4624
odd:	63	119	135
odds between b and c: 121 123 125 127 129 131 133 135 
diff:	b-a: 28	c-a: 36	c-b: 8
diff2:	b2-a2: 2576	c2-a2: 3600	c2-b2: 1024
facts a: 2 2 2 2 2 
facts b: 2 2 3 5 
facts c: 2 2 17 

triple:	32	126	130
sq:	1024	15876	16900
odd:	63	251	259
odds between b and c: 253 255 257 259 
diff:	b-a: 94	c-a: 98	c-b: 4
diff2:	b2-a2: 14852	c2-a2: 15876	c2-b2: 1024
facts a: 2 2 2 2 2 
facts b: 2 3 3 7 
facts c: 2 5 13 

triple:	32	255	257
sq:	1024	65025	66049
odd:	63	509	513
odds between b and c: 511 513 
diff:	b-a: 223	c-a: 225	c-b: 2
diff2:	b2-a2: 64001	c2-a2: 65025	c2-b2: 1024
facts a: 2 2 2 2 2 
facts b: 3 5 17 
facts c: 257 

triple:	33	44	55
sq:	1089	1936	3025
odd:	65	87	109
odds between b and c: 89 91 93 95 97 99 101 103 105 107 109 
diff:	b-a: 11	c-a: 22	c-b: 11
diff2:	b2-a2: 847	c2-a2: 1936	c2-b2: 1089
facts a: 3 11 
facts b: 2 2 11 
facts c: 5 11 

triple:	33	56	65
sq:	1089	3136	4225
odd:	65	111	129
odds between b and c: 113 115 117 119 121 123 125 127 129 
diff:	b-a: 23	c-a: 32	c-b: 9
diff2:	b2-a2: 2047	c2-a2: 3136	c2-b2: 1089
facts a: 3 11 
facts b: 2 2 2 7 
facts c: 5 13 

triple:	33	180	183
sq:	1089	32400	33489
odd:	65	359	365
odds between b and c: 361 363 365 
diff:	b-a: 147	c-a: 150	c-b: 3
diff2:	b2-a2: 31311	c2-a2: 32400	c2-b2: 1089
facts a: 3 11 
facts b: 2 2 3 3 5 
facts c: 3 61 

triple:	33	544	545
sq:	1089	295936	297025
odd:	65	1087	1089
odds between b and c: 1089 
diff:	b-a: 511	c-a: 512	c-b: 1
diff2:	b2-a2: 294847	c2-a2: 295936	c2-b2: 1089
facts a: 3 11 
facts b: 2 2 2 2 2 17 
facts c: 5 109 

triple:	34	288	290
sq:	1156	82944	84100
odd:	67	575	579
odds between b and c: 577 579 
diff:	b-a: 254	c-a: 256	c-b: 2
diff2:	b2-a2: 81788	c2-a2: 82944	c2-b2: 1156
facts a: 2 17 
facts b: 2 2 2 2 2 3 3 
facts c: 2 5 29 

triple:	35	84	91
sq:	1225	7056	8281
odd:	69	167	181
odds between b and c: 169 171 173 175 177 179 181 
diff:	b-a: 49	c-a: 56	c-b: 7
diff2:	b2-a2: 5831	c2-a2: 7056	c2-b2: 1225
facts a: 5 7 
facts b: 2 2 3 7 
facts c: 7 13 

triple:	35	120	125
sq:	1225	14400	15625
odd:	69	239	249
odds between b and c: 241 243 245 247 249 
diff:	b-a: 85	c-a: 90	c-b: 5
diff2:	b2-a2: 13175	c2-a2: 14400	c2-b2: 1225
facts a: 5 7 
facts b: 2 2 2 3 5 
facts c: 5 5 5 

triple:	35	612	613
sq:	1225	374544	375769
odd:	69	1223	1225
odds between b and c: 1225 
diff:	b-a: 577	c-a: 578	c-b: 1
diff2:	b2-a2: 373319	c2-a2: 374544	c2-b2: 1225
facts a: 5 7 
facts b: 2 2 3 3 17 
facts c: 613 

triple:	36	48	60
sq:	1296	2304	3600
odd:	71	95	119
odds between b and c: 97 99 101 103 105 107 109 111 113 115 117 119 
diff:	b-a: 12	c-a: 24	c-b: 12
diff2:	b2-a2: 1008	c2-a2: 2304	c2-b2: 1296
facts a: 2 2 3 3 
facts b: 2 2 2 2 3 
facts c: 2 2 3 5 

triple:	36	77	85
sq:	1296	5929	7225
odd:	71	153	169
odds between b and c: 155 157 159 161 163 165 167 169 
diff:	b-a: 41	c-a: 49	c-b: 8
diff2:	b2-a2: 4633	c2-a2: 5929	c2-b2: 1296
facts a: 2 2 3 3 
facts b: 7 11 
facts c: 5 17 

triple:	36	105	111
sq:	1296	11025	12321
odd:	71	209	221
odds between b and c: 211 213 215 217 219 221 
diff:	b-a: 69	c-a: 75	c-b: 6
diff2:	b2-a2: 9729	c2-a2: 11025	c2-b2: 1296
facts a: 2 2 3 3 
facts b: 3 5 7 
facts c: 3 37 

triple:	36	160	164
sq:	1296	25600	26896
odd:	71	319	327
odds between b and c: 321 323 325 327 
diff:	b-a: 124	c-a: 128	c-b: 4
diff2:	b2-a2: 24304	c2-a2: 25600	c2-b2: 1296
facts a: 2 2 3 3 
facts b: 2 2 2 2 2 5 
facts c: 2 2 41 

triple:	36	323	325
sq:	1296	104329	105625
odd:	71	645	649
odds between b and c: 647 649 
diff:	b-a: 287	c-a: 289	c-b: 2
diff2:	b2-a2: 103033	c2-a2: 104329	c2-b2: 1296
facts a: 2 2 3 3 
facts b: 17 19 
facts c: 5 5 13 

triple:	37	684	685
sq:	1369	467856	469225
odd:	73	1367	1369
odds between b and c: 1369 
diff:	b-a: 647	c-a: 648	c-b: 1
diff2:	b2-a2: 466487	c2-a2: 467856	c2-b2: 1369
facts a: 37 
facts b: 2 2 3 3 19 
facts c: 5 137 

triple:	38	360	362
sq:	1444	129600	131044
odd:	75	719	723
odds between b and c: 721 723 
diff:	b-a: 322	c-a: 324	c-b: 2
diff2:	b2-a2: 128156	c2-a2: 129600	c2-b2: 1444
facts a: 2 19 
facts b: 2 2 2 3 3 5 
facts c: 2 181 

triple:	39	52	65
sq:	1521	2704	4225
odd:	77	103	129
odds between b and c: 105 107 109 111 113 115 117 119 121 123 125 127 129 
diff:	b-a: 13	c-a: 26	c-b: 13
diff2:	b2-a2: 1183	c2-a2: 2704	c2-b2: 1521
facts a: 3 13 
facts b: 2 2 13 
facts c: 5 13 

triple:	39	80	89
sq:	1521	6400	7921
odd:	77	159	177
odds between b and c: 161 163 165 167 169 171 173 175 177 
diff:	b-a: 41	c-a: 50	c-b: 9
diff2:	b2-a2: 4879	c2-a2: 6400	c2-b2: 1521
facts a: 3 13 
facts b: 2 2 2 2 5 
facts c: 89 

triple:	39	252	255
sq:	1521	63504	65025
odd:	77	503	509
odds between b and c: 505 507 509 
diff:	b-a: 213	c-a: 216	c-b: 3
diff2:	b2-a2: 61983	c2-a2: 63504	c2-b2: 1521
facts a: 3 13 
facts b: 2 2 3 3 7 
facts c: 3 5 17 

triple:	39	760	761
sq:	1521	577600	579121
odd:	77	1519	1521
odds between b and c: 1521 
diff:	b-a: 721	c-a: 722	c-b: 1
diff2:	b2-a2: 576079	c2-a2: 577600	c2-b2: 1521
facts a: 3 13 
facts b: 2 2 2 5 19 
facts c: 761 

triple:	40	42	58
sq:	1600	1764	3364
odd:	79	83	115
odds between b and c: 85 87 89 91 93 95 97 99 101 103 105 107 109 111 113 115 
diff:	b-a: 2	c-a: 18	c-b: 16
diff2:	b2-a2: 164	c2-a2: 1764	c2-b2: 1600
facts a: 2 2 2 5 
facts b: 2 3 7 
facts c: 2 29 

triple:	40	75	85
sq:	1600	5625	7225
odd:	79	149	169
odds between b and c: 151 153 155 157 159 161 163 165 167 169 
diff:	b-a: 35	c-a: 45	c-b: 10
diff2:	b2-a2: 4025	c2-a2: 5625	c2-b2: 1600
facts a: 2 2 2 5 
facts b: 3 5 5 
facts c: 5 17 

triple:	40	96	104
sq:	1600	9216	10816
odd:	79	191	207
odds between b and c: 193 195 197 199 201 203 205 207 
diff:	b-a: 56	c-a: 64	c-b: 8
diff2:	b2-a2: 7616	c2-a2: 9216	c2-b2: 1600
facts a: 2 2 2 5 
facts b: 2 2 2 2 2 3 
facts c: 2 2 2 13 

triple:	40	198	202
sq:	1600	39204	40804
odd:	79	395	403
odds between b and c: 397 399 401 403 
diff:	b-a: 158	c-a: 162	c-b: 4
diff2:	b2-a2: 37604	c2-a2: 39204	c2-b2: 1600
facts a: 2 2 2 5 
facts b: 2 3 3 11 
facts c: 2 101 

triple:	40	399	401
sq:	1600	159201	160801
odd:	79	797	801
odds between b and c: 799 801 
diff:	b-a: 359	c-a: 361	c-b: 2
diff2:	b2-a2: 157601	c2-a2: 159201	c2-b2: 1600
facts a: 2 2 2 5 
facts b: 3 7 19 
facts c: 401 

triple:	41	840	841
sq:	1681	705600	707281
odd:	81	1679	1681
odds between b and c: 1681 
diff:	b-a: 799	c-a: 800	c-b: 1
diff2:	b2-a2: 703919	c2-a2: 705600	c2-b2: 1681
facts a: 41 
facts b: 2 2 2 3 5 7 
facts c: 29 29 

triple:	42	56	70
sq:	1764	3136	4900
odd:	83	111	139
odds between b and c: 113 115 117 119 121 123 125 127 129 131 133 135 137 139 
diff:	b-a: 14	c-a: 28	c-b: 14
diff2:	b2-a2: 1372	c2-a2: 3136	c2-b2: 1764
facts a: 2 3 7 
facts b: 2 2 2 7 
facts c: 2 5 7 

triple:	42	144	150
sq:	1764	20736	22500
odd:	83	287	299
odds between b and c: 289 291 293 295 297 299 
diff:	b-a: 102	c-a: 108	c-b: 6
diff2:	b2-a2: 18972	c2-a2: 20736	c2-b2: 1764
facts a: 2 3 7 
facts b: 2 2 2 2 3 3 
facts c: 2 3 5 5 

triple:	42	440	442
sq:	1764	193600	195364
odd:	83	879	883
odds between b and c: 881 883 
diff:	b-a: 398	c-a: 400	c-b: 2
diff2:	b2-a2: 191836	c2-a2: 193600	c2-b2: 1764
facts a: 2 3 7 
facts b: 2 2 2 5 11 
facts c: 2 13 17 

triple:	43	924	925
sq:	1849	853776	855625
odd:	85	1847	1849
odds between b and c: 1849 
diff:	b-a: 881	c-a: 882	c-b: 1
diff2:	b2-a2: 851927	c2-a2: 853776	c2-b2: 1849
facts a: 43 
facts b: 2 2 3 7 11 
facts c: 5 5 37 

triple:	44	117	125
sq:	1936	13689	15625
odd:	87	233	249
odds between b and c: 235 237 239 241 243 245 247 249 
diff:	b-a: 73	c-a: 81	c-b: 8
diff2:	b2-a2: 11753	c2-a2: 13689	c2-b2: 1936
facts a: 2 2 11 
facts b: 3 3 13 
facts c: 5 5 5 

triple:	44	240	244
sq:	1936	57600	59536
odd:	87	479	487
odds between b and c: 481 483 485 487 
diff:	b-a: 196	c-a: 200	c-b: 4
diff2:	b2-a2: 55664	c2-a2: 57600	c2-b2: 1936
facts a: 2 2 11 
facts b: 2 2 2 2 3 5 
facts c: 2 2 61 

triple:	44	483	485
sq:	1936	233289	235225
odd:	87	965	969
odds between b and c: 967 969 
diff:	b-a: 439	c-a: 441	c-b: 2
diff2:	b2-a2: 231353	c2-a2: 233289	c2-b2: 1936
facts a: 2 2 11 
facts b: 3 7 23 
facts c: 5 97 

triple:	45	60	75
sq:	2025	3600	5625
odd:	89	119	149
odds between b and c: 121 123 125 127 129 131 133 135 137 139 141 143 145 147 149 
diff:	b-a: 15	c-a: 30	c-b: 15
diff2:	b2-a2: 1575	c2-a2: 3600	c2-b2: 2025
facts a: 3 3 5 
facts b: 2 2 3 5 
facts c: 3 5 5 

triple:	45	108	117
sq:	2025	11664	13689
odd:	89	215	233
odds between b and c: 217 219 221 223 225 227 229 231 233 
diff:	b-a: 63	c-a: 72	c-b: 9
diff2:	b2-a2: 9639	c2-a2: 11664	c2-b2: 2025
facts a: 3 3 5 
facts b: 2 2 3 3 3 
facts c: 3 3 13 

triple:	45	200	205
sq:	2025	40000	42025
odd:	89	399	409
odds between b and c: 401 403 405 407 409 
diff:	b-a: 155	c-a: 160	c-b: 5
diff2:	b2-a2: 37975	c2-a2: 40000	c2-b2: 2025
facts a: 3 3 5 
facts b: 2 2 2 5 5 
facts c: 5 41 

triple:	45	336	339
sq:	2025	112896	114921
odd:	89	671	677
odds between b and c: 673 675 677 
diff:	b-a: 291	c-a: 294	c-b: 3
diff2:	b2-a2: 110871	c2-a2: 112896	c2-b2: 2025
facts a: 3 3 5 
facts b: 2 2 2 2 3 7 
facts c: 3 113 

triple:	45	1012	1013
sq:	2025	1024144	1026169
odd:	89	2023	2025
odds between b and c: 2025 
diff:	b-a: 967	c-a: 968	c-b: 1
diff2:	b2-a2: 1022119	c2-a2: 1024144	c2-b2: 2025
facts a: 3 3 5 
facts b: 2 2 11 23 
facts c: 1013 

triple:	46	528	530
sq:	2116	278784	280900
odd:	91	1055	1059
odds between b and c: 1057 1059 
diff:	b-a: 482	c-a: 484	c-b: 2
diff2:	b2-a2: 276668	c2-a2: 278784	c2-b2: 2116
facts a: 2 23 
facts b: 2 2 2 2 3 11 
facts c: 2 5 53 

triple:	47	1104	1105
sq:	2209	1218816	1221025
odd:	93	2207	2209
odds between b and c: 2209 
diff:	b-a: 1057	c-a: 1058	c-b: 1
diff2:	b2-a2: 1216607	c2-a2: 1218816	c2-b2: 2209
facts a: 47 
facts b: 2 2 2 2 3 23 
facts c: 5 13 17 

triple:	48	55	73
sq:	2304	3025	5329
odd:	95	109	145
odds between b and c: 111 113 115 117 119 121 123 125 127 129 131 133 135 137 139 141 143 145 
diff:	b-a: 7	c-a: 25	c-b: 18
diff2:	b2-a2: 721	c2-a2: 3025	c2-b2: 2304
facts a: 2 2 2 2 3 
facts b: 5 11 
facts c: 73 

triple:	48	64	80
sq:	2304	4096	6400
odd:	95	127	159
odds between b and c: 129 131 133 135 137 139 141 143 145 147 149 151 153 155 157 159 
diff:	b-a: 16	c-a: 32	c-b: 16
diff2:	b2-a2: 1792	c2-a2: 4096	c2-b2: 2304
facts a: 2 2 2 2 3 
facts b: 2 2 2 2 2 2 
facts c: 2 2 2 2 5 

triple:	48	90	102
sq:	2304	8100	10404
odd:	95	179	203
odds between b and c: 181 183 185 187 189 191 193 195 197 199 201 203 
diff:	b-a: 42	c-a: 54	c-b: 12
diff2:	b2-a2: 5796	c2-a2: 8100	c2-b2: 2304
facts a: 2 2 2 2 3 
facts b: 2 3 3 5 
facts c: 2 3 17 

triple:	48	140	148
sq:	2304	19600	21904
odd:	95	279	295
odds between b and c: 281 283 285 287 289 291 293 295 
diff:	b-a: 92	c-a: 100	c-b: 8
diff2:	b2-a2: 17296	c2-a2: 19600	c2-b2: 2304
facts a: 2 2 2 2 3 
facts b: 2 2 5 7 
facts c: 2 2 37 

triple:	48	189	195
sq:	2304	35721	38025
odd:	95	377	389
odds between b and c: 379 381 383 385 387 389 
diff:	b-a: 141	c-a: 147	c-b: 6
diff2:	b2-a2: 33417	c2-a2: 35721	c2-b2: 2304
facts a: 2 2 2 2 3 
facts b: 3 3 3 7 
facts c: 3 5 13 

triple:	48	286	290
sq:	2304	81796	84100
odd:	95	571	579
odds between b and c: 573 575 577 579 
diff:	b-a: 238	c-a: 242	c-b: 4
diff2:	b2-a2: 79492	c2-a2: 81796	c2-b2: 2304
facts a: 2 2 2 2 3 
facts b: 2 11 13 
facts c: 2 5 29 

triple:	48	575	577
sq:	2304	330625	332929
odd:	95	1149	1153
odds between b and c: 1151 1153 
diff:	b-a: 527	c-a: 529	c-b: 2
diff2:	b2-a2: 328321	c2-a2: 330625	c2-b2: 2304
facts a: 2 2 2 2 3 
facts b: 5 5 23 
facts c: 577 

triple:	49	168	175
sq:	2401	28224	30625
odd:	97	335	349
odds between b and c: 337 339 341 343 345 347 349 
diff:	b-a: 119	c-a: 126	c-b: 7
diff2:	b2-a2: 25823	c2-a2: 28224	c2-b2: 2401
facts a: 7 7 
facts b: 2 2 2 3 7 
facts c: 5 5 7 

triple:	49	1200	1201
sq:	2401	1440000	1442401
odd:	97	2399	2401
odds between b and c: 2401 
diff:	b-a: 1151	c-a: 1152	c-b: 1
diff2:	b2-a2: 1437599	c2-a2: 1440000	c2-b2: 2401
facts a: 7 7 
facts b: 2 2 2 2 3 5 5 
facts c: 1201 

triple:	50	120	130
sq:	2500	14400	16900
odd:	99	239	259
odds between b and c: 241 243 245 247 249 251 253 255 257 259 
diff:	b-a: 70	c-a: 80	c-b: 10
diff2:	b2-a2: 11900	c2-a2: 14400	c2-b2: 2500
facts a: 2 5 5 
facts b: 2 2 2 3 5 
facts c: 2 5 13 

triple:	50	624	626
sq:	2500	389376	391876
odd:	99	1247	1251
odds between b and c: 1249 1251 
diff:	b-a: 574	c-a: 576	c-b: 2
diff2:	b2-a2: 386876	c2-a2: 389376	c2-b2: 2500
facts a: 2 5 5 
facts b: 2 2 2 2 3 13 
facts c: 2 313 

triple:	51	68	85
sq:	2601	4624	7225
odd:	101	135	169
odds between b and c: 137 139 141 143 145 147 149 151 153 155 157 159 161 163 165 167 169 
diff:	b-a: 17	c-a: 34	c-b: 17
diff2:	b2-a2: 2023	c2-a2: 4624	c2-b2: 2601
facts a: 3 17 
facts b: 2 2 17 
facts c: 5 17 

triple:	51	140	149
sq:	2601	19600	22201
odd:	101	279	297
odds between b and c: 281 283 285 287 289 291 293 295 297 
diff:	b-a: 89	c-a: 98	c-b: 9
diff2:	b2-a2: 16999	c2-a2: 19600	c2-b2: 2601
facts a: 3 17 
facts b: 2 2 5 7 
facts c: 149 

triple:	51	432	435
sq:	2601	186624	189225
odd:	101	863	869
odds between b and c: 865 867 869 
diff:	b-a: 381	c-a: 384	c-b: 3
diff2:	b2-a2: 184023	c2-a2: 186624	c2-b2: 2601
facts a: 3 17 
facts b: 2 2 2 2 3 3 3 
facts c: 3 5 29 

triple:	51	1300	1301
sq:	2601	1690000	1692601
odd:	101	2599	2601
odds between b and c: 2601 
diff:	b-a: 1249	c-a: 1250	c-b: 1
diff2:	b2-a2: 1687399	c2-a2: 1690000	c2-b2: 2601
facts a: 3 17 
facts b: 2 2 5 5 13 
facts c: 1301 

triple:	52	165	173
sq:	2704	27225	29929
odd:	103	329	345
odds between b and c: 331 333 335 337 339 341 343 345 
diff:	b-a: 113	c-a: 121	c-b: 8
diff2:	b2-a2: 24521	c2-a2: 27225	c2-b2: 2704
facts a: 2 2 13 
facts b: 3 5 11 
facts c: 173 

triple:	52	336	340
sq:	2704	112896	115600
odd:	103	671	679
odds between b and c: 673 675 677 679 
diff:	b-a: 284	c-a: 288	c-b: 4
diff2:	b2-a2: 110192	c2-a2: 112896	c2-b2: 2704
facts a: 2 2 13 
facts b: 2 2 2 2 3 7 
facts c: 2 2 5 17 

triple:	52	675	677
sq:	2704	455625	458329
odd:	103	1349	1353
odds between b and c: 1351 1353 
diff:	b-a: 623	c-a: 625	c-b: 2
diff2:	b2-a2: 452921	c2-a2: 455625	c2-b2: 2704
facts a: 2 2 13 
facts b: 3 3 3 5 5 
facts c: 677 

triple:	53	1404	1405
sq:	2809	1971216	1974025
odd:	105	2807	2809
odds between b and c: 2809 
diff:	b-a: 1351	c-a: 1352	c-b: 1
diff2:	b2-a2: 1968407	c2-a2: 1971216	c2-b2: 2809
facts a: 53 
facts b: 2 2 3 3 3 13 
facts c: 5 281 

triple:	54	72	90
sq:	2916	5184	8100
odd:	107	143	179
odds between b and c: 145 147 149 151 153 155 157 159 161 163 165 167 169 171 173 175 177 179 
diff:	b-a: 18	c-a: 36	c-b: 18
diff2:	b2-a2: 2268	c2-a2: 5184	c2-b2: 2916
facts a: 2 3 3 3 
facts b: 2 2 2 3 3 
facts c: 2 3 3 5 

triple:	54	240	246
sq:	2916	57600	60516
odd:	107	479	491
odds between b and c: 481 483 485 487 489 491 
diff:	b-a: 186	c-a: 192	c-b: 6
diff2:	b2-a2: 54684	c2-a2: 57600	c2-b2: 2916
facts a: 2 3 3 3 
facts b: 2 2 2 2 3 5 
facts c: 2 3 41 

triple:	54	728	730
sq:	2916	529984	532900
odd:	107	1455	1459
odds between b and c: 1457 1459 
diff:	b-a: 674	c-a: 676	c-b: 2
diff2:	b2-a2: 527068	c2-a2: 529984	c2-b2: 2916
facts a: 2 3 3 3 
facts b: 2 2 2 7 13 
facts c: 2 5 73 

triple:	55	132	143
sq:	3025	17424	20449
odd:	109	263	285
odds between b and c: 265 267 269 271 273 275 277 279 281 283 285 
diff:	b-a: 77	c-a: 88	c-b: 11
diff2:	b2-a2: 14399	c2-a2: 17424	c2-b2: 3025
facts a: 5 11 
facts b: 2 2 3 11 
facts c: 11 13 

triple:	55	300	305
sq:	3025	90000	93025
odd:	109	599	609
odds between b and c: 601 603 605 607 609 
diff:	b-a: 245	c-a: 250	c-b: 5
diff2:	b2-a2: 86975	c2-a2: 90000	c2-b2: 3025
facts a: 5 11 
facts b: 2 2 3 5 5 
facts c: 5 61 

triple:	55	1512	1513
sq:	3025	2286144	2289169
odd:	109	3023	3025
odds between b and c: 3025 
diff:	b-a: 1457	c-a: 1458	c-b: 1
diff2:	b2-a2: 2283119	c2-a2: 2286144	c2-b2: 3025
facts a: 5 11 
facts b: 2 2 2 3 3 3 7 
facts c: 17 89 

triple:	56	90	106
sq:	3136	8100	11236
odd:	111	179	211
odds between b and c: 181 183 185 187 189 191 193 195 197 199 201 203 205 207 209 211 
diff:	b-a: 34	c-a: 50	c-b: 16
diff2:	b2-a2: 4964	c2-a2: 8100	c2-b2: 3136
facts a: 2 2 2 7 
facts b: 2 3 3 5 
facts c: 2 53 

triple:	56	105	119
sq:	3136	11025	14161
odd:	111	209	237
odds between b and c: 211 213 215 217 219 221 223 225 227 229 231 233 235 237 
diff:	b-a: 49	c-a: 63	c-b: 14
diff2:	b2-a2: 7889	c2-a2: 11025	c2-b2: 3136
facts a: 2 2 2 7 
facts b: 3 5 7 
facts c: 7 17 

triple:	56	192	200
sq:	3136	36864	40000
odd:	111	383	399
odds between b and c: 385 387 389 391 393 395 397 399 
diff:	b-a: 136	c-a: 144	c-b: 8
diff2:	b2-a2: 33728	c2-a2: 36864	c2-b2: 3136
facts a: 2 2 2 7 
facts b: 2 2 2 2 2 2 3 
facts c: 2 2 2 5 5 

triple:	56	390	394
sq:	3136	152100	155236
odd:	111	779	787
odds between b and c: 781 783 785 787 
diff:	b-a: 334	c-a: 338	c-b: 4
diff2:	b2-a2: 148964	c2-a2: 152100	c2-b2: 3136
facts a: 2 2 2 7 
facts b: 2 3 5 13 
facts c: 2 197 

triple:	56	783	785
sq:	3136	613089	616225
odd:	111	1565	1569
odds between b and c: 1567 1569 
diff:	b-a: 727	c-a: 729	c-b: 2
diff2:	b2-a2: 609953	c2-a2: 613089	c2-b2: 3136
facts a: 2 2 2 7 
facts b: 3 3 3 29 
facts c: 5 157 

triple:	57	76	95
sq:	3249	5776	9025
odd:	113	151	189
odds between b and c: 153 155 157 159 161 163 165 167 169 171 173 175 177 179 181 183 185 187 189 
diff:	b-a: 19	c-a: 38	c-b: 19
diff2:	b2-a2: 2527	c2-a2: 5776	c2-b2: 3249
facts a: 3 19 
facts b: 2 2 19 
facts c: 5 19 

triple:	57	176	185
sq:	3249	30976	34225
odd:	113	351	369
odds between b and c: 353 355 357 359 361 363 365 367 369 
diff:	b-a: 119	c-a: 128	c-b: 9
diff2:	b2-a2: 27727	c2-a2: 30976	c2-b2: 3249
facts a: 3 19 
facts b: 2 2 2 2 11 
facts c: 5 37 

triple:	57	540	543
sq:	3249	291600	294849
odd:	113	1079	1085
odds between b and c: 1081 1083 1085 
diff:	b-a: 483	c-a: 486	c-b: 3
diff2:	b2-a2: 288351	c2-a2: 291600	c2-b2: 3249
facts a: 3 19 
facts b: 2 2 3 3 3 5 
facts c: 3 181 

triple:	57	1624	1625
sq:	3249	2637376	2640625
odd:	113	3247	3249
odds between b and c: 3249 
diff:	b-a: 1567	c-a: 1568	c-b: 1
diff2:	b2-a2: 2634127	c2-a2: 2637376	c2-b2: 3249
facts a: 3 19 
facts b: 2 2 2 7 29 
facts c: 5 5 5 13 

triple:	58	840	842
sq:	3364	705600	708964
odd:	115	1679	1683
odds between b and c: 1681 1683 
diff:	b-a: 782	c-a: 784	c-b: 2
diff2:	b2-a2: 702236	c2-a2: 705600	c2-b2: 3364
facts a: 2 29 
facts b: 2 2 2 3 5 7 
facts c: 2 421 

triple:	59	1740	1741
sq:	3481	3027600	3031081
odd:	117	3479	3481
odds between b and c: 3481 
diff:	b-a: 1681	c-a: 1682	c-b: 1
diff2:	b2-a2: 3024119	c2-a2: 3027600	c2-b2: 3481
facts a: 59 
facts b: 2 2 3 5 29 
facts c: 1741 

triple:	60	63	87
sq:	3600	3969	7569
odd:	119	125	173
odds between b and c: 127 129 131 133 135 137 139 141 143 145 147 149 151 153 155 157 159 161 163 165 167 169 171 173 
diff:	b-a: 3	c-a: 27	c-b: 24
diff2:	b2-a2: 369	c2-a2: 3969	c2-b2: 3600
facts a: 2 2 3 5 
facts b: 3 3 7 
facts c: 3 29 

triple:	60	80	100
sq:	3600	6400	10000
odd:	119	159	199
odds between b and c: 161 163 165 167 169 171 173 175 177 179 181 183 185 187 189 191 193 195 197 199 
diff:	b-a: 20	c-a: 40	c-b: 20
diff2:	b2-a2: 2800	c2-a2: 6400	c2-b2: 3600
facts a: 2 2 3 5 
facts b: 2 2 2 2 5 
facts c: 2 2 5 5 

triple:	60	91	109
sq:	3600	8281	11881
odd:	119	181	217
odds between b and c: 183 185 187 189 191 193 195 197 199 201 203 205 207 209 211 213 215 217 
diff:	b-a: 31	c-a: 49	c-b: 18
diff2:	b2-a2: 4681	c2-a2: 8281	c2-b2: 3600
facts a: 2 2 3 5 
facts b: 7 13 
facts c: 109 

triple:	60	144	156
sq:	3600	20736	24336
odd:	119	287	311
odds between b and c: 289 291 293 295 297 299 301 303 305 307 309 311 
diff:	b-a: 84	c-a: 96	c-b: 12
diff2:	b2-a2: 17136	c2-a2: 20736	c2-b2: 3600
facts a: 2 2 3 5 
facts b: 2 2 2 2 3 3 
facts c: 2 2 3 13 

triple:	60	175	185
sq:	3600	30625	34225
odd:	119	349	369
odds between b and c: 351 353 355 357 359 361 363 365 367 369 
diff:	b-a: 115	c-a: 125	c-b: 10
diff2:	b2-a2: 27025	c2-a2: 30625	c2-b2: 3600
facts a: 2 2 3 5 
facts b: 5 5 7 
facts c: 5 37 

triple:	60	221	229
sq:	3600	48841	52441
odd:	119	441	457
odds between b and c: 443 445 447 449 451 453 455 457 
diff:	b-a: 161	c-a: 169	c-b: 8
diff2:	b2-a2: 45241	c2-a2: 48841	c2-b2: 3600
facts a: 2 2 3 5 
facts b: 13 17 
facts c: 229 

triple:	60	297	303
sq:	3600	88209	91809
odd:	119	593	605
odds between b and c: 595 597 599 601 603 605 
diff:	b-a: 237	c-a: 243	c-b: 6
diff2:	b2-a2: 84609	c2-a2: 88209	c2-b2: 3600
facts a: 2 2 3 5 
facts b: 3 3 3 11 
facts c: 3 101 

triple:	60	448	452
sq:	3600	200704	204304
odd:	119	895	903
odds between b and c: 897 899 901 903 
diff:	b-a: 388	c-a: 392	c-b: 4
diff2:	b2-a2: 197104	c2-a2: 200704	c2-b2: 3600
facts a: 2 2 3 5 
facts b: 2 2 2 2 2 2 7 
facts c: 2 2 113 

triple:	60	899	901
sq:	3600	808201	811801
odd:	119	1797	1801
odds between b and c: 1799 1801 
diff:	b-a: 839	c-a: 841	c-b: 2
diff2:	b2-a2: 804601	c2-a2: 808201	c2-b2: 3600
facts a: 2 2 3 5 
facts b: 29 31 
facts c: 17 53 

triple:	61	1860	1861
sq:	3721	3459600	3463321
odd:	121	3719	3721
odds between b and c: 3721 
diff:	b-a: 1799	c-a: 1800	c-b: 1
diff2:	b2-a2: 3455879	c2-a2: 3459600	c2-b2: 3721
facts a: 61 
facts b: 2 2 3 5 31 
facts c: 1861 

triple:	62	960	962
sq:	3844	921600	925444
odd:	123	1919	1923
odds between b and c: 1921 1923 
diff:	b-a: 898	c-a: 900	c-b: 2
diff2:	b2-a2: 917756	c2-a2: 921600	c2-b2: 3844
facts a: 2 31 
facts b: 2 2 2 2 2 2 3 5 
facts c: 2 13 37 

triple:	63	84	105
sq:	3969	7056	11025
odd:	125	167	209
odds between b and c: 169 171 173 175 177 179 181 183 185 187 189 191 193 195 197 199 201 203 205 207 209 
diff:	b-a: 21	c-a: 42	c-b: 21
diff2:	b2-a2: 3087	c2-a2: 7056	c2-b2: 3969
facts a: 3 3 7 
facts b: 2 2 3 7 
facts c: 3 5 7 

triple:	63	216	225
sq:	3969	46656	50625
odd:	125	431	449
odds between b and c: 433 435 437 439 441 443 445 447 449 
diff:	b-a: 153	c-a: 162	c-b: 9
diff2:	b2-a2: 42687	c2-a2: 46656	c2-b2: 3969
facts a: 3 3 7 
facts b: 2 2 2 3 3 3 
facts c: 3 3 5 5 

triple:	63	280	287
sq:	3969	78400	82369
odd:	125	559	573
odds between b and c: 561 563 565 567 569 571 573 
diff:	b-a: 217	c-a: 224	c-b: 7
diff2:	b2-a2: 74431	c2-a2: 78400	c2-b2: 3969
facts a: 3 3 7 
facts b: 2 2 2 5 7 
facts c: 7 41 

triple:	63	660	663
sq:	3969	435600	439569
odd:	125	1319	1325
odds between b and c: 1321 1323 1325 
diff:	b-a: 597	c-a: 600	c-b: 3
diff2:	b2-a2: 431631	c2-a2: 435600	c2-b2: 3969
facts a: 3 3 7 
facts b: 2 2 3 5 11 
facts c: 3 13 17 

triple:	63	1984	1985
sq:	3969	3936256	3940225
odd:	125	3967	3969
odds between b and c: 3969 
diff:	b-a: 1921	c-a: 1922	c-b: 1
diff2:	b2-a2: 3932287	c2-a2: 3936256	c2-b2: 3969
facts a: 3 3 7 
facts b: 2 2 2 2 2 2 31 
facts c: 5 397 

triple:	64	120	136
sq:	4096	14400	18496
odd:	127	239	271
odds between b and c: 241 243 245 247 249 251 253 255 257 259 261 263 265 267 269 271 
diff:	b-a: 56	c-a: 72	c-b: 16
diff2:	b2-a2: 10304	c2-a2: 14400	c2-b2: 4096
facts a: 2 2 2 2 2 2 
facts b: 2 2 2 3 5 
facts c: 2 2 2 17 

triple:	64	252	260
sq:	4096	63504	67600
odd:	127	503	519
odds between b and c: 505 507 509 511 513 515 517 519 
diff:	b-a: 188	c-a: 196	c-b: 8
diff2:	b2-a2: 59408	c2-a2: 63504	c2-b2: 4096
facts a: 2 2 2 2 2 2 
facts b: 2 2 3 3 7 
facts c: 2 2 5 13 

triple:	64	510	514
sq:	4096	260100	264196
odd:	127	1019	1027
odds between b and c: 1021 1023 1025 1027 
diff:	b-a: 446	c-a: 450	c-b: 4
diff2:	b2-a2: 256004	c2-a2: 260100	c2-b2: 4096
facts a: 2 2 2 2 2 2 
facts b: 2 3 5 17 
facts c: 2 257 

triple:	64	1023	1025
sq:	4096	1046529	1050625
odd:	127	2045	2049
odds between b and c: 2047 2049 
diff:	b-a: 959	c-a: 961	c-b: 2
diff2:	b2-a2: 1042433	c2-a2: 1046529	c2-b2: 4096
facts a: 2 2 2 2 2 2 
facts b: 3 11 31 
facts c: 5 5 41 

triple:	65	72	97
sq:	4225	5184	9409
odd:	129	143	193
odds between b and c: 145 147 149 151 153 155 157 159 161 163 165 167 169 171 173 175 177 179 181 183 185 187 189 191 193 
diff:	b-a: 7	c-a: 32	c-b: 25
diff2:	b2-a2: 959	c2-a2: 5184	c2-b2: 4225
facts a: 5 13 
facts b: 2 2 2 3 3 
facts c: 97 

triple:	65	156	169
sq:	4225	24336	28561
odd:	129	311	337
odds between b and c: 313 315 317 319 321 323 325 327 329 331 333 335 337 
diff:	b-a: 91	c-a: 104	c-b: 13
diff2:	b2-a2: 20111	c2-a2: 24336	c2-b2: 4225
facts a: 5 13 
facts b: 2 2 3 13 
facts c: 13 13 

triple:	65	420	425
sq:	4225	176400	180625
odd:	129	839	849
odds between b and c: 841 843 845 847 849 
diff:	b-a: 355	c-a: 360	c-b: 5
diff2:	b2-a2: 172175	c2-a2: 176400	c2-b2: 4225
facts a: 5 13 
facts b: 2 2 3 5 7 
facts c: 5 5 17 

triple:	65	2112	2113
sq:	4225	4460544	4464769
odd:	129	4223	4225
odds between b and c: 4225 
diff:	b-a: 2047	c-a: 2048	c-b: 1
diff2:	b2-a2: 4456319	c2-a2: 4460544	c2-b2: 4225
facts a: 5 13 
facts b: 2 2 2 2 2 2 3 11 
facts c: 2113 

triple:	66	88	110
sq:	4356	7744	12100
odd:	131	175	219
odds between b and c: 177 179 181 183 185 187 189 191 193 195 197 199 201 203 205 207 209 211 213 215 217 219 
diff:	b-a: 22	c-a: 44	c-b: 22
diff2:	b2-a2: 3388	c2-a2: 7744	c2-b2: 4356
facts a: 2 3 11 
facts b: 2 2 2 11 
facts c: 2 5 11 

triple:	66	112	130
sq:	4356	12544	16900
odd:	131	223	259
odds between b and c: 225 227 229 231 233 235 237 239 241 243 245 247 249 251 253 255 257 259 
diff:	b-a: 46	c-a: 64	c-b: 18
diff2:	b2-a2: 8188	c2-a2: 12544	c2-b2: 4356
facts a: 2 3 11 
facts b: 2 2 2 2 7 
facts c: 2 5 13 

triple:	66	360	366
sq:	4356	129600	133956
odd:	131	719	731
odds between b and c: 721 723 725 727 729 731 
diff:	b-a: 294	c-a: 300	c-b: 6
diff2:	b2-a2: 125244	c2-a2: 129600	c2-b2: 4356
facts a: 2 3 11 
facts b: 2 2 2 3 3 5 
facts c: 2 3 61 

triple:	66	1088	1090
sq:	4356	1183744	1188100
odd:	131	2175	2179
odds between b and c: 2177 2179 
diff:	b-a: 1022	c-a: 1024	c-b: 2
diff2:	b2-a2: 1179388	c2-a2: 1183744	c2-b2: 4356
facts a: 2 3 11 
facts b: 2 2 2 2 2 2 17 
facts c: 2 5 109 

triple:	67	2244	2245
sq:	4489	5035536	5040025
odd:	133	4487	4489
odds between b and c: 4489 
diff:	b-a: 2177	c-a: 2178	c-b: 1
diff2:	b2-a2: 5031047	c2-a2: 5035536	c2-b2: 4489
facts a: 67 
facts b: 2 2 3 11 17 
facts c: 5 449 

triple:	68	285	293
sq:	4624	81225	85849
odd:	135	569	585
odds between b and c: 571 573 575 577 579 581 583 585 
diff:	b-a: 217	c-a: 225	c-b: 8
diff2:	b2-a2: 76601	c2-a2: 81225	c2-b2: 4624
facts a: 2 2 17 
facts b: 3 5 19 
facts c: 293 

triple:	68	576	580
sq:	4624	331776	336400
odd:	135	1151	1159
odds between b and c: 1153 1155 1157 1159 
diff:	b-a: 508	c-a: 512	c-b: 4
diff2:	b2-a2: 327152	c2-a2: 331776	c2-b2: 4624
facts a: 2 2 17 
facts b: 2 2 2 2 2 2 3 3 
facts c: 2 2 5 29 

triple:	68	1155	1157
sq:	4624	1334025	1338649
odd:	135	2309	2313
odds between b and c: 2311 2313 
diff:	b-a: 1087	c-a: 1089	c-b: 2
diff2:	b2-a2: 1329401	c2-a2: 1334025	c2-b2: 4624
facts a: 2 2 17 
facts b: 3 5 7 11 
facts c: 13 89 

triple:	69	92	115
sq:	4761	8464	13225
odd:	137	183	229
odds between b and c: 185 187 189 191 193 195 197 199 201 203 205 207 209 211 213 215 217 219 221 223 225 227 229 
diff:	b-a: 23	c-a: 46	c-b: 23
diff2:	b2-a2: 3703	c2-a2: 8464	c2-b2: 4761
facts a: 3 23 
facts b: 2 2 23 
facts c: 5 23 

triple:	69	260	269
sq:	4761	67600	72361
odd:	137	519	537
odds between b and c: 521 523 525 527 529 531 533 535 537 
diff:	b-a: 191	c-a: 200	c-b: 9
diff2:	b2-a2: 62839	c2-a2: 67600	c2-b2: 4761
facts a: 3 23 
facts b: 2 2 5 13 
facts c: 269 

triple:	69	792	795
sq:	4761	627264	632025
odd:	137	1583	1589
odds between b and c: 1585 1587 1589 
diff:	b-a: 723	c-a: 726	c-b: 3
diff2:	b2-a2: 622503	c2-a2: 627264	c2-b2: 4761
facts a: 3 23 
facts b: 2 2 2 3 3 11 
facts c: 3 5 53 

triple:	69	2380	2381
sq:	4761	5664400	5669161
odd:	137	4759	4761
odds between b and c: 4761 
diff:	b-a: 2311	c-a: 2312	c-b: 1
diff2:	b2-a2: 5659639	c2-a2: 5664400	c2-b2: 4761
facts a: 3 23 
facts b: 2 2 5 7 17 
facts c: 2381 

triple:	70	168	182
sq:	4900	28224	33124
odd:	139	335	363
odds between b and c: 337 339 341 343 345 347 349 351 353 355 357 359 361 363 
diff:	b-a: 98	c-a: 112	c-b: 14
diff2:	b2-a2: 23324	c2-a2: 28224	c2-b2: 4900
facts a: 2 5 7 
facts b: 2 2 2 3 7 
facts c: 2 7 13 

triple:	70	240	250
sq:	4900	57600	62500
odd:	139	479	499
odds between b and c: 481 483 485 487 489 491 493 495 497 499 
diff:	b-a: 170	c-a: 180	c-b: 10
diff2:	b2-a2: 52700	c2-a2: 57600	c2-b2: 4900
facts a: 2 5 7 
facts b: 2 2 2 2 3 5 
facts c: 2 5 5 5 

triple:	70	1224	1226
sq:	4900	1498176	1503076
odd:	139	2447	2451
odds between b and c: 2449 2451 
diff:	b-a: 1154	c-a: 1156	c-b: 2
diff2:	b2-a2: 1493276	c2-a2: 1498176	c2-b2: 4900
facts a: 2 5 7 
facts b: 2 2 2 3 3 17 
facts c: 2 613 

triple:	71	2520	2521
sq:	5041	6350400	6355441
odd:	141	5039	5041
odds between b and c: 5041 
diff:	b-a: 2449	c-a: 2450	c-b: 1
diff2:	b2-a2: 6345359	c2-a2: 6350400	c2-b2: 5041
facts a: 71 
facts b: 2 2 2 3 3 5 7 
facts c: 2521 

triple:	72	96	120
sq:	5184	9216	14400
odd:	143	191	239
odds between b and c: 193 195 197 199 201 203 205 207 209 211 213 215 217 219 221 223 225 227 229 231 233 235 237 239 
diff:	b-a: 24	c-a: 48	c-b: 24
diff2:	b2-a2: 4032	c2-a2: 9216	c2-b2: 5184
facts a: 2 2 2 3 3 
facts b: 2 2 2 2 2 3 
facts c: 2 2 2 3 5 

triple:	72	135	153
sq:	5184	18225	23409
odd:	143	269	305
odds between b and c: 271 273 275 277 279 281 283 285 287 289 291 293 295 297 299 301 303 305 
diff:	b-a: 63	c-a: 81	c-b: 18
diff2:	b2-a2: 13041	c2-a2: 18225	c2-b2: 5184
facts a: 2 2 2 3 3 
facts b: 3 3 3 5 
facts c: 3 3 17 

triple:	72	154	170
sq:	5184	23716	28900
odd:	143	307	339
odds between b and c: 309 311 313 315 317 319 321 323 325 327 329 331 333 335 337 339 
diff:	b-a: 82	c-a: 98	c-b: 16
diff2:	b2-a2: 18532	c2-a2: 23716	c2-b2: 5184
facts a: 2 2 2 3 3 
facts b: 2 7 11 
facts c: 2 5 17 

triple:	72	210	222
sq:	5184	44100	49284
odd:	143	419	443
odds between b and c: 421 423 425 427 429 431 433 435 437 439 441 443 
diff:	b-a: 138	c-a: 150	c-b: 12
diff2:	b2-a2: 38916	c2-a2: 44100	c2-b2: 5184
facts a: 2 2 2 3 3 
facts b: 2 3 5 7 
facts c: 2 3 37 

triple:	72	320	328
sq:	5184	102400	107584
odd:	143	639	655
odds between b and c: 641 643 645 647 649 651 653 655 
diff:	b-a: 248	c-a: 256	c-b: 8
diff2:	b2-a2: 97216	c2-a2: 102400	c2-b2: 5184
facts a: 2 2 2 3 3 
facts b: 2 2 2 2 2 2 5 
facts c: 2 2 2 41 

triple:	72	429	435
sq:	5184	184041	189225
odd:	143	857	869
odds between b and c: 859 861 863 865 867 869 
diff:	b-a: 357	c-a: 363	c-b: 6
diff2:	b2-a2: 178857	c2-a2: 184041	c2-b2: 5184
facts a: 2 2 2 3 3 
facts b: 3 11 13 
facts c: 3 5 29 

triple:	72	646	650
sq:	5184	417316	422500
odd:	143	1291	1299
odds between b and c: 1293 1295 1297 1299 
diff:	b-a: 574	c-a: 578	c-b: 4
diff2:	b2-a2: 412132	c2-a2: 417316	c2-b2: 5184
facts a: 2 2 2 3 3 
facts b: 2 17 19 
facts c: 2 5 5 13 

triple:	72	1295	1297
sq:	5184	1677025	1682209
odd:	143	2589	2593
odds between b and c: 2591 2593 
diff:	b-a: 1223	c-a: 1225	c-b: 2
diff2:	b2-a2: 1671841	c2-a2: 1677025	c2-b2: 5184
facts a: 2 2 2 3 3 
facts b: 5 7 37 
facts c: 1297 

triple:	73	2664	2665
sq:	5329	7096896	7102225
odd:	145	5327	5329
odds between b and c: 5329 
diff:	b-a: 2591	c-a: 2592	c-b: 1
diff2:	b2-a2: 7091567	c2-a2: 7096896	c2-b2: 5329
facts a: 73 
facts b: 2 2 2 3 3 37 
facts c: 5 13 41 

triple:	74	1368	1370
sq:	5476	1871424	1876900
odd:	147	2735	2739
odds between b and c: 2737 2739 
diff:	b-a: 1294	c-a: 1296	c-b: 2
diff2:	b2-a2: 1865948	c2-a2: 1871424	c2-b2: 5476
facts a: 2 37 
facts b: 2 2 2 3 3 19 
facts c: 2 5 137 

triple:	75	100	125
sq:	5625	10000	15625
odd:	149	199	249
odds between b and c: 201 203 205 207 209 211 213 215 217 219 221 223 225 227 229 231 233 235 237 239 241 243 245 247 249 
diff:	b-a: 25	c-a: 50	c-b: 25
diff2:	b2-a2: 4375	c2-a2: 10000	c2-b2: 5625
facts a: 3 5 5 
facts b: 2 2 5 5 
facts c: 5 5 5 

triple:	75	180	195
sq:	5625	32400	38025
odd:	149	359	389
odds between b and c: 361 363 365 367 369 371 373 375 377 379 381 383 385 387 389 
diff:	b-a: 105	c-a: 120	c-b: 15
diff2:	b2-a2: 26775	c2-a2: 32400	c2-b2: 5625
facts a: 3 5 5 
facts b: 2 2 3 3 5 
facts c: 3 5 13 

triple:	75	308	317
sq:	5625	94864	100489
odd:	149	615	633
odds between b and c: 617 619 621 623 625 627 629 631 633 
diff:	b-a: 233	c-a: 242	c-b: 9
diff2:	b2-a2: 89239	c2-a2: 94864	c2-b2: 5625
facts a: 3 5 5 
facts b: 2 2 7 11 
facts c: 317 

triple:	75	560	565
sq:	5625	313600	319225
odd:	149	1119	1129
odds between b and c: 1121 1123 1125 1127 1129 
diff:	b-a: 485	c-a: 490	c-b: 5
diff2:	b2-a2: 307975	c2-a2: 313600	c2-b2: 5625
facts a: 3 5 5 
facts b: 2 2 2 2 5 7 
facts c: 5 113 

triple:	75	936	939
sq:	5625	876096	881721
odd:	149	1871	1877
odds between b and c: 1873 1875 1877 
diff:	b-a: 861	c-a: 864	c-b: 3
diff2:	b2-a2: 870471	c2-a2: 876096	c2-b2: 5625
facts a: 3 5 5 
facts b: 2 2 2 3 3 13 
facts c: 3 313 

triple:	75	2812	2813
sq:	5625	7907344	7912969
odd:	149	5623	5625
odds between b and c: 5625 
diff:	b-a: 2737	c-a: 2738	c-b: 1
diff2:	b2-a2: 7901719	c2-a2: 7907344	c2-b2: 5625
facts a: 3 5 5 
facts b: 2 2 19 37 
facts c: 29 97 

triple:	76	357	365
sq:	5776	127449	133225
odd:	151	713	729
odds between b and c: 715 717 719 721 723 725 727 729 
diff:	b-a: 281	c-a: 289	c-b: 8
diff2:	b2-a2: 121673	c2-a2: 127449	c2-b2: 5776
facts a: 2 2 19 
facts b: 3 7 17 
facts c: 5 73 

triple:	76	720	724
sq:	5776	518400	524176
odd:	151	1439	1447
odds between b and c: 1441 1443 1445 1447 
diff:	b-a: 644	c-a: 648	c-b: 4
diff2:	b2-a2: 512624	c2-a2: 518400	c2-b2: 5776
facts a: 2 2 19 
facts b: 2 2 2 2 3 3 5 
facts c: 2 2 181 

triple:	76	1443	1445
sq:	5776	2082249	2088025
odd:	151	2885	2889
odds between b and c: 2887 2889 
diff:	b-a: 1367	c-a: 1369	c-b: 2
diff2:	b2-a2: 2076473	c2-a2: 2082249	c2-b2: 5776
facts a: 2 2 19 
facts b: 3 13 37 
facts c: 5 17 17 

triple:	77	264	275
sq:	5929	69696	75625
odd:	153	527	549
odds between b and c: 529 531 533 535 537 539 541 543 545 547 549 
diff:	b-a: 187	c-a: 198	c-b: 11
diff2:	b2-a2: 63767	c2-a2: 69696	c2-b2: 5929
facts a: 7 11 
facts b: 2 2 2 3 11 
facts c: 5 5 11 

triple:	77	420	427
sq:	5929	176400	182329
odd:	153	839	853
odds between b and c: 841 843 845 847 849 851 853 
diff:	b-a: 343	c-a: 350	c-b: 7
diff2:	b2-a2: 170471	c2-a2: 176400	c2-b2: 5929
facts a: 7 11 
facts b: 2 2 3 5 7 
facts c: 7 61 

triple:	77	2964	2965
sq:	5929	8785296	8791225
odd:	153	5927	5929
odds between b and c: 5929 
diff:	b-a: 2887	c-a: 2888	c-b: 1
diff2:	b2-a2: 8779367	c2-a2: 8785296	c2-b2: 5929
facts a: 7 11 
facts b: 2 2 3 13 19 
facts c: 5 593 

triple:	78	104	130
sq:	6084	10816	16900
odd:	155	207	259
odds between b and c: 209 211 213 215 217 219 221 223 225 227 229 231 233 235 237 239 241 243 245 247 249 251 253 255 257 259 
diff:	b-a: 26	c-a: 52	c-b: 26
diff2:	b2-a2: 4732	c2-a2: 10816	c2-b2: 6084
facts a: 2 3 13 
facts b: 2 2 2 13 
facts c: 2 5 13 

triple:	78	160	178
sq:	6084	25600	31684
odd:	155	319	355
odds between b and c: 321 323 325 327 329 331 333 335 337 339 341 343 345 347 349 351 353 355 
diff:	b-a: 82	c-a: 100	c-b: 18
diff2:	b2-a2: 19516	c2-a2: 25600	c2-b2: 6084
facts a: 2 3 13 
facts b: 2 2 2 2 2 5 
facts c: 2 89 

triple:	78	504	510
sq:	6084	254016	260100
odd:	155	1007	1019
odds between b and c: 1009 1011 1013 1015 1017 1019 
diff:	b-a: 426	c-a: 432	c-b: 6
diff2:	b2-a2: 247932	c2-a2: 254016	c2-b2: 6084
facts a: 2 3 13 
facts b: 2 2 2 3 3 7 
facts c: 2 3 5 17 

triple:	78	1520	1522
sq:	6084	2310400	2316484
odd:	155	3039	3043
odds between b and c: 3041 3043 
diff:	b-a: 1442	c-a: 1444	c-b: 2
diff2:	b2-a2: 2304316	c2-a2: 2310400	c2-b2: 6084
facts a: 2 3 13 
facts b: 2 2 2 2 5 19 
facts c: 2 761 

triple:	79	3120	3121
sq:	6241	9734400	9740641
odd:	157	6239	6241
odds between b and c: 6241 
diff:	b-a: 3041	c-a: 3042	c-b: 1
diff2:	b2-a2: 9728159	c2-a2: 9734400	c2-b2: 6241
facts a: 79 
facts b: 2 2 2 2 3 5 13 
facts c: 3121 

triple:	80	84	116
sq:	6400	7056	13456
odd:	159	167	231
odds between b and c: 169 171 173 175 177 179 181 183 185 187 189 191 193 195 197 199 201 203 205 207 209 211 213 215 217 219 221 223 225 227 229 231 
diff:	b-a: 4	c-a: 36	c-b: 32
diff2:	b2-a2: 656	c2-a2: 7056	c2-b2: 6400
facts a: 2 2 2 2 5 
facts b: 2 2 3 7 
facts c: 2 2 29 

triple:	80	150	170
sq:	6400	22500	28900
odd:	159	299	339
odds between b and c: 301 303 305 307 309 311 313 315 317 319 321 323 325 327 329 331 333 335 337 339 
diff:	b-a: 70	c-a: 90	c-b: 20
diff2:	b2-a2: 16100	c2-a2: 22500	c2-b2: 6400
facts a: 2 2 2 2 5 
facts b: 2 3 5 5 
facts c: 2 5 17 

triple:	80	192	208
sq:	6400	36864	43264
odd:	159	383	415
odds between b and c: 385 387 389 391 393 395 397 399 401 403 405 407 409 411 413 415 
diff:	b-a: 112	c-a: 128	c-b: 16
diff2:	b2-a2: 30464	c2-a2: 36864	c2-b2: 6400
facts a: 2 2 2 2 5 
facts b: 2 2 2 2 2 2 3 
facts c: 2 2 2 2 13 

triple:	80	315	325
sq:	6400	99225	105625
odd:	159	629	649
odds between b and c: 631 633 635 637 639 641 643 645 647 649 
diff:	b-a: 235	c-a: 245	c-b: 10
diff2:	b2-a2: 92825	c2-a2: 99225	c2-b2: 6400
facts a: 2 2 2 2 5 
facts b: 3 3 5 7 
facts c: 5 5 13 

triple:	80	396	404
sq:	6400	156816	163216
odd:	159	791	807
odds between b and c: 793 795 797 799 801 803 805 807 
diff:	b-a: 316	c-a: 324	c-b: 8
diff2:	b2-a2: 150416	c2-a2: 156816	c2-b2: 6400
facts a: 2 2 2 2 5 
facts b: 2 2 3 3 11 
facts c: 2 2 101 

triple:	80	798	802
sq:	6400	636804	643204
odd:	159	1595	1603
odds between b and c: 1597 1599 1601 1603 
diff:	b-a: 718	c-a: 722	c-b: 4
diff2:	b2-a2: 630404	c2-a2: 636804	c2-b2: 6400
facts a: 2 2 2 2 5 
facts b: 2 3 7 19 
facts c: 2 401 

triple:	80	1599	1601
sq:	6400	2556801	2563201
odd:	159	3197	3201
odds between b and c: 3199 3201 
diff:	b-a: 1519	c-a: 1521	c-b: 2
diff2:	b2-a2: 2550401	c2-a2: 2556801	c2-b2: 6400
facts a: 2 2 2 2 5 
facts b: 3 13 41 
facts c: 1601 

triple:	81	108	135
sq:	6561	11664	18225
odd:	161	215	269
odds between b and c: 217 219 221 223 225 227 229 231 233 235 237 239 241 243 245 247 249 251 253 255 257 259 261 263 265 267 269 
diff:	b-a: 27	c-a: 54	c-b: 27
diff2:	b2-a2: 5103	c2-a2: 11664	c2-b2: 6561
facts a: 3 3 3 3 
facts b: 2 2 3 3 3 
facts c: 3 3 3 5 

triple:	81	360	369
sq:	6561	129600	136161
odd:	161	719	737
odds between b and c: 721 723 725 727 729 731 733 735 737 
diff:	b-a: 279	c-a: 288	c-b: 9
diff2:	b2-a2: 123039	c2-a2: 129600	c2-b2: 6561
facts a: 3 3 3 3 
facts b: 2 2 2 3 3 5 
facts c: 3 3 41 

triple:	81	1092	1095
sq:	6561	1192464	1199025
odd:	161	2183	2189
odds between b and c: 2185 2187 2189 
diff:	b-a: 1011	c-a: 1014	c-b: 3
diff2:	b2-a2: 1185903	c2-a2: 1192464	c2-b2: 6561
facts a: 3 3 3 3 
facts b: 2 2 3 7 13 
facts c: 3 5 73 

triple:	81	3280	3281
sq:	6561	10758400	10764961
odd:	161	6559	6561
odds between b and c: 6561 
diff:	b-a: 3199	c-a: 3200	c-b: 1
diff2:	b2-a2: 10751839	c2-a2: 10758400	c2-b2: 6561
facts a: 3 3 3 3 
facts b: 2 2 2 2 5 41 
facts c: 17 193 

triple:	82	1680	1682
sq:	6724	2822400	2829124
odd:	163	3359	3363
odds between b and c: 3361 3363 
diff:	b-a: 1598	c-a: 1600	c-b: 2
diff2:	b2-a2: 2815676	c2-a2: 2822400	c2-b2: 6724
facts a: 2 41 
facts b: 2 2 2 2 3 5 7 
facts c: 2 29 29 

triple:	83	3444	3445
sq:	6889	11861136	11868025
odd:	165	6887	6889
odds between b and c: 6889 
diff:	b-a: 3361	c-a: 3362	c-b: 1
diff2:	b2-a2: 11854247	c2-a2: 11861136	c2-b2: 6889
facts a: 83 
facts b: 2 2 3 7 41 
facts c: 5 13 53 

triple:	84	112	140
sq:	7056	12544	19600
odd:	167	223	279
odds between b and c: 225 227 229 231 233 235 237 239 241 243 245 247 249 251 253 255 257 259 261 263 265 267 269 271 273 275 277 279 
diff:	b-a: 28	c-a: 56	c-b: 28
diff2:	b2-a2: 5488	c2-a2: 12544	c2-b2: 7056
facts a: 2 2 3 7 
facts b: 2 2 2 2 7 
facts c: 2 2 5 7 

triple:	84	135	159
sq:	7056	18225	25281
odd:	167	269	317
odds between b and c: 271 273 275 277 279 281 283 285 287 289 291 293 295 297 299 301 303 305 307 309 311 313 315 317 
diff:	b-a: 51	c-a: 75	c-b: 24
diff2:	b2-a2: 11169	c2-a2: 18225	c2-b2: 7056
facts a: 2 2 3 7 
facts b: 3 3 3 5 
facts c: 3 53 

triple:	84	187	205
sq:	7056	34969	42025
odd:	167	373	409
odds between b and c: 375 377 379 381 383 385 387 389 391 393 395 397 399 401 403 405 407 409 
diff:	b-a: 103	c-a: 121	c-b: 18
diff2:	b2-a2: 27913	c2-a2: 34969	c2-b2: 7056
facts a: 2 2 3 7 
facts b: 11 17 
facts c: 5 41 

triple:	84	245	259
sq:	7056	60025	67081
odd:	167	489	517
odds between b and c: 491 493 495 497 499 501 503 505 507 509 511 513 515 517 
diff:	b-a: 161	c-a: 175	c-b: 14
diff2:	b2-a2: 52969	c2-a2: 60025	c2-b2: 7056
facts a: 2 2 3 7 
facts b: 5 7 7 
facts c: 7 37 

triple:	84	288	300
sq:	7056	82944	90000
odd:	167	575	599
odds between b and c: 577 579 581 583 585 587 589 591 593 595 597 599 
diff:	b-a: 204	c-a: 216	c-b: 12
diff2:	b2-a2: 75888	c2-a2: 82944	c2-b2: 7056
facts a: 2 2 3 7 
facts b: 2 2 2 2 2 3 3 
facts c: 2 2 3 5 5 

triple:	84	437	445
sq:	7056	190969	198025
odd:	167	873	889
odds between b and c: 875 877 879 881 883 885 887 889 
diff:	b-a: 353	c-a: 361	c-b: 8
diff2:	b2-a2: 183913	c2-a2: 190969	c2-b2: 7056
facts a: 2 2 3 7 
facts b: 19 23 
facts c: 5 89 

triple:	84	585	591
sq:	7056	342225	349281
odd:	167	1169	1181
odds between b and c: 1171 1173 1175 1177 1179 1181 
diff:	b-a: 501	c-a: 507	c-b: 6
diff2:	b2-a2: 335169	c2-a2: 342225	c2-b2: 7056
facts a: 2 2 3 7 
facts b: 3 3 5 13 
facts c: 3 197 

triple:	84	880	884
sq:	7056	774400	781456
odd:	167	1759	1767
odds between b and c: 1761 1763 1765 1767 
diff:	b-a: 796	c-a: 800	c-b: 4
diff2:	b2-a2: 767344	c2-a2: 774400	c2-b2: 7056
facts a: 2 2 3 7 
facts b: 2 2 2 2 5 11 
facts c: 2 2 13 17 

triple:	84	1763	1765
sq:	7056	3108169	3115225
odd:	167	3525	3529
odds between b and c: 3527 3529 
diff:	b-a: 1679	c-a: 1681	c-b: 2
diff2:	b2-a2: 3101113	c2-a2: 3108169	c2-b2: 7056
facts a: 2 2 3 7 
facts b: 41 43 
facts c: 5 353 

triple:	85	132	157
sq:	7225	17424	24649
odd:	169	263	313
odds between b and c: 265 267 269 271 273 275 277 279 281 283 285 287 289 291 293 295 297 299 301 303 305 307 309 311 313 
diff:	b-a: 47	c-a: 72	c-b: 25
diff2:	b2-a2: 10199	c2-a2: 17424	c2-b2: 7225
facts a: 5 17 
facts b: 2 2 3 11 
facts c: 157 

triple:	85	204	221
sq:	7225	41616	48841
odd:	169	407	441
odds between b and c: 409 411 413 415 417 419 421 423 425 427 429 431 433 435 437 439 441 
diff:	b-a: 119	c-a: 136	c-b: 17
diff2:	b2-a2: 34391	c2-a2: 41616	c2-b2: 7225
facts a: 5 17 
facts b: 2 2 3 17 
facts c: 13 17 

triple:	85	720	725
sq:	7225	518400	525625
odd:	169	1439	1449
odds between b and c: 1441 1443 1445 1447 1449 
diff:	b-a: 635	c-a: 640	c-b: 5
diff2:	b2-a2: 511175	c2-a2: 518400	c2-b2: 7225
facts a: 5 17 
facts b: 2 2 2 2 3 3 5 
facts c: 5 5 29 

triple:	85	3612	3613
sq:	7225	13046544	13053769
odd:	169	7223	7225
odds between b and c: 7225 
diff:	b-a: 3527	c-a: 3528	c-b: 1
diff2:	b2-a2: 13039319	c2-a2: 13046544	c2-b2: 7225
facts a: 5 17 
facts b: 2 2 3 7 43 
facts c: 3613 

triple:	86	1848	1850
sq:	7396	3415104	3422500
odd:	171	3695	3699
odds between b and c: 3697 3699 
diff:	b-a: 1762	c-a: 1764	c-b: 2
diff2:	b2-a2: 3407708	c2-a2: 3415104	c2-b2: 7396
facts a: 2 43 
facts b: 2 2 2 3 7 11 
facts c: 2 5 5 37 

triple:	87	116	145
sq:	7569	13456	21025
odd:	173	231	289
odds between b and c: 233 235 237 239 241 243 245 247 249 251 253 255 257 259 261 263 265 267 269 271 273 275 277 279 281 283 285 287 289 
diff:	b-a: 29	c-a: 58	c-b: 29
diff2:	b2-a2: 5887	c2-a2: 13456	c2-b2: 7569
facts a: 3 29 
facts b: 2 2 29 
facts c: 5 29 

triple:	87	416	425
sq:	7569	173056	180625
odd:	173	831	849
odds between b and c: 833 835 837 839 841 843 845 847 849 
diff:	b-a: 329	c-a: 338	c-b: 9
diff2:	b2-a2: 165487	c2-a2: 173056	c2-b2: 7569
facts a: 3 29 
facts b: 2 2 2 2 2 13 
facts c: 5 5 17 

triple:	87	1260	1263
sq:	7569	1587600	1595169
odd:	173	2519	2525
odds between b and c: 2521 2523 2525 
diff:	b-a: 1173	c-a: 1176	c-b: 3
diff2:	b2-a2: 1580031	c2-a2: 1587600	c2-b2: 7569
facts a: 3 29 
facts b: 2 2 3 3 5 7 
facts c: 3 421 

triple:	87	3784	3785
sq:	7569	14318656	14326225
odd:	173	7567	7569
odds between b and c: 7569 
diff:	b-a: 3697	c-a: 3698	c-b: 1
diff2:	b2-a2: 14311087	c2-a2: 14318656	c2-b2: 7569
facts a: 3 29 
facts b: 2 2 2 11 43 
facts c: 5 757 

triple:	88	105	137
sq:	7744	11025	18769
odd:	175	209	273
odds between b and c: 211 213 215 217 219 221 223 225 227 229 231 233 235 237 239 241 243 245 247 249 251 253 255 257 259 261 263 265 267 269 271 273 
diff:	b-a: 17	c-a: 49	c-b: 32
diff2:	b2-a2: 3281	c2-a2: 11025	c2-b2: 7744
facts a: 2 2 2 11 
facts b: 3 5 7 
facts c: 137 

triple:	88	165	187
sq:	7744	27225	34969
odd:	175	329	373
odds between b and c: 331 333 335 337 339 341 343 345 347 349 351 353 355 357 359 361 363 365 367 369 371 373 
diff:	b-a: 77	c-a: 99	c-b: 22
diff2:	b2-a2: 19481	c2-a2: 27225	c2-b2: 7744
facts a: 2 2 2 11 
facts b: 3 5 11 
facts c: 11 17 

triple:	88	234	250
sq:	7744	54756	62500
odd:	175	467	499
odds between b and c: 469 471 473 475 477 479 481 483 485 487 489 491 493 495 497 499 
diff:	b-a: 146	c-a: 162	c-b: 16
diff2:	b2-a2: 47012	c2-a2: 54756	c2-b2: 7744
facts a: 2 2 2 11 
facts b: 2 3 3 13 
facts c: 2 5 5 5 

triple:	88	480	488
sq:	7744	230400	238144
odd:	175	959	975
odds between b and c: 961 963 965 967 969 971 973 975 
diff:	b-a: 392	c-a: 400	c-b: 8
diff2:	b2-a2: 222656	c2-a2: 230400	c2-b2: 7744
facts a: 2 2 2 11 
facts b: 2 2 2 2 2 3 5 
facts c: 2 2 2 61 

triple:	88	966	970
sq:	7744	933156	940900
odd:	175	1931	1939
odds between b and c: 1933 1935 1937 1939 
diff:	b-a: 878	c-a: 882	c-b: 4
diff2:	b2-a2: 925412	c2-a2: 933156	c2-b2: 7744
facts a: 2 2 2 11 
facts b: 2 3 7 23 
facts c: 2 5 97 

triple:	88	1935	1937
sq:	7744	3744225	3751969
odd:	175	3869	3873
odds between b and c: 3871 3873 
diff:	b-a: 1847	c-a: 1849	c-b: 2
diff2:	b2-a2: 3736481	c2-a2: 3744225	c2-b2: 7744
facts a: 2 2 2 11 
facts b: 3 3 5 43 
facts c: 13 149 

triple:	89	3960	3961
sq:	7921	15681600	15689521
odd:	177	7919	7921
odds between b and c: 7921 
diff:	b-a: 3871	c-a: 3872	c-b: 1
diff2:	b2-a2: 15673679	c2-a2: 15681600	c2-b2: 7921
facts a: 89 
facts b: 2 2 2 3 3 5 11 
facts c: 17 233 

triple:	90	120	150
sq:	8100	14400	22500
odd:	179	239	299
odds between b and c: 241 243 245 247 249 251 253 255 257 259 261 263 265 267 269 271 273 275 277 279 281 283 285 287 289 291 293 295 297 299 
diff:	b-a: 30	c-a: 60	c-b: 30
diff2:	b2-a2: 6300	c2-a2: 14400	c2-b2: 8100
facts a: 2 3 3 5 
facts b: 2 2 2 3 5 
facts c: 2 3 5 5 

triple:	90	216	234
sq:	8100	46656	54756
odd:	179	431	467
odds between b and c: 433 435 437 439 441 443 445 447 449 451 453 455 457 459 461 463 465 467 
diff:	b-a: 126	c-a: 144	c-b: 18
diff2:	b2-a2: 38556	c2-a2: 46656	c2-b2: 8100
facts a: 2 3 3 5 
facts b: 2 2 2 3 3 3 
facts c: 2 3 3 13 

triple:	90	400	410
sq:	8100	160000	168100
odd:	179	799	819
odds between b and c: 801 803 805 807 809 811 813 815 817 819 
diff:	b-a: 310	c-a: 320	c-b: 10
diff2:	b2-a2: 151900	c2-a2: 160000	c2-b2: 8100
facts a: 2 3 3 5 
facts b: 2 2 2 2 5 5 
facts c: 2 5 41 

triple:	90	672	678
sq:	8100	451584	459684
odd:	179	1343	1355
odds between b and c: 1345 1347 1349 1351 1353 1355 
diff:	b-a: 582	c-a: 588	c-b: 6
diff2:	b2-a2: 443484	c2-a2: 451584	c2-b2: 8100
facts a: 2 3 3 5 
facts b: 2 2 2 2 2 3 7 
facts c: 2 3 113 

triple:	90	2024	2026
sq:	8100	4096576	4104676
odd:	179	4047	4051
odds between b and c: 4049 4051 
diff:	b-a: 1934	c-a: 1936	c-b: 2
diff2:	b2-a2: 4088476	c2-a2: 4096576	c2-b2: 8100
facts a: 2 3 3 5 
facts b: 2 2 2 11 23 
facts c: 2 1013 

triple:	91	312	325
sq:	8281	97344	105625
odd:	181	623	649
odds between b and c: 625 627 629 631 633 635 637 639 641 643 645 647 649 
diff:	b-a: 221	c-a: 234	c-b: 13
diff2:	b2-a2: 89063	c2-a2: 97344	c2-b2: 8281
facts a: 7 13 
facts b: 2 2 2 3 13 
facts c: 5 5 13 

triple:	91	588	595
sq:	8281	345744	354025
odd:	181	1175	1189
odds between b and c: 1177 1179 1181 1183 1185 1187 1189 
diff:	b-a: 497	c-a: 504	c-b: 7
diff2:	b2-a2: 337463	c2-a2: 345744	c2-b2: 8281
facts a: 7 13 
facts b: 2 2 3 7 7 
facts c: 5 7 17 

triple:	91	4140	4141
sq:	8281	17139600	17147881
odd:	181	8279	8281
odds between b and c: 8281 
diff:	b-a: 4049	c-a: 4050	c-b: 1
diff2:	b2-a2: 17131319	c2-a2: 17139600	c2-b2: 8281
facts a: 7 13 
facts b: 2 2 3 3 5 23 
facts c: 41 101 

triple:	92	525	533
sq:	8464	275625	284089
odd:	183	1049	1065
odds between b and c: 1051 1053 1055 1057 1059 1061 1063 1065 
diff:	b-a: 433	c-a: 441	c-b: 8
diff2:	b2-a2: 267161	c2-a2: 275625	c2-b2: 8464
facts a: 2 2 23 
facts b: 3 5 5 7 
facts c: 13 41 

triple:	92	1056	1060
sq:	8464	1115136	1123600
odd:	183	2111	2119
odds between b and c: 2113 2115 2117 2119 
diff:	b-a: 964	c-a: 968	c-b: 4
diff2:	b2-a2: 1106672	c2-a2: 1115136	c2-b2: 8464
facts a: 2 2 23 
facts b: 2 2 2 2 2 3 11 
facts c: 2 2 5 53 

triple:	92	2115	2117
sq:	8464	4473225	4481689
odd:	183	4229	4233
odds between b and c: 4231 4233 
diff:	b-a: 2023	c-a: 2025	c-b: 2
diff2:	b2-a2: 4464761	c2-a2: 4473225	c2-b2: 8464
facts a: 2 2 23 
facts b: 3 3 5 47 
facts c: 29 73 

triple:	93	124	155
sq:	8649	15376	24025
odd:	185	247	309
odds between b and c: 249 251 253 255 257 259 261 263 265 267 269 271 273 275 277 279 281 283 285 287 289 291 293 295 297 299 301 303 305 307 309 
diff:	b-a: 31	c-a: 62	c-b: 31
diff2:	b2-a2: 6727	c2-a2: 15376	c2-b2: 8649
facts a: 3 31 
facts b: 2 2 31 
facts c: 5 31 

triple:	93	476	485
sq:	8649	226576	235225
odd:	185	951	969
odds between b and c: 953 955 957 959 961 963 965 967 969 
diff:	b-a: 383	c-a: 392	c-b: 9
diff2:	b2-a2: 217927	c2-a2: 226576	c2-b2: 8649
facts a: 3 31 
facts b: 2 2 7 17 
facts c: 5 97 

triple:	93	1440	1443
sq:	8649	2073600	2082249
odd:	185	2879	2885
odds between b and c: 2881 2883 2885 
diff:	b-a: 1347	c-a: 1350	c-b: 3
diff2:	b2-a2: 2064951	c2-a2: 2073600	c2-b2: 8649
facts a: 3 31 
facts b: 2 2 2 2 2 3 3 5 
facts c: 3 13 37 

triple:	93	4324	4325
sq:	8649	18696976	18705625
odd:	185	8647	8649
odds between b and c: 8649 
diff:	b-a: 4231	c-a: 4232	c-b: 1
diff2:	b2-a2: 18688327	c2-a2: 18696976	c2-b2: 8649
facts a: 3 31 
facts b: 2 2 23 47 
facts c: 5 5 173 

triple:	94	2208	2210
sq:	8836	4875264	4884100
odd:	187	4415	4419
odds between b and c: 4417 4419 
diff:	b-a: 2114	c-a: 2116	c-b: 2
diff2:	b2-a2: 4866428	c2-a2: 4875264	c2-b2: 8836
facts a: 2 47 
facts b: 2 2 2 2 2 3 23 
facts c: 2 5 13 17 

triple:	95	168	193
sq:	9025	28224	37249
odd:	189	335	385
odds between b and c: 337 339 341 343 345 347 349 351 353 355 357 359 361 363 365 367 369 371 373 375 377 379 381 383 385 
diff:	b-a: 73	c-a: 98	c-b: 25
diff2:	b2-a2: 19199	c2-a2: 28224	c2-b2: 9025
facts a: 5 19 
facts b: 2 2 2 3 7 
facts c: 193 

triple:	95	228	247
sq:	9025	51984	61009
odd:	189	455	493
odds between b and c: 457 459 461 463 465 467 469 471 473 475 477 479 481 483 485 487 489 491 493 
diff:	b-a: 133	c-a: 152	c-b: 19
diff2:	b2-a2: 42959	c2-a2: 51984	c2-b2: 9025
facts a: 5 19 
facts b: 2 2 3 19 
facts c: 13 19 

triple:	95	900	905
sq:	9025	810000	819025
odd:	189	1799	1809
odds between b and c: 1801 1803 1805 1807 1809 
diff:	b-a: 805	c-a: 810	c-b: 5
diff2:	b2-a2: 800975	c2-a2: 810000	c2-b2: 9025
facts a: 5 19 
facts b: 2 2 3 3 5 5 
facts c: 5 181 

triple:	95	4512	4513
sq:	9025	20358144	20367169
odd:	189	9023	9025
odds between b and c: 9025 
diff:	b-a: 4417	c-a: 4418	c-b: 1
diff2:	b2-a2: 20349119	c2-a2: 20358144	c2-b2: 9025
facts a: 5 19 
facts b: 2 2 2 2 2 3 47 
facts c: 4513 

triple:	96	110	146
sq:	9216	12100	21316
odd:	191	219	291
odds between b and c: 221 223 225 227 229 231 233 235 237 239 241 243 245 247 249 251 253 255 257 259 261 263 265 267 269 271 273 275 277 279 281 283 285 287 289 291 
diff:	b-a: 14	c-a: 50	c-b: 36
diff2:	b2-a2: 2884	c2-a2: 12100	c2-b2: 9216
facts a: 2 2 2 2 2 3 
facts b: 2 5 11 
facts c: 2 73 

triple:	96	128	160
sq:	9216	16384	25600
odd:	191	255	319
odds between b and c: 257 259 261 263 265 267 269 271 273 275 277 279 281 283 285 287 289 291 293 295 297 299 301 303 305 307 309 311 313 315 317 319 
diff:	b-a: 32	c-a: 64	c-b: 32
diff2:	b2-a2: 7168	c2-a2: 16384	c2-b2: 9216
facts a: 2 2 2 2 2 3 
facts b: 2 2 2 2 2 2 2 
facts c: 2 2 2 2 2 5 

triple:	96	180	204
sq:	9216	32400	41616
odd:	191	359	407
odds between b and c: 361 363 365 367 369 371 373 375 377 379 381 383 385 387 389 391 393 395 397 399 401 403 405 407 
diff:	b-a: 84	c-a: 108	c-b: 24
diff2:	b2-a2: 23184	c2-a2: 32400	c2-b2: 9216
facts a: 2 2 2 2 2 3 
facts b: 2 2 3 3 5 
facts c: 2 2 3 17 

triple:	96	247	265
sq:	9216	61009	70225
odd:	191	493	529
odds between b and c: 495 497 499 501 503 505 507 509 511 513 515 517 519 521 523 525 527 529 
diff:	b-a: 151	c-a: 169	c-b: 18
diff2:	b2-a2: 51793	c2-a2: 61009	c2-b2: 9216
facts a: 2 2 2 2 2 3 
facts b: 13 19 
facts c: 5 53 

triple:	96	280	296
sq:	9216	78400	87616
odd:	191	559	591
odds between b and c: 561 563 565 567 569 571 573 575 577 579 581 583 585 587 589 591 
diff:	b-a: 184	c-a: 200	c-b: 16
diff2:	b2-a2: 69184	c2-a2: 78400	c2-b2: 9216
facts a: 2 2 2 2 2 3 
facts b: 2 2 2 5 7 
facts c: 2 2 2 37 

triple:	96	378	390
sq:	9216	142884	152100
odd:	191	755	779
odds between b and c: 757 759 761 763 765 767 769 771 773 775 777 779 
diff:	b-a: 282	c-a: 294	c-b: 12
diff2:	b2-a2: 133668	c2-a2: 142884	c2-b2: 9216
facts a: 2 2 2 2 2 3 
facts b: 2 3 3 3 7 
facts c: 2 3 5 13 

triple:	96	572	580
sq:	9216	327184	336400
odd:	191	1143	1159
odds between b and c: 1145 1147 1149 1151 1153 1155 1157 1159 
diff:	b-a: 476	c-a: 484	c-b: 8
diff2:	b2-a2: 317968	c2-a2: 327184	c2-b2: 9216
facts a: 2 2 2 2 2 3 
facts b: 2 2 11 13 
facts c: 2 2 5 29 

triple:	96	765	771
sq:	9216	585225	594441
odd:	191	1529	1541
odds between b and c: 1531 1533 1535 1537 1539 1541 
diff:	b-a: 669	c-a: 675	c-b: 6
diff2:	b2-a2: 576009	c2-a2: 585225	c2-b2: 9216
facts a: 2 2 2 2 2 3 
facts b: 3 3 5 17 
facts c: 3 257 

triple:	96	1150	1154
sq:	9216	1322500	1331716
odd:	191	2299	2307
odds between b and c: 2301 2303 2305 2307 
diff:	b-a: 1054	c-a: 1058	c-b: 4
diff2:	b2-a2: 1313284	c2-a2: 1322500	c2-b2: 9216
facts a: 2 2 2 2 2 3 
facts b: 2 5 5 23 
facts c: 2 577 

triple:	96	2303	2305
sq:	9216	5303809	5313025
odd:	191	4605	4609
odds between b and c: 4607 4609 
diff:	b-a: 2207	c-a: 2209	c-b: 2
diff2:	b2-a2: 5294593	c2-a2: 5303809	c2-b2: 9216
facts a: 2 2 2 2 2 3 
facts b: 7 7 47 
facts c: 5 461 

triple:	97	4704	4705
sq:	9409	22127616	22137025
odd:	193	9407	9409
odds between b and c: 9409 
diff:	b-a: 4607	c-a: 4608	c-b: 1
diff2:	b2-a2: 22118207	c2-a2: 22127616	c2-b2: 9409
facts a: 97 
facts b: 2 2 2 2 2 3 7 7 
facts c: 5 941 

triple:	98	336	350
sq:	9604	112896	122500
odd:	195	671	699
odds between b and c: 673 675 677 679 681 683 685 687 689 691 693 695 697 699 
diff:	b-a: 238	c-a: 252	c-b: 14
diff2:	b2-a2: 103292	c2-a2: 112896	c2-b2: 9604
facts a: 2 7 7 
facts b: 2 2 2 2 3 7 
facts c: 2 5 5 7 

triple:	98	2400	2402
sq:	9604	5760000	5769604
odd:	195	4799	4803
odds between b and c: 4801 4803 
diff:	b-a: 2302	c-a: 2304	c-b: 2
diff2:	b2-a2: 5750396	c2-a2: 5760000	c2-b2: 9604
facts a: 2 7 7 
facts b: 2 2 2 2 2 3 5 5 
facts c: 2 1201 

triple:	99	132	165
sq:	9801	17424	27225
odd:	197	263	329
odds between b and c: 265 267 269 271 273 275 277 279 281 283 285 287 289 291 293 295 297 299 301 303 305 307 309 311 313 315 317 319 321 323 325 327 329 
diff:	b-a: 33	c-a: 66	c-b: 33
diff2:	b2-a2: 7623	c2-a2: 17424	c2-b2: 9801
facts a: 3 3 11 
facts b: 2 2 3 11 
facts c: 3 5 11 

triple:	99	168	195
sq:	9801	28224	38025
odd:	197	335	389
odds between b and c: 337 339 341 343 345 347 349 351 353 355 357 359 361 363 365 367 369 371 373 375 377 379 381 383 385 387 389 
diff:	b-a: 69	c-a: 96	c-b: 27
diff2:	b2-a2: 18423	c2-a2: 28224	c2-b2: 9801
facts a: 3 3 11 
facts b: 2 2 2 3 7 
facts c: 3 5 13 

triple:	99	440	451
sq:	9801	193600	203401
odd:	197	879	901
odds between b and c: 881 883 885 887 889 891 893 895 897 899 901 
diff:	b-a: 341	c-a: 352	c-b: 11
diff2:	b2-a2: 183799	c2-a2: 193600	c2-b2: 9801
facts a: 3 3 11 
facts b: 2 2 2 5 11 
facts c: 11 41 

triple:	99	540	549
sq:	9801	291600	301401
odd:	197	1079	1097
odds between b and c: 1081 1083 1085 1087 1089 1091 1093 1095 1097 
diff:	b-a: 441	c-a: 450	c-b: 9
diff2:	b2-a2: 281799	c2-a2: 291600	c2-b2: 9801
facts a: 3 3 11 
facts b: 2 2 3 3 3 5 
facts c: 3 3 61 

triple:	99	1632	1635
sq:	9801	2663424	2673225
odd:	197	3263	3269
odds between b and c: 3265 3267 3269 
diff:	b-a: 1533	c-a: 1536	c-b: 3
diff2:	b2-a2: 2653623	c2-a2: 2663424	c2-b2: 9801
facts a: 3 3 11 
facts b: 2 2 2 2 2 3 17 
facts c: 3 5 109 

triple:	99	4900	4901
sq:	9801	24010000	24019801
odd:	197	9799	9801
odds between b and c: 9801 
diff:	b-a: 4801	c-a: 4802	c-b: 1
diff2:	b2-a2: 24000199	c2-a2: 24010000	c2-b2: 9801
facts a: 3 3 11 
facts b: 2 2 5 5 7 7 
facts c: 13 13 29 

triple:	100	105	145
sq:	10000	11025	21025
odd:	199	209	289
odds between b and c: 211 213 215 217 219 221 223 225 227 229 231 233 235 237 239 241 243 245 247 249 251 253 255 257 259 261 263 265 267 269 271 273 275 277 279 281 283 285 287 289 
diff:	b-a: 5	c-a: 45	c-b: 40
diff2:	b2-a2: 1025	c2-a2: 11025	c2-b2: 10000
facts a: 2 2 5 5 
facts b: 3 5 7 
facts c: 5 29 

triple:	100	240	260
sq:	10000	57600	67600
odd:	199	479	519
odds between b and c: 481 483 485 487 489 491 493 495 497 499 501 503 505 507 509 511 513 515 517 519 
diff:	b-a: 140	c-a: 160	c-b: 20
diff2:	b2-a2: 47600	c2-a2: 57600	c2-b2: 10000
facts a: 2 2 5 5 
facts b: 2 2 2 2 3 5 
facts c: 2 2 5 13 

triple:	100	495	505
sq:	10000	245025	255025
odd:	199	989	1009
odds between b and c: 991 993 995 997 999 1001 1003 1005 1007 1009 
diff:	b-a: 395	c-a: 405	c-b: 10
diff2:	b2-a2: 235025	c2-a2: 245025	c2-b2: 10000
facts a: 2 2 5 5 
facts b: 3 3 5 11 
facts c: 5 101 

triple:	100	621	629
sq:	10000	385641	395641
odd:	199	1241	1257
odds between b and c: 1243 1245 1247 1249 1251 1253 1255 1257 
diff:	b-a: 521	c-a: 529	c-b: 8
diff2:	b2-a2: 375641	c2-a2: 385641	c2-b2: 10000
facts a: 2 2 5 5 
facts b: 3 3 3 23 
facts c: 17 37 

triple:	100	1248	1252
sq:	10000	1557504	1567504
odd:	199	2495	2503
odds between b and c: 2497 2499 2501 2503 
diff:	b-a: 1148	c-a: 1152	c-b: 4
diff2:	b2-a2: 1547504	c2-a2: 1557504	c2-b2: 10000
facts a: 2 2 5 5 
facts b: 2 2 2 2 2 3 13 
facts c: 2 2 313 

triple:	100	2499	2501
sq:	10000	6245001	6255001
odd:	199	4997	5001
odds between b and c: 4999 5001 
diff:	b-a: 2399	c-a: 2401	c-b: 2
diff2:	b2-a2: 6235001	c2-a2: 6245001	c2-b2: 10000
facts a: 2 2 5 5 
facts b: 3 7 7 17 
facts c: 41 61 


*/


/*
not predictable:

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