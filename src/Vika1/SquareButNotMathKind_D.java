package Vika1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SquareButNotMathKind_D {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        
        if (n == 1) {
            StdOut.println("*");
        } else if (n == 2) {
            StdOut.println("* *");
            StdOut.println("* *");
        } else {
            // printing top row
            printRow(n, true);
            
            // printing middle rows
            for (int i = 0; i < n - 2; i++) {
                printRow(n, false);
            }
            
            // printing bottom row
            printRow(n, true);
        }
    }
    
    private static void printRow(int n, boolean isEdge) {
        if (isEdge) {
            // printing a row of asterisks separated by spaces
            for (int i = 0; i < n; i++) {
                StdOut.print("*");
                if (i < n - 1) {
                    StdOut.print(" ");
                }
            }
        } else {
            // printing a row with asterisks only on the edges
            StdOut.print("*");
            for (int i = 0; i < n - 2; i++) {
                StdOut.print("  ");
            }
            StdOut.print(" *");
        }
        StdOut.println(); // moving to the next line after printing the row
    }
}


