package Vika6;

import java.util.Arrays;


public class ArmyStrength_A {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        // T number of battles
        int T = io.getInt();
        for (int i = 0; i < T; i++) {
            int N_G = io.getInt();
            int N_M = io.getInt(); // at most 10^5

            int[] arr_G = new int[N_G];
            for (int j = 0; j < N_G; j++) {
                arr_G[j] = io.getInt(); // at most 10^9
            }

            int[] arr_M = new int[N_M];
            for (int j = 0; j < N_M; j++) {
                arr_M[j] = io.getInt();
            }

            Arrays.sort(arr_G);
            Arrays.sort(arr_M);

            strongerArmy(arr_G, arr_M, io);

        }
        io.flush();
        io.close();
    }
        
        
    private static void strongerArmy(int[] arr_G, int[] arr_M, Kattio io) {
        int g = 0;
        int m = 0;
        while (g < arr_G.length && m < arr_M.length) {
            if (arr_G[g] < arr_M[m]) {
                g++;
            }
            else {
                m++;
            }
        }
        if (g >= arr_G.length) {
            io.println("MechaGodzilla");
        }
        else {
            io.println("Godzilla");
        }
    }
}
