// This program prompts for a dictionary file and then gives the user the
// opportunity to find anagrams of a word.

import java.io.*;
import java.util.*;
public class AnagramDemo {
    public static void main(String[] args) throws
                                       FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("What is the name of the dictionary file? ");
        String fileName = console.nextLine();
        Anagram a = new Anagram(fileName);
        System.out.print("word: ");
        while (console.hasNext()) {
            String word = console.next();
            System.out.println(a.find(word));
	    System.out.print("word: ");
	}
        System.out.println();
    }
}
