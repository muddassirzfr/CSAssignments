 /**
   *  Name: Timothy Backus
   *  Course: CIS 201 - Computer Science I
   *  Section: 001
   *  Assignment: 8
   */

import java.util.Scanner;

//==============================================================
// This program validates an ID number based on a check digit,
// where the check digit is the last digit of the summation
// of digits 1-6 of the ID multiplied by their index (left to
// right, starting at 1).
//==============================================================

public class CheckDigit {
    
    //---------------------------------------------------------------
    // Main Method
    //---------------------------------------------------------------
    
    public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	// Prompt for the user to enter an ID
	System.out.print("Enter your student ID (7 digits): ");
	int input = sc.nextInt();
	System.out.println("ID entered = " + input);
	
	// Calculate the check digit
	int checkDigit = getCheckDigit(input);
	System.out.println("Check digit calculated = " + checkDigit);
	
	// Validate the ID
	validate(checkDigit, input);
    }
    
    
    //---------------------------------------------------------------
    // Returns the check digit
    // getCheckDigit(number entered by user);
    //---------------------------------------------------------------
    
    public static int getCheckDigit(int num) {
	
	// Accumulating variable for summation of digits
	int sum = 0;
	
	// Loop 6 times
	for (int i = 1; i <= 6; i++) {
	    
	    // Add the digit at index i multiplied by its index
	    // to the accumulating variable
	    sum += (i * getDigitByIndex(num, i));
	}
	
	// Get the last digit of the accumulating variable
	return sum % 10;
    }
    
    //---------------------------------------------------------------
    // Retruns a digit by its index (left to right, starting at 1)
    // getCheckDigit(number entered by user, index to get);
    //---------------------------------------------------------------
    
    public static int getDigitByIndex(int num, int index) {
	
	// Modular divide the number by 10^(-i+8) power. i is the passed
	// loop count. This will get the tail. Then integer divide by 
	// 10^(-i+7) power. This will get the head.
	return (num % (int)Math.pow(10, (-index + 8))) / 
			(int)Math.pow(10, (-index + 7));
    }
    
    //---------------------------------------------------------------
    // Retruns true if the last digit is equal to the check digit
    // validate(check digit, number entered by user);
    //---------------------------------------------------------------
    
    public static void validate(int chk, int num) {
	
	// If the last digit is equal to the check digit,
	if(getDigitByIndex(num, 7) == chk)
	{
	    
	    // it is a valid id
	    System.out.println("Valid ID");
	} else {
	    
	    // Otherwise, it isn't
	    System.out.println("Invalid ID");
	}
    }
}