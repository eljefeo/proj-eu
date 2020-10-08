
public class Problem40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		problem();
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
	
	private static void problem(){
		
		int test = 3221; //123 the second 6 in 66 (ones digit)
		System.out.println("Easy mode " + test + " = " + findNthDigitOfAllNumsEasy(test) + " " + findNthDigitOfAllNumsEasy(test+1) + " " + findNthDigitOfAllNumsEasy(test+2) + " " + findNthDigitOfAllNumsEasy(test+3));
	int x=10;
	int c = 1;
	int xx = x;
	while(x-1<test){ // xx will store the start of the range we are talking about, 2890, 38890, etc 
		xx = x;
		x += (9*(c+1)) * (int)Math.pow(10, c++);
	}
	int diffModC=(test-xx)%c;
	System.out.println("c="+c + " and x="+x + " annnd xx:" + xx + "  diffModC="+diffModC);
	//if diffModC == 0, we want the largest digit
	//if diffModC == 1, we want the second largest digit
	// ...etc...

	

	int startingNum = ((test -xx)/c)+ (int)Math.pow(10, c-1); 
	int actualNumber = startingNum/(int)Math.pow(10, c-diffModC-1)%10;
	
	System.out.println("actualNumber " + actualNumber );
	// got to turn the number they give us into the starting number? 
	//like 12 is the 1 in the tens place of 11
	//and 13 is the 1 in the ones place.
	// we kinda like 12 cause that will give us the start of 11, and not just part of 11
	//so also 322 gives us 144
	//while 323 gives us the starting at next 4 
	//
	System.out.println(x + " " + c + " "+ " :starting num: "+ startingNum);
	
	
		
		
		
		
		
		/*System.out.println(" " + (1450/1000));
		System.out.println("start end : " + makeAllNumsStringFromTo(190, 220));
		
		int n1 = 191;
		int n2 = n1+1;
		int d1 = findNthDigitOfAllNums(n1);
		int d2 = findNthDigitOfAllNums(n2);
		String s = makeAllNumsStringUpTo(n2);
		System.out.println("big num expecting " + s.charAt(n1) +""+s.charAt(n2) + "=" + d1+""+d2 + " :: " + s);
		//1   0   0   1   0   1   1   0   2   1   0   3   1   0   4   1   0   5   1   0   6   1   0   7   1   0   8   1   0   9   1   1   0
		//190 191 192 193 194 195 196 197 198 199 200 201 202 203 204 205 206 207 208 209 210 211 212 213 214 215 216 217 218 219 220 221 222
		
		System.out.println("Got num : " + d1);*/
	}
	
	private static int findNthDigitOfAllNums(int num){
		int d = 0;
		if(num <= 0) return -1;
		boolean isEven = num%2==0;
		if(num < 10){
			return num;
		} else if(num < 190){
			//if num == 50 we give 3 from 30
			//if num == 80 we give 4 from 45
			 
			if(isEven)
				d = ((num/2)+5)/10;
			else{
				d = ((num/2)+5)%10;
			}
			
		} else if(num < 2890){  //2987 2988 2989 are the last 999 of 3 digits
								//190 191 192 are the first 100
			
		}
		return d;
	}
	
	private static String findNthDigitOfAllNumsEasy(int num){
		String b = makeAllNumsStringFromTo(0, 1500);
		return b.charAt(num)+"";
	}

	
	public static String makeAllNumsStringUpTo(int n){
		String b = "";
		for(int i=0; i<n; i++){
			b+=i;
		}
		return b;
	}
	
	public static String makeAllNumsStringFromTo(int start, int end){
		String b = "";
		for(int i=start; i<end; i++){
			b+=i;
		}
		return b;
	}
	
}
