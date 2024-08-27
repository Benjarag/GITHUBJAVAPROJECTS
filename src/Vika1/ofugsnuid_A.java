package Vika1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ofugsnuid_A {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] A = new int[n];
        // reading in the integers to the array
        for (int i=0; i < n; i++) {
            A[i] = StdIn.readInt();
        }
        // printing the elements of the array in reverse order
        for (int i=n-1; i >= 0; i--) {
            StdOut.print(A[i] + "\n");
        }
    }
}



// import java.util.Scanner;

// public class ofugsnuid2 {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // reading the integer n for the length of input
//         int n = scanner.nextInt();
//         int[] A = new int[n];

//         // reading in the integers to the array
//         for (int i = 0; i < n; i++) {
//             A[i] = scanner.nextInt();
//         }
//         scanner.close();

//         // printing the elements of the array in reverse order
//         for (int i = n - 1; i >= 0; i--) {
//             System.out.println(A[i]);
//         }
//     }
// }