 /**
   *  Name: Timothy Backus
   *  Course: CIS 201 - Computer Science I
   *  Section: 001
   *  Assignment: 6.1
   */

import java.util.*;

// This program accepts two integers as input
// and prints a grid with x rows and y columns,
// where x is the first number, and y is the
// second number entered.

public class A61 {

    public static void main (String [] args) {
        System.out.print("Enter two integers: ");
        Scanner input = new Scanner(System.in);
	int rows = input.nextInt();
	int cols = input.nextInt();
	printGrid(rows, cols);
    }

    // Method to print the grid
    // printGrid(rows, columns)
    public static void printGrid(int rows, int cols) {
      
	// Row control. Loop until <= row count
	for(int i = 1; i <= rows; i++) {
	  
	    // Column control. Loop until <= column count
	    for (int j = 1; j <= cols; j++) {
	      
		// Print row number + (rows x (column number - 1))
		// with a space to separate.
		System.out.print(i + (rows * (j - 1)) + " ");
	    }
	    
	    // Break the line
	    System.out.println();
	}
    }

}
