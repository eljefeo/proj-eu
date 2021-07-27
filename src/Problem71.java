
public class Problem71 extends ProblemImpl{

	
	/*
	 
	 Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d <= 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

It can be seen that 2/5 is the fraction immediately to the left of 3/7.

By listing the set of reduced proper fractions for d <= 1,000,000 in ascending order of size, find the numerator of the fraction immediately to the left of 3/7.
	 
	 
	 */
	
	public static void main(String[] args) {
		new Problem71().runProblem();
	}

	/*
	1/8, 1/7, 1/6, 1/5, 
	
	*1/4 or 2/8, 
	
	2/7, 
	
	*1/3 or 2/6, 
	
	3/8, 2/5, 3/7, 
	
	*1/2 or 3/6 or 4/8, 
	
	4/7, 3/5, 5/8, 
	
	*2/3 or 4/6, 
	
	5/7, 
	
	*3/4 or 6/8, 
	
	4/5, 5/6, 6/7, 7/8

	*/
	
	
	@Override
	public void problem() {

		System.out.println("Here ...");
		
		int max = 8;
		int n = 2;
		
		for(int i=max; i > 0; i--) { 	// denom
			System.out.println(1 + " / " + i);
			
			
			
			/*
			for(int j=1; j<i; j++) { 	// numer
				System.out.println(j + " / " + i);
				
				if(j != 1 && i % j == 0) {
					System.out.println("Can reduce: " + j + "/" + i + " to 1/" + (i/j));
				}
			}
			*/
			
		}
		
		
	}

}
