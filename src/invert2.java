import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class invert2 {
    public static void main(String[] args) {
        // Reading the first integer which represents the size of the array
        // int n = StdIn.readInt();
        int n = 200000;
        int[] A = new int[n];
        // Reading the elements of the array
        for (int i = 0; i < n; i++) {
            A[i] = i;
            // A[i] = StdIn.readInt();
        }
        StdRandom.shuffle(A);
        
        // Creating and filling array B

        Stopwatch stopwatch = new Stopwatch();

        int[] B = new int[n];
        for (int i=0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[j] == i) {
                    B[i] = j;
                }
            }
        }
        double time = stopwatch.elapsedTime();
        StdOut.println("n = "+n+ " Time spent "+time);
        // // Printing the elements of array B in a single line
        // for (int i=0; i < n; i++) {
        //     StdOut.print(B[i] + " ");
        // }
        // // Add a newline after all elements are printed
    }
}



// public class invert2 {
//     public static void main(String[] args) {
//         // Reading the first integer which represents the size of the array
//         int n = StdIn.readInt();
//         int[] A = new int[n];
//         // Reading the elements of the array
//         for (int i = 0; i < n; i++) {
//             A[i] = StdIn.readInt();
//         }
//         // Creating and filling array B
//         int[] B = new int[n];
//         for (int i=0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (A[j] == i) {
//                     B[i] = j;
//                 }
//             }
//         }
//         // Printing the elements of array B in a single line
//         for (int i=0; i < n; i++) {
//             StdOut.print(B[i] + " ");
//         }
//         // Add a newline after all elements are printed
//         StdOut.println();
//     }
// }