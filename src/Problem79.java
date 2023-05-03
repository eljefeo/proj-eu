import java.util.ArrayList;
import java.util.List;

public class Problem79 implements Problem{// THIS ONE IS NOT DONE YET

	
	/*
	 A common security method used for online banking is to ask the user for three random characters from a passcode. For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected reply would be: 317.

The text file, keylog.txt, contains fifty successful login attempts.

Given that the three characters are always asked for in order, analyse the file so as to determine the shortest possible secret passcode of unknown length.
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem79();
		p.runProblem();
	}
	//static int t = 0;
	@Override
	public Object problem() {
		
		return 0;
	}
	
	/*
	 for a test code, lets say the passcode is 531278
	 if you are going to include the first number in your code, AND THE NUMBERS ARE ALWAYS ASKED FOR IN ORDER...
	 		then if you want to use the first number that would always be the first number in your 3 digits.
	 		because there would be no numbers available to ask for before that one.
	 		like if you want to include the 5, since its the first number, you have to ask for 1st 3rd 5th for example
	 		you can never ask for 5th 3rd and 1st, since that wont be in order. 
	 		Same goes for the last digit, the last digit would always be last in your examples
	 		
	 		from the list below we can see that 7 is always at the beginning and 0 is always at the end.
	 		so right off the bat we can prooobbably assume 7 is the first and 0 is the last.
	 		
	 		We can use similar logic to determine the middle numbers based on where they fall in the examples
	 		
	 		like the number 3 is always the first or second digit in the examples... 
	 		that could mean that 3 is the second digit of the real code because if you want to ask for three random digits
	 			the smallest you could pick would be 1st 2nd 3rd digits, and that means the second digit would never be able 
	 				to be the last digit in your sample
	 		so 3 may be the second digit
	 		
	 		Same thing goes for the number 9, it is always the 2nd or 3rd digit in the samples. That would make sense if 9 was the 
	 		second to last digit, because if you wanted to include the 2nd to last digit in your random three, it would never
	 			be able to be the first digit, since that means you would need 2 more digits after it. But the second to last digit
	 			does not have 2 digits after it, it only has the very last digit. Meaning the second to last digit would never be 
	 			able to be the first digit in your samples.
	 			
	 			so far we will start with that deduction...
	 			the code so far MAY be 73XXXXX90 - where we dont know what the X's are or how many X's we even need
	 			
	 			 we can also see that the numbers 4 and 5 never show up in the samples at all... maybe they are not even in the code?
	 			 
	 		that means the code will have a middle section (assuming the digits dont duplicate?) of 1268
	 		
	 		so we just need to try all the combinations of 1268 with 73 at the beginning and 90 at the end...
	 		and see if any of those combinations can work for the below samples?
	 */
	private List<Integer[]> getCodes(){
		List<Integer[]> codes = new ArrayList<Integer[]>();
		codes.add(new Integer[] {3,1,9});
		codes.add(new Integer[] {6,8,0});
		codes.add(new Integer[] {1,8,0});
		codes.add(new Integer[] {6,9,0});
		codes.add(new Integer[] {1,2,9});
		codes.add(new Integer[] {6,2,0});
		codes.add(new Integer[] {7,6,2});
		codes.add(new Integer[] {6,8,9});
		codes.add(new Integer[] {7,6,2});
		codes.add(new Integer[] {3,1,8});
		codes.add(new Integer[] {3,6,8});
		codes.add(new Integer[] {7,1,0});
		codes.add(new Integer[] {7,2,0});
		codes.add(new Integer[] {7,1,0});
		codes.add(new Integer[] {6,2,9});
		codes.add(new Integer[] {1,6,8});
		codes.add(new Integer[] {1,6,0});
		codes.add(new Integer[] {6,8,9});
		codes.add(new Integer[] {7,1,6});
		codes.add(new Integer[] {7,3,1});
		codes.add(new Integer[] {7,3,6});
		codes.add(new Integer[] {7,2,9});
		codes.add(new Integer[] {3,1,6});
		codes.add(new Integer[] {7,2,9});
		codes.add(new Integer[] {7,2,9});
		codes.add(new Integer[] {7,1,0});
		codes.add(new Integer[] {7,6,9});
		codes.add(new Integer[] {2,9,0});
		codes.add(new Integer[] {7,1,9});
		codes.add(new Integer[] {6,8,0});
		codes.add(new Integer[] {3,1,8});
		codes.add(new Integer[] {3,8,9});
		codes.add(new Integer[] {1,6,2});
		codes.add(new Integer[] {2,8,9});
		codes.add(new Integer[] {1,6,2});
		codes.add(new Integer[] {7,1,8});
		codes.add(new Integer[] {7,2,9});
		codes.add(new Integer[] {3,1,9});
		codes.add(new Integer[] {7,9,0});
		codes.add(new Integer[] {6,8,0});
		codes.add(new Integer[] {8,9,0});
		codes.add(new Integer[] {3,6,2});
		codes.add(new Integer[] {3,1,9});
		codes.add(new Integer[] {7,6,0});
		codes.add(new Integer[] {3,1,6});
		codes.add(new Integer[] {7,2,9});
		codes.add(new Integer[] {3,8,0});
		codes.add(new Integer[] {3,1,9});
		codes.add(new Integer[] {7,2,8});
		codes.add(new Integer[] {7,1,6});
		
		return codes;
	}
	
}
