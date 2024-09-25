package Vika6;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Assignment4Exercise2SiggiSement {
    public static void main(String[] args) {
        // Example usage
        long[] array = {10, 20, 35, 50, 75, 80};
        long targetSum = 125;
        
        // Call the solve function
        solve(array, targetSum);        
    }
    public static void solve(long[] a, long k) {
        Arrays.sort(a);
        int i = 0, j = a.length-1;
        while(i < j) {
            if(a[i] + a[j] == k) {
                StdOut.println(a[i] + " " + a[j]);
                return;
            }
            else if (a[i] + a[j] > k) j--;
            else i++;
        }
        StdOut.println("Neibb");
    }
    public static void tripleSolve(long[] a, long k) {
        Arrays.sort(a); // Sort the array

        int n = a.length;
        for (int i = 0; i < n - 2; i++) {
            long target = k - a[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long currentSum = a[left] + a[right];
                if (currentSum == target) {
                    System.out.println("Found triplet: " + a[i] + ", " + a[left] + ", " + a[right]);
                    return; // Return after finding one triplet
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println("Neibb"); // No triplet found
    }

}
