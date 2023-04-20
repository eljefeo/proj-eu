
public class Problem76 implements Problem{
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

	public static void main(String[] args) {
		Problem p = new Problem76();
		p.runProblem();
		//entry();

	}
	
	/*
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
	 */
	
	@Override
	public Object problem() {
		//entr();
		return vvv(10);
	}
	
	public int vvv (int og) {
		/*
		 so.. if we want to know what N - 2 is gonna be, we need to do 2 first
	 
	 and if we want to do N - 3, we need to find the answer for 3...
	 so what do we do... do we start with 2, then can that give us 3?
	 and then we have enough info for 4, and then 5, and 6 and ....N?
		 */
		int sub = 1;
		int two = 1;
		int[] sols = new int[og + 1];
		sols[2] = 1;
		int count = 0;
		//3.... 3 - 1 = 1, 3 - 2 = (look up above.. 2 = 1) 1 (+1), 
		//then if N-x where x == N, we just add 1 to the final for the 1+1+1+1+1...
		while((og - sub) > 1) {
			//N - 1
			
			//dont forget for 4 we have to do N-1, AND N-2, add both those for the answer to 4
			int miniCount = 0;
			int subTemp = sub;//lets say test is 4. sub is 1
			//so n - 1, look up 1 in the sols[1] that will give you 0, then
			//add 1 so you get 1
			//
			System.out.println("Starting subTemp:  " + subTemp);
			while(subTemp < og) {
				miniCount += sols[subTemp] + 1;
				subTemp++;
				sols[subTemp] = miniCount;
				System.out.println("minicount = " + miniCount + " subtemp: " + subTemp + " sols[subTemp]: "  + sols[subTemp]);
			}
			sub++;
			/*
			int sol = sols[sub];
			count += sol + 1;
			sub++;
			sols[sub] = sol + 1;
			*/
			//System.out.println("in while loop "  + ", sub = " + sub + " sol = " + sol + ", count = " + count);
		}
		
		return count;
		
	}
	public void vv (int runTotal, int sub, int og) {
		/* 5:
		4 + 1
		3 + 2
		3 + 1 + 1
		2 + 2 + 1
		2 + 1 + 1 + 1
		1 + 1 + 1 + 1 + 1
		
		4 - can you add 4 again? no too big
		can you add 3? no too big
		can you add 2? no too big
		can  you add 1?
		yes
		did you get to 5?
		yes
		is your last number 1?
		yes (count it?)
	    then return
	    back to the 4
	    minus to 3
	    can you add 3 again?
	    no too big
	    can you add 2? yes we can
	    are you at 5?
	    yes - (count it?)
	    is your last number 1? 
	    no its 2
	    minus 1, so 2 is 1 now
	    ...
	    is your last number 1
	    yes
	    return
	    is your last number 1
	    yes
	    return
	    is your last number 1
	    no its 3
	    minus to 2
	    can you add 2 again?
	    yes, makes 4
	    can  you add 2 again?
	    no too big
	    can you add 1?
	    yes 
	    is your number 5?
	    yes
	    is your last number 1?
	    yes
	    return
	    is your last number 1?
	    no its 2
	    minus 1 to make 1
	    can you add 1 again?
	    yes
	    is your number 5?
	    no its 3
	    can you add 1 again
	    yes...........
		
		
		*/
		int rightNum = sub - 1; //starts at 4 since 5-1
		int tempRight = rightNum;//where to do this, this num is 4 to start I guess (5 - 1)
		int count = 0;
		int runningTotal = 0;
		/*4 - can you add 4 again? no too big
				can you add 3? no too big
				can you add 2? no too big
				can  you add 1?
				yes
				did you get to 5?
				yes
				is your last number 1?
				yes (count it?)
			    then return
		*/
		
		while(true) {

			int temp = runningTotal + tempRight; // 0 + 4; rightNum starts at 4, starts the highest below og 5;
												// next step is 4 + 4
			
			if(og > temp) {
				runningTotal = temp;	//+= newnum;
				continue;
			} else if(og == temp) {
				//got to 5
				//is your last number 1?
				//		yes (count it?)
				//	    then return
				count++;
				
				if(tempRight == 1) { // is this like the far left number is 1, so we cant reduce/chop it up anymore, so we found one?
					//we get here with 1 4... so what do we do.. we need to get to 2 3 next...
					//so we need to set tempRight to 3 somehow instead of 4
					
					 rightNum--; // should be 3 now, from 4
					 tempRight = rightNum;
					 runningTotal = 0;
					 continue;
					
				} else if(tempRight > 1) { //we  should be able to take out the if here, if its not eq then we can assume its still gt
					// so here... this means we are in a situation like making 5 and we have 2 3. tempRight would be 2, and we can continue to chop it up more..
					//so how do we continue?
					//I guess we started with 4, 
					//we get here with 2 3, tempRight = 2, temp is 5, 
					//so from 2 3, we need to go to 1 1 3... 
					
					
				} else { //tempRight should never be less than 1, either gt or eq
					System.out.println("Should not get here, with tempRight: " + tempRight + ", and rightNum: " + rightNum);
				}
				
				
			} else if(temp > og) {
				// too big
				System.out.println("target num: " + og + ", temp too big: " + temp + ", runningTotal: " + runningTotal + ", tempRight: " + tempRight + " (newnum getting reduced to " + (tempRight-1) + ")");
				tempRight--;// turns to 3
			}
		}
		
		
	}
	
	
	/*
	 if we are at 3 3
	 recur loop 1 ( the far right 3 )
	 original num (6) -3
	 gives us 3
	 
	 func(num){
	 	num is 3
	 	
	 }
	 
	 sub = 3;
	 left = sn - sub;
	 (left is 3)
	 
	 send left back into the recur function
	 woopawAbblyWoopppFlutterWaaawooSHhhh (* sounds of recursion, like going through a black hole time warp *)
	 
	 
	 
	 
	 
	 */
	
	public static void entr() {
		int test = 5;
		int count = 1; //start count with the 1 6
		int sub = test - 1; // 5
		int left = test - sub; //1
		
		//int result = recr666(1, test-1, test);
		int result = recr666(test, "");
		//int result = recr16(1, test-1);
		System.out.println("FINAL for " + test + " : " + result);
	}
	
	public static int recr6666(int n, int og, String els) {
		
		//make 5
		int add = 1;
		int num = 0;
		while (num != n) {
			num += add; //keep adding 1 until we get 10
			//
		}
		return 0;
	}

	public static int recr666(int n, String els) {
		String fff = "";
		int count = 0;//for the 1 and 6
		//int sum = left + right;
		//if(n == 1) {
			//return 0;
			//lower the right
			
			//right--; //5
			//then fill the left with highest you can without going over right number
			// 2 5
			//left++ ;//= sum - right; //left is 2
			
			//but we dont do the right-- and left++ here.
			//we need to return and let the previous call do that
			// or ... do we want to do it here?....................
			//lets try to do it here, lets see what happens
			
			//count++;//for the 2 5 --- do we up the count here? OR cause it will happen at the top when we call it right now..
			//lets let it happen at the top for now I guess, see what happens
			//recr25(left, right); //give this call 2 and 5 so it can find the next one, and up the count when it does
			
			
		//} else if(left > 1) {
			
			for(int i=n-1; i > 0; i--) {
				//like if i is 4
				// then we would send in 4 which would hopefully turn to 3 1, 2 2, 1 1 2, 1 1 1 1 
				//that should give us 4
				//then we should send in 3 which would give us 1 2, 1 1 1 
				//then send in 2, which gives us 1 
				//then the loop looks for greater than 1 so we exit the loop...
				int lleft = n - i;
				els += " " + i;
				fff += " " + i;
				if(i == 1) {
					count++;
					return count;
				}
				
				
				//while() //we can subtract a num... like if we are doing 7 while we can subtract 2, it can go 3 times and 1 left over
				
				System.out.println("Did we get one >> ? " + lleft + " " + i + " :::: " + els);
				//i is right
				System.out.println("in for loop about to call, n: " + n + " i: " + i + " lleft: " + lleft + ", count: " + count);
				int nC = recr666(lleft, els);
				
				count += nC;
				System.out.println("just returned in for loop, n: " + n + " i: " + i + " lleft: " + lleft + ", count: " + count + " nC: " + nC);
			}
			
			//System.out.println("111 Did we get one >> ? " + fff);
			
			//left--;
			
			//recr(,9);
		//} else {
		//	System.out.println("Should not get here, left: " + left + ", right: " + right);
		//}
		
		return count;
		
	}
	
	public static int recr0(int left, int right, int og) {
		/*
		1 1 1 1 1 1 4
	 	1 3 3 3 
	 	2 2 3 3 
	 	1 1 2 3 3 
		 */
		int c = 0;
		
		int subC = 0;
		int ogCopy = og;
		while(ogCopy > 3) {
			ogCopy -= 3;
			subC++;
		}
		
		System.out.println("subc " + subC + " left over: " + ogCopy);
		//we know there are 2 threes, with 1 left over
		//1 3 3 
		
		return c;
	}
	
	public static int recr16(int left, int right) {
		
		int count = 0;//for the 1 and 6
		int sum = left + right;
		if(left == 1) {
			//return 0;
			//lower the right
			
			right--; //5
			//then fill the left with highest you can without going over right number
			// 2 5
			left++ ;//= sum - right; //left is 2
			
			//but we dont do the right-- and left++ here.
			//we need to return and let the previous call do that
			// or ... do we want to do it here?....................
			//lets try to do it here, lets see what happens
			
			count++;//for the 2 5 --- do we up the count here? OR cause it will happen at the top when we call it right now..
			//lets let it happen at the top for now I guess, see what happens
			recr25(left, right); //give this call 2 and 5 so it can find the next one, and up the count when it does
			
			
		} else if(left > 1) {
			
			for(int i=left; i > 1; i--) {
				//like if i is 4
				// then we would send in 4 which would hopefully turn to 3 1, 2 2, 1 1 2, 1 1 1 1 
				//that should give us 4
				//then we should send in 3 which would give us 1 2, 1 1 1 
				//then send in 2, which gives us 1 
				//then the loop looks for greater than 1 so we exit the loop...
				int lleft = left - i;
				//i is right
				//recr16(i);
			}
			
			//left--;
			
			//recr(,9);
		} else {
			System.out.println("Should not get here, left: " + left + ", right: " + right);
		}
		
		return count;
		
	}
	
	public static int recr25(int left, int right) {
		//2 5 come in here, our job to find 1 1 5 I guess
		
		int count = 1;//for the 2 5
		int sum = left + right;
		if(left == 1) {
			//return 0;
			//lower the right
			
			right--; //5
			//then fill the left with highest you can without going over right number
			// 2 5
			left++ ;//= sum - right; //left is 2
			count++;//for the 2 5
			//but we dont do the right-- and left++ here.
			//we need to return and let the previous call do that
			// or ... do we want to do it here?....................
			//lets try to do it here, lets see what happens
			//recrr(left, right); //2 5
			return 0;
			
		} else if(left > 1) {
			int oldRight = right;
			
			left--; //2 becomes 1
			right = left; //right becomes 1
			left = 1;//left becomes 1
			// 1 1 (5)
			count++; // for finding 1 1 5 I guess
			//now what, we just naturally pass in 1, 1 to the next call?
			int rCount = count + recr11(left, right); //0 is returned here + 1 = 1
		} else {
			System.out.println("Should not get here, left: " + left + ", right: " + right);
		}
		
		return count;
		
	}
	
public static int recr11(int left, int right) {
		
		int count = 0;// 1 1 came into this call, our job to find the next one
		// but there is no next one... so we should detect that and return...
		int sum = left + right;
		if(left == 1) {
			//return 0;
			//lower the right
			if(right == 1) {
				return 0;
			}
			
			right--; //5
			
			if(left > right) {
				//since we had 1 2
				// and we took 1 from the right,
				// we want 1 1 1 ...
				//but if we put that 1 on the left it will be 2 1
				//we dont want that...
				//return?
				return count;//I mean I dont know if this is correct, but lets see...
			}
			//then fill the left with highest you can without going over right number
			// 2 5
			left++ ;//= sum - right; //left is 2
			count++;//for the 2 5
			//but we dont do the right-- and left++ here.
			//we need to return and let the previous call do that
			// or ... do we want to do it here?....................
			//lets try to do it here, lets see what happens
			//recrr(left, right); //2 5
			return 0;
			
		} else if(left > 1) {
			
			left--;
			
			recr11(1,left);
		} else {
			System.out.println("Should not get here, left: " + left + ", right: " + right);
		}
		
		return count;
		
	}
	
	
	
	public static int recr22(int left, int right) {
		
		
		/*
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
	*/
		int sum = left + right;
		//left = 1, right = 6
		if(left == 1) {
			//return 0;
			//lower the right
			
			right--; //5
			//then fill the left with highest you can without going over right number
			// 2 5
			left++ ;//= sum - right; //left is 2
			
			if(left > 1) { //true, 2
				int lleft = 1; //minus 1 from left, and put it to the more left
				left--;
				// 1 1 6
				//lleft = 1, left = 1, right = 6
				
				if(lleft == 1) {
					//lleft is 1, need to go to the right of it
					if(left == 1) {
						//left is 1, need to go more to the right
						right--;
						left = sum - right;// left = 4, right = 4
						if(left > 1) {
							lleft = 1;
							left--;
							//left is now 3
							//1 3 4
							
							if(lleft == 1) {
								//go to the right of lleft, which is left
								//take left which is 3, down to 2, and move that 1 to the lleft
								left--;
								lleft++;
								//2 2 4
								
								if(lleft > 1) {
									
								}
									
							}
						}
					}
				}
			}
			
		}
		int count = 0;
		int sn2 = left;
		
		return count;
	}
	
	
	public static int recr1(int sn) {
		
		//if(sn == 1) {
		//	System.out.println("Got 1 .,... going to return 0");
		//	return 0;
		//}
		
		int count = 0;
		int sn2 = sn;
		
		System.out.println("SSSSS to while loop for sn: " + sn + " sn2: " + sn2 + " starting count: " + count);
		while(sn2-- > 1) {
			int left = sn - sn2;
			count++;
			System.out.println("In CALL while loop for sn: " + sn + " ... dcrmnt sn2 to: " + sn2 + " left: " + left + " -- count is now: " + count + " calling recr(" + left + ")");
			int rCount = recr1(left);
			
			count += rCount;
			System.out.println("In RETURNED while loop for sn: " + sn + " ... sn2: " + sn2 + " left: " + left + " -- rCount count: " + rCount + " ::: added rCount, count is now: " + count);
		}
		
		System.out.println("OOOOO of while loop for sn: " + sn + " sn2: " + sn2 + " returning count: " + count);
		return count;
		
	}
	
	//This code doesnt work or do anything yet, 
	public static int recr_2(int sn, int count) {
		//this one will do some stuff, like find out how many ways to make this number
		//but part of finding that out will be to find how manyways to make the smaller numbers inside
		//like this will try to find how many ways to make 6, but part of that is finding out how many
		// 	ways to make 5 in a certain combination, and part of finding out 5 will be to find out 4 in some way etc..
		//so this function will call itself, hence it is a recursive function
		
		//... do some stuff
		//so we get 6 in...
		//
		
		if(sn < 2) {
			System.out.println("returning 0 for sn: " + sn + ", count: " + count);
			return 0;
		}
		
		//can this stand for the sn number just being all 1's? any number that passes 
		//  the check sn < 2 can be all 1's so we give it 1 count already?
		int newCount = 1; 
		
		int sub = sn - 1;
		while(sub > 1) {
			int nn;
			//while((nn = sn - sub) > 1){
			nn = sn - sub;
			newCount++;
			
			if(nn == 1 || nn == 0) {
				continue;
			}
			
			int nCount = recr_2(nn, count);
			System.out.println("got nCount returned: " + nCount + " for nn: " + nn + " sn: " + sn + " sub: " + sub);
			
			sub--;
		}
		
		return newCount;
		
	}
	public Object problem2() {
		
		
		int test = 6;
		int count = 1; //since every number has 1 1 1 1 1... as a way to make that number
		int sub = test - 1; // 5
		int left = test - sub; //1
		//now we check everything for whats left (1)
		
		if(left == 1 || left == 0) {
			//thats the end of the line, cant combine anything else if we are just left with a 1 or 0
			//this is wher we would break in some loop I assume we would put this code in.
		}
		
		//next iteration:
		
		sub--; //sub was 5, now its 4
		left = test - sub; //test is 6 so now left is 2
		
		if(left == 1 || left == 0) {
			//this is false, because left is 2
		} else {
			//we check if we can subtract all numbers from sub to 2. Sub is 4, so we try 4, then 3, then 2
			int otherLeft = left - sub;
			if(otherLeft == 1 || otherLeft == 0) {
				//break;
			} else if(otherLeft < 0) {
				//we get here because 2 - 4 is -2
				//end of the line for this
			}
		}
		
		
		for(int i=test-1; i > 1; i--) {
			
			int nLeft = left;
			System.out.println("starting for loop, left = " + left + ", i = " + i);
			while(true) {
				nLeft -= i;
				if(nLeft > 0) {
					System.out.println("breaking 1 loop, i = " + i + ", nLeft = " + nLeft);
					break;
				} else {
					System.out.println("still in 1 loop, i = " + i + ", nLeft = " + nLeft);
				}
			}
			
			System.out.println("In loop, i = " + i + ", nLeft = " + nLeft);
			if(nLeft > 1) {
				count ++;
			}
		}
		
		
		
		
		
		//entr();
		return "";
	}


	
	
	
	
	
	
	
	
	/* all the code below here is just messing around with some initial ideas, doesnt solve the problem at all yet. */
	
	
	
	
	
	
	
	
	public Object problemOther() {
		System.out.println("Here we go");
		
		
		/*
		 so we do 6, lets see..
		 
		 
		 */
		int test = 6;
		int count = 1; //since every number has 1 1 1 1 1... as a way to make that number
		int sub = test - 1; // 5
		int left = test - sub; //1
		while(true) {
			
			
			
			while(left > 1) {
				left = test - sub; //this gives us 1 and 5, sub is 5, which leave left is 1
				int nSub = sub; //nSub is 5
				System.out.println("1 Left is now: " + left + ", and nSub is " + nSub);
				
				if(left > 0) {
					count++;
					System.out.println("first count up, count is now : " + count);
				} else {
					System.out.println("How did we get here? " + count);
					System.out.println("errrr Left is now: " + left + ", and nSub is " + nSub);
				}
				
				//then we want to go through the rest of the num (after taking away 5) and see how many times we can take away another 5, then 4, and 3, and 2
				//so... what do we do 
				
				
				while(left > 1) {
					left -= nSub;
					//if(left > 1) {
						count++;
						System.out.println("2 Left is now: " + left + ", and nSub is " + nSub);
					//}
				}
				
				count++;
			}
			
			
			
			
			if(4 < 90) {
				break;
			}
		}
		
		count++; //because the start number can already be imagined as all 1's
		
		//then we start doing combos of 2? Or should we start with highest num 5?
		//lets stick with our visualization below and we can switch to the highest to lowest if we want
		//we will do lowest to highest (combos of 2, then 3, then 4, etc..)
		// so we minus the first 2 (do the first combo of 2 for the two 1's on the right)
		
		if(test < 2) { //I guess if we ever go below 2 then we know we cant combine anything else so we return maybe this return is early?
			//return count; // done actually return from this function as a whole, need to change numToCombo to increment
			sub++;
		}
		
		//DOING 2 first
		
		
		
		int next = test - sub; // 4
		count++;
		
		if(test < 2) {
			//return count;
			sub++;
		}
		
		
		next = test - sub; // 2
		count++;
		
		if(test < 2) {
			//return count;
			sub++;
		}
		
		next = test - sub; // 0
		count++;
		
		if(test < 2) {
			//return count;
			sub++; // so now the next is at 0, so we increase the num to combo and go back and do it again?
		}
		
		
		
		return null;
	}
	
	
	

	
	
	/////messing with recur here below, not completed, dont use until you finish it. Go work on the other way as described in comments above
	private static void entry() {
		
		
		int test = 6;
		int ways = recur(test);
		System.out.println("ways to make " + test + " : " + ways);
	}
	private static int recur(int n) {
		
		if(n < 2) return 0;
		
		int waysToMakeN = 0;
		System.out.println("starting recur with " + n);
		int sub = 0;
		while(sub < n) {
			
			
			sub++;
			
			
			
			int diff = n - sub;
			if(diff > 1) {
				System.out.println("gonna call recur again for n: " + n + " with sub: " + sub + " diff: " + diff);
				int newWays = recur(diff);
				System.out.println("inside got this many ways to make " + diff + " with sub: " + sub + " : ways = " + newWays + " ::: waysToMakeN was " + waysToMakeN);
				waysToMakeN += newWays;
				System.out.println(" and now it is : " + waysToMakeN);
			} else if (diff == 1){ //we end here this recur?
				System.out.println("breaking at diff: " + diff + ", sub: " + sub + " for n: " + n);
				waysToMakeN++;
				break;
			} else {
				System.out.println("ERROR " + diff + ", sub: " + sub + " for n: " + n);
			}
			
			
			
		}
		
		
		
		System.out.println("returning " + waysToMakeN + " for n :" + n);
		return waysToMakeN;
				
	}
	

	
}
