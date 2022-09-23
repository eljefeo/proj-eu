import java.math.BigInteger;

public class Problem20 implements Problem { //Took 0.001608 seconds

	public static void main(String[] args) {
		Problem p = new Problem20();
		p.runProblem();
	}
	
	@Override
	public Object problem(){
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
		
		//System.out.println("found: " + inte.toString() + " --- \n" + runningTotal);
		return runningTotal;
	}

}
