package Vika2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Beach_G {
    public static void main(String[] args) {
        int N = StdIn.readInt(); // plot of land
        int B = StdIn.readInt(); // Budget

        int[] arr = new int[N];
        // reading the elements of the array
        for (int i = 0; i < N; i++) {
            arr[i] = StdIn.readInt();
        }

        // starting by initializing variables except the right, (later)
        int left_pointer = 0;
        int current_sum = 0;
        int max_length = 0;

        for (int right_pointer = 0; right_pointer < arr.length; right_pointer++) {
            // try to add the cost
            current_sum += arr[right_pointer];

            // add one to left pointer if the current sum is over budget
            while (current_sum > B) {
                // minus the index at left pointer and move it one to the right 
                current_sum -= arr[left_pointer];
                left_pointer++;
            }
            // update max lenght if this sement is longer
            // Math.max just picks what is more of the two
            max_length = Math.max(max_length, right_pointer - left_pointer + 1);
        }
        StdOut.println(max_length);
        
    }    
}



