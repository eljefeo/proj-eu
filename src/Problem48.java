import java.math.BigInteger;

public class Problem48 implements Problem{

	/*
	 The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

		Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
		
	 */
	
	
	public static void main(String[] args) {
		Problem p = new Problem48();
		p.runProblem();
	}
	
	public String problem(){
		int max = 1001;
		long tenDigits = 10000000000L;
		BigInteger b = new BigInteger("0");
		for(int i = 1; i < max; i++){
			BigInteger c = new BigInteger(""+i).pow(i);
			b = b.add(c);
		}
		//System.out.println("Last ten digits: " + b.mod(new BigInteger(""+tenDigits)));
		// sorry we cheated with BigInteger again...
		return "" + b.mod(new BigInteger(""+tenDigits));
	}

}
