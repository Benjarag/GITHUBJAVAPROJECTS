package Vika2;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestingMatrix {
    public static void main(String[] args) {
        int N = StdIn.readInt();  // Fjöldi lóðanna
        int B = StdIn.readInt();  // Fjárhagsáætlun Maju

        int[] arr = new int[N];
        // Lesa inn kostnað við hverja lóð
        for (int i = 0; i < N; i++) {
            arr[i] = StdIn.readInt();
        }

        // Byrja með vísar og breytur
        int left_pointer = 0;
        int current_sum = 0;
        int max_length = 0;

        for (int right_pointer = 0; right_pointer < arr.length; right_pointer++) {
            // Bæta kostnaði við núverandi plot við current_sum
            current_sum += arr[right_pointer];

            // Færa left_pointer til hægri ef current_sum fer yfir fjárhag Maju
            while (current_sum > B) {
                current_sum -= arr[left_pointer];
                left_pointer++;
            }

            // Uppfæra max_length ef núverandi segment er lengri
            max_length = Math.max(max_length, right_pointer - left_pointer + 1);
        }

        StdOut.println(max_length);  // Prenta lengd lengsta segments sem Maja getur keypt
    }
}
