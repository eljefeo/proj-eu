import java.math.BigInteger;

public class Problem16 implements Problem { //Took 0.003685 seconds

	public static void main(String[] args) {
		Problem p = new Problem16();
		p.runProblem();
	}
	
	/*
	2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
	 * 
	 */
	
	@Override
	public String problem(){
		
		BigInteger total = new BigInteger("1");
		for(int i = 1; i <= 1000; i++){
			total = total.multiply(new BigInteger("2"));
		}
		//System.out.println("final : " + total);
		String totalStr = total.toString();
		int digitSum = 0;
		for(int i = 0; i < totalStr.length(); i++){
			int inte = Integer.parseInt(totalStr.charAt(i)+"");
			digitSum += inte;
		}
		
		//System.out.println("Found : " + digitSum);
		return "" + digitSum;
	}

}
