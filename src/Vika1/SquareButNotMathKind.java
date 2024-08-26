package Vika1;
import java.util.Scanner;

public class SquareButNotMathKind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        if (n == 1) {
            System.out.println("*");
        } else if (n == 2) {
            System.out.println("* *");
            System.out.println("* *");
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
                System.out.print("*");
                if (i < n - 1) {
                    System.out.print(" ");
                }
            }
        } else {
            // printing a row with asterisks only on the edges
            System.out.print("*");
            for (int i = 0; i < n - 2; i++) {
                System.out.print(" ");
                System.out.print(" ");
            }
            System.out.print(" *");
        }
        System.out.println(); // moving to the next line after printing the row
    }
}


