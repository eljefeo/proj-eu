
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
		int number = 4;
		int[] ans = new int[number];
		ans[0] = -1;
		ans[1] = 1;
		//ans[2] = 2;
		//ans[3] = 0;
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
	
	public static int doit2(int number, int[] ans) {
	
		
		//int number = 7;
		
		
		
		int tNum = number;
		int count = 1;
		//int numToTheLeft = 0;
		//int right = 0;
		int numToMinus = 0;
		while(tNum > 1) {
			tNum--;
			numToMinus++;
			System.out.println("Initial call : " + tNum + " " + numToMinus + " count: " + count);
			count = callFind(tNum, numToMinus, count, ans);
			//System.exit(1);
		}
		
		
		
		
		return count;
	}
	
	
	
	
public static int callFind(int numToTheLeft, int right, int count, int[] ans) {
		
	System.out.println("callFinded " + numToTheLeft + ", right: " + right + ", count: " + count );
	
	if(numToTheLeft == 1) {
		System.out.println("!ahve num to the left is 1, returning, nums were " + numToTheLeft + ", " + right + ", count: "+ count);
		return count+1;
	}
	
	if(numToTheLeft < right) {
		System.out.println("num to the left is smaller, " + numToTheLeft + " < " + right + " calling again with " + numToTheLeft + ", " +(right-numToTheLeft) );
		int nCount = callFind(numToTheLeft, right - numToTheLeft, count, ans);
		System.out.println(" gotNcount " + nCount + " from smaller " + numToTheLeft + " < " + right);
		count += nCount;
	} else {
		
		//count++;
		System.out.println("adding 1 for this combo I guess, for " + numToTheLeft +  " and " + right + " count is now : " + count);
		int a = ans[right];
		if(a == 0) {
			//we dont know this one, need to find it
			System.out.println("&&&&dont know " + right + " going to call original");
			int tn = right;
			int mins = 0;
			int tCount = 1;
			tCount = doit2(right, ans);
			//while (tn > 1) {
			//	count++;
			//	tn--;
			//	mins++;
			//	System.out.println("Inner callFinded loop: " +tn + ", " + mins + " count: " + count + ", tCount: " + tCount);
			//	tCount = callFind(tn, mins, tCount++, ans);
			//}
			System.out.println("Had to find the inner " + right+ ", found to be : " + tCount + " setting that now..");
			ans[right] = tCount;
			
			
		} else {
			System.out.println("We already know " + right + " = " + a);
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
