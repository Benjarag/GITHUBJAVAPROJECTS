package Vika8;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KnigsOfTheForest_A {
    static class Moose {
        int year;
        int strength;

        Moose(int year, int strength) {
            this.year = year;
            this.strength = strength;
        }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        // reading inputs
        int k_2011 = io.getInt(); // number of moose in 2011, the starting year
        int n_years = io.getInt(); // number of years
        // Karl-Algtav, inputs
        int y_karl_year = io.getInt();
        int p_karl_strength = io.getInt();
        // number of other moose excluding Karl
        int otherMooseCount = n_years + k_2011 - 2;
        Moose[] moosePool = new Moose[otherMooseCount + 1]; // +1 for Karl
        // reading other moose
        for (int i = 0; i < otherMooseCount; i++) {
            int year = io.getInt();
            int strength = io.getInt();
            moosePool[i] = new Moose(year, strength);
        }
        // Karl's moose added also
        moosePool[otherMooseCount] = new Moose(y_karl_year, p_karl_strength);
        // sorting moose by year of entry
        Arrays.sort(moosePool, (a, b) -> Integer.compare(a.year, b.year));
        
        // priority queue to determine the winning contender by strength
        PriorityQueue<Moose> contenders = new PriorityQueue<>((a, b) -> Integer.compare(b.strength, a.strength));
        // tracking the year Karl wins
        int karlWinYear = -1;
        // index for the sorted moose pool
        int mooseIndex = 0;

        // looping through all years
        for (int year = 2011; year < 2011 + n_years; year++) {
            // adding only moose that entered this year to the contenders priority queue
            while (mooseIndex < moosePool.length && moosePool[mooseIndex].year == year) {
                contenders.offer(moosePool[mooseIndex]);
                mooseIndex++;
            }
            // check if any contenders
            if (!contenders.isEmpty()) {
                // gettinig the strongest moose, from contenders
                Moose winner = contenders.poll();
                // checking if the winner is Karl
                if (winner.year == y_karl_year && winner.strength == p_karl_strength) {
                    karlWinYear = year;
                    break; // Karl wins, exit
                }
                // we automatically remove the winner, with poll()
            }
        }
        // result output
        if (karlWinYear != -1) {
            io.println(karlWinYear);
        } else {
            io.println("unknown");
        }
        io.close();
    }
}