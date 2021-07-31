import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProblemTester {

	public static void main(String[] args) {
		List<Problem> problems = new ArrayList<Problem>();
		
		problems.add(new Problem1());
		problems.add(new Problem2());
		problems.add(new Problem3());
		problems.add(new Problem4());
		problems.add(new Problem5());
		problems.add(new Problem6());
		problems.add(new Problem7());
		problems.add(new Problem8());
		problems.add(new Problem9());
		problems.add(new Problem10());
		problems.add(new Problem11());
		problems.add(new Problem12());
		problems.add(new Problem13());
		problems.add(new Problem14());
		problems.add(new Problem15());
		problems.add(new Problem16());
		problems.add(new Problem17());
		problems.add(new Problem18());
		problems.add(new Problem19());
		problems.add(new Problem20());
		problems.add(new Problem21());
		problems.add(new Problem22());
		problems.add(new Problem23());
		problems.add(new Problem24());
		problems.add(new Problem25());
		problems.add(new Problem26());
		problems.add(new Problem27());
		problems.add(new Problem28());
		problems.add(new Problem29());
		problems.add(new Problem30());
		problems.add(new Problem31());
		problems.add(new Problem32());
		problems.add(new Problem33());
		problems.add(new Problem34());
		problems.add(new Problem35());
		problems.add(new Problem36());
		problems.add(new Problem37());
		problems.add(new Problem38());
		problems.add(new Problem39());
		problems.add(new Problem40());
		problems.add(new Problem41());
		problems.add(new Problem42());
		problems.add(new Problem43());
		problems.add(new Problem44());
		problems.add(new Problem45());
		problems.add(new Problem46());
		problems.add(new Problem47());
		problems.add(new Problem48());
		problems.add(new Problem49());
		problems.add(new Problem50());
		problems.add(new Problem51());
		problems.add(new Problem52());
		problems.add(new Problem53());
		problems.add(new Problem54());
		problems.add(new Problem55());
		problems.add(new Problem56());
		problems.add(new Problem57());
		problems.add(new Problem58());
		problems.add(new Problem59());
		problems.add(new Problem60());
		problems.add(new Problem61());
		problems.add(new Problem62());
		problems.add(new Problem63());
		problems.add(new Problem64());
		problems.add(new Problem65());
		problems.add(new Problem66());
		problems.add(new Problem67());
		problems.add(new Problem68());
		problems.add(new Problem69());
		problems.add(new Problem70());
		problems.add(new Problem71());
		problems.add(new Problem72());

		
		System.out.println("Have this many problems : " + problems.size());
		Map<Integer, String> answers = AnswersDontCheckMeIn.getAnswers();
		
		//Problem p = problems.get(3);
		//p.runProblem();
		List<Integer> longProblems = new ArrayList<Integer>();
		
		for(int i = 0; i < problems.size(); i++) {
			System.out.println("\n\n*****----... Problem " + (i+1) + " ...----*****\n");
			long startT = System.nanoTime();
			Problem p = problems.get(i);
			p.runProblem();
			long endT = System.nanoTime();
			double time = (double) (endT - startT) / 1000000000;
			
			if(time > 1) {
				longProblems.add(i+1);
			}
		}
		
		
		for(Integer i : longProblems) {
			System.out.println("Problem " + i + " took over 1 second ");
		}
		
	}

}
