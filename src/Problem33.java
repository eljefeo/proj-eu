
public class Problem33 {
	/*
	 The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
	 */

	public static void main(String[] args) {
		problem();
	}
	
	private static void problem(){
		
		double a = 4;
		double b = 8;
		System.out.println("here " + (a/b));
		 
		for(double n=11; n<50; n+=1){
			double d = n*2;
			if(n%10 == 0){
				continue;
			}
			else {
				System.out.print("At " + n + " / " + d);
			}
			
			/*int r = num % 10;
			digits[i] = r;
			num /= 10;*/
			
			
			double n1 = (int)(n/10)%10;
			double n2 = (int)n%10;
			double d1 = (int)(d/10)%10;
			double d2 = (int)d%10;
			if(d1 ==0 ||  d2==0){
				System.out.println();
				continue;
			}
			
			else {
			System.out.println(" :: with n1 n2 = " + n1 + "." + n2 + " / " + d1 + "." +d2 + " :: " +n1 +"/"+d2 +" = " +(n1/d2));
			if( (( n1 == d2) && n2/d1==.5) || (( n2 == d1) && n1/d2==.5)){
				System.out.println("Found one? : " + n + " / " + d);
			}
			}
			
		}
	}

}
