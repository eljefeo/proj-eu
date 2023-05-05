import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem78 implements Problem{// Took 0.809113 seconds -- barely made it

	public static void main(String[] args) {
		Problem p = new Problem78();
		p.runProblem();
	}
	//static int t = 0;
	@Override
	public Object problem() {
		return howManyWaysToSumToNEulers_divisibleMillion();
		
	}
	
	public int howManyWaysToSumToNEulers_divisibleMillion() {
		List<BigInteger> all = new ArrayList<BigInteger>();
		all.add(new BigInteger("1"));
		all.add(new BigInteger("1"));
	
		BigInteger million = new BigInteger("1000000");
		int ii = 2;
		while(true) {
			BigInteger run = new BigInteger("0");
			BigInteger neg = new BigInteger("-1");
			BigInteger posNeg = new BigInteger("1");
			int odd = 1;
			int nat = 1;
			int nToDo = ii;
			boolean shouldSubOdd = false;
			int numToSub = odd;
			while(true) {
				nToDo = nToDo - numToSub ;
				if(nToDo < 0 ) {
					break;
				}
				run = run.add((all.get(nToDo).multiply(posNeg)));
				if(shouldSubOdd = !shouldSubOdd) {
					odd += 2;//make all odd numbers, 1 3 5 7 9 etc..
					numToSub = nat;
				} else {
					nat++;//make all natural numbers, 1 2 3 4 5 6 7 ...
					numToSub = odd;
					posNeg = posNeg.multiply(neg);
				}
			}
			
			if(run.mod(million).equals(BigInteger.ZERO)) {
				System.out.println("ans: " + ii + " : " + run);
				return ii;
			}
			all.add(run);
			ii++;
		}
	}
	
	
}
