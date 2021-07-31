import java.math.BigInteger;

public class Problem25 implements Problem { //Took 0.103798 seconds

	public static void main(String[] args) {
		Problem p = new Problem25();
		p.runProblem();
	}
	
	@Override
	public String problem(){
		BigInteger num1= new BigInteger("1");
		BigInteger num2 = new BigInteger("1");
		
		int ind = 2;
		while(true){
			BigInteger newn = num1.add(num2);
			num1 = num2;
			num2 = newn;
			
			ind++;
			if(num2.toString().length() == 1000){
				//System.out.println("Found: " + ind);
				break;
			}
		}
		return "" + ind;
	}

}
