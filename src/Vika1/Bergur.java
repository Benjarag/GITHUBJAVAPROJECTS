package Vika1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Bergur {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] arr = new int[n];
        // reading in the integers to the array
        for (int i=0; i < n; i++) {
            arr[i] = StdIn.readInt();
        }
        // 
        int sum = 0;
        int current_lowest_num = arr[n-1]; // start from the back
        
        // this for loop starts from the end and tries to always
        // sum the lowest number it can find going forward
        // this works the same way as the problem description
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < current_lowest_num) {
                current_lowest_num = arr[i];
            }
            sum += current_lowest_num;
        }
            
        // prints the sum when all the array is finished
        StdOut.println(sum);
        
    }
}

