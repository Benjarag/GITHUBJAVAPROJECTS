package Vika8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContinuousMedian {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        // Reading number of test cases
        int T = io.getInt();
        for (int i = 0; i < T; i++) {
            int N = io.getInt();
            List<Integer> sortedList = new ArrayList<>();  // Maintain a sorted list
            int continuousMedianSum = 0;

            for (int j = 0; j < N; j++) {
                int num = io.getInt();

                // Insert number into the sorted list
                insertSorted(sortedList, num);

                // Calculate the current median
                int median = calculateMedian(sortedList);
                continuousMedianSum += median;
            }
            io.println(continuousMedianSum);
        }
        io.close();
    }

    // Method to insert a number in a sorted manner
    private static void insertSorted(List<Integer> list, int num) {
        // Insert the number and keep the list sorted
        list.add(num);
        Collections.sort(list);  // This can be optimized with binary insertion
    }

    // Method to calculate the median from the sorted list
    private static int calculateMedian(List<Integer> list) {
        int size = list.size();
        if (size % 2 == 1) {
            return list.get(size / 2);  // Odd size, middle element is the median
        } else {
            // Even size, average of two middle elements
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2;
        }
    }
}
