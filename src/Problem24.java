import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem24 extends ProblemImpl{
	
/*	A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

		012   021   102   120   201   210

		What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?*/

	static List<String> perms = new ArrayList<String>();
	
	public static void main(String[] args) {
		Problem p = new Problem24();
		p.runProblem();
	}
	

	@Override
	public void problem(){
		String numstr = "";
		char[] numChars = {
				'0','1','2','3','4','5','6','7','8','9'
		};
		for(char a : numChars){
			numstr+=a;
		}
		System.out.println("String: " + numstr);

		permutation("", numstr); 
		Collections.sort(perms);
		System.out.println("Found: " + perms.get(999999));
		
		
	}


	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0){ 
	    	perms.add(prefix);
	    	
	    } else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}
