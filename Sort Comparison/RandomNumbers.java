import java.io.*;

public class RandomNumbers {
    public static void main (String [] args) throws FileNotFoundException {
	PrintStream ps = new PrintStream(new File("randomNumbers.dat"));
        for (int i = 0; i < 1000000; i++)
            ps.print((int)(Math.random()*1000) + " ");

    }
}
