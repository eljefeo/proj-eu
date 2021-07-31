import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem49 implements Problem {

	/*
	 The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

	There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
	
	What 12-digit number do you form by concatenating the three terms in this sequence?
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem49();
		p.runProblem();
	}
	
	public String problem(){
		int start = 1000;
		int end = 9999;
		for(int i = start; i < end; i++){
			List<String> ls = new ArrayList<String>();
			List<Integer> lsp = new ArrayList<Integer>();
			Util.makeAllPermutationsRecur("", ""+i, ls);
			Collections.sort(ls);
			for(int j = 0; j < ls.size(); j++){
				if(!ls.get(j).startsWith("0")){
					Integer a = Integer.parseInt(ls.get(j));
					if(Util.isPrime(a)){
						lsp.add(a);
					}
				}
				
			}
			String res = find3Nums(lsp);
			if(res != ""){
				return "" + res;
			}
		}
		return null;
	}
	
	
	private static String find3Nums(List<Integer> lsp){
		for(int i = 0; i < lsp.size()-1; i++){
			Integer a = lsp.get(i);
			if(a == 1487)
				return ""; // skip the previously known one...
			
			for(int j = i+1; j < lsp.size(); j++){	
				Integer b = lsp.get(j);
				int dif = b-a;
				if(dif == 0){
					continue; // some have multiples of the same digit, so permutations would be duplicates
				}
				Integer c = b + dif;
				if(lsp.contains(c)){
					String answer = a+""+b+""+c;
					System.out.println("Found a: "+a+" b:"+b+" c:" + c + " answer:"+answer);
					return "" + answer;
				}
			}
		} 
		return "";
	}

}
