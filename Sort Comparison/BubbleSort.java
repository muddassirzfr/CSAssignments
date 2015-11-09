import java.util.*;

public class BubbleSort implements Sorter {

    // field
    private int [] a;
    int comparisons = 0;
    long moves = 0;

    public BubbleSort (int [] a) {
	this.a = a;
    }


     // Rearranges the elements of a into sorted order using
     // the selection sort algorithm.
    public  void sort() {
        // i keeps track of last two positions we are bubbling out to
        for (int i = a.length -2 ; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                comparisons++;
		if ( a [j] > a[j+1] ){
		    moves += 3;
		    swap (j, j+1);
		}
	    }
	}
        System.out.println("Comparisons: " + comparisons +
                           " Data moves: " + moves);
    }
    
    // Swaps a[i] with a[j].
    public  void swap(int i, int j) {
           int temp = a[i];
           a[i] = a[j];
           a[j] = temp;
    }
}
