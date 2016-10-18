/*
 * Name: Tim Backus
 * Course: CIS 203 - Computer Science II
 * Assignment: 8
 * Due: 3/21/14
 */

//=============================================================================
// This class simulates turning a combination lock with numbers 0 to 39. The
// lock can be turned either clockwise, or counterclockwise, and will be
// drawn after each turn with '+' characters to indicate that a number has
// been turned though.
//=============================================================================

public class CombinationLock {
    
    private ListNode current;	// Points to various nodes.
    
    //-------------------------------------------------------------------------
    // Default constructor
    // Postcondition: A CombinationLock object will have been created, and
    //                it will be drawn to the console.
    public CombinationLock() {
	
	// We must keep track of the first node to link it to the last.
    	ListNode front = new ListNode(0, null);
	current = front;
	
	// Create and link the other nodes together.
	for(int i = 1; i <= 39; i++) {
	    current.next = new ListNode(i, current);
	    current = current.next;
	}
	
	// Link the end of the chain to the front.
	front.prev = current;
	current.next = front;
	
	current = front;
	drawLock();
    }
    
    //-------------------------------------------------------------------------
    // Turns and draws the combination lock.
    // Parameters: dir: The direction to turn the lock.
    //                  	true = right (clockwise)
    //                  	false = left (counterclockwise)
    //             target: the number to turn the lock to.
    // Precondition: A CombinationLock object must have already been 
    //               constructed.
    // Throws: IllegalArgumentException if the user enters a value out 
    //         of range.
    public void turn(boolean dir, int target) {
	if(target < 0 || target > 39) {
	    throw new IllegalArgumentException("Please enter a " +
	                                        "number from 0 to 39.");
	}
	
	// Clear the turned-through characters in all nodes.
    	resetState();
	
	// If we turn through a node, set its data to '+'.
    	while(current.id != target) {
	    current.data = '+';
	    if(dir) {	// clockwise
		current = current.prev;
	    } else {	// counterclockwise
		current = current.next;
	    }
    	}
	drawLock();
    }

    //-------------------------------------------------------------------------
    // Resets the turned-through indicators.
    // Precondition: A CombinationLock object must have already been 
    //               constructed.
    // Postcondition: Resets all nodes with the character '-'.
    private void resetState() {
    	for (int i = 1; i <= 40; i++) {
	    current.data = '-';
	    current = current.next;
    	}
    }
    
    //-------------------------------------------------------------------------
    // Prints a representation of the lock to the console.
    // Precondition: A CombinationLock object must have already been 
    //               constructed.
    private void drawLock() {
    	
	// Pointers for alternating (in/de)crementing IDs.
	ListNode up = current;
	ListNode down = current;
	
	// The top of the lock
	System.out.println();
	drawSpaces(11);
	drawNumber(current.id);
	System.out.println();
	drawSpaces(12);
	System.out.println(current.data);
	
	// The upper slant of the lock
	for (int i = 1; i <= 9; i++) {
	    drawSpaces(-i + 12);
	    up = up.prev;
	    System.out.print(up.data);
	    drawSpaces(2 * i - 1);
	    down = down.next;
	    System.out.print(down.data);
	    System.out.println();
	}
	
	// The middle of the lock
	seekBy(-10);
	drawNumber(current.id);
	System.out.print(current.data);
	drawSpaces(19);
	seekBy(20);
	System.out.print(current.data);
	drawNumber(current.id);
	System.out.println();
	down = down.next;
	up = up.next;
	
	// The lower slant of the lock
	for(int i = 9; i >= 1; i--) {
	    drawSpaces(-i + 12);
	    up = up.prev;
	    System.out.print(up.data);
	    drawSpaces(2 * i - 1);
	    down = down.next;
	    System.out.print(down.data);
	    System.out.println();
	}
	
	// The bottom of the lock
	drawSpaces(12);
	seekBy(10);
	System.out.println(current.data);
	drawSpaces(11);
	drawNumber(current.id);
	System.out.println();
	seekBy(-20);
    }
    
    //-------------------------------------------------------------------------
    // Loops through the nodes, either backwards or forewards, a specified
    // number of times.
    // Parameter: num: The number of nodes to go through. A positive value
    //                 will seek forwards, and a negative value will seek
    //                 backwards.
    // Precondition: A CombinationLock object must have already been 
    //               constructed.
    private void seekBy(int num) {
    	for(int i = 1; i <= Math.abs(num); i++) {
	    if(num < 0)
		current = current.prev;
	    else
		current = current.next;
    	}
    }
    
    //=========================================================================
    // Helper Methods
    //=========================================================================
    
    //-------------------------------------------------------------------------
    // Prints a number to the console, spaced appropriately for two digits.
    // Parameter: num: The number to print.
    private static void drawNumber(int num) {
	if(num < 10)
	    System.out.print(" " + num);
	else
	    System.out.print(num);
    }
    
    //-------------------------------------------------------------------------
    // Prints a number of whitespaces inline.
    // Parameter: num: The number of whitespaces to print.
    private static void drawSpaces(int num) {
	for (int i = 1; i <= num; i++)
	    System.out.print(" ");
    }
    
    //=========================================================================
    // Inner Class - ListNode
    //=========================================================================
    
    private class ListNode {
	
	public int id;		// The ID of the node.
	public char data;	// The turned-through character.
	public ListNode next;	// The previous node in the chain.
	public ListNode prev;	// The next node in the chain.

	//---------------------------------------------------------------------
	// Default Constructor
	// Parameters: id: The ID of the ListNode.
	//             prev: A reference to the previous ListNode in the chain.
	// Postcondition: A ListNode will have been created with the entered
	//                parameters, with no next reference.
	public ListNode(int id, ListNode prev) {
	    this(id, prev, null);
	}
	
	//---------------------------------------------------------------------
	// Constructor
	// Parameters: id: The ID of the ListNode.
	//             prev: A reference to the previous ListNode in the chain.
	//             next: A reference to the next ListNode in the chain.
	// Postcondition: A ListNode will have been created with the entered
	//                parameters.
	public ListNode(int id, ListNode prev, ListNode next) {
	    this.data = '-';
	    this.id = id;
	    this.prev = prev; 
	    this.next = next;
	}
    }
}