package Vika9;

import edu.princeton.cs.algs4.StdIn;

public class SubwayTreeSystem_V {
    public static void main(String[] args) {
        System.out.println("Enter the number of iterations:");
        int iterations = StdIn.readInt(); // Read the number of iterations
        for (int i = 0; i < iterations; i++) {
            System.out.println("Enter input A (string of 0s and 1s):");
            String input_A = StdIn.readLine(); // Read the first input string
            System.out.println("Enter input B (string of 0s and 1s):");
            String input_B = StdIn.readLine(); // Read the second input string

            // Find checkpoints for both inputs
            int[] A_checkpoints = findCheckpoints(input_A);
            System.out.println("A_checkpoints:");
            for (int j = 0; j < A_checkpoints.length; j++) {
                System.out.print(A_checkpoints[j] + " "); // Print each checkpoint for A
            }
            System.out.println(); // New line for better output formatting

            int[] B_checkpoints = findCheckpoints(input_B);
            System.out.println("B_checkpoints:");
            for (int j = 0; j < B_checkpoints.length; j++) {
                System.out.print(B_checkpoints[j] + " "); // Print each checkpoint for B
            }
            System.out.println(); // New line for better output formatting
        }
    }

    public static int[] findCheckpoints(String parts) {
        int checkpoint_indicator = 0; // Counter for '0's and '1's
        int current_char = -1; // No character at start
        int[] checkpointArr = new int[parts.length()]; // Max size of array
        int i = 0; // Index for checkpointArr

        for (char ch : parts.toCharArray()) {
            if (ch == '0') {
                if (current_char == 1) { // If transition from '1' to '0'
                    checkpointArr[i++] = checkpoint_indicator; // Store the indicator
                }
                checkpoint_indicator++; // Increment for '0'
                current_char = 0; // Update current character to '0'
            } else if (ch == '1') {
                if (current_char == 0) { // If transition from '0' to '1'
                    checkpointArr[i++] = checkpoint_indicator; // Store the indicator
                }
                checkpoint_indicator--; // Decrement for '1'
                current_char = 1; // Update current character to '1'
            }
        }

        // Trim the checkpoint array to the number of valid entries
        int[] trimmedArr = new int[i];
        System.arraycopy(checkpointArr, 0, trimmedArr, 0, i);
        return trimmedArr; // Return the trimmed array
    }
}
