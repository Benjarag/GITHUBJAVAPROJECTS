package Vika5;


import java.util.Arrays;

public class SiggSement_B {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        // reading inputs, bags quantity, hole size and sizes of the bags
        int N = io.getInt();
        long K = io.getLong();
        long[] size_bag_arr = new long[N];
        for (int i = 0; i < N; i++) {
            size_bag_arr[i] = io.getLong();
        }

        processBags(N, K, size_bag_arr, io);

        io.flush();

        io.close();
    }

    private static void processBags(int N, long K, long[] size_bag_arr, Kattio io) {
        Arrays.sort(size_bag_arr);

        int left = 0;
        int right = N - 1;

        boolean HasBeenFound = false;
        while (left < right) {
            long sum = size_bag_arr[left] + size_bag_arr[right];
            if (sum == K) {
                io.println(size_bag_arr[left] + " " + size_bag_arr[right]);
                HasBeenFound = true;
                break;
            } else if (sum < K) {
                left++;
            } else {
                right--;
            }
        }
        if (!HasBeenFound) {
            io.println("Neibb");
        }
    }
}

