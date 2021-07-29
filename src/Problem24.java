import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem24 extends ProblemImpl { //Took 0.330024 seconds
	
/*	A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. 
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. 
 * The lexicographic permutations of 0, 1 and 2 are:

		012   021   102   120   201   210

		What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?*/

	public static void main(String[] args) {
		Problem p = new Problem24();
		p.runProblem();
	}
	

	@Override
	public void problem(){
		// what if we dont even use the List<String>
		// since we are only looking for the millionth perm
		// and we know each next perm is in the right order...
		// just wait until we have teh millionth one..
		
		//Collections.sort(perms);
		//since we started the nums in order, when we do permutations it turns out to be in lexicographic order already
		// no need to sort..
		int max = 1000000;
		List<String> perms = new ArrayList<String>();
		//String res = permutation("", "0123456789", perms, max); 
		permutation("", "0123456789", perms, max); 
		
		System.out.println("Found: "  + perms.get(perms.size()-1) + " of " + perms.size() + " total permutations");
		
		
	}


	// since the natural permutation of the num will result in lexicographic order
	// we can just stop when we get the max'th number, since that is our answer
	// no need to get the rest of the permutations
	
	private static void permutation(String prefix, String str, List<String> perms, int max) {
	    if(perms.size() == max)
	    	return;
	    int n = str.length();
	    if (n == 0) 
	    	perms.add(prefix);
	    else 
	    	for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), perms, max);
	}
	
	
	private static String permutationHmm(String prefix, String str, List<String> perms, int max) {
	   
	    int n = str.length();
	    if (n == 0) {
	    	System.out.println(max + " with perm " + prefix);
	    	max--;
	    	if(max == 0) {
	    		System.out.println("in here  " + prefix);
	    		return prefix;
	    	}
	    }
	    else 
	    	for (int i = 0; i < n; i++) {
	            String res = permutationHmm(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), perms, max);
	            if(res != "") {
	            	System.out.println("Found:? " + res);
	            	return res;
	            }
	    	}
	    return "";
	}

	
}
