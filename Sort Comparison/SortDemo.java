import java.util.*;
import java.io.*;

public class SortDemo {

    public static void main (String [] args) throws FileNotFoundException{
	char sort = args[0].toLowerCase().charAt(0);
        int n = Integer.parseInt(args[2]);
        char sortCase = args[1].toLowerCase().charAt(0);

        // construct array of size n
	int [] a = new int[n];
        // fill according to the sort case (best, worst, random)
        fill(a, sortCase);
 
        // get the correct sort
        Sorter sorter = getSort(sort, a);
        String sortName = getName (sort);

	//        System.out.println(Arrays.toString(a));
        System.out.println("Sort using " + sortName + " Sort");
        sorter.sort();
	//        System.out.println(Arrays.toString(a));
        check(a);
    }

    public static void fill(int [] a, char sortCase) 
                                 throws FileNotFoundException {
        int n = a.length;

        // this will be a random sort
        if (sortCase == 'r') {
            Scanner sc = new Scanner(new File("randomNumbers.dat"));
            for (int i = 0; i <n ; i++) 
		a[i] = sc.nextInt();
	}
        // this will be a best case sort (array is in order)
        else if (sortCase == 'b')
            for (int i = 0; i <n ; i++) 
                a[i] = i;
        // default to a worst case sort (array is reversed)
        else {
            System.out.println("Defaulting to worst case...");
            for (int i = 0; i <n ; i++) 
                a[i] = n-i;
	}
    }

    public static Sorter getSort(char sort, int[] a) {
        Sorter s;
        // this will be a selection sort
        if (sort == 's')
	    s = new SelectionSort(a);
	// this will be an insertion sort
        else if (sort == 'i')
	    s = new InsertionSort(a);
	// this will be a bubble sort
        else if (sort == 'b')
	    s = new BubbleSort(a);
	// this will be a merge sort
        else if (sort == 'm')
	    s = new MergeSort(a);
	// this will be a quick sort
        else if (sort == 'q')
	    s = new QuickSort(a);
        // else return null, bad choice
        else
	    s = null;
        return s;
    }

    public static String getName(char sort) {
        if (sort == 's')
	    return "Selection";
        if (sort == 'i')
	    return "Insertion";
        if (sort == 'b')
	    return "Bubble";
        if (sort == 'm')
	    return "Merge";
        if (sort == 'q')
	    return "Quick";
        return null;
    }

    public static void check(int [] a) {
        for (int i = 0; i < a.length-1; i++)
	    if (a[i] > a[i+1]) {
		System.out.println("NOT sorted...");
                return;
	    }
        System.out.println("sorted...");
    }
}
			   
