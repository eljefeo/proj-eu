
public class Problem17 implements Problem { //Took 0.000227 seconds

	
	/*
	 * 
	 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.


	 */
	
	
	public static void main(String[] args) {
		Problem p = new Problem17();
		p.runProblem();
	}
	
	
	@Override
	public String problem(){
		String zeroTnine[] = {
				"one", "two", "three","four","five","six","seven","eight","nine"
		};
		
		String teens[] = {
				"ten","eleven", "twelve", "thirteen","fourteen", "fifteen","sixteen", "seventeen", "eighteen", "nineteen"
		};
		
		String twenT90[] = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		
		String hundred = "hundred";
		String thousand = "thousand";
		
		String and = "and";
		
		int letters = 0;
		
		
		//0
		for(int i = 0; i < zeroTnine.length; i++){
			letters+=zeroTnine[i].length();
		}
		for(int i = 0; i < teens.length; i++){
			letters+=teens[i].length();
		}
		//19
		
		for(int i = 0; i < twenT90.length; i++){
			letters+=twenT90[i].length();
			for(int j = 0; j<zeroTnine.length; j++){
				letters+=twenT90[i].length();
				letters+=zeroTnine[j].length();
			}
		}
		//99

		int onethrough99 = letters;
		
		//n hundred
		for(int i = 0; i < zeroTnine.length; i++){
			letters+=zeroTnine[i].length();
			letters+=hundred.length();
		}
		
		for(int i = 0; i < zeroTnine.length; i++){
			for(int j = 0; j < 99; j++){
				letters+=zeroTnine[i].length();
				letters+=hundred.length();
				letters+=and.length();
			}
			letters+=onethrough99;
		}
		
		
		// one thousand
		letters+=3;
		letters+=thousand.length();
		
		//System.out.print("Num of letters " + letters);
		return "" + letters;
	}

}
