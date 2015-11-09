import java.util.*;

public class SelectionSort implements Sorter {

    // field
    private int [] a;
    int moves = 0;
    int comparisons = 0;

    public SelectionSort (int [] a) {
	this.a = a;
    }


     // Rearranges the elements of a into sorted order using
     // the selection sort algorithm.
    public  void sort() {

        for (int i = 0; i < a.length - 1; i++) {
            // find index of smallest remaining value
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                comparisons++;
                if (a[j] < a[min]) {
                    min = j;
		}
	    }
            // swap smallest value its proper place, a[i]
            moves+=3;
            swap(i, min);
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
