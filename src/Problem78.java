import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem78 implements Problem{// Took 0.026811 seconds

	public static void main(String[] args) {
		Problem p = new Problem78();
		p.runProblem();
	}

	@Override
	public Object problem() {
		int million = 1000000;
		return howManyWaysToSumToNEulers_divisibleByN(million);
	}
	
	public int howManyWaysToSumToNEulers_divisibleByN(int numDivisible) {
		List<Integer> all = new ArrayList<Integer>();
		all.add(1);
		all.add(1);
		int ii = 2;
		while(true) {
			int run = 0;
			int neg = -1;
			int posNeg = 1;
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
				run += (all.get(nToDo) * posNeg);
				if(shouldSubOdd = !shouldSubOdd) {
					odd += 2;//make all odd numbers, 1 3 5 7 9 etc..
					numToSub = nat;
				} else {
					nat++;//make all natural numbers, 1 2 3 4 5 6 7 ...
					numToSub = odd;
					posNeg *= neg;
				}
			}
			run %= numDivisible; //we can store only the last 6 digits because 
				//if we add or multiply these together, the numbers after the first 6 digits dont matter or have any effect
			if(run == 0) {
				return ii;
			}
			all.add(run);
			ii++;
		}
	}
	

	//this one can be helpful if you actually want to see all the digits in the num of partitions. the one above only uses the last 6 to solve problem
	// but this one actually gives the num of partitions of a num
	public int howManyWaysToSumToNEulers_divisibleMillion_BigInt() {
		List<BigInteger> all = new ArrayList<BigInteger>();
		all.add(new BigInteger("1"));
		all.add(new BigInteger("1"));
	
		BigInteger million = new BigInteger("1000000");
		int ii = 2;
		while(true) {
			BigInteger run = BigInteger.ZERO;
			BigInteger neg = new BigInteger("-1");
			BigInteger posNeg = BigInteger.ONE;
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
			run = run.mod(million); //we can store only the last 6 digits because 
				//if we add or multiply these together, the numbers after the first 6 digits dont matter or have any effect
			if(run.equals(BigInteger.ZERO)) {
				System.out.println("ans: " + ii + " : " + run);
				return ii;
			}
			all.add(run);
			ii++;
		}
	}
	
}
