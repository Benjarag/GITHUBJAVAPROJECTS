package Vika2;

import java.util.stream.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Kaffi_J {
    public static void main(String[] args) {
        int n_colors = StdIn.readInt();
        int w_width = StdIn.readInt();
        
        
        int[] arr = new int[n_colors];
        for (int i = 0; i < n_colors; i++) {
            arr[i] = StdIn.readInt();
        }
        
        // n <= w <= 10^9
        if (w_width < n_colors) {
            return;
        }

        int sum_of_chairs = IntStream.of(arr).sum(); // calculating the total amount of chairs

        int height = (sum_of_chairs / w_width); //finding the most optimal height
        
        
        if (sum_of_chairs % w_width != 0) {
            height += 1; // Round up if there's a remainder
        }
        
         
        // now we should try to find the best space
        int untidiness = 0;
        for (int i = 0; i < n_colors; i++) {
            if (arr[i] % height != 0) {
                untidiness += height - (arr[i] % height); // finds the gap to the ceiling/height only if it needs to
            } 
        }
        StdOut.println(untidiness);
    
    }
}
