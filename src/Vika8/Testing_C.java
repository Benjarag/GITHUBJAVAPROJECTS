package Vika8;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.ST;

public class Testing_C {
    public static void main(String[] args) {
        // reading inputs
        Kattio io = new Kattio(System.in, System.out);

        int n_number_of_plotted_points = io.getInt();
        int[][] points = new int[n_number_of_plotted_points][2];

        for (int i = 0; i < n_number_of_plotted_points; i++) {
            points[i][0] = io.getInt();
            points[i][1] = io.getInt();
        }

        io.println(countPairs(n_number_of_plotted_points, points));
        io.close();
    }

    public static int countPairs(int n, int[][] points) {
        int counter = 0;
        ST<Long, Boolean> seenPoints = new ST<>(); // ST to store unique encoded points

        Bag<int[]> validOffsets = generateValidOffsets(2018); // find valid offsets

        for (int i = 0; i < n; i++) {
            int x = points[i][0]; // the x in the point
            int y = points[i][1]; // the y in the point

            // checking all the offsets and finding the valid pairs
            for (int[] offset : validOffsets) {
                long encodedTarget = encodePoint(x + offset[0], y + offset[1]);
                // check if the encoded point is in seenPoints
                if (seenPoints.contains(encodedTarget)) {
                    counter++;
                }
            }
            // adding current point to the ST
            seenPoints.put(encodePoint(x, y), true);
        }

        return counter; // returning the total count of pairs
    }

    public static Bag<int[]> generateValidOffsets(int length) {
        Bag<int[]> validOffsets = new Bag<>();
        int length_squared = length * length; // square of the distance
    
        // go over all possible dx values
        for (int dx = 0; dx <= length; dx++) {
            int dy_squared = length_squared - (dx * dx);
    
            // check if dy_squared is non-negative and a perfect square
            if (dy_squared >= 0) {
                int dy = (int) Math.sqrt(dy_squared);
                validOffsets.add(new int[]{dx, dy}); // adding the regular positive offset
                if (dy != 0) {
                    validOffsets.add(new int[]{dx, -dy}); // adding negative dy if dy is not zero
                }
                if (dx != 0) {
                    // adding the symmetric pair (negative dx)
                    validOffsets.add(new int[]{-dx, dy});
                    if (dy != 0) {
                        validOffsets.add(new int[]{-dx, -dy});
                    }
                }
            }
        }
        return validOffsets;
    }

    // encoding points into a Long
    public static long encodePoint(int x, int y) {
        return ((long) x << 32) | (y & 0xFFFFFFFFL); // using a Long to encode
    }
}
