import java.math.BigInteger;

public class Problem48 {

	/*
	 The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

		Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
		
	 */
	
	
	public static void main(String[] args) {
		double f = 5;
		double t = 2;
		double a = f/t;
		System.out.println(" sdf " + a);
		
		//problem();
	}
	
	private static void problem(){
		int max = 1001;
		long digits = 10000000000L;
		BigInteger b = new BigInteger("0");
		for(int i = 1; i < max; i++){
			BigInteger c = new BigInteger(""+i).pow(i);
			b = b.add(c);
		}
		System.out.println("Last ten digits: " + b.mod(new BigInteger(""+digits)));
		
	}

}
