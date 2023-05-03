import java.util.ArrayList;
import java.util.List;

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
		int number = 7;
		int[] ans = new int[number];
		ans[0] = -1;
		ans[1] = 1;
		ans[2] = 2;
		List<Long> all = new ArrayList<Long>();
		all.add(1L);
		all.add(1L);
		//all.add(2);
		//all.add(3);
		//all.add(5);
		//all.add(7);
		//all.add(11);
		//ans[3] = 0;
		//return doit2(number-1, 1, 1, ans);
		//int ff = callFind(4,7,0,ans);
		//System.out.println("Got FFFFF : " + ff);
	
		/*
		 if trying to find 30
		 do +n-1 +n-2
		 do -n-5 -n-7
		 */
		
		int max = 1000;
		int ii = 2;
		//for(int ii = 2; ii < max; ii ++) {
		while(true) {
			long run = 0;
			int i = 2;
			//while(i++ < number) {
			int neg = -1;
			int posNeg = 1;
			int od = 1;
			int odd = 1;
			int nat = 1;
			int nToDo = ii;
			
			while(nToDo > 0) {
				if(run % 1000 == 0) {
					//System.out.println("2Odd is " + odd + " doing all[" + nToDo + "] .... nat is " + nat + " ... nToDo = " + nToDo + " :: " + run );
				}
				nToDo = nToDo - odd;
				
				
				if(nToDo < 0 ) {
					break;
				}
				//System.out.println("Odd is " + odd + " doing all[" + nToDo + "] .... nat is " + nat + " ... nToDo = " + nToDo + " :: " + run );
				//System.out.println("doing run += all.get(nToDo) * posNeg; " + run + " + " +  (all.get(nToDo) * posNeg));
				run += all.get(nToDo) * posNeg;
				
				nToDo = nToDo - nat;
				if(nToDo < 0 ) {
					break;
				}
				//System.out.println("2Odd is " + odd + " doing all[" + nToDo + "] .... nat is " + nat + " ... nToDo = " + nToDo + " :: " + run );
				//System.out.println("doing run += all.get(nToDo) * posNeg; " + run + " + " +  (all.get(nToDo) * posNeg));
				run += all.get(nToDo) * posNeg;
				odd += 2; //make all odd numbers, 1 3 5 7 9 etc..
				nat++;
				posNeg *= neg;
			}
			if(run % 13 == 0) {
				return run;
			}
				System.out.println("ans: " + ii + " : " + run);
				//return run;
			//}
			all.add(run);
			ii++;
		}
		
		//for(int i = 0; i < all.size(); i ++) {
		//	System.out.println(i + " = " + all.get(i));
		//}
		/*int num = 100;
		int max = 50;
		int oldN = 1;
		int diff = 1;
		int oldDiff = 0;
		for(int i=2; i < max; i++) {
			int n = howManyWaysToSumToNEulers(i, ans);
			diff = n - oldN;
			oldN = n;
			System.out.println("ways to make " + i + ": " + n + ", diff from last = " + diff);
		}
		*/
		//int ans2 = howManyWaysToSumToN(0, num, 0, num-1);
		
		
		//return doit2(number, ans);
		//return 0;
	}
	public static int howManyWaysToSumToNEulers(int i, int[] ans) {
		
		
		
		
		return 0;
		
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

		
		int count = 1;//for the number itself at the beginning?
		for(int i=num-1; i>1; i--) {

			int d = num - i;
			System.out.println("OG doing " + i + " " + d);
			count = callFind(i, d, count, ans);
			System.out.println("OG GOT count is at " + count + " for " + i + " " + d);

		}
		
			count++; //for the 1 1 1 1 1 1 at the end?
			System.out.println("Final count: " + count);
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
			count = callFind(tLeft, right - left, count, ans); 
			System.out.println(" inn got count " + count + " from smaller " + left + " < " + right);
	
			tLeft--;
			tRight++;
		}
		System.out.println("exited inner with tLeft: " + tLeft + " tRight: " + tRight + ", left: " + left + " right: " + right + " count: " +count);
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
