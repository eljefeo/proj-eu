
public class Problem76 implements Problem{// Took 1.581191 seconds ---- too SLOWW

	/*
	 It is possible to write five as a sum in exactly six different ways:
		How many ways to make 5:
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
	static int t = 0;
	@Override
	public Object problem() {
		int num = 100;
		//int ans = howManyWaysToSumToN_printAnswers(0, num, 0, num-1, "");
		int ans2 = howManyWaysToSumToN(0, num, 0, num-1);
		//int ans3 = howManyWaysToSumToN_original(0, num, 1, 0, num-1);
		//System.out.println("t: " + t);
		return ans2;
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
	
	
	public static int howManyWaysToSumToN_printAnswers(int num, int goal,  int count, int end, String text) {
		 //if(num < goal) {
			for(int i = 1; i <= end; i++) {
				int ni = num + i;
				if(ni > goal) {
					//t++;
					//System.out.println(" too far " + num + " + " + i);
					return count;
				} else if (ni == goal) {
					text += " " + i;
					System.out.println("found: " + text);
					count++;
					break;
					//return count;
				}
				else {
					count = howManyWaysToSumToN_printAnswers(ni, goal, count, i, text + " " + i);
				}
				
			}
		//}
		
		
		return count;
	}

}
