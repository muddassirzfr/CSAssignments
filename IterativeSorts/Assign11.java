public class Assign11 {
    
    public static void main (String [] args) {

        int [] numbers = getRandomIntegerArray(20);
        print("The unsorted array: ");
        print(numbers);

        print("Sorting using merge sort...");
        Sorter sorter = new MergeSort(numbers);
        sorter.sort();
        print("The sorted array: ");
        print(numbers);

        numbers = getRandomIntegerArray(20);
        print("The unsorted array: ");
        print (numbers);

        print("Sorting using quick sort...");
        sorter = new QuickSort(numbers);
        sorter.sort();
        print("The sorted array: ");
        print(numbers);


    }

    public static int[] getRandomIntegerArray(int size) {
        int [] a =  new int[size];
        for (int i = 0; i < a.length; i++)
	    a[i] = (int)(Math.random() * 100);
        return a;
    }

    public static void print (int [] a) {
	for (int i = 0; i < a.length; i++)
	    System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void print (String s) {
        System.out.println(s);
    }


}
