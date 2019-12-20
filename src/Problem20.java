import java.math.BigInteger;

public class Problem20 {

	public static void main(String[] args) {
		problem();

	}
	
	public static void problem(){
		int factorial = 100;
		BigInteger inte = new BigInteger("1");
		
		for(int i=1; i<=factorial; i++){
			inte = inte.multiply(new BigInteger(""+i));
		}
		
		String str = inte.toString();
		int runningTotal = 0;
		for(int i=0; i<str.length(); i++){
			runningTotal += Integer.parseInt(str.charAt(i)+"");
		}
		
		System.out.println("found: " + inte.toString() + " --- \n" + runningTotal);
	}

}
