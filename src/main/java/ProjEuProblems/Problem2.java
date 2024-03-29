package ProjEuProblems;

public class Problem2 implements Problem { //Took 0.000018 seconds
	
	/*Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

		1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

		By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
*/
	
	
	public static void main(String[] args){
		Problem p = new Problem2();
		p.runProblem();
	}

	@Override
	public Object problem(){
		int total = 0; 
		int val1 = 1, val2 = 2, newVal;
		
		//since we only want evens..
		// we start with 1 and 2, thats adding an odd and an even
		// that gives us an odd (3)
		// then adding an odd and an even (2 and 3) , gives us another odd (5)
		// but then we add an odd and an odd (3 and 5), which gives us an even (8)
		// what im trying to say.. is every 3 goes we get an even
		// so we dont have to check every time if we have an even number to add
		// we just do the sequence three times, add that number, then 3 more and add, etc..
		
		int max = 4000000;
		int counter = 3; // we will start at the 2, so technically the counter is 3 when we begin. Then we'll add every 3 after
		while (val2 < max){
			if(counter == 3) {
				total += val2;
				counter = 0;	
			}
			newVal = val1 + val2;
			val1 = val2;
			val2 = newVal;
			counter++;
		}
		return total;
	}
	
	
}
