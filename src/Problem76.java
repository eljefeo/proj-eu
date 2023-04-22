
public class Problem76 implements Problem{// Took 1.581191 seconds ---- too SLOWW

	/*
	 It is possible to write five as a sum in exactly six different ways:

		4 + 1
		3 + 2
		3 + 1 + 1
		2 + 2 + 1
		2 + 1 + 1 + 1
		1 + 1 + 1 + 1 + 1
		
	How many different ways can one hundred be written as a sum of at least two positive integers?
	190569291
	 */

	public static void main(String[] args) {
		Problem p = new Problem76();
		p.runProblem();
	}
	
	@Override
	public Object problem() {
		int num = 100;
		return howManyWaysToSumToN(0, num, 0, num-1);
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
	
	public static int howManyWaysToSumToN_original(int n, int og, int digit, int count, int end) {
		if(n == og) {
			count++;
		} else if(n < og) {
			int div = og/digit;
			for(int i = 1; i <= end; i++) {
				count = howManyWaysToSumToN_original(n + i, og, digit+1, count, i < div  ? i : div);
			}
		}
		return count;
	}
}
