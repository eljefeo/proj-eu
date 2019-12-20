
public class Problem1 {
	
	public static void main(String[] args){
		problem();
	}

	public static void problem(){
		//Summation of all multiples of 3 or 5 less than 1000
		int total = 0;
		for(int i = 0; i < 1000; i++){
			if(i % 3 == 0 || i % 5 == 0){
				total += i;
			}
		}
		System.out.println("Sum of all multiples of 3 or 5 less than 1000 : " + total);
	}
	
}
