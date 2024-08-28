package Vika2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Beach_G {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        int B = StdIn.readInt();

        int[] arr = new int[N];
        // Reading the elements of the array
        for (int i = 0; i < N; i++) {
            arr[i] = StdIn.readInt();
        }

        // starting by initializing variables except the right
        int left_pointer = 0;
        int current_sum = 0;
        int max_length = 0;

        for (int right_pointer = 0; right_pointer < arr.length ; right_pointer++) {
            // try to add the cost
            current_sum += arr[right_pointer];

            // add one to left pointer if the current sum is over budget
            while (current_sum > B) {
                // minus now to get the most of the budget
                current_sum -= arr[right_pointer];
                left_pointer++;
            }
            // update max lenght if this sement is longer
            // Math.max just picks what is more of the two
            max_length = Math.max(max_length, right_pointer - left_pointer + 1);
        }
        StdOut.println(max_length);
        



    }    
}



// To solve the problem in Java, you can use a sliding window approach:

// 1. **Initialize Variables:** 
//    - Start by initializing two pointers: `left` and `right`, both set to 0. These pointers will represent the start and end of the current segment of plots.
//    - Also, initialize `current_sum` to 0, which will keep track of the total cost of the current segment.
//    - Finally, initialize a variable `max_length` to 0, which will store the maximum length of the segment that Maja can afford.

// 2. **Slide the Right Pointer:**
//    - Iterate through the array using the `right` pointer.
//    - Add the cost of the plot at the `right` pointer to `current_sum`.

// 3. **Check the Budget:**
//    - While `current_sum` exceeds Maja's budget, move the `left` pointer to the right (i.e., increment `left`) to shrink the current segment. Subtract the cost at the `left` pointer from `current_sum` each time you move the `left` pointer.

// 4. **Update the Maximum Length:**
//    - After adjusting the `left` pointer, check if the length of the current segment (`right - left + 1`) is greater than `max_length`. If it is, update `max_length`.

// 5. **Continue Moving the Right Pointer:** 
//    - Continue the process until the `right` pointer has iterated over all plots.

// 6. **Output the Result:** 
//    - After the loop ends, `max_length` will contain the length of the longest segment Maja can afford, and you can output this value.

// This approach efficiently finds the longest segment of adjacent plots that Maja can afford by dynamically adjusting the segment using the sliding window technique, ensuring that you consider all possible segments without having to check each one individually. This method works well within the problem's constraints.