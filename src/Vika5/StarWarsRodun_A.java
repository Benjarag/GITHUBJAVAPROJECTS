package Vika5;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StarWarsRodun_A {
    public static void main(String[] args) {
        // lenght of the input in n 
        int n = StdIn.readInt();
        // read in the input numbers
        int[] arr = new int[n];
        // reading the elements of the array
        for (int i = 0; i < n; i++) {
            arr[i] = StdIn.readInt();
        }

        Arrays.sort(arr);

        for (int i = arr.length/3; i < 2*arr.length/3; i++) // second third
            StdOut.print(arr[i] + " ");
        for (int i = 0; i < arr.length/3; i++) // first third
            StdOut.print(arr[i] + " ");
        for (int i = 2*arr.length/3; i < arr.length; i++) // last third
            StdOut.print(arr[i] + " "); 
    }
}

