
public class Problem40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		problem();
	}
	
	
	//theres 10 1digit nums so 10 (0-9)
	//theres 90 2digit nums so + 90*2 = 180 === 190-192 being 100 
	//theres 900 3digit nums so + 900*3 = 2700 === 2890 2890-2893 being 1000
	//theres 9000 4digit nums so + 9000*4 = 36000 === 38890
	//theres 90000 5digit nums so + 90000*5
	//....etc
	//so count digits
	// then 10 + (9 Math.pow(10,digits.length or -1)
	
	private static void problem(){
		
		int test = 322; //123 the second 6 in 66 (ones digit)
		System.out.println("Easy mode " + test + " = " + findNthDigitOfAllNumsEasy(test) + " " + findNthDigitOfAllNumsEasy(test+1) + " " + findNthDigitOfAllNumsEasy(test+2) + " " + findNthDigitOfAllNumsEasy(test+3));
	int x=10;
	int c = 1;
	int xx = x;
	while(x-1<test){
		xx = x;
		x += (9*(c+1)) * (int)Math.pow(10, c++);
		//System.out.println(x + " " + c);
	}
	System.out.println("c="+c + " and x="+x + " annnd xx:" + xx);
	int diff=x-test;
	//int lkj = (diff / 10) - (9*c) + 10;
	int startingNum = ((test -xx)/c)+ (int)Math.pow(10, c-1);
	System.out.println(x + " " + c + " "+ " :starting num: "+ startingNum);
	/*int lkj = ((test -xx)/c)+ (int)Math.pow(10, c-1);// works for 2 digits kinda, from 10 - 189
	if(c==2)System.out.println(x + " " + c + " diff:" + diff + " lkj:"+ lkj);
	int poi = ((test -xx)/c) + (int)Math.pow(10, c-1); //starts at 190=100, 193=101, 196=102
	if(c==3)System.out.println(x + " " + c + " diff:" + diff + " poi:"+ poi);
	
	int wer = ((test-xx)/c) + (int)Math.pow(10, c-1); //starts at 190=100, 193=101, 196=102
	if(c==4)System.out.println(x + " " + c + " diff:" + diff + " wer:"+ wer);*/
	/*System.out.println(x + " " + (9*(c+1)) + " " + (int)Math.pow(10, c));
	c++;
	x += (9*(c+1)) * (int)Math.pow(10, c);
	System.out.println(x + " " + (9*(c+1)) + " " + (int)Math.pow(10, c));
	c++;
	x += (9*(c+1)) * (int)Math.pow(10, c);
	System.out.println(x + " " + (9*(c+1)) + " " + (int)Math.pow(10, c));
	*/
	//x +=9;
/*	System.out.println("x " + x);
	x+=180;
	System.out.println("x " + x);
	x+=2700;
	System.out.println("x " + x);
	x+=36000;
	System.out.println("x " + x);*/
	
		
		
		
		
		
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
		String b = makeAllNumsStringFromTo(0, 10000);
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
