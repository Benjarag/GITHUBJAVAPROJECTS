package Vika2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Toggi {
    public static void main(String[] args) {
        long c_seconds = StdIn.readLong();
        // n*log10(n)/10^6
        
        long n = binarySearch(c_seconds);

        StdOut.println(n);

        // double result = (n * Math.log10(n)) / 1_000_000;

        

    }

    private static int binarySearch(long c_seconds)
    {
        long lo = 0, hi = 1_000_000_000;
        long mid_storage = 0;

        while (lo <= hi)
        {
            long mid = lo + (hi - lo) / 2;
            
            if (c_seconds < (mid * Math.log10(mid)) / 1_000_000) hi = mid -1;
            
            else if (c_seconds > (mid * Math.log10(mid)) / 1_000_000) lo = mid + 1;

            else return mid;
        }
        return -1;
    }
}
