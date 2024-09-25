package Vika6;

import java.util.Arrays;


public class ColoringSocks_B {
    // 1.  int[S], are the amount of socks
    // 2.  int C, Washing machine storage space
    // 2.  int K, maximum color difference

    // 4.  D_i and D_j are socks in the S array
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        // reading inputs
        int S = io.getInt();
        int C = io.getInt();
        int K = io.getInt();
        int[] sock_arr = new int[S];
        for (int i = 0; i < S; i++) {
            sock_arr[i] = io.getInt();
        }
        Arrays.sort(sock_arr);
        io.print(findNumberOfWashingMachines(sock_arr, C, K, S));

        io.flush();
        io.close();
    }

    private static int findNumberOfWashingMachines(int[] sock_arr, int c_storage_space, int k_color_difference, int sock_count) {
        int number_of_machines = 0;
        int washed_socks = 0;
        while (washed_socks < sock_count) {
            number_of_machines++;
            int first_sock_in_machine = sock_arr[washed_socks];
            int socks_in_machine = 1;
            while ((washed_socks + socks_in_machine) < sock_count &&
                    socks_in_machine < c_storage_space &&
                    (sock_arr[washed_socks + socks_in_machine] - first_sock_in_machine) <= k_color_difference) {
                socks_in_machine++;
            }
            washed_socks += socks_in_machine;
        }
        return number_of_machines;
    }
}
