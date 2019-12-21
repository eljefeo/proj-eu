import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {
	public static boolean isPrime(long num){
		if(num%2==0){
			return false;
		}
		for(long i = 3; i <= Math.sqrt(num); i+=2){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static BigInteger getTriangleNumberBigInt(int num){
		BigInteger total = BigInteger.valueOf(0);
		for(long i = 1; i <= num; i++){
			total = total.add(BigInteger.valueOf(i));
		}
		return total;
	}
	
	public static long getTriangleNumberLong(int num){
		long total = 0;
		for(long i = 1; i <= num; i++){
			total+=i;
		}
		return total;
	}
	
	public static int getTriangleNumberInt(int num){
		int total = 0;
		for(int i = 1; i <= num; i++){
			total+=i;
		}
		return total;
	}
	
	public static Set<BigInteger> getFactorsBigInt(BigInteger num){
		
		Set<BigInteger> factors = new HashSet<BigInteger>();
		BigInteger half = num.divide(BigInteger.valueOf(2));
		for(BigInteger i = new BigInteger("1"); i.compareTo(half) < 1; i = i.add(BigInteger.valueOf(1))){
			if(num.mod(i).compareTo(BigInteger.valueOf(0)) == 0){
				factors.add(i);
			}
		}
		factors.add(num);
		return factors;
	}
	
	public static Set<Long> getFactorsLong(Long num){
		
		Set<Long> factors = new HashSet<Long>();
		factors.add((long) 1);
		Long half = num/2;
		for(Long i = (long) 2; i <= half; i++){
			if(num%i == 0){
				factors.add(i);
			}
		}
		factors.add(num);
		return factors;
	}
	
	public static Set<Integer> getFactorsInt(int num){
		
		Set<Integer> factors = new HashSet<Integer>();
		factors.add(1);
		int half = num/2;
		for(int i = 2; i <= half; i++){
			if(num%i == 0){
				factors.add(i);
			}
		}
		factors.add(num);
		return factors;
	}
	
	public static int stringToInt(String numStr){
		return Integer.parseInt(numStr);
	}
	
	
	public static int findGreatestSumPath(int[][] allnums){
		System.out.println("At line " + 1);
		allnums[1][0] += allnums[0][0];
		allnums[1][1] += allnums[0][0];
		for(int i=2; i<allnums.length; i++){
			System.out.println("At line " + (i+1));
			for(int j = 0; j<allnums[i].length;j++){
				if(j==0){
					allnums[i][j] += allnums[i-1][j];
				} else if(j==allnums[i].length-1){
					allnums[i][j] += allnums[i-1][allnums[i-1].length-1];
				} else {
					allnums[i][j] += allnums[i-1][j-1] > allnums[i-1][j] 
							? allnums[i-1][j-1] 
									: allnums[i-1][j];
				}
				
			}
		}
		int greatestSum = 0;
		for(int i=0;i<allnums[allnums.length-1].length;i++){
			if(allnums[allnums.length-1][i] > greatestSum){
				greatestSum = allnums[allnums.length-1][i];
			}
		}

		return greatestSum;
	}
	
	public static int getNumOfDaysInMonth(int month, int year){
		if(month == 9 || month == 4 || month == 6 || month == 11){
			return 30;
		} else if(month == 2){
			return isLeapYear(year) ? 29 : 28;
		} else {
			return 31;
		}
	}
	
	public static boolean isLeapYear(int year){
		if(year%4==0){
			if(year%100==0){
				if(year%400==0){
					return true;
				} else{
					return false;
				}
			} else {
				return true;
			}
		} else{
			return false;
		}
	}

	public static Set<Integer> getProperDivisors(int num){
		
		Set<Integer> factors = new HashSet<Integer>();
		factors.add(1);
		int half = num/2;
		for(int i = 2; i <= half; i++){
			if(num%i == 0){
				factors.add(i);
			}
		}
		return factors;
	}
	
	public static int addAllIntegers(Set<Integer> nums){
		int result = 0;
		for(Integer num : nums){
			result+=num;
		}
		return result;
	}
	
	public static int getAmicableNumer(int num){
		//return 0 if no amicable number found
		 int sum1 = Util.addAllIntegers(Util.getProperDivisors(num));
		 int sum2 = Util.addAllIntegers(Util.getProperDivisors(sum1));
		 if(num==sum2 && num!=sum1){
			 return sum2;
		 } 
		 
		 return 0;
		 
	}
	
	public static boolean
	
	
}
