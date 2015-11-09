 /**
   *  Name: Timothy Backus
   *  Course: CIS 201 - Computer Science I
   *  Section: 001
   *  Assignment: 7
   */

import java.util.Scanner;
 
//==============================================================
// This program calculates what day of the week a given
// date falls on. 
//
// NOTE: Linux's cal command displays 1/1/1 as a Saturday, and 
// 11 days are missing in the September of 1752. Therefore, there 
// will be discrepancies because of the calendar switch.
//==============================================================

public class DayOfWeek {
    
    //---------------------------------------------------------
    // Main Method
    //---------------------------------------------------------
    
    public static void main(String[] args) {
	
	// Initialize a scanner
	Scanner sc = new Scanner(System.in);
	
	// Prompt the user to enter the month, day, 
	// and the year, and set each entry to its
	// cooresponding variable.
	System.out.print("What is the month (1-12)? ");
	int month = sc.nextInt();
	System.out.print("What is the day (1-31)? ");
	int day = sc.nextInt();
	System.out.print("What is the year (e.g., 2007)? ");
	int year = sc.nextInt();
	
	// Get number of days that have passed in the previous
	// x - 1 years, where x is the current year.
	int daysPassed = (year - 1) * 365;
	
	// Add number of leap years to the accumulated days.
	daysPassed += (getLeapYears(year) - 1);
	
	// Add the number of days in the previous months.
	daysPassed += daysInCurrYear(month - 1, year);
	
	// Add the days left in the month.
	daysPassed += day;
	
	// Print which day of the week the date falls on.
	System.out.println("Your date falls on a " + 
				    getDayOfWeek(daysPassed));
    }
    
    //---------------------------------------------------------
    // Calculate leap years passed as of the given date
    // getLeapYears(year)
    //---------------------------------------------------------
    
    public static int getLeapYears(int y) {
	
	// Subtract one from the year to account for only
	// previous years.
	y -= 1;
	
	// Return count of years divisible by 4, not
	// divisible by 100, but divisible by 400.
	return y / 4 - y / 100 + y / 400;
    }
    
    //---------------------------------------------------------
    // Calculate day of week based on the accumulated days
    // getDayOfWeek(Days passed)
    //---------------------------------------------------------
    
    public static String getDayOfWeek(int dpassed) {
	
	// Divide by 7 and get the remainder.
	dpassed %= 7;
	
	// Returns the day of week based on the remainder.
	if(dpassed == 0) {
	    return "Monday";
	} else if(dpassed == 1) {
	    return "Tuesday";
	} else if(dpassed == 2) {
	    return "Wednesday";
	} else if(dpassed == 3) {
	    return "Thursday";
	} else if(dpassed == 4) {
	    return "Friday";
	} else if(dpassed == 5) {
	    return "Saturday";
	} else {
	    return "Sunday";
	}
    }
    
    //---------------------------------------------------------
    // Calculate the days passed for the current year
    // daysInCurrYear(Month - 1)
    //---------------------------------------------------------
    
    public static int daysInCurrYear(int mon, int y) {
	
	// Initialize the accumulating variable and
	// leap year flag.
	int daysPassed = 0;
	boolean ly = false;
	
	// If the month isn't January (no previous months)
	if (mon != 0) {
	    
	    // Detect a leap year for Febuary
	    if(isLeapYear(y)) {
		
		// Set leap year flag to true.
		ly = true;
	    }
	    
	    // For all previous months...
	    for (int i = mon; i >= 1; i--) {
		
		// add the days in the month to the
		// accumulating variable.
		daysPassed += daysInMonth(i, ly);
	    }
	    
	    // Return the number of days passed.
	    return daysPassed;
	    }
	    
	// If the month is January, return 0.
	else {
	    return 0;
	}
    }
    
    //---------------------------------------------------------
    // Detect Leap Year
    // isLeapYear(Year)
    //---------------------------------------------------------
    
    public static boolean isLeapYear(int y) {
	
	// Detect a leap year.
	// Divisible by 4, not divisible by 100, but
	// divisible by 400.
	if(y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) {
	//if(y % 4 == 0) {
	    
	    // Set leap year flag to true.
	    return true;
	}
	else {
	    return false;
	}
    }
    
    //---------------------------------------------------------
    // Calculate the days in a given month
    // daysInMonth(month, leap year?)
    //---------------------------------------------------------
    
    public static int daysInMonth(int mon, boolean ly) {
	
	// If the month is Febuary, return either 28 or 29, depending
	// on if it's a leap year.
	if (mon == 2) {
	    if(ly) {
		return 29;
	    } else {
		return 28;
	    }
	}
	
	// If the month is odd between January and July, return 31
	else if ((mon >= 1 && mon <= 7) && (mon % 2 == 1)) {
	    return 31;
	}
	
	// If the month is even between August and December, return 31
	else if ((mon >= 8 && mon <= 12) && (mon % 2 == 0)) {
	    return 31;
	}
	
	// If it's anything else, return 30 days.
	else {
	    return 30;
	}
    }
}