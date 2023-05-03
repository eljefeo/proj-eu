
public class Problem76_notes {
	/*
	 It is possible to write five as a sum in exactly six different ways:

		4 + 1
		3 + 2
		3 + 1 + 1
		2 + 2 + 1
		2 + 1 + 1 + 1
		1 + 1 + 1 + 1 + 1
		
	How many different ways can one hundred be written as a sum of at least two positive integers?
	
	
	 */
	
	/*
	 * NOTES:
	 * 
	 
	 Ok so after some looking up of different integer partitions I stumbled across euler's equation with naturals and odds and how to get 
	 the partition number for an integer. Im kinda sad that I found it cause I was trying to avoid spoilers but I am also kinda glad
	 that I found it because damn that pattern would have taken me years to find. So I guess this is the point in the projecteuler questions
	 where I may need to start looking up some of these principles. I will still try to figure out each question on my own going forward
	 but if I need help I can try to investigate the principles.
	 anyways Im going to use eulers equation 
	 -------------
	 ok so Ive been playing around with recursion a few times, and I know there is a better way still. 
	 Yes it has gotten a bit better and more efficient but we are still missing a good way to do it.
	 I am going to go back to the drawing board with the other idea of a forumla to just figure out every number.
	 Except this time instead of just entering 100 and getting the answer back from some magical formula, lets try to figure
	 out this:
	 
	 We can see that every number below has the next number inside it, and some new values added
	 
	 
	 So. After you look at these numbers below, you can see that we just get the number before, and add 1 to the end 
	 of each of its options. Now, sometimes that 1 at the end does nothing, it stays a 1 at the end. But sometimes that 
	 1 at the end can be combined into something new. The new ones are always the ones you see that DO NOT end with 1
	 so for 4, the new one is always the number itself (4 is new) but there is also a new 2 2
	 and with 5, the new one (other than 5 itself) is 3 2
	 and with 6 the new ones are 4 2, 3 3, 2 2 2. 
	 
	 So how do we figure out all the things that are going to be new, or at least how many new ones there are going to be. 
	 
	 
	 for the examples below I have the old nums in parentheses
	 
	 like 2 has:
	  
	 	2	
		1 1
	 
	 and 3 has 
	 
	 	 3
	 	(2) 1
		(1 1) 1
	
	 and 4 has: 5
	 
	 	(3) 1
	 	 2 2
	 	(2 1) 1
		(1 1 1) 1
		
		
		5 has: 7
		
		 5
		(4) 1
		 3 2
		(3 1) 1
		(2 2) 1
		(2 1 1) 1
		(1 1 1 1) 1	
	
	 
	 	6 has : 11
	 	 6
		(5) 1
		 4 2
		(4 1) 1
		 3 3
		(3 2) 1
		(3 1 1) 1
		 2 2 2
		(2 2 1) 1
		(2 1 1 1) 1
		(1 1 1 1 1) 1
		
	7 has: 15
		
		7
		(6) 1
		 5 2
		(5 1) 1
		 4 3
		(4 2) 1
		(4 1 1) 1
		(3 3) 1
		 3 2 2
		(3 2 1) 1
		(3 1 1 1) 1
		(2 2 2) 1
		(2 2 1 1) 1
		(2 1 1 1 1) 1
		(1 1 1 1 1 1) 1
	
	8: 22
	new ones would be 
	8
	6 2
	5 3
	4 4
	4 2 2
	3 3 2
	2 2 2 2
	
	9..new ones would be: 30
	
	9
	7 2
	6 3
	5 4
	5 2 2
	4 3 2
	3 3 3
	3 2 2 2 
	
	10: 42
	
	10
	8 2
	7 3
	6 4
	5 5
	4 4 2
	4 3 3
	4 2 2 2 2
	3 3 2 2
	2 2 2 2 2
	
	 11: 56 :: 14 new
	 	11
		9 2
		8 3
		7 4
		7 2 2
		6 5
		6 3 2
		5 4 2
		5 3 3
		5 2 2 2
		4 4 3
		4 3 2 2
		3 3 3 2
		3 2 2 2 2
		
		12: 77 ways :: 21 new
	-	12
		11 1
	-	10 2
		10 1 1
	-	9 3
		9 2 1
		9 1 1 1
	-	8 4
		8 3 1
	-	8 2 2
		8 2 1 1
		8 1 1 1 1
	-	7 5
		7 4 1
	-	7 3 2
		7 3 1 1
		7 2 2 1
		7 2 1 1 1
		7 1 1 1 1 1
	-	6 6
		6 5 1
		6 4 2
		6 4 1 1
	-	6 3 3
		6 3 2 1
		6 3 1 1 1
	-	6 2 2 2
		6 2 2 1 1
		6 2 1 1 1 1
		6 1 1 1 1 1 1
	-	5 5 2
		5 5 1 1
	-	5 4 3
		5 4 2 1
		5 4 1 1 1
		5 3 3 1
	-	5 3 2 2
		5 3 2 1 1
		5 3 1 1 1 1
		5 2 2 2 1
		5 2 2 1 1 1
		5 2 1 1 1 1 1
		5 1 1 1 1 1 1 1
	-	4 4 4
		4 4 3 1
	-	4 4 2 2
		4 4 2 1 1
		4 4 1 1 1 1
	-	4 3 3 2
		4 3 3 1 1
		4 3 2 2 1
		4 3 2 1 1 1
		4 3 1 1 1 1 1
	-	4 2 2 2 2
		4 2 2 2 1 1
		4 2 2 1 1 1 1
		4 2 1 1 1 1 1 1
		4 1 1 1 1 1 1 1 1
	-	3 3 3 3
		3 3 3 2 1
		3 3 3 1 1 1
	-	3 3 2 2 2
		3 3 2 2 1 1
		3 3 2 1 1 1 1
		3 3 1 1 1 1 1 1
		3 2 2 2 2 1
		3 2 2 2 1 1 1
		3 2 2 1 1 1 1 1
		3 2 1 1 1 1 1 1 1
		3 1 1 1 1 1 1 1 1 1
	-	2 2 2 2 2 2
		2 2 2 2 2 1 1
		2 2 2 2 1 1 1 1
		2 2 2 1 1 1 1 1 1
		2 2 1 1 1 1 1 1 1 1
		2 1 1 1 1 1 1 1 1 1 1
		1 1 1 1 1 1 1 1 1 1 1 1
	
	13: 101 ways :: 34 new ones?
		 13
		12 1
		11 2
		11 1 1
		10 3
		10 2 1
		10 1 1 1
		9 4
		9 3 1
		9 2 2
		9 2 1 1
		9 1 1 1 1
		8 5
		8 4 1
		8 3 2
		8 3 1 1
		8 2 2 1
		8 2 1 1 1
		8 1 1 1 1 1
		7 6
		7 5 1
		7 4 2
		7 4 1 1
		7 3 3
		7 3 2 1
		7 3 1 1 1
		7 2 2 2
		7 2 2 1 1
		7 2 1 1 1 1
		7 1 1 1 1 1 1
		6 6 1
		6 5 2
		6 5 1 1
		6 4 3
		6 4 2 1
		6 4 1 1 1
		6 3 3 1
		6 3 2 2
		6 3 2 1 1
		6 3 1 1 1 1
		6 2 2 2 1
		6 2 2 1 1 1
		6 2 1 1 1 1 1
		6 1 1 1 1 1 1 1
		5 5 3
		5 5 2 1
		5 5 1 1 1
		5 4 4
		5 4 3 1
		5 4 2 2
		5 4 2 1 1
		5 4 1 1 1 1
		5 3 3 2
		5 3 3 1 1
		5 3 2 2 1
		5 3 2 1 1 1
		5 3 1 1 1 1 1
		5 2 2 2 2
		5 2 2 2 1 1
		5 2 2 1 1 1 1
		5 2 1 1 1 1 1 1
		5 1 1 1 1 1 1 1 1
		4 4 4 1
		4 4 3 2
		4 4 3 1 1
		4 4 2 2 1
		4 4 2 1 1 1
		4 4 1 1 1 1 1
		4 3 3 3
		4 3 3 2 1
		4 3 3 1 1 1
		4 3 2 2 2
		4 3 2 2 1 1
		4 3 2 1 1 1 1
		4 3 1 1 1 1 1 1
		4 2 2 2 2 1
		4 2 2 2 1 1 1
		4 2 2 1 1 1 1 1
		4 2 1 1 1 1 1 1 1
		4 1 1 1 1 1 1 1 1 1
		3 3 3 3 1
		3 3 3 2 2
		3 3 3 2 1 1
		3 3 3 1 1 1 1
		3 3 2 2 2 1
		3 3 2 2 1 1 1
		3 3 2 1 1 1 1 1
		3 3 1 1 1 1 1 1 1
		3 2 2 2 2 2
		3 2 2 2 2 1 1
		3 2 2 2 1 1 1 1
		3 2 2 1 1 1 1 1 1
		3 2 1 1 1 1 1 1 1 1
		3 1 1 1 1 1 1 1 1 1 1
		2 2 2 2 2 2 1
		2 2 2 2 2 1 1 1
		2 2 2 2 1 1 1 1 1
		2 2 2 1 1 1 1 1 1 1
		2 2 1 1 1 1 1 1 1 1 1
		2 1 1 1 1 1 1 1 1 1 1 1
		1 1 1 1 1 1 1 1 1 1 1 1 1
	 
	 	
	 
	
	 
	 
	
	///////////	///////////
	 
	 
	 13:
	 Lets try 13 again....
	 
	 N-1 = 1
	 N-2 = 2
	 
	 N-3 = 3
	 N-4 = 5
	 N5 = 7
	 N6 = 11
	 N-7....
	 so here we break. because once we get past halfway, in other words once we are subtracting more than we have left..
	 	we break stuff.
	 	
	 we end up skipping things.
	 N-7, normally 7 would be 15.
	 but..this leaves only 6, instead of 7. (if we were doing 14, 14-7 would be 7, and we already know 7 is 15)
	 but we 13-7 leaves 6, it really leaves 6 1
	 so its like if we did 7, but we skip the 7 and start at the 6 1
	 
	 so is it 7 - 6 = 1, so we skip N-0? so 15 - 1 = 14? WE skip UP TO N-1, dont include n-1
	 N-7 = 14
	 
	 
	 
	 N-8 = 5. 
	 so we skipped 8-5 = 3, we skipped *up to* n-3?
	 				n0 = 1, n1 = 1, n2 = 2
	 				so since 8 normally is 22, we skip 1+1+2. we skipped 4? so we keep 18?
	 				no we skipped only n-1 and n-2..
	 				so we skipped 4, 
	 N-8 = 18
	 
	 
	 
	 N-9 
	 	= 4
	 since 9 > 4, we skip n0, n1, n2, n3 ,, 1 1 2 3, we skip ?
	 9-4 = 5, so we skip up to n-5 (we skip n0 n1 n2 n3 n4)
	 since 9 is normally  30
	 we skipped 1 1 2 3 5 ? skipped 12 ---> notice here we were able to easily just add the normal n0 n1 n2 n3 n4 because n4 is not more than half of 9
	 so we keep 18?
	 N-9 = 18
	 
	 N-10 
	 	= 3
	 so 10 - 3 = 7
	 we skip up to n7, not including, skip n0 n1 n2 n3 n4 n5 n6
	 since 10 is normally 42, we skip to 7
	 so skip n0 n1 n2 n3 n4 n5 n6, skip 1 1 2 3 5 7 11
	 skip 30?
	 so we 42 - 30, keep 12?
	 ** actually no this doesnt work, because yes normally 10 is 42. 
	 *	but when we say we skip n-6, normally 6 is 11, but for the number 10... n-6 is actually only 9
	 *			because in 10, N-6 is more than half so n-6 for 10 actually skips a couple of its own!!!!
	 *		wow this really throws it all off.
	 *		that means we need to calculate N-6 for 10, then we can subtract that from our N-10 for 13...
	 *		so N-6 of 10 **** 10 - 6 (yep more than half) = 4, 6-4 = 2, skip n0=1, n1=1
	 *					so N-6 of 10 is (normally 6 is 11, but subtract 2, we get 9) = 9
	 *
	 *		so back to N-10 of 13. subtract n0 n1 n2 n3 n4 n5 n6, 1 1 2 3 5 7 *9*
	 * so 42 - 28 = 14
	 
	 N-10 = 14
	
	
	N-11
		= 2
		so 11 - 2 = 9, skip up to N-9?
		11 is normally 56
		but we skip up to N-9
		n0 = 1, n1=1, n2=2, n3=3, n4=5, n5=7, n6... 
		n6 is over half of 11.
			so how do we find n6 of 11
				well normally 6 is 11, but we skip 11-6 = 5... 6-5 = 1, looks like only skip n0 = 1
				so instead of n6 = 11, we skip 1.. so its 10
			
		so all that just to do N6 of 11, 
		
		back to N-11 for 13
		skip n0 = 1, n1=1, n2=2, n3=3, n4=5, n5=7, n6=10, n7 = ...
					 so now we gotta find n7 of 11...
					 11 - 7 = 4, and 7-4 = 3.
					 so skip n0 n1 n2
					 skip  1 1 2. Since 7 is normally 15, we skip 4 and leaves 11
					 
		back to N-11 for 13
			skip n0 = 1, n1=1, n2=2, n3=3, n4=5, n5=7, n6=10, n7 = 11, N-8 = ??
			gotta do N-8 of 11
			11 - 8 = 3, 8 -3 = 5
			so do N8 (normally 22) but skip up to n5?
			n0 = 1, n1 = 1, n2 = 2, n3 = 3, n4 = 5.. skip 12? so 22 - 12 = 10?
		
		so back to N-11 for 13:
		13-11 = 2. 11 - 2 = 9
		gotta do 11, but skip up to N-9
		11 is normally 56, but we skip  n0 = 1, n1=1, n2=2, n3=3, n4=5, n5=7, n6=10, n7 = 11, N-8 = 10
			so we skip 1 1 2 3 5 7 10 11 10
			skip 50
			
		so N-11 for 13 is (56 - 50 = 6)?
		Yep , 
		N-11 = 6
		
		lastly 
		N-12
		here I guess we could go through the motions, but if we are at the last num(doing N-12 for 13)
			then we know there is only 1 option. 
		N-12 = 1
		
		ok so what is the total:
	 N-1 = 1
	 N-2 = 2
	 N-3 = 3
	 N-4 = 5
	 N5 = 7
	 N6 = 11
	 N-7 = 14
	 N-8 = 18
	 N-9 = 18
	 N-10 = 14
	 N-11 = 6
	 N-12 = 1
	 ----------
	 === 100
	 and since we count the original number 13 itselft
	 we get 101
	 
	 //yep we got the correct answer, 101 for 13
	  * 
	  * 
	 
	 
	 
	 now can go from 1 up?
	 
	 like if we start knowing 1=1, 2=2, 3=3
	 what if we want to do 4, 5, 6 etc..
	 
	 4:::
	 n0 = 1
	 n1 = 1
	 n2 = 2
	 n3 = last one, we can just assume this is 1
	 so 4 = 5 (including the 4 itself)
	 
	 5: 
	 n0 = 1
	 n1 = 1
	 n2 = 2
	 n3 > half
	 	this means its not all of the 3, which is normally 3
	 	5-3 = 2, 3 - 2 = 1 --- this means skip up to n1, so just skip n0=1
	 	so instead of 3=3, we subtract 1, so 3-1 = 2
	 n3 = 2
	 n4 = last one so this is 1
	 
	 so 5 = 1 1 2 2 1 = 7
	 
	 
	 
	 so can we do some analysis on high numbers and when you have
		to not use the normaly value
		
	like 50:
	you are good from n0 up until n25.
	when you get to n26 you have to minus 1
		so even then you dont have to go another level deep 
			until...lets...if it was n30, it would be to skip 50-30 = 20 and 30-20 = 10, so skip up to n10...nope still good
			
			it would be half of half. So half of 50 is 25, more than half of 50 is 26
				but to have to do that extra level its half of 25, would be I guess when you get to N-13 of 25. 
				so if you are doing n-13, then you have to do extra steps multiple times?
				like 50-13=37. So if you are doing n-37...
				then you are more than half of 50. but to do 37 you would have to do extra steps starting at n-19 for 37
				then to do n19 you would have to do extra steps at n-10 for 19
				then extra steps at n-6 for 10
				then extra steps at n4 for 6
			
	 
	 13: 101 ways
	 13
		12 1
		11 2
		11 1 1
		10 3
		10 2 1
		10 1 1 1
		9 4
		9 3 1
		9 2 2
		9 2 1 1
		9 1 1 1 1
		8 5
		8 4 1
		8 3 2
		8 3 1 1
		8 2 2 1
		8 2 1 1 1
		8 1 1 1 1 1
		7 6
		7 5 1
		7 4 2
		7 4 1 1
		7 3 3
		7 3 2 1
		7 3 1 1 1
		7 2 2 2
		7 2 2 1 1
		7 2 1 1 1 1
		7 1 1 1 1 1 1
		6 6 1
		6 5 2
		6 5 1 1
		6 4 3
		6 4 2 1
		6 4 1 1 1
		6 3 3 1
		6 3 2 2
		6 3 2 1 1
		6 3 1 1 1 1
		6 2 2 2 1
		6 2 2 1 1 1
		6 2 1 1 1 1 1
		6 1 1 1 1 1 1 1
		5 5 3
		5 5 2 1
		5 5 1 1 1
		5 4 4
		5 4 3 1
		5 4 2 2
		5 4 2 1 1
		5 4 1 1 1 1
		5 3 3 2
		5 3 3 1 1
		5 3 2 2 1
		5 3 2 1 1 1
		5 3 1 1 1 1 1
		5 2 2 2 2
		5 2 2 2 1 1
		5 2 2 1 1 1 1
		5 2 1 1 1 1 1 1
		5 1 1 1 1 1 1 1 1
		4 4 4 1
		4 4 3 2
		4 4 3 1 1
		4 4 2 2 1
		4 4 2 1 1 1
		4 4 1 1 1 1 1
		4 3 3 3
		4 3 3 2 1
		4 3 3 1 1 1
		4 3 2 2 2
		4 3 2 2 1 1
		4 3 2 1 1 1 1
		4 3 1 1 1 1 1 1
		4 2 2 2 2 1
		4 2 2 2 1 1 1
		4 2 2 1 1 1 1 1
		4 2 1 1 1 1 1 1 1
		4 1 1 1 1 1 1 1 1 1
		3 3 3 3 1
		3 3 3 2 2
		3 3 3 2 1 1
		3 3 3 1 1 1 1
		3 3 2 2 2 1
		3 3 2 2 1 1 1
		3 3 2 1 1 1 1 1
		3 3 1 1 1 1 1 1 1
		3 2 2 2 2 2
		3 2 2 2 2 1 1
		3 2 2 2 1 1 1 1
		3 2 2 1 1 1 1 1 1
		3 2 1 1 1 1 1 1 1 1
		3 1 1 1 1 1 1 1 1 1 1
		2 2 2 2 2 2 1
		2 2 2 2 2 1 1 1
		2 2 2 2 1 1 1 1 1
		2 2 2 1 1 1 1 1 1 1
		2 2 1 1 1 1 1 1 1 1 1
		2 1 1 1 1 1 1 1 1 1 1 1
		1 1 1 1 1 1 1 1 1 1 1 1 1
	 
	 12: 76 ways
	 12
		11 1
		10 2
		10 1 1
		9 3
		9 2 1
		9 1 1 1
		8 4
		8 3 1
		8 2 2
		8 2 1 1
		8 1 1 1 1
		7 5
		7 4 1
		7 3 2
		7 3 1 1
		7 2 2 1
		7 2 1 1 1
		7 1 1 1 1 1
		6 6
		6 5 1
		6 4 2
		6 4 1 1
		6 3 3
		6 3 2 1
		6 3 1 1 1
		6 2 2 2
		6 2 2 1 1
		6 2 1 1 1 1
		6 1 1 1 1 1 1
		5 5 2
		5 5 1 1
		5 4 3
		5 4 2 1
		5 4 1 1 1
		5 3 3 1
		5 3 2 2
		5 3 2 1 1
		5 3 1 1 1 1
		5 2 2 2 1
		5 2 2 1 1 1
		5 2 1 1 1 1 1
		5 1 1 1 1 1 1 1
		4 4 4
		4 4 3 1
		4 4 2 2
		4 4 2 1 1
		4 4 1 1 1 1
		4 3 3 2
		4 3 3 1 1
		4 3 2 2 1
		4 3 2 1 1 1
		4 3 1 1 1 1 1
		4 2 2 2 2
		4 2 2 2 1 1
		4 2 2 1 1 1 1
		4 2 1 1 1 1 1 1
		4 1 1 1 1 1 1 1 1
		3 3 3 3
		3 3 3 2 1
		3 3 3 1 1 1
		3 3 2 2 2
		3 3 2 2 1 1
		3 3 2 1 1 1 1
		3 3 1 1 1 1 1 1
		3 2 2 2 2 1
		3 2 2 2 1 1 1
		3 2 2 1 1 1 1 1
		3 2 1 1 1 1 1 1 1
		3 1 1 1 1 1 1 1 1 1
		2 2 2 2 2 2
		2 2 2 2 2 1 1
		2 2 2 2 1 1 1 1
		2 2 2 1 1 1 1 1 1
		2 2 1 1 1 1 1 1 1 1
		2 1 1 1 1 1 1 1 1 1 1
		1 1 1 1 1 1 1 1 1 1 1 1
	 
	 11: 56
	 11
		10 1
		9 2
		9 1 1
		8 3
		8 2 1
		8 1 1 1
		7 4
		7 3 1
		7 2 2
		7 2 1 1
		7 1 1 1 1
		6 5
		6 4 1
		6 3 2
		6 3 1 1
		6 2 2 1
		6 2 1 1 1
		6 1 1 1 1 1
		5 5 1
		5 4 2
		5 4 1 1
		5 3 3
		5 3 2 1
		5 3 1 1 1
		5 2 2 2
		5 2 2 1 1
		5 2 1 1 1 1
		5 1 1 1 1 1 1
		4 4 3
		4 4 2 1
		4 4 1 1 1
		4 3 3 1
		4 3 2 2
		4 3 2 1 1
		4 3 1 1 1 1
		4 2 2 2 1
		4 2 2 1 1 1
		4 2 1 1 1 1 1
		4 1 1 1 1 1 1 1
		3 3 3 2
		3 3 3 1 1
		3 3 2 2 1
		3 3 2 1 1 1
		3 3 1 1 1 1 1
		3 2 2 2 2
		3 2 2 2 1 1
		3 2 2 1 1 1 1
		3 2 1 1 1 1 1 1
		3 1 1 1 1 1 1 1 1
		2 2 2 2 2 1
		2 2 2 2 1 1 1
		2 2 2 1 1 1 1 1
		2 2 1 1 1 1 1 1 1
		2 1 1 1 1 1 1 1 1 1
		1 1 1 1 1 1 1 1 1 1 1
	 
	 10: 42
	 10
		9 1
		8 2
		8 1 1
		7 3
		7 2 1
		7 1 1 1
		6 4
		6 3 1
		6 2 2
		6 2 1 1
		6 1 1 1 1
		5 5
		5 4 1
		5 3 2
		5 3 1 1
		5 2 2 1
		5 2 1 1 1
		5 1 1 1 1 1
		4 4 2
		4 4 1 1
		4 3 3
		4 3 2 1
		4 3 1 1 1
		4 2 2 2
		4 2 2 1 1
		4 2 1 1 1 1
		4 1 1 1 1 1 1
		3 3 3 1
		3 3 2 2
		3 3 2 1 1
		3 3 1 1 1 1
		3 2 2 2 1
		3 2 2 1 1 1
		3 2 1 1 1 1 1
		3 1 1 1 1 1 1 1
		2 2 2 2 2
		2 2 2 2 1 1
		2 2 2 1 1 1 1
		2 2 1 1 1 1 1 1
		2 1 1 1 1 1 1 1 1
		1 1 1 1 1 1 1 1 1 1
	 
	 9: 30
	 9
		8 1
		7 2
		7 1 1
		6 3
		6 2 1
		6 1 1 1
		5 4
		5 3 1
		5 2 2
		5 2 1 1
		5 1 1 1 1
		4 4 1
		4 3 2
		4 3 1 1
		4 2 2 1
		4 2 1 1 1
		4 1 1 1 1 1
		3 3 3
		3 3 2 1
		3 3 1 1 1
		3 2 2 2
		3 2 2 1 1
		3 2 1 1 1 1
		3 1 1 1 1 1 1
		2 2 2 2 1
		2 2 2 1 1 1
		2 2 1 1 1 1 1
		2 1 1 1 1 1 1 1
		1 1 1 1 1 1 1 1 1
		
	 8: 22 ways
	 8
		7 1
		6 2
		6 1 1
		5 3
		5 2 1
		5 1 1 1
		4 4
		4 3 1
		4 2 2
		4 2 1 1
		4 1 1 1 1
		3 3 2
		3 3 1 1
		3 2 2 1
		3 2 1 1 1
		3 1 1 1 1 1
		2 2 2 2
		2 2 2 1 1
		2 2 1 1 1 1
		2 1 1 1 1 1 1
		1 1 1 1 1 1 1 1
		
	7: 15
	7
		6 1
		5 2
		5 1 1
		4 3
		4 2 1
		4 1 1 1
		3 3 1
		3 2 2
		3 2 1 1
		3 1 1 1 1
		2 2 2 1
		2 2 1 1 1
		2 1 1 1 1 1
		1 1 1 1 1 1 1
		
	6: 11
	6
		5 1
		4 2
		4 1 1
		3 3
		3 2 1
		3 1 1 1
		2 2 2
		2 2 1 1
		2 1 1 1 1
		1 1 1 1 1 1
		
	5: 7
	5
		4 1
		3 2
		3 1 1
		2 2 1
		2 1 1 1
		1 1 1 1 1	
		
	4: 5
	4
		3 1
		2 2
		2 1 1
		1 1 1 1
		
		
		
	3: 3 ways
	3
		2 1
		1 1 1
	
	2: 2 ways
	2	
		1 1
		
	1:
	1
		
	 */
	 
	 
	 
	 
	
}
