package Vika6;

import java.util.Arrays;

public class BirdsOnAWire_C {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        // reading inputs
        int l_length = io.getInt();
        int d_distance = io.getInt();
        int n_birds = io.getInt();

        if (n_birds > 0) {
            int[] arr_birds = new int[n_birds];
            for (int i = 0; i < n_birds; i++) {
                arr_birds[i] = (io.getInt() - 6);
            }
            Arrays.sort(arr_birds);
            int bird_place_count = 0;

            bird_place_count += findPlaces(d_distance, arr_birds[0] - d_distance); // before first
            if (n_birds > 1) {
                for (int i = 1; i < n_birds; i++) {
                    int space_between_birds = arr_birds[i] - arr_birds[i - 1] - 1; // cant count themselfes
                    bird_place_count += findPlaces(d_distance, space_between_birds - d_distance);
                }
            }
            bird_place_count += findPlaces(d_distance, (l_length - 12) - arr_birds[n_birds - 1] - d_distance); // from the last bird to the end of the allowed place

            io.print(bird_place_count);
        }
        else {
            io.print(findPlaces(d_distance, l_length-12));
        }

        io.flush();
        io.close();
    }

    private static int findPlaces(int d_distance, int l_length) {
        if (l_length > 0) {
            return ((l_length + d_distance)/d_distance);
        }
        return 0;
    }
}
