package Vika5;

import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MinimumScalarProduct_C {

    public static void main(String[] args) {
        int T = StdIn.readInt();

        for (int testCase = 0; testCase < T; testCase++) {
            int n = StdIn.readInt();

            int[] vector1 = new int[n];
            int[] vector2 = new int[n];

            for (int j = 0; j < n; j++) {
                vector1[j] = StdIn.readInt();
            }

            for (int j = 0; j < n; j++) {
                vector2[j] = StdIn.readInt();
            }

            Arrays.sort(vector1);

            Arrays.sort(vector2);
            reverseArray(vector2);  // helper function to reverse

            long minimum_scalar = 0;
            for (int j = 0; j < n; j++) {
                minimum_scalar += (long) vector1[j] * (long) vector2[j];  // ensure long to avoid overflow
            }

            StdOut.println("Case #" + (testCase + 1) + ": " + minimum_scalar);
        }
    }

    private static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
