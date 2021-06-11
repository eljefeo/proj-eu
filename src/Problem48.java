import java.math.BigInteger;

public class Problem48 {

	/*
	 The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

		Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
		
	 */
	
	
	public static void main(String[] args) {
		problem();
	}
	
	private static void problem(){
		int max = 1001;
		long tenDigits = 10000000000L;
		BigInteger b = new BigInteger("0");
		for(int i = 1; i < max; i++){
			BigInteger c = new BigInteger(""+i).pow(i);
			b = b.add(c);
		}
		System.out.println("Last ten digits: " + b.mod(new BigInteger(""+tenDigits)));
		// sorry we cheated with BigInteger again...
	}

}
