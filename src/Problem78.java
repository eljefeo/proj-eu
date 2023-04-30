
public class Problem78 implements Problem{// THIS ONE IS NOT DONE YET

	public static void main(String[] args) {
		Problem p = new Problem78();
		p.runProblem();
	}
	static int t = 0;
	@Override
	public Object problem() {
		//doit();
		//int num = 100;
		//int ans2 = howManyWaysToSumToN(0, num, 0, num-1);
		return doit();
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
