package Vika5;

import edu.princeton.cs.algs4.ST;


public class SiggiSement_B {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        // reading inputs
        int N = io.getInt();
        int K = io.getInt();
        int[] size_bag_arr = new int[N];
        for (int i = 0; i < N; i++) {
            size_bag_arr[i] = io.getInt();
        }

        findBags(N, K, size_bag_arr, io);

        io.flush();

        io.close();
    }

    private static void findBags(int N, int K, int[] size_bag_arr, Kattio io) {
        // using ST from algs4 to keep track of seen elements
        ST<Integer, Boolean> seen = new ST<>();

        boolean HasBeenFound = false;
        for (int i = 0; i < N; i++) {
            int current = size_bag_arr[i];
            int valid_pair = K - current;

            // checking if the valid pair to sum up to k is already in the set
            if (seen.contains(valid_pair)) {
                io.print(valid_pair + " " + current + "\n");
                HasBeenFound = true;
                break;
            }

            // adding the current element to the set of seen 
            seen.put(current, true);
        }

        if (!HasBeenFound) {
            io.println("Neibb");
        }
    }
}
