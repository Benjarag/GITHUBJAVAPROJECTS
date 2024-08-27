package Vika2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Toggi {
    public static void main(String[] args) {
        long c_seconds = StdIn.readLong();
        
        long n = binarySearch(c_seconds);
        
        StdOut.println(n); // 
        
    }
    
    private static long binarySearch(long c_seconds)
    {
        long lo = 0, hi = Long.MAX_VALUE; // now you can guess for every second, becuase we have MAX_VALUE
        long nearest_n = 0; 
        
        while (lo <= hi)
        {
            long mid = lo + (hi - lo) / 2;
            //                                 n*log10(n)/10^6
            double c_seconds_guess_time = (mid * Math.log10(mid)) / 1_000_000;
            
            if (c_seconds_guess_time <= c_seconds) {
                nearest_n = mid; // stores the nearest so far
                lo = mid + 1; // tries larger n
            }
            
            else {
                hi = mid - 1; // tries smaller n
            } 
        }
        return nearest_n; // returns n which meets the requirements of the c_seconds
    }
}
