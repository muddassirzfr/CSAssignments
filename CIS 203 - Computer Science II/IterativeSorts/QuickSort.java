/*
 * Name: Tim Backus
 * Course: CIS 203 - Computer Science II
 * Assignment: 9
 * Due: 4/25/14
 */

import java.util.Stack;

//===========================================================================
// This class performs a Quicksort on a passed array.
//===========================================================================

public class QuickSort implements Sorter {

    private int [] a;

    //-----------------------------------------------------------------------
    // Constructor
    // Parameter: data: The array to be sorted.
    // Postcondition: The QuickSort object will store the array.
    public QuickSort (int [] a) {
    	this.a = a;
    }

    //-----------------------------------------------------------------------
    // Performs an iterative Quicksort.
    // Precondition: The QuickSort object must have been initialized.
    // Postcondition: The array will be sorted using Quicksort.
    public void sort() {
    	Stack<Pair> stk = new Stack<Pair>();
    	
    	// Push the entire array as a partition.
    	stk.push(new Pair(0, a.length));
    	
    	while(!stk.empty()) {
	    Pair popped = stk.pop();
	    
	    // Get the starting position and size of the partition.
	    int index = popped.first;
	    int partSize = popped.n;
	    
	    // If the partition has more than one value
	    if(partSize > 1) {
		int p = partition(index, partSize);
		int leftSize = p - index;
		
		// Build the left and right partitions and push them
		// to the stack.
		Pair p1 = new Pair(index, leftSize); 
		Pair p2 = new Pair(p + 1, partSize - (leftSize + 1));
		stk.push(p1);
		stk.push(p2);
	    }
    	}
    }
    
    //-----------------------------------------------------------------------
    // Parameters: first - first position  in the position (also the pivot)
    //             n - number of values to partition
    // Postcondition: a[first]-a[pivotIndex-1] <= a[pivotIndex] 
    //                a[pivotIndex] < a[pivotIndex+1]-a[first + n]
    private int partition(int first, int n)  {
    	int pivotIndex = first;
    	int last = first + n - 1;
    	int pivotValue = a[first++];
    	while (first <= last) {
    		while (first <= last && a[first] <= pivotValue)
    			first++;
    		while (last >= first && a[last] > pivotValue)
    			last--;
    		if (first < last) 
    			swap(first, last);
    	}
    	swap(pivotIndex, last);
    	return last;
    }
    
    //-----------------------------------------------------------------------
    // Parameters: i - the first position to swap.
    //             j - the second position to swap.
    // Postcondition: the array at positions i and j will have been swapped.
	public  void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}