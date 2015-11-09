/*
 * Name: Tim Backus
 * Course: CIS 203 - Computer Science II
 * Assignment: 6
 * Due: 3/14/14
 */

import java.io.*;
import java.util.*;

//===========================================================================
// This class performs a bin sort on a file of integers. The first two lines
// must be the maximum place values throughout all values, followed by the
// number of values to sort. The number of values to be sorted must equal the
// specified number of values in line two.
//===========================================================================

public class BinSort {
    
    private static byte maxDigits;
    private static int numberCount;
    private static Integer[] values;
    
    //-----------------------------------------------------------------------
    // Main method
    // Parameter: args: The user may specify a file to sort from at runtime.
    //                  If they do not, or enter more than one argument, the
    //                  program will prompt the user for a file name.
    // Throws: FileNotFoundException if the file entered is not found.
    
    public static void main (String[] args) throws FileNotFoundException {
	File f;
	
	// If the user doesn't pass a file name at runtime, prompt them.
	if(args.length != 1) {
	    System.out.print("Please enter a file to sort values from: ");
	    Scanner console = new Scanner(System.in);
	    f = new File (console.next());
	} else
	    f = new File (args[0]);
	
	// Attempt to read values from the file. If it is not formatted
	// correctly, don't bother sorting.
	if(getValues(f)) {
	    sort(values, maxDigits);
		
	// Print an error message informing the user of the correct format.
	} else {
	    System.out.println("An error occured while reading values.\n" +
				    "Please ensure the first two lines of " +
				    "the file are the maximum digits in any " +
				    "number, and the amount of values in " +
				    "the specified file, respectively.\nThe " +
				    "number of values in the data file also " +
				    "must match the value specified on " +
				    "line two.");
	}
    }
    
    //-----------------------------------------------------------------------
    // Prints each value in an array.
    // Parameter: a: The Integer array to print.
    
    private static void printArray(Integer[] a) {
	System.out.print("[");
	if(a.length > 0)
	    System.out.print(a[0]);
	for(int i = 1; i < a.length; i++)
	    System.out.print(", " + a[i]);
	System.out.println("]");
    }
    
    //-----------------------------------------------------------------------
    // Reads in values to be sorted from the specified file.
    // Parameter: f: The File object to read from.
    // Throws: FileNotFoundException if the file cannot be found.
    // Returns: True if the file is formatted correctly, false if not.
    
    private static boolean getValues(File f) throws FileNotFoundException {
	    Scanner fileScan = new Scanner(f);
	    
	    // If the first token is an integer
	    if(fileScan.hasNextInt()) {
		maxDigits = (byte)fileScan.nextInt();
		
		// If the second token is an integer
		if(fileScan.hasNextInt()) {
		    numberCount = fileScan.nextInt();
		    values = new Integer[numberCount];
			
		// Not an integer or EOF. Incorrect file format.
		} else
		    return false;
		    
	    // Not an integer or EOF. Incorrect file format.
	    } else
		return false;
	    
	    // Store the values to an array of Integers.
	    for (int i = 0; i < numberCount; i++) {
		if(fileScan.hasNextInt())
		    values[i] = fileScan.nextInt();
		
		// If the number of actual values is less than the 
		// specified, exit.
		else
		    return false;
	    }
	    
	    // If the number of actual values is greater than the
	    // specified, exit.
	    if(fileScan.hasNextInt())
		return false;
	    
	    return true;
    }
    
    //-----------------------------------------------------------------------
    // Sorts the values.
    // Parameters: a: The Integer array to sort.
    //             digits: The maximum number of digits.
    
    private static void sort(Integer[] a, byte digits) {
	    
	// For each place value, extended by 1
	for (int i = 0; i < digits + 1; i++) {
	    ArrayList<Integer>[] bin = 
		(ArrayList<Integer>[]) new ArrayList[10];
	    
	    // Initialize the sorting bins.
	    for (int j = 0; j < 10; j++)
		bin[j] = new ArrayList<Integer>();
	    
	    // Get each Nth digit and place its value into the
	    // cooresponding bin.
	    for (int j = 0; j < a.length; j++) {
		byte digit = (byte)((a[j] / Math.pow(10, i)) % 10);
		bin[digit].add(a[j]);
	    }
	    
	    // Add the contents of each bin to bin 0.
	    for (int j = 1; j < 10; j++)
		bin[0].addAll(bin[j]);
	    
	    // Set the values to the finished sorting iteration.
	    a = bin[0].toArray(new Integer[bin[0].size()]);
	}
	
	printArray(a);
    }
}