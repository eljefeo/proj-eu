package ProjEuProblems;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import ProjEuUtil.Util;

import java.util.LinkedHashMap;

public class ProblemTester {
	
	

	
	private static final String superSecretKey = Util.getSecretKeyFromFile();

	//public static void main(String[] args) {
	@Test
	void testAllProblems() {
		System.out.println("I am going to run all problems...");
		List<Problem> problems = new ArrayList<Problem>();
		EncryptStuff encryptStuff = new EncryptStuff();
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
		problems.add(new Problem73());
		problems.add(new Problem74());
		problems.add(new Problem75());
		problems.add(new Problem76());
		problems.add(new Problem77());
		problems.add(new Problem78());
		problems.add(new Problem79());
		problems.add(new Problem80());
		problems.add(new Problem81());
		problems.add(new Problem82());
		
		System.out.println("Have this many problems : " + problems.size());
		Map<Integer, String> answers = AnswersToProblems.getAnswersEncrypted();
		Map<Integer,Double> times = new HashMap<Integer,Double>();
		List<Integer> longProblems = new ArrayList<Integer>();
		List<Integer> incorrectAnswers = new ArrayList<Integer>();
		

		for(int i = 0; i < problems.size(); i++) {
			System.out.println("\n\n*****----... Problem " + (i+1) + " ...----*****\n");
			String expectedAnswer = encryptStuff.decrypt(answers.get(i+1), superSecretKey);
			long startT = System.nanoTime();
			Problem p = problems.get(i);
			String res = p.runProblem();
			long endT = System.nanoTime();
			double time = (double) (endT - startT) / 1000000000;
			times.put(p.getId(), time);
			//System.out.println("\ngot answer from the thing : " + res);
			
			System.out.println("\nComparing " + res + " to expected answer: " + expectedAnswer);
			if(!res.equals(expectedAnswer)) {
				assertEquals(res.equals(expectedAnswer), true);
				incorrectAnswers.add(p.getId());
			} 
			
			if(time > 1) {
				longProblems.add(p.getId());
			}
		}
		
		times = sortByValue(times);

		for(Integer id : times.keySet()) {
			System.out.printf("Problem " + id + " took %f seconds\n", times.get(id));
		}
		
		for(Integer i : longProblems) {
			System.out.println("\nProblem " + i + " took over 1 second ");
		}
		
		for(Integer i : incorrectAnswers) {
			System.out.println("Problem " + i + " had an incorrect answer ");
		}
		
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}

class ValueComparator implements Comparator<Integer> {

    Map<Integer, Double> base;
    public ValueComparator(Map<Integer, Double> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(Integer a, Integer b) {
    	System.out.println("Called compare for int " + a + " and  " + b);
    	if(a == null || b == null || base == null || base.get(b) == null) {
    		System.out.println("something is null....");
    		System.out.println("a " + a);
    		System.out.println("b " + b);
    		System.out.println("base " + base);
    		System.out.println("base.get(b)  " + base.get(b));
    		return -1;
    	} else {
    		System.out.println("everything was not null for once!!! ");
    	}
    		//
    	
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}