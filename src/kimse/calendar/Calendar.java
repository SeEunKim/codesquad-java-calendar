package kimse.calendar;

public class Calendar {

	private final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}
	}

	public void printCalendar(int year, int month) {
		System.out.printf("    <<%4d년 %3d월 >> \n", year, month);
		System.out.println(" SU MO TU WE TH FR SA ");
		System.out.println("---------------------");

		// get weekday automatically
		int weekday = getWeekday(year, month, 1);
		
		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = getMaxDaysOfMonth(year, month);

		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;

		// print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		// print from second line to last
	
		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

	private int getWeekday(int year, int month, int day) {
		// 1970년 1월 1일 목요일 기준점
		int syear = 1970;

		final int STANDARD_WEEKDAY = 3; //1970/Jan/1st = Thursday
		
		int count = 0;
		
		for(int i = syear; i < year; i++ ) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
//		System.out.println(count);
		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		
		
//		System.out.println(count);
		
		return weekday;
	}
	
	// simple test code here
	public static void main(String[] args) {
		Calendar cal = new Calendar();
		System.out.println(cal.getWeekday(1970, 1, 1) == 3);
//		System.out.println(cal.getWeekday(1970, 2, 1) == 31);
//		System.out.println(cal.getWeekday(1970, 3, 1) == 31 + 28);
		System.out.println(cal.getWeekday(1971, 1, 1) == 4);
		System.out.println(cal.getWeekday(2018, 8, 28));
		
	}
}
