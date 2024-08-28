package Vika2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class GuessTheNumber_B {
    public static void main(String[] args) {
        int lo = 1, hi = 1000;
        int attemps = 0;
        while (lo <= hi && attemps < 10)
        {
            int  mid = lo + (hi - lo) / 2;
            StdOut.println(mid);
            attemps++;

            String correct_number_clue = StdIn.readString();
            
            if (correct_number_clue.equals("lower")) hi = mid - 1;

            else if (correct_number_clue.equals("higher")) lo = mid + 1;

            else if (correct_number_clue.equals("correct")) break;
            else break;
                
        }
    }
}
