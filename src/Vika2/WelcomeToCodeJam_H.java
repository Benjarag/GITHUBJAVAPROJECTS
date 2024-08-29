package Vika2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Warning this code is extremely hard to wrap your head around
// took me a couple of hours debugging and counting on paper 

public class WelcomeToCodeJam_H {
    // initialize the target string, "welcome to code jam", final means it will stay like 
    private static final String TARGET_S2 = "welcome to code jam";
    // we will use this MOD = 1000 to get the desired 4 digit result
    private static final int MOD = 10000;
 
    public static void main(String[] args) {
        int N = StdIn.readInt(); // get the input of N amount of lines
        StdIn.readLine();// Move to the next line after reading the integer

        // for loop for t starting at one and going to the N
        for (int t = 1; t <= N; t++) {
            String input_s1 = StdIn.readLine(); // reading the lines
            int result = countSubsequences(input_s1);
            // we use %d first to get the t number and then % 04d to get 4 zeros if needed and then d or result, n added also for newline
            StdOut.printf("Case #%d: %04d%n", t, result); //formatting to get the desired format e.g. 000 and Case #...
        }
    }

    private static int countSubsequences(String s1String) {
        // get the lenght of each string for the for loops
        int n = s1String.length();
        int m = TARGET_S2.length();

        // arr[j] will store the number of ways to form the characters of the target string and it will be stored in the last array e.g. arr[m]
        int[] arr = new int[m + 1]; // this is done to have one in the beginning to start the count
        arr[0] = 1; // here we let the first be one. this is also crucial if the string is empty

        // traverse forward in the inputted string
        for (int i = 0; i < n; i++) {
            // traverse backwards in target string
            for (int j = m - 1; j >= 0; j--) {
                // comparing the string chars and if both are same, then we store the initial arr[j+1] in the arr[j+1] plus the arr[j]
                // this ensures that we can count all the posibilities and store them as we go forward in completing all the chars  
                if (s1String.charAt(i) == TARGET_S2.charAt(j)) {
                    arr[j + 1] = (arr[j + 1] + arr[j]) % MOD; // % MOD here so it will never go above 9999 or 4 digits
                }
            }
        }
        return arr[m]; // this is the number of ways to form the full target, stored in arr[m] the last array slot
    }
}