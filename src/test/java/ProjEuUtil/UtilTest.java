package ProjEuUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import ProjEuUtil.Util;

public class UtilTest {

	
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
