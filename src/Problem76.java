
public class Problem76 implements Problem{// Took 2.596475 seconds ---- too SLOWW

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
	 * 	 999:
	 		   N-10	N-9	N-8	N-7	N-6	N-5	N-4	N-3	N-2	N-1
	 			989	990	991	992	993	994	995	996	997	998
	 -------------------------------------------------
... ?	?	?	?	30	22	15	11	7	5	3	2	1

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
		int test = 100;
		return rec666(0, test, 1, 0, test-1);
		
	}

	public static int rec666(int n, int og, int digit, int count, int end) {
		if(n == og) {
			count++;
		} else if(n < og) {
			int div = og/digit;
			for(int i = 1; i <= end; i++) {
				count = rec666(n + i, og, digit+1, count, i < div  ? i : div);
			}
		}
		return count;
	}
	


	
}
