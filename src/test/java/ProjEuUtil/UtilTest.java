package ProjEuUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class UtilTest {
	
	@Test
	public void isPrimeTestSame() {
		
		int howMany = 1000;
		List<Integer> p1 = Util.getPrimesUnder(howMany);
		List<Integer> p2 = Util.getPrimesUnderWithSqrt(howMany);
		
		assertTrue(p1.size() == p2.size());
		
		for(int i = 0; i < p1.size(); i++) {
			//System.out.println("Checking " + p1.get(i) + " vs " + p2.get(i));
			assertTrue(p1.get(i).intValue() == p2.get(i).intValue());
		}
		//Util.compare2PrimeFunctionsTimings();
		
	}

	@Test
	public void testDuplicates() {
		//Something about an array of size n+1 that contains the numbers from 1 through n.
		// show that this array must have a duplicate number, return the duplicate.



		int howManyRuns = 100;
		int size = 10000;

		double timings = 0;
		for(int i = 0; i < howManyRuns; i++){
			//System.out.println("on run: " + i + "/" + howManyRuns);
			int[] arr = getArrNPlus1(size);

			long startT = System.nanoTime();

			/*
			dup1:
				Average:  0.000013 seconds (size 1000, 1000 times)
				Average:  0.000184 seconds (size 10000, 1000 times)
				Average:  0.001630 seconds (size 100000, 1000 times)
				Average:  0.042187 seconds (size 1000000, 1000 times)
				Average:  0.538733 seconds (size 10000000, 100 times)

			dup2:
				Average:  0.000001 seconds (size 1000, 1000 times)
				Average:  0.000010 seconds (size 10000, 1000 times)
				Average:  0.000106 seconds (size 100000, 1000 times)
				Average:  0.002191 seconds (size 1000000, 1000 times)
				Average:  0.028886 seconds (size 10000000, 100 times)
			 */

			int dup1 = dup1(arr); //Average:  0.000013 seconds (size 1000, 1000 times), Average:  0.000133 seconds (size 10000, 10000 times)
			//int dup2 = dup2(arr);   //Average:  0.000001 seconds (size 1000, 1000 times), Average:  0.000007 seconds, (size 10000, 10000 times)

			long endT = System.nanoTime();
			double time = (double) (endT - startT) / 1000000000;
			//System.out.printf("Took %f seconds\n", time);
			timings += time;
			//System.out.printf("Answer : %s\n", dup1);
		}
		timings = timings / howManyRuns;
		System.out.printf("Average:  %f seconds\n", timings);

	}


	public int dup1(int[] arr) {
		Set<Integer> s = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++){
			if(!s.add(arr[i])){
				return arr[i];
			}
		}
		return -1;
	}

	public int dup2(int[] arr) {
		int[] dd = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			if(dd[arr[i]] != 0){
				return arr[i];
			}
			dd[arr[i]] = 1;
		}
		return -1;
	}

	public int[] getArrNPlus1(int size){
		int[] arr = new int[size+1];
		arr[0] = size;
		for(int i = 1; i < size; i++){
			arr[i] = i;
		}
		arr[size] = new Random().nextInt(1,size);;
		arr = shuffleIntArray(arr);

		return arr;
	}

	public int[] shuffleIntArray(int[] arr){
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			int randomIndexToSwap = rand.nextInt(arr.length);
			int temp = arr[randomIndexToSwap];
			arr[randomIndexToSwap] = arr[i];
			arr[i] = temp;
		}

		return arr;
	}


	@Test
	public void testCombinations() {

		int numberOf1s = 3;
		int numberOf0s = 2;
		int[] nums = new int[]{1,1,1,0,0};
		int expectedSize = Util.getNChooseKSize(numberOf1s + numberOf0s, numberOf0s);
		int[][] combos = Util.getAllCombinationsInt(nums);

		Set<String> comst = new HashSet<>();
		for (int[] arr : combos) {
			String com = "";
			for(int i : arr)
				com += i;
			comst.add(com);
		}
		System.out.println("Found " + comst.size() + " things " + expectedSize);
		for(String s : comst){
			System.out.println(s);
		}

		assertTrue(comst.size() == expectedSize);
	}
	
	@Test
	public void isPrimeTest() {
		int[] primes = new int[] {2,3,5,7,11,13,17,19};
		
		List<Integer> ps = Util.getPrimesUnder(10000000);
		System.out.println("pp : " + ps.get(ps.size()-55));
		
		for(int p : primes) {
			
			assertTrue(Util.isPrime(p));
		}
		
		
		primes = new int[] {2,3,5,7,999983,12,13,17,9998971,987654321,19, 9999991};
		assertTrue(Util.isPrime(primes[0]));
		assertTrue(Util.isPrime(primes[1]));
		assertTrue(Util.isPrime(primes[2]));
		assertTrue(Util.isPrime(primes[3]));
		assertTrue(Util.isPrime(primes[4]));
		assertFalse(Util.isPrime(primes[5])); //12
		assertTrue(Util.isPrime(primes[6]));
		assertTrue(Util.isPrime(primes[7]));
		assertTrue(Util.isPrime(primes[8]));
		assertFalse(Util.isPrime(primes[9])); //987654321
		assertTrue(Util.isPrime(primes[10]));
		assertTrue(Util.isPrime(primes[11]));
	}
	
	@Test
	public void getPrimesUnderTest() {
		
		int under = 10000000; // ten million
		int primeCount = 664579 ;// there should be this many primes under ten million
		
		List<Integer> primes = Util.getPrimesUnder(under);
		
		assertEquals(primeCount, primes.size());
		for(int p : primes) {
			assertTrue(Util.isPrime(p));
		}
	}
}
