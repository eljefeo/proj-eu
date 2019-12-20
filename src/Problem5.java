
public class Problem5 {

	public static void main(String[] args) {
		problem();
		
	}
	
	/*
	 * 
	 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

		What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 * 
	 */
	
	public static void problem(){
		
		boolean found = false;
		
		int ind = 0;
		while(!found){
			ind++;
			boolean bad = false;
			for(int i=1; i <= 20; i++){
				if(ind%i!=0){
					bad = true;
					break;
				}
			}
			if(!bad){
				found = true;
			}
			
		}
		
		System.out.println("Found : " + ind);
		
	}

}
