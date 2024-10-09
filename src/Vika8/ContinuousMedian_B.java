package Vika8;

import java.util.PriorityQueue;

public class ContinuousMedian_B {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        // Reading number of test cases
        int T = io.getInt(); 
        for (int i = 0; i < T; i++) {
            int N = io.getInt(); 
            // Max-Heap for the lower half
            PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
            // Min-Heap for the upper half
            PriorityQueue<Long> minHeap = new PriorityQueue<>();

            Long continuous_median_count = 0L;

            for (int j = 0; j < N; j++) {
                Long num = io.getLong();
                
                // Add the number to the max-heap
                maxHeap.add(num);
                
                // Balance the heaps if needed
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                } else if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                }

                // Ensure the max-heap can only have at most one more element than min-heap
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }

                // Calculate the median
                Long median;
                if (maxHeap.size() > minHeap.size()) { 
                    median = maxHeap.peek(); 
                } else { // if both heaps are equal in size
                    median = (maxHeap.peek() + minHeap.peek()) / 2;
                }

                continuous_median_count += median;
            }
            io.println(continuous_median_count);
        }
        io.flush();
        io.close();
    }
}

// The structure of numbers in the heaps is:
//       maxHeap <= minHeap

// Median calculation:
//     If maxHeap has more elements than minHeap, the median is the top of maxHeap.
//     If both heaps have the same number of elements, the median is the average of the tops of both heaps.
