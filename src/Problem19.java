
public class Problem19 implements Problem { //Took 0.001820 seconds

	
	/*
	 * 
	 * You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
	 */
	
	public static void main(String[] args) {
		Problem p = new Problem19();
		p.runProblem();

	}
	
	//While the other problem below is a nice lucky cheesy way to get the right answer, it may not work in every scenario, but this code should..
	@Override
	public Object problem(){
		
		int numOfSundaysOnFirstOfMonth = 0;
		int dayOfWeek = 2;
		int yearstart = 1901;
		int yearend = 2000;
		for(int year = yearstart; year<=yearend; year++){
			for(int month=1; month<=12; month++){
				int numOfDays = Util.getNumOfDaysInMonth(month, year);
				for(int day=1; day<=numOfDays; day++){
					dayOfWeek++;
					if(dayOfWeek == 8){
						dayOfWeek = 1;
					}
					if(day==1 && dayOfWeek==1){
						numOfSundaysOnFirstOfMonth++;
					}
					System.out.println("Year: " + year + ", Month: " + month + ", " + "day of month: " + day + ", day of the week: " + dayOfWeek);
				}
			}
		}
		
		//System.out.println("Found: " + numOfSundaysOnFirstOfMonth);
		return numOfSundaysOnFirstOfMonth;
	}
	
	// This also gives the correct answer because of good 'ol statistics and logic, and a bit of luck:
	public Object problemLuckyCheesy(){
		/*
		 *  Assuming each day of the week has equal likelihood of falling on the first of the month...
		 *  then, since there are 1200 months in the twentieth century the answer should be 1200/7 days of the week
		 *  (as long as we are not off by more than a little we can probably round up just in case if need be)
		 */
		
		int howManyYears = 100;
		int monthsPerYear = 12;
		int daysPerWeek = 7;
		return howManyYears * monthsPerYear / daysPerWeek;
		
	}
	


}
