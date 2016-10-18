/*
  Name: Timothy Backus
  Course: CIS 201 - Computer Science I
  Section: 001
  Assignment: 1
  Note: We just had to copy the source file.
*/

import java.util.*;

public class MemoryExerciser {

  public static final int MAX_SIZE = 10;

  public static void main(String[] args) {
  
    Scanner input = new Scanner(System.in);
    
    // prompt the user for the number of numbers
    System.out.print("How many integers (up to " + MAX_SIZE);
    System.out.print(") would you like to see? ");
    // get the number of numbers
    int size = input.nextInt();
    if (size > MAX_SIZE)
      size = MAX_SIZE;
    int[] numbers = new int[size];		// the list of integers
    // fill the list with 'size' random numbers.
    makeList(numbers);
    
    // display the numbers
    for(int i = 0; i < numbers.length; i++)
      System.out.println(numbers[i]);
    
    // prompt the user to hide the nubmers
    System.out.print("Type 1 when you are ready to hide the numbers: ");
    input.nextInt();
    // scroll the numbers off the terminal
    for (int i = 0; i < 50; i++)
      System.out.println();
    
    System.out.println("Score: " + numCorrect(numbers) + 
			" correct out of " + size + " numbers.");
  }
  
  // fills the list with 'size' unique random numbers
  public static void makeList(int[] list) {
    Random rand = new Random();
    int count = 0;
    while (count < list.length){
      int number = rand.nextInt(1000);
      if (!found (list, count, number)) {
	// add the number to the list
	list[count] = number;
	count++;
      }
    }
  }
    
  // conducts a search to find the value in the list so far
  // returns true if found
  public static boolean found(int[] a, int size, int value) {
    for (int i = 0; i < size; i++)
      if (a[i] == value)
	// key is found
	return true;
      
      // key is not found
      return false;
  }
  
  public static int numCorrect(int[] list) {
    Scanner input = new Scanner(System.in);
    int correct = 0;
    System.out.print("Enter the " + list.length + " numbers: ");
    for (int i = 0; i < list.length; i++) {
      int next = input.nextInt();
      if(list[i] == next)
	correct++;
    }
    return correct;
  }
}