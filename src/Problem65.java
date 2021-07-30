import java.math.BigInteger;

public class Problem65 extends ProblemImpl { //Took 0.002743 seconds

	
	/*
	 Convergents of e:
	 
	 The square root of 2 can be written as an infinite continued fraction.
	 
	 e = 2 + 1 /
	 		1 + 1 / 
	 		2 + 2 / 
	 		3 + 3 / 
	 		4 + 4 /
	 
	 */
	
	/*
	 e :
	  2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536
	  2; 1, 2,   1,    1,    4,     1,      1,      6,        1, 1, 8?
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem65();
		p.runProblem();
	}

	public void problem() {
		int t = 100;
		BigInteger num = BigInteger.ONE;
		BigInteger den = new BigInteger("" + Util.getEPeriod(t));
		
		for(int i=t; i > 0; i--) {
			t--;
			BigInteger next = new BigInteger("" + Util.getEPeriod(t));
			num = den.multiply(next).add(num);
			BigInteger temp = num;
			num = den; 
			den = temp;

			
		}
		System.out.println(num + " / " + den);
		System.out.println("Digits sum : " + Util.addUpAllDigits(num));
		
	}
		
	/*
	 
	 int t = 6;
	getEPeriod(t)
	 returns 4
	 
	 so 1 / 4
	 int num = 1;
	 int den = 4;
	 
	  int next = getEPeriod(t-1 = 5) = 1
	  
	  so 1/4 + 1 = 
	  int num = denom*next + num = 4*1 + 1 = 5
	  
	  
	  then recip
	  5/4 becomes 4/5
	  int temp = num  = 5
	  num = denom = 4
	  denom = temp = 5
	  
	  num = 5
	  denom = 4
	  
	  int next = getEPeriod(t-2 = 4) = 1
	 
	 
	 
	 2 + 1/ 23/32 + 2 = 
	 1 + 1/ 9/23 + 1 = 32/23
	 2 + 1/ = 5/9 + 2 = 23/9
	 1 + 1/ 4/5 + 1 = 9/5
	 1 + 1/ -- 1/4  + 1 = 5/4 -- starting here is 87/32
	 4 + 1/
	 1 + 1/
	 1 + 1/
	 6 +  
	 
	 */
		
		
	

}
