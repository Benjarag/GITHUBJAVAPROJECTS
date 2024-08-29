package Vika2;

import java.util.stream.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestingMatrix {
    public static void main(String[] args) {
        int n_colors = StdIn.readInt(); // Number of colors
        int w_width = StdIn.readInt(); // Width of the storage room

        if (n_colors > w_width) {
            StdOut.println("Impossible"); // If there are more colors than width, it's impossible to fit them
            return;
        }

        int[] arr = new int[n_colors];
        for (int i = 0; i < n_colors; i++) {
            arr[i] = StdIn.readInt(); // Read the number of chairs for each color
        }

        // Total number of chairs
        int totalChairs = IntStream.of(arr).sum(); 

        // Calculate the minimum height needed
        int minHeight = (totalChairs + w_width - 1) / w_width; // Ceiling of totalChairs / w_width

        // Find the height of each stack such that it accommodates the maximum chairs of any single color
        int maxColorChairs = IntStream.of(arr).max().getAsInt();
        int height = Math.max(minHeight, maxColorChairs);

        // Calculate the untidiness
        int untidiness = 0;
        for (int i = 0; i < n_colors; i++) {
            // Calculate the number of full stacks and the gap for each color
            int fullStacks = (arr[i] + height - 1) / height; // Ceiling of arr[i] / height
            int usedWidth = fullStacks * height; // Total height space used
            int unusedWidth = usedWidth - arr[i]; // Gap for the color
            untidiness += unusedWidth;
        }

        StdOut.println(untidiness);
    }
}
