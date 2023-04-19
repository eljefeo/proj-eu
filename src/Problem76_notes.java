
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
	 -------- I visualize 5 like this: --------
	 
	 1 1 1 1 1 :: 1st way (five 1's)
	 1 1 1 \ / :: 2nd way (three 1's and a 2)
	        2
	 1 \ /  
	    2   2  :: 3rd way (one 1 and two 2's)
	    
	 (cant combine that last 1 with anything, so back to all 1's 1 1 1 1 1)
	 1 1 \ | /
	       3  :: 4th way (two 1's and a 3)
	 \ /   
	  2    3  :: 5th way (one 2 and one 3)
	    
	 (nothing left to combine.. so back to all 1's)
	 1 \ \ / /
	      4   :: 6th way (one 1 and one 4)
	      
	 (nothing left to combine, and we cant go to the next number, 5, because thats the starting number)
	 
	 we are done, we found 6 ways to do it.
	   
	 */
	
	/*
	 -------- I visualize 6 it like this: --------
	 6:
	 1 1 1 1 1 1 :: 1st way (6 1's)
	 1 1 1 1 \ / :: 2nd way (four 1's and a 2)
	          2
	 1 1 \ /  
	      2   2  :: 3rd way (two 1 and two 2's)
	      
	 \ /   
	  2   2   2  :: 4rd way (three 2's)
	    
	 (cant combine anything else as 2's, so back to all 1's 1 1 1 1 1)
	 1 1 1 \ | /
	         3  :: 5th way (three 1's and a 3)
	 
	 1 1 1 \ | /
	 \ | /
	   3     3  :: 6th way (two 3's)
	   
	 (nothing left to combine, but we need to check that 3 on the right again, it can become a 2 and a 1)
	 1 1 1 \ | /
	   \ /
	    2    3  :: 7th way (one 1, one 2, and a 3)
	    
	 (cant combine that last 1, and now we are all the way on the left and are doing combos of 2, so we are done with the 3, back to all 1's)
	 
	 1 1 \ \ / /
	        4   :: 8th way (two 1's and one 4)
	 
	 
	 
	 \ /   
	  2     4   :: 9th way (one 2 and one 3)
	    
	 (nothing left to combine.. so back to all 1's)
	 
	 1 \ \ | / /
	       5    :: 10th way (one 1 and one 5)
	       
	 (cant combine that 1 with anything, and we are at 5 which is 1 less than the starting number, so we are complete now) 
	 10 ways for the number 6

	   
	 */
	
	
	/*
	 ways to make 5:
		2 + 3
		1 + 4
		1 + 1 + 3
		1 + 2 + 2
		1 + 1 + 1 + 2
		1 + 1 + 1 + 1 + 1
		
	ways to make 4:
		2 + 2
		1 + 3
		1 + 1 + 2
		1 + 1 + 1 + 1
		
	ways to make 3:

		1 + 2
		1 + 1 + 1
		
	ways to make 2: 
		1 + 1
		
		
		
		
	 */
	
	/*
	 So for 8:
	 we can go down or up...
	 heres down:
	 1 7
	 //Then we lower the right side by one, and try to fill up the slots on the left with 
	 // 	all numbers high to low that can fit on the left
	 // and we go left to right
	 2 6
	 1 1 6 - now that we have the 6 on the right, and the left side is all 1's then we are done with 6 on the right
	 so now we lower the 6 to 5 and do it again
	 3 5 - remember lower the left  to 5 and fill the left with the highest number you can 5 or less
	 now we keep breaking it down left to right
	 1 2 5
	 1 1 1 5 - now we have all 1's on the left, so lower the 5 to 4 and keep going
	 4 4 - we lowered 5 to 4 and we fill the left side with highest numbers, 4 or less
	 1 3 4 - this is becuase we were at 4, then we lower that to 3 (always lower it 1 by 1, left to right)
	 2 2 4 - since we lowered to 3, and there was no more room to lower anything so we went from 3 to 2
	 1 1 2 4
	 1 1 1 1 4 - now we are all 1's on the left, we lower the 4 to 3
	 2 3 3 - 4 went to 3 on the left, then fill the right with highest numbers you can 3 or less
	 1 1 3 3
	 1 2 2 3 - that first 3 from the left side is what we lower to 2, which now allows another 2 (highest we can fit) then 1 to finish
	 remember starting from left to right, the number should always be at or below the number to its right
	 there should never be a number with a lower number to the right of it anywhere
	 1 1 1 2 3
	 1 1 1 1 1 3 - now we have all 1's again, so lower the 3 to 2 on the far right, and go again
	 2 2 2 2 - and remember that new 2 all the way on the right, fill in all slots to the left of it with highest number at or below it (2)
	 1 1 2 2 2 - then go left to right lowering the number
	 1 1 1 1 2 2
	 1 1 1 1 1 1 2
	 1 1 1 1 1 1 1 1 
	 
	 we found 21 ways for the number 8!
	 
	 By using this method I have come up with the following:
	 
	 10 - 39 ways (need to double check)
	 9 - 29
	 8 - 21
	 7 - 14
	 6 - 10
	 5 - 6
	 4 - 4
	 3 - 2
	 2 - 1
	 
	 */
	
	/*
	 11:
	 
	 1 10
	 2 9
	 1 1 9
	 3 8
	 1 2 8 
	 1 1 1 8
	 4 7
	 1 3 7
	 2 2 7
	 1 1 2 7
	 1 1 1 1 7
	 5 6
	 1 4 6
	 2 3 6
	 1 1 3 6
	 1 2 2 6
	 1 1 1 2 6
	 1 1 1 1 1 6
	 1 5 5
	 2 4 5
	 1 1 4 5
	 3 3 5
	 1 2 3 5
	 1 1 1 3 5
	 2 2 2 5
	 1 1 2 2 5
	 1 1 1 1 2 5
	 1 1 1 1 1 1 5
	 3 4 4
	 1 2 4 4 
	 1 1 1 4 4 
	 1 3 3 4
	 2 2 3 4
	 1 1 2 3 4
	 1 1 1 1 3 4
	 1 2 2 2 4
	 1 1 1 2 2 4
	 1 1 1 1 1 2 4
	 1 1 1 1 1 1 1 4
	 2 3 3 3
	 1 1 3 3 3
	 1 2 2 3 3
	 1 1 1 2 3 3
	 1 1 1 1 1 3 3
	 2 2 2 2 3
	 1 1 2 2 2 3
	 1 1 1 1 2 2 3
	 1 1 1 1 1 1 2 3
	 1 1 1 1 1 1 1 1 3
	 1 2 2 2 2 2
	 1 1 1 2 2 2 2
	 1 1 1 1 1 2 2 2
	 1 1 1 1 1 1 1 2 2
	 1 1 1 1 1 1 1 1 1 2
	 1 1 1 1 1 1 1 1 1 1 1
	 
	 55 ways for 11?
	 
	 1	2	3	4	5	6	7	8	9
	 --------------------------------
	 1	5	10	11	10	7	5	3	2	1
	 
	 
	 
	 10:
	 1 9						1 9
	 2 8
	 1 1 8						2 8s
	 3 7
	 1 2 7						3 7s
	 1 1 1 7
	 4 6
	 1 3 6
	 2 2 6						5 6s
	 1 1 2 6
	 1 1 1 1 6
	 1 4 5
	 2 3 5
	 1 1 3 5					6 5s
	 1 2 2 5
	 1 1 1 2 5
	 1 1 1 1 1 5
	 2 4 4
	 1 1 4 4
	 3 3 4
	 1 2 3 4					9 4s
	 1 1 1 3 4
	 2 2 2 4
	 1 1 2 2 4
	 1 1 1 1 2 4
	 1 1 1 1 1 1 4
	 1 3 3 3 
	 2 2 3 3 
	 1 1 2 3 3 
	 1 1 1 1 3 3 				8 3s
	 1 2 2 2 3
	 1 1 1 2 2 3
	 1 1 1 1 1 2 3
	 1 1 1 1 1 1 1 3
	 2 2 2 2 2
	 1 1 2 2 2 2
	 1 1 1 1 2 2 2				5 2s
	 1 1 1 1 1 1 2 2
	 1 1 1 1 1 1 1 1 2
	 1 1 1 1 1 1 1 1 1 1        1 1
	 10 has 40 ways
	 
	 occurances starting number (far right side) ... (not sure if this helps, just looking for patterns on how to cheese this problem)
	 1	2	3	4	5	6	7	8	9
	 --------------------------------
	 1	5	8	9	6	5	3	2	1
	 
	 
	 
	 9:
	 1 8						1 8
	 2 7
	 1 1 7						2 7s
	 3 6
	 1 2 6						3 6s
	 1 1 1 6
	 4 5
	 1 3 5
	 2 2 5						5 5s
	 1 1 2 5
	 1 1 1 1 5
	 1 4 4
	 2 3 4
	 1 1 3 4
	 1 2 2 4					6 4s
	 1 1 1 2 4
	 1 1 1 1 1 4
	 3 3 3 
	 1 2 3 3 
	 1 1 1 3 3 
	 2 2 2 3
	 1 1 2 2 3					7 3s
	 1 1 1 1 2 3
	 1 1 1 1 1 1 3
	 1 2 2 2 2 
	 1 1 1 2 2 2 
	 1 1 1 1 1 2 2 				4 2s
	 1 1 1 1 1 1 1 2
	 1 1 1 1 1 1 1 1 1 			1 1
	 ::: 9 has 29 ways
	 
	 1	2	3	4	5	6	7	8	9
	 --------------------------------
	 1	4	7	6	5	3	2	1
	 
	 8:
	 1 7						1 7
	 2 6						2 6s
	 1 1 6
	 3 5
	 1 2 5						3 5s
	 1 1 1 5
	 4 4
	 1 3 4
	 2 2 4						5 4s
	 1 1 2 4
	 1 1 1 1 4
	 2 3 3
	 1 1 3 3
	 1 2 2 3					5 3s
	 1 1 1 2 3
	 1 1 1 1 1 3
	 2 2 2 2
	 1 1 2 2 2
	 1 1 1 1 2 2				4 2s
	 1 1 1 1 1 1 2
	 1 1 1 1 1 1 1 1			1 1
	 ::: 8 has 21 ways
	 
	 1	2	3	4	5	6	7	8	9
	 --------------------------------
	 1	4	5	5	3	2	1
	 
	 7:
	 1 6						1 6
	 2 5						2 5s
	 1 1 5
	 3 4 
	 1 2 4						3 4s
	 1 1 1 4
	 1 3 3
	 2 2 3
	 1 1 2 3					4 3s
	 1 1 1 1 3
	 1 2 2 2
	 1 1 1 2 2 					3 2s
	 1 1 1 1 1 2
	 1 1 1 1 1 1 1 				1 1
	 ::: 7 has 14 ways
	 
	 1	2	3	4	5	6	7	8	9
	 --------------------------------
	 1	3	4	3	2	1
	 
	 
	 6:
	 1 5						1 5
	 2 4						2 4s
	 1 1 4
	 3 3 
	 1 2 3 						3 3s
	 1 1 1 3
	 2 2 2 
	 1 1 2 2 					3 2s
	 1 1 1 1 2					
	 1 1 1 1 1 1 				1 1
	 ::: 6 has 10 ways
	 
	 1	2	3	4	5	6	7	8	9
	 --------------------------------
	 1	3	3	2	1
	 
	 5:
	 1 4						1 4
	 2 3						2 3s
	 1 1 3
	 1 2 2 						2 2s
	 1 1 1 1 2	
	 1 1 1 1 1 1				1 1
	 ::: 5 has 6 ways
	 
	 1	2	3	4	5	6	7	8	9
	 --------------------------------
	 1	2	2	1
	 
	  4:
	  1 3 						1 3
	  2 2 
	  1 1 2						2 2s
	  1 1 1 1 					1 1
	  ::: 4 has 4 ways
	  
	 1	2	3	4	5	6	7	8	9
	 --------------------------------
	 1	2	1
	  
	  
	  
	  3:
	  1 2						1 2
	  1 1 1 					1 1
	  ::: 3 has 2 ways
	  
	 1	2	3	4	5	6	7	8	9
	 --------------------------------
	 1	1
	 
	 
	  2:
	  1 1 						1 1
	  ::: 2 has 1 way
	 
	 1	2	3	4	5	6	7	8	9
	 --------------------------------
	 1
	 
	 
	 */
	
	

}
