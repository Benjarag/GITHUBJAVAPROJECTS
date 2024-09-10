package Vika2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Kaffi {
    public static void main(String[] args) {
        int n = StdIn.readInt(), w = StdIn.readInt();
        int[] A = new int[n]; long sum=0;
        for (int i=0; i < n; i++) {
          A[i] = StdIn.readInt();
          sum += A[i];
        }

        // Find the height, by binary search
        long a= (sum/w)-1, b = sum;
        while (a < b-1) {
            long mid = a + (b-a)/2;
            // Compute the widths of the colors
            long width=0;
            for (int i=0; i < n; i++) {
                long cw = (A[i]+mid-1)/mid;
                width += cw;
            }
            if (width > w) 
              a = mid;
            else b = mid;
        }
        // Correct answer occurs then for height = b
//        StdOut.println("Sum="+sum+", a="+a+", b="+b+", n="+n);
        long disorg = 0;
        for (int i=0; i < n; i++) {
            disorg += (b - (A[i] % b)) % b;
//            StdOut.println("A[i]="+A[i]+ "mod: "+(A[i] % b));
        }
        StdOut.println(disorg);
    }
}

/*
 *      // Find the height, by binary search
        int a= (int) (sum/w), b = (int) (1+sum/n);
        // b = (int) (sum/(w-n+(w == n ? 1 : 0)));
        long a= (sum/w), b = sum;
        while (a < b-1) {
            int mid = a + (b-a)/2;
            // Compute the widths of the colors
            int width=0;
            for (int i=0; i < n; i++) {
                int cw = (A[i]+mid-1)/mid;
                width += cw;
            }
            if (width > w) 
              a = mid;
            else b = mid;
        }
        // Correct answer occurs then for height = b
//        StdOut.println("Sum="+sum+", a="+a+", b="+b+", n="+n);
        long disorg = 0;
        for (int i=0; i < n; i++) {
            disorg += (b - (A[i] % b)) % b;
//            StdOut.println("A[i]="+A[i]+ "mod: "+(A[i] % b));
        }
        StdOut.println(disorg);
    }
}
 */