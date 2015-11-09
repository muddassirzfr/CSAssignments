public class QuickSort implements Sorter {

    // field
    private int [] a;
    int comps = 0;
    int moves = 0;

    public QuickSort (int [] a) {
	this.a = a;
    }


     // Rearranges the elements of a into sorted order using
     // the mergesort algorithm.
    public  void sort() {
	quickSort(0, a.length);
        System.out.println("Comparisons: " + comps +
                           " Data moves: " + moves);
    }
    
    // Parameters: first - first position to start sorting at
    //             n - number of values to sort starting from "first"
    public void quickSort(int first, int n) {
        // if we are sorting one or fewer places, it's sorted!!!!
        comps++;
        if (n <= 1) 
	    return;

        // partition the n items around the item in a[first] (the pivot)
        // and return where a[first] is now located
        int pivotIndex = partition(first, n);
 
        // get the size of the pieces on either side of the pivot
        int n1 = pivotIndex - first;
        int n2 = n - n1 - 1;

        // and quicksort the two pieces on either side of the pivot
        quickSort(first, n1);
        quickSort(pivotIndex+1, n2);
    }

    // Parameters: first - first position  in the position (also the pivot)
    //             n - number of values to partition
    // Postcondition: a[first]-a[pivotIndex-1] <= a[pivotIndex] 
    //                a[pivotIndex] < a[pivotIndex+1]-a[first + n]
   private  int partition(int first, int n)  {
       int pivotIndex = first;
       int last = first + n - 1;
       int pivotValue = a[first++];
       while (first <= last) {
	   while (first <= last && a[first] <= pivotValue) {
                first++;
                comps+=2;
	   }
           comps+=2;
	   while (last >= first && a[last] > pivotValue) {
               last--;
                comps+=2;
	   }
           comps+=2;
           if (first < last)  {
	       swap(first, last);
               moves += 3;
	   }
       }
       swap(pivotIndex, last);
       moves += 3;
       return last;
   }

    public  void swap(int i, int j) {
           int temp = a[i];
           a[i] = a[j];
           a[j] = temp;
    }

}
