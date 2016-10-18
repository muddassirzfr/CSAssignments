 /**
   *  Name: Timothy Backus
   *  Course: CIS 201 - Computer Science I
   *  Section: 001
   *  Assignment: 6.2
   */

import java.util.*;

// This program accepts two integers < 10, the first integer less than
// than the second prints values in a square in this range
// in a square rotating the first value

public class A62 {

    public static void main (String [] args) {
        System.out.print("Enter two integers: ");
        Scanner input = new Scanner(System.in);
	int min = input.nextInt();
	int max = input.nextInt();
	printSquare(min, max);
    }

    // Draws the square
    // printSquare(minimun value, maximum value)
    public static void printSquare(int min, int max) {
      
	// Set size to the difference of the maximum and minimun
	// plus one
	int size = (max - min) + 1;
	
	// Row control. Loops size times, but starts at 0.
	for (int i = 0; i <= size - 1; i++) {
	  
	    // Column control. Loops size times, but starts at 0.
	    for (int j = 0; j <= size - 1; j++) {
	      
		// Print the result of this algorithm followed by a space:
		// > Add the current row with the current column
		// > Divide this by the size and take the remainder
		// > Add the minimum to this number
		System.out.print((((j + i) % size) + min) + " ");
	    }
	    System.out.println();
	}
    }
}