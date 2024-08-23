import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Prefix {
    public static void main(String[] args) {
        int n = 10;
        int[] A = new int[n];
        // Reading the elements of the array
        for (int i = 0; i < n; i++) {
            A[i] = i;
        }
        StdRandom.shuffle(A);
        for (int i = 0; i < n; i++) {
            StdOut.print(i + " ");
        }
        StdOut.println();
        for (int i = 0; i < n; i++) {
            StdOut.print(A[i] + " ");
        }
        StdOut.println();

        int[] B = new int[n];
        B[0] = A[0];
        // Reading the elements of the array
        for (int i = 1; i < n; i++) {
            B[i] = B[i-1] + A[i];
        }
        // Reikna A[x...y] = b[y] - B[x-1]
        for (;;) {
            int x = StdIn.readInt(), y = StdIn.readInt();
            StdOut.println("A["+x+":"+y+"] = "+ (B[y] - B[x-1]));
        }
    }
}