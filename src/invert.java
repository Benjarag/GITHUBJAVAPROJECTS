import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class invert {
    public static void main(String[] args) {
        // Reading the first integer which represents the size of the array
        int n = StdIn.readInt();
        int[] A = new int[n];
        // Reading the elements of the array
        for (int i = 0; i < n; i++) {
            A[i] = StdIn.readInt();
        }
        // Creating and filling array B
        int[] B = new int[n];
        for (int i=0; i < n; i++) {
            B[A[i]] = i;
        }
        // Printing the elements of array B in a single line
        for (int i=0; i < n; i++) {
            StdOut.print(B[i] + " ");
        }
        // Add a newline after all elements are printed
        StdOut.println();
    }
}

// public class invert {
//     public static void main(String[] args) {
//         // Reading the first integer which represents the size of the array
//         int n = 1000000;
//         int[] A = new int[n];
//         // Reading the elements of the array
//         for (int i = 0; i < n; i++) {
//             A[i] = i;
//         }
//         StdRandom.shuffle(A);
//         Stopwatch stopwatch = new Stopwatch();
//         // Creating and filling array B
//         int[] B = new int[n];
//         for (int i=0; i < n; i++) {
//             B[A[i]] = i;
//         }
//         double time = stopwatch.elapsedTime();
//         StdOut.println("n = "+ n + " Time spent " + time);
//     }
// }