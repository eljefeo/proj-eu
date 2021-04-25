
public class Problem52 {

	
	/*
	   
	   It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

		Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
	   
	 */
	
	public static void main(String[] args) {
		problem();

	}
	
	private static void problem(){
		
		int t1 = 1258749; //251748
		int t2 = 2517489;
		//int t = 12344562;
		//hasDuplicateDigit(t);
		System.out.println("has same digits? " + hasSameUniqueDigits(t1, t2));
		
		int max = 100000000;
		for(int i=10; i<max; i++){
			boolean hasSame = true;
			for(int j=2; j<7; j++){
				int ii = i*j;
				if(!hasSameUniqueDigits(i, ii)){
					hasSame = false;
					break;
				}
			}
			
			if(hasSame){
				System.out.println("HAS SAME !!! " + i);
				return;
			}
			
		}
		
		System.out.println("done...no answer???");
		
	}
	
	public static boolean hasSameUniqueDigits(int a, int b){
		
		String at = a+"";
		String bt = b+"";
		
		// lets assume the solution has unique digits, no duplicate digits. This is like the example given, and the example made no mention of allowing duplicate digits..
		// if we find an answer, and it is wrong on the website, we can switch to allowing duplicate digits.
		if(hasDuplicateDigit(a) || hasDuplicateDigit(b) || at.length() != bt.length() || a == b){
			return false;
		}
		
		for(int i=0; i<at.length(); i++){
			char c = at.charAt(i);
			boolean hasThisDigit = false;
			for(int j=0; j<bt.length(); j++){
				char d = bt.charAt(j);
				if(c == d){
					hasThisDigit = true;
					//System.out.println("yay " + c + " == " + d + " at j=" + j);
					break;
				}
			}
			if(!hasThisDigit){
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean hasDuplicateDigit(int a){
		
		String at = a+"";
		if(at.length()>1){
			for(int i=0; i<at.length(); i++){
				char c = at.charAt(i);
				for(int j=i+1; j<at.length(); j++){
					if(c == at.charAt(j)){
						//System.out.println("Matched " + c + " and " + at.charAt(j));
						return true;
					}
				}
			}
		}
		
		return false;
	}

}
