
public class Problem9 implements Problem { //Took 0.006984 seconds
	
	/*A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

	a^2 + b^2 = c^2
	For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	Find the product abc.*/

	public static void main(String[] args) {
		Problem p = new Problem9();
		p.runProblem();
	}
	
	public String problem(){
		for(int i = 1; i < 1000; i++){
			int a = (int) Math.pow(i, 2);
			for(int j = i+1; j < 1000; j++){
				int b = (int) Math.pow(j, 2);
				double k = Math.sqrt(a+b);
				if((k - (int)k) == 0){
					if((i + j + k) == 1000){
						System.out.println("Found : " + i + " " + j + " " + k );
						System.out.println("Product : " + (i*j*(int)k));
						return "" + (i*j*(int)k);
					}
				}
				
			}
		}
		return null;
	}

}