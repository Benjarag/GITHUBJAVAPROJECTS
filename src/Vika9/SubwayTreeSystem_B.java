package Vika9;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;



public class SubwayTreeSystem_B {
    public static void main(String[] args) {
        int iterations = StdIn.readInt(); // Read number of test scenarios
        StdIn.readLine(); // Consume the leftover newline character
    
        for (int i = 0; i < iterations; i++) {
            String input_A = StdIn.readLine(); // Read first input string
            String input_B = StdIn.readLine(); // Read second input string
    
            // Find checkpoints for both inputs
            int[] A_checkpoints = findCheckpoints(input_A);
            int[] B_checkpoints = findCheckpoints(input_B);
    
            // Compare the checkpoints and print result
            if (areSameCheckpoints(A_checkpoints, B_checkpoints)) {
                StdOut.println("same");
            } else {
                StdOut.println("different");
            }
        }
    }
    
    private static int[] findCheckpoints(String parts) {
        int checkpoint_indicator = 0;
        int current_char = -1;
        int[] checkpointArr = new int[parts.length()];
        int i = 0;
        for (char ch : parts.toCharArray()) {
            if (ch == '0') {
                if (current_char == 1) {
                    checkpointArr[i] = checkpoint_indicator;
                    i++;
                }
                checkpoint_indicator++;
                current_char = 0; 
            }
            else if (ch == '1') {
                if (current_char == 0) {
                    checkpointArr[i] = checkpoint_indicator;
                    i++;
                }
                checkpoint_indicator--;
                current_char = 1;            
            }
        }
        // Create a new array of the exact size needed and copy valid entries
        int[] trimmedArr = new int[i+1];
        System.arraycopy(checkpointArr, 0, trimmedArr, 0, i+1);
        
        return trimmedArr;
    }

    
    public static boolean areSameCheckpoints(int[] A, int[] B) {
        // // Print elements of array A
        // StdOut.print("A: ");
        // for (int i = 0; i < A.length; i++) {
        //     StdOut.print(A[i] + " ");
        // }
        // StdOut.println(); // New line for better formatting

        // // Print elements of array B
        // StdOut.print("B: ");
        // for (int i = 0; i < B.length; i++) {
        //     StdOut.print(B[i] + " ");
        // }
        // StdOut.println(); // New line for better formatting


        // Sort both arrays to compare their values and frequencies
        Arrays.sort(A);
        Arrays.sort(B);
            
        // Check if both sorted arrays are equal
        return Arrays.equals(A, B);
        
    }
}