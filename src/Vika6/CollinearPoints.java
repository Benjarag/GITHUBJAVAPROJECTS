package Vika6;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class CollinearPoints {

    // Helper class to represent a point
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Function to calculate the greatest common divisor (GCD) of two numbers
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Function to find the maximum number of collinear points
    public static int maxCollinearPoints(List<Point> points) {
        int maxPoints = 1; // At least 1 point is collinear with itself

        // Iterate through each point as a starting point
        for (int i = 0; i < points.size(); i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicates = 0;
            int verticals = 0;
            int localMax = 0;

            for (int j = i + 1; j < points.size(); j++) {
                int dx = points.get(j).x - points.get(i).x;
                int dy = points.get(j).y - points.get(i).y;

                // Check for duplicate points
                if (dx == 0 && dy == 0) {
                    duplicates++;
                } else if (dx == 0) {
                    // Handle vertical lines separately
                    verticals++;
                    localMax = Math.max(localMax, verticals);
                } else {
                    // Calculate slope and reduce it to the smallest ratio by using GCD
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;

                    // Create a unique key for each slope
                    String slope = dy + "/" + dx;
                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);

                    localMax = Math.max(localMax, slopeMap.get(slope));
                }
            }

            // Update the overall max count
            maxPoints = Math.max(maxPoints, localMax + duplicates + 1); // +1 for the base point itself
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while (true) {
            int n = io.getInt(); // Number of points in the test case
            if (n == 0) {
                break; // End of input
            }

            // Read all the points
            List<Point> points = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = io.getInt();
                int y = io.getInt();
                points.add(new Point(x, y));
            }

            // Find and print the maximum number of collinear points
            io.println(maxCollinearPoints(points));
        }

        io.flush();
        io.close();
    }
}
