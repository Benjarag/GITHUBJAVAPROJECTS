import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class New {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] A = new int[n];
        for (int i=0; i < n; i++)
            A[i] = StdIn.readInt();
        
        boolean[] hak = new boolean[n];
        for (int i=0; i < n; i++)
            hak[A[i]] = true;
        int vantar = -1;
        for (int i=0; i < n; i++)
            if (hak[i] == false)
                vantar = i;
            StdOut.println("Vantar: "+vantar);
            
            // n=5,       a[0] = 3, 2, 0, 4, 3
        

    }
}

// Önnur leið til þess að gera verkefnið án þess að nota algs4
// import java.util.Scanner;

// public class New {
//     public static void main(String[] args) {
//         Scanner scan = new Scanner(System.in);

//         // Reading the first integer which represents the size of the array
//         int n = scan.nextInt();
//         int[] A = new int[n];
//         // Reading the elements of the array
//         for (int i = 0; i < n; i++) {
//             A[i] = scan.nextInt();
//         }
//         // Close the scanner to avoid resource leak
//         scan.close();
//         // Initializing a boolean array to track which numbers are present
//         boolean[] hak = new boolean[n];
//         for (int i = 0; i < n; i++) {
//             hak[A[i]] = true;
//         }
//         // Finding the missing number (if any)
//         int vantar = -1;
//         for (int i = 0; i < n; i++) {
//             if (!hak[i]) {
//                 vantar = i;
//             }
//         }
//         // Printing the result
//         System.out.println("Vantar: " + vantar);
//     }
// }

// public class New {
//     public static void main(String[] args) {
//         Scanner scan = new Scanner(System.in);

//         // Reading the first integer which represents the size of the array
//         int n = scan.nextInt();
//         int[] A = new int[n];
//         // Reading the elements of the array
//         for (int i = 0; i < n; i++) {
//             A[i] = scan.nextInt();
//         }
//         // Close the scanner to avoid resource leak
//         scan.close();
//         // hækka teljaran
//         int[] count = new int[n];
//         for (int i = 0; i < n; i++) {
//             count[A[i]]++;
//         }
//         // finna algengasta teljarann
//         int maxi = 0;
//         for (int i = 0; i < n; i++) {
//             if (count[i] > count[maxi]) {
//                 maxi = i;
//             }
//         }
//         // Printing the result
//         System.out.println("Algengast: " + maxi + " kom fyrir " + count[maxi]);
//     }
// }