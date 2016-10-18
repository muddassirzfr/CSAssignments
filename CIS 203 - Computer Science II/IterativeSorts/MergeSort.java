/*
 * Name: Tim Backus
 * Course: CIS 203 - Computer Science II
 * Assignment: 9
 * Due: 4/25/14
 */

import java.util.Stack;

//===========================================================================
// This class performs a Mergesort on a passed array.
//===========================================================================

public class MergeSort implements Sorter {
	
   private int [] a;

    //-----------------------------------------------------------------------
    // Constructor
    // Parameter: data: The array to be sorted.
    // Postcondition: The MergeSort object will store the array.
    public MergeSort (int [] data) {
	a = data;
    }

    //-----------------------------------------------------------------------
    // Performs an iterative Mergesort.
    // Precondition: The MergeSort object must have been initialized.
    // Postcondition: The array will be sorted using Mergesort.
    public void sort ()  {
	Stack<Pair> stk = new Stack<Pair>();
	
	// Push the segments onto the stack.
	for (int i = a.length; i >= 1; i /= 2) {
	    stk.add(new Pair(0, i));
	}
	while(!stk.empty()) {
	    Pair popped = stk.pop();
	    
	    // If the stack is empty after a pop, the sort has completed.
	    if(stk.empty())
		break;
	    
	    // If the popped and next pair's first number are the same
	    if(popped.first == stk.peek().first) {
		    
		// Push the other half and sub-segments to the stack.
		stk.push(new Pair(popped.first + popped.n, 
				  stk.peek().n - popped.n));
		while(stk.peek().n > 1) {
		    stk.push(new Pair(popped.first + popped.n,
					(stk.peek().n / 2)));
		}
	    }
	    
	    // Merge the segments together.
	    if(stk.peek().n > 1)
		merge(stk.peek().first, popped.first - 
		      stk.peek().first, popped.n);
	}
    }
    
    //-----------------------------------------------------------------------
    // Merge the sorted halves
    // Precondition: data has at least n1 + n2 components starting at
    //    a[first]. The first  n1 elements (from a[first] to 
    //    a[first + n1 - 1] are sorted from smallest 
    //    to largest, and the last n2 (from a[first + n1] to 
    //    a[first + n1 + n2 - 1]) are also sorted from smallest to largest. 
    // Postcondition: Starting at a[first], n1 + n2 elements of data
    //    have been rearranged to be sorted from smallest to largest.
    private void merge(int first, int n1, int n2)  {

    	Integer[] temp = new Integer[n1 + n2];

    	int copied = 0;
    	int copied1 = 0;
    	int copied2 = 0; 

    	// Merge elements, copying from two halves of a to the
    	// temporary array.
    	while ((copied1 < n1) && (copied2 < n2)) {
	    if (a[first + copied1] < a[first + n1 + copied2]) { 
		temp[copied] = a[first + copied1];
		copied++;
		copied1++;
	    } else {
		temp[copied] = a[first + n1 + copied2];
		copied++;
		copied2++;
	    }
    	}

    	// Copy any remaining entries in the left and right subarrays.
    	while (copied1 < n1) {
	    temp[copied] = a[first + copied1];
	    copied++;
	    copied1++;
    	}
    	while (copied2 < n2) {
	    temp[copied] = a[first + n1 + copied2];
	    copied++;
	    copied2++;
    	}

    	// Copy from temp back to the real array.
    	for (int i = 0; i < n1+n2; i++)
	    a[first + i] = temp[i];
	}
}