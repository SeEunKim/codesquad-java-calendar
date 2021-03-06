package kimse.calendar;

import java.util.Scanner;

public class Prompt {

	/**
	 * 
	 * @param week 요일
	 * @return 0 ~ 6 ( 0 = Sunday, 7 = Saturday)
	 */
	public int parseDay(String week) {
		if (week.equals("SU")) {
			return 0;
		} else if (week.equals("MO")) {
			return 1;
		} else if (week.equals("TU")) {
			return 2;
		} else if (week.equals("WE")) {
			return 3;
		} else if (week.equals("TH")) {
			return 4;
		} else if (week.equals("FR")) {
			return 5;
		} else if (week.equals("SA")) {
			return 6;
		} else {
			return 0;
		}

	}

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;
		int year = 2018;

		while (true) {
			System.out.println("년도를 입력하세요. (exit : -1) ");
			System.out.println("YEAR > ");
			year = scanner.nextInt();
			if(year == -1) {
				break;
			}

			System.out.println("달을 입력하세요.");
			System.out.println("MONTH > ");
			month = scanner.nextInt();
			
			if (month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다. ");
				continue;
			}
 
			
			cal.printCalendar(year, month);
		}
		System.out.printf("Bye~");

//		cal.printSampleCalendar();
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
