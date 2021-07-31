
public class Problem40 implements Problem {

	/*
	 	An irrational decimal fraction is created by concatenating the positive integers:
		
		0.123456789101112131415161718192021...
		             ^
		             ^
		It can be seen that the 12th digit of the fractional part is 1.
		
		If dn represents the nth digit of the fractional part, find the value of the following expression.
		
		d1 x d10 x d100 x d1000 x d10000 x d100000 x d1000000
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem40();
		p.runProblem();
	}
	
	
	//theres 10 1digit nums so 10 (0-9)
	//theres 90 2digit nums so + 90*2 = 180 === 190-192 being 100 
	//theres 900 3digit nums so + 900*3 = 2700 === 2890 (2700 plus the previous 190) 2890-2893 being 1000
	//theres 9000 4digit nums so + 9000*4 = 36000 === 38890 (36000 plus the previous 2890)
	//theres 90000 5digit nums so + 90000*5 = 450000 = 488890 (450000 + 38890....)
	//theres 900000 6digit nums so 900,000*6 = 5,400,000 = 5,888,890
	//.....7
	//.....8
	
	//....etc
	//so count digits
	// then 10 + (9 Math.pow(10,digits.length or -1)
	public String problem(){
		int product = 1;
		for(int i=0; i<7; i++){
			product *= Util.findNthDigitOfAllNums((int)Math.pow(10, i));;
		}
		//System.out.println("Solution : " + product);
		return "" + product;
	}
	
	
}
