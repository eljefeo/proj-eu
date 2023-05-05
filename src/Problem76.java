import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public Object problem() {
		int num = 100;
		BigInteger ans = howManyWaysToSumToNEulers(num);
		System.out.println("Testing : " + num + " = " + ans);
		
		return ans;
		//return Util.howManyWaysToSumToN_recurEntry(num);
	}
	
	public BigInteger howManyWaysToSumToNEulers(int num) {
		List<BigInteger> all = new ArrayList<BigInteger>();
		all.add(new BigInteger("1"));
		all.add(new BigInteger("1"));
	
		num++;
		int ii = 2;
		while(ii < num) {
			BigInteger run = new BigInteger("0");
			BigInteger neg = new BigInteger("-1");
			BigInteger posNeg = new BigInteger("1");
			int odd = 1;
			int nat = 1;
			int nToDo = ii;
			int numToSub = odd;
			boolean shouldSubOdd = true;
			boolean isNeg = false;
			while(true) {
				
				
				
				
				
				if(shouldSubOdd) {
					nToDo = nToDo - odd ;
					if(nToDo < 0 ) {
						break;
					}
					run = run.add((all.get(nToDo).multiply(posNeg)));
					
				} else {
					nToDo = nToDo - nat ;
					if(nToDo < 0 ) {
						break;
					}
					run = run.add((all.get(nToDo).multiply(posNeg)));
					odd += 2; //make all odd numbers, 1 3 5 7 9 etc..
					nat++;
					posNeg = posNeg.multiply(neg);
				}
				
				shouldSubOdd = !shouldSubOdd;
				
				
			}
			all.add(run);
			ii++;
		}
		return all.get(all.size()-1);
	}
	
	public BigInteger howManyWaysToSumToNEulersSaved(int num) {
		List<BigInteger> all = new ArrayList<BigInteger>();
		all.add(new BigInteger("1"));
		all.add(new BigInteger("1"));
	
		num++;
		int ii = 2;
		while(ii < num) {
			BigInteger run = new BigInteger("0");
			BigInteger neg = new BigInteger("-1");
			BigInteger posNeg = new BigInteger("1");
			int odd = 1;
			int nat = 1;
			int nToDo = ii;
			
			while(true) {
				nToDo = nToDo - odd;
				if(nToDo < 0 ) {
					break;
				}
				run = run.add((all.get(nToDo).multiply(posNeg)));
				
				nToDo = nToDo - nat;
				if(nToDo < 0 ) {
					break;
				}
				run = run.add((all.get(nToDo).multiply(posNeg)));
				odd += 2; //make all odd numbers, 1 3 5 7 9 etc..
				nat++;
				posNeg = posNeg.multiply(neg);
			}
			all.add(run);
			ii++;
		}
		return all.get(all.size()-1);
	}

	
	//Just an extra func for testing:
	public static int howManyWaysToSumToN_printAnswers(int num, int goal,  int count, int end, String text) {
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
		
		return count;
	}

}
