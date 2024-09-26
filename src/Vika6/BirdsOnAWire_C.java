package Vika6;

import java.util.Arrays;

public class BirdsOnAWire_C {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        // reading inputs
        int l_length = io.getInt();
        int d_distance = io.getInt();
        int n_birds = io.getInt();

        int[] arr_birds = new int[n_birds];
        for (int i = 0; i < n_birds; i++) {
            arr_birds[i] = io.getInt();
        }

        Arrays.sort(arr_birds);

        int bird_places = 0;


        if (n_birds == 0) {
            // if there are no birds on the wire
            if ((l_length - 12) >= 0) {
                bird_places = ((l_length - 12) / d_distance) + 1; // plus one to count also for the bird placed at the 6th cm
            }
        }
        else {
            // if there are birds on the wire
            // this finds how many bird places there are from the 6th cm to the first bird
            bird_places = (arr_birds[0] - 6) / d_distance;

            // this finds bird places between the birds
            for (int i = 1; i < n_birds; i++) {
                bird_places += (arr_birds[i] - arr_birds[i - 1]) / d_distance - 1; // minus 1 because we cant count the bird as a space
            }

            // this finds bird places from the last bird to the lenght - 6cm
            bird_places += (l_length - 6 - arr_birds[n_birds - 1]) / d_distance;
        }

        io.println(bird_places);
        io.flush();
        io.close();
    }
}
        