import java.util.*;

public class InsertionSort implements Sorter {

    // field
    private int [] a;
    int moves = 0;
    int comparisons = 0;

    public InsertionSort (int [] a) {
	this.a = a;
    }


     // Rearranges the elements of a into sorted order using
     // the selection sort algorithm.
    public  void sort() {
        for (int i = 1; i < a.length; i++) {
            // find where to insert a[i] in the first i-1 sorted values
            // while shifting other values right to make space for a[i]
            moves++;
            int temp = a[i];
            int insertPosition = findPosition(temp, i);
            a[insertPosition] = temp;
            moves++;
	}
        System.out.println("Comparisons: " + comparisons +
                          " Data moves: " + moves);
    }
    
    // Parameters: value - to insert
    //             n - number of values in the sorted part of the array
    // returns position to insert value in the first n sorted values
    public int findPosition (int value, int n){
	for (int i = n-1; i >= 0; i--) {
            comparisons++;
            if (a[i] <= value) {
		return i+1;
	    }
            a[i+1] = a[i]; moves++;
	}
        return 0;
    }
}
