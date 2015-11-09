/*
 * Timothy Backus
 * CIS 201 - Section 001
 * Assignment 3
*/

// This class prints out and sums
// 1/1, 1/2, 1/3 ... 1/N, where N is the loop count
// specified by the integer N.
public class Series {
  
    // Constant number of loop iterations
    public static final int N = 10;
  
    // Main method
    public static void main (String[] args) {
	
	// Double for storing the sum of fractions
	double sum = 0;
	
	// Loop N - 1 times (to compensate for the extra "+")
	for (int i = 1; i <= (N - 1); i++) {
	  
	      // Print "1/i + "
	      System.out.print("1/" + i + " + ");
	      
	      // Sum the result to the existing sum
	      sum = sum + (1.0 / i);
	}
	
	// Print "1/N" (compensation for extra "+")
	System.out.print("1/" + N);
	
	// Sum the result to the existing sum
	sum = sum + (1.0 / N);
	
	// Print the final sum
	System.out.println(" = " + sum);
    }
}
