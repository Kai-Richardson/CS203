

/*
 * Computes day of week of any date.
 *
 * @author Kai Richardson
 * @version 2019-11-02
 *
 * --------------------------
 * CS203
 * Enhancements: Negative years, pre-1753 years, daylight savings dates, months as numbers
 * Bugs: Will report holidays before they existed, such as Christmas on Dec. 25th, 80 BCE
 * Notes: Requires Java 8, which is present on all the engineering workstations
 * --------------------------
 */


import java.util.Scanner;
import java.time.*;
import java.time.chrono.*;
import java.time.temporal.*;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.*;

import de.jollyday.*;

public class Main {

	/**
	 * Reads month/day/year and tells day of week, holiday, leap year, and era
	 */
	public static void main(String[] args) throws DumbUser {
		//Initialize keyboard object
		Scanner keyboard = new Scanner(System.in);

		//Define object instance of LocalDate to store our day.
		LocalDate localDate;

		//Define month, year, and date object variables
		Month localMonth;
		int localYear;
		int localDay;

		//Define DayOfWeek holder obj
		DayOfWeek weekDay;

		//Define Era obj to hold the current era
		Era localEra;

		//Define string to hold our holidays
		String stringHolidays;


		// prompt user for year
		System.out.print("Please type a year (negative for BCE): ");
		try {
			localYear = keyboard.nextInt();
		}
		catch (Exception ex) { //if someone types some string or something
			throw new DumbUser("year", ex.getMessage());
		}

		//Basic year checking
		if (localYear == 0) {
			//Year 0 does not exist, throw exception
			throw new DumbUser("year", "Year 0 is not an actual year.");
		} else if (localYear < 0) {
			//Convert to positive number value for display
			localYear = localYear * -1;
		}

		//prompt user for the month, full name OR number
		keyboard.nextLine(); //Consume the \n, since we prompted for an int before
		System.out.print("Please type a month: ");
		final String keyboardMonthEntry = keyboard.nextLine();
		try {

			localMonth = Month.valueOf(keyboardMonthEntry.toUpperCase());
		} catch (Exception ex1) {
			try {
				localMonth = Month.of(Integer.valueOf(keyboardMonthEntry));
			}
			catch (Exception ex2) {
				throw new DumbUser("month", ex2.getMessage());
			}
		}

		//prompt user for the date, handle weird string entry
		System.out.print("Please type a day (1-31): ");
		try {
			localDay = keyboard.nextInt();
		}
		catch (Exception ex) {
			throw new DumbUser("day", ex.getMessage());
		}

		//Attempt to set our date holder to the given input
		try {
			localDate = LocalDate.of(localYear, localMonth.getValue(), localDay);
		} catch (Exception ex) {
			throw new DumbUser("date", ex.getMessage());
		}

		//Calculate the current Era given year
		localEra = localDate.getEra();

		//Gets holidays for the date we're checking
		stringHolidays = getHolidays(localDate);

		//Gets the day of the week
		weekDay = getWeekDay(localDate);

		//Display the final output
		System.out.println(localDate.getMonth() + " " + localDay + ", " + localYear + " " + localEra + " is a "
				+ weekDay.getDisplayName(TextStyle.FULL, Locale.US));

		if (!stringHolidays.equals("[]")) {
			System.out.println("It is also the holiday " + stringHolidays);
		}

		if (checkLeapYear(localDate)) {
			System.out.println("It is also a leap year!");
		}

		//Daylight savings end & start date handling
		System.out.print(checkDaySavings(localDate));

	}


	/** Method to check if the date is a leap year using java.time
	 *
	 * @param date - date we're checking at
	 * @return bool - is it a leap year or not
	 */
	private static boolean checkLeapYear(LocalDate date) {
		return date.isLeapYear();
	}

	/** Method to find the day of the week given a LocalDate
	 *
	 * @param date - date we're checking at
	 * @return DayOfWeek - what day it is
	 */
	private static DayOfWeek getWeekDay(LocalDate date) throws DumbUser {
		//Calculate the day of the week
		try {
			return date.getDayOfWeek();
		} catch (Exception ex) {
			throw new DumbUser("day of week", ex.getMessage());
		}
	}

	/** Method to find the holidays on a given date using de.JollyDay
	 *
	 * @param date - date we're checking at
	 * @return String - string of holidays on the given day
	 */
	private static String getHolidays(LocalDate date) {

		//init holiday manager to handle holidays
		HolidayManager manager = HolidayManager.getInstance(HolidayCalendar.UNITED_STATES);

		Set<Holiday> holidaySet = manager.getHolidays(date, date);

		return holidaySet.toString();
	}

	/** Method to check if the given date is the end or beginning of daylight savings.
	 *
	 * @param date - date we're checking at
	 * @return String - string message of what's going on then, empty if nothing
	 */
	private static String checkDaySavings(LocalDate date) {
		String savingsResult;

		if (date.getYear() < 1918) {
			return ""; //Daylight savings didn't exist before 1918 in the US
		}

		LocalDate firstSundayInNovember =
				YearMonth.of( date.getYear() , date.getMonth() )
						.atDay( 1 )
						.with( TemporalAdjusters.dayOfWeekInMonth( 1 , DayOfWeek.SUNDAY ) );

		LocalDate secondSundayInMarch =
				YearMonth.of( date.getYear() , date.getMonth() )
						.atDay( 1 )
						.with( TemporalAdjusters.dayOfWeekInMonth( 2 , DayOfWeek.SUNDAY ) );

		if (date.equals(firstSundayInNovember)) {
			savingsResult = "It's also the end of Daylight Savings Time in the US!";
		}
		else if (date.equals(secondSundayInMarch)) {
			savingsResult = "It's also the start of Daylight Savings Time in the US!";
		}
		else {
			return "";
		}

		return savingsResult;
	}

	/** DumbUser exception if the wrong type is inputted places where it doesn't belong */
	private static class DumbUser extends Exception {
		private DumbUser(String type, String error) {
			System.out.println("Illegal " + type + " given.");
			System.out.println("Specific Error: " + error);
			throw new RuntimeException();
		}
	}
}