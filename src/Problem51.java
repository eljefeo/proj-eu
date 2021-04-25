
public class Problem51 {

	
	/*
	 By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, 
	yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
	 */
	
	public static void main(String[] args) {
		problem();
	}
	
	private static void problem(){
		//56003
		String ts = "56003";
		// how to start replacing some of the digits with another number...without replacing all digits
		String t = "123";
		for(int i=0; i<2; i++){
			String d = i+"x";
		}
		/*
		 so like if we did the first digit only
		 x23 - 223 323 423 523 etc...
		 what if we did the first 2
		 xx3 - 113 223 333 443 553 etc.
		 x2x - 121 222 323 424 525 etc.
		  
		 */
	}

}
