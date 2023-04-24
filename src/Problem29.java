import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem29 implements Problem {

	
	/*
	 Consider all integer combinations of a^b for 2<=a<=5 and 2<=b<=5 :
	 
	  2^2=4 2^3=8 2^4=16 2^5=32
	  3^2=9 3^3=27 3^4=81 3^5=243
	  4^2=16 4^3=64 4^4=256 4^5=1024
	  5^2=25 5^3=125 5^4=625 5^5=3125
	 
	 If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:
		4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
	 How many distinct terms are in the sequence generated by
	 	a^b for 2<=a<=100 and 2<=b<=100
	 	
	 	
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem29();
		p.runProblem();
	}
	
	@Override
	public Object problem(){
		int lowerBound = 2;
		int higherBound = 100;
		Set<BigInteger> nums = new HashSet<BigInteger>();
		
		for(int i=lowerBound; i<=higherBound; i++){
			for(int j=lowerBound; j<=higherBound; j++){
				BigInteger n = new BigInteger(i+"");
				nums.add(n.pow(j));
			}
		}
		//System.out.println("Total number of unique numbers : " + nums.size());
		return nums.size();
	} 
}
