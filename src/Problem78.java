
public class Problem78 implements Problem{// THIS ONE IS NOT DONE YET

	public static void main(String[] args) {
		Problem p = new Problem78();
		p.runProblem();
	}
	//static int t = 0;
	@Override
	public Object problem() {
		//doit();
		//int num = 100;
		//int ans2 = howManyWaysToSumToN(0, num, 0, num-1);
		//countTimesIn();
		int number = 5;
		int[] ans = new int[number];
		ans[0] = -1;
		ans[1] = 1;
		ans[2] = 2;
		//ans[3] = 0;
		//return doit2(number-1, 1, 1, ans);
		return doit2(number, ans);
	}
	
	public static int doit() {
		
		int n = 2;
		int pn = 2;
		int diffIncrease = 3;
		int oldDiff = 3;
		int mil = 1000000;
		System.out.println(" start pn = " + pn + " for n " + n + " :: " + (pn%mil));
		int oldPn = 0;
		while(pn%mil != 0) {
			//int ans2 = howManyWaysToSumToN(0, num, 0, num-1);
			n++;
			pn = howManyWaysToSumToN(0, n, 0, n-1) + 1;
			diffIncrease = (pn - oldPn);
			System.out.println(n + " = " + pn + ", increase: " + diffIncrease + " diffChange: +" + (diffIncrease - oldDiff));
			oldDiff = diffIncrease;
			oldPn = pn;
		}
		return n;
	}
	
	public void countTimesIn() {
		int number = 7;
		
		int[] an = new int[number];
		an[0] = -1;
		an[1] = 1;
		an[2] = 2;
		an[3] = 3;
		
		int numToTheLeft = 0;
		int right = 0;
		int numToMinus = number-1;
		while (numToMinus > 0) {
			
			int cnt = 0;
			int tmpNumToMinus = numToMinus;
			int tmpNum = number;
			
			while (tmpNumToMinus < tmpNum) {//how many times 6 goes into 7
				tmpNum -= tmpNumToMinus;
				cnt++;
			}
			System.out.println("minus "  + numToMinus + " .. " + cnt + " times with " + tmpNum + " leftover");
			//int d = number - tmp;//1
			
			//howManyWaysToSumToN2(d, an);
			numToMinus--;//6
		}
	}
	
	//public static int doit2(int left,int right, int count, int[] ans) {
	public static int doit2(int num, int[] ans) {
	
		
		//int number = 7;
		/*		
		int tLeft = left, tRight = right;
		//int numToTheLeft = 0;
		//int right = 0;
		//int numToMinus = 0;
		while(tLeft > 1) {
			
			if(tRight > tLeft) {
				System.out.println("Doit2 right bigger than left, " + tLeft + " " + tRight + " count: " + count);
				tRight -= tLeft;
				doit2(tLeft, tRight, count, ans);
			}
			
			
			//numToMinus++;
			//count++;
			System.out.println("Initial call : " + tLeft + " " + tRight + " count: " + count);
			count = callFind(tLeft, tRight, count, ans);
			System.out.println("back from Initial call : " + tLeft + " " + tRight + " count: " + count);
			//System.exit(1);
			tLeft--;
			tRight++;
		}
		
		*/
		
		int count = 2;
		for(int i=num-1; i>1; i--) {
			
			//5
			/*
			 5-1=4
			 -2=3
			 -3=2...
			 
			 */
			int d = num - i;
			System.out.println("doing " + i + " " + d);
			count = callFind(i, d, count, ans);

		}
		
			
		return count;
	}
	
	
	
	
public static int callFind(int left, int right, int count, int[] ans) {
		
	System.out.println("callFinded " + left + ", right: " + right + ", count still: " + count );
	
	if(left == 1) {
		System.out.println("!ahve num to the left is 1, returning, nums were " + left + ", " + right + ", count: "+ count);
		return count;
	}
	
	if(right > left) {
		System.out.println("num to the left is smaller, " + left + " < " + right + " calling again with " + left + ", " +(right-left) );
		
		int tLeft = left, tRight = right;
		while(tLeft > 1) {
			System.out.println("inner, currently " + tLeft + " " + tRight + ", like " + tLeft + " " + tLeft + " " + (right-left));
			int nCount = callFind(tLeft, right - left, count, ans); 
			System.out.println(" gotNcount " + nCount + " from smaller " + left + " < " + right);
			count = nCount;
			tLeft--;
			tRight++;
		}
	} else {
		//count++;
		System.out.println("in else for " + left +  " and " + right + " count is still : " + count);
		int a = ans[right];
		if(a == 0) {
			//we dont know this one, need to find it
			System.out.println("&&&&dont know " + right + " going to call original");

			int tCount = 2;
			
			System.out.println("Had to find the inner " + right+ ", found to be : " + tCount + " setting that now..");
			ans[right] = tCount;
			
			
		} else {
			System.out.println("We already know " + right + " = " + a + " for left: " + left + " right: " + right + " returning " + (count + a));
			return count + a;
		}
	}
		return count;
		
	}


	public static void callFind2(int numToTheLeft, int right, int[] ans) {
		
		int a = ans[right];
		if(a == 0) {
			
		} else {
			
		}
		
	}
	/*
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
	 */
	public static int howManyWaysToSumToN2(int num, int[] ans) {
		int a = ans[num];
		if(a == 0) {
			//need to find this num
			
			int tmp = num-1;
			int cnt = 0;
			while(tmp > num) {
				tmp -= num;
				cnt++;
			}
			System.out.println("");
			
			
			int tt = num;
			while (tt > 0) {
				tt--;
				
				int d = num - tt;//
				howManyWaysToSumToN2(d, ans);
				
			}
		} else {
			System.out.println("found this num : ans[" + num + "] = " + a );
		}
		
		 return 666;
		
	}
	
	public static int howManyWaysToSumToN(int num, int goal,  int count, int end) {
		if(num == goal) {
			count++;
		} else if(num < goal) {
			for(int i = 1; i <= end; i++) {
				count = howManyWaysToSumToN(num + i, goal, count, i);
			}
		}
		return count;
	}
	
	
	
}
